<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css">
    <title>Registration</title>
    <style type="text/css">
        body,html{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        body {
            height: 100vh;
            background: #efefef;
         }

        .wrapper {
            display: flex;
            justify-content: center;
            align-items: center;
            width: 50%;
            margin: auto;
            padding-top: 5rem;
            padding-bottom: 1rem;
        }
        .buttons1{
            position:fixed;
            left:50px;
            top:50px;
        }
        .buttons{
            display: flex;
            justify-content: center;
            padding: 1rem;
        }
    </style>
</head>
<body>

<c:url value="/saveRegData" var="formUrl"/>
<div class="wrapper">
    <form:form modelAttribute="reg" action="${formUrl}" class="ui form" method="post">
        <h1 class="ui center aligned header">Registration</h1>
        <div class="ui container">
            <div class="ui two column grid">

                <div class="field required column">
                    <label>FirstName</label>
                    <form:input path="firstName" maxlength="30" placeholder="first name"/>
                    <form:errors path="firstName"  class="ui pointing red prompt basic label"  ></form:errors>
                </div>
                <div class="field required column">
                    <label>LastName</label>
                    <form:input path="lastName" maxlength="30" placeholder="last name"/>
                    <form:errors path="lastName"  class="ui pointing red prompt basic label"  ></form:errors>
                </div>
                <div class="field required column">
                    <label>Email</label>
                    <form:input path="email" type="email" maxlength="30" placeholder="email"/>
                    <form:errors path="email"  class="ui pointing red prompt basic label"  ></form:errors>
                </div>
                <div class="field required column">
                    <label>UserName</label>
                    <form:input path="userName" type="text" maxlength="30" placeholder="user name"/>
                    <form:errors path="userName"  class="ui pointing red prompt basic label"  ></form:errors>
                </div>
                <div class="field required column">
                    <label>Password</label>
                    <form:input path="password" type="password" maxlength="30" />
                    <form:errors path="password"  class="ui pointing red prompt basic label"  ></form:errors>
                </div>
                <div class="field required column">
                    <label>ConfirmPassword</label>
                    <form:input path="confirmPassword" type="password" maxlength="30"/>
                    <form:errors path="confirmPassword"  class="ui pointing red prompt basic label"  ></form:errors>
                </div>
                <div class="field required column">
                    <label>Address</label>
                    <form:input path="address" type="text" maxlength="200" placeholder="adddress"/>
                    <form:errors class="ui pointing red prompt basic label" path="address"   ></form:errors>
                </div>
                <div class="field required column">
                    <label>Country</label>
                    <form:select path="country" class="ui dropdown">
                        <form:options items="${countriesList}" />
                    </form:select>
                    <form:errors path="country"  class="ui pointing red prompt basic label"  ></form:errors>
                </div>
                <div class="field required column">
                    <label>Contact</label>
                    <form:input path="contact" type="number" maxlength="10" placeholder="contact"/>
                    <form:errors path="contact"  class="ui pointing red prompt basic label"  ></form:errors>
                </div>
            </div>
            <div class="buttons row">

                <button type="submit" class="ui button linkedin">Register</button>
                <a href="index.jsp" type="submit" class="ui button linkedin">Back</a>
            </div>
        </div>
    </form:form>
    <div class="buttons1">
        <a href="index.jsp"><input class="ui black button" type="button" value="home" align="centre"  ></a>
    </div>
</div>
<script>
    $('.ui.dropdown').dropdown();
</script>
</body><sec:csrfInput/>
</html>

