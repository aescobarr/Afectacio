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
        sortable:false,
        resizeable:true,
        formatter:formatUrl
    };
     myColumnDefs[2] = {
        key:"grauAfectacio",
        label:txtGrauAfectacio,
        sortable:false,
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
        label:txtDataEpisodi,
        sortable:true,
        resizeable:true,
        formatter:formatUrl
    };
     myColumnDefs[5] = {
        key:"enginyer1",
        label:txtEnginyer1,
        sortable:true,
        resizeable:true,
        formatter:formatUrl
    };
     myColumnDefs[6] = {
        key:"enginyer2",
        label:txtEnginyer2,
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
        fields: ["id","codi","especie1","grauAfectacio","areaAfectada","data","enginyer1","enginyer2"],
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
            {key:"afectacio", label:txtAfectacio, editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true})},
            {key:"alcada", label:txtAlcadaArbres, editor: new YAHOO.widget.DropdownCellEditor({dropdownOptions:["Tots","Vol","Subvol"],disableBtns:true})},
            {key:"esborrar", label:"", className:'linkEsborrar'}
        ];

        myDataSource = new YAHOO.util.DataSource(dadesEstimacions.estimacions);
        myDataSource.responseType = YAHOO.util.DataSource.TYPE_JSARRAY;
        myDataSource.responseSchema = {
            fields: ["id","ordre","idespecie","especie","recobriment","afectacio","alcada",{key:"id"}]
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
            myDataTableEstimacions.addRow( {id:"-1", especie:"",recobriment:"",afectacio:"",ordre:posicio+1} , posicio);
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

function comprovarFilaTaulaEstimacions(record){
    var dada = record.getData('recobriment');
    dada = dada.replace(",",".");
    record.setData('recobriment',dada);
    if(!((isInteger(dada) || isDouble(dada)) && dada>=0 && dada<=100)){
        return false;
    }
    dada = record.getData('afectacio');
    dada = dada.replace(",",".");
    record.setData('afectacio',dada);
    if(!((isInteger(dada) || isDouble(dada)) && dada>=0 && dada<=100)){
        return false;
    }
    return true;
}