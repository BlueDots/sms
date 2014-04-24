$(document).ready(function() {
	var form = $("#className");

	console.log(form);
	var select = $("<font>学期</font><select name='term' id='term'>");
	var option1 = $("<option vaule='201402'>201502</option>");
	var option2 = $("<option vaule='201402'>201501</option>");
	var option3 = $("<option vaule='201402'>201402</option>");
	var option4 = $("<option vaule='201402'>201401</option>");
	var option5 = $("<option vaule='201302'>201302</option>");
	var option6 = $("<option vaule='201301'>201301</option>");
	var option7 = $("<option vaule='201202'>201202</option>");
	var option8 = $("<option vaule='201201'>201201</option>");
	select.append(option1);
	select.append(option2);
	select.append(option3);
	select.append(option4);
	select.append(option5);
	select.append(option6);
	select.append(option7);
	select.append(option8);

	select.insertAfter(form);

});


//更新学生名单
function updateData(aaa) {
    
	var num =getCheckBox(); 
	if(num>1){
		alert("录入数据只能勾选一个名单");
		return ;
	}
	
	if(num==0){
		alert("请在奖学金信息表中勾选一个名单");
		return ;
	}
	
	var hosNo  = 	$("input[type='checkbox'][name='oprechebox']:checkbox:checked").val();
	
	 console.log(hosNo);
	var  datas  = hosNo.split(',');
	state = datas[0];
	urlParam = datas[1];
	console.log(state);
	console.log(urlParam);
	
	var stateValue = state.split('=');
	if(stateValue=='通过'){
		alert("该记录已通过审核不可更改");
		return ;
	}
	
	if(aaa==0 && stateValue=='校级审核中'){
		alert("该记录正在校级审核中..班主任不可修改");
		return ;
	}
	
	$.getJSON('scholarShipAjxa/scholarShipAjxa!queryOneStudentByTermStudentNo?'+urlParam,function(data){
		$("#mbaseScore").val(data.scholar.baseScore);
		$("#mawardScore").val(data.scholar.awardScore);
		$("#mpunishScore").val(data.scholar.punishScore);
		$("#mlessonScore").val(data.scholar.lessonScore);
		$("#minnovateScore").val(data.scholar.innovateScore);
		$("#mskillsScore").val(data.scholar.skillsScore);
		$("#msportScore").val(data.scholar.sportScore);
		$("#mphysiqueScore").val(data.scholar.physiqueScore);
		$("#msportMatchScore").val(data.scholar.sportMatchScore);
		$("#mmanageScore").val(data.scholar.manageScore);
		$("#mcultureScore").val(data.scholar.cultureScore);
		$("#mmediaScore").val(data.scholar.mediaScore);
		$("#mserviceScore").val(data.scholar.serviceScore);
		$("#examStateForModify").val(data.examState);
		$("#modiftName").html(data.scholar.student.studentName);
		
		$("#studentNoForModify").val(data.scholar.student.studentNo);
		$("#termForModify").val(data.scholar.term);
		$('#modifyDiv').show();$('#modifyInfoDiv').show();
	});
	
}


//获取修改名单
function getCheckBox(){
	var  data = $("input[type='checkbox'][name='oprechebox']:checkbox:checked");
	console.log(data.length);
	return data.length;
}









var flag = 1;

/**
 * 核对提交的form表单属性
 */
function checkFormDate() {
	var result = true;
	var inputCompent = $("#editMsg").find('input');
	var selectCpmpent = $("#editMsg").find('select');
	console.log(inputCompent);
	console.log(selectCpmpent);
	$.each(inputCompent, function(index, compont) {
		console.log(compont.name);
		if (compont.name == 'studentNo' && compont.value == '') {
			alert('需要添加的学号不能为空');
			result = false;
			return result;
		}
		if (compont.name == 'baseScore' && compont.value == '0') {
			alert('基准分不能为0');
			result = false;
			return result;
		}
		if (compont.name == 'lessonScore' && compont.value == '0') {
			alert('学院课程分分不能为0');
			result = false;
			return result;
		}

		if (compont.name == 'lessonScore' && compont.value == '0') {
			alert('学院课程分分不能为0');
			result = false;
			return result;
		}
	});

	$.each(selectCpmpent, function(index, compont) {

		$.each(selectCpmpent, function(index1, compont2) {
			if (compont.value != compont2.value) {
				alert('添加的学期必须全部相同');
				result = false;
				return result;
			}
		});
	});

	$('#CollegeForAdd').val($('#college').val());
	$('#CollegeForclassName').val($('#className').val());
	return result;
}

function addMoreColumn(aaa) {

	if (aaa == '1') {
		if ($('#college').val() == '-1' || $("#className").val() == '-1') {
			alert("请先选择需要添加的班级和班级所在的学院!");

		}
	} else {

		$("#allbasicMsg").hide();
		$("#editMsg").show();
		var numsOfRow = prompt("请输入要录入的记录数", "");
		if (numsOfRow == "" || isNaN(numsOfRow)) {
			alert("请输入数字" + numsOfRow);
		} else if (numsOfRow > 50 || numsOfRow < 1) {
			alert("请输入1-10范围内的数字");
		}

		for ( var i = 0; i < numsOfRow; i++) {
			var data = "<select style='width:100% ' name='term'>"
					+ "     <option value='201502'>201502</option>"
					+ "     <option value='201501'>201501</option>"
					+ "     <option value='201402'>201402</option>"
					+ "     <option value='201401'>201401</option>"
					+ "     <option value='201302'>201302</option>"
					+ "    <option value='201301'>201301</option>"
					+ "     </select> ";
			if (i >= 1) {
				data = "同上";
			}
			var tr1 = $("<tr>"
					+ "  <td height='40'  >"
					+

					" <table border='0' cellpadding='4'"
					+ "			cellspacing='0'   class='demo'  >"
					+ "		  <tr bgcolor='#FFFFFF' align = 'center'>"
					+ "    <td rowspan='3' align='left' style='width:35px;' > <input type='text' style='width:100% ' name='studentNo'></td>"
					+ "    <td   rowspan='3'  align='left' style='width:20px ' >"
					+ data
					+ "</td>"
					+

					"     <td rowspan='2' align='left' style='width:20px '  ><input type='text' name='baseScore' value='0' style='width:100%  '> </td>"
					+ "    <td   rowspan='2' align='left'  style='width:20px ' ><input type='text' name='awardScore' value='0' style='width:100%  '></td>"
					+ "    <td  rowspan='2' align='left' style='width:10px ' ><input type='text' name='punishScore' value='0' style='width:100% '></td>"
					+

					"     <td  rowspan='2'  align='left' style='width:20px ' ><input type='text' name='lessonScore' value='0' style='width:100% '></td>"
					+ "     <td   rowspan='2' align='left' style='width:40px ' ><input type='text' name='innovateScore' value='0' style='width:100%  '></td>"
					+ "     <td   rowspan='2' align='left'style='width:40px '  ><input type='text' name='skillsScore' value='0' style='width:100% '></td>"
					+

					"    <td   rowspan='2' align='left' style='width:40px ' ><input type='text' name='sportScore' value='0' style='width:100%  '> </td>"
					+ "    <td  rowspan='2' align='left' style='width:40px ' ><input type='text' name='physiqueScore' value='0' style='width:100%  '></td>"
					+ "    <td  rowspan='2' align='left' style='width:40px ' ><input type='text' name='sportMatchScore' value='0' style='width:100% '></td>"
					+

					"    <td  rowspan='2' align='left' style='width:40px ' ><input type='text' name='manageScore' value='0' style='width:100% '></td>"
					+ "   <td  rowspan='2' align='left'style='width:40px '  ><input type='text' name='cultureScore' value='0' style='width:100% '></td>"
					+ "    <td   rowspan='2' align='left' style='width:40px ' ><input type='text' name='mediaScore' value='0' style='width:100% '></td>"
					+ "     <td  rowspan='2' align='left'style='width:40px '  ><input type='text' name='serviceScore' value='0' style='width:100% '></td>"
					+ "  </tr> " +

					"</table>" +

					"</td>" +

					"</tr>");
			$("#entryScholarshipAssessInfo").append(tr1);
		}

		var button = $("<tr >" + "  <td height='40' >" +

		"  <table border='0' cellpadding='4'"
				+ "	cellspacing='1'  class='demo' id = 'abc'>"
				+ "	<tr  align = 'center'>"
				+ "		<td height='22' colspan='7' align='right'"
				+ "			style='font-size: 16px'>"
				+ "		<input type='submit' value='提交'>	" + "		</td>"
				+ "			<td height='22' colspan='8' align='left'"
				+ "				style='font-size: 16px'>"
				+ "				<input type='reset' value='取消'>" + "			</td>" + "	</tr>"
				+ "</table>" +

				"	</td>" +

				"</tr>");

		if (flag == 1) {
			flag = 0;
			$("#entryScholarshipAssessInfo").append(button);
		}
	}

}
/**
 * 通过学生的编号获取所有的数据
 * 
 * @param studentNo
 */
function getOneStudentSchloar(studentNo) {

	if (studentNo == undefined || studentNo == '') {
		alert("学号不能为空");
	}

	$.getJSON(
					'scholarShipAjxa/scholarShipAjxa!queryOneStudentSchloar?studentNo='
							+ studentNo,
					function(data) {
						if (data.message != null || data.message != undefined) {
							alert(data.message);
							return;
						}

						var table = $("#pastAdvInfoTab");
						table.empty();

						var trHead = $("<tr class='CTitle'>"
								+ "+	<td height='22' colspan='10' align='center' style='font-size: 16px'>"
								+ "+学生奖学金信息表" + "+</td>" + "+  </tr>");
						table.append(trHead);
						var trTitle = $("<tr bgcolor='#FFFFFF' align='center'>"
								+ " <td width='10%' name='assTerm'> " + "学期"
								+ " </td>"
								+ "<td width='15%' name='totalScore'> "
								+ " 	德育素质得分" + " </td>"
								+ "  <td width='15%' name='totalScore'> "
								+ "  	智育素质得分" + "  </td>"
								+ "  <td width='15%' name='totalScore'> "
								+ " 	体育素质得分" + " </td>"
								+ "  <td width='15%' name='totalScore'> "
								+ " 	美育素质得分" + " </td>"
								+ " <td width='15%' name='totalScore'> "
								+ "	总得分" + " </td>"
								+ "  <td width='10%' name='assLevel'> "
								+ " 	奖学金等级" + "</td>"
								+ " <td width='5%' name='assRank'> " + " 	排名"
								+ " </td>" + "</tr>");
						table.append(trTitle);
						$.each(data.scholars, function(index, value) {
							var tr=null;
							  tr = $("<tr bgcolor='#FFFFFF' align='center'>"
									+ "<td>"
									+ value.term
									+ "</td>"
									+ "<td>"
									+ value.moralQualityAssessmentScore
									+ "</td>"
									+ "<td>"
									+ value.qualityScore
									+ "</td>"
									+ "<td>"
									+ value.sportQualityTotalScore
									+ "</td>"
									+ "<td>"
									+ value.artEducationTotalScore
									+ "</td>"
									+ "<td>"
									+ value.totalScore
									+ "</td>"
									+ "<td>"
									+ value.rank
									+ "</td>"
									+ "<td>" + value.totalScoreRank + "</td>" +

									"</tr>");

							tr.appendTo(table);
						 
						 
						});

						$("#assessInfoDiv").show();
						$("#setSchStuBasicInfoDiv").show();
					});
}