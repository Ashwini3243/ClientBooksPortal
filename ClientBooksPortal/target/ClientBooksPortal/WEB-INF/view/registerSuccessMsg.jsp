<%--
  Created by IntelliJ IDEA.
  User: Ashu
  Date: 23-04-2020
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>

    <style>
        body {
            height: 100vh;
            background: #efefef;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
        }
    </style>
</head>
<body>
<h1>${str}</h1><br>
<a href="index.jsp" class="ui button linkedin">Home</a>
</body>
<sec:csrfInput/>
</html>
