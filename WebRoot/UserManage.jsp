<%@ page language="java" import="java.util.*" import="com.neo.entity.User" pageEncoding="UTF-8"%>
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
    <title>用户管理页面</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <script type="text/javascript" src="jquery.js"></script>
    <script>
        $(document).ready(function () {
            $("#searchButton").click(function () {
                event.preventDefault(); // 阻止默认表单提交行为
                var searchText = $("#searchText").val().toLowerCase(); // 获取搜索文本并转换为小写
    
                // 遍历表格的每一行，但排除表头行
                $("table tbody tr:not(:first-child)").each(function () {
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
    
</head>
<body>
    <div id="big_cont">
       <%@include file="header.jsp" %>
            
        

        <div id="body_cont">
            <div id="left_cont"></div>
			<h2>用户管理</h2>
            <div id="med_cont">
                <form action="" id="form2" style="display: flex; align-items: center;">
                    <h3>搜索用户：</h3><input type="text" id="searchText" style="display: inline-block; flex: 1;">
                    <button id="searchButton">搜索</button>
                </form>
                
                <table id="table1">
                    <tr>
                    <th>用户名</th>
                    <th>昵称</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>出生日期</th>
                    <th>手机</th>
                    <th>Email</th>
                    <th>微信号</th>
                    <th>描述信息</th>
                    <th>注册日期</th>
                    <th>最后修改日期</th>
                    <th>是否禁用</th>
                    <th>是否为管理员</th>
                    <th>操作</th>
                    </tr>
					<%List<User> userList = (List<User>)request.getAttribute("userList"); %>
					
                    <%for (User user:userList){                 
    				String encodedUserName = java.net.URLEncoder.encode(user.getUserName(), "UTF-8");
    				encodedUserName = encodedUserName.replaceAll("\\+", "%20");
					%>
                    <tr>
                        <td><%=user.getUserName() %> <br><a href="UserDetail3?UserName=<%=encodedUserName %>">详细信息</a></td>
                      
                        <td><%=user.getNickname() %></td>
                        <td><%=user.getFullName() %></td>
                        <td><%=user.getSex() %></td>
                        <td><%=user.getBirthday() %></td>
                        <td><%=user.getPhone() %></td>
                        <td><%=user.getEmail() %></td>
                        <td><%=user.getWxid() %></td>
                        <td><%=user.getDescip() %></td>
                        <td><%=user.getRegDate() %></td>
                        <td><%=user.getModiDate() %></td>
                        <td><%=user.getAvailable() %></td>
                        <td><%=user.getAdminUser() %></td>
                        <td><a href="PasswordAlterByAdmin?UserName=<%=user.getUserName()%>">修改密码</a><br>
            
                      
       
                        <script>
                        	var isAvail = <%=user.getAvailable()%>; // 获取是否是管理员的值
        					var linkText2 = isAvail === 1 ? "禁用" : "启用";
        					document.write('<a href="Change?UserName=<%=user.getUserName()%>">' + linkText2 + '</a><br>');
    					
                        
        					var isAdmin = <%=user.getAdminUser()%>; // 获取是否是管理员的值
        					var linkText = isAdmin === 0 ? "设为管理员" : "取消管理员";
        					document.write('<a href="ChangeAdmin?UserName=<%=user.getUserName()%>">' + linkText + '</a>');
    					
    						
    					</script>
                        </td>
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
