<%-- 
    Document   : potvrzeni
    Created on : 12.12.2011, 0:10:41
    Author     : car nikolaj
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%--
slouzi k zobrazeni ukolu, ktere cekaji na potvrzeni konretnim resitelem
--%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Úkoly čekající na potvrzení</h3>
        <table>
            <h3>Neřešené úkoly</h3>
            <tr>

                <th>Datum přijetí</th>
                <th>datum splnění</th>
                <th>Nadpis</th>
                <th>Text</th>
                <th>Stav</th>
                <th>Uživatel</th>
                <th>Řešitel</th>
                <th>Kategorie</th>
            </tr>
            <c:forEach items="${ukoly}" var="ukol">
                <tr>
                    <td><c:out value="${ukol.datumPrijeti}"></c:out></td>
                    <td><c:out value="${ukol.datumSplneni}"></c:out></td>
                    <td><c:out value="${ukol.nadpis}"></c:out></td>
                    <td><c:out value="${ukol.textUkolu}"></c:out></td>
                    <td><c:out value="${ukol.stavUkolu}"></c:out></td>
                    <td><c:out value="${ukol.uzivatelId}"></c:out></td>
                    <td><c:out value="${ukol.resitelId}"></c:out></td>
                    <td><c:out value="${ukol.kategorieId}"></c:out></td>

                    <td><a href="novy.htm?ukolID=${ukol.id}">Potvrdit</a></td>
                    <td><a href="smazani.htm?Id=${ukol.id}&priznak=3">Neschvalit</a></td>
                </c:forEach>

            </tr>
        </table>
    </body>
</html>
