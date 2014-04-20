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
    
    <title>My JSP 'admin_userRole.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="<%=basePath%>/css/css.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>/css/style.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>/css/jquery-ui.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>/css/arrow.css" rel="stylesheet" type="text/css" />

	<script src="<%=basePath%>/js/jquery-1.10.2.js"></script>
	<script src="<%=basePath%>/js/testSearch.js"></script>
	<script src="<%=basePath%>/js/date.js"></script>

<script type="text/javascript">

var menuids = [ "suckertree1" ];

function buildsubmenus() {
	for ( var i = 0; i < menuids.length; i++) {
		var ultags = document.getElementById(menuids[i]).getElementsByTagName(
				"ul");
		for ( var t = 0; t < ultags.length; t++) {
			ultags[t].parentNode.getElementsByTagName("a")[0].className = "subfolderstyle";
			ultags[t].parentNode.onmouseover = function() {
				this.getElementsByTagName("ul")[0].style.display = "block";
			};
			ultags[t].parentNode.onmouseout = function() {
				this.getElementsByTagName("ul")[0].style.display = "none";
			};
		}
	}
}

if (window.addEventListener)
	window.addEventListener("load", buildsubmenus, false);
else if (window.attachEvent)
	window.attachEvent("onload", buildsubmenus);


function sousuo() {
	window
			.open(
					"gaojisousuo.htm",
					"",
					"depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
}
function selectAll() {
	var obj = document.fom.elements;
	for ( var i = 0; i < obj.length; i++) {
		if (obj[i].name == "delid") {
			obj[i].checked = true;
		}
	}
}

function unselectAll() {
	var obj = document.fom.elements;
	for ( var i = 0; i < obj.length; i++) {
		if (obj[i].name == "delid") {
			if (obj[i].checked == true)
				obj[i].checked = false;
			else
				obj[i].checked = true;
		}
	}
}

function link() {
	document.getElementById("fom").action = "../addrenwu.htm";
	document.getElementById("fom").submit();
}
</script>	

  </head>
  
  <body >
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
											<td width="538">

                     	角色
												<select>
													<option>学生</option>
													<option>班主任</option>
													<option>院级工作人员</option>
													<option>校级工作人员</option>
													<option>院级管理员</option>
													<option>校级管理员</option>
												</select>
												
												 
											  教师工号:<input name="teacherNo"  type="text" size="10" />
											  教师姓名:<input name="teacherName" type="text" size="10" />
												<input name="Submit4" type="button" class="right-button02" value="查 询" />
													
												排序:
												<select name="排序">
													<option>
														教师工号 
													</option>
													<option>
														教师姓名
													</option>
												</select>
												
											  <img src="<%=basePath%>/images/up[1].png"></img>
											  
											</td>
											<td width="77" align="center">
												<div class="suckerdiv">
													<ul id="suckertree1">
														<li>
															<a href="#">角色分配</a>
															<ul>
																<li>
																<a href="files/college_admin/admin_addUserRole.jsp">分配角色</a>
																</li>
															</ul>

														</li>
													</ul>
												</div>
											</td>
											 
											<td width="77" align="center">
												<a href="#" onclick="sousuo()"> <input name="Submit4"
														type="button" class="right-button07" value="导出" /> </a>
											 
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
							<table id="subtree1" style="DISPLAY: " width="100%" border="0"
								cellspacing="0" cellpadding="0">
								<tr>
									<td class="CPanel">
										<div id="liulanbiao" style="margin-left: 10px">
											<table width="99%" border="0" cellpadding="0" cellspacing="0"
												class="CContent">
												<tr>
													<th class="tablestyle_title">
														当前位置： <a href="#" style="color:red;">分配角色管理</a>&gt;&gt;<a style="color:red;" href="#">用户分配角色</a> 
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
																				用户信息查询表																			</td>
																		</tr>
																		<tr bgcolor="#EEEEEE" align="center">
																		 <td><input type="checkbox" name="delid" />全选</td>
																			<td>教师工号</td>
																			<td>教师姓名</td>
																			<td>性别</td>
																			<td>政治面貌</td>
																			<td>部门</td>
																			<td>教师职称</td>
																			<td>入职时间</td>
																			<td>角色列表</td>
																		</tr>
										
										<s:iterator value="vteacherRoleList" id="vteacherRole" >			
																		<tr bgcolor="#FFFFFF" align="center">
																		    <td><input type="checkbox" name="delid" /></td>
																			<td><s:property value="#vteacherRole.teacherNo"></s:property>	</td>
																			<td><s:property value="#vteacherRole.teacherName"></s:property>	</td>
																			<td>
																				<s:if test="%{#vteacherRole.sex==0}"> 
																					男	
																				</s:if>
																				<s:if test="%{#vteacherRole.sex==1}"> 
																					女	
																				</s:if>						
																			</td>
																			<td><s:property value="#vteacherRole.political"></s:property>	</td>																			
																			<td>
				
																				<s:iterator value="#vteacherRole.departmentList" id="dList" >
																					<s:property value="#dList"></s:property>	
																				</s:iterator>
																			</td>
																			<td><s:property value="#vteacherRole.teacherTitle"></s:property>	</td>
																			<td><s:property value="#vteacherRole.worktime"></s:property>	</td>
																			<td>
																				<s:iterator value="#vteacherRole.roleList" id="rList" >
																				<a href="TecRole/displayPurview!showPurviewByRoleNo?roleName=<s:property value="#rList"></s:property>">
																					<s:property value="#rList"></s:property>	
																				</a>
																				</s:iterator>
																			</td>
																		</tr>
											</s:iterator>					
																		</table>
																</td>
															</tr>
														</table>
														<table width="95%" border="0" align="center"
															cellpadding="0" cellspacing="0">
															<tr>
																<td height="6">
																	<img src="<%=basePath%>/images/spacer.gif" width="1" height="1" />
																</td>
															</tr>
															<tr>
															</tr>
														</table>
														<table width="95%" border="0" align="center"
															cellpadding="0" cellspacing="0">
															<tr>
																<td height="6">
																	<img src="<%=basePath%>/images/spacer.gif" width="1" height="1" />
																</td>
															</tr>
															<tr>
																<td height="33">
																	<table width="100%" border="0" align="center"
																		cellpadding="0" cellspacing="0" class="right-font08">
																		<tr>
																			<td width="50%">
																				共
																				<span class="right-text09">5</span> 页 | 第
																				<span class="right-text09">1</span> 页
																			</td>
																			<td width="49%" align="right">
																				[
																				<a href="#" class="right-font08">首页</a> |
																				<a href="#" class="right-font08">上一页</a> |
																				<a href="#" class="right-font08">下一页</a> |
																				<a href="#" class="right-font08">末页</a>] 
																				<s:debug></s:debug>
																			</td>
																			<td width="1%">
																				<table width="20" border="0" cellspacing="0"
																					cellpadding="0">
																					<tr>
																						
																						
																					</tr>
																				</table>
																			</td>
																		</tr>
																	</table>
																</td>
															</tr>
														</table>
													</td>
												</tr>
											</table>
										</div>
									</td>
								</tr>
							</table>
						</td>
				</tr>
			</table>
		</form>
	</body>
</html>
