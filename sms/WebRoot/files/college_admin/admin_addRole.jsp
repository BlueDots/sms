<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@  taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'admin_addRole.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="<%=basePath%>/css/admin/jquery.treeview.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>/css/admin/screen.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>/css/admin/file.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>/css/css.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>/css/style.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>/css/jquery-ui.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>/css/arrow.css" rel="stylesheet" type="text/css" />

	<script src="<%=basePath%>/js/admin/jquery-1.7.2.min.js"></script>
	<script src="<%=basePath%>/js/admin/jquery.cookie.js"></script>
	<script src="<%=basePath%>/js/admin/jquery.treeview.js"></script>
	<script src="<%=basePath%>/js/admin/lyx.js"></script>
	<script src="<%=basePath%>/js/testSearch.js"></script>
	<script src="<%=basePath%>/js/date.js"></script>

<script type="text/javascript">
function displayPurview(){
	
	$("#tablePurview").toggle();
	
}

function getChecked(){

	var roleName = $("#roleName").attr("value");
	var roleDescription = $("#roleDescription").attr("value");

	var array = new Array();

	if(roleName=='' || roleDescription == ''){
		alert("角色信息不能为空");
		return;
	}

	$("input:checkbox:checked").each(function(){
		
		array.push($(this).siblings("input:hidden").val());
	
		window.location.href="RoleManager/addRole!addRole?array="+array+"&roleName="+roleName+"&roleDescription="+roleDescription;
	
	}); 
	

}
</script>
  </head>
  
 <body>
		<form name="fom" id="fom" method="post" action="">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="30">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="62" background="<%=basePath%>/images/nav04.gif">

									<table width="98%" border="0" align="center" cellpadding="0"
										cellspacing="0">
										<tr>
											<td width="21">
												<img src="<%=basePath%>/images/ico07.gif" width="20" height="18" />
											</td>
										  
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<!--这是显示查询人员的信息的表格-->

					<div>&nbsp;</div>
				<!--这事显示录入人员的表格-->
				
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td>
										<div id="lurubiao" style="margin-left: 10px">
											<table width="99%" border="0" cellpadding="0" cellspacing="0"
												class="CContent">
												<tr>
													<th class="tablestyle_title">
														 当前位置： <a href="#" style="color:red;">角色管理</a>&gt;&gt; <a href="./admin_jobManager.html" style="color:red">查看角色信息</a>&gt;&gt;<a style="color:red;" href="admin_addRole.html">添加角色	</a> 
													</th>
												</tr>
												<tr>
													<td class="CPanel">
														<table width="100%" border="0" align="center"
															cellpadding="0" cellspacing="0">
															<tr>
																<td height="40" class="font42">
																	<table width="100%" border="0" cellpadding="4"
																		cellspacing="1" bgcolor="#464646" class="newfont03">
																		<tr class="CTitle">
																			<td height="22" colspan="13" align="center"
																				style="font-size: 16px">
																				添加角色表
																			</td>
																		</tr>
																		<tr bgcolor="#EEEEEE">
																			 		
																			<td width="5%" align="center">
																			  角色名称
																			</td>
																			<td width="10%" align="center">
																				角色描述
																			</td>
																			<td width="8%" align="center">
																				操作
																			</td>	

																		</tr>
																		<tr bgcolor="#FFFFFF" align="center">
																			 		
																			<td>
																				<input type="text" name="roleName" id="roleName"/>
																			</td>
																			<td>
																			  	<input type="text" name="roleDescription" id="roleDescription"/>
																			</td>
																			<td>
																				<a href="javascript:displayPurview();">分配权限</a>
																			</td>																			
																		</tr>																			 			
																	</table>
																</td>
															</tr>
															<tr>
																<td colspan="2" align="center" height="30px">
																							
																</td>
															</tr>
															
															<tr>
																<td>
																
														
										               <!--添加权限的表格-->
										               		<table width="100%" border="0" cellpadding="4"	cellspacing="1" bgcolor="#464646" class="newfont03" id="tablePurview" style=display:none>
																		<tr class="CTitle">
																			<td height="22" colspan="13" align="center"
																				style="font-size: 16px" width="100%">
																				权限列表
																			</td>
																		</tr>
																		<tr bgcolor="#FFFFFF">																		
																				<td  height="60"  width="100%">
																				
<!--  ----------- ----------- -----------权限界面开始---------- ------------------- -->																						
		<ul id="test">	
				<s:iterator value="purviewList" id="purviewParent" >	
					<s:if test='#purviewParent.pid==1' >	
						<li>
							<input type="checkbox" name="purview" 
							<s:iterator value="checkList" id="checkLists" >
								<s:property value="%{#purviewParent.id == #checkLists.id ? 'checked' : ''}"/>
							</s:iterator>	
							/>
							<input type="hidden" name="field＿name" value="<s:property value="#purviewParent.id"/>">
							<span class="folder">	
								<s:property value="#purviewParent.purviewName"></s:property>						
							</span>	
						
									<ul>
										<s:iterator value="purviewList" id="purviewChild">	
												<s:if test="#purviewParent.id==#purviewChild.pid">							
													<li>													
														<input type="checkbox" name="purview" 
																<s:iterator value="checkList" id="checkLists" >
																	<s:property value="%{#purviewChild.id == #checkLists.id ? 'checked' : ''}"/>
																</s:iterator>
														/>
														<input type="hidden" name="field＿name" value="<s:property value="#purviewChild.id"/>">
														<span class="file">	
															<s:property value="#purviewChild.purviewName"></s:property>						
														</span>	
													</li>
												</s:if>							
										</s:iterator>
									</ul>
									
								</li>	
							</s:if>		
				</s:iterator>
		</ul>	
<!--  ----------- ----------- -----------权限界面结束---------- ------------------- -->		
		
																				</td>
																		</tr>
																		<tr bgcolor="#FFFFFF">
																			<td colspan="2" align="center" height="30px">
																				<input type="button" name="submitPurview" value="提交"
																					class="button" onclick="getChecked()" />
																				<input type="button" name="return" value="返回"
																					class="button" onclick="window.history.go(-1);"/>
																			</td>
																		</tr>
										               		</table>
													
															
																													
														</table>
													</td>
												</tr>
											</table>
											
										</div>	
									<td>												
								</tr>
							</table>
						</td>
					</tr>
				</table>									
		</form>
	</body>
</html>
