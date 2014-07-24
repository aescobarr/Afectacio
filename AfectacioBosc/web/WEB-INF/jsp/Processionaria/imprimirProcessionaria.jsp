<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<html xml:lang="ca" lang="ca" xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>SISTEMA D'INFORMACI&Oacute; D'AFECTACI&Oacute; DELS BOSCOS DE CATALUNYA</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta http-equiv="Content-Style-Type" content="text/css" />
        <fmt:setBundle var="bundleSIPAN" basename="Literals.MSIPAN"/>
        <fmt:setBundle var="bundleAfectacio" basename="cat.creaf.afectaciobosc.literals.AfectacioBosc"/>
        <link rel="shortcut icon" href="<c:url value='/grafics/afectacio_ico_nav.ico' />"/>
        <link rel="stylesheet" type="text/css" href="<c:url value='/css/sipan.css' />" />
        <link rel="stylesheet" type="text/css" href="<c:url value='/css/estilAfectacio.css' />" />
        <%@ include file="/WEB-INF/jsp/Estructura/yui-sipan.jsp" %>
        <script type="text/javascript">
          function printpage() {
              window.print();
          }
        </script>
    </head>
    <body class="yui-skin-sam">
        <div id="doc" class="yui-d2">
            <div id="hd">
                <div class="logout"><a class="print" href="#" onclick="javascript:printpage();return false;">&nbsp;</a></div>
                <div class="header"><img src="<c:url value='/grafics/img_header.png' />" alt=""/></div>
            </div>
            <div id="bd">
                <div class="modul">
                    <h2><fmt:message key="processionaria" bundle="${bundleAfectacio}" /></h2>
                    <div class="eina">
                        <table width="100%" class="blanc">
                            <tr><td height="30"><strong><fmt:message key="numeroPoligon" bundle="${bundleAfectacio}" /></strong></td><td>${dades.afectacio.codi}</td><td align="center" rowspan="11"><img src="<c:url value='/grafics_temp/${dades.nomFitxer}'/>" alt="mapa" /></td></tr>
                            <tr><td height="30"><strong><fmt:message key="comarca" bundle="${bundleAfectacio}" /></strong></td><td>${dades.afectacio.comarca}</td></tr>
                            <tr><td height="30"><strong><fmt:message key="tipusBosc" bundle="${bundleAfectacio}" /></strong></td><td>${dades.afectacio.tipusBosc}</td></tr>
                            <c:if test="${dades.afectacio.tipusBosc!=null && dades.afectacio.tipusBosc.idString=='TB002'}">
                            <tr><td height="30"><strong><fmt:message key="alcadaMitjanaArbres" bundle="${bundleAfectacio}" /></strong></td><td>${dades.afectacio.alcadaMitjanaArbres}</td></tr>
                            </c:if>
                            <tr><td height="30"><strong><fmt:message key="orientacio" bundle="${bundleAfectacio}" /></strong></td><td>${dades.afectacio.orientacio}</td></tr>
                            <tr><td height="30"><strong><fmt:message key="especie" bundle="${bundleAfectacio}" /></strong></td><td>${dades.afectacio.especie}</td></tr>
                            <tr><td height="30"><strong><fmt:message key="dataObservacio" bundle="${bundleAfectacio}" /></strong></td><td>${dades.afectacio.dataFormatada}</td></tr>
                            <tr><td height="30"><strong><fmt:message key="altitud" bundle="${bundleAfectacio}" /></strong></td><td>${dades.afectacio.alcada}</td></tr>
                            <tr><td height="30"><strong><fmt:message key="grauinfestacio" bundle="${bundleAfectacio}" /></strong></td><td>${dades.afectacio.grauInfestacio}</td></tr>
                            <tr><td height="30"><strong><fmt:message key="observacions" bundle="${bundleAfectacio}" /></strong></td><td>${dades.afectacio.observacions}</td></tr>
                            <tr><td height="30"><strong><fmt:message key="area" bundle="${bundleAfectacio}" /></strong></td><td>${dades.area}</td></tr>
                            <tr><td height="30"><strong><fmt:message key="centroide" bundle="${bundleAfectacio}" /></strong></td><td>${dades.centroide}</td></tr>
                        </table>
                    </div>
                    <div class="peueina">

                    </div>
                </div>
            </div>
            <div id="ft">
                <%@ include file="/WEB-INF/jsp/Estructura/footerAgentsRurals.jsp" %>
            </div>
        </div>
    </body>
</html>