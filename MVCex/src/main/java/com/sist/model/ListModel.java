package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
public class ListModel implements Model {

	@Override
	public String handleRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		// 1. 사용자의 요청값을 받는다
		String page=request.getParameter("page");
		   if(page==null)
			   page="1";
		   
		   // 페이지 지정 
		   int curpage=Integer.parseInt(page);
		   // 페이지에 해당되는 목록 
		   GoodsDAO dao=new GoodsDAO();
		   List<GoodsVO> list=
				 dao.goodsListData(curpage);
		   int totalpage=dao.goodsTotalPage();
		   
		   final int BLOCK=10;
		   int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		   
		   if(endPage>totalpage)
			   endPage=totalpage;
		   
		   // JSP에서 출력할 데이터를 전송 
		   request.setAttribute("list", list);
		   request.setAttribute("curpage", curpage);
		   request.setAttribute("totalpage", totalpage);
		   request.setAttribute("startPage", startPage);
		   request.setAttribute("endPage", endPage);
		return "goods/list.jsp";
	}

}