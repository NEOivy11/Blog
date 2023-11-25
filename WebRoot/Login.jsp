<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <title>登录页面</title>
	<link rel="stylesheet" type="text/css" href="style.css">
    <script type="text/javascript" src="jquery.js"></script>

  </head>
  
  <body>
    <div id="big_cont">
        <div id="head_cont">
            <h1>登录</h1>
        </div>
		<span id="error" name="Error">
		<% String errorMsg = (String) request.getAttribute("message");
           if (errorMsg != null && !errorMsg.isEmpty()) {
              out.print("出错信息：" + errorMsg);
              // 如果登录失败，显示链接到注册的Servlet
      		  out.print(" <a href=\"Register\">注册</a>");
           } %>
        </span>
        <div id="body_cont">
            <div id="left_cont"></div>

            <div id="med_cont">
                <form id="form1" action="Login" method="post">
                    用户名：<input id="UserName" type="text" name="UserName"><br>
                    密码：<input id="password" type="password" name="password"><br>
                    <button id="regs" type="submit" style="display: block; margin: 0 auto;">登录</button>
                </form>

            </div>

            <div id="right_cont"></div>

        </div>

        <%@ include file="footer.jsp" %>
    </div>
  </body>
</html>
