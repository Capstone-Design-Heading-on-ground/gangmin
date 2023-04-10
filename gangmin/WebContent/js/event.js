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

function togglecon2()
{
	var frmcate = document.frmcate;
	alert(`high price`);
	frmcate.method = "post";
	frmcate.action = "/gangmin/lecture/highprice.do";
	frmcate.submit();
}