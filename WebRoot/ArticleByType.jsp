<%@ page language="java" import="java.util.*" import="com.neo.entity.Atricle" import="com.neo.service.articleService"  pageEncoding="utf-8"%>
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
    <title>文章页面</title>
    <script type="text/javascript" src="jquery.js"></script>
    <link rel="stylesheet" type="text/css" href="style.css">
    <style>

    </style>
</head>
<body>
    <div id="big_cont">
        <div id="head_cont">
            <h1>文章</h1>
        </div>

        <div id="body_cont">
            <h2 style="text-align: center;">${Type.type}</h2>
            <div id="left_cont"></div>

            <div id="med_cont">
                <h2>文章列表</h2>
                <div class="article-list">
                <%List<Atricle> artList = (List<Atricle>)request.getAttribute("artList");
                articleService artService = new articleService(); %>
                <%for (Atricle art:artList){ %>
                    <article>
                        <h3><%=art.getArtTitle() %></h3>
                        <p><%=art.getContent() %></p>
                        <h4><%=artService.findType(art.getTypeId()) %></h4>
                        <p><a href="AtricleDisplay2?ArtId=<%=art.getArtId() %>">阅读更多</a></p>
                    </article>
                    <%} %>

                    

            </div>

            <div id="right_cont"></div>

        </div>

        <div id="foot_cont">
            <footer>
                <p>&copy; MyBlog. All rights reserved.</p>
                <ul>
                    <li><a href="#">Privacy Policy</a></li>
                    <li><a href="#">Terms of Service</a></li>
                    <li><a href="#">Contact Us</a></li>
                </ul>
            </footer>
        </div>
    </div>
</body>
</html>