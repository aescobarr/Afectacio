<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<fmt:setBundle var="bundleSeguretat" basename="Literals.MSeguretat"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>SISTEMA D'INFORMACI&Oacute; D'AFECTACI&Oacute; DELS BOSCOS DE CATALUNYA</title>
        <link rel="stylesheet" type="text/css" href="../css/sipan.css" />
        <script src="../js/general.js"></script>
    </head>
    <body class="login">
        <% if (org.acegisecurity.context.SecurityContextHolder.getContext().getAuthentication() != null &&
                org.acegisecurity.context.SecurityContextHolder.getContext().getAuthentication().getName() != null &&
                !"".equals(org.acegisecurity.context.SecurityContextHolder.getContext().getAuthentication().getName().trim())) {
            response.sendRedirect("logout.htm");
        }
        %>
        <div class="login">
            <c:set var="txtUsuari"><fmt:message key="Login.jlUsuari.text" bundle="${bundleSeguretat}" /></c:set>
            <c:set var="txtPwd"><fmt:message key="Login.jlContrassenya.text" bundle="${bundleSeguretat}" /></c:set>
            <c:set var="txtOK"><fmt:message key="Login.jbAcceptar.text" bundle="${bundleSeguretat}" /></c:set>
            <form name="formulari" method="POST" action="<c:url value='j_acegi_security_check'/>">
                <%  String classe = "";
                    if("1".equals(request.getParameter("login_error"))){
                        classe = "class='errorlogin'";
                    }
                %>
                <p><label <%= classe%> for="j_username">${txtUsuari}:</label>
                <input type="text" name="j_username">
                <label <%= classe%> for="j_username">${txtPwd}:</label>
                <input type="password" name="j_password">
                <a class="boto" href="#" onClick="javascript:document.formulari.submit();return false;">${txtOK}</a></p>
            </form>
        </div>
    </body>
</html>
