/**
 * Created by kai on 2015/11/21.
 */
function $(id){
    return document.getElementById(id);
}

window.onload = function(){


    //showall();
//    function showall(){
//        xmlhttp.onreadystatechange=function(){
//            if(xmlhttp.readyState==4&&xmlhttp.status==200){
//                $('webpage').innerHTML=xmlhttp.responseText;
//                //document.writer("kaka");
//            }
//        }
//        url = 'jsp/admin/goodShow.jsp' ;
//        xmlhttp.open("get",url,true);
//
//        xmlhttp.send(null);
//    }
    $('search').onfocus = function (e) {
        $('search').value="";

    }
    $('showall').onclick=function(e){
        showall();
    }
    $('search1').onclick = function(){
        xmlhttp.onreadystatechange=function(){
            if(xmlhttp.readyState==4&&xmlhttp.status==200){
                $('webpage').innerHTML=xmlhttp.responseText;
            }
        }
        url = 'managerView/TableGoodsSearch.php?name='+$('search').value ;
        xmlhttp.open("get",url,true);

        xmlhttp.send(null);

    }

}