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
            <h2>FORMA DE VALORAR EL GRAU D'ATAC DE PROCESSION�RIA DEL PI EN LES DIFERENTS COMARQUES</h2>
            <p>Amb la finalitat de con�ixer la distribuci� de la procession�ria del pi i la seva intensitat 
                a les diferents comarques catalanes, ser� necessari realitzar el seg�ent treball:</p>
            <ul>
                <li>Es marcaran i numeraran en els pl�nols d'escala 1:50.000, les zones amb un major
                    grau d'atac de processin�ria existents a la comarca.</li>
                <li>Per a cada una d'aquestes zones, es realitzaran unes valoracions d'acord amb els
                    seg�ents par�metres:
                </li>
            </ul>
            <p>Tipus de bosc:</p>
            <ul>
                <li>REP - Repoblaci� (indicant l'al�ada aproximada dels arbres).</li>
                <li>B.N. - Bosc natural.</li>
                <li>ESP�CIE - Ps: &#09;Pi rojalet (P.sylvestris)
                    &#09;&#09;Pn: Pinassa (P.nigra)
                    &#09;&#09;Ppr: Pinastre (P.pinaster)
                    &#09;&#09;Ppa: Pi pinyer (P. pinae)
                    &#09;&#09;Ph: Pi blanc (P.halepensis)
                </li>
            </ul>
            <p>Grau d'infestaci�:</p>
            <ol>
                <li>Quan s'aprecien v�ries bosses als marges de bosc i algunes al centre de la massa boscosa.</li>
                <li>Defoliacions parcials als marges sobre alguns arbres i v�ries bosses en el centre de la massa.</li>
                <li>Defoliacions intenses als marges i parcials en el centre de la massa.</li>
                <li>Defoliacions molt fortes tant als marges com en el centre de la massa.</li>
            </ol>
            <p>Les dades de cada zona, atenent a aquests par�metres, s'han d'indicar en la taula que
                figura a continuaci�. Amb les dades cumplimentades i les fotoc�pies dels pl�nols,
                es retornar� la inforamci� als respectius sots-inspectors.</p>
            <a href="<c:url value='/processionaria/ajuda.htm'/>?contingut=ajuda">Tornar a l'ajuda</a>
            </div>
                </div>
            <div id="ft">
                <%@ include file="/WEB-INF/jsp/Estructura/footer.jsp" %>
            </div>
        </div>
    </body>
</html>