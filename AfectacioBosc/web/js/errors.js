function afegirErrorsJavascript(errors){
    var llistaErrors = document.getElementById('llistaerrorsjavascript');
    removeChildrenFromNode(llistaErrors);
    for(var i=0;i<errors.length;i++){
        var newError = document.createElement('li');
        newError.innerHTML = errors[i];
        llistaErrors.appendChild(newError);
    }
}

function veureErrorsJavascript(esVisible){
    if(esVisible){
        document.getElementById('errorsjavascript').style.display = 'block';
    }else{
        document.getElementById('errorsjavascript').style.display = 'none';
    }
}

function removeChildrenFromNode(node) {
    if(node==undefined || node == null){
        return;
    }
    if(node.hasChildNodes()) {
        while(node.childNodes.length >= 1 ) {
            node.removeChild(node.firstChild);
        }
    }
}

