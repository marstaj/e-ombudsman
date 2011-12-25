<%-- 
    Document   : instituce
    Created on : 15.12.2011, 17:28:14
    Author     : car nikolaj
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%--
vypise seznam instituci v systemu
        --%>
        <h1>Vyberte instituci</h1>
        <table>
            <tr>
                <th>Název</th>
            </tr>
            <c:forEach items="${instituce}" var="instituce">
                <tr>
                    <td><c:out value="${instituce.nazev}"></c:out></td>
                    <td><a href="login.htm?ID=${instituce.id}">Vstoupit</a><td>
                    </c:forEach>
            </tr>
        </table><br/>
        <br/><br/>

        <a href="new_instituce_form.htm">Přidat Instituci</a>
    </body>
</html>
