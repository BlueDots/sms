//民族
var nations=new Array("汉族","蒙古族","回族","藏族","维吾尔族","苗族","彝族","壮族","布依族","朝鲜族","满族","侗族","瑶族","白族","土家族","哈尼族","哈萨克族","傣族","黎族","僳僳族","佤族","畲族","高山族","拉祜族","水族","东乡族","纳西族","景颇族","柯尔克孜族","土族","达斡尔族","仫佬族","羌族","布朗族","撒拉族","毛南族","仡佬族","锡伯族","阿昌族","普米族","塔吉克族","怒族","乌孜别克族","俄罗斯族","鄂温克族","德昂族","保安族","裕固族","京族","塔塔尔族","独龙族","鄂伦春族","赫哲族","门巴族","珞巴族","基诺族","其他");
//政治面貌
var political_status = new Array("共青团员","中共预备党员","中共党员","群众","其他","不详");

//获取学院信息
function setCollegeData_enter(collegeSelect) {
	$.getJSON("college/college!showCollege?type=depart", function(data) {
		var depInfos = data.depInfos;
		var optionfirst = $("<option value='-1' id='-1' >请选择</option>");
		collegeSelect.append(optionfirst);
		var i=0;
		$.each(depInfos, function(index, value) {
			var departNo = value.departNo;
			var department = value.department;
			var option = $("<option value='" + department + "' id='"+departNo+i+"' >" + department
					+ "</option>");
			collegeSelect.append(option);
			i++;
		});
	});
}
//获取专业信息
function setMajorData_enter(value,majorSelect) {
	$.getJSON("college/college!showCollege?type=major&departNo="+value,function(data){
		var majors = data.majors;
		majorSelect.empty();
		var i=0;
		var optionfirst = $("<option value='-1' id='-1' >请选择</option>");
		majorSelect.append(optionfirst);
		$.each(majors, function(index, value) {
			var major = value.major;
			var majorNo = value.majorNo;
			var option = $("<option value='" + major + "' id='"+majorNo+i+"' >" + major
					+ "</option>");
			majorSelect.append(option);
			i++;
		});
	});
}

//初始化学院下拉框的监听事件
function initCollegeListener_enter(collegeSelect,majorSelect) {
	collegeSelect.change(function(event){
		
		var value;
		//jquery 转换成 dom 
		var collegeSelectDom=collegeSelect.get(0);
		for(var i=0;i<collegeSelectDom.options.length;i++)
			 if(collegeSelectDom.options[i].selected){
				 value=collegeSelectDom.options[i].id;
		}
		//截取字符串,前4位为学院编号
		if(value.length==5)
			value = value.substr(0, 4);
		
		if(value!=-1){
	    setMajorData_enter(value,majorSelect);
		}else{
			alert("请选择具体的学院");
		}
	 });
}
//初始化专业的下拉框的监听事件
function initMajorListener_enter(collegeSelect,majorSelect,classSelect) {
	
	majorSelect.change(function(){
		var college;
		var value;
		//jquery 转换成 dom
		var collegeSelectDom = collegeSelect.get(0);
		//获得选中option的id
		for(var i=0;i<collegeSelectDom.options.length;i++)
			 if(collegeSelectDom.options[i].selected){
				 college=collegeSelectDom.options[i].id;
		}
		
		//jquery 转换成 dom
		var majorSelectDom = majorSelect.get(0);
		//获得选中option的id
		for(var i=0;i<majorSelectDom.options.length;i++)
			 if(majorSelectDom.options[i].selected){
				 value=majorSelectDom.options[i].id;
		}
		
		//截取id 
		//前8位为班级编号
		if(value.length==9)
			value = value.substr(0, 8);
		//前4位为学院编号
		if(college.length==5)
			college = college.substr(0, 4);
		
		var url  = "college/college!showCollege?type=class";
		if(value==-1&& college==-1){
	       alert("请选择学院");
	       return ;
		}else if(value==-1&& college!=-1){
			url=url+"&departNo="+college;
		}else if(value!=-1){
			url=url+"&majorNo="+value;
		}
		
		$.getJSON(url,function(data){
			
			var classs = data.classInfos;
			classSelect.empty();
			var firstMajorData = $("<option value='-1'>全部</option>");
			classSelect.append(firstMajorData);
			$.each(classs, function(index, value) {
				var className = value.className;
				var classNo = value.classNo;
				var option = $("<option value='" + className + "' >" + className
						+ "</option>");
				classSelect.append(option);
			});
		});
	 });
}


//验证学号是否符合规范(数字，8位)
function validateStudent(studentNo) {
	if(isNaN(studentNo)) {
		alert("学号只能是数字!");
		return false;
	}
	if(studentNo.length!=8) {
		alert("学号只能为8位!");
		return false;
	}
	
	var flag = studentNoIsExist(studentNo);
	if(flag) {
		alert("学号已经存在!");
		return false;
	}
	
	return true;
}

function studentNoIsExist(studentNo) {
	var flag = false;
	$.ajaxSettings.async = false;  
	$.getJSON("StuBasicInfoJSON/StuBasicInfoActionJSON!validateStudentNoIsExist?studentNo="+studentNo,function(data) {
		if(data.studentNoIsExist == true) {
			flag=true;
		}
	});
	return flag;
}
 
/*切换*/
function exchange(id1,id2) {
	var Obj1 = document.getElementById(id1);
	var Obj2 = document.getElementById(id2);
	if(Obj1.style.display == "none") {
 			Obj1.style.display = "block";
 			Obj2.style.display = "none";
 		}
 		else {
 			Obj1.style.display = "none";
 			Obj2.style.display = "block";
 	}
}

/*手动录入*/
function manually(id) {
	var numsOfRow = prompt("请输入要录入的记录数","");
	if(numsOfRow=="" || isNaN(numsOfRow)) {
		alert("请输入数字");
	}
	else if(numsOfRow>5||numsOfRow<1) {
		alert("请输入1-5范围内的数字");
	}
	else {
		eval(id+"(numsOfRow)");
	}
}

//提交验证
function entrySubmitvalidate() {
	var flag = false;
	var entryTableObj = document.getElementById("entryStuBasicInfo");
	var entrySubmitObj = document.getElementById("entrySubmit");
	var entryForm = document.getElementById("entryForm");
	
	var trLength = $("#entryStuBasicInfo tr").length;
	
	entrySubmitObj.onclick=function() {
		//手动录入数据的行数
		var dataLength = trLength-3;
		for(var i=0;i<dataLength;i++) {
			//当前行下标（从1开始）
			var trIndex = i+1;
			var trObj = entryTableObj.rows[2+i];
			//学号输入框
			var sno = trObj.cells[1].childNodes[0];
			if(validateStudent(sno.value)==false) {
				alert("第"+trIndex+"行的学号输入不符合规范");
				return false;
			}
			//姓名输入框
			var sname = trObj.cells[2].childNodes[0];
			if(sname.value.length<=0){
				
				alert("第"+trIndex+"行的姓名不能为空!");
				return false;
			}
			//学院选择框
			var college = trObj.cells[3].childNodes[0];
			var collegeSelectNum=0;
			for(var collegeIndex=0;collegeIndex<college.options.length;collegeIndex++)
				if(college.options[collegeIndex].selected)
					collegeSelectNum++;
			if(collegeSelectNum==0) {
				alert("第"+trIndex+"行的学院必须选择一个!");
				return false;
			}
			//专业选择框
			var major = trObj.cells[4].childNodes[0];
			var majorSelectNum=0;
			for(var majorIndex=0;majorIndex<major.options.length;majorIndex++)
				if(major.options[majorIndex].selected)
					majorSelectNum++;
			if(majorSelectNum==0) {
				alert("第"+trIndex+"行的专业必须选择一个!");
				return false;
			}	
			
			//班级选择框
			var className = trObj.cells[5].childNodes[0];
			var classSelectNum=0;
			for(var classIndex=0;classIndex<className.options.length;classIndex++)
				if(className.options[classIndex].selected)
					classSelectNum++;
			if(classSelectNum==0) {
				alert("第"+trIndex+"行的班级必须选择一个!");
				return false;
			}	
			
			//性别选择框
			var sex = trObj.cells[6].childNodes[0];
			var sexSelectNum=0;
			for(var sexIndex=0;sexIndex<sex.options.length;sexIndex++)
				if(sex.options[sexIndex].selected)
					sexSelectNum++;
			if(sexSelectNum==0) {
				alert("第"+trIndex+"行的性别必须选择一个!");
				return false;
			}
			//民族选择框
			var nation = trObj.cells[7].childNodes[0];
			var nationSelectNum=0;
			for(var nationIndex=0;nationIndex<nation.options.length;nationIndex++)
				if(nation.options[nationIndex].selected)
					nationSelectNum++;
			
			if(nationSelectNum==0) {
				alert("第"+trIndex+"行的民族必须选择一个!");
				return false;
			}		
			//籍贯输入框
			var hometown = trObj.cells[8].childNodes[0];
			if(hometown.value.length<=0) {
				alert("第"+trIndex+"行的籍贯不能为空!");
				return false;
			}
			//身份证输入框
			var idCard = trObj.cells[10].childNodes[0];
			if(idCard.value.length!=18) {
				alert("第"+trIndex+"行的身份证输入不符合规范!");
				return false;
			}			
		}
		entryForm.submit();
	};
}

/*录入学生基本信息*/
function entryStuBasicInfo(numsOfRow) {
	var mainTr = document.getElementById("allbasicMsg");
		var editDiv = document.getElementById("editMsg");
		//change(mainTr,editDiv);
		mainTr.style.display = "none";
		editDiv.style.display = "block";
		//取得表对象
		var tableObj = document.getElementById("entryStuBasicInfo");
		var trLength = $("#entryStuBasicInfo tr").length;
		var differ = trLength-3;

		if(differ >= numsOfRow) {
			var i,j;
			j=differ-numsOfRow;
			for(i=0;i<j;i++)
				tableObj.deleteRow(trLength-2-i);
					
		}
		else {
			
		for(var i=0;i<numsOfRow-differ;i++) {
			
			var TrObj = tableObj.insertRow(trLength-1);
			TrObj.setAttribute("bgcolor","#EEEEEE");
			TrObj.setAttribute("align","center");
			
			//第一列:照片
			var TdObj1 = TrObj.insertCell(0);
			var photo = document.createElement("input");
			photo.type = "button";
			photo.value = "导入";
			photo.name="photo";
			photo.setAttribute("style","width:30px");
			TdObj1.appendChild(photo);

			//第二列 :学号
			var TdObj2 = TrObj.insertCell(1);
			var sno = document.createElement("input");
			sno.type = "text";
			sno.name = "sno";
			sno.setAttribute("style","width:60px");
			//添加事件
			sno.onblur=function() {
				validateStudent($(this).val());
			};
			TdObj2.appendChild(sno);

			//第三列:姓名
			var TdObj3 = TrObj.insertCell(2);
			var sname = document.createElement("input");
			sname.type = "text";
			sname.name = "sname";
			sname.setAttribute("style","width:60px");
			TdObj3.appendChild(sname);
			
			var collegeSelect = $("<select name='department'>");
			var majorSelect = $("<select name='major'>");
			var classSelect = $("<select name='className'>");

			
			//第四列：学院
			var TdObj4 = TrObj.insertCell(3);
			//初始化学院select
			setCollegeData_enter(collegeSelect);
			//加载监听
			initCollegeListener_enter(collegeSelect,majorSelect);
			//jquery转换成Dom对象
			var collegeSelect_Dom = collegeSelect.get(0);
			collegeSelect_Dom.name="college";
			TdObj4.appendChild(collegeSelect_Dom);			
			
			//第五列：专业
			var TdObj5 = TrObj.insertCell(4);
			//加载监听
			initMajorListener_enter(collegeSelect,majorSelect,classSelect);
			//jquery转换成Dom对象
			var majorSelect_Dom = majorSelect.get(0);
			majorSelect_Dom.name="major";
			TdObj5.appendChild(majorSelect_Dom);

			//第六列：班级
			var TdObj6 = TrObj.insertCell(5);
			//jquery转换成Dom对象
			var classSelect_Dom = classSelect.get(0);
			classSelect_Dom.name="className";
			TdObj6.appendChild(classSelect_Dom);

			//第七列：//性别
			var TdObj7 = TrObj.insertCell(6);
			var sex = document.createElement("select");
			sex.name="sex";
			var man = document.createElement("option");
			man.appendChild(document.createTextNode("男"));
			var female = document.createElement("option");
			female.appendChild(document.createTextNode("女"));
			sex.appendChild(man);
			sex.appendChild(female);
			TdObj7.appendChild(sex);

			//第八列:民族
			var TdObj8 = TrObj.insertCell(7);
			var nation = document.createElement("select");
			
			for(var nationIndex=0;nationIndex<nations.length;nationIndex++) {
				var opE = document.createElement("option");
				opE.appendChild(document.createTextNode(nations[nationIndex]));
				nation.appendChild(opE);
			}	
			nation.name="nation";
			TdObj8.appendChild(nation);

			//第九列:籍贯
			var TdObj9 = TrObj.insertCell(8);
			var birthPlace = document.createElement("input");
			birthPlace.type = "text";
			birthPlace.name = "birthPlace";	
			birthPlace.setAttribute("style","width:100px");
			TdObj9.appendChild(birthPlace);

			//第十列:政治面貌
			var TdObj10 = TrObj.insertCell(9);
			var political = document.createElement("select");
			political.name="political";
			for(var poIndex=0;poIndex<political_status.length;poIndex++) {
				var opE = document.createElement("option");
				opE.appendChild(document.createTextNode(political_status[poIndex]));
				political.appendChild(opE);
			}	
			TdObj10.appendChild(political);

			//第十一列:身份证
			var TdObj11 = TrObj.insertCell(10);
			var IDCard = document.createElement("input");
			IDCard.type="text";
			IDCard.name = "IDCard";
			IDCard.setAttribute("style","width:130px");
			TdObj11.appendChild(IDCard);

			//第十二列:学历
			var TdObj12 = TrObj.insertCell(11);
			var schooling = document.createElement("select");
			schooling.name="eduBackground";
			var s_1 = document.createElement("option");
			var s_2 = document.createElement("option");
			var s_3 = document.createElement("option");
			var s_4 = document.createElement("option");
			s_1.appendChild(document.createTextNode("本科"));
			s_2.appendChild(document.createTextNode("研究生"));
			s_3.appendChild(document.createTextNode("硕士"));
			s_4.appendChild(document.createTextNode("博士"));

			schooling.appendChild(s_1);
			schooling.appendChild(s_2);
			schooling.appendChild(s_3);
			schooling.appendChild(s_4);
			TdObj12.appendChild(schooling);


			//第十三列:银行卡号

			var TdObj13 = TrObj.insertCell(12);
			var bandCard = document.createElement("input");
			bandCard.name="bankCard";
			bandCard.type = "text";
			TdObj13.appendChild(bandCard);		
		}
	}
	//为提交按钮添加验证事件	
	entrySubmitvalidate();	
		
}


/*录入学生参与活动信息*/
function entryStudentActivityInfo(numsOfRow) {
	var mainTr = document.getElementById("allbasicMsg");
		var editDiv = document.getElementById("editMsg");
		//change(mainTr,editDiv);
		mainTr.style.display = "none";
		editDiv.style.display = "block";
		//取得表对象
		var tableObj = document.getElementById("entryStudentActivityInfo");
		var trLength = $("#entryStudentActivityInfo tr").length;
		var differ = trLength-3;
		if(differ >= numsOfRow) {
			var i,j;
			j=differ-numsOfRow;
			for(i=0;i<j;i++)
				tableObj.deleteRow(trLength-2-i);
					
		}
		else {

		for(var i=0;i<numsOfRow-differ;i++) {
			var TrObj = tableObj.insertRow(trLength-1);
			TrObj.setAttribute("bgcolor","#FFFFFF");
			TrObj.setAttribute("align","center");

			//第一列
			var TdObj1 = TrObj.insertCell(0);
			var sno = document.createElement("input");
			sno.type = "text";
			sno.name = "sno";
			sno.setAttribute("style","width:100px");
			TdObj1.appendChild(sno);

			//第二列
			var TdObj2 = TrObj.insertCell(1);
			var actno = document.createElement("input");
			actno.type = "text";
			actno.name = "actno";
			actno.setAttribute("style","width:100px");
			TdObj2.appendChild(actno);

			//第三列
			var TdObj3 = TrObj.insertCell(2);
			var sessionYear = document.createElement("input");
			sessionYear.type = "text";
			sessionYear.name = "sessionYear";
			sessionYear.setAttribute("style","width:50px");
			TdObj3.appendChild(sessionYear);

			//第四列
			var TdObj4 = TrObj.insertCell(3);
			var awardTime = document.createElement("input");
			awardTime.type = "text";
			awardTime.name = "awardTime";
			awardTime.setAttribute("style","width:100px");
			TdObj4.appendChild(awardTime);

			//第五列
			var TdObj5 = TrObj.insertCell(4);
			var awardRating = document.createElement("select");
			awardRating.name="awardRating";
			var name1 = document.createElement("option");
			name1.appendChild(document.createTextNode("一等奖"));
			var name2 = document.createElement("option");
			name2.appendChild(document.createTextNode("二等奖"));
			var name3 = document.createElement("option");
			name3.appendChild(document.createTextNode("三等奖"));
			var name4 = document.createElement("option");
			name4.appendChild(document.createTextNode("优胜奖"));
			awardRating.appendChild(name1);
			awardRating.appendChild(name2);
			awardRating.appendChild(name3);
			awardRating.appendChild(name4);
			TdObj5.appendChild(awardRating);

			//第六列
			var TdObj6 = TrObj.insertCell(5);
			var stuJob = document.createElement("input");
			stuJob.type = "text";
			stuJob.name="stuJob";
			stuJob.setAttribute("style","width:150px");
			TdObj6.appendChild(stuJob);

			//第七列
			var TdObj7 = TrObj.insertCell(6);
			var workingTime = document.createElement("input");
			workingTime.type = "text";
			workingTime.name="workingTime";
			workingTime.setAttribute("style","width:150px");
			TdObj7.appendChild(workingTime);
		}
	}
		
}


/*录入活动信息*/
function entryActivityInfo(numsOfRow) {
	var mainTr = document.getElementById("allbasicMsg");
		var editDiv = document.getElementById("editMsg");
		//change(mainTr,editDiv);
		mainTr.style.display = "none";
		editDiv.style.display = "block";
		//取得表对象
		var tableObj = document.getElementById("entryActivityInfo");
		var trLength = $("#entryActivityInfo tr").length;
		var differ = trLength-3;
		if(differ >= numsOfRow) {
			var i,j;
			j=differ-numsOfRow;
			for(i=0;i<j;i++)
				tableObj.deleteRow(trLength-2-i);
					
		}
		else {

		for(var i=0;i<numsOfRow-differ;i++) {
			var TrObj = tableObj.insertRow(trLength-1);
			TrObj.setAttribute("bgcolor","#FFFFFF");
			TrObj.setAttribute("align","center");

			//第一列
			var TdObj1 = TrObj.insertCell(0);
			var actName = document.createElement("input");
			actName.type = "text";
			actName.name = "actName";
			actName.setAttribute("style","width:150px");
			TdObj1.appendChild(actName);

			//第二列
			var TdObj2 = TrObj.insertCell(1);
			var sponsor = document.createElement("input");
			sponsor.type = "text";
			sponsor.name = "sponsor";
			sponsor.setAttribute("style","width:80px");
			TdObj2.appendChild(sponsor);

			//第三列
			var TdObj3 = TrObj.insertCell(2);
			var organize = document.createElement("input");
			organize.type = "text";
			organize.name = "organize";
			organize.setAttribute("style","width:80px");
			TdObj3.appendChild(organize);

			//第四列
			var TdObj4 = TrObj.insertCell(3);
			var teacherNo = document.createElement("input");
			teacherNo.type = "text";
			teacherNo.name = "teacherNo";
			teacherNo.setAttribute("style","width:70px");
			TdObj4.appendChild(teacherNo);

			//第五列
			var TdObj5 = TrObj.insertCell(4);
			var stuName = document.createElement("input");
			stuName.type = "text";
			stuName.name = "stuName";
			stuName.setAttribute("style","width:70px");
			TdObj5.appendChild(stuName);

			//第六列
			var TdObj6 = TrObj.insertCell(5);
			var actType = document.createElement("select");
			actType.name="actType";
			var name1 = document.createElement("option");
			name1.appendChild(document.createTextNode("学术科技类"));
			var name2 = document.createElement("option");
			name2.appendChild(document.createTextNode("文艺体育类"));
			var name3 = document.createElement("option");
			name3.appendChild(document.createTextNode("社会公益类"));
			var name4 = document.createElement("option");
			name4.appendChild(document.createTextNode("实践创新类"));
			var name5 = document.createElement("option");
			name5.appendChild(document.createTextNode("理论学习类"));
			var name6 = document.createElement("option");
			name6.appendChild(document.createTextNode("其他类"));
			actType.appendChild(name1);
			actType.appendChild(name2);
			actType.appendChild(name3);
			actType.appendChild(name4);
			actType.appendChild(name5);
			actType.appendChild(name6);
			TdObj6.appendChild(actType);

			//第七列
			var TdObj7 = TrObj.insertCell(6);
			var actLevel = document.createElement("select");
			actLevel.name="actLevel";
			var name1 = document.createElement("option");
			name1.appendChild(document.createTextNode("院级"));
			var name2 = document.createElement("option");
			name2.appendChild(document.createTextNode("校级"));
			var name3 = document.createElement("option");
			name3.appendChild(document.createTextNode("厅级"));
			var name4 = document.createElement("option");
			name4.appendChild(document.createTextNode("国家级"));
			actLevel.appendChild(name1);
			actLevel.appendChild(name2);
			actLevel.appendChild(name3);
			actLevel.appendChild(name4);
			TdObj7.appendChild(actLevel);

			//第八列
			var TdObj8 = TrObj.insertCell(7);
			var actDescribe = document.createElement("input");
			actDescribe.type = "text";
			actDescribe.name = "actDescribe";
			actDescribe.setAttribute("style","width:250px");
			TdObj8.appendChild(actDescribe);			
		}
	}
		
}


/*录入就业信息*/
function entryJobInfo(numsOfRow) {
	var mainTr = document.getElementById("allbasicMsg");
		var editDiv = document.getElementById("editMsg");
		//change(mainTr,editDiv);
		mainTr.style.display = "none";
		editDiv.style.display = "block";
		//取得表对象
		var tableObj = document.getElementById("entryJobInfo");
		var trLength = $("#entryJobInfo tr").length;
		var differ = trLength-3;
		if(differ >= numsOfRow) {
			var i,j;
			j=differ-numsOfRow;
			for(i=0;i<j;i++)
				tableObj.deleteRow(trLength-2-i);
					
		}
		else {

		for(var i=0;i<numsOfRow-differ;i++) {
			var TrObj = tableObj.insertRow(trLength-1);
			TrObj.setAttribute("bgcolor","#FFFFFF");
			TrObj.setAttribute("align","center");

			//第一列
			var TdObj1 = TrObj.insertCell(0);
			var stuno = document.createElement("input");
			stuno.type = "text";
			stuno.name = "stuno";
			stuno.setAttribute("style","width:100px");
			TdObj1.appendChild(stuno);

			//第二列
			var TdObj2 = TrObj.insertCell(1);
			var jobTimes = document.createElement("input");
			jobTimes.type = "text";
			jobTimes.name = "jobTimes";
			jobTimes.setAttribute("style","width:80px");
			TdObj2.appendChild(jobTimes);

			//第三列
			var TdObj3 = TrObj.insertCell(2);
			var company = document.createElement("input");
			company.type = "text";
			company.name = "company";
			company.setAttribute("style","width:250px");
			TdObj3.appendChild(company);

			//第四列
			var TdObj4 = TrObj.insertCell(3);
			var jobType = document.createElement("select");
			jobType.name="jobType";
			var name1 = document.createElement("option");
			name1.appendChild(document.createTextNode("国企"));
			var name2 = document.createElement("option");
			name2.appendChild(document.createTextNode("私企"));
			var name3 = document.createElement("option");
			name3.appendChild(document.createTextNode("外企"));
			var name4 = document.createElement("option");
			name4.appendChild(document.createTextNode("公务员"));
			var name5 = document.createElement("option");
			name5.appendChild(document.createTextNode("事业单位"));
			jobType.appendChild(name1);
			jobType.appendChild(name2);
			jobType.appendChild(name3);
			jobType.appendChild(name4);
			jobType.appendChild(name5);
			TdObj4.appendChild(jobType);

			//第五列
			var TdObj5 = TrObj.insertCell(4);
			var jobTime = document.createElement("input");
			jobTime.type = "text";
			jobTime.name = "stuName";
			jobTime.setAttribute("style","width:120px");
			TdObj5.appendChild(jobTime);
		}
	}
		
}


/*录入学生处分信息*/
function entryPunishInfo(numsOfRow) {
	var mainTr = document.getElementById("allbasicMsg");
		var editDiv = document.getElementById("editMsg");
		//change(mainTr,editDiv);
		mainTr.style.display = "none";
		editDiv.style.display = "block";
		//取得表对象
		var tableObj = document.getElementById("entryPunishInfo");
		var trLength = $("#entryPunishInfo tr").length;
		var differ = trLength-3;
		if(differ >= numsOfRow) {
			var i,j;
			j=differ-numsOfRow;
			for(i=0;i<j;i++)
				tableObj.deleteRow(trLength-2-i);
					
		}
		else {

		for(var i=0;i<numsOfRow-differ;i++) {
			var TrObj = tableObj.insertRow(trLength-1);
			TrObj.setAttribute("bgcolor","#FFFFFF");
			TrObj.setAttribute("align","center");

			//第一列
			var TdObj1 = TrObj.insertCell(0);
			var sno = document.createElement("input");
			sno.type = "text";
			sno.name = "sno";
			sno.setAttribute("style","width:150px");
			TdObj1.appendChild(sno);

			//第二列
			var TdObj2 = TrObj.insertCell(1);
			var punlishTime = document.createElement("input");
			punlishTime.type = "text";
			punlishTime.name = "punlishTime";
			punlishTime.setAttribute("style","width:150px");
			TdObj2.appendChild(punlishTime);

			//第三列
			var TdObj3 = TrObj.insertCell(2);
			var publishType = document.createElement("select");
			publishType.name="publishType";
			var name1 = document.createElement("option");
			name1.appendChild(document.createTextNode("通报批评"));
			var name2 = document.createElement("option");
			name2.appendChild(document.createTextNode("警告"));
			var name3 = document.createElement("option");
			name3.appendChild(document.createTextNode("严重警告"));
			var name4 = document.createElement("option");
			name4.appendChild(document.createTextNode("记过"));
			var name5 = document.createElement("option");
			name5.appendChild(document.createTextNode("留校察看"));
			var name6 = document.createElement("option");
			name6.appendChild(document.createTextNode("开除学籍"));
			publishType.appendChild(name1);
			publishType.appendChild(name2);
			publishType.appendChild(name3);
			publishType.appendChild(name4);
			publishType.appendChild(name5);
			publishType.appendChild(name6);
			TdObj3.appendChild(publishType);

			//第四列
			var TdObj4 = TrObj.insertCell(3);
			var publishReason = document.createElement("input");
			publishReason.type = "text";
			publishReason.name = "publishReason";
			publishReason.setAttribute("style","width:400px");
			TdObj4.appendChild(publishReason);

		}
	}
		
}

/*录入学生学籍变动信息*/
function entryStatusInfo(numsOfRow) {
	var mainTr = document.getElementById("allbasicMsg");
		var editDiv = document.getElementById("editMsg");
		//change(mainTr,editDiv);
		mainTr.style.display = "none";
		editDiv.style.display = "block";
		//取得表对象
		var tableObj = document.getElementById("entryStatusInfo");
		var trLength = $("#entryStatusInfo tr").length;
		var differ = trLength-3;
		if(differ >= numsOfRow) {
			var i,j;
			j=differ-numsOfRow;
			for(i=0;i<j;i++)
				tableObj.deleteRow(trLength-2-i);
					
		}
		else {

		for(var i=0;i<numsOfRow-differ;i++) {
			var TrObj = tableObj.insertRow(trLength-1);
			TrObj.setAttribute("bgcolor","#FFFFFF");
			TrObj.setAttribute("align","center");

			//第一列
			var TdObj1 = TrObj.insertCell(0);
			var sno = document.createElement("input");
			sno.type = "text";
			sno.name = "sno";
			sno.setAttribute("style","width:150px");
			TdObj1.appendChild(sno);

			//第二列
			var TdObj2 = TrObj.insertCell(1);
			var statusType = document.createElement("select");
			statusType.name="statusType";
			var name1 = document.createElement("option");
			name1.appendChild(document.createTextNode("退学"));
			var name2 = document.createElement("option");
			name2.appendChild(document.createTextNode("删除学生"));
			var name3 = document.createElement("option");
			name3.appendChild(document.createTextNode("专升本"));
			var name4 = document.createElement("option");
			name4.appendChild(document.createTextNode("留级"));
			var name5 = document.createElement("option");
			name5.appendChild(document.createTextNode("转专业"));
			var name6 = document.createElement("option");
			name6.appendChild(document.createTextNode("转院"));
			statusType.appendChild(name1);
			statusType.appendChild(name2);
			statusType.appendChild(name3);
			statusType.appendChild(name4);
			statusType.appendChild(name5);
			statusType.appendChild(name6);
			TdObj2.appendChild(statusType);

			//第三列
			var TdObj3 = TrObj.insertCell(2);
			var statusTime = document.createElement("input");
			statusTime.type = "text";
			statusTime.name = "statusTime";
			statusTime.setAttribute("style","width:150px");
			TdObj3.appendChild(statusTime);

			//第四列
			var TdObj4 = TrObj.insertCell(3);
			var remarks = document.createElement("input");
			remarks.type = "text";
			remarks.name = "remarks";
			remarks.setAttribute("style","width:400px");
			TdObj4.appendChild(remarks);

		}
	}
		
}



/*录入教师基本信息*/
function entryTeacherInfo(numsOfRow) {
	var mainTr = document.getElementById("allbasicMsg");
		var editDiv = document.getElementById("editMsg");
		//change(mainTr,editDiv);
		mainTr.style.display = "none";
		editDiv.style.display = "block";
		//取得表对象
		var tableObj = document.getElementById("entryTeacherInfo");
		var trLength = $("#entryTeacherInfo tr").length;
		var differ = trLength-3;
		if(differ >= numsOfRow) {
			var i,j;
			j=differ-numsOfRow;
			for(i=0;i<j;i++)
				tableObj.deleteRow(trLength-2-i);
					
		}
		else {

		for(var i=0;i<numsOfRow-differ;i++) {
			var TrObj = tableObj.insertRow(trLength-1);
			TrObj.setAttribute("bgcolor","#FFFFFF");
			TrObj.setAttribute("align","center");

			//第一列
			var TdObj1 = TrObj.insertCell(0);
			var tecno = document.createElement("input");
			tecno.type = "text";
			tecno.name = "tecno";
			tecno.setAttribute("style","width:50px");
			TdObj1.appendChild(tecno);

			//第二列
			var TdObj2 = TrObj.insertCell(1);
			var tecname = document.createElement("input");
			tecname.type = "text";
			tecname.name = "tecname";
			tecname.setAttribute("style","width:50px");
			TdObj2.appendChild(tecname);

			//第三列
			var TdObj3 = TrObj.insertCell(2);
			var sex = document.createElement("select");
			var man = document.createElement("option");
			man.appendChild(document.createTextNode("男"));
			var female = document.createElement("option");
			female.appendChild(document.createTextNode("女"));
			sex.appendChild(man);
			sex.appendChild(female);
			TdObj3.appendChild(sex);

			//第四列
			var TdObj4 = TrObj.insertCell(3);
			var nation = document.createElement("select");
			var han = document.createElement("option");
			han.appendChild(document.createTextNode("汉族"));
			var nohan = document.createElement("option");
			nohan.appendChild(document.createTextNode("非汉族"));
			nation.appendChild(han);
			nation.appendChild(nohan);
			TdObj4.appendChild(nation);

			//第五列
			var TdObj5 = TrObj.insertCell(4);
			var birthPlace = document.createElement("input");
			birthPlace.type = "text";
			birthPlace.name = "name";
			birthPlace.setAttribute("style","width:80px");
			TdObj5.appendChild(birthPlace);

			//第六列
			var TdObj6 = TrObj.insertCell(5);
			var political = document.createElement("select");
			var p1 = document.createElement("option");
			p1.appendChild(document.createTextNode("群众"));
			var p2 = document.createElement("option");
			p2.appendChild(document.createTextNode("团员"));
			var p3 = document.createElement("option");
			p3.appendChild(document.createTextNode("党员"));
			political.appendChild(p1);
			political.appendChild(p2);
			political.appendChild(p3);
			TdObj6.appendChild(political);

			//第七列
			var TdObj7 = TrObj.insertCell(6);
			var birthPlace = document.createElement("input");
			birthPlace.type = "text";
			birthPlace.name = "name";
			birthPlace.setAttribute("style","width:80px");
			TdObj7.appendChild(birthPlace);

			//第八列
			var TdObj8 = TrObj.insertCell(7);
			var teachertitle = document.createElement("select");
			teachertitle.name="teachertitle";
			var s_1 = document.createElement("option");
			var s_2 = document.createElement("option");
			var s_3 = document.createElement("option");
			var s_4 = document.createElement("option");
			var s_5 = document.createElement("option");
			var s_6 = document.createElement("option");
			var s_7 = document.createElement("option");
			var s_8 = document.createElement("option");
			var s_9 = document.createElement("option");
			s_1.appendChild(document.createTextNode("教授"));
			s_2.appendChild(document.createTextNode("副教授	"));
			s_3.appendChild(document.createTextNode("讲师"));
			s_4.appendChild(document.createTextNode("助教"));
			s_5.appendChild(document.createTextNode("研究员"));
			s_6.appendChild(document.createTextNode("副研究员"));
			s_7.appendChild(document.createTextNode("高级实验师"));
			s_8.appendChild(document.createTextNode("助理研究员"));	
			s_9.appendChild(document.createTextNode("助理工程师"));			
			teachertitle.appendChild(s_1);
			teachertitle.appendChild(s_2);
			teachertitle.appendChild(s_3);
			teachertitle.appendChild(s_4);
			teachertitle.appendChild(s_5);
			teachertitle.appendChild(s_6);
			teachertitle.appendChild(s_7);
			teachertitle.appendChild(s_8);
			teachertitle.appendChild(s_9);			
			TdObj8.appendChild(teachertitle);

			//第九列
			var TdObj9 = TrObj.insertCell(8);
			var department = document.createElement("input");
			department.type = "text";
			department.name = "department";	
			department.setAttribute("style","width:60px");
			TdObj9.appendChild(department);
			//第十列
			var TdObj10 = TrObj.insertCell(9);
			var workingTime = document.createElement("input");
			workingTime.type="text";
			workingTime.name = "workingTime";
			workingTime.setAttribute("style","width:150px")
			TdObj10.appendChild(workingTime);

			//第十一列
			var TdObj11 = TrObj.insertCell(10);
			var schooling = document.createElement("select");
			var s_1 = document.createElement("option");
			var s_2 = document.createElement("option");
			var s_3 = document.createElement("option");
			var s_4 = document.createElement("option");
			s_1.appendChild(document.createTextNode("本科"));
			s_2.appendChild(document.createTextNode("研究生"));
			s_3.appendChild(document.createTextNode("硕士"));
			s_4.appendChild(document.createTextNode("博士"));
			schooling.appendChild(s_1);
			schooling.appendChild(s_2);
			schooling.appendChild(s_3);
			schooling.appendChild(s_4);
			TdObj11.appendChild(schooling);
	
		}
	}
		
}




/*录入先进项目信息*/
function entryAdvanceInfo(numsOfRow) {
	var mainTr = document.getElementById("allbasicMsg");
		var editDiv = document.getElementById("editMsg");
		//change(mainTr,editDiv);
		mainTr.style.display = "none";
		editDiv.style.display = "block";
		//取得表对象
		var tableObj = document.getElementById("entryAdvanceInfo");
		var trLength = $("#entryAdvanceInfo tr").length;
		var differ = trLength-3;
		if(differ >= numsOfRow) {
			var i,j;
			j=differ-numsOfRow;
			for(i=0;i<j;i++)
				tableObj.deleteRow(trLength-2-i);
					
		}
		else {

		for(var i=0;i<numsOfRow-differ;i++) {
			var oTeacherTri = tableObj.insertRow(trLength-1);
			oTeacherTri.setAttribute("align", "center");
			if((i%2) === 0){
				oTeacherTri.setAttribute("bgcolor", "#FFFFFF");
			}else {
				oTeacherTri.setAttribute("bgcolor", "#EEEEEE");
			}
			/*第一列*/
			oTeacherTri.insertCell(0);
			var oTeacherTriTd1 = oTeacherTri.cells[0];
			oTeacherTriTd1.setAttribute("width", "10%");
			var tec_No = document.createElement('input');
			tec_No.type = "text";
			tec_No.size = "5";
			oTeacherTriTd1.appendChild(tec_No);

			/*第二列*/
			oTeacherTri.insertCell(1);
			var oTeacherTriTd2 = oTeacherTri.cells[1];
			oTeacherTriTd2.setAttribute("width", "7%");
			var tec_Name = document.createElement('input');
			tec_Name.type = "text";
			tec_Name.size = "5";
			oTeacherTriTd2.appendChild(tec_Name);

			/*第三列*/
			oTeacherTri.insertCell(2);
			var oTeacherTriTd3 = oTeacherTri.cells[2];
			oTeacherTriTd3.setAttribute("width", "7%");
			var tec_Sex = document.createElement('select');
			var man = document.createElement("option");
			man.appendChild(document.createTextNode("男"));
			var woman = document.createElement("option");
			woman.appendChild(document.createTextNode("女"));
			tec_Sex.appendChild(man);
			tec_Sex.appendChild(woman);
			oTeacherTriTd3.appendChild(tec_Sex);

			/*第四列*/
			oTeacherTri.insertCell(3);
			var oTeacherTriTd4 = oTeacherTri.cells[3];
			oTeacherTriTd4.setAttribute("width", "7%");
			var tec_College = document.createElement('select');
			var software = document.createElement("option");
			software.appendChild(document.createTextNode("软件学院"));
			var finance = document.createElement("option");
			finance.appendChild(document.createTextNode("经贸学院"));
			tec_College.appendChild(software);
			tec_College.appendChild(finance);
			oTeacherTriTd4.appendChild(tec_College);

			/*第五列*/
			oTeacherTri.insertCell(4);
			var oTeacherTriTd5 = oTeacherTri.cells[4];
			oTeacherTriTd5.setAttribute("width", "7%");
			var tec_Major = document.createElement('select');
			var soft_design = document.createElement("option");
			soft_design.appendChild(document.createTextNode("软件开发"));
			var fin_internation = document.createElement("option");
			fin_internation.appendChild(document.createTextNode("国际贸易"));
			tec_Major.appendChild(soft_design);
			tec_Major.appendChild(fin_internation);
			oTeacherTriTd5.appendChild(tec_Major);

			/*第六列*/
			oTeacherTri.insertCell(5);
			var oTeacherTriTd6 = oTeacherTri.cells[5];
			oTeacherTriTd6.setAttribute("width", "7%");
			var tec_class = document.createElement('select');
			var class1 = document.createElement("option");
			class1.appendChild(document.createTextNode("1101"));
			var class2 = document.createElement("option");
			class2.appendChild(document.createTextNode("1102"));
			tec_class.appendChild(class1);
			tec_class.appendChild(class2);
			oTeacherTriTd6.appendChild(tec_class);

			/*第七列*/
			oTeacherTri.insertCell(6);
			var oTeacherTriTd7 = oTeacherTri.cells[6];
			oTeacherTriTd7.setAttribute("width", "7%");
			var adv_type = document.createElement('select');
			var type1 = document.createElement("option");
			type1.appendChild(document.createTextNode("优秀三好学生"));
			var type2 = document.createElement("option");
			type2.appendChild(document.createTextNode("优秀学生干部"));
			var type3 = document.createElement("option");
			type3.appendChild(document.createTextNode("最佳三好学生"));
			var type4 = document.createElement("option");
			type4.appendChild(document.createTextNode("最佳学生干部"));
			var type5 = document.createElement("option");
			type5.appendChild(document.createTextNode("优秀团员"));
			var type6 = document.createElement("option");
			type6.appendChild(document.createTextNode("优秀团干部"));

			adv_type.appendChild(type1);
			adv_type.appendChild(type2);
			adv_type.appendChild(type3);
			adv_type.appendChild(type4);
			adv_type.appendChild(type5);
			adv_type.appendChild(type6);

			oTeacherTriTd7.appendChild(adv_type);

			/*第八列*/
			oTeacherTri.insertCell(7);
			var oTeacherTriTd8 = oTeacherTri.cells[7];
			oTeacherTriTd8.setAttribute("width", "10%");
			var tec_Position = document.createElement('input');
			tec_Position.type = "text";
			tec_Position.size = "5";
			oTeacherTriTd8.appendChild(tec_Position);

			/*第九列*/
			oTeacherTri.insertCell(8);
			var oTeacherTriTd9 = oTeacherTri.cells[8];
			oTeacherTriTd9.setAttribute("width", "10%");
			var adv_level= document.createElement('select');
			var level1 = document.createElement("option");
			level1.appendChild(document.createTextNode("院级"));
			var level2 = document.createElement("option");
			level2.appendChild(document.createTextNode("校级"));
			var level3 = document.createElement("option");
			level3.appendChild(document.createTextNode("厅级"));
			var level4 = document.createElement("option");
			level4.appendChild(document.createTextNode("省级"));
			var level5 = document.createElement("option");
			level5.appendChild(document.createTextNode("国家级"));
			
			adv_level.appendChild(level1);
			adv_level.appendChild(level2);
			adv_level.appendChild(level3);
			adv_level.appendChild(level4);
			adv_level.appendChild(level5);

			oTeacherTriTd9.appendChild(adv_level);
		}
	}
		
}




/*录入贫困生建档信息*/
function entryJiandangInfo(numsOfRow) {
	var mainTr = document.getElementById("allbasicMsg");
		var editDiv = document.getElementById("editMsg");
		//change(mainTr,editDiv);
		mainTr.style.display = "none";
		editDiv.style.display = "block";
		//取得表对象
		var tableObj = document.getElementById("entryJiandangInfo");
		var trLength = $("#entryJiandangInfo tr").length;
		var differ = trLength-3;
		if(differ >= numsOfRow) {
			var i,j;
			j=differ-numsOfRow;
			for(i=0;i<j;i++)
				tableObj.deleteRow(trLength-2-i);
					
		}
		else {

		for(var i=0;i<numsOfRow-differ;i++) {
			var oTeacherTri = tableObj.insertRow(trLength-1);
			oTeacherTri.setAttribute("align", "center");
			if((i%2) === 0){
				oTeacherTri.setAttribute("bgcolor", "#FFFFFF");
			}else {
				oTeacherTri.setAttribute("bgcolor", "#EEEEEE");
			}
			/*第一列*/
			oTeacherTri.insertCell(0);
			var oTeacherTriTd1 = oTeacherTri.cells[0];
			oTeacherTriTd1.setAttribute("width", "10%");
			var tec_No = document.createElement('input');
			tec_No.type = "text";
			tec_No.size = "5";
			oTeacherTriTd1.appendChild(tec_No);

			/*第二列*/
			oTeacherTri.insertCell(1);
			var oTeacherTriTd2 = oTeacherTri.cells[1];
			oTeacherTriTd2.setAttribute("width", "7%");
			var tec_Name = document.createElement('input');
			tec_Name.type = "text";
			tec_Name.size = "5";
			oTeacherTriTd2.appendChild(tec_Name);

			/*第三列*/
			oTeacherTri.insertCell(2);
			var oTeacherTriTd3 = oTeacherTri.cells[2];
			oTeacherTriTd3.setAttribute("width", "7%");
			var tec_Sex = document.createElement('select');
			var man = document.createElement("option");
			man.appendChild(document.createTextNode("男"));
			var woman = document.createElement("option");
			woman.appendChild(document.createTextNode("女"));
			tec_Sex.appendChild(man);
			tec_Sex.appendChild(woman);
			oTeacherTriTd3.appendChild(tec_Sex);


			/*第四列*/
			oTeacherTri.insertCell(3);
			var oTeacherTriTd4 = oTeacherTri.cells[3];
			oTeacherTriTd4.setAttribute("width", "7%");
			var tec_College = document.createElement('select');
			var software = document.createElement("option");
			software.appendChild(document.createTextNode("软件学院"));
			var finance = document.createElement("option");
			finance.appendChild(document.createTextNode("经贸学院"));
			tec_College.appendChild(software);
			tec_College.appendChild(finance);
			oTeacherTriTd4.appendChild(tec_College);

			/*第五列*/
			oTeacherTri.insertCell(4);
			var oTeacherTriTd5 = oTeacherTri.cells[4];
			oTeacherTriTd5.setAttribute("width", "7%");
			var tec_Major = document.createElement('select');
			var soft_design = document.createElement("option");
			soft_design.appendChild(document.createTextNode("软件开发"));
			var fin_internation = document.createElement("option");
			fin_internation.appendChild(document.createTextNode("国际贸易"));
			tec_Major.appendChild(soft_design);
			tec_Major.appendChild(fin_internation);
			oTeacherTriTd5.appendChild(tec_Major);

			/*第六列*/
			oTeacherTri.insertCell(5);
			var oTeacherTriTd6 = oTeacherTri.cells[5];
			oTeacherTriTd6.setAttribute("width", "7%");
			var tec_class = document.createElement('select');
			var class1 = document.createElement("option");
			class1.appendChild(document.createTextNode("1101"));
			var class2 = document.createElement("option");
			class2.appendChild(document.createTextNode("1102"));
			tec_class.appendChild(class1);
			tec_class.appendChild(class2);
			oTeacherTriTd6.appendChild(tec_class);


			/*第七列*/
			oTeacherTri.insertCell(6);
			var oTeacherTriTd7 = oTeacherTri.cells[6];
			oTeacherTriTd7.setAttribute("width", "7%");
			var address = document.createElement('input');
			address.type = "text";
			address.size = "5";
			oTeacherTriTd7.appendChild(address);

			/*第八列*/
			oTeacherTri.insertCell(7);
			var oTeacherTriTd8 = oTeacherTri.cells[7];
			oTeacherTriTd8.setAttribute("width", "7%");
			var fina = document.createElement('input');
			fina.type = "text";
			fina.size = "5";
			oTeacherTriTd8.appendChild(fina);
			/*第九列*/
			oTeacherTri.insertCell(8);
			var oTeacherTriTd9 = oTeacherTri.cells[8];
			oTeacherTriTd9.setAttribute("width", "10%");
			var pastPovLevel = document.createElement('select');
			var level1 = document.createElement("option");
			level1.appendChild(document.createTextNode("甲等"));
			var level2 = document.createElement("option");
			level2.appendChild(document.createTextNode("乙等"));
			var level3 = document.createElement("option");
			level3.appendChild(document.createTextNode("丙等"));

			pastPovLevel.appendChild(level1);
			pastPovLevel.appendChild(level2);
			pastPovLevel.appendChild(level3);
			
			oTeacherTriTd9.appendChild(pastPovLevel);

			/*第十列*/
			oTeacherTri.insertCell(9);
			var oTeacherTriTd10 = oTeacherTri.cells[9];
			oTeacherTriTd10.setAttribute("width", "10%");
			var term = document.createElement('select');
			var term1 = document.createElement("option");
			term1.appendChild(document.createTextNode("201101"));
			var term2 = document.createElement("option");
			term2.appendChild(document.createTextNode("201102"));
			var term3 = document.createElement("option");
			term3.appendChild(document.createTextNode("201201"));

			term.appendChild(term1);
			term.appendChild(term2);
			term.appendChild(term3);
			
			oTeacherTriTd10.appendChild(term);
		}
	}
		
}


/*录入奖学金信息*/
function entryScholarshipAssessInfo(numsOfRow) {
	var mainTr = document.getElementById("allbasicMsg");
		var editDiv = document.getElementById("editMsg");
		//change(mainTr,editDiv);
		mainTr.style.display = "none";
		editDiv.style.display = "block";
		//取得表对象
		var tableObj = document.getElementById("entryScholarshipAssessInfo");
		var trLength = $("#entryScholarshipAssessInfo tr").length;
		var differ = trLength-5;
		if(differ >= numsOfRow) {
			var i,j;
			j=differ-numsOfRow;
			for(i=0;i<j;i++)
				tableObj.deleteRow(trLength-2-i);
					
		}
		else {

		for(var i=0;i<numsOfRow-differ;i++) {
			var oTeacherTri = tableObj.insertRow(trLength-1);
			oTeacherTri.setAttribute("align", "center");
			if((i%2) === 0){
				oTeacherTri.setAttribute("bgcolor", "#FFFFFF");
			}else {
				oTeacherTri.setAttribute("bgcolor", "#EEEEEE");
			}
			/*第一列*/
			oTeacherTri.insertCell(0);
			var oTeacherTriTd1 = oTeacherTri.cells[0];
			var tec_No = document.createElement('input');
			tec_No.type = "text";
			tec_No.size = "5";
			oTeacherTriTd1.appendChild(tec_No);

			/*第二列*/
			oTeacherTri.insertCell(1);
			var oTeacherTriTd2 = oTeacherTri.cells[1];
			var tec_Name = document.createElement('input');
			tec_Name.type = "text";
			tec_Name.size = "5";
			oTeacherTriTd2.appendChild(tec_Name);

			/*第三列*/
			oTeacherTri.insertCell(2);
			var oTeacherTriTd3 = oTeacherTri.cells[2];
			var basic = document.createElement('input');
			basic.type = "text";
			basic.size = "5";
			oTeacherTriTd3.appendChild(basic);

			/*第四列*/
			oTeacherTri.insertCell(3);
			var oTeacherTriTd4 = oTeacherTri.cells[3];
			var award = document.createElement('input');
			awardtype = "text";
			award.size = "5";
			oTeacherTriTd4.appendChild(award);

			/*第五列*/
			oTeacherTri.insertCell(4);
			var oTeacherTriTd5 = oTeacherTri.cells[4];
			var punish = document.createElement('input');
			punish.type = "text";
			punish.size = "5";
			oTeacherTriTd5.appendChild(punish);

			/*第六列*/
			oTeacherTri.insertCell(5);
			var oTeacherTriTd6 = oTeacherTri.cells[5];
			var tot1 = document.createElement('input');
			tot1.type = "text";
			tot1.size = "5";
			oTeacherTriTd6.appendChild(tot1);

			/*第七列*/
			oTeacherTri.insertCell(6);
			var oTeacherTriTd7 = oTeacherTri.cells[6];
			var compulsary = document.createElement('input');
			compulsary.type = "text";
			compulsary.size = "5";
			oTeacherTriTd7.appendChild(compulsary);
			
			/*第八列*/
			oTeacherTri.insertCell(7);
			var oTeacherTriTd8 = oTeacherTri.cells[7];
			var common = document.createElement('input');
			common.type = "text";
			common.size = "5";
			oTeacherTriTd8.appendChild(common);
			/*第九列*/
			oTeacherTri.insertCell(8);
			var oTeacherTriTd9 = oTeacherTri.cells[8];
			var technology = document.createElement('input');
			technology.type = "text";
			technology.size = "5";
			oTeacherTriTd9.appendChild(technology);

			/*第十列*/
			oTeacherTri.insertCell(9);
			var oTeacherTriTd10 = oTeacherTri.cells[9];
			var occuption = document.createElement('input');
			occuption.type = "text";
			occuption.size = "5";
			oTeacherTriTd10.appendChild(occuption);

			/*第十一列*/
			oTeacherTri.insertCell(10);
			var oTeacherTriTd11 = oTeacherTri.cells[10];
			var tot2 = document.createElement('input');
			tot2.type = "text";
			tot2.size = "5";
			oTeacherTriTd11.appendChild(tot2);

			/*第十二列*/
			oTeacherTri.insertCell(11);
			var oTeacherTriTd12 = oTeacherTri.cells[11];
			var PE1 = document.createElement('input');
			PE1.type = "text";
			PE1.size = "5";
			oTeacherTriTd12.appendChild(PE1);
			/*第十三列*/
			oTeacherTri.insertCell(12);
			var oTeacherTriTd13 = oTeacherTri.cells[12];
			var PE2 = document.createElement('input');
			PE2.type = "text";
			PE2.size = "5";
			oTeacherTriTd13.appendChild(PE2);
			/*第十四列*/
			oTeacherTri.insertCell(13);
			var oTeacherTriTd14 = oTeacherTri.cells[13];
			var PE3 = document.createElement('input');
			PE3.type = "text";
			PE3.size = "5";
			oTeacherTriTd14.appendChild(PE3);
			/*第十五列*/
			oTeacherTri.insertCell(14);
			var oTeacherTriTd15 = oTeacherTri.cells[14];
			var tot3 = document.createElement('input');
			tot3.type = "text";
			tot3.size = "5";
			oTeacherTriTd15.appendChild(tot3);
				
			/*第十六列*/
			oTeacherTri.insertCell(15);
			var oTeacherTriTd16 = oTeacherTri.cells[15];
			var morManager = document.createElement('input');
			morManager.type = "text";
			morManager.size = "5";
			oTeacherTriTd16.appendChild(morManager);

			/*第十七列*/
			oTeacherTri.insertCell(16);
			var oTeacherTriTd17 = oTeacherTri.cells[16];
			var morCulture = document.createElement('input');
			morCulture.type = "text";
			morCulture.size = "5";
			oTeacherTriTd17.appendChild(morCulture);

			/*第十八列*/
			oTeacherTri.insertCell(17);
			var oTeacherTriTd18 = oTeacherTri.cells[17];
			var morArt = document.createElement('input');
			morArt.type = "text";
			morArt.size = "5";
			oTeacherTriTd18.appendChild(morArt);
			/*第十九列*/
			oTeacherTri.insertCell(18);
			var oTeacherTriTd19 = oTeacherTri.cells[18];
			var morService = document.createElement('input');
			morService.type = "text";
			morService.size = "5";
			oTeacherTriTd19.appendChild(morService);
			/*第二十列*/
			oTeacherTri.insertCell(19);
			var oTeacherTriTd20 = oTeacherTri.cells[19];
			var total = document.createElement('input');
			total.type = "text";
			total.size = "5";
			oTeacherTriTd20.appendChild(total);
			/*第二十一列*/
			oTeacherTri.insertCell(20);
			var oTeacherTriTd21 = oTeacherTri.cells[20];
			var rank = document.createElement('input');
			rank.type = "text";
			rank.size = "5";
			oTeacherTriTd21.appendChild(rank);
			/*第二十二列*/
			oTeacherTri.insertCell(21);
			var oTeacherTriTd20 = oTeacherTri.cells[21];
			var preClassLevel = document.createElement('select');
			var nLevel1 = document.createElement("option");
			nLevel1.appendChild(document.createTextNode("一等"));
			var nLevel2 = document.createElement("option");
			nLevel2.appendChild(document.createTextNode("二等"));
			var nLevel3 = document.createElement("option");
			nLevel3.appendChild(document.createTextNode("三等"));

			preClassLevel.appendChild(nLevel1);
			preClassLevel.appendChild(nLevel2);
			preClassLevel.appendChild(nLevel3);
			
			oTeacherTriTd20.appendChild(preClassLevel);
		}
	}
		
}




/*录入奖助学金信息*/
function entrySholarshipInfo(numsOfRow) {
	var mainTr = document.getElementById("allbasicMsg");
		var editDiv = document.getElementById("editMsg");
		//change(mainTr,editDiv);
		mainTr.style.display = "none";
		editDiv.style.display = "block";
		//取得表对象
		var tableObj = document.getElementById("entrySholarshipInfo");
		var trLength = $("#entrySholarshipInfo tr").length;
		var differ = trLength-4;
		if(differ >= numsOfRow) {
			var i,j;
			j=differ-numsOfRow;
			for(i=0;i<j;i++)
				tableObj.deleteRow(trLength-2-i);
					
		}
		else {

		for(var i=0;i<numsOfRow-differ;i++) {
			var oTeacherTri = tableObj.insertRow(trLength-1);
			oTeacherTri.setAttribute("align", "center");
			if((i%2) === 0){
				oTeacherTri.setAttribute("bgcolor", "#FFFFFF");
			}else {
				oTeacherTri.setAttribute("bgcolor", "#EEEEEE");
			}
				/*第一列*/
			oTeacherTri.insertCell(0);
			var oTeacherTriTd1 = oTeacherTri.cells[0];
			oTeacherTriTd1.setAttribute("width", "10%");
			var tec_No = document.createElement('input');
			tec_No.type = "text";
			tec_No.size = "5";
			oTeacherTriTd1.appendChild(tec_No);

			/*第二列*/
			oTeacherTri.insertCell(1);
			var oTeacherTriTd2 = oTeacherTri.cells[1];
			oTeacherTriTd2.setAttribute("width", "7%");
			var tec_Name = document.createElement('input');
			tec_Name.type = "text";
			tec_Name.size = "5";
			oTeacherTriTd2.appendChild(tec_Name);

			/*第三列*/
			oTeacherTri.insertCell(2);
			var oTeacherTriTd3 = oTeacherTri.cells[2];
			oTeacherTriTd3.setAttribute("width", "7%");
			var tec_Sex = document.createElement('select');
			var man = document.createElement("option");
			man.appendChild(document.createTextNode("男"));
			var woman = document.createElement("option");
			woman.appendChild(document.createTextNode("女"));
			tec_Sex.appendChild(man);
			tec_Sex.appendChild(woman);
			oTeacherTriTd3.appendChild(tec_Sex);


			/*第四列*/
			oTeacherTri.insertCell(3);
			var oTeacherTriTd4 = oTeacherTri.cells[3];
			oTeacherTriTd4.setAttribute("width", "7%");
			var tec_College = document.createElement('select');
			var software = document.createElement("option");
			software.appendChild(document.createTextNode("软件学院"));
			var finance = document.createElement("option");
			finance.appendChild(document.createTextNode("经贸学院"));
			tec_College.appendChild(software);
			tec_College.appendChild(finance);
			oTeacherTriTd4.appendChild(tec_College);

			/*第五列*/
			oTeacherTri.insertCell(4);
			var oTeacherTriTd5 = oTeacherTri.cells[4];
			oTeacherTriTd5.setAttribute("width", "7%");
			var tec_Major = document.createElement('select');
			var soft_design = document.createElement("option");
			soft_design.appendChild(document.createTextNode("软件开发"));
			var fin_internation = document.createElement("option");
			fin_internation.appendChild(document.createTextNode("国际贸易"));
			tec_Major.appendChild(soft_design);
			tec_Major.appendChild(fin_internation);
			oTeacherTriTd5.appendChild(tec_Major);

			/*第六列*/
			oTeacherTri.insertCell(5);
			var oTeacherTriTd6 = oTeacherTri.cells[5];
			oTeacherTriTd6.setAttribute("width", "7%");
			var tec_class = document.createElement('select');
			var class1 = document.createElement("option");
			class1.appendChild(document.createTextNode("1101"));
			var class2 = document.createElement("option");
			class2.appendChild(document.createTextNode("1102"));
			tec_class.appendChild(class1);
			tec_class.appendChild(class2);
			oTeacherTriTd6.appendChild(tec_class);


			/*第七列*/
			oTeacherTri.insertCell(6);
			var oTeacherTriTd7 = oTeacherTri.cells[6];
			oTeacherTriTd7.setAttribute("width", "7%");
			var pastClassLevel = document.createElement('select');
			var pLevel1 = document.createElement("option");
			pLevel1.appendChild(document.createTextNode("一等"));
			var pLevel2 = document.createElement("option");
			pLevel2.appendChild(document.createTextNode("二等"));
			var pLevel3 = document.createElement("option");
			pLevel3.appendChild(document.createTextNode("三等"));

			pastClassLevel.appendChild(pLevel1);
			pastClassLevel.appendChild(pLevel2);
			pastClassLevel.appendChild(pLevel3);

			oTeacherTriTd7.appendChild(pastClassLevel);

			/*第八列*/
			oTeacherTri.insertCell(7);
			var oTeacherTriTd8 = oTeacherTri.cells[7];
			oTeacherTriTd8.setAttribute("width", "7%");
			var preClassLevel = document.createElement('select');
			var nLevel1 = document.createElement("option");
			nLevel1.appendChild(document.createTextNode("一等"));
			var nLevel2 = document.createElement("option");
			nLevel2.appendChild(document.createTextNode("二等"));
			var nLevel3 = document.createElement("option");
			nLevel3.appendChild(document.createTextNode("三等"));

			preClassLevel.appendChild(nLevel1);
			preClassLevel.appendChild(nLevel2);
			preClassLevel.appendChild(nLevel3);
			
			oTeacherTriTd8.appendChild(preClassLevel);



			/*第九列*/
			oTeacherTri.insertCell(8);
			var oTeacherTriTd9 = oTeacherTri.cells[8];
			oTeacherTriTd9.setAttribute("width", "7%");
			var pastSchName = document.createElement('select');
			var name1 = document.createElement("option");
			name1.appendChild(document.createTextNode("国家奖学金"));
			var name2 = document.createElement("option");
			name2.appendChild(document.createTextNode("国家励志"));
			var name3 = document.createElement("option");
			name3.appendChild(document.createTextNode("国家助学金"));
			var name4 = document.createElement("option");
			name4.appendChild(document.createTextNode("校奖学金"));
			var name5 = document.createElement("option");
			name5.appendChild(document.createTextNode("企业"));
			var name6 = document.createElement("option");
			name6.appendChild(document.createTextNode("个人资助"));

			pastSchName.appendChild(name1);
			pastSchName.appendChild(name2);
			pastSchName.appendChild(name3);
			pastSchName.appendChild(name4);
			pastSchName.appendChild(name5);
			pastSchName.appendChild(name6);
			
			oTeacherTriTd9.appendChild(pastSchName);

			/*第十列*/
			oTeacherTri.insertCell(9);
			var oTeacherTriTd10 = oTeacherTri.cells[9];
			oTeacherTriTd10.setAttribute("width", "10%");
			var pastPovLevel = document.createElement('select');
			var level1 = document.createElement("option");
			level1.appendChild(document.createTextNode("甲等"));
			var level2 = document.createElement("option");
			level2.appendChild(document.createTextNode("乙等"));
			var level3 = document.createElement("option");
			level3.appendChild(document.createTextNode("丙等"));

			pastPovLevel.appendChild(level1);
			pastPovLevel.appendChild(level2);
			pastPovLevel.appendChild(level3);
			
			oTeacherTriTd10.appendChild(pastPovLevel);

			/*第十一列*/
			oTeacherTri.insertCell(10);
			var oTeacherTriTd11 = oTeacherTri.cells[10];
			oTeacherTriTd11.setAttribute("width", "10%");

			var prePovLevel = document.createElement('select');
			var level1 = document.createElement("option");
			level1.appendChild(document.createTextNode("甲等"));
			var level2 = document.createElement("option");
			level2.appendChild(document.createTextNode("乙等"));
			var level3 = document.createElement("option");
			level3.appendChild(document.createTextNode("丙等"));

			prePovLevel.appendChild(level1);
			prePovLevel.appendChild(level2);
			prePovLevel.appendChild(level3);
			
			oTeacherTriTd11.appendChild(prePovLevel);

			/*第十二列*/
			oTeacherTri.insertCell(11);
			var oTeacherTriTd12 = oTeacherTri.cells[11];
			oTeacherTriTd12.setAttribute("width", "10%");
			var preSchName = document.createElement('select');
			var name1 = document.createElement("option");
			name1.appendChild(document.createTextNode("国家奖学金"));
			var name2 = document.createElement("option");
			name2.appendChild(document.createTextNode("国家励志"));
			var name3 = document.createElement("option");
			name3.appendChild(document.createTextNode("国家助学金"));
			var name4 = document.createElement("option");
			name4.appendChild(document.createTextNode("校奖学金"));
			var name5 = document.createElement("option");
			name5.appendChild(document.createTextNode("企业"));
			var name6 = document.createElement("option");
			name6.appendChild(document.createTextNode("个人资助"));

			preSchName.appendChild(name1);
			preSchName.appendChild(name2);
			preSchName.appendChild(name3);
			preSchName.appendChild(name4);
			preSchName.appendChild(name5);
			preSchName.appendChild(name6);
			
			oTeacherTriTd12.appendChild(preSchName);

			/*第十三列*/
			oTeacherTri.insertCell(12);
			var oTeacherTriTd13 = oTeacherTri.cells[12];
			oTeacherTriTd13.setAttribute("width", "7%");
			var scholarProperty = document.createElement('select');
			var property1 = document.createElement("option");
			property1.appendChild(document.createTextNode("国家"));
			var property2 = document.createElement("option");
			property2.appendChild(document.createTextNode("学校"));
			var property3 = document.createElement("option");
			property3.appendChild(document.createTextNode("企业资助"));
			var property4 = document.createElement("option");
			property4.appendChild(document.createTextNode("个人资助"));

			scholarProperty.appendChild(property1);
			scholarProperty.appendChild(property2);
			scholarProperty.appendChild(property3);
			scholarProperty.appendChild(property4);
			
			oTeacherTriTd13.appendChild(scholarProperty);
			/*第十四列*/
			oTeacherTri.insertCell(13);
			var oTeacherTriTd14 = oTeacherTri.cells[13];
			oTeacherTriTd14.setAttribute("width", "7%");
			var tec_time = document.createElement('input');
			tec_time.type = "text";
			tec_time.size = "5";
			oTeacherTriTd14.appendChild(tec_time);
			/*第十五列*/
			oTeacherTri.insertCell(14);
			var oTeacherTriTd15 = oTeacherTri.cells[14];
			oTeacherTriTd15.setAttribute("width", "7%");
			var tec_fare = document.createElement('input');
			tec_fare.type = "text";
			tec_fare.size = "5";
			oTeacherTriTd15.appendChild(tec_fare);
		}
	}
		
}


