<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" session="true" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Secure page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css">
    <style type="text/css">
    .logout{
        position:fixed;
        right:110px;
        top:30px;
    }
    table tr th{

        font-weight: 700;
        font-size: 15px;
        text-align: center;
    }
    .wrapper{
        padding-top: 6rem;
    }
    .welcome{
        position:fixed;
        left:50px;
        top:30px;
    }
    </style>

</head>
<body>
        <div class="welcome">
        <c:if test="${pageContext.request.userPrincipal.name != null}">
       <h2 style="color: darkblue"><i>Welcome: ${pageContext.request.userPrincipal.name}</i></h2>
        </c:if>
</div>
<div class="ui container wrapper">

    <h1 class="ui header divided" > Books list</h1>

<div class="button">
    <table cellspacing="0" cellpadding="8" class="ui table striped celled" >

     <i> <tr >

            <th>Book Name</th>
            <th>Book Author</th>
            <th>view</th>
        </tr></i>
        <c:forEach items="${data.booksInfoList}" var="data">

            <tr>
                <td>${data.bookName}</td>
                <td>${data.bookAuthor}</td>
                <td><a href="bookDetailsById/${data.bookId}" >view</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</div>
<div class="logout">
<a  href="logout" class="ui black button">Logout</a>
</div>
</body>
<sec:csrfInput/>
</html>