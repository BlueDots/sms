$(document).ready(function(){
		
    		$("#test").treeview();
    
		
		//给所有的权限复选框绑定事件处理函数
		$("[name=purview]").click(function(){
		
				var checked = this.checked;   //当前checkbox的选中状态
		
				//当选中或取消一个权限时，选中或取消所有下级的权限
				$(this).siblings("ul").find("input").attr("checked",checked);
				
				//当选中一个权限时，也要同时选中所有上级权限
				if(checked){
					
					$(this).parents("li").children("input").attr("checked",checked);
				}
				
				//当取消一个权限后，同级若没有选中的权限时，上级也取消权限，再向上一层也类似
				else{
				
					if($(this).parent().siblings("li").children("input:checked").size() == 0){
						
						$(this).parent().parent().siblings("input").attr("checked",checked);
						
						var startPoint = $(this).parent().parent();
						
							if(startPoint.parent().siblings("li").children("input:checked").size() == 0){
							
								startPoint.parent().parent().siblings("input").attr("checked",checked);
							
							}
						
					}
				}
		});	
	});	