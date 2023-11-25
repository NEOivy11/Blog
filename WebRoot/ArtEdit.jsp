<%@ page language="java" import="java.util.*" import="com.neo.entity.Type" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>文章编辑页面</title>
	<link rel="stylesheet" type="text/css" href="style.css">
    <script type="text/javascript" src="jquery.js"></script>

  </head>
  
  <body>
    <div id="big_cont">
        
        <%@include file="header.jsp" %>
            
        
		<span id="error" name="Error">
        </span>
        <div id="body_cont">
            <div id="left_cont"></div>

            <div id="med_cont">
    <h2 style="text-align:center">文章编辑</h2>
    <hr>
    <form id="form1" action="ArticleEdit" method="post" style="max-width: 400px; margin: 0 auto;">
        <% List<Type> typeList = (List<Type>) request.getAttribute("typeList"); %>

        <label for="typeId">类型：</label>
        <select name="typeId" id="typeId">
            <% for (Type type : typeList) { %>
            <option value="<%= type.getTypeId() %>"><%= type.getType() %></option>
            <% } %>
        </select>
        <br>

        <label for="artTitle">标题：</label>
        <input type="text" name="artTitle" id="artTitle" required>
        <br>

        <label for="content">内容：</label><br>
        <textarea name="content" id="content" rows="20" cols="60" required></textarea>
        <br>
		<br>
        <button id="regs" type="submit">确认</button>
    </form>
</div>


            <div id="right_cont"></div>

        </div>

        <%@ include file="footer.jsp" %>
    </div>
    
  </body>
</html>