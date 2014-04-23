$(document).ready(function() {
	var form = $("#className");
	
	console.log(form);
	var select = $("<font>学期</font><select name='term'>");
	var option1 = $("<option vaule='201402'>201404</option>");
	var option2 = $("<option vaule='201401'>201403</option>");
	var option3 = $("<option vaule='201302'>201302</option>");
	var option4 = $("<option vaule='201301'>201301</option>");
	var option5 = $("<option vaule='201202'>201202</option>");
	var option6 = $("<option vaule='201201'>201201</option>");
	select.append(option1);
	select.append(option2);
	select.append(option3);
	select.append(option4);
	select.append(option5);
	select.append(option6);
	
	select.insertAfter(form);
	
	
});