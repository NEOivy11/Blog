<%@ page language="java" import="java.util.*" import="com.neo.entity.User" import="com.neo.service.userService" pageEncoding="UTF-8"%>

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
    <title>用户列表</title>
    <script type="text/javascript" src="jquery.js"></script>
    <link rel="stylesheet" type="text/css" href="style.css">
    <style>
        #map ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }

        #map li {
            display: inline;
            margin-right: 20px; 
        }
    </style>
    
    
</head>
<body>
	<%@include file="header.jsp" %>
    <div id="big_cont">
            
       

        <div id="body_cont">
            <div id="left_cont"></div>
			<div id="searchForms" style="display: flex; justify-content: space-between; width: 800px; margin: 0 auto;">
    <form action="FindUser" id="form2" method="post" style="display: flex; align-items: center; width: 400px;">
        <span style="margin-right: 10px;">搜索用户：</span>
        <input type="text" id="searchTextUser" style="width: 200px; height: 10px;" name="find">
        <button id="searchButtonUser" style="width: 50px; height: 25px; font-size: 14px; padding: 3px;">搜索</button>
    </form>

</div>

            <div id="med_cont">
                <div class="article-list">
                <%List<User> userList = (List<User>)request.getAttribute("userList");
                userService userService = new userService();
                 %>
                <%for (User user:userList){ %>
                    <article class="article">
                        <h3 class="nickname">昵称：<%=user.getNickname() %></h3>
                        <p class="userName">用户名：<%=user.getUserName() %></p>
                        <h4 class="descip">描述信息：<%=user.getDescip() %></h4>
                        <p><a href="UserDetail2?UserName=<%=user.getUserName()%>">查看详细</a></p>
                    </article>
				<%} %>
                   
            </div>

            <div id="right_cont"></div>

        </div>

        <%@ include file="footer.jsp" %>
    </div>
</body>
</html>
