var onPestanyaClick = function onButtonClick(p_oEvent) {alert(document.tipusaplicacio.tipus.value);
    document.tipusapliacio.action = document.tipusaplicacio.tipus.value;
    document.tipusaplicacio.submit();
};
var tabView = new YAHOO.widget.TabView('pestanyer');
tabView.addListener('activeIndexChange', onPestanyaClick);