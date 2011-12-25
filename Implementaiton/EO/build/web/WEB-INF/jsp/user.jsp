<%-- 
    Document   : uzivatel
    Created on : 19.11.2011, 0:37:29
    Author     : car nikolaj
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%--
zobrazuje seznam uzivatelu z databaze
--%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${message}</title>
    </head>
    <body>
        <h3>${message}</h3>
        <br/>
        <table>
            <tr>
                <th>ID</th>
                <th>Login</th>
                <th>Heslo</th>
                <th>Jméno</th>
                <th>Příjmení</th>
                <th>Stav Účtu</th>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td><c:out value="${user.id}"></c:out></td>
                    <td><c:out value="${user.login}"></c:out></td>
                    <td><c:out value="${user.heslo}"></c:out></td>
                    <td><c:out value="${user.jmeno}"></c:out></td>
                    <td><c:out value="${user.prijmeni}"></c:out></td>
                    <td><c:out value="${user.stavUctu}"></c:out></td>
                    <td>
                        <c:choose>
                            <c:when test="${isAdmin}">
                                <a href="jmenovani_resitele.htm?userID=${user.id}">Jmenuj</a>
                                <a href="smazani.htm?Id=${user.id}&priznak=1">Smazat</a>

                            </c:when>
                        </c:choose>
                    </td>
                </tr>

            </c:forEach>
        </table>
        <a href="hlavni_strana.htm">zpět</a>
    </body>
</html>
