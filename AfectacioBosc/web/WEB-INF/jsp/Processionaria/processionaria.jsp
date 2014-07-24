<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<html xml:lang="ca" lang="ca" xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>SISTEMA D'INFORMACI&Oacute; D'AFECTACI&Oacute; DELS BOSCOS DE CATALUNYA</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta http-equiv="Content-Style-Type" content="text/css" />
        <link rel="shortcut icon" href="<c:url value='/grafics/afectacio_ico_nav.ico' />"/>
        <link rel="stylesheet" type="text/css" href="<c:url value='/css/sipan.css' />" />
        <link rel="stylesheet" type="text/css" href="<c:url value='/css/estilAfectacio.css' />" />
        <fmt:setBundle var="bundleAfectacio" basename="cat.creaf.afectaciobosc.literals.AfectacioBosc"/>
        <%@ include file="/WEB-INF/jsp/Estructura/yui-sipan.jsp" %>
    </head>
    <body class="yui-skin-sam">
        <div id="doc" class="yui-d2">
            <div id="hd">
                <div class="header"><img src="<c:url value='/grafics/img_header.png' />" alt="" /></div>
            </div>
            <div id="bd">
                <div class="modul mprocessionaria">
            <h2>Funcionament general de l'aplicaci�</h2>
            <h3>Visualitzaci� de les dades entrades</h3>
            <p>A la part inferior de la p�gina hi ha una taula que permet veure les dades
            de les afectacions ja entrades. A m�s en el mapa de cartografia hi ha els 
            pol�gons entrats en les afectacions que ja hi ha a la base de dades.</p>
            <h3>Inserir una nova afectaci�</h3>
            <p>Els passos per a inserir una nova afectaci� a la base de dades s�n els seg�ents:</p>
            <ol>
                <li>Pr�mer el bot� de 'Nova afectaci�'</li>
                <li>A la part esquerra apareix un formulari d'entrada de dades. Si necessita informaci�
                sobre com entrar la fitxa pot anar a l'apartat de l'ajuda
                <a href="<c:url value='/processionaria/ajuda.htm'/>?contingut=omplirfitxa">Forma de valorar el grau d'atac de procession�ria del pi en les diferents comarques</a>.
                A m�s, tamb� pot digitalitzar l'�rea afectada en el mapa de cartografia. Si el que necessita �s
                informaci� sobre com utilitzar el mapa pot anar a <a href="<c:url value='/processionaria/ajuda.htm'/>?contingut=carto">Com digitalitzar i utilitzar el mapa</a>.</li>
                <li>Finalment pot clicar el bot� 'Desar' per inserir la informaci�
                a la base de dades, o 'Cancel�lar' per descartar la informaci� entrada.</li>
            </ol>
            <a href="<c:url value='/processionaria/ajuda.htm'/>?contingut=ajuda">Tornar a l'ajuda</a>
            </div>
                </div>
            <div id="ft">
                <%@ include file="/WEB-INF/jsp/Estructura/footer.jsp" %>
            </div>
        </div>
    </body>
</html>