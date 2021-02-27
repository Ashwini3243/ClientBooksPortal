<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css">
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<style>
    table tbody tr td:nth-child(1){
        width: 100px;
        font-weight: 600;
    }

</style>
<div class="ui container" style="padding-top: 5rem;">

<table class="ui table striped celled book_details">
    <thead>
    <tr>
        <th colspan="2">
            Book Details
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

    </tbody>
</table>
<a href="../index.jsp" class="ui button linkedin">Home</a>
<a href="../getBooksList" class="ui button linkedin"> Back </a>
</div>
<sec:csrfInput/>