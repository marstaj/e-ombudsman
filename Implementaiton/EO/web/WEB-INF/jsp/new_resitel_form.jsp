<%-- 
    Document   : new_resitel_form
    Created on : 27.11.2011, 17:53:07
    Author     : car nikolaj
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%--
formular pro pridani noveho resitele
--%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Přidání řešitele</title>
    </head>
    <body>
        <h3>Zde můžete přidat nového řešitele:</h3>
        <spring:nestedPath path="name">
            <form:form method="POST" commandName="resitel">
                Login <form:errors path="login" cssClass="error"/><br />
                <form:input path="login"/><br /><br />

                Heslo <form:errors path="heslo" cssClass="error" /><br />
                <form:input path="heslo"/><br /><br />

                Jméno <form:errors path="jmeno" cssClass="error" /><br />
                <form:input path="jmeno"/><br /><br />

                Příjmení <form:errors path="prijmeni" cssClass="error" /><br />
                <form:input path="prijmeni"/><br /><br />

                Kategorie:
                <spring:bind path="kategorieId">
                    <select name="${status.expression}">
                        <option value="1">První</option>
                        <option value="2">Druhá</option>
                        <option value="3">Třetí</option>

                    </select>
                </spring:bind>

                <input type="submit" value="OK">
            </form:form>
        </spring:nestedPath>
        <a href="hlavni_strana.htm">zpět</a>
    </body>
</html>
