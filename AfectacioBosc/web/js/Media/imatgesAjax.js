YAHOO.namespace("example.container");



function mostrarImatgeLoading(){
    document.getElementById('loadingimatges').style.display='block';
}

function amagarImatgeLoading(){
    document.getElementById('loadingimatges').style.display='none';
}

function previousImatges(){
    mostrarImatgeLoading();
    curpos = curpos-9;
    bloquejarBotonsPreviousNext();
    var url = urlLlistarJSON + "&pos="+curpos;
    getImatgesAjax(url);
}

function nextImatges(){
    mostrarImatgeLoading();
    curpos = curpos+9;
    bloquejarBotonsPreviousNext();
    var url = urlLlistarJSON+"&pos="+curpos;
    getImatgesAjax(url);
}

function bloquejarBotonsPreviousNext(){
    document.getElementById("btnprevious").disabled = (curpos==0);
    document.getElementById("btnnext").disabled = (curpos+9>=numFotos);
}

var curpos, items = [];
var ids = [];
curpos = 0;
var carousel;
/*Cal posar aquesta variable a true si es vol que aparegui la icona de la creu
 * per poder eliminar imatges.
 */
var esPossibleEliminarImatges = false;

function getImageTag(id,titol) {
    var retVal = "<div class='fotothmb'>";
    var urlImg = "http://"+urlServidor+"/AfectacioBosc/grafics_temp/"+id+"_thn.jpg";
    var titolReduit = titol;
    if(titol.length>20){
        titolReduit = titol.substring(0,20) + "...";
    }
    retVal += "<a onclick='javascript:popUpImatge(\""+id+"\");return false;'>"+"<img src=\"" + urlImg + "\" height=\"75\" width=\"75\" alt=\""+titol+"\"/>"+"</a><br/>";
    retVal += "<a onclick='javascript:popUpImatge(\""+id+"\");return false;'>"+titolReduit+"</a>";
    if(esPossibleEliminarImatges){
        retVal += "<a class='botoesborrar' onclick='javascript:esborrarFoto(\""+id+"\");return false;'>&nbsp;</a>";
    }
    retVal += "</div>";
    return retVal;
}

function popUpImatge(id){
    var urlImg = "/AfectacioBosc/general/visualitzarfoto.htm?id="+id;
    obrirpopup(urlImg);
}

function getImatgesAjax(url){
    var callback = {
        success: function (o) {
            imatges = YAHOO.lang.JSON.parse(o.responseText).records;
            
            var tag;

           // document.getElementById("taulaimatges").innerHTML = "";
            var textTaula = "<table class='blanc'>";
                for (i = 0; i < imatges.length; i++) {
                    if(i%3==0)
                        textTaula += "<tr>";
                    tag = getImageTag(imatges[i].id,imatges[i].titol);
                    //document.getElementById("taulaimatges").innerHTML += tag;
                    textTaula += "<td>"+tag+"</td>";
                    if(i%3==2)
                        textTaula += "</tr>";
                }
                textTaula += "</table>";
                document.getElementById("taulaimatges").innerHTML = textTaula;
                document.getElementById("contadorImatges").innerHTML = (curpos+1)+"/"+(parseInt(numFotos/9)+1);
                amagarImatgeLoading();
                document.getElementById('tabimg').style.display='block';

        },

        failure: function (o) {
            YAHOO.example.container.wait.hide();
            alert("Ajax request failed!");
        }
    }

    YAHOO.util.Connect.asyncRequest("GET", url,callback);
}


function getImages() {
    var url = urlLlistarJSON+"&pos="+curpos;
    getImatgesAjax(url);
}
var imatges;
YAHOO.util.Event.onContentReady("tabimg", function () {
mostrarImatgeLoading();
    var url = urlLlistarJSON;
    curpos = 0;
    bloquejarBotonsPreviousNext();
    getImatgesAjax(url);
});


function esborrarFoto(idfoto,target){
    if (confirm(txtTaula.MSG_CONFIRMESBORRAR)) {
        mostrarImatgeLoading();
        var url = "http://"+urlServidor+"/AfectacioBosc/sequeres/edicio/esborrarfoto.htm?idfoto="+idfoto;
        cridaAJAXEsborrarFoto(url,target);
    }
}

function cridaAJAXEsborrarFoto(sUrl,target){
    var callback = {
        success: function(o) {
            numFotos--;
            if(curpos>=numFotos){
                curpos = curpos - 9;
            }
            getImages();
        },
        failure: function(o) {
            alert("La crida asincrona en AJAX no ha funcionat"); //FAILURE
        }
    }
    var transaction = YAHOO.util.Connect.asyncRequest("GET", sUrl, callback, null);
}