<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modify.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="style.css">
	
	<script type="text/javascript"></script>
  </head>
  
  <body>
  
  <%@include file="header.jsp" %>
  <div id="big_cont">
  <div id="med_cont">
    <form action="UpdateType" method="post">
    	<span class="detail-label">原类型:</span><input type="text" name="oldType" value="${oldType.type }" readonly><br>
    	<span class="detail-label">新类型:</span><input type="text" name="newType" value=""><br>
    	<button type="submit">修改</button>
    	<span>${errorMessage}</span>
    </form>
    </div>
    </div>
    <%@ include file="footer.jsp" %>
  </body>
</html>
