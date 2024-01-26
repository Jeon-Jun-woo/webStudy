<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="model" class="com.sist.model.GoodsModel"/>
<%
   // Controller
   model.goodsListData(request);
   // request를 보내주고 출력에 필요한 데이터를 받아온다
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
	  <h1 class="text-center">특가상품</h1>
	  	<c:forEach var="vo" items="${list}">
		   <div class="col-md-3">
		    <div class="thumbnail">
		      <a href="#">
		        <img src="${vo.goods_poster}" title="${vo.goods_name }" style="width:100%">
		        <div class="caption">
		          <p>${vo.goods_price }</p>
		        </div>
		      </a>
		    </div>
		   </div>
  		</c:forEach>
	</div>
</body>
</html>