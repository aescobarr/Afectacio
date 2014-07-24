var Dom = YAHOO.util.Dom,
Event = YAHOO.util.Event,
myDataSource = null,
myDataTable = null;


var reqBuild = function requestBuilder(oState, oSelf) {
    var startIndex, results, sort, dir;

    oState = oState || {
        pagination: null,
        sortedBy: null
    };
    sort = (oState.sortedBy) ? oState.sortedBy.key : oSelf.getColumnSet().keys[0].getKey();
    dir = (oState.sortedBy && oState.sortedBy.dir === YAHOO.widget.DataTable.CLASS_DESC) ? "desc" : "asc";
    startIndex = (oState.pagination) ? oState.pagination.recordOffset : 0;
    results = (oState.pagination) ? oState.pagination.rowsPerPage : null;
    return  "&results=" 	+ results +
    "&startIndex=" 	+ startIndex +
    "&sort=" + sort +
    "&dir=" + dir;
};


Event.onDOMReady(function() {

    var formatUrl = function(elCell, oRecord, oColumn, sData) {
        elCell.innerHTML = sData;
    };

    var formatImprimirUrl = function(elCell, oRecord, oColumn, sData) {
        elCell.innerHTML = "<a class='print' href='#' onclick=\"javascript:visualitzar('"+oRecord.getData("id")+"')\">&nbsp;</a>";
    };

    var formatEditarUrl = function(elCell, oRecord, oColumn, sData) {
        elCell.innerHTML = "<a class='botoeditar' href='#' onclick=\"javascript:editar('"+oRecord.getData("id")+"')\">&nbsp;</a>";
    };

    var formatEsborrarUrl = function(elCell, oRecord, oColumn, sData) {
        elCell.innerHTML = "<a class='botoesborrar' href='#' onclick=\"javascript:esborrar('"+oRecord.getData("id")+"')\">&nbsp;</a>";
    };

    var myColumnDefs = new Array();

    myColumnDefs[0] = {
        key:"codi",
        label:txtCodi,
        sortable:true,
        resizeable:true,
        formatter:formatUrl
    };
    myColumnDefs[1] = {
        key:"especie1",
        label:txtEspecie1,
        sortable:true,
        resizeable:true,
        formatter:formatUrl
    };
     myColumnDefs[2] = {
        key:"grauAfectacioEspecie1",
        label:txtGrauAfectacioEspecie1,
        sortable:true,
        resizeable:true,
        formatter:formatUrl
    };
     myColumnDefs[3] = {
        key:"areaAfectada",
        label:txtArea,
        sortable:false,
        resizeable:true,
        formatter:formatUrl
    };
     myColumnDefs[4] = {
        key:"data",
        label:txtData,
        sortable:true,
        resizeable:true,
        formatter:formatUrl
    };
     myColumnDefs[5] = {
        key:"codiAgent1",
        label:txtResponsable1,
        sortable:true,
        resizeable:true,
        formatter:formatUrl
    };
     myColumnDefs[6] = {
        key:"codiAgent2",
        label:txtResponsable2,
        sortable:true,
        resizeable:true,
        formatter:formatUrl
    };
     myColumnDefs[7] = {
        key:"imprimir",
        label:"",
        sortable:false,
        resizeable:false,
        formatter:formatImprimirUrl
    };


        if(editable){            
            myColumnDefs[8] = {
                key:"editar",
                label:"",
                sortable:false,
                resizeable:false,
                formatter:formatEditarUrl
            };
            if(esborrable){
                myColumnDefs[9] = {
                    key:"esborrar",
                    label:"",
                    sortable:false,
                    resizeable:false,
                    formatter:formatEsborrarUrl
                };
            }
        }else if(esborrable){
            myColumnDefs[8] = {
                key:"esborrar",
                label:"",
                sortable:false,
                resizeable:false,
                formatter:formatEsborrarUrl
            };
        }
                    
    var myResponseSchema = {
        resultsList: "records",
        fields: ["id","codi","especie1","grauAfectacioEspecie1","areaAfectada","data","codiAgent1","codiAgent2"],
        metaFields: {
            totalRecords: "totalRecords",
            sort: "sort",
            dir: "dir"
        }
    };    
    myDataSource = new YAHOO.util.XHRDataSource(urlElementsTaulaJSON);
    myDataSource.responseType = YAHOO.util.XHRDataSource.TYPE_JSON;
    myDataSource.responseSchema = myResponseSchema;
    myConfigs = {
        initialRequest: "sort=codi&dir=asc&startIndex=0&results=25",
        dynamicData: true,
        sortedBy : {
            key:"codi",
            dir:YAHOO.widget.DataTable.CLASS_ASC
        },
        paginator: new YAHOO.widget.Paginator({
            rowsPerPage:25,
            firstPageLinkLabel: "<<",
            lastPageLinkLabel:">>",
            previousPageLinkLabel : "<",
            nextPageLinkLabel: ">"
        }),
        generateRequest: reqBuild,
        MSG_EMPTY:txtTaula.MSG_EMPTY,
        MSG_ERROR:txtTaula.MSG_ERROR,
        MSG_LOADING:txtTaula.MSG_LOADING,
        MSG_SORTASC:txtTaula.MSG_SORTASC,
        MSG_SORTDESC:txtTaula.MSG_SORTDESC
    };

    myDataTable = new YAHOO.widget.DataTable("taulaDinamica", myColumnDefs, myDataSource, myConfigs);

    myDataTable.handleDataReturnPayload = function(oRequest, oResponse, oPayload) {
        oPayload.totalRecords = oResponse.meta.totalRecords;
        return oPayload;
    }
});










var myDataTableRegeneracio;


YAHOO.util.Event.onContentReady("dadesregeneracio",function() {
    var especiesFormatter = function(el, oRecord, oColumn, oData) {
                    var combo = especiesAOferir;
                    for (var i = 0;i<combo.length;i++) {
                       if (oData == combo[i].especie) {
                          oRecord.setData('idespecie',combo[i].id);
                          el.innerHTML = combo[i].especie;
                          return;
                       }
                    }
                }
    

    YAHOO.example.InlineCellEditing = function() {
        var formatAddress = function(elCell, oRecord, oColumn, oData) {
            elCell.innerHTML = "<pre class=\"address\">" + oData + "</pre>";
        };

        var myColumnDefs = [
            {key:"especie",label: txtEspecie,formatter:especiesFormatter,editor: new YAHOO.widget.DropdownCellEditor({dropdownOptions:especiesAOferir,disableBtns:true})},
            {key:"abundancia", label:txtAbundancia, editor: new YAHOO.widget.RadioCellEditor({radioOptions:["Baixa","Alta"],disableBtns:true})},
            {key:"individus", label:txtIndividus, editor: new YAHOO.widget.RadioCellEditor({radioOptions:["<50%",">50%"],disableBtns:true})},
            {key:"esborrar", label:"", className:'linkEsborrar'}
        ];

        myDataSource = new YAHOO.util.DataSource(dadesRegeneracio.regeneracio);
        myDataSource.responseType = YAHOO.util.DataSource.TYPE_JSARRAY;
        myDataSource.responseSchema = {
            fields: ["id","idespecie","especie","abundancia","individus","ordre",{key:"id"}]
        };

        var myConfigs = {
            MSG_EMPTY:txtTaula.MSG_EMPTY,
            MSG_ERROR:txtTaula.MSG_ERROR,
            MSG_LOADING:txtTaula.MSG_LOADING,
            MSG_SORTASC:txtTaula.MSG_SORTASC,
            MSG_SORTDESC:txtTaula.MSG_SORTDESC}
        myDataTableRegeneracio = new YAHOO.widget.DataTable("taularegeneracio", myColumnDefs, myDataSource, myConfigs);

        // Set up editing flow
        var highlightEditableCell = function(oArgs) {
            var elCell = oArgs.target;
            if(YAHOO.util.Dom.hasClass(elCell, "yui-dt-editable")) {
                this.highlightCell(elCell);
            }
        };
        myDataTableRegeneracio.subscribe("cellMouseoverEvent", highlightEditableCell);
        myDataTableRegeneracio.subscribe("cellMouseoutEvent", myDataTableRegeneracio.onEventUnhighlightCell);
        myDataTableRegeneracio.subscribe("cellClickEvent", myDataTableRegeneracio.onEventShowCellEditor);

        myDataTableRegeneracio.subscribe('cellClickEvent',function(oArgs) {
            var target = oArgs.target;
            var column = myDataTableRegeneracio.getColumn(target);
            if (column.key == 'esborrar') {
                if (confirm('Segur?')) {
                    myDataTableRegeneracio.deleteRow(target);
                }
            } else {
                myDataTableRegeneracio.onEventShowCellEditor(oArgs);
            }
        });

        var onButtonAfegirClick = function onButtonClick(p_oEvent) {
            var posicio = myDataTableRegeneracio.getRecordSet().getLength();
            myDataTableRegeneracio.addRow( {id:"-1", especie:"",abundancia:"",individus:"",ordre:posicio+1} , posicio);
        };

        var afegirButton = new YAHOO.widget.Button("afegir", {
            onclick: {
                fn: onButtonAfegirClick
            }
        });

        return {
            oDS: myDataSource,
            oDT: myDataTableRegeneracio
        };
    }();
});

function getDadesRegeneracio(){
    var set = myDataTableRegeneracio.getRecordSet();
    var jsonStr = YAHOO.lang.JSON.stringify(set);
    document.dades2.elements['idsDadesRegeneracio'].value = jsonStr;
}







var myDataTableEstimacions;


YAHOO.util.Event.onContentReady("dadesestimacions",function() {
    var especiesFormatter = function(el, oRecord, oColumn, oData) {
                    var combo = especiesAOferir;
                    for (var i = 0;i<combo.length;i++) {
                       if (oData == combo[i].especie) {
                          oRecord.setData('idespecie',combo[i].id);
                          el.innerHTML = combo[i].especie;
                          return;
                       }
                    }
                }

    var canviMFormatter = function(el, oRecord, oColumn, sData) {
        if(oRecord._oData.canvimortalitat=="I"){
            el.innerHTML = txtCanviIgual;
        }else if(oRecord._oData.canvimortalitat=="M"){
            el.innerHTML = txtCanviMillor;
        }else if(oRecord._oData.canvimortalitat=="P"){
            el.innerHTML = txtCanviPitjor;
        }else{
            el.innerHTML = "";
        }        
    };
    
    var canviDFFormatter = function(el, oRecord, oColumn, sData) {
        if(oRecord._oData.canvidefoliacio=="I"){
            el.innerHTML = txtCanviIgual;
        }else if(oRecord._oData.canvidefoliacio=="M"){
            el.innerHTML = txtCanviMillor;
        }else if(oRecord._oData.canvidefoliacio=="P"){
            el.innerHTML = txtCanviPitjor;
        }else{
            el.innerHTML = "";
        }        
    };
    
    var canviDCFormatter = function(el, oRecord, oColumn, sData) {
        if(oRecord._oData.canvidecoloracio=="I"){
            el.innerHTML = txtCanviIgual;
        }else if(oRecord._oData.canvidecoloracio=="M"){
            el.innerHTML = txtCanviMillor;
        }else if(oRecord._oData.canvidecoloracio=="P"){
            el.innerHTML = txtCanviPitjor;
        }else{
            el.innerHTML = "";
        }        
    };
    
    var rebrotsFormatter = function(el, oRecord, oColumn, sData) {
        if(oRecord._oData.rebrots=="N"){
            el.innerHTML = txtRebrotsNo;
        }else if(oRecord._oData.rebrots=="S"){
            el.innerHTML = txtRebrotsSoca;
        }else if(oRecord._oData.rebrots=="C"){
            el.innerHTML = txtRebrotsCapcada;
        }else{
            el.innerHTML = "";
        }        
    }

    YAHOO.example.InlineCellEditing = function() {
        var val = function(e) {
            e = e.replace(",",".");
            if(e==''){
            }else if((isInteger(e) || isDouble(e)) && e>=0 && e<=100){
                return e;
            }else if(e!==null){
                alert(txtErrorEdicioCelaPercentatge);
            }
        };

        var editorPercentatge = new YAHOO.widget.TextboxCellEditor({resetInvalidData:false,validator:val,disableBtns:true});
        
        var myColumnDefs = [
            {key:"especie",label: txtEspecie,formatter:especiesFormatter,editor: new YAHOO.widget.DropdownCellEditor({dropdownOptions:especiesAOferir,disableBtns:true})},
            {key:"recobriment", label:txtRecobriment, editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true})},
            {key:"arbre", label:txtArbre, editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true})},
            {key:"arbresafectats", label:txtArbreAfectat, editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true})},
            {key:"percmortalitat", label:txtPercM, editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true})},
            {key:"percdefoliacio", label:txtPercDF, editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true})},
            {key:"percdecoloracio", label:txtPercDC, editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true})},
            {key:"canvimortalitat", label:txtCanviM, formatter:canviMFormatter, editor: new YAHOO.widget.RadioCellEditor({radioOptions:[{label:txtCanviPitjor, value:"P"}, {label:txtCanviIgual, value:"I"}, {label:txtCanviMillor, value:"M"}],disableBtns:true})},
            {key:"canvidefoliacio", label:txtCanviDF, formatter:canviDFFormatter, editor: new YAHOO.widget.RadioCellEditor({radioOptions:[{label:txtCanviPitjor, value:"P"}, {label:txtCanviIgual, value:"I"}, {label:txtCanviMillor, value:"M"}],disableBtns:true})},
            {key:"canvidecoloracio", label:txtCanviDC, formatter:canviDCFormatter, editor: new YAHOO.widget.RadioCellEditor({radioOptions:[{label:txtCanviPitjor, value:"P"}, {label:txtCanviIgual, value:"I"}, {label:txtCanviMillor, value:"M"}],disableBtns:true})},
            {key:"rebrots", label:txtRebrots, formatter:rebrotsFormatter, editor: new YAHOO.widget.RadioCellEditor({radioOptions:[{label:txtRebrotsNo, value:"N"}, {label:txtRebrotsSoca, value:"S"}, {label:txtRebrotsCapcada, value:"C"}],disableBtns:true})},
            {key:"tipusAfectacio", label:txtTipusAfectacio, editor: new YAHOO.widget.CheckboxCellEditor({checkboxOptions:["M","DF","DC"],disableBtns:true})},
            {key:"afectacio", label:txtGrauAfectacio, editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true})},
            {key:"esborrar", label:"", className:'linkEsborrar'}
        ];

        myDataSource = new YAHOO.util.DataSource(dadesEstimacions.estimacions);
        myDataSource.responseType = YAHOO.util.DataSource.TYPE_JSARRAY;
        myDataSource.responseSchema = {
            fields: ["id","ordre","tipusAfectacio","arbre","arbresafectats",
                "percmortalitat","percdefoliacio","percdecoloracio","canvimortalitat",
                "canvidefoliacio","canvidecoloracio","rebrots","idespecie","especie",
                "recobriment","afectacio",{key:"id"}]
        };

        var myConfigs = {
            MSG_EMPTY:txtTaula.MSG_EMPTY,
            MSG_ERROR:txtTaula.MSG_ERROR,
            MSG_LOADING:txtTaula.MSG_LOADING,
            MSG_SORTASC:txtTaula.MSG_SORTASC,
            MSG_SORTDESC:txtTaula.MSG_SORTDESC}
        myDataTableEstimacions = new YAHOO.widget.DataTable("taulaestimacions", myColumnDefs, myDataSource, myConfigs);

        // Set up editing flow
        var highlightEditableCell = function(oArgs) {
            var elCell = oArgs.target;
            if(YAHOO.util.Dom.hasClass(elCell, "yui-dt-editable")) {
                this.highlightCell(elCell);
            }
        };
        myDataTableEstimacions.subscribe("cellMouseoverEvent", highlightEditableCell);
        myDataTableEstimacions.subscribe("cellMouseoutEvent", myDataTableEstimacions.onEventUnhighlightCell);
        myDataTableEstimacions.subscribe("cellClickEvent", myDataTableEstimacions.onEventShowCellEditor);

        myDataTableEstimacions.subscribe('cellClickEvent',function(oArgs) {
            var target = oArgs.target;
            var column = myDataTableEstimacions.getColumn(target);
            if (column.key == 'esborrar') {
                if (confirm('Segur?')) {
                    myDataTableEstimacions.deleteRow(target);
                }
            } else {
                myDataTableEstimacions.onEventShowCellEditor(oArgs);
            }
        });

        var onButtonAfegirClick = function onButtonClick(p_oEvent) {
            var posicio = myDataTableEstimacions.getRecordSet().getLength();
            myDataTableEstimacions.addRow( {id:"-1", especie:"",recobriment:"",afectacio:"",arbresafectats:"",ordre:posicio+1} , posicio);
        };

        var afegirButton = new YAHOO.widget.Button("afegirestimacio", {
            onclick: {
                fn: onButtonAfegirClick
            }
        });

        return {
            oDS: myDataSource,
            oDT: myDataTableEstimacions
        };
    }();
});

function getDadesEstimacions(){
    var set = myDataTableEstimacions.getRecordSet();
    var jsonStr = YAHOO.lang.JSON.stringify(set);
    document.dades2.elements['idsDadesEstimacions'].value = jsonStr;
}

function comprovarDadesEstimacionsTipusAfectacio(){
    var correcte = true;
    var rs = myDataTableEstimacions.getRecordSet();
    if(rs.getLength()==0){
        return false;
    }
    var record;
    for(var i=0;i<rs.getLength();i++){
        record = rs.getRecord(i);
        if(!comprovarFilaTaulaEstimacionsTipusAfectacio(record))
            correcte = false;
    }
    return correcte;
}

function comprovarDadesEstimacionsSumaTipusAfectacions(){
    var correcte = true;
    var rs = myDataTableEstimacions.getRecordSet();
    if(rs.getLength()==0){
        return false;
    }
    var record;
    for(var i=0;i<rs.getLength();i++){
        record = rs.getRecord(i);
        if(!comprovarFilaTaulaEstimacionsSumaTipusAfectacions(record))
            correcte = false;
    }
    return correcte;
}

function comprovarDadesEstimacionsSansAfectats(){
    var correcte = true;
    var rs = myDataTableEstimacions.getRecordSet();
    if(rs.getLength()==0){
        return false;
    }
    var record;
    for(var i=0;i<rs.getLength();i++){
        record = rs.getRecord(i);
        if(!comprovarFilaTaulaEstimacionsSansAfectats(record))
            correcte = false;
    }
    return correcte;
}

function comprovarDadesEstimacions(){
    var correcte = true;
    var rs = myDataTableEstimacions.getRecordSet();
    if(rs.getLength()==0){
        return false;
    }
    var record;
    for(var i=0;i<rs.getLength();i++){
        record = rs.getRecord(i);
        if(!comprovarFilaTaulaEstimacions(record))
            correcte = false;
    }
    return correcte;
}

function sumaArray(valors){
    var acumulat = 0;
    for(var i = 0; i < valors.length; i++){
        acumulat = acumulat + parseInt(valors[i]);
    }
    return acumulat;
}

function checkSumaEnters(valors,esperat){
    var acumulat = sumaArray(valors);
    return (acumulat==esperat);
}

function condicioAMesGranOIgualQueB(a,b){
    return (a>=b);
}

function checkSumaMesGranIgual50(valors){
    var acumulat = sumaArray(valors);
    return condicioAMesGranOIgualQueB(acumulat,50);
}

// El % d'arbres afectats ha de tenir un valor enter entre 0 i 100. Els valors M,
// DF i DC són enters entre 0 i 100, i la suma de M, DF i DC ha de ser igual al %
// d'arbres afectats
function comprovarFilaTaulaEstimacionsSumaTipusAfectacions(record){
    var dada = record.getData('arbresafectats');
    if(dada!=null){
        dada = dada.replace(",",".");
        record.setData('arbresafectats',dada);
        if(!((isInteger(dada) || isDouble(dada)) && dada>=0 && dada<=100)){
            return false;
        }
    }else{
        return false;
    }
    dada = record.getData('percdefoliacio');
    if(dada!=null){
        dada = dada.replace(",",".");
        record.setData('percdefoliacio',dada);        
    }else{
        return false;
    }
    dada = record.getData('percdecoloracio');
    if(dada!=null){
        dada = dada.replace(",",".");
        record.setData('percdecoloracio',dada);        
    }else{
        return false;
    }
    dada = record.getData('percmortalitat');
    if(dada!=null){
        dada = dada.replace(",",".");
        record.setData('percmortalitat',dada);        
    }else{
        return false;
    }
    var valorsTipusAfectacio = [record.getData('percdefoliacio'),record.getData('percdecoloracio'),
    record.getData('percmortalitat')];
    var sumaValorsTipusAfectacioOk = checkSumaEnters(valorsTipusAfectacio, record.getData('arbresafectats'));
    if(!sumaValorsTipusAfectacioOk){
        return false;
    }
    return true;
}

// La casella de % d'arbres afectats no pot estar en blanc i ha de contenir un valor 
// entre 0 i 100. 
// Les caselles de DF i DC no poden estar en blanc i han de contenir valors
// entre 0 i 100. La suma de DF i DC han de ser igual i superior a 50.
// La casella M no pot estar en blanc i ha de contenir un valor entre 5 i 100. 
function comprovarFilaTaulaEstimacionsTipusAfectacio(record){
    var dada = record.getData('arbresafectats');
    if(dada!=null){
        dada = dada.replace(",",".");
        record.setData('arbresafectats',dada);
        if(!((isInteger(dada) || isDouble(dada)) && dada>=0 && dada<=100)){
            return false;
        }
    }else{
        return false;
    }
    dada = record.getData('percdefoliacio');
    if(dada!=null){
        dada = dada.replace(",",".");
        record.setData('percdefoliacio',dada);
        if(!((isInteger(dada) || isDouble(dada)))){
            return false;
        }
    }else{
        return false;
    }
    dada = record.getData('percdecoloracio');
    if(dada!=null){
        dada = dada.replace(",",".");
        record.setData('percdecoloracio',dada);
        if(!((isInteger(dada) || isDouble(dada)))){
            return false;
        }
    }else{
        return false;
    }
    if(record.getData('percdecoloracio')!=null && record.getData('percdefoliacio') !=null){
        var valorsDFDC = [record.getData('percdefoliacio'),record.getData('percdecoloracio')];
        var dfdcOk = checkSumaMesGranIgual50(valorsDFDC);
        if(!dfdcOk){
            return false;
        }
    }
    dada = record.getData('percmortalitat');
    if(dada!=null){
        dada = dada.replace(",",".");
        record.setData('percmortalitat',dada);
        if(!((isInteger(dada) || isDouble(dada)) && dada>=5 )){
            return false;
        }
    }else{
        return false;
    }
    return true;
}

// Les caselles de %arbres sans i %arbres afectats no poden estar en blanc, i han de
// contenir un nombre enter entre 0 i 100. La suma de les dues caselles ha de ser del 100%
function comprovarFilaTaulaEstimacionsSansAfectats(record){
    var dada = record.getData('arbresafectats');
    if(dada!=null){
        dada = dada.replace(",",".");
        record.setData('arbresafectats',dada);
        if(!((isInteger(dada) || isDouble(dada)) && dada>=0 && dada<=100)){
            return false;
        }
    }else{
        return false;
    }    
    dada = record.getData('arbre');
    if(dada!=null){
        dada = dada.replace(",",".");
        record.setData('arbre',dada);
        if(!((isInteger(dada) || isDouble(dada)) && dada>=0 && dada<=100)){
            return false;
        }
    }else{
        return false;
    }
    if(record.getData('arbre')!=null && record.getData('arbresafectats')!=null){
        var valorsAfectacio = [record.getData('arbre'),record.getData('arbresafectats')];
        var afectacioOk = checkSumaEnters(valorsAfectacio, 100);
        if(!afectacioOk){
            return false;
        }
    }
    return true;
}

function comprovarFilaTaulaEstimacions(record){
    var dada = record.getData('recobriment');
    if(dada!=null){
        dada = dada.replace(",",".");
        record.setData('recobriment',dada);
        if(!((isInteger(dada) || isDouble(dada)) && dada>=0 && dada<=100)){
            return false;
        }
    }else{
        return false;
    }        
    dada = record.getData('afectacio');
    if(dada!=null){
        dada = dada.replace(",",".");
        record.setData('afectacio',dada);
        if(!((isInteger(dada) || isDouble(dada)) && dada>=0 && dada<=100)){
            return false;
        }
    }else{
        return false;
    }            
    return true;
}

var myDataTableTransecte;

YAHOO.util.Event.onContentReady("dadestransecte",function() {
    var especiesFormatter = function(el, oRecord, oColumn, oData) {
                    var combo = especiesAOferir;
                    for (var i = 0;i<combo.length;i++) {
                       if (oData == combo[i].especie) {
                          oRecord.setData('idespecie',combo[i].id);
                          el.innerHTML = combo[i].especie;
                          return;
                       }
                    }
                }



    YAHOO.example.InlineCellEditing = function() {
        var formatAddress = function(elCell, oRecord, oColumn, oData) {
            elCell.innerHTML = "<pre class=\"address\">" + oData + "</pre>";
        };

        var myColumnDefs = [
            {key:"ordre",label: ""},
            {key:"especie",label: "*&nbsp;"+txtEspecie,formatter:especiesFormatter,editor: new YAHOO.widget.DropdownCellEditor({dropdownOptions:especiesAOferir,disableBtns:true})},
            {key:"estrat", label:"*&nbsp;"+txtEstrat, editor: new YAHOO.widget.RadioCellEditor({radioOptions:["","Vol","Subvol"],disableBtns:true})},
            {key:"classeDiametrica", label:"*&nbsp;"+txtClasseDiametrica, editor: new YAHOO.widget.DropdownCellEditor({dropdownOptions:["","10-20","20-30","30-40","40-50","50-60","60-70","70-80","80-90","90-100"],disableBtns:true})},
            {key:"estat", label:txtEstatArbres, editor: new YAHOO.widget.DropdownCellEditor({dropdownOptions:["","V","MC","MP","MF"],disableBtns:true})},
            {key:"afectacio", label:txtAfectacioCapcada, editor: new YAHOO.widget.RadioCellEditor({radioOptions:["","DF","DC"],disableBtns:true})},
            {key:"fullaVerda", label:txtFullaVerda, editor: new YAHOO.widget.DropdownCellEditor({dropdownOptions:["","0-10","11-25","26-60",">60","100"],disableBtns:true})},
            {key:"observacions",label:txtObservacions, editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true})}
        ];

        myDataSource = new YAHOO.util.DataSource(dadesTransecte.arbres);
        myDataSource.responseType = YAHOO.util.DataSource.TYPE_JSARRAY;
        myDataSource.responseSchema = {
            fields: ["id","ordre","idespecie","especie","estrat","classeDiametrica","estat","afectacio","fullaVerda","observacions",{key:"id"}]
        };

        var myConfigs = {
            MSG_EMPTY:txtTaula.MSG_EMPTY,
            MSG_ERROR:txtTaula.MSG_ERROR,
            MSG_LOADING:txtTaula.MSG_LOADING,
            MSG_SORTASC:txtTaula.MSG_SORTASC,
            MSG_SORTDESC:txtTaula.MSG_SORTDESC}
        myDataTableTransecte = new YAHOO.widget.DataTable("taulatransecte", myColumnDefs, myDataSource, myConfigs);

        // Set up editing flow
        var highlightEditableCell = function(oArgs) {
            var elCell = oArgs.target;
            if(YAHOO.util.Dom.hasClass(elCell, "yui-dt-editable")) {
                this.highlightCell(elCell);
            }
        };
        myDataTableTransecte.subscribe("cellMouseoverEvent", highlightEditableCell);
        myDataTableTransecte.subscribe("cellMouseoutEvent", myDataTableTransecte.onEventUnhighlightCell);
        myDataTableTransecte.subscribe("cellClickEvent", myDataTableTransecte.onEventShowCellEditor);

        myDataTableTransecte.subscribe('cellClickEvent',function(oArgs) {
            var target = oArgs.target;
            var column = myDataTableTransecte.getColumn(target);
            if (column.key == 'esborrar') {
                if (confirm('Segur?')) {
                    myDataTableTransecte.deleteRow(target);
                }
            } else {
                myDataTableTransecte.onEventShowCellEditor(oArgs);
            }
        });

        var onButtonAfegirClick = function onButtonClick(p_oEvent) {
            var posicio = myDataTableTransecte.getRecordSet().getLength();
            myDataTableTransecte.addRow( {id:"-1", ordre:posicio+1, especie:"",
                estrat:"",classeDiametrica:"",estat:"",afectacio:"",fullaVerda:"",
                observacions:""} , posicio);
        };

        var afegirButton = new YAHOO.widget.Button("afegirarbre", {
            onclick: {
                fn: onButtonAfegirClick
            }
        });

        return {
            oDS: myDataSource,
            oDT: myDataTableTransecte
        };
    }();
});

function getDadesTransecte(){
    var set = myDataTableTransecte.getRecordSet();
    var jsonStr = YAHOO.lang.JSON.stringify(set);
    document.dades2.elements['idsDadesTransecte'].value = jsonStr;
}

function comprovarDadesTransecte(){
    var correcte = true;
    var rs = myDataTableTransecte.getRecordSet();
    var record;
    for(var i=0;i<rs.getLength();i++){
        record = rs.getRecord(i);
        if(!comprovarFilaTaulaTransecte(record))
            correcte = false;
    }
    return correcte;
}

function comprovarFilaTaulaTransecte(record){
    if((record.getData('especie')=='' ||
        record.getData('estrat')=='' ||
        record.getData('classeDiametrica')=='') &&
        (record.getData('estat')!='' ||
        record.getData('afectacio')!='' ||
        record.getData('fullaVerda')!='' ||
        record.getData('observacions')!=''))
        return false;
    return true;
}

function omplirTaulaTransectePerDefecte(){
    var rs = myDataTableTransecte.getRecordSet();
    var record;
    for(var i=0;i<rs.getLength();i++){
        record = rs.getRecord(i);
        omplirFilaTaulaTransectePerDefecte(record);
    }
}

function omplirFilaTaulaTransectePerDefecte(record){
    if(record.getData('especie')!='' ||
        record.getData('estrat')!='' ||
        record.getData('classeDiametrica')!='' ||
        record.getData('estat')!='' ||
        record.getData('afectacio')!='' ||
        record.getData('fullaVerda')!='' ||
        record.getData('observacions')!=''){
        if(record.getData('estat')==''){
            record.setData('estat','V');
        }
        if(record.getData('fullaVerda')==''){
            record.setData('fullaVerda','100');
        }
     }
}

function comprovarDades100Transecte(){
    var correcte = true;
    if(myDataTableTransecte.getRecordSet().getLength()<100){
        correcte = false;
    }
    return correcte;
}

