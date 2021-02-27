<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
    <h1 style="color:red;text-align:center">Session Expired</h1>
    <br><br>
    
    <a href="index.jsp">Go to home</a>
<sec:csrfInput/>