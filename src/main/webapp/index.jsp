

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
    <title>Usuarios</title>
</head>
<body>
<h1>Usuarios</h1>
    <ul>
        <c:forEach items="${personas}" var="persona">
            <li> ${persona.nombre} ${persona.correo} </li>
        </c:forEach>
    </ul>
</body>

</html>