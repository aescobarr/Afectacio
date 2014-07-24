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
    "&dir=" + dir +
    "&random=" + Math.random();
};


Event.onDOMReady(function() {

    var formatUrl = function(elCell, oRecord, oColumn, sData) {
        elCell.innerHTML = sData;
    };

    var formatNivellAfectacioUrl = function(elCell, oRecord, oColumn, sData) {
        var dany = txtDanyModerat;
        if(oRecord.getData("nivellAfectacio")==1)
            dany = txtDanyGreu;
        else if(oRecord.getData("nivellAfectacio")==2)
            dany = txtDanyMoltGreu;
        else if(oRecord.getData("nivellAfectacio")==3)
            dany = txtDanyExtrem;

        elCell.innerHTML = dany;
    };

    var formatImprimirUrl = function(elCell, oRecord, oColumn, sData) {
        elCell.innerHTML = "<a class='print' href='#' onclick=\"javascript:visualitzar('"+oRecord.getData("id")+"')\">&nbsp;</a>";
        if(editable){
            elCell.innerHTML += "<a class='botoesborrar' href='#' onclick=\"javascript:esborrar('"+oRecord.getData("id")+"')\">&nbsp;</a>";
        }
    };

    var myColumnDefs = [
    {
        key:"codi",
        label:txtCodi,
        sortable:true,
        resizeable:true,
        formatter:formatUrl
    }
    ,
    {
        key:"nomCami",
        label:txtNomCami,
        sortable:true,
        resizeable:true,
        formatter:formatUrl
    }
    ,
    {
        key:"longitudKm",
        label:txtLongitudKm,
        sortable:true,
        resizeable:true,
        formatter:formatUrl
    }
    ,
    {
        key:"observacions",
        label:txtObservacions,
        sortable:true,
        resizeable:true,
        formatter:formatUrl
    }
    ,
    {
        key:"terme",
        label:txtTerme,
        sortable:true,
        resizeable:true,
        formatter:formatUrl
    }
    ,
    {
        key:"comarca",
        label:txtComarca,
        sortable:true,
        resizeable:true,
        formatter:formatUrl
    }
    ,
    {
        key:"codiAgent1",
        label:txtCodiAgent1,
        sortable:true,
        resizeable:true,
        formatter:formatUrl
    }
    ,
    {
        key:"codiAgent2",
        label:txtCodiAgent2,
        sortable:true,
        resizeable:true,
        formatter:formatUrl
    }
    ,
    {
        key:"peusAfectats",
        label:txtPeusAfectats,
        sortable:false,
        resizeable:true,
        formatter:formatUrl
    }
    ,
    {
        key:"nivellAfectacio",
        label:txtNivellAfectacio,
        sortable:false,
        resizeable:true,
        formatter:formatNivellAfectacioUrl
    }
    ,
    {
        key:"imprimir",
        label:"",
        sortable:false,
        resizeable:false,
        formatter:formatImprimirUrl
    }
     ];
                    
    var myResponseSchema = {
        resultsList: "records",
        fields: ["id","codi","comarca","terme","nomCami","longitudKm","codiAgent1","codiAgent2","observacions","peusAfectats","nivellAfectacio"],
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
        initialRequest: "sort=codi&dir=asc&startIndex=0&results=25" +
    "&random=" + Math.random(),
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

var myDataTableObs;


YAHOO.util.Event.onContentReady("dadesobservacions",function() {
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

         var val = function(e) {
            e = e.replace(",",".");
            if(isInteger(e) && e>=0){
                return e;
            }else if(e!==null && e!==''){
                alert(txtErrorEdicioCelaEnter);
            }
        };

        var editorNum = new YAHOO.widget.TextareaCellEditor({resetInvalidData:false,validator:val,disableBtns:true});



        var myColumnDefs = [
            {key:"especie",label: txtEspecie,formatter:especiesFormatter,editor: new YAHOO.widget.DropdownCellEditor({dropdownOptions:especiesAOferir,disableBtns:true})},
            {key:"pistaParcial", label:txtPistaParcial, editor: editorNum},
            {key:"pistaTotal", label:txtPistaTotal, editor: editorNum},
            {key:"franjaParcial", label:txtFranjaParcial, editor: editorNum},
            {key:"franjaTotal", label:txtFranjaTotal, editor: editorNum},
            {key:"esborrar", label:"", className:'linkEsborrar'}
        ];

        myDataSource = new YAHOO.util.DataSource(dadesObservacions.observacions);
        myDataSource.responseType = YAHOO.util.DataSource.TYPE_JSARRAY;
        myDataSource.responseSchema = {
            fields: ["id","idespecie","especie","pistaParcial","pistaTotal","franjaParcial","franjaTotal",{key:"id"}]
        };

        var myConfigs = {
            MSG_EMPTY:txtTaula.MSG_EMPTY,
            MSG_ERROR:txtTaula.MSG_ERROR,
            MSG_LOADING:txtTaula.MSG_LOADING,
            MSG_SORTASC:txtTaula.MSG_SORTASC,
            MSG_SORTDESC:txtTaula.MSG_SORTDESC}
        myDataTableObs = new YAHOO.widget.DataTable("taulaobservacions", myColumnDefs, myDataSource, myConfigs);

        // Set up editing flow
        var highlightEditableCell = function(oArgs) {
            var elCell = oArgs.target;
            if(YAHOO.util.Dom.hasClass(elCell, "yui-dt-editable")) {
                this.highlightCell(elCell);
            }
        };
        myDataTableObs.subscribe("cellMouseoverEvent", highlightEditableCell);
        myDataTableObs.subscribe("cellMouseoutEvent", myDataTableObs.onEventUnhighlightCell);
        myDataTableObs.subscribe("cellClickEvent", myDataTableObs.onEventShowCellEditor);

        myDataTableObs.subscribe('cellClickEvent',function(oArgs) {
            var target = oArgs.target;
            var column = myDataTableObs.getColumn(target);
            if (column.key == 'esborrar') {
                if (confirm('Segur?')) {
                    myDataTableObs.deleteRow(target);
                }
            } else {
                myDataTableObs.onEventShowCellEditor(oArgs);
            }
        });

        var onButtonAfegirClick = function onButtonClick(p_oEvent) {
            var posicio = myDataTableObs.getRecordSet().getLength();
            myDataTableObs.addRow( {id:"-1", especie:"",pistaParcial:"",pistaTotal:"",franjaParcial:"",franjaTotal:""} , posicio);
        };

        var afegirButton = new YAHOO.widget.Button("afegir", {
            onclick: {
                fn: onButtonAfegirClick
            }
        });

        return {
            oDS: myDataSource,
            oDT: myDataTableObs
        };
    }();
});

function getDadesObservacions(){
    var set = myDataTableObs.getRecordSet();
    var jsonStr = YAHOO.lang.JSON.stringify(set);
    document.dades2.elements['idsDadesObservacions'].value = jsonStr;
}