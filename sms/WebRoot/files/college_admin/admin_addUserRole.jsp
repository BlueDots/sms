<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'admin_addUserRole.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="<%=basePath%>/css/css.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>/css/style.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>/css/jquery-ui.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>/css/arrow.css" rel="stylesheet" type="text/css" />

	<script src="<%=basePath%>/js/jquery-1.7.2.min.js"></script>
	<script src="<%=basePath%>/js/testSearch.js"></script>
	<script src="<%=basePath%>/js/jquery-ui-1.8.21.custom.min.js"></script>

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
																 
												教师工号:<input name="teacherNo"    type="text" size="10" />
											  教师姓名:<input name="teacherName" type="text" size="10" />
												<input name="Submit4" type="button" class="right-button02" value="查 询" />
													
											  
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
						<div id="allbasicMsg" style="display: block">
							<table id="subtree1" style="DISPLAY: " width="100%" border="0"
								cellspacing="0" cellpadding="0">
								<tr>
									<td class="CPanel">
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
																			<td>姓名</td>
																			<td>性别</td>
																			<td>职称</td>
																			<td>职务</td>
																			<td>所属单位</td>
																			<td>角色</td>
																		</tr>
																		
																		<tr bgcolor="#FFFFFF" align="center">
																		  <td><input type="checkbox" name="delid" /></td>
																			<td>2323</td>
																			<td>艾老师</td>
																			<td>男</td>
																			<td>副教授</td>
																			<td>团委书记</td>
																			<td>软件学院</td>
																			<td>
																				<select>
																					<option>学生</option>
																					<option>班主任</option>
																					<option>院级工作人员</option>
																					<option>校级工作人员</option>
																					<option>院级管理员</option>
																					<option>校级管理员</option>
																				</select>	
																			</td>
																		</tr>								                         	

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
																<td colspan="2" align="center" height="30px">
																	<input type="button" name="Submit" value="新增一列"
																		class="button" onclick="link();" />
																	<input type="button" name="Submit" value="保存"
																		class="button" onclick="link();" />
																    <input type="button" name="Submit" value="提交"
																		class="button" onclick="link();" />
																	<input type="button" name="Submit2" value="返回"
																		class="button" onclick="window.history.go(-1);" />
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
		</form>
	</body>
</html>
