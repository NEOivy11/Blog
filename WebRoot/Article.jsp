<%@ page language="java" import="java.util.*" import="com.neo.entity.Type" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>文章类型管理页面</title>
    <script type="text/javascript" src="jquery.js"></script>
    <link rel="stylesheet" type="text/css" href="style.css">
    <script>
        $(document).ready(function() {
            // 当点击“添加”按钮时
            /*
            $(".addType").click(function() {
                var newType = prompt("请输入要添加的文章类型:");
                if (newType === null || newType.trim() === "") {
                    return;
                }
                // 创建新的列表项并添加到文章类型列表中
                var newItem = "<li><span>" + newType + "</span>  <a href='ArticleDetail.html' target='_blank'>查看详细</a>" + "<button class='changeType'>修改</button><button class='deleteType'>删除</button></li>";
                $(".article-type-list ul").append(newItem);
            });
*/
            // 当点击“修改”按钮时
            $(".article-type-list").on("click", ".changeType", function() {
                // 获取当前列表项的文本内容
                var currentText = $(this).siblings("span").text();
                var updatedText = prompt("请输入修改后的文章类型:", currentText);
                if (updatedText === null || updatedText.trim() === "") {
                    return;
                }
                $(this).siblings("span").text(updatedText);
            });

            //当点击“删除”按钮时
            $(".article-type-list").on("click", ".deleteType", function() {
                //查看当前是否有文章使用该类型

                // 获取当前列表项并将其从DOM中移除
                $(this).closest("li").remove();
            });
        });
    </script>
    <style>
        .addType,
        .changeType,
        .deleteType {
            padding: 5px 10px; /* 调整按钮的内边距来控制按钮尺寸 */
            background-color: #ffcc00;
            color: #333;
            border: none;
            border-radius: 5px;
            font-size: 14px;
            cursor: pointer;
        }
       
        .article-type-list ul li {
            margin: 10px 0;
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 10px;
            background-color: #ffffff24;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
        }
        

        a {
            text-decoration: none;
            margin-right: 10px;
        }


        .addType:hover,
        .changeType:hover,
        .deleteType:hover {
            background-color: #ffdb4d;
        }
    </style>
</head>
<body>
    <div id="big_cont">
        <%@include file="header.jsp" %>
            
        

        <div id="body_cont">
            <div id="left_cont"></div>

            <div id="med_cont">
                <h2 style="text-align: center;">文章类型</h2>
                <p>请注意：无法删除已被文章使用的类型</p>
                <div class="article-type-list">
                    <ul>
                    <%List<Type> typeList = (List<Type>)request.getAttribute("typeList"); %>
                    <%for (Type type:typeList) {%>
                        <li><span><%=type.getType() %></span>  <a href="ArtByType?TypeId=<%=type.getTypeId() %>" >查看详细</a><a href="UpdateType?TypeId=<%=type.getTypeId() %>">修改</a><a href="DeleteType?typeId=<%=type.getTypeId()%>">删除</a></li>
                        
    				<%} %>
						

                    </ul>
                    
                    <form action="Article" method="post">
                    	请输入要添加的文章类型：<input type="text" name="type">
                    <button class="addType" type="submit">添加</button>
                    </form>
                </div>
            </div>

            <div id="right_cont"></div>

        </div>

        <%@ include file="footer.jsp" %>
    </div>
</body>
</html>
