/**
 * 1.ndex.jsp
 */


window.onload = function()
{
	var form1 = f("form1");
	//alert("index.js:�����ǲ�������");
	f('submit').onclick = function()
	{
		alert('�û���¼');
		
	}
	f('submit2').onclick = function()
	{
		alert('����Ա��¼');
		form1.action="IndexControl?admin=admin";
	}
	 form1.onsubmit = function ()
	{
		 
		//alert("�ύ��");
		if(f("username").value==""||f("password").value == "")
			{
			alert("����Ϊ��");
			return false;
			}
		
		
		return true;
	}
	 f("reset").onclick = function()
		{
			f("username").value = "";
			f("password").value = "";
		}
	 function f(id)
	 {

	 	var temp = document.getElementById(id);
	 	return temp;
	 	
	 }


}