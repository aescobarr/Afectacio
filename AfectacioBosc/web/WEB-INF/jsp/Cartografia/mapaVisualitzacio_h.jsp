<script type="text/javascript" src="../../openlayers/OpenLayers.js"></script>
<script type="text/javascript">
var map, vectors, controls,tiled;
function initMapa(){
    OpenLayers.Lang.es = {
        'baseLayer': "Capa Base"
    };
    OpenLayers.Lang.ca = {
        'baseLayer': "Capa Base"
    };
    OpenLayers.Lang.setCode('es');

    var optionsMap = {
        maxExtent: new OpenLayers.Bounds(258235.00,4486328.00,532736.00,4750036.00),
        maxResolution: 'auto',
        units: "m",
        projection: "EPSG:23031"
    }
    map = new OpenLayers.Map('map',optionsMap);

    var ortos = new OpenLayers.Layer.WMS( "Ortofotomapa",
    "http://www.opengis.uab.es/cgi-bin/catalunya/MiraMon5_0.cgi",
    {
        layers: 'Orto5k_Versio3_ICC-catalunya',
        format: 'image/gif'
    } );

    var topo5m = new OpenLayers.Layer.WMS( "Topogràfic 5000m",
    "http://shagrat.icc.es/lizardtech/iserv/ows",
    {
        layers: 'mtc5m',
        format: 'image/png',
        EXCEPTIONS: "application/vnd.ogc.se_xml"
    } );

    var topo50m = new OpenLayers.Layer.WMS( "Topogràfic 50000m",
    "http://shagrat.icc.es/lizardtech/iserv/ows",
    {
        layers: 'mtc50m',
        format: 'image/png',
        EXCEPTIONS: "application/vnd.ogc.se_xml"
    } );


    

    OpenLayers.Feature.Vector.style['default']['strokeWidth'] ='2';
    vectors = new OpenLayers.Layer.Vector("Capa de punts",
    {
        'displayInLayerSwitcher':false
    });

    var overviewOptions = {
        mapOptions: optionsMap
    }
    var overviewMap = new OpenLayers.Control.OverviewMap(overviewOptions);
    var layersSwitch = new OpenLayers.Control.LayerSwitcher({
        'ascending':false ,
        'dataLayers':null
    });

    bubble = new OpenLayers.Control.WMSGetFeatureInfo({
        url: 'http://localhost/geoserver/wms',
        title: 'Identify features by clicking',
        queryVisible: true,
        eventListeners: {
            getfeatureinfo: function(event) {
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
    });

    map.addLayers([topo50m,topo5m,ortos,tiled]);
    map.addControl(new OpenLayers.Control.ScaleLine());    
    map.addControl(overviewMap);
    map.addControl(bubble);    
    bubble.activate();
    map.addControl(layersSwitch);
    map.zoomToMaxExtent();
}


var mapa;
var pareMapa;
var hideMapa;
var pareAmagarMapa;
var iniciat = false;
function amagarMapa(){
    if(mapa==null){
        mapa = document.getElementById('map');
        pareMapa = mapa.parentNode;
    }
    pareMapa.removeChild(mapa);
    hideMapa = document.getElementById('hidemap');
    pareAmagarMapa = hideMapa.parentNode;
    pareAmagarMapa.removeChild(hideMapa);
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
        //pareMapa = null;
       // mapa = null;
        //if(!iniciat){
            map.zoomToMaxExtent();
          if(pareAmagarMapa!=null && document.getElementById('hidemap')==null){
            pareAmagarMapa.appendChild(hideMapa);
          }
          //  iniciat = true;
       // }
}

function getFilaInfoText(event){
    var taula = document.createElement('table');
    var cadenaTaula = 'No hi ha cap actuació!';
    var cadenaFila;
    var i;
    if(taula){
        cadenaTaula = '<table class="estil1"><tbody>';
        taula.innerHTML = event.text;
        for ( i = 1; i < taula.getElementsByTagName('tr').length; i++){
            var fila = taula.getElementsByTagName('tr')[i];
            if(fila){
                cadenaFila = '<tr><td><a href="#" onclick="javascript:visualitzar(\'' +
                fila.getElementsByTagName('td')[1].innerHTML + '\')" >' +
                fila.getElementsByTagName('td')[2].innerHTML + '</a></td><td>' +
                fila.getElementsByTagName('td')[4].innerHTML + '</td></tr>';
                cadenaTaula = cadenaTaula + cadenaFila;
            }
        }
    cadenaTaula = cadenaTaula + '</tbody></table>';
}
//return cadenaTaula;
//return event.text;
return cadenaTaula;
}

</script>
