<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>用户详情</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <script type="text/javascript" src="jquery.js"></script>
</head>
<body>
    <div id="big_cont">
        <%@include file="header.jsp" %>
            
        

        <div id="body_cont">
            <div id="left_cont"></div>

            <div id="med_cont">
           
           <form action="UpdateUser" method="post">
           <h1 style="text-align:center">用户主页</h1>
           <h2 style="text-align:center">修改个人信息</h2>
           	
    		昵称:<input type="text" name="Nickname" value="${user.nickname}"><br>
    		
    		姓名:<input type="text" name="fullName" value="${user.fullName} "><br>
    		性别:<input type="text" name="sex" value="${user.sex}"><br>
    		出生日期:<input type="text" name="birthday" value="${user.birthday }"><br>
    		电话:<input type="text" name="phone" value="${user.phone}"><br>
    		邮箱:<input type="text" name="email" value="${user.email }"><br>
    		微信:<input type="text" name="wxid" value="${user.wxid}"><br>
    		描述信息:<input type="text" name="descip" value="${user.descip }"><br>
    		<button type="submit">修改</button>
    		<span>${errorMessage}</span>
    		</form>
                
               
            </div>

            <div id="right_cont"></div>

        </div>
        

    
        <%@ include file="footer.jsp" %>
    </div>
</body>
</html>
