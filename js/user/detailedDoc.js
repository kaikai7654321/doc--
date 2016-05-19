/**
 * 
 */

window.onload = function()
{
	//alert("detailedDoc:关于乱码");
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
        xmlhttp.open("get","detailedDoc?name=comment&id="+m('id').value,true);

        xmlhttp.send(null);

    }
	function m(id){
		
		var element = document.getElementById(id);
		
		return element;
	}
	
	m('return').onclick = function()
	{
		//返回上一页并刷新
		window.location.href=document.referrer;
		
		
	}
	m('send').onclick = function()
	{
		//alert("关于乱码");
		var score = m('score').value;
		var message = m('message').value;
		
		if(!(score=="0"&&message==""))
			{
		xmlhttp.onreadystatechange=function(){
            if(xmlhttp.readyState==4&&xmlhttp.status==200){
                //m('webpage').innerHTML=xmlhttp.responseText;
            	showall();
            	 m('message').value="";
            	//alert("发表成功");
            }
        }
		//alert("message:"+message);
		//String message1 = new String((message.getBytes("utf-8")),"GBK");
		//message = encodeURI(encodeURI(message));
		message = (encodeURI(message));
		var url = "detailedDoc?name=addComment&id="+m('id').value+"&score="+score+"&message="+message;
        //alert("url: "+url);
		xmlhttp.open("get",url,true);

        xmlhttp.send(null);
       
		
			}
	}

}