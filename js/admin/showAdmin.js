/**
 * 
 */

window.onload = function() {
	//alert("showDoc.js: ");
		
		function m(id){
			
			var element = document.getElementById(id);
			
			return element;
		}
		

		   m('tiao').onclick = function gotoPage() {
			var pageTo = m('tiaozhuan');
			if(pageTo==null || ""==pageTo)
				{
				alert("Ìø×ªµ½Ò³Ãæ£º"+pageTo.value);
				}
			else {
				
				window.alert('pagenow: ' + pageTo.value);
				window.open('Register?option=showAdmin&pageNow=' + pageTo.value, '_self');
			}
			
		}
		     	
}
