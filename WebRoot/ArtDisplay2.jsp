<%@ page language="java" import="java.util.*" import="com.neo.entity.Comment" import="com.neo.service.commentService" import="com.neo.service.userService" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="style.css">

    <script type="text/javascript" src="jquery.js"></script>
    <style type="text/css">
.comments-section {
    margin-top: 30px;
    background-color: #f8f8f8;
    border: 1px solid #ddd;
    border-radius: 5px;
    padding: 20px;
    margin: 20px;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}

.comments-section h3 {
    font-size: 24px;
    color: #666;
}

.comment {
    border: 1px solid #ddd;
    border-radius: 5px;
    margin-bottom: 15px;
    padding: 15px;
    background-color: #f9f9f9;
}

.comment-content p {
    font-size: 16px;
    color: #333;
}

.comment-meta {
    margin-top: 10px;
    font-size: 14px;
    color: #777;
}

.comment-meta span {
    margin-right: 10px;
}

form {
    margin-top: 20px;
    display: flex;
    justify-content: center;
    align-items: center;
}

textarea {
    width: 100%;
    padding: 10px;
    margin-bottom: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    background-color: #f5f5f5;
    font-size: 16px;
    color: #333;
}

button {
    padding: 10px 20px;
    background-color: #ffcc00;
    color: #333;
    border: none;
    border-radius: 5px;
    font-size: 18px;
    cursor: pointer;
    display: block; 
    margin: 0 auto; 
}



    	
    </style>
  </head>
  
  <body>
  <%@include file="header.jsp" %>
  <div id="med_cont">
    <div class="article-details">
        <p class="article-type"><strong>类型:</strong> ${type}</p>
        <p><h2 class="article-title"> ${art.artTitle}</h2></p>
        <hr>
        <div class="article-meta">
        	<span><strong>文章ID:</strong> ${art.artId}</span>
        	<span><strong>发布者:</strong> </span>
        	<span><strong>发布时间:</strong></span>
        </div>
        <hr>
        <p class="article-content"> ${art.content}</p>
        <hr>
    </div>
    

    <script>
        function toggleReplyBox(commentId) {
            var replyBox = document.getElementById('reply_' + commentId);
            replyBox.style.display = (replyBox.style.display === 'none') ? 'block' : 'none';
        }
        
        document.addEventListener('click', function(event) {
        var replyBox = document.querySelector('.reply-box');
        if (event.target.closest('.comment') === null && event.target.closest('.reply-box') === null) {
            replyBox.style.display = 'none';
        }
    	});
    </script>

   </div>
   <%@ include file="footer.jsp" %>
</body>
</html>

