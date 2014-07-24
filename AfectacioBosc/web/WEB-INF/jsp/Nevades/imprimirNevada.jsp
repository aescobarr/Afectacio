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
                    <h2><fmt:message key="nevades" bundle="${bundleAfectacio}" /></h2>
                    <div class="eina">
                        <table width="100%" class="blanc">
                            <tr><td><strong><fmt:message key="numeroPoligon" bundle="${bundleAfectacio}" /></strong></td><td>${dades.afectacio.codi}</td><td align="center" rowspan="9"><img src="<c:url value='/grafics_temp/${dades.nomFitxer}'/>" alt="mapa" /></td></tr>
                            <tr><td><strong><fmt:message key="comarca" bundle="${bundleAfectacio}" /></strong></td><td>${dades.afectacio.comarca}</td></tr>
                            <tr><td><strong><fmt:message key="terme" bundle="${bundleAfectacio}" /></strong></td><td>${dades.afectacio.terme}</td></tr>
                            <tr><td><strong><fmt:message key="nomCami" bundle="${bundleAfectacio}" /></strong></td><td>${dades.afectacio.nomCami}</td></tr>
                            <tr><td><strong><fmt:message key="longitud" bundle="${bundleAfectacio}" /></strong></td><td>${dades.afectacio.longitudKm}</td></tr>
                            <tr><td><strong><fmt:message key="observacions" bundle="${bundleAfectacio}" /></strong></td><td>${dades.afectacio.observacions}</td></tr>
                            <tr><td><strong><fmt:message key="peusAfectatsHa" bundle="${bundleAfectacio}" /></strong></td><td>${dades.afectacio.sumaPeusAfectatsPerHa}</td></tr>
                            <tr><td><strong><fmt:message key="nivellAfectacio" bundle="${bundleAfectacio}" /></strong></td><td>${dades.afectacio.nivellAfectacioText}</td></tr>
                            <tr><td colspan="2">
                                    <table width="100%"><tr><th><fmt:message key="especie" bundle="${bundleAfectacio}" /></th>
                                        <th><fmt:message key="pistaParcial" bundle="${bundleAfectacio}" /></th>
                                        <th><fmt:message key="pistaTotal" bundle="${bundleAfectacio}" /></th>
                                        <th><fmt:message key="franjaParcial" bundle="${bundleAfectacio}" /></th>
                                        <th><fmt:message key="franjaTotal" bundle="${bundleAfectacio}" /></th></tr>
                                        <c:forEach items="${dades.afectacio.dadesObservacions}" var="element" varStatus="loopStatus">
                                        <tr><td>${element.especie}</td>
                                            <td>${element.pistaParcialmentAfectat}</td>
                                            <td>${element.pistaTotalmentAfectat}</td>
                                            <td>${element.franjaParcialmentAfectat}</td>
                                            <td>${element.franjaTotalmentAfectat}</td>
                                        </tr>
                                        </c:forEach>
                                    </table>
                                </td></tr>
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