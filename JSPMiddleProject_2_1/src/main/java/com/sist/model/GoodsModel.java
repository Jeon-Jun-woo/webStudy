package com.sist.model;
//요청받아서 => 요청 처리후에 결과값을 request/session에 담아서 JSP로 보내주는 역할
/*
 *      request
 *  JSP => Model => DAO
 *      <=       <=
 *      request=> 결과값을 추가해서 전송
 *      			setAttribute()
 *  ================================> Call By Reference
 */
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.sist.vo.*;
import com.sist.dao.*;
public class GoodsModel {
	public void goodsListData(HttpServletRequest request)
	{
		// type , page
		String type=request.getParameter("type");
		if(type==null)
			type="1";
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		
		// 페이지 지정
		int curpage=Integer.parseInt(page);
		// 페이지에 해당되는 목록
		GoodsDAO dao=new GoodsDAO();
		List<GoodsVO> list=
				dao.goodsListData(curpage,Integer.parseInt(type));
		int totalpage=dao.goodsTotalPage(Integer.parseInt(type));
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		//JSP에서 출력할 데이터를 전송
		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("type", type);
	}
}
