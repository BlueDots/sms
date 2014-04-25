//得到学生基本信息列表
var stuBasicInfoObj;
var g_college=null;
var g_major=null;
var g_className=null;
var g_stuNoOrName=null;


function getStuBasicInfoList(currentPage){
	var url="?currentPage="+currentPage;
	
	if(g_college!=null)
		url+="&college="+g_college;
	if(g_major!=null)
		url+="&major="+g_major;
	if(g_className!=null)
		url+="&className="+g_className;
	if(g_stuNoOrName!=null)
		url+="&stuNoOrName="+g_stuNoOrName;
	//alert(url);
	
	$.getJSON("StuBasicInfoJSON/StuBasicInfoActionJSON!queryStuBasicInfoLists"+url,function(data){
		//得到StubasicInfoList
		var stuBaisicInfoLists = data.stuBasicInfoVOlists;
		//得到显示的table对象
		var showTableObj = document.getElementById("tableOfShowStuBasicInfoLists");
		//得到表的行数
		var trLength=$("#tableOfShowStuBasicInfoLists tr").length;
		//得到数据个数
		var dataCounts = stuBaisicInfoLists.length;
		//alert(trLength);
		//若trLength>1,清空行号1之后的tr
		if(trLength>1) {
			for(var i=trLength-1;i>0;i--) {
				showTableObj.deleteRow(i);
				trLength--;
			}	
		}
		
		//alert(trLength);
		
		stuBasicInfoObj = stuBaisicInfoLists;
		for(var i=0;i<dataCounts;i++) {
			var stuBasicInfo = stuBaisicInfoLists[i].stuBasicInfo;
			var TrObj = showTableObj.insertRow(trLength+i);
			if(i%2==0)
				TrObj.setAttribute("bgcolor","#FFFFFF");
			else TrObj.setAttribute("bgcolor","#EEEEEE");
			TrObj.setAttribute("align","center");

			//第一列
			var TdObj1 = TrObj.insertCell(0);
			var checkBox = document.createElement("input");
			checkBox.type="checkbox";
			checkBox.id=stuBasicInfo.studentNo;
			TdObj1.appendChild(checkBox);
			//第二列：照片
			var TdObj2 = TrObj.insertCell(1);		
			
			//第三列：学号
			var TdObj3 = TrObj.insertCell(2);
			
			var a =  document.createElement("a");
			a.id=i;
			//添加点击事件，显示详细信息
			a.onclick=function() {
				var value=$(this).attr("id");
				stuBasicInfoDetail(stuBasicInfoObj[value].stuBasicInfo);
				popup('#stuBasicInfoDiv', '#StuBasicInfoDiv', '#btnCloseStuBasicInfoDiv');
			};
			a.appendChild(document.createTextNode(stuBasicInfo.studentNo!=null?stuBasicInfo.studentNo:""));
			TdObj3.appendChild(a);
			
			
			//第四列：姓名
			var TdObj4 = TrObj.insertCell(3);
			TdObj4.appendChild(document.createTextNode(stuBasicInfo.studentName!=null?stuBasicInfo.studentName:""));
			
			//第五列：学院
			var TdObj5 = TrObj.insertCell(4);
			TdObj5.appendChild(document.createTextNode(stuBasicInfo.college!=null?stuBasicInfo.college:""));
			
			//第六列：专业
			var TdObj6 = TrObj.insertCell(5);
			TdObj6.appendChild(document.createTextNode(stuBasicInfo.major!=null?stuBasicInfo.major:""));

			//第七列：班级
			var TdObj7 = TrObj.insertCell(6);
			TdObj7.appendChild(document.createTextNode(stuBasicInfo.className!=null?stuBasicInfo.className:""));

			//第八列：性别
			var TdObj8 = TrObj.insertCell(7);
			if(stuBasicInfo.sex==0)
				TdObj8.appendChild(document.createTextNode("男"));
			else TdObj8.appendChild(document.createTextNode("女"));

			//第九列：民族
			var TdObj9 = TrObj.insertCell(8);
			TdObj9.appendChild(document.createTextNode(stuBasicInfo.nation!=null?stuBasicInfo.nation:""));

			//第十列：籍贯
			var TdObj10 = TrObj.insertCell(9);
			TdObj10.appendChild(document.createTextNode(stuBasicInfo.hometown!=null?stuBasicInfo.hometown:""));

			//第十一列：政治面貌
			var TdObj11 = TrObj.insertCell(10);
			TdObj11.appendChild(document.createTextNode(stuBasicInfo.political!=null?stuBasicInfo.political:""));

			//第十二列：身份证号码
			var TdObj12 = TrObj.insertCell(11);
			TdObj12.appendChild(document.createTextNode(stuBasicInfo.idCard!=null?stuBasicInfo.idCard:""));

			//第十三列：学历
			var TdObj13 = TrObj.insertCell(12);
			TdObj13.appendChild(document.createTextNode(stuBasicInfo.eduBackground!=null?stuBasicInfo.eduBackground:""));

			//第十四列：英语等级
			var TdObj14 = TrObj.insertCell(13);
			TdObj14.appendChild(document.createTextNode(stuBasicInfo.englishlevel!=null?stuBasicInfo.englishlevel:""));

			//第十五列：银行卡号
			var TdObj15 = TrObj.insertCell(14);
			TdObj15.appendChild(document.createTextNode(stuBasicInfo.bankCard!=null?stuBasicInfo.bankCard:""));	
			
			//十六列：审核状态
			var TdObj16 = TrObj.insertCell(15);
			TdObj16.appendChild(document.createTextNode(stuBasicInfo.exameState!=null?stuBasicInfo.exameState:""));	
			
			//十七列:备注
			var TdObj17 = TrObj.insertCell(16);
			TdObj17.appendChild(document.createTextNode(stuBasicInfo.remarks!=null?stuBasicInfo.remarks:""));		
		}
		
		//分页
		//首页
		var firstPage = document.getElementById("firstPage");
		//添加点击事件
		firstPage.onclick=function() {
			getStuBasicInfoList(currentPage);
		};
		//总页数
		var pageNums = document.getElementById("pageNums"); 
		pageNums.innerText=data.pageVo.pageNum;
		
		//当前页
		var currentPage = document.getElementById("currentPage");
		currentPage.innerText=data.pageVo.currentPage;
		
		//上一页
		var previousPage = document.getElementById("previousPage");
		//添加点击事件
		previousPage.onclick=function() {
			var currentPage=data.pageVo.currentPage;
			if(currentPage>1)
				getStuBasicInfoList(currentPage-1);
		};
		//下一页
		var nextPage = document.getElementById("nextPage");
		//添加点击事件
		nextPage.onclick=function() {
			var currentPage=data.pageVo.currentPage;
			if(currentPage<data.pageVo.pageNum)
				getStuBasicInfoList(currentPage+1);
		};
		
		//最后一页
		var lastPage = document.getElementById("lastPage");
		//添加点击事件
		lastPage.onclick=function() {
			var currentPage=data.pageVo.currentPage;
			if(currentPage!=data.pageVo.pageNum)
				getStuBasicInfoList(data.pageVo.pageNum);
		};
		
		//跳转
		var gotoPage = document.getElementById("gotoPage");
		var go = document.getElementById("go");
		//添加点击事件
		go.onclick=function() {
			var currentPage=data.pageVo.currentPage;
			var page = gotoPage.value;
			if(!isNaN(page) && page!=currentPage && page >=1 && page <= data.pageVo.pageNum) 
				getStuBasicInfoList(page);
		};			
	});
}

//详细信息
function stuBasicInfoDetail(stuBasicInfo) {
	//学号
	var studentNo = stuBasicInfo.studentNo;
	document.getElementById("studentNo").value=(studentNo!=null?studentNo:"");
	//姓名
	var studentName = stuBasicInfo.studentName;
	document.getElementById("studentName").value=(studentName!=null?studentName:"");
	//性别
	var sex = stuBasicInfo.sex;
	document.getElementById("sex").value=(sex!=0?"女":"男");
	//学院
	var college = stuBasicInfo.college;
	document.getElementById("college").value=(college!=null?college:"");
	//专业
	var major = stuBasicInfo.major;
	document.getElementById("major_detail").value=(major!=null?major:"");
	//班级
	var className = stuBasicInfo.className;
	document.getElementById("className_detail").value=(className!=null?className:"");
	//出生日期
	var birthday = stuBasicInfo.birthday;
	document.getElementById("birthday").value=(birthday!=null?birthday:"");
	//民族
	var nation = stuBasicInfo.nation;
	document.getElementById("nation").value=(nation!=null?nation:"");
	//籍贯
	var hometown = stuBasicInfo.hometown;
	document.getElementById("hometown").value=(hometown!=null?hometown:"");
	//政治面貌
	var political = stuBasicInfo.political;
	document.getElementById("political").value=(political!=null?political:"");
	//手机号码
	var telephone = stuBasicInfo.telephone;
	document.getElementById("telephone").value=(telephone!=null?telephone:"");
	//银行卡号
	var bankCard = stuBasicInfo.bankCard;
	document.getElementById("bankCard").value=(bankCard!=null?bankCard:"");
	//身份证号码
	var idCard = stuBasicInfo.idCard;
	document.getElementById("idCard").value=(idCard!=null?idCard:"");
	//家庭联系人
	var family = stuBasicInfo.family;
	document.getElementById("family").value=(family!=null?family:"");
	//家庭住址
	var address = stuBasicInfo.address;
	document.getElementById("address").value=(address!=null?addrss:"");
	//家庭联系电话
	var fphone = stuBasicInfo.fphone;
	document.getElementById("fphone").value=(fphone!=null?fphone:"");
	//英语等级
	var englishlevel = stuBasicInfo.englishlevel;
	document.getElementById("englishlevel").value=(englishlevel!=null?englishlevel:"");
	//个人邮箱
	var email = stuBasicInfo.email;
	document.getElementById("email").value=(email!=null?email:"");
	//学历
	var eduBackground = stuBasicInfo.eduBackground;
	document.getElementById("eduBackground").value=(eduBackground!=null?eduBackground:"");
}

function setCollegeMajorClassStuNoOrName(college,major,className,stuNoOrName) {
	g_college=college;
	g_major=major;
	g_className=className;
	g_stuNoOrName=stuNoOrName;
}

function getWaitingForNum() {
	var num;
	var spanObj = document.getElementById("verifyNum");
	$.ajaxSettings.async = false;
	$.getJSON("StuBasicInfoJSON/StuBasicInfoActionJSON!gainWaitingForNum",function(data) {
		num = data.waitingForNum;
	});
	spanObj.innerText = num;
}

function updateStuBasicInfo() {
	var checkedSelectedList = checkChooseCheck();
	if(checkedSelectedList.length == 0) {
		alert("请勾选要编辑的记录");
		return;
	}
	
	var ids = "";
	for(var i=0;i<checkedSelectedList.length;i++){
		if(checkedSelectedList[i].id != "check1")
			ids+=checkedSelectedList[i].id+",";
	}
	
	
	
	
	
}




/*检测是否选择复选框 并返回选中的checkbox*/
function checkChooseCheck(){
	   var inputs = document.getElementsByTagName("input");
	   //存放勾选的checkbox
	   var checkedSelectedList = new Array();
	   
		for(var i=0;i<inputs.length;i++){
		if(inputs.item(i).getAttribute("type") == "checkbox") {
			if(inputs.item(i).checked == true && inputs.item(i).id !="check1") {
				checkedSelectedList.push(inputs.item(i));
			}  
		}
      }
	  return  checkedSelectedList;
} 

//得到班主任待修改信息
function getTutorWatingForUpdate(teacherNo,currentPage) {
	var url="StuBasicInfoJSON/StuBasicInfoActionJSON!gainTutorWatingForUpdateNum?teacherNo="+teacherNo;
	var tutorWatingForUpdateNum;
	$.ajaxSettings.async = false;
	$.getJSON(url,function(data){
		tutorWatingForUpdateNum = data.tutorWatingForUpdateNum;
	});
	
	var waitingForUpdate = document.getElementById("waitingForUpdate");
	var waitingForUpdateNum = document.getElementById("waitingForUpdateNum");
	
	waitingForUpdateNum.innerText=tutorWatingForUpdateNum;
	
	if(tutorWatingForUpdateNum>0) {
		waitingForUpdate.onclick=function() {
			$.getJSON("StuBasicInfoJSON/StuBasicInfoActionJSON!gainTutorWatingForUpdate?currentPage="+currentPage+"&teacherNo="+teacherNo,function(data){
				//alert(data.tutorWatingForUpdateList);
				stuBaisicInfoLists = data.tutorWatingForUpdateList;
				//得到显示的table对象
				var showTableObj = document.getElementById("tableOfShowStuBasicInfoLists");
				//得到表的行数
				var trLength=$("#tableOfShowStuBasicInfoLists tr").length;
				//得到数据个数
				var dataCounts = stuBaisicInfoLists.length;
				//alert(trLength);
				//若trLength>1,清空行号1之后的tr
				if(trLength>1) {
					for(var i=trLength-1;i>0;i--) {
						showTableObj.deleteRow(i);
						trLength--;
					}	
				}
				
				//alert(trLength);
				
				stuBasicInfoObj = stuBaisicInfoLists;
				for(var i=0;i<dataCounts;i++) {
					var stuBasicInfo = stuBaisicInfoLists[i];
					var TrObj = showTableObj.insertRow(trLength+i);
					if(i%2==0)
						TrObj.setAttribute("bgcolor","#FFFFFF");
					else TrObj.setAttribute("bgcolor","#EEEEEE");
					TrObj.setAttribute("align","center");

					//第一列
					var TdObj1 = TrObj.insertCell(0);
					var checkBox = document.createElement("input");
					checkBox.type="checkbox";
					checkBox.id=stuBasicInfo.studentNo;
					TdObj1.appendChild(checkBox);
					//第二列：照片
					var TdObj2 = TrObj.insertCell(1);		
					
					//第三列：学号
					var TdObj3 = TrObj.insertCell(2);
					
					var a =  document.createElement("a");
					a.id=i;
					//添加点击事件，显示详细信息
					a.onclick=function() {
						var value=$(this).attr("id");
						stuBasicInfoDetail(stuBasicInfoObj[value].stuBasicInfo);
						popup('#stuBasicInfoDiv', '#StuBasicInfoDiv', '#btnCloseStuBasicInfoDiv');
					};
					a.appendChild(document.createTextNode(stuBasicInfo.studentNo!=null?stuBasicInfo.studentNo:""));
					TdObj3.appendChild(a);
					
					
					//第四列：姓名
					var TdObj4 = TrObj.insertCell(3);
					TdObj4.appendChild(document.createTextNode(stuBasicInfo.studentName!=null?stuBasicInfo.studentName:""));
					
					//第五列：学院
					var TdObj5 = TrObj.insertCell(4);
					TdObj5.appendChild(document.createTextNode(stuBasicInfo.college!=null?stuBasicInfo.college:""));
					
					//第六列：专业
					var TdObj6 = TrObj.insertCell(5);
					TdObj6.appendChild(document.createTextNode(stuBasicInfo.major!=null?stuBasicInfo.major:""));

					//第七列：班级
					var TdObj7 = TrObj.insertCell(6);
					TdObj7.appendChild(document.createTextNode(stuBasicInfo.className!=null?stuBasicInfo.className:""));

					//第八列：性别
					var TdObj8 = TrObj.insertCell(7);
					if(stuBasicInfo.sex==0)
						TdObj8.appendChild(document.createTextNode("男"));
					else TdObj8.appendChild(document.createTextNode("女"));

					//第九列：民族
					var TdObj9 = TrObj.insertCell(8);
					TdObj9.appendChild(document.createTextNode(stuBasicInfo.nation!=null?stuBasicInfo.nation:""));

					//第十列：籍贯
					var TdObj10 = TrObj.insertCell(9);
					TdObj10.appendChild(document.createTextNode(stuBasicInfo.hometown!=null?stuBasicInfo.hometown:""));

					//第十一列：政治面貌
					var TdObj11 = TrObj.insertCell(10);
					TdObj11.appendChild(document.createTextNode(stuBasicInfo.political!=null?stuBasicInfo.political:""));

					//第十二列：身份证号码
					var TdObj12 = TrObj.insertCell(11);
					TdObj12.appendChild(document.createTextNode(stuBasicInfo.idCard!=null?stuBasicInfo.idCard:""));

					//第十三列：学历
					var TdObj13 = TrObj.insertCell(12);
					TdObj13.appendChild(document.createTextNode(stuBasicInfo.eduBackground!=null?stuBasicInfo.eduBackground:""));

					//第十四列：英语等级
					var TdObj14 = TrObj.insertCell(13);
					TdObj14.appendChild(document.createTextNode(stuBasicInfo.englishlevel!=null?stuBasicInfo.englishlevel:""));

					//第十五列：银行卡号
					var TdObj15 = TrObj.insertCell(14);
					TdObj15.appendChild(document.createTextNode(stuBasicInfo.bankCard!=null?stuBasicInfo.bankCard:""));	
					
					//十六列：审核状态
					var TdObj16 = TrObj.insertCell(15);
					TdObj16.appendChild(document.createTextNode(stuBasicInfo.exameState!=null?stuBasicInfo.exameState:""));	
					
					//十七列:备注
					var TdObj17 = TrObj.insertCell(16);
					TdObj17.appendChild(document.createTextNode(stuBasicInfo.remarks!=null?stuBasicInfo.remarks:""));		
				}
				
				//分页
				//首页
				var firstPage = document.getElementById("firstPage");
				//添加点击事件
				firstPage.onclick=function() {
					getTutorWatingForUpdate(teacherNo,currentPage);
				};
				//总页数
				var pageNums = document.getElementById("pageNums"); 
				pageNums.innerText=data.pageVo.pageNum;
				
				//当前页
				var currentPage = document.getElementById("currentPage");
				currentPage.innerText=data.pageVo.currentPage;
				
				//上一页
				var previousPage = document.getElementById("previousPage");
				//添加点击事件
				previousPage.onclick=function() {
					var currentPage=data.pageVo.currentPage;
					if(currentPage>1)
						getTutorWatingForUpdate(teacherNo,currentPage-1);
				};
				//下一页
				var nextPage = document.getElementById("nextPage");
				//添加点击事件
				nextPage.onclick=function() {
					var currentPage=data.pageVo.currentPage;
					if(currentPage<data.pageVo.pageNum)
						getTutorWatingForUpdate(teacherNo,currentPage+1);
				};
				
				//最后一页
				var lastPage = document.getElementById("lastPage");
				//添加点击事件
				lastPage.onclick=function() {
					var currentPage=data.pageVo.currentPage;
					if(currentPage!=data.pageVo.pageNum)
						getTutorWatingForUpdate(teacherNo,data.pageVo.pageNum);
				};
				
				//跳转
				var gotoPage = document.getElementById("gotoPage");
				var go = document.getElementById("go");
				//添加点击事件
				go.onclick=function() {
					var currentPage=data.pageVo.currentPage;
					var page = gotoPage.value;
					if(!isNaN(page) && page!=currentPage && page >=1 && page <= data.pageVo.pageNum) 
						getTutorWatingForUpdate(teacherNo,page);
				};			
			});
			
		};
	}
	
}


function updateStuBasicInfo(roleId){
	alert(roleId);
	var inputLists = $("#stuBasicInfo input");
	alert(inputLists[0].type);
	for(var i=0;i<inputLists.length;i++){
		
	}
}

