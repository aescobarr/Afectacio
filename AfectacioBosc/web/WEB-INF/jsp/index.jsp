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
        <fmt:setBundle var="bundleSeguretat" basename="Literals.MSeguretat"/>
        <fmt:setBundle var="bundleAfectacio" basename="cat.creaf.afectaciobosc.literals.AfectacioBosc"/>
        <link rel="stylesheet" type="text/css" href="<c:url value='/css/sipan.css' />" />
<link rel="stylesheet" type="text/css" href="<c:url value='/css/estilAfectacio.css' />" />
        <%@ include file="/WEB-INF/jsp/Estructura/yui-sipan.jsp" %>
        <script type="text/javascript" src="<c:url value='/js/Estructura/menu.js' />"></script>
        <script type="text/javascript" src="<c:url value='/js/general.js' />"></script>
        <script type="text/javascript"  src="<c:url value='/js/Utils/md5.js' />"></script>
        <script type="text/javascript">
            function setFocus() {
              var loginForm = document.getElementById("usuari");
              if (loginForm) {
                loginForm.focus();
              }
            }

            function getIP(){
                var ip = '<%=request.getRemoteAddr()%>';
                return ip;
            }
      </script>
    </head>
    <body class="yui-skin-sam"  onload="javascript:setFocus();return false;">
        <div id="doc" class="yui-d2">
            <div id="hd">
                <div class="login"></div>
                <div class="header"><img src="<c:url value='/grafics/img_header.png' />" alt=""/></div>
                <div class="menu"></div>
            </div>
            <div id="bd" class="cos_pagina_inicial">
                <%@ include file="/WEB-INF/jsp/Login/loginSimple.jsp" %>
                <br/>
                <div class="avis"><p><fmt:message key="avis" bundle="${bundleAfectacio}" /></p>
                    <ul><li><fmt:message key="avisCaducaSessio" bundle="${bundleAfectacio}" /></li></ul>
                    <ul><li><fmt:message key="avisF5" bundle="${bundleAfectacio}" /></li></ul>
                </div>
                <div class="iconesnavegadors"><fmt:message key="optimitzatPer" bundle="${bundleSIPAN}" />&nbsp;<img src="<c:url value='/grafics/iconChrome.png' />" alt="Google Chrome" />&nbsp;<fmt:message key="googleChrome" bundle="${bundleSIPAN}" />&nbsp;<img src="<c:url value='/grafics/iconFirefox.png' />" alt="Firefox" />&nbsp;<fmt:message key="firefox" bundle="${bundleSIPAN}" />&nbsp;<img src="<c:url value='/grafics/iconIE.png' />" alt="IE" />&nbsp;<fmt:message key="internetExplorer" bundle="${bundleSIPAN}" /></div>
            </div>
            <div id="ft">
                <%@ include file="/WEB-INF/jsp/Estructura/footer.jsp" %>
            </div>
        </div>
    </body>
</html>