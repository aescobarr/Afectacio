<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<html xml:lang="ca" lang="ca" xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>SISTEMA D'INFORMACI&Oacute; D'AFECTACI&Oacute; DELS BOSCOS DE CATALUNYA</title>
        <meta HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE"/>
        <meta HTTP-EQUIV="EXPIRES" CONTENT="0"/>
        <meta HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta http-equiv="Content-Style-Type" content="text/css" />
        <fmt:setBundle var="bundleSIPAN" basename="Literals.MSIPAN"/>
        <fmt:setBundle var="bundleAfectacio" basename="cat.creaf.afectaciobosc.literals.AfectacioBosc"/>
        <link rel="shortcut icon" href="<c:url value='/grafics/afectacio_ico_nav.ico' />"/>
        <link rel="stylesheet" type="text/css" href="<c:url value='/css/sipan.css' />" />
        <link rel="stylesheet" type="text/css" href="<c:url value='/css/estilAfectacio.css' />" />
        <%@ include file="/WEB-INF/jsp/Estructura/yui-sipan.jsp" %>
        <%@ include file="/WEB-INF/jsp/Estructura/configJS.jsp" %>
        <script type="text/javascript" src="<c:url value='/js/Nevades/llistarNevades.js' />"></script>
        <script type="text/javascript" src="<c:url value='/openlayers/OpenLayers.js' />"></script>
        <script type="text/javascript" src="<c:url value='/js/general.js' />"></script>
        <script type="text/javascript">
            var editable = false;
            <c:if test="${dades.editable}">editable = true;</c:if>
                var urlServidor = "${dades.ip}";
                if(urlServidor==""){
                    urlServidor = "${ip}";
                }
                var transparencia = 0.8;
                var urlElementsTaulaJSON = "http://" + urlServidor + "<c:url value='/nevades/llistarnevadesjson.htm?'/>";
                var txtCodiAgent1 = "<fmt:message key='agent1' bundle='${bundleAfectacio}' />";
                var txtCodiAgent2 = "<fmt:message key='agent2' bundle='${bundleAfectacio}' />";
                var txtCodi = '<fmt:message key="numeroAbreviat" bundle="${bundleAfectacio}" />';
                var txtComarca = '<fmt:message key="comarca" bundle="${bundleAfectacio}" />';
                var txtTerme = '<fmt:message key="terme" bundle="${bundleAfectacio}" />';
                var txtLongitudKm = '<fmt:message key="longitud" bundle="${bundleAfectacio}" />';
                var txtNomCami = '<fmt:message key="cami" bundle="${bundleAfectacio}" />';
                var txtData = '<fmt:message key="data" bundle="${bundleAfectacio}" />';
                var txtTipusBosc = '<fmt:message key="tipusBosc" bundle="${bundleAfectacio}" />';
                var txtOrientacio = '<fmt:message key="orientacio" bundle="${bundleAfectacio}" />';
                var txtTitolCapa = '<fmt:message key="processionaria" bundle="${bundleAfectacio}" />';
                var txtAlcada = '<fmt:message key="altitud" bundle="${bundleAfectacio}" />';
                var txtEspecie = '<fmt:message key="especie" bundle="${bundleAfectacio}" />';
                var txtGrauInfestacio = '<fmt:message key="grauinfestacio" bundle="${bundleAfectacio}" />';
                var txtObservacions = '<fmt:message key="observacions" bundle="${bundleAfectacio}" />';
                var txtArea = '<fmt:message key="area" bundle="${bundleAfectacio}" />';
                var txtPistaParcial = '<fmt:message key="margeParcial2" bundle="${bundleAfectacio}" />';
                var txtPistaTotal = '<fmt:message key="margeTotal1" bundle="${bundleAfectacio}" />';
                var txtFranjaParcial = '<fmt:message key="interiorParcial4" bundle="${bundleAfectacio}" />';
                var txtFranjaTotal = '<fmt:message key="interiorTotal3" bundle="${bundleAfectacio}" />';
                var txtPeusAfectats = "<fmt:message key='peusAfectatsHa' bundle='${bundleAfectacio}' />";
                var txtNivellAfectacio = "<fmt:message key='nivellAfectacio' bundle='${bundleAfectacio}' />";
                var txtDanyModerat = "<fmt:message key='danyModerat' bundle='${bundleAfectacio}' />";
                var txtDanyGreu = "<fmt:message key='danyGreu' bundle='${bundleAfectacio}' />";
                var txtDanyMoltGreu = "<fmt:message key='danyMoltGreu' bundle='${bundleAfectacio}' />";
                var txtDanyExtrem = "<fmt:message key='danyExtrem' bundle='${bundleAfectacio}' />";
                var txtErrorEdicioCelaEnter = "<fmt:message key='errorEdicioCelaEnter' bundle='${bundleAfectacio}' />";
                
                var urlImatgeMapaSituacio = "<c:url value='/grafics/mapa_ref.jpg' />";
                var especiesAOferir = "";
            <c:if test="${especiesAOferir!=null}">
                especiesAOferir = ${especiesAOferir};
            </c:if>
                var dadesObservacions = {observacions:""};
            <c:if test="${observacionsjson!=null}">
                dadesObservacions = {observacions:${observacionsjson}};
            </c:if>
                var crearCamins = true;
        </script>
        <script type="text/javascript" src="<c:url value='/js/Cartografia/mapaVisualitzacio.js' />"></script>
        <script type="text/javascript">
            var tiled = crearCapaUsuari();

            var taula = new Array(1);
            taula['NEVADES_GEOMETRIA'] = new Array(2);
            taula['NEVADES_GEOMETRIA'][0] = new Array(2);
            taula['NEVADES_GEOMETRIA'][0][0] = "visualitzar";
            taula['NEVADES_GEOMETRIA'][0][1] = Array(1);
            taula['NEVADES_GEOMETRIA'][0][1][0] = 0;
            taula['NEVADES_GEOMETRIA'][1] = new Array(2);
            taula['NEVADES_GEOMETRIA'][1][0] = new Array(2);
            taula['NEVADES_GEOMETRIA'][1][0][0] = 1;
            taula['NEVADES_GEOMETRIA'][1][0][1] = "<fmt:message key='codi' bundle='${bundleAfectacio}' />";
            taula['NEVADES_GEOMETRIA'][1][1] = new Array(2);
            taula['NEVADES_GEOMETRIA'][1][1][0] = 2;
            taula['NEVADES_GEOMETRIA'][1][1][1] = "<fmt:message key='cami' bundle='${bundleAfectacio}' />";

            function crearCapaUsuari(){
                var urlServidor = "${dades.ip}";
                if(urlServidor==""){
                    urlServidor = "${ip}";
                }
                var capa;
                var urlCapa = "http://"+ urlServidor + "/geoserver/wms";
                capa = new OpenLayers.Layer.WMS(
                "<fmt:message key='afectacio' bundle='${bundleAfectacio}' />",
                "http://"+ urlServidor + "/geoserver/wms",
                {
                    layers: 'SIPAN:NEVADES_GEOMETRIA',
                    styles: '',
                    transparent: 'true',
                    format: 'image/png',
                    width: '800',
                    height: '600',
                    tiled: 'true'
                },
                {buffer: 0}
            );
                capa.setOpacity(1);
                return capa;
            }

            function nou(){
                document.dades.action = "<c:url value='/nevades/edicio/inserir.htm'/>";
                document.dades.submit();
            }

            function enrera(){
                document.dades.action = "<c:url value='/nevades/llistarnevades.htm'/>";
                document.dades.submit();
            }

            function initPagina(){
                initMapa();
                afegirCapa(tiled);
                if(document.dades2 && document.dades2.wkt){
                    mostrarWTK(document.dades2.wkt.value);
                }else{
                    clearFeaturesMapa();
                }
            }

            function acceptar(){
                if(validaDades()){
                    getDadesObservacions();
                    document.dades2.action = "<c:url value='/nevades/edicio/editar.htm'/>";
                    document.dades2.wkt.value=getWKTDeObjectesDigitalitzats();
                    document.dades2.submit();
                }
            }

            function validaDades(){
                var esValid = true;
                var missatge = "<fmt:message key="errorEntradaDades" bundle="${bundleAfectacio}" />:";
                var dada = document.getElementsByName('codi')[0].value;
                if(dada==='null' || dada.trim()===''){
                    esValid = false;
                    missatge += "\n<fmt:message key="calNumTram" bundle="${bundleAfectacio}" />";
                }
                var dada = document.getElementById('comarca').value;
                if(dada==='null' || dada.trim()===''){
                    esValid = false;
                    missatge += "\n<fmt:message key="calComarca" bundle="${bundleAfectacio}" />";
                }
                var dada = document.getElementById('terme').value;
                if(dada==='null' || dada.trim()===''){
                    esValid = false;
                    missatge += "\n<fmt:message key="calTerme" bundle="${bundleAfectacio}" />";
                }
                var dada = document.getElementsByName('nomCami')[0].value;
                if(dada==='null' || dada.trim()===''){
                    esValid = false;
                    missatge += "\n<fmt:message key="calNomCami" bundle="${bundleAfectacio}" />";
                }
                var dada = document.getElementsByName('longitudKmString')[0].value;
                if(dada==='null' || dada.trim()==='' || 
                    (!isInteger(dada) && !isDouble(dada,2))){
                    esValid = false;
                    missatge += "\n<fmt:message key="calLongitudKm" bundle="${bundleAfectacio}" />";
                }
                if(getElementsDigitalitzats()!=2){
                    esValid = false;
                    missatge += "\n<fmt:message key="calDigitalitzarDosPunts" bundle="${bundleAfectacio}" />";
                }
                if(!esValid){
                    alert(missatge);
                }
                return esValid;
            }

            function visualitzar(id){
                window.open("<c:url value='/nevades/imprimirnevades.htm'/>?idafectacio="+id,'popup','width=970,height=550,scrollbars=YES,resizable=YES,left=0');
            }

            function esborrar(id){
                if(confirm("<fmt:message key='confirmacio' bundle='${bundleSIPAN}' />")){
                    document.dades.idafectacio.value = id;
                    document.dades.novaurl.value = "/nevades/llistarnevades.htm";
                    document.dades.action = "<c:url value='/nevades/edicio/esborrar.htm'/>?";
                    document.dades.submit();
                }
            }

            YAHOO.util.Event.onContentReady("bloc_control_mapa", function () {
                var oPushButton2 = new YAHOO.widget.Button("botodigitalitzar", { onclick: { fn: onClickDigitalitzar } });
            });
        </script>

        <%
                    boolean esEditable = false;
                    cat.creaf.afectaciobosc.model.Nevada nevada = ((cat.creaf.afectaciobosc.model.Nevada) request.getAttribute("nevada"));
                    if (nevada != null
                            && !(nevada.getEstat() == MSIPANBasicObj.ObjecteSIPAN.NO_MODIFICAT
                            && "-1".equals(nevada.getIdString()))) {
                        esEditable = true;
                    }
        %>

    </head>
    <body onload="javascript:initPagina();" class="yui-skin-sam">
        <div id="doc" class="yui-d2">
            <div id="hd">
                <%@ include file="/WEB-INF/jsp/Estructura/header.jsp" %>
            </div>
            <div id="bd">
                <div class="modul mnevades">
                    <%@ include file="/WEB-INF/jsp/Estructura/menu.jsp" %>
                    <a href="#" onclick="javascript:obrirpopup('<c:url value='/grafics/ajuda_nevades.pdf'/>');return false;" title="<fmt:message key='ajuda' bundle='${bundleSIPAN}' />"><fmt:message key='ajuda' bundle='${bundleSIPAN}' /></a>&nbsp;
                    <a href="#" onclick="javascript:obrirpopup('<c:url value='/grafics/fitxa_neu_v2.pdf'/>');return false;" title="<fmt:message key="fitxaNevadesCampPDF" bundle="${bundleAfectacio}" />"><fmt:message key="fitxaNevadesCampPDF" bundle="${bundleAfectacio}" /></a>
                    <div class="eina">
                        <div id="mapa">
                            <div class="divmapa">
                                <div id="map" class="mapafectacio"></div>
                                <div class="anar_carto">
                                    <div id="container"></div>
                                </div>
                                <div class="anar_carto">
                                    <div class="element_anar_carto">
                                        <input type="button" id="botomoure" name="botomoure" class="botomoure" alt="<fmt:message key='moureMapa' bundle='${bundleAfectacio}' />"  onclick="javascript:toggleControl('moure');return false;"/>
                                        <input type="button" id="botozoomfinestra" name="botozoomfinestra" class="botozoomfinestra" alt="<fmt:message key='zoomFinestra' bundle='${bundleAfectacio}' />" onclick="javascript:toggleControl('zoom');return false;"/>
                                        <input type="button" id="botoinfo" name="botoinfo" class="botoinfo" alt="<fmt:message key='informacio' bundle='${bundleAfectacio}' />" onclick="javascript:toggleControl('info');return false;"/>
                                    </div>
                                    <% if (esEditable) {%>
                                    <div  class="element_anar_carto" id="controlToggle">
                                        <input type="button" id="botodigitalitzar" name="botodigitalitzar" class="botodigitalitzarpunt" alt="<fmt:message key="digitalitzarPunt" bundle="${bundleAfectacio}" />" onclick="javascript:toggleControl('point');return false;"/>
                                        <input type="button" id="botoesborrar" name="botoesborrar" class="botoesborrar" alt="<fmt:message key="esborrarElementMapa" bundle="${bundleAfectacio}" />" onclick="javascript:toggleControl('remove');return false;" />
                                    </div>
                                    <%}%>
                                    <div  class="element_anar_carto">
                                        <div id="coordenades"></div>
                                    </div>
                                </div>
                                <%@ include file="/WEB-INF/jsp/Estructura/filtregeo.jsp" %>
                            </div>
                        </div>
                        <div class="continguteina">                            
                            <div class="diventradaDades" id="fitxa">                                

                                <% if (esEditable) {%>
                                <form name="dades2" method="POST" action="">

                                    <spring:nestedPath path="nevada">

                                        <h3><fmt:message key="dadesBasiques" bundle="${bundleAfectacio}" /></h3>
                                        <c:set var="txtCodiAgent1">*&nbsp;<fmt:message key="codiAgent1" bundle="${bundleAfectacio}" /></c:set>
                                        <tag:inputFormText etiqueta="${txtCodiAgent1}" tamany="complet" path="codiAgent1"/>
                                        <c:set var="txtCodiAgent2"><fmt:message key="codiAgent2" bundle="${bundleAfectacio}" /></c:set>
                                        <tag:inputFormText etiqueta="${txtCodiAgent2}" tamany="complet" path="codiAgent2"/>
                                        <c:set var="txtCodi">*&nbsp;<fmt:message key="numTram" bundle="${bundleAfectacio}" /></c:set>
                                        <tag:inputFormText etiqueta="${txtCodi}" tamany="complet" path="codi" />
                                        <c:set var="txtNomCami">*&nbsp;<fmt:message key="nomCami" bundle="${bundleAfectacio}" /></c:set>
                                        <tag:inputFormText etiqueta="${txtNomCami}" tamany="complet" path="nomCami"/>
                                        <%
                                             request.setAttribute("llista", request.getAttribute("comarques"));
                                             request.setAttribute("objecteSeleccionat", nevada.getComarca());
                                        %>
                                        <c:set var="txtComarca">*&nbsp;<fmt:message key="comarca" bundle="${bundleAfectacio}" /></c:set>
                                        <tag:inputFormCombo etiqueta="${txtComarca}"  tamany="complet" path="comarca" />
                                        <%
                                             request.setAttribute("llista", request.getAttribute("municipis"));
                                             request.setAttribute("objecteSeleccionat", nevada.getTerme());
                                        %>
                                        <c:set var="txtTerme">*&nbsp;<fmt:message key="municipi" bundle="${bundleAfectacio}" /></c:set>
                                        <tag:inputFormCombo etiqueta="${txtTerme}"  tamany="complet" path="terme" />                                      
                                        <c:set var="txtLongitudKm">*&nbsp;<fmt:message key="longitudKm" bundle="${bundleAfectacio}" /></c:set>
                                        <tag:inputFormText etiqueta="${txtLongitudKm}" tamany="complet" path="longitudKmString"/>
                                        <strong><fmt:message key="nota" bundle="${bundleAfectacio}" />:</strong><fmt:message key="notaAmplada" bundle="${bundleAfectacio}" />
                                        <c:set var="txtObservacions"><fmt:message key="observacions" bundle="${bundleAfectacio}" /></c:set>
                                        <tag:inputFormTextarea etiqueta="${txtObservacions}" tamany="completTextArea" path="observacions" />

                                        <div id="dadesobservacions" class="scroll campformulari">
                                            <div class="scroll tauladadesobservacions">
                                            <input class="linkAfegir" type="button" id="afegir" name="afegir" value="<fmt:message key="afegir" bundle="${bundleSIPAN}" />" />
                                            <div id="taulaobservacions"></div>
                                            <input type="hidden" id="idsDadesObservacions" name="idsDadesObservacions" value="" />
                                            <fmt:message key="explicacioEntradaTaulaObservacions" bundle="${bundleAfectacio}" />
                                            </div>
                                        </div>
                                        <div class="campformulari"><div class="etiqueta"></div>
                                            <div class="entradadades">
                                                <div id="botonera" class="botonera">
                                                    <input type="button" value="<fmt:message key="desar" bundle="${bundleSIPAN}" />" onclick="javascript:acceptar()" class="boto" />
                                                    <input type="button" value="<fmt:message key="cancelar" bundle="${bundleSIPAN}" />" onclick="javascript:enrera()" class="boto" />
                                                </div>
                                            </div>
                                        </div>
                                        <input type="hidden" name="idnevada" value='${processionaria.idString}'/>
                                        <input type="hidden" name="wkt" value='${processionaria.areaAfectadaWtk}'/>
                                        <input type="hidden" name="primerelement" value='${primerelement}'/>
                                        <input type="hidden" name="numelements" value='${numelements}'/>
                                        <input type="hidden" name="operacio" value=''/>
                                    </spring:nestedPath>

                                </form>
                                <%} else {%>
                                <div class="divbotonou">
                                    <img id="boto_processionaria" src="<c:url value='/grafics/boto_nevada.png' />" onclick="javascript:nou()" class="boto" alt="nou"/>
                                </div>
                                <%}%>
                            </div>
                            <div class="yui-content">
                                <div id="llistat">                                    
                                    <div id="taulaDinamica">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="peueina">

                        </div>
                    </div>

                </div>
            </div>
            <div id="ft">
                <%@ include file="/WEB-INF/jsp/Estructura/footerAgentsRurals.jsp" %>
            </div>
        </div>
        <form name="dades" method="get" action="">
            <input type="hidden" name="idafectacio" value=''/>
            <input type="hidden" name="novaurl" value=''/>
            <input type="hidden" name="primerelement" value='${primerelement}'/>
            <input type="hidden" name="numelements" value='${numelements}'/>
        </form>
    </body>
</html>