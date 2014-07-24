var txtTaula = {MSG_EMPTY:"",MSG_ERROR:"",MSG_LOADING:"",MSG_SORTASC:"",MSG_SORTDESC:""};


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


var onButtonFiltreClick = function onButtonClick(p_oEvent) {
    var idfigura = document.dades.idfigura.value;
    eliminarCapa(tiled);
    tiled = crearCapaUsuari(idfigura);
    afegirCapa(tiled);

    var startIndex = "0";

    var oState = myDataTable.getState();

    var oCallback = {
        success : myDataTable.onDataReturnSetRows,
        failure : myDataTable.onDataReturnSetRows,
        argument : oState,
        scope : myDataTable
    };

    var request = "sort=data&dir=asc&startIndex="+startIndex+"&results=30";//&idfigura="+idfigura;
    myDataSource.sendRequest(request,oCallback);

};

Event.onDOMReady(function() {

    var formatUrl = function(elCell, oRecord, oColumn, sData) {
        elCell.innerHTML = sData;
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
        key:"comarca",
        label:txtComarca,
        sortable:true,
        resizeable:true,
        formatter:formatUrl
    }
    ,
    {
        key:"tipusBosc",
        label:txtTipusBosc,
        sortable:true,
        resizeable:true,
        formatter:formatUrl
    }
    ,
    {
        key:"orientacio",
        label:txtOrientacio,
        sortable:true,
        resizeable:true,
        formatter:formatUrl
    }
    ,
    {
        key:"alcada",
        label:txtAlcada,
        sortable:true,
        resizeable:true,
        formatter:formatUrl
    }
    ,
    {
        key:"especie",
        label:txtEspecie,
        sortable:true,
        resizeable:true,
        formatter:formatUrl
    }
    ,
    {
        key:"grauInfestacio",
        label:txtGrauInfestacio,
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
        key:"data",
        label:txtData,
        sortable:true,
        resizeable:true,
        formatter:formatUrl
    },
    {
        key:"area",
        label:txtArea,
        sortable:false,
        resizeable:true,
        formatter:formatUrl
    },
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
        fields: ["id","codi","comarca","tipusBosc","orientacio","alcada","especie","grauInfestacio","data","codiAgent1","codiAgent2","area"],
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
        initialRequest: "sort=data&dir=asc&startIndex=0&results=25" +
    "&random=" + Math.random(),
        dynamicData: true,
        sortedBy : {
            key:"data",
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


