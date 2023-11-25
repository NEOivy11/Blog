<%@ page language="java" import="java.util.*" import="com.neo.service.userService" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>博客</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <style>

        #map ul {
            list-style-type: none;
            display: flex;
            gap: 20px;
            margin: 0;
            padding: 0;
        }

        #map a {
            text-decoration: none;
            color: #fff;
            font-weight: bold;
            font-size: 16px;
            transition: color 0.3s ease;
        }

        #map a:hover {
            color: #ffcc00;
        }

        .user-info {
    		display: flex;
    		flex-direction: column;
    		align-items: flex-end;
    		margin-left: auto; /* 将该项推到最右端 */
		}

        .logout-link {
            color: #ffcc00;
            font-weight: bold;
            text-decoration: none;
            font-size: 16px;
            margin-top: 5px;
            transition: color 0.3s ease;
        }

        .logout-link:hover {
            color: #fff;
        }
    </style>
</head>
<body>
<%if(request.getAttribute("nickname")!=null) {%>
<%if ("1".equals(request.getAttribute("isAdmin"))) {%>
    <div id="big_cont">
        <div id="head_cont">
            <h1>博客</h1>
            <div id="map">
                <ul>
                    <li><a href="Blog_main">主页</a></li>
                    <li><a href="ArticleEdit">发布文章</a></li>
                    <li><a href="UserList">用户列表</a></li>
                    <li><a href="UserManage">用户管理</a></li>
                    <li><a href="LoginLog">登录日志</a></li>
                    <li><a href="OperationLog">操作日志</a></li>
                    
                    <li class="user-info">
                        
                        	<a class="logout-link" href="UserDetail">管理员用户：<%=request.getAttribute("nickname") %></a>
                        	<a class="logout-link" href="Logout">注销</a>
                        
                        
                    </li>
                </ul>
                
            </div>
        </div>
    </div><%}else{ %><div id="big_cont">
        <div id="head_cont">
            <h1>博客</h1>
            <div id="map">
                <ul>
                    <li><a href="Blog_main">主页</a></li>
                    <li><a href="ArticleEdit">发布文章</a></li>
                    <li><a href="UserList">用户列表</a></li>
            
                    
                    <li class="user-info">
                        
                        	<a class="logout-link" href="UserDetail">登录用户：<%=request.getAttribute("nickname") %></a>
                        	<a class="logout-link" href="Logout">注销</a>
                        
                        
                    </li>
                </ul>
                
            </div>
        </div>
    </div><%} }else{%><div id="big_cont">
        <div id="head_cont">
            <h1>博客</h1>
            <div id="map">
                <ul>
                    <li><a href="Blog_main">主页</a></li>
                    <li><a href="ArticleEdit">发布文章</a></li>
                    <li><a href="UserList">用户列表</a></li>
            
                    
                    <li class="user-info">
                        
                        	<a class="logout-link" href="Login">登录</a>
                        	<a class="logout-link" href="Register">注册</a>
                        
                        
                    </li>
                </ul>
                
            </div>
        </div>
    </div><%} %>
    
</body>
</html>
