var xmlhttp = false;
if (window.XMLHttpRequest) { 									//Mozilla��Safari�������
	xmlhttp = new XMLHttpRequest();
} 
else if (window.ActiveXObject) { 								//IE�����
	try {
		xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
	} catch (e) {
		try {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	   } catch (e) {}
	}
}
