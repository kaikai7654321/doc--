/**
 * 1.ndex.jsp
 */


window.onload = function()
{
	var form1 = f("form1");
	//alert("index.js:看看是不是乱码");
	f('submit').onclick = function()
	{
		alert('用户登录');
		
	}
	f('submit2').onclick = function()
	{
		alert('管理员登录');
		form1.action="IndexControl?admin=admin";
	}
	 form1.onsubmit = function ()
	{
		 
		//alert("提交了");
		if(f("username").value==""||f("password").value == "")
			{
			alert("不能为空");
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