/**
 * Cal tenir l'input i el contenidor on apareixeran les dades dintre d'un contenidor
 * anomenat bd que és el que s'esperarà a estar finalitzat per executar les accions.
 * Es necessari tenir les variables definides:
 * urlElementsABuscar:  Url on es consulta el que es voldrà mostrar. El retorn és en
 *                      en format JSON. La consulta es fa amb l'atribut query ple
 *                      amb el que s'ha entrat al requadre de text. Cal que el JSON
 *                      es construeixi amb una llista de resultat anomenada 'records' i
 *                      on cada resultat tingui 'id' i 'nom'
 * idInputText: id de l'element html que s'utilitza de requadre de text d'entrada
 *              de la cerca
 * idContenidorResultatsCerca:  id de l'element html que s'utilitza com a contenidor
 *                              del resultat de la cerca
 * idContenidorSeleccionat: id de l'element html on es posarà la id de l'element seleccionat
 */
YAHOO.util.Event.onContentReady("bd", function () {
    var myResponseSchema = {
        resultsList: "records",
        fields: ["id","nom"],
        metaFields: {
            totalRecords: "totalRecords",
            sort: "sort",
            dir: "dir"
        }
    };
    oDS = new YAHOO.util.XHRDataSource(urlElementsABuscar);
    oDS.responseType = YAHOO.util.XHRDataSource.TYPE_JSON;
    oDS.responseSchema = myResponseSchema;

    var oAC = new YAHOO.widget.AutoComplete(idInputText,idContenidorResultatsCerca, oDS);
    oAC.suppressInputUpdate = true;
    oAC.queryDelay = .5;
    oAC.minQueryLength = 3;
    oAC.maxResultsDisplayed = 2000;
    oAC.animHoriz = true;
    oAC.generateRequest = function(sQuery) {
        return "?output=json&results=100&query=" + sQuery ;
    };
    oAC.resultTypeList = false;
    oAC.formatResult = function(oResultData, sQuery, sResultMatch) {
        return  oResultData.nom;
    };
    oAC.itemSelectEvent.subscribe(function(sType, aArgs) {
        var oData = aArgs[2];
        document.getElementById(idContenidorSeleccionat).value = oData.id;
        document.getElementById(idInputText).value = oData.nom;
    });
    return {
        oDS: oDS,
        oAC: oAC
    };
});