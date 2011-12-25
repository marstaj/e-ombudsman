<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%--
formular pro pridani noveho uzivatele/registraci
--%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrace</title>
    </head>
    <body>
        <h3>Vyplňte, prosím, své osobní údaje:</h3>
        <spring:nestedPath path="name">
            <form:form method="POST" commandName="user">
                Login <form:errors path="login" cssClass="error"/><br />
                <form:input path="login"/><br /><br />

                Heslo <form:errors path="heslo" cssClass="error" /><br />
                <form:input path="heslo"/><br /><br />

                Jméno <form:errors path="jmeno" cssClass="error" /><br />
                <form:input path="jmeno"/><br /><br />

                Příjmení <form:errors path="prijmeni" cssClass="error" /><br />
                <form:input path="prijmeni"/><br /><br />
                <input type="submit" value="OK">
            </form:form>
        </spring:nestedPath>
        <a href="hlavni_strana.htm">zpět</a>
    </body>
</html>