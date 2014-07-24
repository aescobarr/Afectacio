<%-- 
    Document   : error
    Created on : 19-may-2009, 11:17:31
    Author     : a_escobar
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<script type='text/javascript' src='/Tasques/dwr/interface/tasquesListAjaxManager.js'></script>
<script type='text/javascript' src='/Tasques/dwr/engine.js'></script>
<script type='text/javascript' src='/Tasques/dwr/util.js'></script>

<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%
        String idioma = (String) request.getSession().getAttribute("idioma");
%>
<fmt:setLocale value="<%=idioma%>" scope="page"/>
<fmt:setBundle var="bundleSIPAN" basename="Literals.MSIPAN"/>
<link rel="stylesheet" type="text/css" href="css/sipan.css" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <script type="text/javascript">
            function redirigir(){
                document.formulariRedirigir.submit();
            }
        </script>
    </head>
    <body>aaaaaaaaaaaaaaaaa
        <div class="layoutcentral blockinfo">
            <h2><fmt:message key="excepcio" bundle="${bundleSIPAN}"/></h2>
            <p>${exception}</p>
        </div>
    </body>
    <form name="formulariRedirigir">
    </form>
</html>
