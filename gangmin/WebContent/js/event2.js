/**
 * 
 */
function togglecon1(event)
{
		var frmcate = document.frmcate;
		var sort = event.target.value;
		frmcate.method = "get";
		frmcate.action = "/gangmin/lecture/eventprice.do?do_sort="+sort;
		frmcate.submit();

}

function doSearch2()
{
	var selectedAcademy = new Array();
	var radiovalue1 = $('input[name=rd_line]:checked').val();
	var radiovalue2 = $('input[name=rd_sub1]:checked').val();
	var radiovalue3 = $('input[name=rd_sub2]:checked').val();
	var radiovalue4 = $('input[name=radio_final]:checked').val();
	
	
	let selectedAcademy1 = $('input:checkbox[name=checkList]').each(function (index){
		if($(this).is(":checked")==true){
			//console.log($(this).val());
			selectedAcademy.push($(this).val());
		}
	})
	
	var form = document.createElement("form");
	form.setAttribute("charset","UTF-8");
	form.setAttribute("method","Get");
	form.setAttribute("action","/gangmin/lecture/categorySearch.do");
	
	var hiddenField = document.createElement("input");
	hiddenField.setAttribute("type","hidden");
	hiddenField.setAttribute("name", "selectedAcademy");
	hiddenField.setAttribute("value", selectedAcademy);
	form.appendChild(hiddenField);
	
	hiddenField = document.createElement("input");
	hiddenField.setAttribute("type","hidden");
	hiddenField.setAttribute("name", "radioValue1");
	hiddenField.setAttribute("value", radiovalue1);
	form.appendChild(hiddenField);
	
	if(radiovalue1=="인문계열"){
	hiddenField = document.createElement("input");
	hiddenField.setAttribute("type","hidden");
	hiddenField.setAttribute("name", "radioValue2");
	hiddenField.setAttribute("value", radiovalue2);
	form.appendChild(hiddenField);
	}
	
	if(radiovalue1=="자연계열"){
	hiddenField = document.createElement("input");
	hiddenField.setAttribute("type","hidden");
	hiddenField.setAttribute("name", "radioValue2");
	hiddenField.setAttribute("value", radiovalue3);
	form.appendChild(hiddenField);
	}
	
	hiddenField = document.createElement("input");
	hiddenField.setAttribute("type","hidden");
	hiddenField.setAttribute("name", "radioValue4");
	hiddenField.setAttribute("value", radiovalue4);
	form.appendChild(hiddenField);
	
	
	document.body.appendChild(form);
	form.submit();
	 
	//$("#categoryAcademy input[type=radio]:checked").val();
	//alert(selectedAcademy);
}