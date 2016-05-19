/**
 * 
 */

window.onload = function() {
	// alert("showDoc.js: ");
		
		function m(id){
			
			var element = document.getElementById(id);
			
			return element;
		}

		m('search').onfocus = function()
		{
			m('search').value="";
		}
		
		m('searchbt').onclick = function()
		{
			var keyword = m('search').value;
			if(keyword=="关键字")
				{
				keyword="";
				}
			var selection = m('select').value;

			keyword = (encodeURI(keyword));
			selection = (encodeURI(selection));
			var url = "user_index?name=showDoc&pageNow=1&keyword="+keyword+"&type="+selection;
			
			window.open(url, '_self');
		}
		m('tiao').onclick = function gotoPage() {
			var pageTo = m('tiaozhuan');
			if(pageTo==null || ""==pageTo)
				{
				alert("跳转到页面："+pageTo.value);
				}
			else {
				
				window.alert('pagenow: ' + pageTo.value);
				window.open('user_index?name=showDoc&pageNow=' + pageTo.value, '_self');
			}
			
		}
		     	
}
