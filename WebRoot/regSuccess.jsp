<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="style.css">

    <script type="text/javascript" src="jquery.js"></script>
  </head>
  
  <body>
  <%@include file="header.jsp" %>
  <div id="big_cont">
  <div id = "med_cont">
  
  	<h2 style="text-align:center">注册成功</h2>
  	注册成功<br>
  	<form>
   	 <span class="detail-label">用户名：</span>
   	 <input type="text" class="detail-value" value="${user.userName}" readonly><br>
   	 
   	 <span class="detail-label">全名：</span>
   	 <input type="text" class="detail-value" value="${user.fullName}" readonly><br>
   	 </form>
   	 
   </div>
   </div>
   	 <%@ include file="footer.jsp" %>
   	 
  </body>
</html>
