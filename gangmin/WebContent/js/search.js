function findlecture(e)
{
	var frmsearch = document.frmsearch;
	var findl = document.getElementById("searchlecture").value;
		if(e.keyCode == 13)
		{
			frmsearch.method = "get";
			frmsearch.action = "/gangmin/lecture/searchLecture.do";
			frmsearch.submit();
		}
	
}