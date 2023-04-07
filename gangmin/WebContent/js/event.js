/**
 * 
 */
function togglecon1()
{
	var frmcate = document.frmcate;
	alert(`low price`);
	frmcate.method = "post";
	frmcate.action = "/gangmin/lecture/lowprice.do";
	frmcate.submit();
	
}