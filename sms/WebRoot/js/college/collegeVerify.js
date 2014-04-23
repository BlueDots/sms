//得到学生基本信息列表
var stuBasicInfoObj;
var g_college=null;
var g_major=null;
var g_className=null;
var g_stuNoOrName=null;

//点击查看审核详细信息
function verifyDetail(id,currentPage) {
	var verifyObj = document.getElementById(id);
	
	if(verifyObj.style.display == "block") {
		verifyObj.style.display = "none";
	}
	else {
			verifyObj.style.display = "block";
			flushPage(id);
		
		var url = "?className="+id+"&currentPage="+currentPage;
		
		$.getJSON("StuBasicInfoJSON/StuBasicInfoActionJSON!gainWaitingForLists"+url,function(data){
			var stuBaisicInfoLists = data.waitingForLists;
			//alert(stuBaisicInfoLists.length);
			//得到显示的table对象
			var tableId=id+"table";
			var showTableObj = document.getElementById(tableId);
			//得到表的行数
			var trLength=$("#"+tableId+" tr").length;
			//得到数据个数
			var dataCounts = stuBaisicInfoLists.length;
			//alert(trLength);
			//若trLength>2,清空行号1之后的tr
			if(trLength>2) {
				for(var i=trLength-1;i>1;i--) {
					showTableObj.deleteRow(i);
					trLength--;
				}	
			}
			
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
				checkBox.type="checkBox";
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
	
	
				//第十三列：银行卡号
				var TdObj13 = TrObj.insertCell(12);
				TdObj13.appendChild(document.createTextNode(stuBasicInfo.bankCard!=null?stuBasicInfo.bankCard:""));	
				
				//十四列：审核状态
				var TdObj14 = TrObj.insertCell(13);
				TdObj14.appendChild(document.createTextNode(stuBasicInfo.exameState!=null?stuBasicInfo.exameState:""));	
				
				//十五列:备注
				var TdObj15 = TrObj.insertCell(14);
				TdObj15.appendChild(document.createTextNode(stuBasicInfo.remarks!=null?stuBasicInfo.remarks:""));		
			}		
			
			
			//分页
			//首页
			var firstPage = document.getElementById(id+"firstPage");
			//添加点击事件
			firstPage.onclick=function() {
				verifyDetail(id,1);
			};
			//总页数
			var pageNums = document.getElementById(id+"pageNums"); 
			pageNums.innerText=data.pageVo.pageNum;
			
			//当前页
			var currentPage = document.getElementById(id+"currentPage");
			currentPage.innerText=data.pageVo.currentPage;
			
			//上一页
			var previousPage = document.getElementById(id+"previousPage");
			//添加点击事件
			previousPage.onclick=function() {
				var currentPage=data.pageVo.currentPage;
				if(currentPage>1)
					verifyDetail(id,currentPage-1);
			};
			//下一页
			var nextPage = document.getElementById(id+"nextPage");
			//添加点击事件
			nextPage.onclick=function() {
				var currentPage=data.pageVo.currentPage;
				if(currentPage<data.pageVo.pageNum)
					verifyDetail(id,currentPage+1);
			};
			
			//最后一页
			var lastPage = document.getElementById(id+"lastPage");
			//添加点击事件
			lastPage.onclick=function() {
				var currentPage=data.pageVo.currentPage;
				if(currentPage!=data.pageVo.pageNum)
					verifyDetail(id,data.pageVo.pageNum);
			};
			
			//跳转
			var gotoPage = document.getElementById(id+"gotoPage");
			var go = document.getElementById(id+"go");
			//添加点击事件
			go.onclick=function() {
				var currentPage=data.pageVo.currentPage;
				var page = gotoPage.value;
				if(!isNaN(page) && page!=currentPage && page >=1 && page <= data.pageVo.pageNum) 
					verifyDetail(id,page);
			};
			
		});
	
	}
	
	
}

function flushPage(id) {
	var verifyTableObj= document.getElementById("verifyList");
	//alert(id);
	var verifyTableTrObj = document.getElementById(id);
	for(var i=3;i<13;i+=2) {
		if(verifyTableObj.rows[i] != verifyTableTrObj){
			verifyTableObj.rows[i].style.display="none";
		}
	}
}

