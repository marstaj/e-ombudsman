<%--
    Document   : login
    Created on : 15.12.2010, 23:31:40
    Author     : Matej
--%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%--
zobrazuje formular potrebny pro prihlaseni
--%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8_czech_ci">

        <title>Přihlášení do Informačního Systému</title>
    </head>
    <body>
        <h3>Vyplňte, prosím, své přihlašovací údaje:</h3>
        <spring:nestedPath path="name">

            <form:form method="POST" commandName="loginForm">
                Přihlašovací jméno:
                <spring:bind path="login">
                    <input type="text" name="${status.expression}" value="${status.value}">
                </spring:bind>
                <br />
                Heslo:
                <spring:bind path="heslo">
                    <input type="text" name="${status.expression}" value="${status.value}">
                </spring:bind>
                <br />

                <input type="submit" value="OK">

            </form:form>
        </spring:nestedPath>
        <p>Pokud nejste zaregistrováni do systému, můžete tak učinit <a href="new_user_form.htm">zde</a></p><br /><br />
        <a href="hlavni_strana.htm">zpět</a>
    </body>
</html>

