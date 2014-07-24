       <script type="text/javascript">
            var urlServidor = "${ip}";
            var numFotos = ${numFotos};
            var idSequera = "${afectacio.idString}";
            var urlLlistarJSON = "http://"+urlServidor+"/AfectacioBosc/sequeres/llistarfotossequerajson.htm?idafectacio="+idSequera;
            
        </script>
        <script type="text/javascript" src="<c:url value='/js/Estructura/menu.js' />"></script>
        <script type="text/javascript" src="<c:url value='/js/Estructura/pestanyer.js' />"></script>
        <script type="text/javascript" src="<c:url value='/js/general.js' />"></script>
        <script type="text/javascript" src="<c:url value='/js/Media/imatgesAjax.js' />"></script>
        <script type="text/javascript" src="<c:url value='/js/Utils/missatgeError.js' />"></script>
        <script type="text/javascript">

           /* var novaURL = '';
            var funcioDesar = function desar(){
               var missatges = getMissatgesError();
               if(validaDades(missatges)){
                    document.dades.novaurl.value = novaURL;
                    document.dades.action = "<c:url value='/actuacions/edicio/editarfotosactuacio.htm'/>";
                    document.dades.submit();
                }
            }

            var funcioDescartarCanvis = function descartarCanvis(){
                document.dades.action = "/SIPAN"+novaURL;
                document.dades.method = "GET";
                document.dades.submit();
            }

            var funcioDesarIAnar = function desarIAnar(url){
                novaURL = url;
                funcioDesar();
//                novaURL = url;
//                if(hihacanvis){
//                    YAHOO.example.missatgeConfirmacio.simpledialog1.show();
//                }else{
//                    document.dades.action = '/SIPAN'+url;
//                    document.dades.method = 'GET';
//                    document.dades.submit();
//                }
            }
*/
            esPossibleEliminarImatges = true;
/*
            function getMissatgesError(){
                var missatges = new Array();
                var index = 0;
                return missatges;
            }*/
/*
            function validaDades(){
                var esValid = true;
                return esValid;
            }

            function validaDadesInici(){
                var esValid = true;
                var missatge = "<h3><fmt:message key="avis" bundle="${bundleSIPAN}" /></h3><ul>";
                <c:if test="${exception!=null}">
                    esValid = false;
                    missatge += "<li>${exception}</li>";
                </c:if>
                if(!esValid){
                    var caixa = document.getElementById("errors");
                    caixa.innerHTML = missatge+"</ul>";
                    caixa.style.visibility = "visible";
                }
                return esValid;
            }*/

            function descarregar(id){
                obrirpopup('<c:url value='/media/visualitzardocument.htm'/>?id='+id);
            }

            /*

            function eliminarDocument(){
                document.dades.eliminarDocument.value = "S";
                document.getElementById('nomdocument').innerHTML = "<p><fmt:message key='noTeDocument' bundle='${bundleSIPAN}' /></p>";
            }*/

//YAHOO.util.Event.addListener(window, "load", init);
        </script>

<div class="etiqueta"><fmt:message key="document" bundle="${bundleSIPAN}" />:</div><div class="entradadades"><input type="file" name="file1" /></div>
<div class="etiqueta"><fmt:message key="document" bundle="${bundleSIPAN}" />:</div><div class="entradadades"><input type="file" name="file2" /></div>
<div class="etiqueta"><fmt:message key="document" bundle="${bundleSIPAN}" />:</div><div class="entradadades"><input type="file" name="file3" /></div>
<div class="separadorGran"></div>
                        
<div class="campformulari"><div class="etiqueta"><label></label></div><div class="entradadades">
    <div id="tabimg">
        <input id="btnprevious" type="button" onclick="javascript:previousImatges();return false;" value="<" />
        <span id="contadorImatges"></span>
        <input id="btnnext" type="button" onclick="javascript:nextImatges();return false;" value=">" />
        <img id="loadingimatges" src="<c:url value='/grafics/rel_interstitial_loading.gif'/>" alt=""/>
        <div id="taulaimatges"></div>
        <div class="separadorPetit"></div>
        </div>
    </div>
</div>
