/**
 * 
 */
function togglecon1()
{
	var frmcate = document.frmcate;
	frmcate.method = "post";
	frmcate.action = "/gangmin/lecture/lowprice.do";
	frmcate.submit();
	
}