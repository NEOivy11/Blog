<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <title>注册页面</title>

    <link rel="stylesheet" type="text/css" href="style.css">

    <script type="text/javascript" src="jquery.js"></script>
    <script type="text/javascript">
    $(document).ready(function() {
            $("#form1").submit(function() {
                if ($("#UserName").val().length >= 4 && $("#UserName").val().length <= 10 && $("#password").val() != "" && $("#sure_passw").val() == $("#password").val()) {
                    alert("提交成功！");
                    return true;
                } 
                else if ($("#UserName").val().length < 4 || $("#UserName").val().length > 10 ){
                    alert("用户名长度应该在4个字符到10个字符之间！");
                    return false;
                }
                else if ($("#password").val() == ""){
                    alert("密码不能为空！");
                    return false;
                }
                else if ($("#password").val() != $("#sure_passw").val()){
                    alert("确认密码必须与设置的密码相同！");
                    return false;
                }

        });
    });
    
    </script>
</head>
<body>
    <div id="big_cont">
        <div id="head_cont">
            <h1>注册</h1>
        </div>

        <div id="body_cont">
            <div id="left_cont"></div>

            <div id="med_cont">
                <form id="form1" action="Register" method="post" accept-charset="UTF-8">
                    昵称：<input id="Nickname" type="text" name="Nickname"><br>                    
                    密码：<input id="password" type="password" name="password"><br>
                    确认密码：<input id="sure_passw" type="password" name="surePassword"><br>
                    姓名：<input id="fullname" type="text" name="FullName"><br>
                    性别：<input id="sex" type="text" name="sex"><br>
                    出生日期：<input id="birthday" type="text" name="birthday"><br>
                    电话：<input id="phone" type="text" name="phone"><br>
                    邮箱：<input id="email" type="text" name="email"><br>
                    微信：<input id="wxid" type="text" name="wxid"><br>
                    描述信息：<input id="descip" type="text" name="descip"><br>         
       <span style="color:red" id="message">${message}</span>       
             <button id="regs" type="submit" style="display: block; margin: 0 auto;">注册</button>
                </form>

            </div>

            <div id="right_cont"></div>

        </div>

        <%@ include file="footer.jsp" %>
    </div>
</body>
</html>

