YAHOO.namespace("example.container");

function initBarraProgres() {

    if (!YAHOO.example.container.wait) {


        YAHOO.example.container.wait =
            new YAHOO.widget.Panel("wait",
        {width: "240px",
            fixedcenter: true,
            close: false,
            draggable: true,
            zindex:4,
            modal: false,
            visible: false
        }
    );

        YAHOO.example.container.wait.setHeader(txtBarraProgres.LOADING);
        YAHOO.example.container.wait.setBody("<img src=\"http://l.yimg.com/a/i/us/per/gr/gp/rel_interstitial_loading.gif\"/>");
        var elementImatges = document.getElementById('containerimatges');
        YAHOO.example.container.wait.render(elementImatges);

    }

    YAHOO.example.container.wait.show();
}

var curpos, items = [];
var ids = [];
curpos = 0;
var carousel;
/*Cal posar aquesta variable a true si es vol que aparegui la icona de la creu
 * per poder eliminar imatges.
 */
var esPossibleEliminarImatges = false;

/*
function esborrarImatge(id){
     if (confirm(txtTaula.MSG_CONFIRMESBORRAR)) {
        var idsAEsborrar = document.getElementById('idsaesborrar');
        idsAEsborrar.value += '&' + id;
        marcarCanvis();
     }
}
*/
function getImageTag(id,titol) {
    var retVal = "<div >";
    var urlImg = "http://"+urlServidor+"/SIPAN/grafics_temp/"+id+"_thn.jpg";

    retVal += "<a onclick='javascript:popUpImatge(\""+id+"\");return false;'>"+"<img src=\"" + urlImg + "\" height=\"75\" width=\"75\" />"+"</a><br/>";
    retVal += "<a onclick='javascript:popUpImatge(\""+id+"\");return false;'>"+titol+"</a>";
    if(esPossibleEliminarImatges){
        retVal += "<a class='botoesborrar' onclick='javascript:esborrarFoto(\""+id+"\");return false;'>&nbsp;</a>";
    }
    retVal += "</div>";
    return retVal;
}

function popUpImatge(id){
    var urlImg = "/SIPAN/media/visualitzarfoto.htm?id="+id;
    obrirpopup(urlImg);
}

function getImatgesAjax(url){
    YAHOO.util.Connect.asyncRequest("GET", url,{
        success: function (o) {
            YAHOO.example.container.wait.hide();
            imatges = YAHOO.lang.JSON.parse(o.responseText).records;
            curpos = curpos+9;
            var tag;
            if (typeof carousel != "undefined") {
                for (i = 0; i < imatges.length; i++) {
                    tag = getImageTag(imatges[i].id,imatges[i].id);
                    carousel.addItem(tag);
                }
            }
            alert(carousel.get("lastVisible"));
            carousel.set("selectedItem",  carousel.get("lastVisible"));

        },

        failure: function (o) {
            YAHOO.example.container.wait.hide();
            alert("Ajax request failed!");
        }
    });
}


function getImages() {
    carousel = this;
    var url = "http://"+urlServidor+"/SIPAN/enps/llistarfotosenpjson.htm?idenp="+idENP+"&pos="+curpos;
    getImatgesAjax(url);
}
var imatges;
YAHOO.util.Event.onContentReady("tabimg", function () {
    initBarraProgres();
    carousel = new YAHOO.widget.Carousel("containerimatges",
        {numItems: numFotos,
            numVisible: [3,3],
            isCircular: false
        }
    );


    var url = "http://"+urlServidor+"/SIPAN/enps/llistarfotosenpjson.htm?idenp="+idENP;
    var callback = {
        success: function (o) {
            YAHOO.example.container.wait.hide();
            imatges = YAHOO.lang.JSON.parse(o.responseText).records;
            curpos = 9;
            if (typeof carousel != "undefined") {
                if(imatges.length==0){
                    carousel.addItem("<div ></div>");
                }
                for (i = 0; i < imatges.length; i++) {
                    carousel.addItem(getImageTag(imatges[i].id,imatges[i].id));
                }
            }

        },

        failure: function (o) {
            YAHOO.example.container.wait.hide();
            alert("Ajax request failed!");
        }
    };
    YAHOO.util.Connect.asyncRequest("GET", url,callback);

    carousel.on("loadItems", function (o) {alert('eoo');
        YAHOO.example.container.wait.show();
        getImages.call(this);
    });
    carousel.registerPagination("{firstVisible} - {lastVisible} <strong>/</strong> {numItems}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
    carousel.render();
    carousel.show();
});