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
    <div class="comments-section">
        <h3>评论区</h3>
        <% List<Comment> comList = (List<Comment>)request.getAttribute("list"); 
        	commentService comService = new commentService();
        	userService userService = new userService();%>
        <% for (Comment com : comList) { %>
            <div class="comment" id="comment_<%=com.getCommentId()%>">
                <%if((Integer)com.getParentCom() != 0) {%>
                <div class="comment-meta">
                	<span > 回复 <%=comService.findParentUser(com.getParentCom())%>: <span style="background-color: #f0f0f0; color: #333;">" <%=comService.findParentCom(com.getCommentId()) %> "</span></span>
                </div>
                <%} %>
                <div class="comment-content">
                    <p><%=com.getComContent() %></p>
                </div>
                           
                <div class="comment-meta">
                    <span>评论人：<%=userService.findNickname(com.getUserName()) %></span>
                    <span>评论时间：<%=com.getComDate() %></span>
                    <span>
                        <button type="button" style="font-size: 14px;" onclick="toggleReplyBox('<%=com.getCommentId()%>')">回复</button>
                    </span>
                </div> 
                <div class="reply-box" id="reply_<%=com.getCommentId()%>" style="display: none;">
                    <form action="Reply?parentCom=<%=com.getCommentId() %>&artId=${art.artId}" method="post">
                        <textarea name="repComContent" rows="2" cols="50" placeholder="确认"></textarea>
                        <br>
                        <button type="submit" name="repComment" id="repComment">确认</button>
                    </form>
                </div>
            </div>
        <% } %>

        <!-- 评论输入框 -->
        <form action="AddComment?artId=${art.artId}" method="post">
            <textarea name="comContent" rows="4" cols="50" placeholder="发表评论"></textarea>
            <br>
            <button type="submit" name="addComment" id="addComment">发表评论</button>
        </form>
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

