<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
		1.선택자 => Javascript
		2. 글자 관련
		3. margin / padding / border
		4. background
		5. position
			=>fixed
			=>relative
			=> 배치 => top/bottom/left/right
		6.overflow
		===================================
		CSS는 약간의 수정
		=> 퍼블리셔
		
		HTML / CSS => 화면 UI
		JavaScript => UI 제어
		java => 데이터 관리
				오라클 ==> 자바 ==> HTML/JavaScript
		오라클 => 데이터 저장 장소
		============= 통합(Spring)
		Spring-BOot <==> Front
		============ MSA
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{
	margin: 0px;
	padding: 0px;
}
body{
	width: 960px;
	margin: 0px auto;
	overflow: hidden;
}
#nav{
	width: 300px;
	float: left;
}
#section{
	width: 660px;
	float: right;
}
li {
	list-style:none;
}
@media screen and (max-width:768px){
	body{width:auto}
	#nav{width:auto;float:none}
	#section{width:auto;float:none}
}

</style>
</head>
<body>
	<div id="nav">
		<ul>
		  <li>홈</li>
		  <li>뉴스 1</li>
		  <li>뉴스 2</li>
		</ul>
	</div>
	<div id="section">
	 얄리양링얄앙ㄹ앙얄ㄹ라릴 얄라 양랑알양ㄹ앙얄앙ㅇ얄아알알알아라이알얼ㅇㄹㅇㄹㅇㄹㅇㄹㅇㄹㅇㄹㅇㄹㅇㄹ
	  ㅇㄹ ㅇㄹㅇㄹㅇㄹㅎㄷㅈㅎㄷㅈㅎㄷㅈ
	  ㅇㄹ ㅇㄹㅇㄹㅎㄷㅈㅎㅈㄷㅎㄷㅈㅎㄷㅈㅎㄷㅎㅎㅎㄷㅈㅎㄷㅈㅎㄷㅈ
	  ㅇㄹㅇㄹㄷㅈㅎㄷㅈㅎㄷㅈ
	  ㅇㄹㅇㅎㄷㅈㅎㄷㅈㅎㄷㅈㅎㅈㄷㅎㄷㅈ
	  ㄹㅇㄹㅎㄷㅈㅎㅈㅎㄷㄷㅈㅎㄷㅈ
	  ㅇㅈㅎㅈㄷㅎㄷㅈㅎㄷㅈㅎㄷㅈㅎㄷㅈㄷㅎㅈㅎㄷㅈ
	  ㅇㄹㅎㄷㅈㅎㄷㅈㅎㄷㅈㅎㄷㅈㅎㅎㄷㅈ
	  ㄹㄷㄹㄷㄹㄷㄹㅎㄷㅈㅎㄷㅈㄷㅈㅎㄷㅈ
	  ㄷㄹㄹㄷㄹㄷㅎㅈㄷㅎㄷㅈㅎㄷㅈㅎㄷㅈㅎㄷㅈㅎㄷㅈㅎㄷ
	  ㄹㄹㄷㅎㄷㅈㅎㄷㅈ
	  ㄹㄷㄷㅎㄷㅈㅎㅈㄷㅎㄷㅎㄷㅈㅎㄷㅈㅎㄷㅈㅎㄷㅈ
	  ㄹㄷㄹㅈㅎ
	  ㄷㅎㅈㄷㅎㅈㄷ
	  ㅎㄷㅎㅎㄷㅈㅎㄷㅈㄷㅈㅎㄷㅈ
	  ㄷ
	  ㄹㄷㅎㄷㅈㅎㄷㅈ
	  ㅎ
	  ㄷㅎ
	  ㄷㄹ
	  ㄷ
	  ㅎ
	  ㅈㅎ
	  ㄷ고
	  ㄷ고
	  
	</div>
</body>
</html>