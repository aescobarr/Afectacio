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
            </div>
            <div id="bd">
                <div class="modul">
                    <div class="eina">
                        <div class="dina4">
                        <h2><fmt:message key="dadesBasiques" bundle="${bundleAfectacio}" /></h2>
                        <table width="100%" class="blanc">
                            <tr><td><strong><fmt:message key="codi" bundle="${bundleAfectacio}" />:</strong></td><td>${dades.afectacio.codi}</td><td align="center" rowspan="9"><img src="<c:url value='/grafics_temp/${dades.nomFitxer}'/>" alt="mapa" /></td></tr>
                            <tr><td><strong><fmt:message key="data" bundle="${bundleAfectacio}" />:</strong></td><td>${dades.afectacio.dataFormatada}</td></tr>
                            <tr><td><strong><fmt:message key="codiAgent1" bundle="${bundleAfectacio}" />:</strong></td><td>${dades.afectacio.codiAgent1}</td></tr>
                            <tr><td><strong><fmt:message key="codiAgent2" bundle="${bundleAfectacio}" />:</strong></td><td>${dades.afectacio.codiAgent2}</td></tr>                            
                            <tr><td><strong><fmt:message key="distribucioArbresAfectats" bundle="${bundleAfectacio}" />:</strong></td><td>${dades.afectacio.distribucioArbresAfectats}</td></tr>
                            <tr><td><strong><fmt:message key="causaEpisodiDecaiment" bundle="${bundleAfectacio}" />:</strong></td><td>${dades.afectacio.causesDecaimentFormatada}</td></tr>
                            <tr><td><strong><fmt:message key="grauAfectacio" bundle="${bundleAfectacio}" />:</strong></td><td>${dades.afectacio.grauAfectacio}</td></tr>
                            <h3><fmt:message key="afectacioGeneral" bundle="${bundleAfectacio}" /></h3>
                            <table width="100%"><tr><th><fmt:message key="especie" bundle="${bundleAfectacio}" /></th>
                                <th><fmt:message key="recobriment" bundle="${bundleAfectacio}" /></th>
                                <th><fmt:message key="afectacio" bundle="${bundleAfectacio}" /></th>
                                <th><fmt:message key="alcada" bundle="${bundleAfectacio}" /></th></tr>
                                <c:forEach items="${dades.afectacio.afectacionsEstimades}" var="element" varStatus="loopStatus">
                                <tr><td>${element.especie}</td>
                                    <td>${element.recobriment}</td>
                                    <td>${element.afectacio}</td>
                                    <td>${element.alcadaFormatejada}</td>
                                </tr>
                                </c:forEach>
                            </table>
                        </table>
                        </div>
                    </div>
                    <div class="peueina">

                    </div>
                </div>
            </div>
            <div id="ft">
                
            </div>
        </div>
    </body>
</html>