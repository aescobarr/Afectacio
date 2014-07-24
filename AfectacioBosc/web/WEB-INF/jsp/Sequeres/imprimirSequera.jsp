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
        <script type="text/javascript" src="<c:url value='/js/Media/imatgesAjax.js' />"></script>
        <script type="text/javascript">
          var urlServidor = "${dades.ip}";  
          var idSequera = "${dades.afectacio.idString}";
          var urlLlistarJSON = "http://"+urlServidor+"/AfectacioBosc/sequeres/llistarfotossequerajson.htm?idafectacio="+idSequera;
          var numFotos = ${dades.numFotos};
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
                    <div class="eina">
                        <h2><fmt:message key="dadesBasiques" bundle="${bundleAfectacio}" /></h2>
                        <table width="100%" class="blanc">
                            <tr><td><strong><fmt:message key="codi" bundle="${bundleAfectacio}" />:</strong></td><td>${dades.afectacio.codi}</td><td align="center" rowspan="9"><img src="<c:url value='/grafics_temp/${dades.nomFitxer}'/>" alt="mapa" /></td></tr>
                            <tr><td><strong></strong></td><td><c:if test="${dades.afectacio.nouOAntic=='N'}"><fmt:message key="episodiNou" bundle="${bundleAfectacio}" /></c:if><c:if test="${dades.afectacio.nouOAntic!='N'}"><fmt:message key="episodiAntic" bundle="${bundleAfectacio}" /></c:if></td></tr>
                            <tr><td><strong></strong></td><td><c:if test="${dades.afectacio.arbresNousAfectats=='N'}"><fmt:message key="nohihaArbresNousAfectats" bundle="${bundleAfectacio}" /></c:if><c:if test="${dades.afectacio.arbresNousAfectats!='N'}"><fmt:message key="hihaArbresNousAfectats" bundle="${bundleAfectacio}" /></c:if></td></tr>
                            <tr><td><strong><fmt:message key="coordenadesUTMPuntObservacio" bundle="${bundleAfectacio}" /></strong></td><td><strong><fmt:message key="x" bundle="${bundleAfectacio}" />:</strong>${dades.afectacio.coordenadaXPuntObservacio}&nbsp;<strong><fmt:message key="y" bundle="${bundleAfectacio}" />:</strong>${dades.afectacio.coordenadaYPuntObservacio}</td></tr>
                            <tr><td><strong><fmt:message key="coordenadesUTMCentroide" bundle="${bundleAfectacio}" /></strong></td><td><strong><fmt:message key="x" bundle="${bundleAfectacio}" />:</strong>${dades.centroide_x}&nbsp;<strong><fmt:message key="y" bundle="${bundleAfectacio}" />:</strong>${dades.centroide_y}</td></tr>
                            <tr><td><strong><fmt:message key="areaAfectadaHa" bundle="${bundleAfectacio}" /></strong></td><td>${dades.area}</td></tr>
                            <tr><td><strong><fmt:message key="orientacio" bundle="${bundleAfectacio}" />:</strong></td><td>${dades.afectacio.orientacioFoto}</td></tr>
                            <tr><td><strong><fmt:message key="data" bundle="${bundleAfectacio}" />:</strong></td><td>${dades.afectacio.dataFormatada}</td></tr>
                            <tr><td><strong><fmt:message key="codiAgent1" bundle="${bundleAfectacio}" />:</strong></td><td>${dades.afectacio.codiAgent1}</td></tr>
                            <tr><td><strong><fmt:message key="codiAgent2" bundle="${bundleAfectacio}" />:</strong></td><td>${dades.afectacio.codiAgent2}</td></tr>
                            <tr><td><strong><fmt:message key="distribucioArbresAfectats" bundle="${bundleAfectacio}" />:</strong></td><td>${dades.afectacio.distribucioArbresAfectats}</td></tr>
                            <tr><td><strong><fmt:message key="causaEpisodiDecaiment" bundle="${bundleAfectacio}" />:</strong></td><td>${dades.afectacio.causesDecaimentFormatada}</td></tr>
                            <tr><td><strong><fmt:message key="observacions" bundle="${bundleAfectacio}" />:</strong></td><td>${dades.afectacio.observacions}</td></tr>
                            <h3><fmt:message key="afectacioGeneral" bundle="${bundleAfectacio}" /></h3>
                            <table width="100%"><tr><th><fmt:message key="especie" bundle="${bundleAfectacio}" /></th>
                                <th><fmt:message key="recobriment" bundle="${bundleAfectacio}" /></th>
                                <th><fmt:message key="afectacioPercent" bundle="${bundleAfectacio}" /></th>
                                <th><fmt:message key="tipusAfectacio" bundle="${bundleAfectacio}" /></th>
                            <th><fmt:message key="arbrePercentatge" bundle="${bundleAfectacio}" /></th></tr>
                                <c:forEach items="${dades.afectacio.afectacionsEstimades}" var="element" varStatus="loopStatus">
                                <tr><td>${element.especie}</td>
                                    <td>${element.recobriment}</td>
                                    <td>${element.afectacio}</td>
                                    <td><c:if test="${element.mortalitat}">M&nbsp;</c:if><c:if test="${element.defoliacio}">DF&nbsp;</c:if><c:if test="${element.decoloracio}">&nbsp;DC&nbsp;</c:if></td>
                                    <td>${element.arbre}</td>
                                </tr>
                                </c:forEach>
                            </table>
                        </table>
                        <p><fmt:message key="descripcioTipusAfectacio" bundle="${bundleAfectacio}" /></p>
                        <hr/>
                        <div>
                            <h2><fmt:message key="caracteritzacioInSituDeLaZonaAfectada" bundle="${bundleAfectacio}" /></h2>
                            <h3><fmt:message key="caracteritzacioTopograficaZona" bundle="${bundleAfectacio}" /></h3>
                        <div class="campformulari"><div class="etiqueta"><label><fmt:message key="orientacio" bundle="${bundleAfectacio}" />:</label></div><div class="entradadades">${dades.afectacio.orientacio}</div></div>
                        <div class="campformulari"><div class="etiqueta"><label><fmt:message key="pendent" bundle="${bundleAfectacio}" />:</label></div><div class="entradadades">${dades.afectacio.pendent}</div></div>
                        <div class="campformulari"><div class="etiqueta"><label><fmt:message key="posicioPendent" bundle="${bundleAfectacio}" />:</label></div><div class="entradadades">${dades.afectacio.posicioPendent}</div></div>
                        <div class="campformulari"><div class="etiqueta"><label><fmt:message key="disposicioPendent" bundle="${bundleAfectacio}" />:</label></div><div class="entradadades">${dades.afectacio.disposicioPendent}</div></div>
                        <h3><fmt:message key="gestioForestal" bundle="${bundleAfectacio}" /></h3>
                        <div class="campformulari"><div class="etiqueta"><label><fmt:message key="tipusBosc" bundle="${bundleAfectacio}" />:</label></div><div class="entradadades">${dades.afectacio.tipusBosc}</div></div>
                        <div class="campformulari"><div class="etiqueta"><label><fmt:message key="especieDominant1" bundle="${bundleAfectacio}" />:</label></div><div class="entradadades">${dades.afectacio.especie1TipusBosc}</div></div>
                        <div class="campformulari"><div class="etiqueta"><label><fmt:message key="especieDominant2" bundle="${bundleAfectacio}" />:</label></div><div class="entradadades">${dades.afectacio.especie2TipusBosc}</div></div>
                        <div class="campformulari"><div class="etiqueta"><label><fmt:message key="especieDominant3" bundle="${bundleAfectacio}" />:</label></div><div class="entradadades">${dades.afectacio.especie3TipusBosc}</div></div>
                        <div class="campformulari"><div class="etiqueta"><label><fmt:message key="presenciaSoques" bundle="${bundleAfectacio}" />:</label></div>
                            <div class="entradadades"><c:if test="${dades.afectacio.presenciaSoquesRecents}"><fmt:message key="recents" bundle="${bundleAfectacio}" /><c:if test="${dades.afectacio.presenciaSoquesAntigues}">,&nbsp;</c:if></c:if>
                                        <c:if test="${dades.afectacio.presenciaSoquesAntigues}"><fmt:message key="antigues" bundle="${bundleAfectacio}" /></c:if></div></div>
                        <div class="campformulari"><div class="etiqueta"><label><fmt:message key="especieSoca1" bundle="${bundleAfectacio}" />:</label></div><div class="entradadades">${dades.afectacio.especie1Soca}</div></div>
                        <div class="campformulari"><div class="etiqueta"><label><fmt:message key="especieSoca2" bundle="${bundleAfectacio}" />:</label></div><div class="entradadades">${dades.afectacio.especie2Soca}</div></div>
                        <div class="campformulari"><div class="etiqueta"><label><fmt:message key="especieSoca3" bundle="${bundleAfectacio}" />:</label></div><div class="entradadades">${dades.afectacio.especie3Soca}</div></div>
                        <div class="campformulari"><div class="etiqueta"><label><fmt:message key="treballsSilvicoles" bundle="${bundleAfectacio}" />:</label></div><div class="entradadades">${dades.afectacio.treballsSilvicolesString}</div></div>
                            <h3><fmt:message key="regeneracioEspeciesForestals" bundle="${bundleAfectacio}" /></h3>
                            <table width="100%"><tr><th><fmt:message key="especie" bundle="${bundleAfectacio}" /></th>
                                <th><fmt:message key="abundancia" bundle="${bundleAfectacio}" /></th>
                                <th><fmt:message key="individus" bundle="${bundleAfectacio}" /></th></tr>
                                <c:forEach items="${dades.afectacio.regeneracionsEspeciesForestals}" var="element" varStatus="loopStatus">
                                <tr><td>${element.especie}</td>
                                    <c:if test="${element.abundancia=='0'}">
                                        <td>Baixa</td>
                                    </c:if>
                                    <c:if test="${element.abundancia=='1'}">
                                        <td>Alta</td>
                                    </c:if>
                                    <c:if test="${element.percentatgeMorts=='0'}">
                                        <td><50%</td>
                                    </c:if>
                                    <c:if test="${element.percentatgeMorts=='1'}">
                                        <td>>50%</td>
                                    </c:if>
                                </tr>
                                </c:forEach>
                            </table>
                        </div>
                        <hr/>
                        <div>
                            <div class="campformulari"><div class="etiqueta"><label></label></div><div class="entradadades">
                                <div id="tabimg">
                                    <input id="btnprevious" type="button" onclick="javascript:previousImatges();return false;" value="<" />
                                    <span id="contadorImatges"></span>
                                    <input id="btnnext" type="button" onclick="javascript:nextImatges();return false;" value=">" />
                                    <img id="loadingimatges" src="<c:url value='/grafics/rel_interstitial_loading.gif'/>" alt=""/>
                                    <div id="taulaimatges"></div>
                                    <div class="separadorPetit"></div>
                                    </div></div>
                            </div>
                        </div>
<!--                        <div>
                            <h2><fmt:message key="transecte" bundle="${bundleAfectacio}" /></h2>
                             <fmt:message key="coordenadesUTMIniciTransecte" bundle="${bundleAfectacio}" />
                            <div class="campformulari"><div class="etiqueta"><label><fmt:message key="x" bundle="${bundleAfectacio}" />:</label></div><div class="entradadades">${dades.afectacio.coordenadaXIniciTransecte}</div></div>
                            <div class="campformulari"><div class="etiqueta"><label><fmt:message key="y" bundle="${bundleAfectacio}" />:</label></div><div class="entradadades">${dades.afectacio.coordenadaYIniciTransecte}</div></div>
                            <fmt:message key="coordenadesUTMFiTransecte" bundle="${bundleAfectacio}" />
                            <div class="campformulari"><div class="etiqueta"><label><fmt:message key="x" bundle="${bundleAfectacio}" />:</label></div><div class="entradadades">${dades.afectacio.coordenadaXFiTransecte}</div></div>
                            <div class="campformulari"><div class="etiqueta"><label><fmt:message key="y" bundle="${bundleAfectacio}" />:</label></div><div class="entradadades">${dades.afectacio.coordenadaYFiTransecte}</div></div>
                            <table width="100%"><tr>
                                <th>&nbsp;</th>
                                <th><fmt:message key="especie" bundle="${bundleAfectacio}" /></th>
                                <th><fmt:message key="estrat" bundle="${bundleAfectacio}" /></th>
                                <th><fmt:message key="classeDiametrica" bundle="${bundleAfectacio}" /></th>
                                <th><fmt:message key="estatArbres" bundle="${bundleAfectacio}" /></th>
                                <th><fmt:message key="afectacioCapcada" bundle="${bundleAfectacio}" /></th>
                                <th><fmt:message key="percentFullaVerda" bundle="${bundleAfectacio}" /></th>
                                <th><fmt:message key="observacions" bundle="${bundleAfectacio}" /></th></tr>
                                <c:forEach items="${dades.afectacio.arbresTransecte}" var="element" varStatus="loopStatus">
                                <tr><td>${loopStatus.count}</td>
                                    <td>${element.especie}</td>
                                    <td><c:if test="${element.estrat!=null}" >${element.estrat}</c:if></td>
                                    <td><c:if test="${element.classeDiametrica!=null}" >${element.classeDiametrica}</c:if></td>
                                    <td><c:if test="${element.estatArbres!=null}" >${element.estatArbres}</c:if></td>
                                    <td><c:if test="${element.afectacioCapcada!=null}" >${element.afectacioCapcada}</c:if></td>
                                    <td><c:if test="${element.percentatgeFullaVerda!=null}" >${element.percentatgeFullaVerda}</c:if></td>
                                    <td><c:if test="${element.observacions!=null}" >${element.observacions}</c:if></td>
                                </tr>
                                </c:forEach>
                            </table>
                        </div>-->

                    </div>
                    <div class="peueina">
                        <%@ include file="/WEB-INF/jsp/Estructura/footerAgentsRurals.jsp" %>
                    </div>
                </div>
            </div>
            <div id="ft">
                
            </div>
        </div>
    </body>
</html>