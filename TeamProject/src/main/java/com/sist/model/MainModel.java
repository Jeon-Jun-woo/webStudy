package com.sist.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.RequestMapping;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;

/*
 *    1. DispatcherServlet
 *       => WEB-INF => application에 있는 클래스명을 읽는다 
 *       => 대기 
 *       => init은 서버구동시 한번만 수행 
 *    2. 사용자 접속 : service()
 *       => 사용자가 URL전송 
 *          main/main.do 
 *       =>  전체 XML에 등록된 Model을 읽어서 
 *           => @RequestMapping을 찾아서 메소드 호출 
 */
public class MainModel {
  @RequestMapping("main/main.do") 
  public String main_main(HttpServletRequest request,
		  HttpServletResponse response)
  {
	  //2. DB연동 
	  GoodsDAO dao=new GoodsDAO();
	  List<GoodsVO> list= dao.goodsMainListData();
	  
	  request.setAttribute("list", list);
	  request.setAttribute("main_jsp", "../main/home.jsp");
	  return "../main/main.jsp";
  }

}