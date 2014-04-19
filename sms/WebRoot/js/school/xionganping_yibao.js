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
	
	popup('#medicareDiv', '#acceptResultDiv', '#btnCloseacceptResult');
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
	
	popup('#medicareDiv', '#acceptResultList', '#btnCloseList')
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
	popup('#medicareDiv', '#acceptMoney', '#btnCloseMoney');
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
