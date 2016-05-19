/**
 * 1.Doc.js
 */

window.onload=function()
{
//alert("addDoc.js:≤‚ ‘");
function f(id){
	
	var element = document.getElementById(id);
	
	return element;
}

{
	//alert("the name: "+f('name').value);
	alert("name:"+f("name").value+" "+"author: "+f('author').value+(" attachedFile: "+f('attachedFile'))
			+" uploader: "+f('uploader').value+" file: "+f("file").value);
	if(f('name').value==""  || f('author').value==""  || f('attachedFile').value==""  || 
			f('uploader').value==""  ||f("file").value=="")
		{
		alert("”–Œ¥ÃÓœÓ");
		return false;
		}
	return true;
}
f("return").onclick = function()
{
window.location = window.history.go(-1);	
}
}
