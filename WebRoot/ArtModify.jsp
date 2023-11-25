<%@ page language="java" import="java.util.*" import="com.neo.entity.Type" import="com.neo.entity.Atricle" pageEncoding="UTF-8"%>
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
    <title>文章编辑页面</title>
	<link rel="stylesheet" type="text/css" href="style.css">
    <script type="text/javascript" src="jquery.js"></script>

  </head>
  
  <body>
    <div id="big_cont">
        
        <%@include file="header.jsp" %>
            <h1>文章编辑</h1>
        
		<span id="error" name="Error">
        </span>
        <div id="body_cont">
            <div id="left_cont"></div>

            <div id="med_cont">
                <form id="form1" action="UpdateArt" method="post">
                <%List<Type> typeList = (List<Type>)request.getAttribute("typeList"); 
                Atricle art = (Atricle)request.getAttribute("art");%>
                
                    类型：     <select name="typeId">
                    <%for (Type type:typeList){ %>
             			<%if(art.getTypeId()==type.getTypeId()) {%>
    			<option value="<%=type.getTypeId()%>" selected><%=type.getType() %></option>
    			<%} else{%>
    			<option value="<%=type.getTypeId()%>"><%=type.getType() %></option>
    			<%}
    			} %>
    			
					</select>
                  
                    <br>
                    标题：<input type="text" name="artTitle" value="${art.artTitle }"><br>
                    内容：<textarea name="content" >${art.content }</textarea>
           <br>
                    <button id="regs" type="submit" style="display: block; margin: 0 auto;">确认</button>
                </form>

            </div>

            <div id="right_cont"></div>

        </div>

        <%@ include file="footer.jsp" %>
    </div>
    
  </body>
</html>