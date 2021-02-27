<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<title>delivery</title>
<head></head>

<body>
<div>
    <form:form action="${pageContext.request.contextPath}/addDeliveryAddress" modelAttribute="address" method="post">
        <table>
            <tr>
                <td><form:label path="address_id">First Name</form:label></td>
                <td><form:input path="address_id" type="text" required="true" /></td>
                <td><form:errors style="color:red; " path="address_id" /> </td>
            </tr>
            <tr>
                <td><form:label path="firstName">First Name</form:label></td>
                <td><form:input path="firstName" type="text" required="true" /></td>
                <td><form:errors style="color:red; " path="firstName" /> </td>
            </tr>
            <tr>
                <td><form:label path="lastName">Last Name</form:label></td>
                <td><form:input path="lastName" type="text" required="true"/></td>
                <td><form:errors style="color:red; " path="lastName" /> </td>
            </tr>
            <tr>
                <td><form:label path="addressLine1">Address Line 1</form:label></td>
                <td><form:input path="addressLine1" type="text" required="true"/></td>
                <td><form:errors style="color:red; " path="addressLine1"/> </td>
            </tr>
            <tr>
                <td><form:label path="addressLine2">Address Line 2</form:label></td>
                <td><form:input path="addressLine2" type="text" /></td>
                <td><form:errors style="color:red; " path="addressLine2"/> </td>
            </tr>
            <tr>
                <td><form:label path="postcode">Postcode</form:label></td>
                <td><form:input path="postcode" type="text" required="true" /></td>
                <td><form:errors style="color:red; " path="postcode"/> </td>
            </tr>

            <tr>
                <td><form:label path="email">Email</form:label></td>
                <td><form:input path="email" type="text" required="true"/></td>
                <td><form:errors style="color:red; " path="email"/> </td>
            </tr>
            <tr>
                <td><form:label path="contactNumber">Contact Number</form:label></td>
                <td><form:input path="contactNumber" type="text" required="true" /></td>
                <td><form:errors style="color:red; " path="contactNumber"/> </td>
            </tr>
        </table>
        <input type="submit" value="Add Address"/>
    </form:form>
    <h3 style="color:blue;">${msg}</h3>
</div>

</body>

</html>