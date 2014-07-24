<?xml version="1.0" encoding="UTF-8"?>
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
        <!--script type="text/javascript" src="<c:url value='/js/Estructura/pestanyer.js' />"></script-->
        <script type="text/javascript" src="<c:url value='/js/general.js' />"></script>
        <script type="text/javascript" src="<c:url value='/js/Processionaria/llistarProcessionaries.js' />"></script>
        <script type="text/javascript" src="<c:url value='/openlayers/OpenLayers.js' />"></script>
        <script type="text/javascript">
            var editable = false;
            <c:if test="${dades.editable}">editable = true;</c:if>
                var urlServidor = "${dades.ip}";
                if(urlServidor==""){
                    urlServidor = "${ip}";
                }
                var transparencia = 0.8;
                var urlElementsTaulaJSON = "<c:url value='/processionaria/llistarprocessionariesjson.htm?'/>";
                var txtCodi = "<fmt:message key='codi' bundle='${bundleAfectacio}' />";
                var txtComarca = "<fmt:message key='comarca' bundle='${bundleAfectacio}' />";
                var txtData = "<fmt:message key='data' bundle='${bundleAfectacio}' />";
                var txtTipusBosc = "<fmt:message key='tipus' bundle='${bundleAfectacio}' />";
                var txtOrientacio = "<fmt:message key='orientacio' bundle='${bundleAfectacio}' />";
                var txtTitolCapa = "<fmt:message key='processionaria' bundle='${bundleAfectacio}' />";
                var txtAlcada = "<fmt:message key='altitud' bundle='${bundleAfectacio}' />";
                var txtEspecie = "<fmt:message key='especie' bundle='${bundleAfectacio}' />";
                var txtGrauInfestacio = "<fmt:message key='grau' bundle='${bundleAfectacio}' />";
                var txtCodiAgent1 = "<fmt:message key='agent1' bundle='${bundleAfectacio}' />";
                var txtCodiAgent2 = "<fmt:message key='agent2' bundle='${bundleAfectacio}' />";
                var txtObservacions = "<fmt:message key='observacions' bundle='${bundleAfectacio}' />";
                var txtArea = "<fmt:message key='area' bundle='${bundleAfectacio}' />";
                txtTaula = {MSG_EMPTY:"<fmt:message key='noRecordsFound' bundle='${bundleAfectacio}' />",
                    MSG_ERROR:"<fmt:message key='error' bundle='${bundleAfectacio}' />",
                    MSG_LOADING:"<fmt:message key='carregant' bundle='${bundleAfectacio}' />",
                    MSG_SORTASC:"<fmt:message key='ordenarAsc' bundle='${bundleAfectacio}' />",
                    MSG_SORTDESC:"<fmt:message key='ordenarDesc' bundle='${bundleAfectacio}' />"}
                txtOpenlayers = {MSG_ERROR_MASSA_ELEMENTS_DIGITALITZATS: "<fmt:message key='errorDigitalitzantMassaElements' bundle='${bundleAfectacio}' />",
                    MSG_ELIMINAR: "<fmt:message key='confirmacioEliminacioElement' bundle='${bundleAfectacio}' />"}
                var urlImatgeMapaSituacio = "<c:url value='/grafics/mapa_ref.jpg' />";
                var crearCamins = false;
        </script>
        <script type="text/javascript" src="<c:url value='/js/Cartografia/mapaVisualitzacio.js' />"></script>
        <script type="text/javascript">
            var tiled = crearCapaUsuari();

            var taula = new Array(1);
            taula['AFECTACIO_GEOMETRIA'] = new Array(2);
            taula['AFECTACIO_GEOMETRIA'][0] = new Array(2);
            taula['AFECTACIO_GEOMETRIA'][0][0] = "visualitzar";
            taula['AFECTACIO_GEOMETRIA'][0][1] = Array(1);
            taula['AFECTACIO_GEOMETRIA'][0][1][0] = 0;
            taula['AFECTACIO_GEOMETRIA'][1] = new Array(4);
            taula['AFECTACIO_GEOMETRIA'][1][0] = new Array(2);
            taula['AFECTACIO_GEOMETRIA'][1][0][0] = 1;
            taula['AFECTACIO_GEOMETRIA'][1][0][1] = "<fmt:message key='codi' bundle='${bundleAfectacio}' />";
            taula['AFECTACIO_GEOMETRIA'][1][1] = new Array(2);
            taula['AFECTACIO_GEOMETRIA'][1][1][0] = 3;
            taula['AFECTACIO_GEOMETRIA'][1][1][1] = "<fmt:message key='tipusBosc' bundle='${bundleAfectacio}' />";
            taula['AFECTACIO_GEOMETRIA'][1][2] = new Array(2);
            taula['AFECTACIO_GEOMETRIA'][1][2][0] = 6;
            taula['AFECTACIO_GEOMETRIA'][1][2][1] = "<fmt:message key='especie' bundle='${bundleAfectacio}' />";
            taula['AFECTACIO_GEOMETRIA'][1][3] = new Array(2);
            taula['AFECTACIO_GEOMETRIA'][1][3][0] = 7;
            taula['AFECTACIO_GEOMETRIA'][1][3][1] = "<fmt:message key='grauinfestacio' bundle='${bundleAfectacio}' />";

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
                    layers: 'SIPAN:AFECTACIO_GEOMETRIA',
                    styles: '',
                    transparent: 'true',
                    format: 'image/png',
                    width: '800',
                    height: '600',
                    tiled: 'true'
                },
                {buffer: 0}
            );
                capa.setOpacity(0.8);
                return capa;
            }

            function nou(){
                document.dades.action = "<c:url value='/processionaria/edicio/inserir.htm'/>";
                document.dades.submit();
            }

            function enrera(){
                document.dades.action = "<c:url value='/processionaria/llistarprocessionaries.htm'/>";
                document.dades.submit();
            }

            function initPagina(){
                if(document.getElementById("alcadaMitjanaArbres")!=null){
                    document.getElementById("alcadaMitjanaArbres").disabled = true;
                }
                initMapa();
                crearCapaUsuari();
                afegirCapa(tiled);
                if(document.dades2 && document.dades2.wkt){
                    mostrarWTK(document.dades2.wkt.value);
                }else{
                    clearFeaturesMapa();
                }
                llegirCookies();
            }

            function acceptar(){
                if(validaDades()){
                    document.dades2.action = "<c:url value='/processionaria/edicio/editar.htm'/>";
                    document.dades2.wkt.value=getWKTDeObjectesDigitalitzats();
                    document.dades2.submit();
                }
            }

            function validaDades(){
                var esValid = true;
                var missatge = "<fmt:message key="errorEntradaDades" bundle="${bundleAfectacio}" />:";
                var dada = document.getElementsByName('codiAgent1')[0].value;
                if(dada==='null' || dada.trim()===''){
                    esValid = false;
                    missatge += "\n<fmt:message key="calCodiAgent1" bundle="${bundleAfectacio}" />";
                }
                var dada = document.getElementsByName('codi')[0].value;
                if(dada==='null' || dada.trim()===''){
                    esValid = false;
                    missatge += "\n<fmt:message key="calNumeroPoligon" bundle="${bundleAfectacio}" />";
                }
                var dada = document.getElementById('tipusBosc').value;
                if(dada==='null' || dada.trim()===''){
                    esValid = false;
                    missatge += "\n<fmt:message key="calTipusBosc" bundle="${bundleAfectacio}" />";
                }
                var dada = document.getElementById('especie').value;
                if(dada==='null' || dada.trim()===''){
                    esValid = false;
                    missatge += "\n<fmt:message key="calEspecie" bundle="${bundleAfectacio}" />";
                }
                var dada = document.getElementById('campdata').value;
                if(dada==='null' || dada.trim()===''){
                    esValid = false;
                    missatge += "\n<fmt:message key="calDataObservacio" bundle="${bundleAfectacio}" />";
                }
                var dada = document.getElementById('grauInfestacio').value;
                if(dada==='null' || dada.trim()===''){
                    esValid = false;
                    missatge += "\n<fmt:message key="calGrauInfestacio" bundle="${bundleAfectacio}" />";
                }
                var dada = document.getElementById('alcada').value;
                document.getElementById('alcada').value = dada.replace(",",".");
                if(dada!=='null' && dada!=='' && !isInteger(dada) && !isDouble(dada,2)){
                    esValid = false;                    
                    missatge += "\n<fmt:message key="formatAltitud" bundle="${bundleAfectacio}" />";
                }
                var dada = document.getElementById('alcadaMitjanaArbres').value;
                document.getElementById('alcadaMitjanaArbres').value = dada.replace(",",".");
                if(dada!=='null' && dada!=='' && !isInteger(dada) && !isDouble(dada,2)){
                    esValid = false;                    
                    missatge += "\n<fmt:message key="formatAlcadaMitjanaArbres" bundle="${bundleAfectacio}" />";
                }
                if(!validaData()){
                    esValid = false;
                    missatge += "\n<fmt:message key="formatDataInvalit" bundle="${bundleAfectacio}" />";
                }
                if(getElementsDigitalitzats()!=1){
                    esValid = false;
                    missatge += "\n<fmt:message key="calDigitalitzarZonaAfectada" bundle="${bundleAfectacio}" />";
                }
                if(!esValid){
                    alert(missatge);
                }
                return esValid;
            }

           

            function validaData(){
                var data=document.getElementById('campdata');
                if (isDate(data.value)==false){
                    data.focus()
                    return false
                }
                return true
            }            

            function popUpInfo(contingut){
                window.open("<c:url value='/processionaria/ajuda.htm'/>?contingut="+contingut,'popup','width=970,height=550,scrollbars=YES,resizable=YES,left=0');
            }

            function visualitzar(id){
                window.open("<c:url value='/processionaria/imprimirprocessionaria.htm'/>?idafectacio="+id,'popup','width=970,height=550,scrollbars=YES,resizable=YES,left=0');
            }

            function esborrar(id){
                if(confirm("<fmt:message key='confirmacio' bundle='${bundleSIPAN}' />")){
                    document.dades.idafectacio.value = id;
                    document.dades.novaurl.value = "/processionaria/llistarprocessionaries.htm";
                    document.dades.action = "<c:url value='/processionaria/edicio/esborrar.htm'/>?";
                    document.dades.submit();
                }
            }

            function canviTipusBosc() {                
                var tbIndex = document.dades2.tipusBosc.selectedIndex;
                if(tbIndex==2){
                    document.getElementById("alcadaMitjanaArbres").disabled = false;
                }else{
                    document.getElementById("alcadaMitjanaArbres").disabled = true;
                }
            }


            function llegirCookies(){
                var left = readCookie('left');
                var right = readCookie('right');
                var bottom = readCookie('bottom');
                var top = readCookie('top');
                if(left!=null && right!=null && bottom!=null && top!=null){
                    var bounds = new OpenLayers.Bounds(left, bottom, right, top);
                    map.zoomToExtent(bounds);
                }
            }

            function escriureCookies(){
                document.cookie = "left="+map.getExtent().left+"; path=/";
                document.cookie = "right="+map.getExtent().right+"; path=/";
                document.cookie = "bottom="+map.getExtent().bottom+"; path=/";
                document.cookie = "top="+map.getExtent().top+"; path=/";
            }

            function exitPagina(){
                escriureCookies();
            }

            YAHOO.util.Event.onContentReady("bloc_control_mapa", function () {
                var oPushButton2 = new YAHOO.widget.Button("botodigitalitzar", { onclick: { fn: onClickDigitalitzar } });

            });
        </script>

        <%
                    boolean esEditable = false;
                    cat.creaf.afectaciobosc.model.Processionaria processionaria = ((cat.creaf.afectaciobosc.model.Processionaria) request.getAttribute("processionaria"));
                    if (processionaria != null
                            && !(processionaria.getEstat() == MSIPANBasicObj.ObjecteSIPAN.NO_MODIFICAT
                            && "-1".equals(processionaria.getIdString()))) {
                        esEditable = true;
                    }

        %>

    </head>
    <body onload="javascript:initPagina();" onunload="javascript:exitPagina();return false;" class="yui-skin-sam">
        <div id="doc" class="yui-d2">
            <div id="hd">
                <%@ include file="/WEB-INF/jsp/Estructura/header.jsp" %>
            </div>
            <div id="bd">
                <div class="modul mprocessionaria">
                    <%@ include file="/WEB-INF/jsp/Estructura/menu.jsp" %>
                    <a href="#" onclick="javascript:obrirpopup('<c:url value='/grafics/ajuda_processionaria.pdf'/>');return false;" title="<fmt:message key='ajuda' bundle='${bundleSIPAN}' />"><fmt:message key='protocol' bundle='${bundleAfectacio}' /></a>
                    <a href="#" onclick="javascript:obrirpopup('<c:url value='/grafics/fitxa_camp_processionaria.pdf'/>');return false;" title="<fmt:message key="fitxaNevadesCampPDF" bundle="${bundleAfectacio}" />"><fmt:message key="fitxaNevadesCampPDF" bundle="${bundleAfectacio}" /></a>
                    <c:if test="${dades.llistableShape}">
                    <div class="eines_fitxa">
                        <a class="veure_shape" href="http://${dades.ip}/geoserver/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=SIPAN:AFECTACIO_GEOMETRIA&outputFormat=SHAPE-ZIP"   title="<fmt:message key="exportarShape" bundle="${bundleSIPAN}" />">&nbsp;</a>
                    </div>
                    </c:if>
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
                                        <input type="button" id="botodigitalitzar" name="botodigitalitzar" class="botodigitalitzar" alt="<fmt:message key="digitalitzarPoligon" bundle="${bundleAfectacio}" />" onclick="javascript:toggleControl('polygon');return false;"/>
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

                                    <spring:nestedPath path="processionaria">

                                        <h3><fmt:message key="dadesBasiques" bundle="${bundleAfectacio}" /></h3>
                                        <c:set var="txtCodiAgent1">*&nbsp;<fmt:message key="codiAgent1" bundle="${bundleAfectacio}" /></c:set>
                                        <tag:inputFormText etiqueta="${txtCodiAgent1}" tamany="complet" path="codiAgent1"/>
                                        <c:set var="txtCodiAgent2"><fmt:message key="codiAgent2" bundle="${bundleAfectacio}" /></c:set>
                                        <tag:inputFormText etiqueta="${txtCodiAgent2}" tamany="complet" path="codiAgent2"/>
                                        <c:set var="txtCodi">*&nbsp;<fmt:message key="codi" bundle="${bundleAfectacio}" /></c:set>
                                        <tag:inputFormText etiqueta="${txtCodi}" tamany="complet" path="codi" />

                                        <%
                                             request.setAttribute("llista", request.getAttribute("comarques"));
                                             request.setAttribute("objecteSeleccionat", processionaria.getComarca());
                                        %>
                                        <c:set var="txtComarca"><fmt:message key="comarca" bundle="${bundleAfectacio}" /></c:set>
                                        <tag:inputFormCombo etiqueta="${txtComarca}"  tamany="complet" path="comarca" />

                                        <div class="campformulari"><div class="etiqueta"><label for="tipusBosc" >*&nbsp;<fmt:message key="tipusBosc" bundle="${bundleAfectacio}" /></label></div>
                                            <div class="entradadades">
                                                <select id="tipusBosc" name="tipusBosc" class="complet" onchange="javascript:canviTipusBosc();return false;">
                                                    <option id="null" value="null" selected></option>
                                                    <option id="TB001" value="TB001">Bosc natural</option>
                                                    <option id="TB002" value="TB002">Repoblació</option>
                                                </select></div></div>
                                        <c:set var="txtAlcadaMitjanaArbres"><fmt:message key="alcadaMitjanaArbres" bundle="${bundleAfectacio}" /></c:set>
                                        <tag:inputFormText etiqueta="${txtAlcadaMitjanaArbres}" tamany="complet" path="alcadaMitjanaArbres" identificador="alcadaMitjanaArbres" />


                                        <%
                                             request.setAttribute("llista", request.getAttribute("orientacions"));
                                             request.setAttribute("objecteSeleccionat", processionaria.getOrientacio());
                                        %>
                                        <c:set var="txtOrientacio"><fmt:message key="orientacio" bundle="${bundleAfectacio}" /></c:set>
                                        <tag:inputFormCombo etiqueta="${txtOrientacio}"  tamany="complet" path="orientacio" />

                                        <%
                                             request.setAttribute("llista", request.getAttribute("especies"));
                                             request.setAttribute("objecteSeleccionat", processionaria.getEspecie());
                                        %>
                                        <c:set var="txtEspecie">*&nbsp;<fmt:message key="especie" bundle="${bundleAfectacio}" /></c:set>
                                        <tag:inputFormCombo etiqueta="${txtEspecie}"  tamany="complet" path="especie" />

                                        <c:set var="txtData">*&nbsp;<fmt:message key="dataObservacio" bundle="${bundleAfectacio}" /></c:set>
                                        <tag:inputFormText etiqueta="${txtData}" tamany="complet" path="data" identificador="campdata"/>
                                        <c:set var="txtAlcada"><fmt:message key="altitud" bundle="${bundleAfectacio}" /></c:set>
                                        <tag:inputFormText etiqueta="${txtAlcada}" tamany="complet" path="alcada" identificador="alcada"/>
                                        
                                        <%
                                             request.setAttribute("llista", request.getAttribute("grausinfestacio"));
                                             request.setAttribute("objecteSeleccionat", processionaria.getGrauInfestacio());
                                        %>
                                        <c:set var="txtGrau">*&nbsp;<fmt:message key="grauinfestacio" bundle="${bundleAfectacio}" /></c:set>
                                        <tag:inputFormCombo etiqueta="${txtGrau}"  tamany="complet" path="grauInfestacio" />                                        
                                        <c:set var="txtObservacions"><fmt:message key="observacions" bundle="${bundleAfectacio}" /></c:set>
                                        <tag:inputFormTextarea etiqueta="${txtObservacions}" tamany="completTextArea" path="observacions" />

                                        <div class="campformulari"><div class="etiqueta"></div><div class="entradadades"><fmt:message key="campsObligatoris" bundle="${bundleAfectacio}" /></div></div>
                                        
                                        <div class="campformulari"><div class="etiqueta"></div>
                                            <div class="entradadades">
                                                <div id="botonera" class="botonera">
                                                    <input type="button" value="<fmt:message key="desar" bundle="${bundleSIPAN}" />" onclick="javascript:acceptar()" class="boto" />
                                                    <input type="button" value="<fmt:message key="cancelar" bundle="${bundleSIPAN}" />" onclick="javascript:enrera()" class="boto" />
                                                </div>
                                            </div>
                                        </div>
                                        <input type="hidden" name="idprocessionaria" value='${processionaria.idString}'/>
                                        <input type="hidden" name="wkt" value='${processionaria.areaAfectadaWtk}'/>
                                        <input type="hidden" name="primerelement" value='${primerelement}'/>
                                        <input type="hidden" name="numelements" value='${numelements}'/>
                                        <input type="hidden" name="operacio" value=''/>
                                    </spring:nestedPath>

                                </form>
                                <%} else {%>
                                <div class="divbotonou">
                                    <%--<input type="button" value="<fmt:message key="afegirNova" bundle="${bundleAfectacio}" />" onclick="javascript:nou()" class="boto"/>--%>
                                    <img id="boto_processionaria" src="<c:url value='/grafics/boto_processionaria.png' />" onclick="javascript:nou()" class="boto" alt="nou"/>
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
            <input type="hidden" name="idafectacio" value='${idprocessionaria}'/>
            <input type="hidden" name="idprocessionaria" value='${idprocessionaria}'/>
            <input type="hidden" name="novaurl" value=''/>
            <input type="hidden" name="primerelement" value='${primerelement}'/>
            <input type="hidden" name="numelements" value='${numelements}'/>
        </form>
    </body>
</html>