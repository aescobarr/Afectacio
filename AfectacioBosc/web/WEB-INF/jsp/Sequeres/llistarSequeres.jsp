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
            <c:if test="${dades.editable}">editable = true;</c:if>
            <c:if test="${dades.esborrable}">esborrable = true;</c:if>
                var urlServidor = "${dades.ip}";
                if(urlServidor==""){
                    urlServidor = "${ip}";
                }
                var transparencia = 0.8;
                var urlElementsTaulaJSON = "<c:url value='/sequeres/llistarsequeresjson.htm?'/>";
                var txtDistribucio = "<fmt:message key='distribucioArbresAfectats' bundle='${bundleAfectacio}' />";
                var txtCodi = '<fmt:message key="codi" bundle="${bundleAfectacio}" />';
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
                var txtAbundancia = "<fmt:message key='abundancia' bundle='${bundleAfectacio}' />";
                var txtIndividus = "<fmt:message key='individus' bundle='${bundleAfectacio}' />";
                var txtRecobriment = "<fmt:message key='recobriment' bundle='${bundleAfectacio}' />";
                var txtAfectacio = "<fmt:message key='afectacioPercent' bundle='${bundleAfectacio}' />";
                var txtGrauAfectacio = "<fmt:message key='grauAfectacioPercent' bundle='${bundleAfectacio}' />";
                var txtTipusAfectacio = "<fmt:message key='tipusAfectacio' bundle='${bundleAfectacio}' />";
                var txtArbre = "<fmt:message key='arbrePercentatge' bundle='${bundleAfectacio}' />";
                var txtArbreAfectat = "<fmt:message key='arbreAfectatPercentatge' bundle='${bundleAfectacio}' />";
                var txtPercM = "<fmt:message key='mortalitatPercentatge' bundle='${bundleAfectacio}' />";
                var txtPercDF = "<fmt:message key='defoliacioPercentatge' bundle='${bundleAfectacio}' />";
                var txtPercDC = "<fmt:message key='decoloracioPercentatge' bundle='${bundleAfectacio}' />";
                var txtCanviM = "<fmt:message key='canviMortalitat' bundle='${bundleAfectacio}' />";
                var txtCanviDF = "<fmt:message key='canviDefoliacio' bundle='${bundleAfectacio}' />";
                var txtCanviDC = "<fmt:message key='canviDecoloracio' bundle='${bundleAfectacio}' />";
                var txtCanviMillor = "<fmt:message key='canviMillor' bundle='${bundleAfectacio}' />";
                var txtCanviPitjor = "<fmt:message key='canviPitjor' bundle='${bundleAfectacio}' />";
                var txtCanviIgual = "<fmt:message key='canviIgual' bundle='${bundleAfectacio}' />";
                var txtRebrots = "<fmt:message key='rebrots' bundle='${bundleAfectacio}' />";
                var txtRebrotsCapcada = "<fmt:message key='rebrotsCapcada' bundle='${bundleAfectacio}' />";
                var txtRebrotsNo = "<fmt:message key='rebrotsNo' bundle='${bundleAfectacio}' />";
                var txtRebrotsSoca = "<fmt:message key='rebrotsSoca' bundle='${bundleAfectacio}' />";

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
                var txtGrauAfectacioEspecie1 = "<fmt:message key='grauAfectacioEspecie' bundle='${bundleAfectacio}' /> 1";
                var txtResponsable1 = "<fmt:message key='responsable' bundle='${bundleAfectacio}' /> 1";
                var txtResponsable2 = "<fmt:message key='responsable' bundle='${bundleAfectacio}' /> 2";

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
        <script type="text/javascript" src="<c:url value='/js/Sequeres/llistarSequeres.js' />"></script>
        <script type="text/javascript" src="<c:url value='/js/Cartografia/mapaVisualitzacio.js' />"></script>
        <script type="text/javascript">
            var tiled = crearCapaUsuari();
            var tiledAnterior = crearCapaUsuariAnterior();
//            var tiled2 = crearCapaUsuari2();
//            var tiled2Anterior = crearCapaUsuariAnterior2();

            var taula = new Array(1);
            taula['SEQUERA_GEOMETRIA'] = new Array(2);
            taula['SEQUERA_GEOMETRIA'][0] = new Array(2);
            taula['SEQUERA_GEOMETRIA'][0][0] = "visualitzar";
            taula['SEQUERA_GEOMETRIA'][0][1] = Array(1);
            taula['SEQUERA_GEOMETRIA'][0][1][0] = 0;
            taula['SEQUERA_GEOMETRIA'][1] = new Array(1);
            taula['SEQUERA_GEOMETRIA'][1][0] = new Array(2);
            taula['SEQUERA_GEOMETRIA'][1][0][0] = 1;
            taula['SEQUERA_GEOMETRIA'][1][0][1] = "<fmt:message key='codi' bundle='${bundleAfectacio}' />";

            taula['SEQUERA_ANTERIOR_GEOMETRIA'] = new Array(2);
            taula['SEQUERA_ANTERIOR_GEOMETRIA'][0] = new Array(2);
            taula['SEQUERA_ANTERIOR_GEOMETRIA'][0][0] = "visualitzar";
            taula['SEQUERA_ANTERIOR_GEOMETRIA'][0][1] = Array(1);
            taula['SEQUERA_ANTERIOR_GEOMETRIA'][0][1][0] = 0;
            taula['SEQUERA_ANTERIOR_GEOMETRIA'][1] = new Array(1);
            taula['SEQUERA_ANTERIOR_GEOMETRIA'][1][0] = new Array(2);
            taula['SEQUERA_ANTERIOR_GEOMETRIA'][1][0][0] = 1;
            taula['SEQUERA_ANTERIOR_GEOMETRIA'][1][0][1] = "<fmt:message key='codi' bundle='${bundleAfectacio}' />";
            
            function crearCapaUsuari(){
                var urlServidor = "${dades.ip}";
                if(urlServidor==""){
                    urlServidor = "${ip}";
                }
                var capa;
                var urlCapa = "http://"+ urlServidor + "/geoserver/wms";
                capa = new OpenLayers.Layer.WMS(
                "<fmt:message key='afectacioAnyEnCurs' bundle='${bundleAfectacio}' />",
                "http://"+ urlServidor + "/geoserver/wms",
                {
                    layers: 'SIPAN:SEQUERA_GEOMETRIA',
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

            function crearCapaUsuariAnterior(){
                var urlServidor = "${dades.ip}";
                if(urlServidor==""){
                    urlServidor = "${ip}";
                }
                var capa;
                var urlCapa = "http://"+ urlServidor + "/geoserver/wms";
                capa = new OpenLayers.Layer.WMS(
                "<fmt:message key='afectacioAnyAnterior' bundle='${bundleAfectacio}' />",
                "http://"+ urlServidor + "/geoserver/wms",
                //"http://croscat.creaf.uab.es/geoserver/wms",
                {
                    layers: 'SIPAN:SEQUERA_ANTERIOR_GEOMETRIA',
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

//            function crearCapaUsuari2(){
//                var urlServidor = "${dades.ip}";
//                if(urlServidor==""){
//                    urlServidor = "${ip}";
//                }
//                var capa;
//                var urlCapa = "http://"+ urlServidor + "/geoserver/wms";
//                capa = new OpenLayers.Layer.WMS(
//                "<fmt:message key='transecteAnyEnCurs' bundle='${bundleAfectacio}' />",
//                "http://"+ urlServidor + "/geoserver/wms",
//                {
//                    layers: 'SIPAN:TRANSECTE_GEOMETRIA',
//                    styles: '',
//                    transparent: 'true',
//                    format: 'image/png',
//                    width: '800',
//                    height: '600',
//                    tiled: 'true'
//                },
//                {buffer: 0}
//            );
//                capa.setOpacity(1);
//                return capa;
//            }

//            function crearCapaUsuariAnterior2(){
//                var urlServidor = "${dades.ip}";
//                if(urlServidor==""){
//                    urlServidor = "${ip}";
//                }
//                var capa;
//                var urlCapa = "http://"+ urlServidor + "/geoserver/wms";
//                capa = new OpenLayers.Layer.WMS(
//                "<fmt:message key='transecteAnyAnterior' bundle='${bundleAfectacio}' />",
//                "http://"+ urlServidor + "/geoserver/wms",
//                {
//                    layers: 'SIPAN:TRANSECTE_ANTERIOR_GEOMETRIA',
//                    styles: '',
//                    transparent: 'true',
//                    format: 'image/png',
//                    width: '800',
//                    height: '600',
//                    tiled: 'true'
//                },
//                {buffer: 0}
//            );
//                capa.setOpacity(1);
//                return capa;
//            }

            function nou(){
                document.dades.action = "<c:url value='/sequeres/edicio/inserir.htm'/>";
                document.dades.submit();
            }

            function enrera(){
                document.dades.action = "<c:url value='/sequeres/llistarsequeres.htm'/>";
                document.dades.submit();
            }

            function initPagina(){
                initMapa();
                afegirCapa(tiled);
                afegirCapa(tiledAnterior);
//                afegirCapa(tiled2);
//                afegirCapa(tiled2Anterior);
                if(document.dades2 && document.dades2.wkt){
                    mostrarWTK(document.dades2.wkt.value);
                }else{
                    clearFeaturesMapa();
                }
                llegirCookies();
                
                if(document.getElementById('nou').checked){
                    document.getElementById('divArbresNousAfectats').style.display="none";
                }else{
                    document.getElementById('divArbresNousAfectats').style.display="block";
                }
            }

            function acceptarISortir(){
                if(validaDades()){
                    getDadesEstimacions();
                    getDadesRegeneracio();
//                    getDadesTransecte();
                    document.dades2.action = "<c:url value='/sequeres/edicio/editar.htm'/>";
                    document.dades2.novaurl.value = "/sequeres/llistarsequeres.htm";
                    document.dades2.wkt.value=getWKTDeObjectesDigitalitzats();
                    document.dades2.submit();
                }
            }

            function acceptar(){
                if(validaDades()){
                    getDadesEstimacions();
                    getDadesRegeneracio();
//                    getDadesTransecte();
                    document.dades2.action = "<c:url value='/sequeres/edicio/editar.htm'/>";
                    document.dades2.novaurl.value = "/sequeres/edicio/editar.htm";
                    document.dades2.wkt.value=getWKTDeObjectesDigitalitzats();
                    document.dades2.submit();
                }
            }
            
            function validaCodi(codi){
                return !(codi==null || codi.length!=9 || codi.substring(2,3)!='-' 
                    || codi.substring(6,7)!='-');
            }
            
            function formatIncorrecteCoordX(){
                var dada = document.getElementsByName('coordenadaXPuntObservacio')[0].value;
                return (!isInteger(dada) && !isDouble(dada,2));
            }
            
            function formatIncorrecteCoordY(){
                var dada = document.getElementsByName('coordenadaYPuntObservacio')[0].value;
                return (!isInteger(dada) && !isDouble(dada,2));
            }
            
            function coordXEnBlanc(){
                var dada = document.getElementsByName('coordenadaXPuntObservacio')[0].value;
                return (dada==='null' || dada.trim()==='');
            }
            
            function coordYEnBlanc(){
                var dada = document.getElementsByName('coordenadaYPuntObservacio')[0].value;
                return (dada==='null' || dada.trim()==='');
            }
            
            function coordXForaRang(xMinima, xMaxima){
                var dada = document.getElementsByName('coordenadaXPuntObservacio')[0].value;
                return (dada<xMinima || dada>xMaxima);
            }
            
            function coordYForaRang(yMinima, yMaxima){
                var dada = document.getElementsByName('coordenadaYPuntObservacio')[0].value;
                return (dada<yMinima || dada>yMaxima);
            }
            
            function validaCoordX(xMinima,xMaxima){
                if(coordXEnBlanc())                    
                    return "\n<fmt:message key="calCoordenadaX" bundle="${bundleAfectacio}" />";
                if(formatIncorrecteCoordX())
                    return "\n<fmt:message key="calCoordenadesPuntObservacio" bundle="${bundleAfectacio}" />";
                if(coordXForaRang(xMinima, xMaxima))
                    return "\n<fmt:message key="coordXForaRang" bundle="${bundleAfectacio}" />";
                return "";
            }
            
            function validaCoordY(yMinima,yMaxima){
                if(coordYEnBlanc())                    
                    return "\n<fmt:message key="calCoordenadaY" bundle="${bundleAfectacio}" />";
                if(formatIncorrecteCoordY())
                    return "\n<fmt:message key="calCoordenadesPuntObservacio" bundle="${bundleAfectacio}" />";
                if(coordYForaRang(yMinima, yMaxima))
                    return "\n<fmt:message key="coordYForaRang" bundle="${bundleAfectacio}" />";
                return "";
            }
            
            function validaDades(){
                var esValid = true;
                var missatge = "<fmt:message key="errorEntradaDades" bundle="${bundleAfectacio}" />:";
                var dada = document.getElementsByName('codi')[0].value;
                if(dada==='null' || dada.trim()==='' || !validaCodi(dada)){
                    esValid = false;
                    missatge += "\n<fmt:message key="calNumTram" bundle="${bundleAfectacio}" />";
                }
                var xMinima = 259500;
                var xMaxima = 4603100;
                var yMinima = 405250;
                var yMaxima = 4745000;
                var mssX = validaCoordX(xMinima,xMaxima);
                if(mssX != ""){
                    esValid = false;
                    missatge += "\n"+mssX;
                }
                var mssY = validaCoordY(yMinima,yMaxima);
                if(mssY != ""){
                    esValid = false;
                    missatge += "\n"+mssY;
                }
//                var dada = document.getElementsByName('coordenadaXPuntObservacio')[0].value;
//                document.getElementsByName('coordenadaXPuntObservacio')[0].value = dada.replace(",",".");
//                if(dada==='null' || dada.trim()==='' ||
//                    (!isInteger(dada) && !isDouble(dada,2)) || dada<xMinima || dada>xMaxima){
//                    esValid = false;
//                    missatge += "\n<fmt:message key="calCoordenadesPuntObservacio" bundle="${bundleAfectacio}" />";
//                }else{
//                    var dada = document.getElementsByName('coordenadaYPuntObservacio')[0].value;
//                    document.getElementsByName('coordenadaYPuntObservacio')[0].value = dada.replace(",",".");
//                    if(dada==='null' || dada.trim()==='' ||
//                        (!isInteger(dada) && !isDouble(dada,2)) || dada<yMinima || dada>yMaxima){
//                        esValid = false;
//                        missatge += "\n<fmt:message key="calCoordenadesPuntObservacio" bundle="${bundleAfectacio}" />";
//                    }
//                }
                var dada = document.getElementById('distribucioArbresAfectats').value;
                if(dada==='null' || dada.trim()===''){
                    esValid = false;
                    missatge += "\n<fmt:message key="calDistribucioArbresAfectats" bundle="${bundleAfectacio}" />";
                }
                var dada = document.getElementsByName('codiAgent1')[0].value;
                if(dada==='null' || dada.trim()===''){
                    esValid = false;
                    missatge += "\n<fmt:message key="calCodiAgent1" bundle="${bundleAfectacio}" />";
                }
                var dada = document.getElementsByName('codiAgent2')[0].value;
                if(dada==='null' || dada.trim()===''){
                    esValid = false;
                    missatge += "\n<fmt:message key="calCodiAgent2" bundle="${bundleAfectacio}" />";
                }
//                var dada = document.getElementsByName('coordenadaXIniciTransecte')[0].value;
//                document.getElementsByName('coordenadaXIniciTransecte')[0].value = dada.replace(",",".");
//                if(dada==='null' || dada.trim()==='' ||
//                    (!isInteger(dada) && !isDouble(dada,2))){
//                    esValid = false;
//                    missatge += "\n<fmt:message key="calCoordenadesTransecte" bundle="${bundleAfectacio}" />";
//                }else{
//                    var dada = document.getElementsByName('coordenadaYIniciTransecte')[0].value;
//                    document.getElementsByName('coordenadaYIniciTransecte')[0].value = dada.replace(",",".");
//                    if(dada==='null' || dada.trim()==='' ||
//                        (!isInteger(dada) && !isDouble(dada,2))){
//                        esValid = false;
//                        missatge += "\n<fmt:message key="calCoordenadesTransecte" bundle="${bundleAfectacio}" />";
//                    }else{
//                        var dada = document.getElementsByName('coordenadaXFiTransecte')[0].value;
//                        document.getElementsByName('coordenadaXFiTransecte')[0].value = dada.replace(",",".");
//                        if(dada==='null' || dada.trim()==='' ||
//                            (!isInteger(dada) && !isDouble(dada,2))){
//                            esValid = false;
//                            missatge += "\n<fmt:message key="calCoordenadesTransecte" bundle="${bundleAfectacio}" />";
//                        }else {
//                            var dada = document.getElementsByName('coordenadaYFiTransecte')[0].value;
//                            document.getElementsByName('coordenadaYFiTransecte')[0].value = dada.replace(",",".");
//                            if(dada==='null' || dada.trim()==='' ||
//                                (!isInteger(dada) && !isDouble(dada,2))){
//                                esValid = false;
//                                missatge += "\n<fmt:message key="calCoordenadesTransecte" bundle="${bundleAfectacio}" />";
//                            }
//                        }
//                    }
//                }
                var dada = document.getElementsByName('orientacioFoto')[0].value;
                if(dada==='null' || dada.trim()==='' || !isInteger(dada) || dada<0 || dada>360){
                    esValid = false;
                    missatge += "\n<fmt:message key="calOrientacio" bundle="${bundleAfectacio}" />";
                }
                var dada=document.getElementsByName('data')[0].value;
                if(dada==='null' || dada.trim()===''){
                    esValid = false;
                    missatge += "\n<fmt:message key="calDataObservacio" bundle="${bundleAfectacio}" />";
                }
                if(!isDate(dada)){
                    esValid = false;
                    missatge += "\n<fmt:message key="formatDataInvalit" bundle="${bundleAfectacio}" />";
                }
                if(getElementsDigitalitzats()!=1){
                    esValid = false;
                    missatge += "\n<fmt:message key="calDigitalitzarZonaAfectada" bundle="${bundleAfectacio}" />";
                }
                if(!comprovarDadesEstimacions()){
                    esValid = false;
                    missatge += "\n<fmt:message key="taulaEstimacionsMalEntrada" bundle="${bundleAfectacio}" />";
                }
                if(!comprovarDadesEstimacionsSansAfectats()){
                    esValid = false;
                    missatge += "\n<fmt:message key="taulaEstimacionsMalEntradaSansAfectats" bundle="${bundleAfectacio}" />";
                }
                if(!comprovarDadesEstimacionsSumaTipusAfectacions()){
                    esValid = false;
                    missatge += "\n<fmt:message key="taulaEstimacionsMalEntradaSumaTipusAfectacions" bundle="${bundleAfectacio}" />";
                }
                if(!comprovarDadesEstimacionsTipusAfectacio()){
                    esValid = false;
                    missatge += "\n<fmt:message key="taulaEstimacionsMalEntradaTipusAfectacio" bundle="${bundleAfectacio}" />";
                }
//                if(!comprovarDadesTransecte()){
//                    esValid = false;
//                    missatge += "\n<fmt:message key="taulaTransectesMalEntrada" bundle="${bundleAfectacio}" />";
//                }
                if(!esValid){
                    alert(missatge);
                }else{
//                    if(!comprovarDades100Transecte()){
//                        if(!confirm("<fmt:message key='confirmacioNoEntrar100Transectes' bundle='${bundleAfectacio}' />")){                            
//                            esValid = false;
//                        }
//                    }else{
//                        omplirTaulaTransectePerDefecte();
//                    }
                }
                return esValid;
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
           /*     var capa = readCookie('sequera');
                tiled.setVisibility(capa=='true');
                capa = readCookie('sequeraanterior');
                tiledAnterior.setVisibility(capa=='true');
                var capa = readCookie('transecte');
                tiled2.setVisibility(capa=='true');
                capa = readCookie('transecteanterior');
                tiled2Anterior.setVisibility(capa=='true');*/
            }

            function escriureCookies(){
                document.cookie = "left="+map.getExtent().left+"; path=/";
                document.cookie = "right="+map.getExtent().right+"; path=/";
                document.cookie = "bottom="+map.getExtent().bottom+"; path=/";
                document.cookie = "top="+map.getExtent().top+"; path=/";
          /*      document.cookie = "sequera="+tiled.visibility+"; path=/";
                document.cookie = "sequeraanterior="+tiledAnterior.visibility+"; path=/";
                document.cookie = "transecte="+tiled2.visibility+"; path=/";
                document.cookie = "transecteanterior="+tiled2Anterior.visibility+"; path=/";*/
            }

            function exitPagina(){
                escriureCookies();
            }

            function visualitzar(id){
                window.open("<c:url value='/sequeres/imprimirsequeres.htm'/>?idafectacio="+id,'popup','width=970,height=550,scrollbars=YES,resizable=YES,left=0');
            }

            function editar(id){
                document.dades.idafectacio.value = id;
                document.dades.action = "<c:url value='/sequeres/edicio/editar.htm'/>?";
                document.dades.submit();
            }

            function esborrar(id){
                if(confirm("<fmt:message key='confirmacio' bundle='${bundleSIPAN}' />")){
                    document.dades.idafectacio.value = id;
                    document.dades.novaurl.value = "/sequeres/llistarsequeres.htm";
                    document.dades.action = "<c:url value='/sequeres/edicio/esborrar.htm'/>?";
                    document.dades.submit();
                }
            }

            function descarregarFitxer(){
                if(confirm("<fmt:message key='confirmacioTrigaMinuts' bundle='${bundleSIPAN}' />")){
                    var url = "<c:url value='/sequeres/llistarsequeresxls.htm'/>";
                    window.open(url);
                }
            }
            
            function canviNouOAntic(){
                var inputValorNouOAntic = document.getElementById('valorNouOAntic');
                if(document.getElementById('nou').checked){
                    inputValorNouOAntic.value = 'N';
                    document.getElementById('divArbresNousAfectats').style.display="none";
                }else{
                    inputValorNouOAntic.value = 'A';
                    document.getElementById('divArbresNousAfectats').style.display="block";
                }
            }
            
            function canviArbresNousAfectats(){
                var inputValor = document.getElementById('arbresNousAfectats');
                if(document.getElementById('hihaArbresNousAfectats').checked){
                    inputValor.value = 'S';
                }else{
                    inputValor.value = 'N';
                }
            }

            YAHOO.util.Event.onContentReady("bloc_control_mapa", function () {
                var oPushButton2 = new YAHOO.widget.Button("botodigitalitzar", { onclick: { fn: onClickDigitalitzar } });
            });
        </script>

        <%
                    boolean esEditable = false;
                    cat.creaf.afectaciobosc.model.Sequera afectacio = ((cat.creaf.afectaciobosc.model.Sequera) request.getAttribute("afectacio"));
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
                <div class="modul msequera">
                    <%@ include file="/WEB-INF/jsp/Estructura/menu.jsp" %>
                    <a href="#" onclick="javascript:obrirpopup('<c:url value='/grafics/ajuda_sequera2013.pdf'/>');return false;" title="<fmt:message key='protocol' bundle='${bundleAfectacio}' />"><fmt:message key='protocol' bundle='${bundleAfectacio}' /></a>&nbsp;
                    <a href="#" onclick="javascript:obrirpopup('<c:url value='/grafics/fitxa_camp_sequera2013.pdf'/>');return false;" title="<fmt:message key="fitxaNevadesCampPDF" bundle="${bundleAfectacio}" />"><fmt:message key="fitxaNevadesCampPDF" bundle="${bundleAfectacio}" /></a>
                    <div class="eina">
                        <div class="continguteina">
                            <c:if test="${dades.llistableShape}">
                            <div class="eines_fitxa">
                                <a class="veure_shape" href="http://${dades.ip}/geoserver/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=SIPAN:SEQUERA_GEOMETRIA&outputFormat=SHAPE-ZIP"   title="<fmt:message key="exportarShape" bundle="${bundleSIPAN}" />">&nbsp;</a>
                            </div>
                            </c:if>
                            <% if (esEditable) {%>
                            <div id="fitxa">
                                <form name="dades2" method="POST" action="" enctype="multipart/form-data">
                                    <spring:nestedPath path="afectacio">
                                        <div id="pestanyer">
                                            <ul class="yui-nav">
                                                <li class="selected"><a href="#tabdadesbasiques"><em><fmt:message key="dadesBasiques" bundle="${bundleAfectacio}" /></em></a></li>                                                
                                                <li><a href="#tabzona"><em><fmt:message key="caracteritzacioInSituDeLaZonaAfectada" bundle="${bundleAfectacio}" /></em></a></li>
                                                <li><a href="#tabimatges"><em><fmt:message key="imatges" bundle="${bundleAfectacio}" /></em></a></li>
                                            </ul>
                                            <div class="yui-content msequera">
                                                <div id="tabdadesbasiques">
                                                    <%@ include file="/WEB-INF/jsp/Sequeres/pestanyaDadesBasiques.jsp" %>
                                                </div>
                                                <div id="tabzona">
                                                    <%@ include file="/WEB-INF/jsp/Sequeres/pestanyaCaracteritzacio.jsp" %>
                                                </div>
                                                <div id="tabimatges">
                                                    <%@ include file="/WEB-INF/jsp/Sequeres/pestanyaFotos.jsp" %>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="campformulari"><div class="etiqueta"></div>
                                            <div class="entradadades">
                                                <div id="botonera" class="botonera">
                                                    <c:if test="${editable}">
                                                    <input type="button" value="<fmt:message key="desar" bundle="${bundleSIPAN}" />" onclick="javascript:acceptar()" class="boto" />
                                                    </c:if>
                                                    <input type="button" value="<fmt:message key="desarISortir" bundle="${bundleAfectacio}" />" onclick="javascript:acceptarISortir()" class="boto" />
                                                    <input type="button" value="<fmt:message key="cancelar" bundle="${bundleSIPAN}" />" onclick="javascript:enrera()" class="boto" />
                                                </div>
                                            </div>
                                        </div>
                                                <input type="hidden" name="wkt" value='${afectacio.areaAfectadaWtk}'/>
                                                <input type="hidden" name="novaurl" value=''/>
                                                <input type="hidden" name="idafectacio" value='${afectacio.idString}'/>
                                    </spring:nestedPath>
                                </form>
                            </div>
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
                                    <img id="boto_sequera" src="<c:url value='/grafics/boto_sequera.png' />" onclick="javascript:nou()" class="boto" alt="nou"/>
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