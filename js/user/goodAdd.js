/**
 * 
 */
/*
window.onload=function()
{
alert("不能为空");
}

*/

//alert("hell");
//console.log('lll');
window.onload=function()
{

function $(id){
	
	var element = document.getElementById(id);
	
	return element;
}
//提交检验空值。
$('form1').onsubmit=function  ()
{
	//alert("the name: "+$('name').value);
	alert("name:"+$("name").value+" "+"number: "+$('number').value+" weight: "+$('weight').value
			+" price: "+$('price').value+" discount_price: "+$('discount_price').value
			+" desc: "+$('desc').value+" file: "+$("file").value);
	if($('name').value==""  || $('number').value==""  || $('weight').value==""  || $('price').value==""
    || $('discount_price').value==""  || $('desc').value=="" ||$("file").value==""
    	|| $('des_keywords').value=="")
		{
		alert("有未填项");
		return false;
		}
	return true;
}

}

