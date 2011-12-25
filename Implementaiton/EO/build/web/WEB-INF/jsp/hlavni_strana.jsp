<%-- 
    Document   : hlavni_strana
    Created on : 19.11.2011, 22:41:25
    Author     : car nikolaj
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vítejte</title>
    </head>
    <body>
        <h1>E-Ombudsman</h1>
        <%--
hlavni strana systemu, je zde rozdeleno jaka data se uzivateli zobrazi podle jeho role v systemu
        --%>

        <c:choose>
            <c:when test="${isAdmin}">
                <a href="user.htm">Výpis uživatelů</a><br /><br />
                <a href="ukol.htm">Výpis ukolu</a><br /><br />
                <a href="resitel.htm">Výpis řešitelů</a><br /><br />
                <a href="new_user_form.htm">Registrace nového uživatele</a><br /><br />
                <a href="new_resitel_form.htm">Registrace nového řešitele</a><br /><br />


            </c:when>
            <c:when test="${isOmbudsman}">
                <a href="user.htm">Výpis uživatelů</a><br /><br />
                <a href="ukol.htm">Výpis ukolu</a><br /><br />
                <a href="resitel.htm">Výpis řešitelů</a><br /><br />
                <a href="potvrzeni.htm">Potvrzeni úkolu</a><br /><br />
            </c:when>
            <c:when test="${isResitel}">
                <a href="user.htm">Výpis uživatelů</a><br /><br />
                <a href="ukol.htm">Výpis ukolu</a><br /><br />
                <a href="resitel.htm">Výpis řešitelů</a><br /><br />
                <a href="potvrzeni.htm">Potvrzeni úkolu</a><br /><br />
            </c:when>
            <c:when test="${userLoggedIn}">
                <a href="user.htm">Výpis uživatelů</a><br /><br />
                <a href="ukol.htm">Výpis ukolu</a><br /><br />
                <a href="resitel.htm">Výpis řešitelů</a><br /><br />
                <a href="new_ukol_form.htm">Registrace nového ukolu</a><br /><br />
            </c:when>

            <c:otherwise>
                <p>Nejste přihlášen/a. Prosím pokračujte následujícím odkazem k přihlášení:</p>
                <a href="login.htm">Přihlášení</a><br /><br />
            </c:otherwise>

        </c:choose>
    </body>
</html>

