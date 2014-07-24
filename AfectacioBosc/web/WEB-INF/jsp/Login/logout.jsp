<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<fmt:setBundle var="bundleSeguretat" basename="Literals.MSeguretat"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>SISTEMA D'INFORMACI&Oacute; D'AFECTACI&Oacute; DELS BOSCOS DE CATALUNYA</title>
    </head>
    <body>
        <c:set var="txtSortir"><fmt:message key="sortir" bundle="${bundleSeguretat}" /></c:set>
        <div class="logout">
        <form method="POST">
            <b><fmt:message key="Login.jlUsuari.text" bundle="${bundleSeguretat}" />:</b>
               <%=org.acegisecurity.context.SecurityContextHolder.getContext().getAuthentication().getName()%>            
               <a class="boto" href='<c:url value="/seguretat/j_acegi_logout"/>'>${txtSortir}</a>
        </form>
        </div>
    </body>
</html>
