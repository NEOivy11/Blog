<%@ page language="java" import="java.util.*" import="com.neo.entity.User" import="java.util.Date" import="java.text.SimpleDateFormat" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
   User user = (User)request.getAttribute("user");
   String formattedRegDate = (user.getRegDate() != null) ? sdf.format(user.getRegDate()) : "";
   String formattedModiDate = (user.getModiDate() != null) ? sdf.format(user.getModiDate()) : "";
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
    <style type="text/css">
    #left_cont{
    		height: 980px;
            background-color:#555;
            float:left;
            width: 10%;
            text-align: center;
            margin:0 0 30px
        }
    </style>
</head>
<body>
    <div id="big_cont">
        <%@include file="header.jsp" %>
        

        <div id="body_cont">
            <div id="left_cont">
            	<ul>
            		<li><a href="UserDetail">用户信息</a></li>                   
               		<li><a href="Article">类型管理</a></li>
                    <li><a href="UserArt?userName=${user.userName }">文章管理</a></li>               
                </ul>
            </div>
            

            <div id="med_cont">
    		
        <form>
        	<h1 style="text-align:center">用户主页</h1>
            <h2 style="text-align:center">个人信息</h2>
            <span class="detail-label">用户名:</span>
            <input type="text" class="detail-value" value="${user.userName}" readonly>
        <br>
        
            <span class="detail-label">昵称:</span>
            <input type="text"  value="${user.nickname}" readonly>
        
        <br>
            <span class="detail-label">姓名:</span>
            <input type="text"  value="${user.fullName}" readonly>
        <br>
        
            <span class="detail-label">性别:</span>
            <input type="text"  value="${user.sex}" readonly>
        <br>
        
            <span class="detail-label">出生日期:</span>
            <input type="text" class="detail-value" value="${user.birthday}" readonly>
        <br>
        
            <span class="detail-label">电话:</span>
            <input type="text" class="detail-value" value="${user.phone}" readonly>
        <br>
        
            <span class="detail-label">邮箱:</span>
            <input type="text" class="detail-value" value="${user.email}" readonly>
        <br>
        
            <span class="detail-label">微信:</span>
            <input type="text" class="detail-value" value="${user.wxid}" readonly>
        <br>
        
            <span class="detail-label">描述信息:</span>
            <input type="text" class="detail-value" value="${user.descip}" readonly>
        <br>
        
            <span class="detail-label">注册日期:</span>
            <input type="text" class="detail-value" value="${user.regDate}" readonly>
        <br>
        
            <span class="detail-label">最后修改日期:</span>
            <input type="text" class="detail-value" value="${user.modiDate}" readonly>
        
    

    <div class="user-actions">
        <a href="UpdateUser2?userName=${user.userName }">修改信息</a>
    </div>
    </form>
</div>


            <div id="right_cont"></div>

        </div>

        <%@ include file="footer.jsp" %>
    </div>
</body>
</html>

