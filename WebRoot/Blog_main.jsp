<%@ page language="java" import="java.util.*" import="com.neo.entity.Atricle" import="com.neo.service.articleService" pageEncoding="UTF-8"%>

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
    <title>博客主页面</title>
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

    			<form action="FindArtByTitle" method="post" id="form3" style="display: flex; align-items: center; width: 400px;">
        			<span style="margin-right: 10px;">搜索文章：</span>
        			<input type="text" id="searchTextArticle" style="width: 200px; height: 10px; " name="ArtTitle">
        			<button id="searchButtonArticle" style="width: 50px; height: 25px; font-size: 14px; padding: 3px;">搜索</button>
    			</form>
		</div>

            	<div id="med_cont">
                	<div class="article-list">
                	<%List<Atricle> artList = (List<Atricle>)request.getAttribute("artList");
                			articleService artService = new articleService();
                	 %>
                	<%for (Atricle art:artList){ %>
	                    <article>
	                        <h3><%=art.getArtTitle() %></h3>
	                        <p><%=art.getContent() %></p>
	                        <h4><%=artService.findType(art.getTypeId()) %></h4>
	                        <p><a href="AtricleDisplay?ArtId=<%=art.getArtId()%>">阅读更多</a></p>
	                    </article>
			<%} %>

            		</div>

        	</div>
		<div id="right_cont"></div>
</div>
<%@ include file="footer.jsp" %>

</body>
</html>
