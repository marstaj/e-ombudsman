<%-- 
    Document   : new_instituce_form
    Created on : 15.12.2011, 17:13:23
    Author     : car nikolaj
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%--
formular pro pridani nove instutce
--%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Instituce</title>
    </head>
    <body>
        <h3>Zde můžete přidat novou instituci</h3>
        <spring:nestedPath path="name">
            <form:form method="POST" commandName="instituce">
                Název <form:errors path="nazev" cssClass="error"/><br />
                <form:input path="nazev"/><br /><br />
                <input type="submit" value="OK">
            </form:form>
        </spring:nestedPath>
    </body>
</html>
