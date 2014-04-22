<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/tutor/tanchu.css">
<!-- 需要放到公共的js包下-->

<script src="<%=basePath%>js/jquery-1.10.2.min.js"></script>
<script src="<%=basePath%>js/jquery-1.10.2.js"></script>
<script src="<%=basePath%>js/jquery.provincesCity.js"></script>
<script src="<%=basePath%>js/jquery.chromatable.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/school/jquery-1.10.2-vsdoc2.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/tutor/tutor_scholarship.js"></script>

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
	font-weight: bold;
	padding: 8px 5px;
	text-align: left;
}
</style>

<script type="text/javascript">

var menuids = [ "suckertree1" ]

function buildsubmenus() {
	for ( var i = 0; i < menuids.length; i++) {
		var ultags = document.getElementById(menuids[i]).getElementsByTagName(
				"ul")
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
	window.attachEvent("onload", buildsubmenus)</script>
<style type="text/css">
<!--
.STYLE3 {
	font-size: 14px
}

.STYLE11 {
	font-size: 13px;
	font-weight: bold;
}
-->
</style>
</head>

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
									<div id="liulanbiao" style="margin-left: 5px">
										<table width="100%" border="0" cellpadding="0" cellspacing="0"
											class="CContent">
											<tr>
												<th class="tablestyle_title">当前位置：奖助学信息页面</th>
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
																			<td height="22" colspan="17" align="center"
																				style="font-size: 16px">
																				<center>奖助学信息表</center></td>
																		</tr>
																		<tr bgcolor="#EEEEEE" align="center">
																			<th rowspan="2"><span class="STYLE3">
																					<center>
																						<input type="checkbox" />
																					</center> </span>
																			</th>
																			<th rowspan="2"><span class="STYLE3">
																					<center>学号</center> </span></td>
                                                                  <th
																				rowspan="2"><span class="STYLE3"> <center>姓名</center> </span>
																			</td>
                                                                  <th
																				rowspan="2"><span class="STYLE3"> <center>性别</center> </span>
																			</td>
                                                                  <th
																				rowspan="2"><span class="STYLE3"> <center>学院</center> </span>
																			</td>
                                                                  <th
																				rowspan="2"><span class="STYLE3"> <center>专业</center> </span>
																			</td>
                                                                  <th
																				rowspan="2"><span class="STYLE3"> <center>班级</center> </span>
																			</th>
                                                                  <th
																				colspan="2"><span class="STYLE3"> <center>上半年获奖学金情况</center>
																			</span>
																			</th>
                                                                  <th
																				rowspan="2"><span class="STYLE3"><center>上学年奖助信息</center>
																			</span>
																			</th>
                                                                  <th
																				rowspan="2"><span class="STYLE3"><center>上学年贫困等级</center>
																			</span>
																			</th>
                                                                  <th
																				rowspan="2"><span class="STYLE3"> <center>本学年贫困等级</center>
																			</span>
																			</th>
                                                                  <th
																				rowspan="2"><span class="STYLE3"> <center>奖助学名称</center> </span>
																			</th>
                                                                  <th
																				rowspan="2"><span class="STYLE3"> <center>性质</center> </span>
																			</th>
                                                                  <th
																				rowspan="2"><span class="STYLE3"> <center>获奖时间</center> </span>
																			</th>
                                                                  <th
																				rowspan="2"><span class="STYLE3"> <center>金额</center> </span>
																			</th>
                                                                  <th
																				rowspan="2"><span class="STYLE3"> <center>审核状态</center> </span>
																			</th>
                                                                </tr>
                                                                <tr
																			bgcolor="#EEEEEE">
                                                                  <th><span
																				class="STYLE3">上半学年</span>
																			</th>
                                                                  <th><span
																				class="STYLE3">下半学年</span>
																			</th>
						 										 </tr>
																	</thead>
                                                                <tr
																		bgcolor="#FFFFFF" align="center">
                                                                  <td><input
																			type="checkbox" />
																		</td>
                                                                  <td><a
																			href="#"
																			onclick="popup('#pastSchInfoDiv', '#setSchStuBasicInfoDiv', '#ClosePastSchInfo')">20101428</a>	</td>
                                                                  <td> 赖辉强 </td>
                                                                  <td> 男 </td>
                                                                  <td> 软件学院 </td>
                                                                  <td> 软件开发 </td>
                                                                  <td> 软件1001 </td>
                                                                  <td>一等奖</td>
                                                                  <td>一等奖</td>
                                                                  <td> 获国家奖学金 </td>
                                                                  <td>甲等</td>
                                                                  <td>甲等</td>
																  <td>励志奖学金</td>
																  <td>国家</td>
																  <td>2010-10-10</td>
																  <td>5000</td>
																  <td>通过</td>
															  </tr>
													
                                                              </table>
															</td>
															</tr>
														</table>
														<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0">
															<tr>
																<td height="6">
																	<img src="../../images/spacer.gif" width="1" height="1" />
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
																				<a href="#" class="right-font08">末页</a>] 转至：
																			</td>
																			<td width="1%">
																				<table width="20" border="0" cellspacing="0"
																				cellpadding="0">
																					<tr>
																						<td width="1%">
																							<input name="textfield3" type="text"
																						class="right-textfield03" size="1" />
																						</td>
																						<td width="87%">
																							<input name="Submit23222" type="submit"
																						class="right-button06" value=" " />
																						</td>
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
						</div>
					</td>
				</tr>
			</table>
		</form>
		<!--高级查询条件-->
	<form name="fom" id="fom" method="post" action="">
    	<div id="advancedDiv" style="display: none"></div>
    		<div id="advancedSearchDiv" style="display: none">
             	<h2>高级查询选项<a href="#" id="CloseadvancedSearch">关闭</a>
			</h2>
        	<div class="form">
            	<table width="50%" border="0" cellpadding="4"
					cellspacing="1" bgcolor="#464646" class="demo"
					id="advancedSearchTab">
					<thead>
            
					<tr bgcolor="#FFFFFF" align="center">
					    <td width='15%' name='projectName'> 
					    	性别
					    </td>
					    <td width='35%'> 
					    	<input name="sex" type="radio" value="sex" checked />男 
							<input name="sex" type="radio" value="sex" />女
					    </td>
					</tr>
					<tr bgcolor="#FFFFFF" align="center">
					    <td width='15%' name='projectName'> 
					    	奖助学名称
					    </td>
					    <td width='35%'> 
					    	<select name="awaName">
					    		<option>国家奖学金</option>
					    		<option>国家励志</option>
					    		<option>国家助学金</option>
					    		<option>校奖学金</option>
					    		<option>企业</option>
					    		<option>个人资助</option>
					    	</select>	
					    </td>
					</tr>
					<tr bgcolor="#FFFFFF" align="center">
					    <td width='15%'> 
					    	奖助学性质
					    </td>
					    <td width='35%'> 
					  		 <select name="awaProperty">
					    		<option>国家</option>
					    		<option>学校 </option>
					    		<option>企业资助</option>
					    		<option>个人资助</option>
					    	</select>	
					    </td>
					</tr>
					<tr bgcolor="#FFFFFF" align="center">
					    <td width='15%'> 
					    	审核状态
					    </td>
					    <td width='35%'> 
					  		 <select name="checkState">
					    		<option> 未提交</option>
					    		<option> 通过</option>
					    		<option>院级审核中</option>
					    		<option>校级审核中</option>
					    		<option>院级未通过</option>
					    		<option>校级未通过</option>
					    	</select>	
					    </td>
					</tr>
					<tr bgcolor="#FFFFFF" align="center">
							<!--使用juquery的时间插件-->
					    <td width='15%' name='projectName'> 
					    	获奖时间
					    </td>
					    <td width='35%'> 
					    	<select name="awardTime">
					    		<option>2011-2012</option>
					    		<option>2012-2013</option>
					    	</select>	
					    </td>
					</tr>
					<tr bgcolor="#FFFFFF" align="center">
							<!--使用juquery的时间插件-->
					    <td width='15%' name='projectName'> 
					    	获奖金额
					    </td>
					    <td width='35%'> 
					    	<input type="text" size="10" name="fare" id="fare" />
					    </td>
					</tr>
					<tr bgcolor="#FFFFFF" align="center">
							<!--使用juquery的时间插件-->
					    <td width='15%' name='projectName'> 
					    	本学年贫困等级
					    </td>
					     <td width='35%'> 
					    	<select name="prePovertyLevel">
					    		<option>甲等</option>
					    		<option>乙等</option>
					    		<option>丙等</option>
					    	</select>	
					    </td>
					</tr>
					<tr bgcolor="#FFFFFF" align="center">
							<!--使用juquery的时间插件-->
					    <td width='15%' name='projectName'> 
					    	上学年贫困等级
					    </td>
					     <td width='35%'> 
					    	<select name="PastPovertyLevel">
					    		<option>甲等</option>
					    		<option>乙等</option>
					    		<option>丙等</option>
					    	</select>	
					    </td>
					</tr>
            	
				</table>
        	</div>
    	</div>
    <form>
    	<!--曾获奖助学信息-->
    	<div id="pastSchInfoDiv" style="display: none"></div>
    		<div id="setSchStuBasicInfoDiv" style="display: none">
        	<h2>奖助学信息<a href="#" id="ClosePastSchInfo">关闭</a>
				</h2>
        	<div class="form">
            	<table width="100%" border="0" cellpadding="4"
						cellspacing="1" bgcolor="#464646" class="demo" id="pastAdvInfoTab">
						<thead>
            		<tr class="CTitle">
            			<td height="22" colspan="10" align="center"
									style="font-size: 16px">
            				学生曾获奖助学信息表
						</td>
					</tr>
            
					<tr bgcolor="#FFFFFF" align="center">
					    <td width='15%' name='projectName'> 
					    	奖助学名称
					    </td>
					    <td width='15%' name='projectName'> 
					    	性质
					    </td>
					    <td width='15%' name='projectName'> 
					    	荣获时间
					    </td>
					    <td width='20%' name='projectName'> 
					    	金额
					    </td>
					</tr>
					<tr bgcolor="#FFFFFF" align="center">
					    <td width='15%' name='projectName'> 
					    	国家励志奖学金
					    </td>
					    <td width='15%' name='projectName'> 
					    	国家级
					    </td>
					    <td width='15%' name='projectName'> 
					    	2011-5-30
					    </td>
					    <td width='20%' name='projectName'> 
					    	5000
					    </td>
					</tr>
            	
					</table>
        	</div>
    	</div>
</bo
																			dy>
</html>
