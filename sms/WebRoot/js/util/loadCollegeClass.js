$(document).ready(function() {
    console.log( "加载学院班级信息开始!" );
    
    $.getJSON("",callback);
});

/**
 * 通过后台显示的数据显示下拉框,后台需要传入{college:1,major:1,class:1}和最头的data 
 * 然后在callback中添加select和　监听事件
 * @param data
 */
function callback(data){
	
}