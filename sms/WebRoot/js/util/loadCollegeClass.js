//需要做的东西有如下的一些，提供加载学院，专业方向，班级的级联

//但是需要做的一个是可配置性，即假如登陆进来的是一个班主任，那么显示的应该是他所管理的学院的班级的

//假如登陆进来的是一个校级工作人员及一上，那么需要显示的是全院全专业全班级的信息

//假如登陆的是一个院级工作人员，那么需要显示的是本院的所有班级

/**
 * 如果页面需要显示　学院专业班级　则showCollegeUtil(1,1,1,-1)
 *  
 */

function ShowConfig(){
}

ShowConfig.prototype = { 
	    college:1, 
	    major: 1
}

 
var a= new ShowConfig({major:1});




function showCollegeUtil(ShowConfig){
		
	var  url  = "";
	//表示显示的是全部学院和其它
	if(college==1){
		url="college";
	}
	
	if(college==0 && major==1){
		
	}
	
}