<%@ page language="java" import="java.util.*" import="com.neo.entity.LoginLog" pageEncoding="UTF-8"%>
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
    <title>登录日志</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <script type="text/javascript" src="jquery.js"></script>
    
    <style>
        .setAdmin,
        .modiPass,
        .denyUser {
            padding: 5px 10px; /* 调整按钮的内边距来控制按钮尺寸 */
            background-color: #ffcc00;
            color: #333;
            border: none;
            border-radius: 5px;
            font-size: 14px;
            cursor: pointer;
            width: 85px;
        }

        #searchButton{
            padding: 5px 10px;
            font-size: 18px;
            cursor: pointer;
            width: auto;
            height: auto;
        }
    </style>
    <script>
         $(document).ready(function () {
            $("#searchButton").click(function () {
                event.preventDefault(); // 阻止默认表单提交行为
                var searchText = $("#searchText").val().toLowerCase(); // 获取搜索文本并转换为小写
                $("table tbody tr:not(:first)").each(function () {
                    var rowData = $(this).text().toLowerCase(); // 获取当前行的文本并转换为小写
    
                    // 如果当前行的文本中包含搜索文本，则显示该行，否则隐藏
                    if (rowData.indexOf(searchText) >= 0) {
                        $(this).show();
                    } else {
                        $(this).hide();
                    }
                });
            });
        });
    </script>
</head>
<body>
    <div id="big_cont">
       <%@include file="header.jsp" %>
            
        

        <div id="body_cont">
            <div id="left_cont"></div>

            <div id="med_cont">
            <h2 style="text-align:center">登录日志</h2>
                <form action="" id="form2" style="display: flex; align-items: center;">
                    <h3>查询：</h3><input type="text" id="searchText" style="display: inline-block; flex: 1;">
                    <button id="searchButton">查询</button>
                </form>
                
                <table id="table1">
                    <tr>
                    		<th>登录时间</th>
                    		<th>用户名</th>
                    		<th>IP地址</th>
                            <th>登录状态</th>
                    </tr>
					<%List<LoginLog> logList = (List<LoginLog>)request.getAttribute("logList"); %>
					
                    <%for (LoginLog log:logList){                 
					%>
                    <tr>
                        <td><%=log.getLogDate() %></td>
                        <td><%=log.getUserName() %></td>
                        <td><%=log.getIpAdress() %></td>
                        <td><%=log.getLogContent() %></td>
                  
                  
                    </tr>
                    <%} %>
                </table>

            </div>

            <div id="right_cont"></div>

        </div>

        <%@ include file="footer.jsp" %>
    </div>
</body>
</html>
