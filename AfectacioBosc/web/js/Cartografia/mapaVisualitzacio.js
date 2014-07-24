var txtDefaultOLSpanish = {
    'baseLayer': "Cartografía de referencia",
    'overlays':"Capas"
};
var txtDefaultOLCatalan = {
    'baseLayer': "Cartografia de referència",
    'overlays':"Capes"
};

var map, vectors, controls, layersSwitch;
function initMapa(){
    OpenLayers.Lang.es = txtDefaultOLSpanish;
    OpenLayers.Lang.ca = txtDefaultOLCatalan;
    OpenLayers.Lang.setCode('ca');



    var optionsMap = {
        maxExtent: new OpenLayers.Bounds(258000,4485000,536000,4752000),
        maxResolution: 'auto',
        projection: "EPSG:23031",
        units: 'm',
        controls:[new OpenLayers.Control.Navigation()]
    }
    map = new OpenLayers.Map('map',optionsMap);

    
    var topo = new OpenLayers.Layer.WMS(
        "Topogràfica", "http://sagitari.icc.cat/tilecache/tilecache.py?",
        {
            layers: 'topo',
            format:"image/jpeg",
            exceptions:"application/vnd.ogc.se_xml"
        },

        {
            buffer:0,
            transitionEffect:'resize',
            resolutions: [550,275,100,50,25,10,5,2,1,0.5]
            }
        );
    
    var orto = new OpenLayers.Layer.WMS(
        "Imatge", "http://sagitari.icc.cat/tilecache/tilecache.py?",
        {
            layers: 'orto',
            format:"image/jpeg",
            exceptions:"application/vnd.ogc.se_xml"
        },

        {
            buffer:0,
            transitionEffect:'resize',
            resolutions: [550,275,100,50,25,10,5,2,1,0.5]
            }
        );


    OpenLayers.Feature.Vector.style['default']['strokeWidth'] ='2';
    vectors = new OpenLayers.Layer.Vector("Digitalitzant");

    layersSwitch = new OpenLayers.Control.LayerSwitcher({
        'ascending':false ,
        'dataLayers':null
    });



    var removeOptions = {
        clickout: true,
        onSelect: featureRemove,
        toggle: false,
        multiple: false,
        hover: false
    };


    var controlPoint = new OpenLayers.Control();
    OpenLayers.Util.extend(controlPoint, {
        draw: function () {
            this.point = new OpenLayers.Handler.Point( controlPoint,
            {
                "done": this.notice
                })
            this.point.activate();
        },
        activate: function(){
            this.point.activate();
        },
        deactivate: function(){
            this.point.deactivate();
        },
        notice: function (point) {
            if(vectors.features.length>1){
                if(confirm("txtOpenlayers.MSG_ERROR_MASSA_ELEMENTS_DIGITALITZATS")){
                    vectors.removeFeatures(vectors.features);
                    var features = new Array(1);
                    features[0] = new OpenLayers.Feature.Vector(
                        new OpenLayers.Geometry.Point(point.x, point.y));
                    vectors.addFeatures(features);
                }else{
                    this.point.deactivate();
                }
            }else{
                var features = new Array(1);
                features[0] = new OpenLayers.Feature.Vector(
                    new OpenLayers.Geometry.Point(point.x, point.y));
                vectors.addFeatures(features);
            }
        }
    });








    var controlPolygon = new OpenLayers.Control();
    OpenLayers.Util.extend(controlPolygon, {
        create: function(pixel,sketch){
            if(vectors.features.length>0){
                if(confirm(txtOpenlayers.MSG_ERROR_MASSA_ELEMENTS_DIGITALITZATS)){
                    vectors.removeFeatures(vectors.features);
                }else{
                    this.polygon.deactivate();
                }
            }
        },
        draw: function () {
            this.polygon = new OpenLayers.Handler.Polygon( controlPolygon,
            {
                "done": this.notice,
                "create":this.create
                });
            this.polygon.activate();
        },
        activate: function(){
                    
            this.polygon.activate();
                    
        },
        deactivate: function(){
            this.polygon.deactivate();
        },
        notice: function (polygon) {
            //vectors.removeFeatures(vectors.features);
            var features = new Array(1);
            features[0] = new OpenLayers.Feature.Vector(
                polygon);
            vectors.addFeatures(features);
        }
    });

       
    
    
    bubble = new OpenLayers.Control.WMSGetFeatureInfo({
        url: 'http://'+urlServidor+'/geoserver/wms',
        title: 'Identify features by clicking',
        queryVisible: true,
        infoFormat: 'text/html',
        eventListeners: {
            getfeatureinfo: function(event) {
                if(event.text.split('¨#¨').length>1){
                    map.addPopup(
                        new OpenLayers.Popup.FramedCloud(
                            "chicken",
                            map.getLonLatFromPixel(event.xy),
                            null,
                            getFilaInfoText(event),
                            null,
                            true
                            )
                        );
                }
            }
        }
    });

    controls = {
        point: controlPoint,
        polygon: controlPolygon,
        zoom: new OpenLayers.Control.ZoomBox({
            alwaysZoom:true
        }),
        remove: new OpenLayers.Control.SelectFeature(vectors,removeOptions),
        info: bubble

    };


    map.addControl(new OpenLayers.Control.ScaleLine());
    map.addControl(new OpenLayers.Control.MousePosition({
        'div':OpenLayers.Util.getElement('coordenades')
        }));
    
    map.addControl(new OpenLayers.Control.PanZoomBar({
        'zoomWorldIcon':true
    }));

    var bounds = new OpenLayers.Bounds(258000,4485000,536000,4752000);
    var referencia = new OpenLayers.Layer.Image(
        "Overview", urlImatgeMapaSituacio, bounds, new OpenLayers.Size(128, 123)
        );
    var genericMapOptions = {
        projection: "EPSG:23031",
        units: 'm',
        maxExtent: bounds
    }
    var overviewMapSize = new OpenLayers.Size(128, 123);
    var overviewOptions = {
        mapOptions: genericMapOptions,
        size: overviewMapSize,
        div: $('overview'),
        layers: [referencia]
    }
    var ovControl = new OpenLayers.Control.OverviewMap(overviewOptions);
    ovControl.isSuitableOverview = function() {
        return true;
    };
    map.addControl(ovControl);


    for(var key in controls) {
        map.addControl(controls[key]);
        controls[key].deactivate();
    }
    if(crearCamins){
        crearCapesCamins();
    }
    map.addLayers([topo,orto,vectors]);
    map.addControl(layersSwitch);
    map.zoomToMaxExtent();
}

function crearCapesCamins(){
    var urlCapa = "http://"+ urlServidor + "/geoserver/wms";
    capaPrimaris = new OpenLayers.Layer.WMS(
        'Camins primaris',urlCapa,
        {
            layers: 'SIPAN:CAMINS_BOMBERS_1',
            styles: '',
            cql_Filter: "CAS='VIA61'",
            transparent: 'true',
            format: 'image/png',
            width: '800',
            height: '600',
            tiled: 'true'
        },
        {
            buffer: 0
        }
        );
    capaPrimaris.setOpacity(1);
    capaSecundaris = new OpenLayers.Layer.WMS(
        'Camins secundaris',urlCapa,
        {
            layers: 'SIPAN:CAMINS_BOMBERS_1',
            styles: '',
            cql_Filter: "CAS='VIA62'",
            transparent: 'true',
            format: 'image/png',
            width: '800',
            height: '600',
            tiled: 'true'
        },
        {
            buffer: 0
        }
        );
    capaSecundaris.setOpacity(1);
    capaTerciaris = new OpenLayers.Layer.WMS(
        'Camins terciaris',urlCapa,
        {
            layers: 'SIPAN:CAMINS_BOMBERS_1',
            styles: '',
            cql_Filter: "CAS='VIA63'",
            transparent: 'true',
            format: 'image/png',
            width: '800',
            height: '600',
            tiled: 'true'
        },
        {
            buffer: 0
        }
        );
    capaTerciaris.setOpacity(1);
    capaNoAccessibles = new OpenLayers.Layer.WMS(
        'Camins no accessibles BRP',urlCapa,
        {
            layers: 'SIPAN:CAMINS_BOMBERS_1',
            styles: '',
            cql_Filter: "CAS='VIA64'",
            transparent: 'true',
            format: 'image/png',
            width: '800',
            height: '600',
            tiled: 'true'
        },
        {
            buffer: 0
        }
        );
    capaNoAccessibles.setOpacity(1);
    map.addLayers([capaPrimaris,capaSecundaris,capaTerciaris,capaNoAccessibles]);
}

function featureRemove(feature) {
    var x = confirm(txtOpenlayers.MSG_ELIMINAR);
    if (x==true) {
        vectors.removeFeatures(feature);
    }
}

function initAddPolygon(){

}

function comprovacioPreAfegir(x,y){
    return comprovacioAmbitCoordenada(x,y);
}

function comprovacioAmbitCoordenada(x,y){
    var bounds = map.maxExtent;
    if( x < bounds.left || x > bounds.right || y < bounds.bottom || y > bounds.top ){
        alert("La coordenada " + x + "," + y + " cau fora de l'àmbit del mapa.");
        return false;
    }
    return true;
}

function toggleControl(element) {
    for(key in controls) {
        var control = controls[key];
        //if(element.value == key && element.checked) {
        if(element == key) {
            control.activate();
        } else {
            control.deactivate();
        }
    }
    if(element.value=="polygon")
        clearFeaturesMapa();
}

function esborrarSeleccionats(){
    var seleccionats = vectors.selectedFeatures;    
    vectors.removeFeatures(seleccionats);
}

function getWKTDeObjectesDigitalitzats(){
    var digits = vectors.features;
    var geoWKT = new OpenLayers.Format.WKT();
    return geoWKT.write(digits);
}

function mostrarWTK(wkt){
    var geoWKT = new OpenLayers.Format.WKT();
    var feats = geoWKT.read(wkt);
    if(feats){
        vectors.addFeatures(feats);        
    }else{
        clearFeaturesMapa();
    }
}

function mostrarCapaProcessionaria(){
    var layer = map.getLayersByName('Processionaria')[0];
    layer.setVisibility(true);
}

function amagarCapaProcessionaria(){
    var layer = map.getLayersByName('Processionaria')[0];
    layer.setVisibility(false);
}

function clearFeaturesMapa(){
    vectors.removeFeatures(vectors.features);
}

function afegirCapa(capaNova){
    if(map!=null)
        map.addLayer(capaNova);
}

function eliminarCapa(capaNova){
    if(map!=null)
        map.removeLayer(capaNova,null);
}

var mapa;
var pareMapa;
var hideMapa;
var pareAmagarMapa;
var iniciat = false;
function veureAmagarMapa(tamany){
    if(mapa==null){
        mapa = document.getElementById('map');
        pareMapa = mapa.parentNode;
        pareMapa.removeChild(mapa);
    }else{
        if(tamany!=""){
            mapa.setAttribute("class",tamany);
        }
        pareMapa.appendChild(mapa);
        pareMapa = null;
        mapa = null;
        if(!iniciat){
            map.zoomToMaxExtent();
            iniciat = true;
        }
    }
}

function amagarMapa(){
    if(mapa==null){
        mapa = document.getElementById('map');
        pareMapa = mapa.parentNode;
    }
    pareMapa.removeChild(mapa);
    hideMapa = document.getElementById('hidemap');
    if(hideMapa!=null){
        pareAmagarMapa = hideMapa.parentNode;
        pareAmagarMapa.removeChild(hideMapa);
    }
}

function veureMapa(tamany){
    if(mapa==null){
        mapa = document.getElementById('map');
        pareMapa = mapa.parentNode;
    }
    if(tamany!=""){
        mapa.setAttribute("class",tamany);
    }
    pareMapa.appendChild(mapa);
    map.zoomToMaxExtent();
    if(pareAmagarMapa!=null && document.getElementById('hidemap')==null){
        pareAmagarMapa.appendChild(hideMapa);
    }
}

function getElementsDigitalitzats(){
    return vectors.features.length;
}

function getFilaInfoText(event){    
    var geoserver = "\"" + event.text + "\"";
    var html = parseGeoserverHTML(geoserver,taula);
    return html;
}

function parseGeoserverHTML(geoserver,taulaEntrada){
    var taules = extreureTaules(geoserver,taulaEntrada);
    html = "<div>";
    for(i=0;i<taules.length;i++){
        html = html + taules[i];
    }
    html = html + "</div>";
    return html;
}

function extreureTaules(geoserver,taulaEntrada){
    var cadenesAmbTaules = geoserver.split('¨#¨');
    var numValides = contarCadenesValides(cadenesAmbTaules);    
    var taules = new Array(numValides);
    var bones = 0;
    for(var i=1;i<cadenesAmbTaules.length;i++){
        var taula = extreureTaula(cadenesAmbTaules[i],taulaEntrada);
        if(taula!=null){
            taules[bones] = taula;
            bones++;
        }
    }
    return taules;
}

function contarCadenesValides(cadenes){
    var numValides = 0;
    for(var i=1;i<cadenes.length;i++){
        if(cadenes[i]!=null && cadenes[i]!=''){
            numValides++;
        }
    }    
    return numValides;
}

function extreureTaula(geoserver,taulaEntrada){
    if(geoserver==null || geoserver==''){
        return null;
    }
    var nomTaula = geoserver.substr(0,geoserver.indexOf('¨$¨'));    
    var contingutTaula = geoserver.substr(geoserver.indexOf('¨$¨')+3);    
    var html = "<table class='estil1'><thead>";
    var titols = contingutTaula.substr(0,contingutTaula.indexOf('¨&¨'));    
    var camps = contingutTaula.substr(contingutTaula.indexOf('¨&¨')+3);    
    var numCols = contarNumeroColumnes(titols);    
    html = html + extreureTitolsColumnes(titols,taulaEntrada[nomTaula]);    
    html = html + "</thead><tbody>";
    html = html + extreureCampsColumnes(numCols,camps,taulaEntrada[nomTaula]);
    html = html + "</tbody></table>";
    return html;
}


function contarNumeroColumnes(geoserver){
    if(geoserver==null || geoserver==''){
        return null;
    }
    var contingutTaula = geoserver.split('¨$¨');
    return contingutTaula.length;
}

function extreureTitolsColumnes(geoserver,taulaEntrada){
    if(geoserver==null || geoserver==''){
        return null;
    }    
    var html = "<tr>";    
    for(var i=0;i<taulaEntrada[1].length;i++){
        html = html + "<th>" + taulaEntrada[1][i][1] + "</th>";
    }
    html = html + "</tr>";    
    return html;
}


function extreureCampsColumnes(numCols,geoserver,taulaEntrada){
    if(geoserver==null || geoserver==''){
        return null;
    }
    var contingutTaula = geoserver.split('¨&¨');
    var html = "";
    for(var k=0;k<contingutTaula.length/numCols;k++){
        for(var i=0;i<taulaEntrada[1].length;i++){
            if(i%numCols==0){
                html = html + "<tr>";
            }
            html = html + "<td>";
            html = html + contingutTaula[k*numCols + taulaEntrada[1][i][0]];
            html = html  + "</td>";
            if(i%numCols==numCols-1){
                html = html + "</tr>";
            }
        }
    }
    return html;
}

function netejaCadena(s) {
    var r = "";
    for (var i=0; i < s.length; i++) {
        if (s.charAt(i) != '\n' &&
            s.charAt(i) != '\r' &&
            s.charAt(i) != '\t' &&
            s.charAt(i) != ' ') {
            r += s.charAt(i);
        }
    }
    return r;
}


/** Part de les capes **/


function initCaixaCapa(
    id_li,
    estilCssCaixa,
    idIcona,
    idCapaGeoServer,
    etiquetaCapaACaixa,
    ipServidorGeoServer,
    veureKML
    ){
    var html;
    html = "<div class=\"botons_capa\">";
    if(veureKML){
        html = html + "<a class=\"kml\" href=\"http://" + ipServidorGeoServer + "/geoserver/wms/kml?layers=" + idCapaGeoServer + "\" target=\"_blank\"></a>";
    }
    html = html + "<a id=\"" + idIcona + "\" class=\"noveurecapa\" href=\"#\" onclick=\"javascript:mostrarAmagarCapa('" + idIcona + "','" + id_li + "');return false;\"></a>";
    html = html + "</div>";
    html = html + "<div class=\"titol_capa\">";
    html = html + etiquetaCapaACaixa;
    html = html + "</div>";

    var contenidorCapes = document.getElementById('llistacapes');
    var nouLi = document.createElement('li');
    nouLi.setAttribute("id", id_li);
    nouLi.setAttribute("class", "capa " + estilCssCaixa);
    nouLi.innerHTML = html;
    contenidorCapes.appendChild(nouLi);
}

function creaCapaASwitch(
    id_li,
    transparencia,
    estilCssCaixa,
    idIcona,
    idCapaGeoServer,
    etiquetaCapaACaixa,
    ipServidorGeoServer,
    format,
    veureKML,
    formatExcepcions
    ){
    var capa = new OpenLayers.Layer.WMS(
        id_li, ipServidorGeoServer,
        {
            layers: idCapaGeoServer,
            styles: '',
            transparent: 'true',
            format: format,
            width: '800',
            height: '600',
            tiled: 'true'
        },
        {
            buffer: 0
        }
        );
    if(formatExcepcions!=null){
        capa = new OpenLayers.Layer.WMS(
            id_li, ipServidorGeoServer,
            {
                layers: idCapaGeoServer,
                styles: '',
                transparent: 'true',
                format: format,
                exceptions: formatExcepcions,
                width: '800',
                height: '600',
                tiled: 'true'
            },
            {
                buffer: 0
            }
            );
    }
    capa.setOpacity(transparencia);
    capa.setVisibility(false);
    map.addLayer(capa);
    initCaixaCapa(
        id_li,
        estilCssCaixa,
        idIcona,
        idCapaGeoServer,
        etiquetaCapaACaixa,
        ipServidorGeoServer,
        veureKML
        );
}


function actualitzaPosicioCapaMap(idControl,delta){
    var capa = getCapaDeIdLlista(idControl);
    if(capa){
        map.raiseLayer(capa,delta);
    }

}

function pujaControl(idcontrol){
    var control = document.getElementById(idcontrol);
    var clonControl = control.cloneNode(true);
    var contenidorControl = document.getElementById('llistacapes');
    var controlAnterior = YAHOO.util.Dom.getPreviousSibling(idcontrol);
    if(controlAnterior){
        contenidorControl.removeChild(control);
        contenidorControl.insertBefore(clonControl, controlAnterior);
    }
    ajustaOrdreLayers();
}

function baixaControl(idcontrol){
    var control = document.getElementById(idcontrol);
    var clonControl = control.cloneNode(true);
    var contenidorControl = document.getElementById('llistacapes');
    var controlSeguent = YAHOO.util.Dom.getNextSibling(idcontrol);
    if(controlSeguent){
        contenidorControl.removeChild(control);
        contenidorControl.insertBefore(clonControl, controlSeguent.nextSibling);
    }
    ajustaOrdreLayers();
}

function ajustaOrdreLayers(){
    var contenidorControl = document.getElementById('llistacapes');
    var nodeList = YAHOO.util.Dom.getChildren(contenidorControl);
    var llistaCapes = new Array();
    var index = 0;
    for(var i = nodeList.length-1; i >= 0; i--){
        var capa = getCapaDeIdLlista(nodeList[i].id);
        if(capa){
            if(capa.getVisibility()){
                llistaCapes[index] = capa;
                index++;
            }
        }
    }
    var posicioLayer = 3;
    for(i = 0; i < llistaCapes.length; i++){
        map.setLayerIndex(llistaCapes[i],posicioLayer);
        posicioLayer++;
    }
}

function getCapaDeIdLlista(idLlista){
    return map.getLayersByName(idLlista)[0];
}

function obreUll(actiu,iconaVis){
    if(actiu){
        iconaVis.setAttribute("class", "veurecapa");
    }else{
        iconaVis.setAttribute("class", "noveurecapa");
    }
}

function mostrarAmagarCapa(idIcona, nomCapa){
    var iconaVis = document.getElementById(idIcona);
    var capa = getCapaDeIdLlista(nomCapa);
    if(capa!=null){
        if(capa.getVisibility()){
            capa.setVisibility(false);
            obreUll(false,iconaVis);
        }else{
            capa.setVisibility(true);
            obreUll(true,iconaVis);
        }
    }
    ajustaOrdreLayers();
}

function readCookie(name) {
    var nameEQ = name + "=";
    var ca = document.cookie.split(';');
    for(var i=0;i < ca.length;i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1,c.length);
        if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
    }
    return null;
}



