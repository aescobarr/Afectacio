<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<html xml:lang="ca" lang="ca" xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>SISTEMA D'INFORMACI&Oacute; D'AFECTACI&Oacute; DELS BOSCOS DE CATALUNYA</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta http-equiv="Content-Style-Type" content="text/css" />
        <link rel="shortcut icon" href="<c:url value='/grafics/afectacio_ico_nav.ico' />"/>
        <fmt:setBundle var="bundleSIPAN" basename="Literals.MSIPAN"/>        
        <link rel="stylesheet" type="text/css" href="<c:url value='/css/sipan.css' />" />
        <%@ include file="/WEB-INF/jsp/Estructura/yui-sipan.jsp" %>
        <script type="text/javascript" src="<c:url value='/js/Estructura/menu.js' />"></script>
        
        <%
        java.net.InetAddress i = java.net.InetAddress.getLocalHost();
        String ip =i.getCanonicalHostName();
        %>
    </head>
    <body class="yui-skin-sam">
        <div id="doc" class="yui-d2">
            <div id="hd">
                <%@ include file="/WEB-INF/jsp/Estructura/header.jsp" %>
            </div>
            <div id="bd">
                <div class="modul">
                    <h2></h2>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <div class="eina">
                        <p><fmt:message key="sensePermisos" bundle="${bundleSIPAN}" /></p>
                    </div>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                </div>
            </div>
            <div id="ft">
                <%@ include file="/WEB-INF/jsp/Estructura/footer.jsp" %>
            </div>
        </div>
    </body>
</html>