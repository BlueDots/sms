<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>学生工作管理系统</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link href="<%=basePath%>css/css.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/arrow.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/tutor/tanchu.css">
<!-- 需要放到公共的js包下-->

<script src="<%=basePath%>js/jquery-1.10.2.min.js"></script>
<script src="<%=basePath%>js/jquery-1.10.2.js"></script>
<script src="<%=basePath%>js/jquery.provincesCity.js"></script>
<script src="<%=basePath%>js/jquery.chromatable.js"></script>
<script type="text/javascript" src="<%=basePath%>js/school/jquery-1.10.2-vsdoc2.js"></script>
<script type="text/javascript" src="<%=basePath%>js/tutor/tutor_povertyFile.js"></script>
<!--编辑贫困建档信息-->

<script type="text/javascript">
	var menuids = [ "suckertree1" ]

	function buildsubmenus() {
		for ( var i = 0; i < menuids.length; i++) {
			var ultags = document.getElementById(menuids[i])
					.getElementsByTagName("ul")
			for ( var t = 0; t < ultags.length; t++) {
				ultags[t].parentNode.getElementsByTagName("a")[0].className = "subfolderstyle"
				ultags[t].parentNode.onmouseover = function() {
					this.getElementsByTagName("ul")[0].style.display = "block"
				}
				ultags[t].parentNode.onmouseout = function() {
					this.getElementsByTagName("ul")[0].style.display = "none"
				}
			}
		}
	}

	if (window.addEventListener)
		window.addEventListener("load", buildsubmenus, false)
	else if (window.attachEvent)
		window.attachEvent("onload", buildsubmenus)
</script>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	list-style-type: none;
}

.demo {
	border: solid 1px #D5D5D5;
	border-collapse: collapse;
	width: 100%;
}

.demo td {
	border: 1px solid #D5D5D5;
	font-size: 12px;
	padding: 7px 5px;
}

.demo th {
	background-color: #EEE;
	border-right: 1px solid #D5D5D5;
	font-size: 13.5px;
	line-height: 120%;
	font- weight: bold;
	padding: 8px 5px;
	text-align: left;
}
</style>
</head>
<script language=JavaScript>
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
<script src="<%=basePath%>js/jquery-1.7.2.min.js">
	
</script>
<script src="<%=basePath%>js/testSearch.js">
	
</script>
<script src="<%=basePath%>js/jquery.chromatable.js">
	
</script>
<script type="text/javascript">
	$(document).ready(function() {

		$("#tableID").chromatable({
			width : "100%",

			scrolling : "yes"
		});

	});
</script>
<body>
	<form name="fom" id="fom" method="post" action="">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="30">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="62" background="<%=basePath%>/images/nav04.gif">

								<table width="100%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td width="2%"><img src="<%=basePath%>/images/ico07.gif"
											width="20" height="18" /></td>
										<td width="75%"><span class="collegeName">学院 <select
												name="college" size="1" id="collegeId">
													<option value="selected">请选择学院</option>
													<option value="agri_college">农学院</option>
													<option value="garden_art">园林与艺术学院</option>
													<option value="animal_science_tech">动物科学技术学院</option>
													<option value="engin_college">工学院</option>
													<option value="science_college">理学院</option>
													<option value="land_resources">国土资源与环境学院</option>
													<option value=" computer_information">计算机与信息工程学院</option>
													<option value=" economics_management">经济管理学院</option>
													<option value="food_science_engin">食品科学与工程学院</option>
													<option value="normal_college">职业师范（技术）学院</option>
													<option value="biological_science_engine">
														生物科学与工程学院</option>
													<option value="foreign_languages">外国语学院</option>
													<option value="software">软件学院</option>
													<option value="marxism_college">马克思主义学院（政治学院）</option>
													<option value="continu_education">继续教育学院</option>
											</select> </span> <span class="majorName">专业方向 <select name="major"
												id="majorId">
													<option value="selected">请选择专业方向</option>
											</select> </span> <span class="className">班级 <select name="class"
												id="classId">
													<option value="selected">请选择班级</option>
											</select> </span> <input name="condition" type="text" size="16"
											value="请输入学号或者姓名" /> <input name="find" type="button"
											class="right-button02" value="查询" /> &nbsp;&nbsp;排序 <select
											name="rank">
												<option>学号升序</option>
												<option>学号降序</option>
										</select></td>
										<td width="9%" align="left">
											<div class="suckerdiv" style="padding-right:-20px">
												<ul id="suckertree1">
													<li><a href="#">信息管理</a>
														<ul>
															<li><a>编辑</a>
																<ul>
																	<li><a onclick="" id='manuallyId'>修改</a></li>
																	<li><a onclick=''>删除</a></li>
																</ul></li>
															<li><a>录入</a>
																<ul>
																	<li><a onclick="manually()" id='manuallyId'>手动录入</a>
																	</li>
																	<li><a onclick=''>导入</a></li>
																</ul></li>
														</ul></li>
												</ul>
											</div></td>
										<td width="7%" align="left"><input name="advanced_search"
											type="button" class="right-button07" value="高级搜索"
											onclick="popup('#advancedDiv', '#advancedSearchDiv', '#CloseadvancedSearch')" />
										</td>
										<td width="7%" align="left"><input name="export"
											type="button" class="right-button07" value="导出"
											onclick="exportData()" /></td>
									</tr>
								</table></td>
						</tr>
					</table></td>
			</tr>
			<tr>
				<td>
					<div id="allbasicMsg" style="display: block">
						<table id="subtree1" style="DISPLAY: " width="100%" border="0"
							cellspacing="0" cellpadding="0">
							<tr>
								<td class="CPanel">
									<div id="liulanbiao" style="margin-left: 10px">
										<table width="99%" border="0" cellpadding="0" cellspacing="0"
											class="CContent">
											<tr>
												<th class="tablestyle_title">当前位置：学生建档信息页面</th>
											</tr>
											<tr>
												<td class="CPanel">
													<table width="100%" border="0" align="center"
														cellpadding="0" cellspacing="0">

														<tr>
															<td height="40" class="font42"><table width="100%"
																	border="0" cellpadding="4" cellspacing="1"
																	bgcolor="#464646" class="demo" id="tableID">
																	<thead>
																		<tr class="CTitle">
																			<td colspan="13" align="center"
																				style="font-size: 16px">学生建档信息表</td>
																		</tr>
																		<tr bgcolor="#EEEEEE">
																			<th>
																				<center>
																					<input name="checkbox11" type="checkbox"
																						value="checkbox" onclick="select_all()" />
																				</center></th>
																			<th>
																				<center>学号</center></th>
																			<th>
																				<center>姓名</center>
																			</th>
																			<th><center>性别</center>
																			</th>
																			<th>
																				<center>学院</center>
																			</th>
																			<th>
																				<center>专业</center></th>
																			<th>
																				<center>班级</center>
																			</th>
																			<th>
																				<center>家庭住址</center>
																			</th>
																			<th>
																				<center>家庭经济情况</center>
																			</th>
																			<th>
																				<center>认定等级</center>
																			</th>
																			<th>
																				<center>学期</center>
																			</th>
																			<th>
																				<center>审核状态</center>
																			</th>
																			<th>
																				<center>备注</center>
																			</th>
																		</tr>
																	</thead>


																	<tr bgcolor="#FFFFFF" align="center">
																		<td><input name="checkbox11" type="checkbox"
																			value="checkbox" />
																		</td>
																		<td><a href="#"
																			onclick="popup('#fileInfoDiv', '#setSchStuBasicInfoDiv', '#ClosePastFileInfo')">20101428</a>
																		</td>
																		<td>陈鹏</td>
																		<td>男</td>
																		<td>软件学院</td>
																		<td>软件开发</td>
																		<td>1001</td>
																		<td>江西上饶</td>
																		<td>贫困</td>
																		<td>甲等</td>
																		<td>201201</td>
																		<td>通过</td>
																		<td>无</td>
																	</tr>
																</table>
																<table width="95%" border="0" align="center"
																	cellpadding="0" cellspacing="0">
																	<tr>
																		<td height="6"><img src="../../images/spacer.gif"
																			width="1" height="1" /></td>
																	</tr>
																	<tr>
																		<td height="33">
																			<table width="100%" border="0" align="center"
																				cellpadding="0" cellspacing="0" class="right-font08">
																				<tr>
																					<td width="50%">共 <span class="right-text09">5</span>
																						页 | 第 <span class="right-text09">1</span> 页</td>
																					<td width="49%" align="right">[ <a href="#"
																						class="right-font08">首页</a> | <a href="#"
																						class="right-font08">上一页</a> | <a href="#"
																						class="right-font08">下一页</a> | <a href="#"
																						class="right-font08">末页</a>] 转至：</td>
																					<td width="1%">
																						<table width="20" border="0" cellspacing="0"
																							cellpadding="0">
																							<tr>
																								<td width="1%"><input name="textfield3"
																									type="text" class="right-textfield03" size="1" />
																								</td>
																								<td width="87%"><input name="Submit23222"
																									type="submit" class="right-button06" value=" " />
																								</td>
																							</tr>
																						</table></td>
																				</tr>
																			</table></td>
																	</tr>
																</table></td>
														</tr>
													</table></td>
											</tr>
										</table>

									</div></td>
							</tr>
						</table>
					</div></td>
			</tr>
		</table>
	</form>
	</div>
	</td>
	</tr>
	</table>
	</form>
	<form name="fom" id="fom" method="post" action="">
		<div id="advancedDiv" style="display: none"></div>
		<div id="advancedSearchDiv" style="display: none">
			<h2>
				高级查询选项<a href="#" id="CloseadvancedSearch">关闭</a>
			</h2>
			<div class="form">
				<table width="50%" border="0" cellpadding="4" cellspacing="1"
					bgcolor="#464646" class="demo" id="advancedSearchTab">
					<thead>

						<tr bgcolor="#FFFFFF" align="center">
							<td width='15%'>性别</td>
							<td width='35%'><input name="sex" type="radio" value="sex"
								checked />男 <input name="sex" type="radio" value="sex" />女</td>
						</tr>
						<tr bgcolor="#FFFFFF" align="center">
							<td width='15%'>认定等级</td>
							<td width='35%'><select name="level">
									<option>甲等</option>
									<option>乙等</option>
									<option>丙等</option>
							</select></td>
						</tr>
						<tr bgcolor="#FFFFFF" align="center">
							<td width='15%'>审核状态</td>
							<td width='35%'><select name="checkState">
									<option>未提交</option>
									<option>通过</option>
									<option>院级审核中</option>
									<option>校级审核中</option>
									<option>院级未通过</option>
									<option>校级未通过</option>
							</select></td>
						</tr>
						<tr bgcolor="#FFFFFF" align="center">
							<td width='15%'>学期</td>
							<td width='35%' name='nation'><select name="term">
									<option>20141</option>
									<option>20132</option>
									<option>20131</option>
							</select></td>
						</tr>
						<tr bgcolor="#FFFFFF" align="center">
							<!--使用juquery的时间插件-->
							<td width='15%' name='projectName'>家庭经济情况</td>
							<td width='35%'><input type="text" name="finLevel"
								value="贫困" /></td>
						</tr>
						<tr bgcolor="#FFFFFF" align="center">
							<!--使用juquery的时间插件-->
							<td width='15%'>家庭住址</td>
							<td width='35%'><input type="text" name="address"
								value="江西赣州" /></td>
						</tr>
				</table>
			</div>
		</div>
	</form>
	<!--查询某个学生的全部建档信息-->
	<div id="fileInfoDiv" style="display: none"></div>
	<div id="setSchStuBasicInfoDiv" style="display: none">
		<h2>
			建档信息<a href="#" id="ClosePastFileInfo">关闭</a>
		</h2>
		<div class="form">
			<table width="80%" border="0" cellpadding="4" cellspacing="1"
				bgcolor="#464646" class="demo" id="pastAdvInfoTab">
				<thead>
					<tr class="CTitle">
						<td height="22" colspan="10" align="center"
							style="font-size: 16px">学生建档信息表</td>
					</tr>

					<tr bgcolor="#FFFFFF" align="center">
						<td width='15%' name='projectName'>学期</td>
						<td width='15%' name='projectName'>认定等级</td>
						<td width='15%' name='projectName'>家庭经济情况</td>
						<td width='20%' name='projectName'>备注</td>
					</tr>
					<tr bgcolor="#FFFFFF" align="center">
						<td width='15%' name='projectName'>201201</td>
						<td width='15%' name='projectName'>甲等</td>
						<td width='15%' name='projectName'>贫困</td>
						<td width='20%' name='projectName'>无</td>
					</tr>
					<tr bgcolor="#FFFFFF" align="center">
						<td width='15%' name='projectName'>201301</td>
						<td width='15%' name='projectName'>乙等</td>
						<td width='15%' name='projectName'>贫困</td>
						<td width='20%' name='projectName'>无</td>
					</tr>
			</table>
		</div>
	</div>
</body>
</html>
