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
        <%@ include file="/WEB-INF/jsp/Estructura/configJS.jsp" %>        
        <script type="text/javascript" src="<c:url value='/openlayers/OpenLayers.js' />"></script>
        <script type="text/javascript" src="<c:url value='/js/general.js' />"></script>
        <script type="text/javascript" src="<c:url value='/js/Estructura/pestanyer.js' />"></script>
        <script type="text/javascript">
            var editable = false;
            var esborrable = false;
            <c:if test="${editable}">editable = true;</c:if>
            <c:if test="${esborrable}">esborrable = true;</c:if>
                var urlServidor = "${ip}";
                if(urlServidor==""){
                    urlServidor = "${ip}";
                }
                var transparencia = 0.8;
                var urlElementsTaulaJSON = "http://" + urlServidor + "<c:url value='/danysabiotics/llistardanysabioticsjson.htm?'/>";
                var txtDistribucio = "<fmt:message key='distribucioArbresAfectats' bundle='${bundleAfectacio}' />";
                var txtCodi = '<fmt:message key="codi" bundle="${bundleAfectacio}" />';
                var txtDataEpisodi = '<fmt:message key="dataEpisodi" bundle="${bundleAfectacio}" />';
                var txtTipusBosc = '<fmt:message key="tipusBosc" bundle="${bundleAfectacio}" />';
                var txtOrientacio = '<fmt:message key="orientacio" bundle="${bundleAfectacio}" />';
                var txtTitolCapa = '<fmt:message key="processionaria" bundle="${bundleAfectacio}" />';
                var txtAlcada = '<fmt:message key="altitud" bundle="${bundleAfectacio}" />';
                var txtEstrat = '<fmt:message key="estrat" bundle="${bundleAfectacio}" />';
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
                var txtAbundancia = "<fmt:message key='abundancia' bundle='${bundleAfectacio}' />";
                var txtIndividus = "<fmt:message key='individus' bundle='${bundleAfectacio}' />";
                var txtRecobriment = "<fmt:message key='recobriment' bundle='${bundleAfectacio}' />";
                var txtAfectacio = "<fmt:message key='afectacioPercent' bundle='${bundleAfectacio}' />";

                var txtEstrat = "<fmt:message key='estrat' bundle='${bundleAfectacio}' />";
                var txtClasseDiametrica = "<fmt:message key='classeDiametrica' bundle='${bundleAfectacio}' />";
                var txtEstatArbres = "<fmt:message key='estatArbres' bundle='${bundleAfectacio}' />";
                var txtAfectacioCapcada = "<fmt:message key='afectacioCapcada' bundle='${bundleAfectacio}' />";
                var txtFullaVerda = "<fmt:message key='percentFullaVerda' bundle='${bundleAfectacio}' />";
                var txtObservacions = "<fmt:message key='observacions' bundle='${bundleAfectacio}' />";

                var txtErrorEdicioCelaPercentatge = "<fmt:message key='errorEdicioCelaPercentatge' bundle='${bundleAfectacio}' />";

                var crearCamins = false;
                var urlImatgeMapaSituacio = "<c:url value='/grafics/mapa_ref.jpg' />";

                var txtComarca = "<fmt:message key='comarca' bundle='${bundleAfectacio}' />";
                var txtEspecie1 = "<fmt:message key='especie' bundle='${bundleAfectacio}' /> 1";
                var txtGrauAfectacio = "<fmt:message key='grauAfectacio' bundle='${bundleAfectacio}' />";
                var txtEnginyer1 = "<fmt:message key='enginyer' bundle='${bundleAfectacio}' /> 1";
                var txtEnginyer2 = "<fmt:message key='enginyer' bundle='${bundleAfectacio}' /> 2";

                var especiesAOferir = "";
            <c:if test="${especiesAOferir!=null}">
                especiesAOferir = ${especiesAOferir};
            </c:if>
                var dadesRegeneracio = {regeneracio:""};
            <c:if test="${regeneraciojson!=null}">
                dadesRegeneracio = {regeneracio:${regeneraciojson}};
            </c:if>

                var dadesEstimacions = {estimacions:""};
            <c:if test="${estimacionsjson!=null}">
                dadesEstimacions = {estimacions:${estimacionsjson}};
            </c:if>

                var dadesTransecte = {arbres:""};
            <c:if test="${arbrestransectejson!=null}">
                dadesTransecte = {arbres:${arbrestransectejson}};
            </c:if>
        </script>
        <script type="text/javascript" src="<c:url value='/js/DanysAbiotics/editarDanyAbiotic.js' />"></script>
        <script type="text/javascript" src="<c:url value='/js/Cartografia/mapaVisualitzacio.js' />"></script>
        <script type="text/javascript">
            var tiled = crearCapaUsuariAnterior();
//            var tiledPEIN = crearCapaPEIN();

            var taula = new Array(1);
            taula['DANYABIOTIC_GEOMETRIA'] = new Array(2);
            taula['DANYABIOTIC_GEOMETRIA'][0] = new Array(2);
            taula['DANYABIOTIC_GEOMETRIA'][0][0] = "visualitzar";
            taula['DANYABIOTIC_GEOMETRIA'][0][1] = Array(1);
            taula['DANYABIOTIC_GEOMETRIA'][0][1][0] = 0;
            taula['DANYABIOTIC_GEOMETRIA'][1] = new Array(1);
            taula['DANYABIOTIC_GEOMETRIA'][1][0] = new Array(2);
            taula['DANYABIOTIC_GEOMETRIA'][1][0][0] = 1;
            taula['DANYABIOTIC_GEOMETRIA'][1][0][1] = "<fmt:message key='codi' bundle='${bundleAfectacio}' />";

            
            function crearCapaUsuariAnterior(){
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
                    layers: 'SIPAN:DANYABIOTIC_GEOMETRIA',
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
      /*
            function crearCapaPEIN(){
                var capa = new OpenLayers.Layer.WMS(
                    "PEIN","http://"+urlServidor+"/geoserver/gwc/service/wms",
                    {
                        layers: 'SIPAN:ENPS_PEIN_GEOMETRIA',
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
                capa.setVisibility(true);
                return capa;
            }*/

            function nou(){
                document.dades.idafectacio.value = "-1";
                document.dades.action = "<c:url value='/danysabiotics/edicio/inserir.htm'/>";
                document.dades.submit();
            }

            function enrera(){
                document.dades.action = "<c:url value='/danysabiotics/llistardanysabiotics.htm'/>";
                document.dades.submit();
            }

            function initPagina(){
                initCheckboxesDates();
                initMapa();
//                afegirCapa(tiledPEIN);
                afegirCapa(tiled);
                if(document.formAfectacio && document.formAfectacio.wkt){
                    mostrarWTK(document.formAfectacio.wkt.value);
                }else{
                    clearFeaturesMapa();
                }
                llegirCookies();
            }

            function initCheckboxesDates(){
                document.getElementById('dataApreciacioInicial').disabled = true;
                document.getElementById('dataDadesDefinitives').disabled = true;
                document.getElementById('dataValidacio').disabled = true;
                <c:if test="${afectacio.dataApreciacioInicial!=null}">
                    document.getElementById('chckapreciacioinicial').checked = true;
                    document.getElementById('dataApreciacioInicial').disabled = false;
                </c:if>
                <c:if test="${afectacio.dataDadesDefinitives!=null}">
                    document.getElementById('chckdadesdefinitives').checked = true;
                    document.getElementById('dataDadesDefinitives').disabled = false;
                </c:if>
                <c:if test="${afectacio.dataValidacio!=null}">
                    document.getElementById('chckvalidacio').checked = true;
                    document.getElementById('dataValidacio').disabled = false;
                </c:if>
            }

            function acceptar(){
                acceptarIAnar("/danysabiotics/edicio/editar.htm");
            }

            function acceptarISortir(){
                acceptarIAnar("/danysabiotics/llistardanysabiotics.htm");
            }

            function acceptarIAnar(novaurl){
                if(validaDades()){
                    getDadesEstimacions();
                    document.formAfectacio.action = "<c:url value='/danysabiotics/edicio/editar.htm'/>";
                    document.formAfectacio.novaurl.value = novaurl;
                    document.formAfectacio.accio.value = "1";
                    document.formAfectacio.wkt.value=getWKTDeObjectesDigitalitzats();
                    document.formAfectacio.submit();
                }
            }

            function validaDades(){
                var esValid = true;
                var missatge = "<fmt:message key="errorEntradaDades" bundle="${bundleAfectacio}" />:";
                var dada = document.getElementById('codi').value;
                if(dada==='null' || dada.trim()===''){
                    esValid = false;
                    missatge += "\n<fmt:message key="calCodi" bundle="${bundleAfectacio}" />";
                }
                var chckdata = document.getElementById('chckapreciacioinicial').checked;
                dada=document.getElementById('dataApreciacioInicial').value;
                if(chckdata && (dada==='null' || dada.trim()==='' || !isDate(dada))){
                    esValid = false;
                    missatge += "\n<fmt:message key="calDataApreciacioInicialOInvalida" bundle="${bundleAfectacio}" />";
                }
                chckdata = document.getElementById('chckdadesdefinitives').checked;
                dada=document.getElementById('dataDadesDefinitives').value;
                if(chckdata && (dada==='null' || dada.trim()==='' || !isDate(dada))){
                    esValid = false;
                    missatge += "\n<fmt:message key="calDataDadesDefinitivesOInvalida" bundle="${bundleAfectacio}" />";
                }
                chckdata = document.getElementById('chckvalidacio').checked;
                dada=document.getElementById('dataValidacio').value;
                if(chckdata && (dada==='null' || dada.trim()==='' || !isDate(dada))){
                    esValid = false;
                    missatge += "\n<fmt:message key="calDataValidacioOInvalida" bundle="${bundleAfectacio}" />";
                }
                if((document.getElementById('dataApreciacioInicial').value==='null' ||
                    document.getElementById('dataApreciacioInicial').value==='') &&
                    (document.getElementById('dataDadesDefinitives').value==='null' ||
                    document.getElementById('dataDadesDefinitives').value==='') &&
                    (document.getElementById('dataValidacio').value==='null' ||
                    document.getElementById('dataValidacio').value==='')){
                    esValid = false;
                    missatge += "\n<fmt:message key="calDataInicialODefinitivesOValidacio" bundle="${bundleAfectacio}" />";
                }
                dada = document.getElementById('nomEnginyer1').value;
                var dada2 = document.getElementById('nomEnginyer2').value;
                var dada3 = document.getElementById('codiAgent1').value;
                var dada4 = document.getElementById('codiAgent2').value;
                if( (dada==='null' || dada.trim()==='') &&
                    (dada2==='null' || dada2.trim()==='') &&
                    (dada3==='null' || dada3.trim()==='') &&
                    (dada4==='null' || dada4.trim()==='')){
                    esValid = false;
                    missatge += "\n<fmt:message key="calIntroduirAlgunIdentificador" bundle="${bundleAfectacio}" />";
                }
                dada = document.getElementById('mostreigSistematicselect').selectedIndex;
                if(dada<1){
                    esValid = false;
                    missatge += "\n<fmt:message key="calIndicarSiMostreigSistematic" bundle="${bundleAfectacio}" />";
                }
                dada = document.getElementById('percentatgeAmbTreballsGestioAparent').value;
                document.getElementById('percentatgeAmbTreballsGestioAparent').value = dada.replace(",",".");
                if(!isInteger(dada) && !isDouble(dada,2)){
                    esValid = false;
                    missatge += "\n<fmt:message key="calPercentatgeAmbTreballsEnFormatCorrecte" bundle="${bundleAfectacio}" />";
                }
                dada = document.getElementById('percentatgeSenseTreballsGestioAparent').value;
                document.getElementById('percentatgeSenseTreballsGestioAparent').value = dada.replace(",",".");
                if(!isInteger(dada) && !isDouble(dada,2)){
                    esValid = false;
                    missatge += "\n<fmt:message key="calPercentatgeSenseTreballsEnFormatCorrecte" bundle="${bundleAfectacio}" />";
                }
                dada = document.getElementById('percentatgeBoscRegeneracioNatural').value;
                document.getElementById('percentatgeBoscRegeneracioNatural').value = dada.replace(",",".");
                if(!isInteger(dada) && !isDouble(dada,2)){
                    esValid = false;
                    missatge += "\n<fmt:message key="calPercentatgeRegeneracioNaturalEnFormatCorrecte" bundle="${bundleAfectacio}" />";
                }
                dada = document.getElementById('percentatgeRepoblacioArtificial').value;
                document.getElementById('percentatgeRepoblacioArtificial').value = dada.replace(",",".");
                if(!isInteger(dada) && !isDouble(dada,2)){
                    esValid = false;
                    missatge += "\n<fmt:message key="calPercentatgeRepoblacioArtificialEnFormatCorrecte" bundle="${bundleAfectacio}" />";
                }
                dada = document.getElementById('percentatgePlantacioEspeciesCreixementRapid').value;
                document.getElementById('percentatgePlantacioEspeciesCreixementRapid').value = dada.replace(",",".");
                if(!isInteger(dada) && !isDouble(dada,2)){
                    esValid = false;
                    missatge += "\n<fmt:message key="calPercentatgeEspeciesCreixementRapidEnFormatCorrecte" bundle="${bundleAfectacio}" />";
                }
                dada=document.getElementById('dataEpisodi').value;
                if(dada==='null' || dada.trim()==='' || !isDate(dada)){
                    esValid = false;
                    missatge += "\n<fmt:message key="calDataEpisodiOInvalida" bundle="${bundleAfectacio}" />";
                }
                if(!comprovarDadesEstimacions()){
                    esValid = false;
                    missatge += "\n<fmt:message key="taulaEstimacionsDanysAbioticsMalEntrada" bundle="${bundleAfectacio}" />";
                }
                dada = false;
                <%
                java.util.List causes2 = (java.util.List)request.getAttribute("causesDecaiment");
                for(int i=0;i<causes2.size();i++){        
                %>
                dada = dada || document.getElementById('CAUSADECAIMENTDANYABIOTIC_<%=i%>').checked;
                <%}%>
                if(!dada){
                    esValid = false;
                    missatge += "\n<fmt:message key="calSeleccionarAlgunaCausaDecaiment" bundle="${bundleAfectacio}" />";
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

            function canviCheckData(idTextData,checkbox){
                document.getElementById(idTextData).disabled=!checkbox.checked
                if(!checkbox.checked){
                    document.getElementById(idTextData).value = '';
                }
            }

            function visualitzar(id){
                window.open("<c:url value='/danysabiotics/imprimirdanysabiotics.htm'/>?idafectacio="+id,'popup','width=970,height=550,scrollbars=YES,resizable=YES,left=0');
            }

            function editar(id){
                document.dades.idafectacio.value = id;
                document.dades.action = "<c:url value='/danysabiotics/edicio/editar.htm'/>?";
                document.dades.submit();
            }

            function esborrar(id){
                if(confirm("<fmt:message key='confirmacio' bundle='${bundleSIPAN}' />")){
                    document.dades.idafectacio.value = id;
                    document.dades.novaurl.value = "/danysabiotics/llistardanysabiotics.htm";
                    document.dades.action = "<c:url value='/danysabiotics/edicio/esborrar.htm'/>?";
                    document.dades.submit();
                }
            }

            function descarregarFitxer(){
                if(confirm("<fmt:message key='confirmacioTrigaMinuts' bundle='${bundleSIPAN}' />")){
                    var url = "<c:url value='/danysabiotics/llistardanysabioticsxls.htm'/>";
                    window.open(url);
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
            cat.creaf.afectaciobosc.model.DanyAbiotic afectacio = ((cat.creaf.afectaciobosc.model.DanyAbiotic) request.getAttribute("afectacio"));
            if (afectacio != null
                    && !(afectacio.getEstat() == MSIPANBasicObj.ObjecteSIPAN.NO_MODIFICAT
                    && "-1".equals(afectacio.getIdString()))) {
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
                <div class="modul mdanysabiotics">
                    <%@ include file="/WEB-INF/jsp/Estructura/menu.jsp" %>
                    <a href="#" onclick="javascript:obrirpopup('<c:url value='/grafics/ProtocolDA.pdf'/>');return false;" title="<fmt:message key='protocol' bundle='${bundleAfectacio}' />"><fmt:message key='protocol' bundle='${bundleAfectacio}' /></a>&nbsp;
                    <a href="#" onclick="javascript:obrirpopup('<c:url value='/grafics/FitxadeCampDA.pdf'/>');return false;" title="<fmt:message key="fitxaCampPDF" bundle="${bundleAfectacio}" />"><fmt:message key="fitxaNevadesCampPDF" bundle="${bundleAfectacio}" /></a>
                    <div class="eina">
                        <div class="continguteina">
                            <c:if test="${llistableShape}">
                            <div class="eines_fitxa">
                                <a class="veure_shape" href="http://${ip}/geoserver/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=SIPAN:DANYMECANIC_GEOMETRIA&outputFormat=SHAPE-ZIP"   title="<fmt:message key="exportarShape" bundle="${bundleSIPAN}" />">&nbsp;</a>
                            </div>
                            </c:if>
                            <% if (esEditable) {%>
                            <%@ include file="/WEB-INF/jsp/DanysAbiotics/fitxaDanyAbiotic.jsp" %>
                            <%} else {%>
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
                            <div class="diventradaDades" id="fitxa">
                                <div class="divbotonou">
                                    <img id="boto_danymecanic" src="<c:url value='/grafics/boto_danysmecanics.png' />" onclick="javascript:nou()" class="boto" alt="nou"/>
                                </div>
                            </div>
                            <%}%>
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
                <%@ include file="/WEB-INF/jsp/Estructura/footer.jsp" %>
            </div>
        </div>
        <form name="dades" method="get" action="">
            <input type="hidden" name="idafectacio" value='${idafectacio}'/>
            <input type="hidden" name="novaurl" value=''/>
            <input type="hidden" name="primerelement" value='${primerelement}'/>
            <input type="hidden" name="numelements" value='${numelements}'/>
        </form>
    </body>
</html>