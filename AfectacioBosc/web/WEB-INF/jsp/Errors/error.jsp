<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%
        String idioma = (String) request.getSession().getAttribute("idioma");
%>
<html xml:lang="ca" lang="ca" xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta http-equiv="Content-Style-Type" content="text/css" />
        <fmt:setLocale value="<%=idioma%>" scope="page"/>
        <fmt:setBundle var="bundleSIPAN" basename="Literals.MSIPAN"/>
        <link rel="stylesheet" type="text/css" href="css/sipan.css" />
        <script type="text/javascript">
            function redirigir(){
                document.formulariRedirigir.submit();
            }
        </script>
    </head>
    <body>
        <div class="layoutcentral blockinfo">
            <h2><fmt:message key="excepcio" bundle="${bundleSIPAN}"/></h2>
            <p>${exception}</p>
        </div>
    </body>
    <form name="formulariRedirigir">
    </form>
</html>
