// JavaScript Document
function m(id){
	return document.getElementById(id);
}
window.onload = function(){
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
    chkreg();
	m('name').focus();
	var cname1='';
    var cname2='';
    var cpwd1 = '';
    var cpwd2 = '';
   
	//
	function chkreg(){
       // alert(cname1);
		if((cname1 == 'yes') &&(cname2=='yes') && (cpwd1 == 'yes') && (cpwd2 == 'yes') ){
			m('register').disabled = false;
           // alert("");
		}else{

			m('register').disabled = true;
           
		}
	}
	//ÿһ�μ��̰��£�����ÿ������һ����ĸ
	m('name').onkeyup = function (){
		name = m('name').value;
		cname2 = '';
		if(name.match(/^[a-zA-Z_]*/) == ''){
			m('namediv').innerHTML = '<font color=red>��������ĸ�»��߿�ͷ</font>';
			cname1 = '';
		}else if(name.length < 2){
			m('namediv').innerHTML = '<font color=red>���������λ</font>';
			cname1 = '';
		}else{
			m('namediv').innerHTML = '<font color=green>ע�����Ʒ��ϱ�׼</font>';
			cname1 = 'yes';
		}
		chkreg();
	}
	//�鿴�Ƿ������Ѿ���ռ����
	m('name').onblur = function(){
        //alert(cname1);
		name = m('name').value;
		if(cname1 == 'yes'){
            // xmlhttp = new XMLHttpRequest();
			xmlhttp.open('get','Register?option=adminname&name='+name,true);
			xmlhttp.onreadystatechange = function(){
				if(xmlhttp.readyState == 4){
					if(xmlhttp.status == 200){
						var msg = xmlhttp.responseText;
						if(msg=="1"){
							//alert("the msg: "+msg);
							m('namediv').innerHTML="<font color=green>��ϲ���û�������ʹ��</font>";
							cname2 = 'yes';
						}else if(msg == '2'){
							//alert("the msg: "+msg);
							m('namediv').innerHTML="<font color=red>�û�����ռ�ã�</font>";
							cname2 = '';
						}else{
							alert("the msg: "+msg);
							m('namediv').innerHTML="<font color=red>"+msg+"</font>";
							cname2 = '';
						}
					}
				}
				chkreg();
			}
			xmlhttp.send(null);
		}
	}
	//��һ����������
	m('password1').onkeyup = function(){
		pwd = m('password1').value;
		pwd2 = m('password2').value;
		
		if(pwd.length < 6){
			m('pwddiv1').innerHTML = '<font color=red>���볤��������λ</font>';
			cpwd1 = '';
		}else if(pwd.length >= 6 && pwd.length < 12){
			m('pwddiv1').innerHTML = '<font color=green>�������Ҫ������ǿ�ȣ���</font>';
			cpwd1 = 'yes';
		}else if((pwd.match(/^[0-9]*m/)!=null) || (pwd.match(/^[a-zA-Z]*m/) != null )){
			m('pwddiv1').innerHTML = '<font color=green>�������Ҫ������ǿ�ȣ���</font>';
			cpwd1 = 'yes';
		}else{
			m('pwddiv1').innerHTML = '<font color=green>�������Ҫ������ǿ�ȣ�ǿ</font>';
			cpwd1 = 'yes';
		}

		chkreg();
	}
	//�ڶ�������
	m('password2').onkeyup = function(){
		pwd1 = m('password1').value;
		pwd2 = m('password2').value;
		if(pwd1 != pwd2){
			m('pwddiv2').innerHTML = '<font color=red>�������벻һ��</font>';
			cpwd2 = '';
		}else{
			m('pwddiv2').innerHTML = '<font color=green>������ȷ</font>';
			cpwd2 = 'yes';
			chkreg();
		}
	}
	
	m('return').onclick = function(){
		
        window.open('index.jsp',"_self");
	}


    m('register').onclick = function(){

            url = 'Register?option=adminRegister&name=' + m('name').value + '&password=' + m('password1').value;
            
            //alert("register.js: url:"+url);
            xmlhttp.open('get', url, true);
            
            xmlhttp.onreadystatechange = function () {
                //window.open('login.php', '_blank', '', false);
                if (xmlhttp.readyState == 4) {
                    if (xmlhttp.status == 200) {

                        msg = xmlhttp.responseText;
                        //alert(mag);
                        if (msg == '1') {
                            alert('ע��ɹ�');
                            window.open('Register?option=showAdmin', '_self', '', false);
                            
                            //location='../index1.php';
                        }  else {
                            alert("ע��ʧ�ܣ�������ע��: "+msg);
                        }
                        m('imgdiv').style.visibility = 'hidden';
                    }
                }
            

            
            //window.open('login.php','_parent','',false);
        }
            xmlhttp.send(null);
    }


}