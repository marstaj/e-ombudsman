<%-- 
    Document   : resitel
    Created on : 27.11.2011, 18:15:33
    Author     : car nikolaj



--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%--
slouzi k zobrazeni resitelu z databaze
--%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>${message}</h3>
        <br/>
        <table>
            <tr>
                <th>ID</th>
                <th>Login</th>
                <th>Heslo</th>
                <th>Jmeno</th>
                <th>Prijmeni</th>
                <th>Kategorie</th>
                <th>Stav Účtu</th>
            </tr>
            <c:forEach items="${resitele}" var="resitel">
                <tr>
                    <td><c:out value="${resitel.id}"></c:out></td>
                    <td><c:out value="${resitel.login}"></c:out></td>
                    <td><c:out value="${resitel.heslo}"></c:out></td>
                    <td><c:out value="${resitel.jmeno}"></c:out></td>
                    <td><c:out value="${resitel.prijmeni}"></c:out></td>
                    <td><c:out value="${resitel.kategorieId}"></c:out></td>
                    <td><c:out value="${resitel.stavUctu}"></c:out></td>
                    <td>
                        <c:choose>
                            <c:when test="${isOmbudsman}">
                                <a href="prideleni.htm?resID=${resitel.id}&ukolID=${ukolID}">Vybrat</a>
                            </c:when>
                        </c:choose>
                        <c:choose>
                            <c:when test="${isAdmin}">
                                <a href="smazani.htm?Id=${resitel.id}&priznak=2">Smazat</a>

                            </c:when>
                        </c:choose>
                    </c:forEach>
                </td>
            <tr/>
        </table>
        <a href="hlavni_strana.htm">zpět</a>
    </body>
</html>
