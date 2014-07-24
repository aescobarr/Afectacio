<div class="anar_carto">
    <div class="element_anar_carto">
        <img style="visibility:hidden" id="progresnocarregares" src="<c:url value='/grafics/indicator.white.gif'/>" width="16" height="16" alt="indicator.white"/>
        <select id="comboprovincies" name="comboprovincies" onchange="consultaAjax(this,'combocomarques','comarca','progrescarregacomarca')">
            <option id="provincia_nosel" value=""><fmt:message key="provincia"  bundle="${bundleSIPAN}"/>...</option>
            <option id="1" value="provincia_8">Barcelona</option>
            <option id="2" value="provincia_17">Girona</option>
            <option id="3" value="provincia_25">Lleida</option>
            <option id="4" value="provincia_43">Tarragona</option>
        </select>
    </div>
    <div class="element_anar_carto">
        <img style="visibility:hidden" id="progrescarregacomarca" src="<c:url value='/grafics/indicator.white.gif'/>" width="16" height="16" alt="indicator.white"/>
        <select id="combocomarques" name="combocomarques" onchange="consultaAjax(this,'combomunicipis','municipi','progrescarregamunicipi')" disabled="true"></select>
    </div>
    <div class="element_anar_carto">
        <img style="visibility:hidden" id="progrescarregamunicipi" src="<c:url value='/grafics/indicator.white.gif'/>" width="16" height="16" alt="indicator.white"/>
        <select id="combomunicipis" name="combomunicipis" disabled="true"></select>
    </div>     
    <div class="element_anar_carto">
        <input type="button" value="Anar-hi" onclick="javascript:anarAMapa();return false;" />        
    </div>
</div>
        
<script type="text/javascript" src="<c:url value='/js/ajax.js' />"></script>
<script type="text/javascript">
    var ajax = new Array();
        
    function consultaAjax(sel,nomComboAOmplir,parametreTipusObjecte,nomIconaProgres){
        var codi = sel.options[sel.selectedIndex].value;
        document.getElementById(nomComboAOmplir).options.length = 0;
        if(codi .length>0){
            mostraIconaCarrega(nomIconaProgres);
            var index = ajax.length;
            ajax[index] = new sack();
            document.getElementById(nomComboAOmplir).disabled = true;
            // Nom del servei
            ajax[index].requestFile = "<c:url value='/general/llistarlimitsadministratius.htm?'/>" + "retorna=" + parametreTipusObjecte + '&codi=' + codi;
            //ajax[index].requestFile = "../../general/llistarlimitsadministratius.htm?retorna=" + parametreTipusObjecte + '&codi=' + codi;
            // Funció que s'executa després de recuperar la llista del servei
            ajax[index].onCompletion = function(){ creaLlistaACombo(index, nomComboAOmplir, nomIconaProgres)};
            // Execute AJAX function
            ajax[index].runAJAX();
        }
    }

    function creaLlistaACombo(index,nomCombo, nomIconaProgres){
        var obj = document.getElementById(nomCombo);
        eval(ajax[index].response);	// Executing the response from Ajax as Javascript code
        amagaIconaCarrega(nomIconaProgres);
        document.getElementById(nomCombo).disabled = false;
    }

    function mostraIconaCarrega(nomIcona){
        var e = document.getElementById(nomIcona);
        e.style.visibility='visible';
    }

    function amagaIconaCarrega(nomIcona){
        var e = document.getElementById(nomIcona);
        e.style.visibility='hidden';
    }

    function anarAMapa(){
       var selectMunicipis = document.getElementById('combomunicipis');
        var selectComarques = document.getElementById('combocomarques');
        var xy = "-1";
        if(selectMunicipis.selectedIndex>0){
            xy = selectMunicipis[selectMunicipis.selectedIndex].value;
            //alert(selectMunicipis[selectMunicipis.selectedIndex].value);
            //alert(selectMunicipis[selectMunicipis.selectedIndex].text);
            //alert(selectMunicipis[selectMunicipis.selectedIndex].id);
            //document.dades.idmunicipi.value = selectMunicipis.selectedIndex;
        }else if(selectComarques.selectedIndex>0){
            xy = selectComarques[selectComarques.selectedIndex].value;
            //document.dades.idcomarca.value = selectComarques.selectedIndex;
        }
        if(xy!="-1"){
            //document.dades.xy.value = xy;
            var index0 = xy.indexOf("&",0);
            var index1 = xy.indexOf("&",index0+1);
            var minX = xy.substring(index0+1,index1);
            index0 = index1+1;
            index1 = xy.indexOf("&",index0);
            var maxX = xy.substring(index0,index1);
            index0 = index1+1;
            index1 = xy.indexOf("&",index0);
            var minY = xy.substring(index0,index1);
            index0 = index1+1;
            index1 = xy.length;
            var maxY = xy.substring(index0,index1);
            var bounds = new OpenLayers.Bounds();
            bounds.extend(new OpenLayers.LonLat(minX,minY));
            bounds.extend(new OpenLayers.LonLat(maxX,maxY));
            map.zoomToExtent(bounds,false);
        }
    }

</script>