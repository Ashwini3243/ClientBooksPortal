<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css">
<style>
    table tbody tr td:nth-child(1){
        width: 200px;
        font-weight: 900;
    }
    .logout{
        position:fixed;
        right:105px;
        top:30px;
    }

</style>
<div class="ui container" style="padding-top: 6rem;">
<table class="ui table striped celled book_details">
    <thead>
    <tr>
        <th colspan="2">
            <h3> Book Details </h3>
        </th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>BookId</td>
        <td>${data.bookId}</td>
    </tr>
    <tr>
        <td>Book Name</td>
        <td>${data.bookName}</td>
    </tr>
    <tr>
        <td>Book Author</td>
        <td>${data.bookAuthor}</td>
    </tr>
    <tr>
        <td>Book desc</td>
        <td>${data.bookDesc}</td>
    </tr>
    <tr>
        <td>price</td>
        <td>${price}</td>
    </tr>
    </tbody>
</table>
<a href="../welcome  " class="ui button linkedin">Home</a>
<a href="../welcome" class="ui button linkedin">Back</a>
<div class="logout">
<a href="../logout" class="ui black button">Logout</a>
</div></div>
<sec:csrfInput/>