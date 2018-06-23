<%--
  Created by IntelliJ IDEA.
  User: Xiaodong
  Date: 2018/6/23
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>我的书籍</title>
</head>
<body>
    <c:forEach items="${books}" var="item">
        <label>${item.name}</label><br/>
    </c:forEach>
</body>
</html>
