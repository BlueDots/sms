 



//录入受理结果 首先应该先判断是不是有数据勾选了，才可以去修改受理结果
function updateDataAboutAcceptResult() {

	var num =getCheckBoxCountAboutJuMing(); 
	if(num>1){
		alert("录入数据只能勾选一个名单");
		return ;
	}
	
	if(num==0){
		alert("请在学生医保登记表中勾选一个名单");
		return ;
	}
	
	var hosNo  = 	$("input[type='checkbox'][name='juming']:checkbox:checked").val();
	
	$.getJSON("hosInsurance/hosInsurance!getHosByHosNo?hosNo="+hosNo,function(data){
		var  hos = data.hosInsuranceInfo;
		if(hos.hosState=='校级审核中'){
			alert("该学生的未审核，请前去审核");
			return ;
		}
		 setData("juming",hos);
		$("#jumingHospitalAddress").html(hos.hospitalAddress);
		$("#jumingCost").html(hos.cost);
		$("#submitTime").val(hos.submitTime);
		$("#refuseReason").val(hos.refuseReason);
		
		$("#resultDeal").val(hos.resultDeal);
		
		popup('#medicareDiv', '#acceptResultDiv', '#btnCloseacceptResult');
	});
	
}


function updateDataAboutCompany(){
	var  num =getCompanyCheckBox(); 
	if(1<num){
		alert("录入数据只能勾选一个名单");
		return ;
	}
	
	if(num==0){
		alert("请在商业理赔登记表中勾选一个名单");
		return;
	}
	var hosNo  = 	$("input[type='checkbox'][name='company']:checkbox:checked").val();
	$.getJSON("hosInsurance/hosInsurance!getHosByHosNo?hosNo="+hosNo,function(data){
		var  hos = data.hosInsuranceInfo;
	   
		setData("company",hos);
		$("#companyBankcardID").html(hos.bankcardID	);
		$("#insurerTime").html(hos.insurerTime);
		$("#insurerTime").val(hos.insurerTime);
		
		$("#complete").val(hos.complete);
		$("#notinsurerReason").val(hos.notinsurerReason);
		$("#companyRemark").val(hos.companyRemark);
		
		$("#companyCost").html(hos.cost);
		if(hos.hosState=='校级审核中'){
			alert("该学生的未审核，请前去审核");
			return ;
		}
		 
		popup('#medicareDiv', '#acceptMoney', '#btnCloseMoney') ;
    });
  

}

function updateDataAboutReimburse(){
	var num = getCheckBoxCountAboutBaoXiao();
	if(1<num){
		alert("录入数据只能勾选一个名单");
		return ;
	}
	if(num==0){
		alert("请在已报销登记表中勾选一个名单");
		return ;
	}
	
	var hosNo  = 	$("input[type='checkbox'][name='reimburse']:checkbox:checked").val();
	$.getJSON("hosInsurance/hosInsurance!getHosByHosNo?hosNo="+hosNo,function(data){
		var  hos = data.hosInsuranceInfo;
		if(hos.hosState=='校级审核中'){
			alert("该学生的未审核，请前去审核");
			return ;
		}
	    setData("bx",hos);
		$("#bxReimbursementAmount").val(hos.reimbursementAmount);
		$("#bxBill").val(hos.bill);
		$("#bxGetCardTime").val(hos.getcardTime);
		$("#bxCost").html(hos.cost);
		$("#jumingRemark").val(hos.jumingRemark	);
		popup('#medicareDiv', '#acceptResultList', '#btnCloseList');
    });

}

function  getCheckBoxCountAboutJuMing(){
	var  data = $("input[type='checkbox'][name='juming']:checkbox:checked");
	console.log(data.length);
	return data.length;
}


function getCheckBoxCountAboutBaoXiao(){
	var  data = $("input[type='checkbox'][name='reimburse']:checkbox:checked");
	console.log(data.length);
	return data.length;
}


function getCompanyCheckBox(){
	var  data = $("input[type='checkbox'][name='company']:checkbox:checked");
	console.log(data.length);
	return data.length;
}


function popup(div1, div2, btnId) {
	$(div1).css({ display: "block", height: $(document).height() });
    var yscroll = document.documentElement.scrollTop;
    $(div2).css("top", "100px");
    $(div2).css("display", "block");
    document.documentElement.scrollTop = 0;

	$(btnId).click(function() {
    	$(div1).css("display", "none");
    	$(div2).css("display", "none");
	});
};

function setData(ads,hos){
	$("#"+ads+"HosNo").val(hos.hosNo);
	$("#"+ads+"StudentNo").html(hos.student.studentNo);
	$("#"+ads+"StudentName").html(hos.student.studentName);
	$("#"+ads+"College").html(hos.student.college);
	$("#"+ads+"Class").html(hos.student.className);
	$("#"+ads+"HospitalDate").html(hos.hospitalDate);
	$("#"+ads+"LeaveDate").html(hos.leaveDate);
	$("#"+ads+"HosDate").html(hos.hosDate);
	$("#"+ads+"Conditon").html(hos.conditon);
	$("#"+ads+"LocalCity").html(hos.localCity==0?'本市':'外市');
	$("#"+ads+"ApplyTime").html(hos.applyTime);
}