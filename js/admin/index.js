/**
 * 1
 * 2.
 */
//
/*
 var number=2;

     function LMYC() {
	var lbmc;
	//var treePic;
	for (i = 1; i <= number; i++) {
		lbmc = eval('LM' + i);
		//treePic = eval('treePic'+i);
		//treePic.src = 'pic/file.gif';
		lbmc.style.display = 'none';
	}
}
*/
function ShowFLT(i) {
	lbmc = eval('LM' + i);
	//treePic = eval('treePic' + i)
	if (lbmc.style.display == 'none') {
		//LMYC();
		//treePic.src = 'pic/nofile.gif';
		lbmc.style.display = '';
	} else {
		//treePic.src = 'pic/file.gif';
		lbmc.style.display = 'none';
	}
}