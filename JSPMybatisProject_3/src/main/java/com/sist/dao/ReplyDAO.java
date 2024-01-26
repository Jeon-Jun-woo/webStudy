package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.vo.*;

import oracle.jdbc.OracleTypes;
public class ReplyDAO {
	private Connection conn;
	private CallableStatement cs;
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	private static ReplyDAO dao;
	// 드라이버 등록 => 한번만 수행
	public ReplyDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {}
	}
	// 연결
	public void getConnection() {
		try
		{
			conn=DriverManager.getConnection(URL,"hr","happy");
		}catch(Exception ex) {}
	}
	// 해제
	public void disConnection()
	{
		try
		{
			if(cs!=null)
				cs.close();
			if(conn!=null)
				conn.close();
		}catch(Exception ex) {}
	}
	//싱긑턴
	public static ReplyDAO newInstance()
	{
		if(dao==null)
			dao=new ReplyDAO();
		return dao;
	}
	//목록
	/*
	 * CREATE OR REPLACE PROCEDURE replyListData(
     pNo NUMBER,
     pType NUMBER,
     pResult OUT SYS_REFCURSOR
  )
  
  
  		
	 * 
	 *   no => 댓글 고유번호
	 *   type => 구분자 (명소: 1,자연 : 2 , 쇼핑: 3 , 맛집 : 4)
	 *   cno=> 각 고유번호
	 *   
	 *   <select id="replyListData" resultType="ReplyVO"
	 *    parameterMap="map"
	 *    statement="CALLABLE"
	 *    >
	 *    {CALL replyListData(?,?,?)}
	 *    </select>
	 *    
	 *    SQLInjection => 가끔
	 */
	public List<ReplyVO> replyListData(int type,int cno)
	{
		List<ReplyVO> list=new ArrayList<ReplyVO>();
		try
		{
			getConnection();
			String sql="{CALL replyListData(?,?,?)}";
			cs=conn.prepareCall(sql);
			cs.setInt(1, cno);
			cs.setInt(2, type);
			// 문자, 숫자, 커서 ==> OUT 변수일 경우에만 사용
			// OracleTypes.VARCHAR => String
			// OracleTypes.INTEGER => int
			// OracleTypes.CURSOR => ResultSet
			cs.registerOutParameter(3, OracleTypes.CURSOR);
			//실행
			cs.executeQuery();
			// 레지스터에 저장된 값 읽기
			ResultSet rs=(ResultSet)cs.getObject(3);
			//no,type,cno,id,name,msg,regdate
			while(rs.next())
			{
				ReplyVO vo=new ReplyVO();
				vo.setNo(rs.getInt(1));
				vo.setType(rs.getInt(2));
				vo.setCno(rs.getInt(3));
				vo.setId(rs.getString(4));
				vo.setName(rs.getString(5));
				vo.setMsg(rs.getString(6));
				vo.setDbday(rs.getString(7));
				list.add(vo);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			
		}
		finally
		{
			disConnection();
		}
		return list;
	}
/*
 * CREATE OR REPLACE PROCEDURE replyInsert(
     pType reply_all.type%type,
     pCno reply_all.cno%type,
     pId reply_all.id%type,
     pName reply_all.name%type,
     pMsg reply_all.msg%type
  )
 * 
 */
	public void replyInsert(ReplyVO vo)
	{
		try
		{
			getConnection();
			String sql="{CALL replyInsert(?,?,?,?,?)}";
			cs=conn.prepareCall(sql);
			cs.setInt(1, vo.getType());
			cs.setInt(2, vo.getCno());
			cs.setString(3, vo.getId());
			cs.setString(4,vo.getName());
			cs.setString(5, vo.getMsg());
			cs.executeQuery();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
	}
	public void replyUpdate(int no,String msg)
	{
		try
		{
			getConnection();
			String sql="{CALL replyUpdate(?,?)";
			cs=conn.prepareCall(sql);
			cs.setInt(1, no);
			cs.setString(2, msg);
			cs.executeQuery();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
	}
	public void replyDelete(int no)
	{
		try
		{
			getConnection();
			String sql="{CALL replyDelete(?)}";
			cs=conn.prepareCall(sql);
			cs.setInt(1, no);
			cs.executeQuery();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
	}
}
