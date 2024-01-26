<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.invalidate(); //세션에 모든 기록을 지움
	response.sendRedirect("../main/main.jsp");
%>