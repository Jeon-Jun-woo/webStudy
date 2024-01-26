<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.bean.*"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%-- StudentBean bean=new StudentBean(): 메모리 할당 --%>
<jsp:useBean id="bean" class="com.sist.bean.StudentBean"></jsp:useBean>
	<jsp:setProperty name="bean" property="*"/>
<%--
	request.setCharacterEncoding("UTF-8");
	String hakbun=request.getParameter("hakbun");
	String name=request.getParameter("name");
	String kor=request.getParameter("kor");
	String eng=request.getParameter("eng");
	String math=request.getParameter("math");
	

	//데이터 묶기
	StudentBean sb=new StudentBean();
	sb.setHakbun(Integer.parseInt(hakbun));
	sb.setName(name);
	sb.setKor(Integer.parseInt(kor));
	sb.setEng(Integer.parseInt(eng));
	sb.setMath(Integer.parseInt(math));
	//오라클

 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학생 정보</h1>
	학번:<%=bean.getHakbun() %><br>
	학번:<jsp:getProperty name="baen" property="hakbun"/><br>
	이름:<%=bean.getName() %><br>
	국어:<%=bean.getKor() %><br>
	영어:<%=bean.getEng() %><br>
	수학:<%=bean.getMath() %>
</body>
</html>