<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css">
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <title>
        home
    </title>
    <style type="text/css">
        .left_menu{
            position:fixed;
            background: #b3c6ff !important;
            top:80px;
        }
        .item
        {
            font-size: 15px;
            color:white;
        }
        #c{
            position:fixed;
            left:9%;
            top:37px;
            font-weight: bold;
            font-size:35px;
            font-family: "Courier New";

        }
        #img1{
            position: fixed;
            border-radius: 50%;
            margin-left:10px;
            width: 6%;
            top:7px;
            height:80px;
        }
        a
        {
            text-decoration: none;
        }
        a:hover
        {
            color: cornflowerblue;
            font-size:15px;
        }
        #colorForHeader
        {   position: fixed;
            background-color: whitesmoke;
            height: 100px;
            width:1500px;
        }
    </style>
</head>
<body>
<div id="colorForHeader"> </div>
<span id="img_H"> <img src="<c:url value="/images/corona.PNG"/>" id="img1"/></span>
<span id="c">Corona Fighters</span>
<div class="ui eight item  menu left_menu">
    <a class=" item">
        <i class="home icon"></i>
    </a>
    <a class="item" href="home">
        about us
    </a>
    <a class="item" href="#">
        preventive measure
    </a>
    <a class="item" href="#">
        corona meter
    </a>
    <a class="item" href="#">
        buy vaccine
    </a>
    <a class="item" href="#">
        FAQ
    </a>
    <c:choose>
        <c:when test="${pageContext.request.userPrincipal.name == null}">
            <a class="ui item" href="">
                <i class="sign in icon"></i>
                Login
            </a>
            <a class="ui item" href="">
                <i class="user plus icon"></i>
                Sign Up
            </a>
        </c:when>
        <c:otherwise>
            <a class="ui item" href="">
                <i class="sign out alternate icon"></i>
                sign out
            </a>
        </c:otherwise>
    </c:choose>
</div>
</div>
</body>
</html>


