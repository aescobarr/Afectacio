function trim(cadena){
    return cadena.replace(/^\s+|\s+$/g, '');
}

function submitenter(myfield,e){
    var keycode;
    if (window.event) keycode = window.event.keyCode;
    else if (e) keycode = e.which;
    else return true;
    if (keycode == 13)
    {
        myfield.form.submit();
        return false;
    }
    else
        return true;
}

function isDouble(s,numDecimals){
    var s1,s2,index;
    index = s.indexOf(".");
    if(index<0){
        index = s.indexOf(",");
    }
    if(index<0){
        return false;
    }
    s1 = s.substring(0,index);
    s2 = s.substring(index+1,s.length);
    if(numDecimals!=null){
        if(s2.length>numDecimals)
            return false;
    }
    return isInteger(s1) && isInteger(s2);
}

function isInteger (s) {
    var i;

    if (isEmpty(s))
        if (isInteger.arguments.length == 1) return 0;
        else return (isInteger.arguments[1] == true);

    for (i = 0; i < s.length; i++)
    {
        var c = s.charAt(i);

        if (!isDigit(c)) return false;
    }

    return true;
}

function isEmpty(s) {
    return ((s == null) || (s.length == 0))
}

function isDigit (c){
    return ((c >= "0") && (c <= "9"))
}

function isHora(hora){
    if(hora.length>5 || hora.length<4){
        return false;
    }
    if(hora.length==4){
        hora = '0' + hora;
    }
    if(hora.substring(2,3)!=':'){
        return false;
    }
    if(!isInteger(hora.substring(0,2))){
        return false;
    }
    if(!isInteger(hora.substring(3))){
        return false;
    }
    if(parseInt(hora.substring(0,2))<0 || parseInt(hora.substring(0,2))>23){
        return false;
    }
    if(parseInt(hora.substring(3))<0 || parseInt(hora.substring(3))>59){
        return false;
    }
    return true;
}

function stripCharsInBag(s, bag){
    var i;
    var returnString = "";
    // Search through string's characters one by one.
    // If character is not in bag, append to returnString.
    for (i = 0; i < s.length; i++){
        var c = s.charAt(i);
        if (bag.indexOf(c) == -1) returnString += c;
    }
    return returnString;
}

function daysInFebruary (year){
    // February has 29 days in any year evenly divisible by four,
    // EXCEPT for centurial years which are not also divisible by 400.
    return (((year % 4 == 0) && ( (!(year % 100 == 0)) || (year % 400 == 0))) ? 29 : 28 );
}

function DaysArray(n) {
    for (var i = 1; i <= n; i++) {
        this[i] = 31
        if (i==4 || i==6 || i==9 || i==11) {this[i] = 30}
        if (i==2) {this[i] = 29}
    }
    return this
}

var dtCh= "/";
var minYear=1000;
var maxYear=2900;

function isDate(dtStr){
    //Missatges
    /*    var formatDataHauriaDeSer='La data hauria de ser de la forma (DD/MM/YYYY)';
                    var mesNoValid='El mes no és vàlid, ha de ser un nombre entre 1 i 12';
                    var diaNoValid='El dia no és vàlid, ha de ser un nombre entre 1 i 31';
                    var anyNoValid='L\'any hauria de ser un nombre enter entre 1000 i 2900';*/
    //No és obligatori
    if(dtStr.length == 0)
        return true;
    var daysInMonth = DaysArray(12)
    var pos1=dtStr.indexOf(dtCh)
    var pos2=dtStr.indexOf(dtCh,pos1+1)
    var strMonth=dtStr.substring(pos1+1,pos2)
    var strDay=dtStr.substring(0,pos1)
    var strYear=dtStr.substring(pos2+1)
    strYr=strYear
    if (strDay.charAt(0)=="0" && strDay.length>1) strDay=strDay.substring(1)
    if (strMonth.charAt(0)=="0" && strMonth.length>1) strMonth=strMonth.substring(1)
    for (var i = 1; i <= 3; i++) {
        if (strYr.charAt(0)=="0" && strYr.length>1) strYr=strYr.substring(1)
    }
    month=parseInt(strMonth)
    day=parseInt(strDay)
    year=parseInt(strYr)
    if (pos1==-1 || pos2==-1){
        //alert(formatDataHauriaDeSer)
        return false
    }
    if (strMonth.length<1 || month<1 || month>12){
        // alert(mesNoValid)
        return false
    }
    if (strDay.length<1 || day<1 || day>31 || (month==2 && day>daysInFebruary(year)) || day > daysInMonth[month]){
        // alert(diaNoValid)
        return false
    }
    if (strYear.length != 4 || year==0 || year<minYear || year>maxYear){
        //alert(anyNoValid)
        return false
    }
    return true
}

function obrirpopup(url,width,height){
    if(width==null){
        width = 640;
    }
    if(height==null){
        height = 480;
    }
    var newwindow=window.open(url,'name','height='+height+',width='+width+',left=150,top=100,resizable=yes,scrollbars=yes,toolbar=no,status=no,location=no');
    if (window.focus) {newwindow.focus()}
}
