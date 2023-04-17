/**
 * 
 */
function togglecon1(event)
{
		var frmcate = document.frmcate;
		var sort = event.target.value;
		alert(`${sort}`);
		frmcate.method = "get";
		frmcate.action = "/gangmin/lecture/eventprice.do?do_sort="+sort;
		frmcate.submit();

}

function doSearch()
{
	let selectedAcademy = $("#categoryAcademy input[type=radio]:checked").val();
	alert(selectedAcademy);
}