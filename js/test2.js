/**
 * 
 */

window.onload = function()
{
	//alert("detailedDoc:πÿ”⁄¬“¬Î");
	if (window.XMLHttpRequest) { 
		xmlhttp = new XMLHttpRequest();
	} 
	else if (window.ActiveXObject) { 								
		try {
			xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		   } catch (e) {}
		}
	} 
	showall();
    function showall()
    {
    	
        xmlhttp.onreadystatechange=function(){
            if(xmlhttp.readyState==4&&xmlhttp.status==200){
                m('webpage').innerHTML=xmlhttp.responseText;
            }
        }
        xmlhttp.open("get","DocTest",true);

        xmlhttp.send(null);

    }
	function m(id){
		
		var element = document.getElementById(id);
		
		return element;
	}
	
	

}