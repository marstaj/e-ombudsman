<%-- 
    Document   : ukol
    Created on : 21.11.2011, 21:10:40
    Author     : car nikolaj
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%--
zobrazuje seznam ukolu z databaze
--%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <h3>Neřešené úkoly</h3>
            <tr>

                <th>Datum přijetí</th>
                <th>datum splnění</th>
                <th>Nadpis</th>
                <th>Text</th>
                <th>Stav</th>
                <th>Uživatel</th>
                <th>Kategorie</th>
            </tr>
            <c:forEach items="${volne}" var="ukol">
                <tr>                
                    <td><c:out value="${ukol.datumPrijeti}"></c:out></td>
                    <td><c:out value="${ukol.datumSplneni}"></c:out></td>
                    <td><c:out value="${ukol.nadpis}"></c:out></td>
                    <td><c:out value="${ukol.textUkolu}"></c:out></td>
                    <td><c:out value="${ukol.stavUkolu}"></c:out></td>
                    <c:forEach items="${uzivatele}" var="uziv">
                        <c:if test = "${ukol.uzivatelId eq uziv.id}">
                            <td><c:out value="${uziv.jmeno}"></c:out>
                            <td/>
                        </c:if>
                    </c:forEach>
                    <c:forEach items="${kategorie}" var="kat">
                        <c:if test = "${ukol.kategorieId eq kat.id}">
                            <td><c:out value="${kat.nazev}"></c:out>
                            <td/>
                        </c:if>
                    </c:forEach>
                    <td>
                        <c:choose>
                            <c:when test="${isOmbudsman}">
                                <a href="resitel.htm?ukolID=${ukol.id}">Přidělit</a>
                            </c:when>
                        </c:choose>
                    </c:forEach>
                </td>
            </tr>
        </table>
        <table>
            <h3>Řešené úkoly</h3>
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
            <c:forEach items="${resene}" var="ukol">
                <tr>
                    <td><c:out value="${ukol.datumPrijeti}"></c:out></td>
                    <td><c:out value="${ukol.datumSplneni}"></c:out></td>
                    <td><c:out value="${ukol.nadpis}"></c:out></td>
                    <td><c:out value="${ukol.textUkolu}"></c:out></td>
                    <td><c:out value="${ukol.stavUkolu}"></c:out></td>
                    <c:forEach items="${uzivatele}" var="uziv">
                        <c:if test = "${ukol.uzivatelId eq uziv.id}">
                            <td><c:out value="${uziv.jmeno}"></c:out>
                            <td/>
                        </c:if>
                    </c:forEach>
                    <c:forEach items="${resitele}" var="res">
                        <c:if test = "${ukol.resitelId eq res.id}">
                            <td><c:out value="${res.jmeno}"></c:out>
                            <td/>
                        </c:if>
                    </c:forEach>
                    <c:forEach items="${kategorie}" var="kat">
                        <c:if test = "${ukol.kategorieId eq kat.id}">
                            <td><c:out value="${kat.nazev}"></c:out>
                            <td/>
                        </c:if>
                    </c:forEach>
                    <td>

                </tr>
            </c:forEach>

        </table>
                <table>
            <h3>Nesplněné</h3>
            <tr>

                <th>Datum přijetí</th>
                <th>datum splnění</th>
                <th>Nadpis</th>
                <th>Text</th>
                <th>Stav</th>
                <th>Uživatel</th>
                <th>Kategorie</th>
            </tr>
            <c:forEach items="${nesplnene}" var="ukol">
                <tr>
                    <td><c:out value="${ukol.datumPrijeti}"></c:out></td>
                    <td><c:out value="${ukol.datumSplneni}"></c:out></td>
                    <td><c:out value="${ukol.nadpis}"></c:out></td>
                    <td><c:out value="${ukol.textUkolu}"></c:out></td>
                    <td><c:out value="${ukol.stavUkolu}"></c:out></td>
                    <c:forEach items="${uzivatele}" var="uziv">
                        <c:if test = "${ukol.uzivatelId eq uziv.id}">
                            <td><c:out value="${uziv.jmeno}"></c:out>
                            <td/>
                        </c:if>
                    </c:forEach>
                    <c:forEach items="${kategorie}" var="kat">
                        <c:if test = "${ukol.kategorieId eq kat.id}">
                            <td><c:out value="${kat.nazev}"></c:out>
                            <td/>
                        </c:if>
                    </c:forEach>
                    <td>

                    </c:forEach>
                </td>
            </tr>
        </table>
        <a href="hlavni_strana.htm">zpět</a>
    </body>
</html>
