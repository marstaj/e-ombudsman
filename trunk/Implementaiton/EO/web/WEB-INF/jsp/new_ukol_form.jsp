<%-- 
    Document   : new_ukol_form
    Created on : 21.11.2011, 21:20:32
    Author     : car nikolaj
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%--
formular pro pridani noveho ukolu
--%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nový ůkol</title>
    </head>
    <body>
        <h3>Zde můžete vložit svojo připomínku:</h3>

        <spring:nestedPath path="name">
            <form:form method="POST" commandName="ukol">
                Nadpis
                <form:errors path="nadpis" cssClass="error" /><br />
                <form:input path="nadpis"/><br /><br />

                Text
                <form:errors path="textUkolu" cssClass="error" /><br />
                <form:textarea path="textUkolu"/><br /><br />
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
