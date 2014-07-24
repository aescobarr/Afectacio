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
                            <tr><td><strong><fmt:message key="codi" bundle="${bundleAfectacio}" />:</strong></td><td>${dades.afectacio.codi}</td><td align="center" rowspan="9"></td></tr>
                            <tr><td><strong><fmt:message key="utmXPuntAfectat" bundle="${bundleAfectacio}" />:</strong></td><td>${dades.afectacio.utmX}</td></tr>
                            <tr><td><strong><fmt:message key="utmYPuntAfectat" bundle="${bundleAfectacio}" />:</strong></td><td>${dades.afectacio.utmY}</td></tr>
                            <c:set var="valueData"><fmt:formatDate value="${dades.afectacio.dataApreciacioInicial}" pattern="dd/MM/yyyy" type="date"/></c:set>
                            <tr><td><strong><fmt:message key="dataApreciacioInicial" bundle="${bundleAfectacio}" />:</strong></td><td>${valueData}</td></tr>
                            <c:set var="valueData"><fmt:formatDate value="${dades.afectacio.dataDadesDefinitives}" pattern="dd/MM/yyyy" type="date"/></c:set>
                            <tr><td><strong><fmt:message key="dataDadesDefinitives" bundle="${bundleAfectacio}" />:</strong></td><td>${valueData}</td></tr>
                            <c:set var="valueData"><fmt:formatDate value="${dades.afectacio.dataValidacio}" pattern="dd/MM/yyyy" type="date"/></c:set>
                            <tr><td><strong><fmt:message key="dataValidacio" bundle="${bundleAfectacio}" />:</strong></td><td>${valueData}</td></tr>
                            <tr><td><strong><fmt:message key="nomEnginyer1" bundle="${bundleAfectacio}" />:</strong></td><td>${dades.afectacio.nomEnginyer1}</td></tr>
                            <tr><td><strong><fmt:message key="nomEnginyer2" bundle="${bundleAfectacio}" />:</strong></td><td>${dades.afectacio.nomEnginyer2}</td></tr>
                            <tr><td><strong><fmt:message key="codiAgent1" bundle="${bundleAfectacio}" />:</strong></td><td>${dades.afectacio.codiAgent1}</td></tr>
                            <tr><td><strong><fmt:message key="codiAgent2" bundle="${bundleAfectacio}" />:</strong></td><td>${dades.afectacio.codiAgent2}</td></tr>
                            <tr><td><strong><fmt:message key="excepcionalitatMeteorologica" bundle="${bundleAfectacio}" />:</strong></td><td>${dades.afectacio.excepcionalitatMeteorologica}</td></tr>
                            <tr><td><strong><fmt:message key="mostreigSistematic" bundle="${bundleAfectacio}" />:</strong></td><td><c:if test="${afectacio.esMostreigSistematic}"><fmt:message key="si" bundle="${bundleSIPAN}" /></c:if><c:if test="${!afectacio.esMostreigSistematic}"><fmt:message key="no" bundle="${bundleSIPAN}" /></c:if></td></tr>
                            <tr><td><strong><fmt:message key="observacions" bundle="${bundleAfectacio}" />:</strong></td><td>${dades.afectacio.observacionsMostreigSistematic}</td></tr>
                            <tr><td colspan="2"><img src="<c:url value='/grafics_temp/${dades.nomFitxer}'/>" alt="mapa" /></td></tr>
                            <tr><td colspan="2">
                            <table>
                                <tr>
                                    <th><fmt:message key="gestioZona" bundle="${bundleAfectacio}" /></th>
                                    <th>%</th>
                                    <th><fmt:message key="tipusBosc" bundle="${bundleAfectacio}" /></th>
                                    <th>%</th>
                                </tr>
                                <tr>
                                    <td><fmt:message key="ambTreballsGestioAparent" bundle="${bundleAfectacio}" /></td>
                                    <td>${dades.afectacio.percentatgeAmbTreballsGestioAparent}</td>
                                    <td><fmt:message key="boscRegeneracioNatural" bundle="${bundleAfectacio}" /></td>
                                    <td>${dades.afectacio.percentatgeBoscRegeneracioNatural}</td>
                                </tr>
                                <tr>
                                    <td><fmt:message key="senseTreballsGestioAparent" bundle="${bundleAfectacio}" /></td>
                                    <td>${dades.afectacio.percentatgeSenseTreballsGestioAparent}</td>
                                    <td><fmt:message key="repoblacioArtificial" bundle="${bundleAfectacio}" /></td>
                                    <td>${dades.afectacio.percentatgeRepoblacioArtificial}</td>
                                </tr>
                                <tr>
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>
                                    <td><fmt:message key="plantacioEspeciesCreixementRapid" bundle="${bundleAfectacio}" /></td>
                                    <td>${dades.afectacio.percentatgePlantacioEspeciesCreixementRapid}</td>
                                </tr>
                            </table></td></tr>
                            <c:set var="valueData"><fmt:formatDate value="${dades.afectacio.data}" pattern="dd/MM/yyyy" type="date"/></c:set>
                            <tr><td><strong><fmt:message key="dataEpisodiFormatada" bundle="${bundleAfectacio}" />:</strong></td><td>${valueData}</td></tr>
                            <tr><td colspan="2">
                            <table width="100%"><tr><th><fmt:message key="especie" bundle="${bundleAfectacio}" /></th>
                                <th><fmt:message key="recobriment" bundle="${bundleAfectacio}" /></th>
                                <th><fmt:message key="afectacio" bundle="${bundleAfectacio}" /></th>
                                <th><fmt:message key="estrat" bundle="${bundleAfectacio}" /></th></tr>
                                <c:forEach items="${dades.afectacio.afectacionsEstimades}" var="element" varStatus="loopStatus">
                                <tr><td>${element.especie}</td>
                                    <td>${element.recobriment}</td>
                                    <td>${element.afectacio}</td>
                                    <td>${element.estrat}</td>
                                </tr>
                                </c:forEach>
                            </table></td></tr>
                            <tr><td><strong><fmt:message key="grauAfectacio" bundle="${bundleAfectacio}" />:</strong></td><td>${dades.afectacio.grauAfectacioXarxaViaria}</td></tr>
                            <tr><td><strong><fmt:message key="causaEpisodiDecaiment" bundle="${bundleAfectacio}" />:</strong></td>
                                <td><c:forEach items="${dades.afectacio.causesDecaiment}" var="element" varStatus="status" >
                                        ${element}<c:if test="${fn:length(dades.afectacio.causesDecaiment)>status.index+1}">,&nbsp;</c:if>
                                    </c:forEach></td></tr>
                            <tr><td><strong><fmt:message key="observacions" bundle="${bundleAfectacio}" />:</strong></td><td>${dades.afectacio.observacions}</td></tr>
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