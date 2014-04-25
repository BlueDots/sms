<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
<title>My JSP 'class_advanceInfo.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生工作管理系统</title>

<link href="<%=basePath%>css/css.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/style.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/jquery-ui.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/arrow.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/tutor/tanchu.css">
<!-- 需要放到公共的js包下-->

<script src="<%=basePath%>js/jquery-1.10.2.js"></script>
<script src="<%=basePath%>/js/jquery.provincesCity.js"></script>
<script src="<%=basePath%>/js/jquery.chromatable.js"></script>
<script src="<%=basePath%>js/tutor/tutor_advanceInfo.js"></script>
<script src="<%=basePath%>js/college/college.js"></script>

<!--用于生成编辑的内容-->
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
	var menuids = [ "suckertree1"]
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
		window.addEventListener("load", buildsubmenus, false);
	else if (window.attachEvent)
		window.attachEvent("onload", buildsubmenus);
	
</script>

</head>

<script type="text/javascript">
	function getDefalutInfo(){
		window.location.href=encodeURI(encodeURI("stuAdvInfoAction!showStuAdvInfo?stuAdvVo.className=软件1111班&currentPage=1"));
	}
	function showStuAdvInfo(){
		   var condition = $("#condition").val();
		   var currentPage = 1;
		   if(condition!=""||condition!=""){
		   	if(!isNaN(condition)){
		   		window.location.href="stuAdvInfoAction!showStuAdvInfo?flag=true&stuAdvVo.studentNo="+condition+"&currentPage="+currentPage;
		   	}else{
		   		window.location.href="stuAdvInfoAction!showStuAdvInfo?flag=true&stuAdvVo.studentName="+condition+"&currentPage="+currentPage;
		   	}
		   }else{
		   	  alert("查询条件不能为空！");
		   	  return;	
		   }
	}
	
	function exportFile(){
		var filePath = "D://";
		window.location.href="stuAdvInfoAction!exportFile?abstractId=0100&outFilePath="+filePath;
		alert("导出成功:D://学生评优评先表.xls");
	}
	function showImportInfo(){
		var filePath = "D://outworkbook.xls";
		window.location.href="stuAdvInfoAction!importFile?flag=false&abstractId=0100&filePath="+filePath;
	}
	function ensureImportFile(){
		var filePath = "D://outworkbook.xls";
		window.location.href="stuAdvInfoAction!importFile?flag=true&abstractId=0100&filePath="+filePath;
		alert("导入成功！");
	}
	
	$(document).ready(function() {
		//window.location.href=encodeURI(encodeURI("stuAdvInfoAction!showStuAdvInfo?stuAdvVo.className=软件1111班&currentPage=1"));
		
		/*精确查询*/
		$("#accurateSearch").click(function() {
		   showStuAdvInfo();
		});
		/*下一页*/
		$("#nextPage").click(function() {
		   window.location.href="stuAdvInfoAction?stuAdvVo.studentNo=20111826&currentPage=2";
		  });
		  /*确定导入*/
		 $('#ensureImportFile').click(function(){
			var filePath = "D://outworkbook.xls";
			window.location.href="stuAdvInfoAction!importFile?flag=true&abstractId=0100&filePath="+filePath;
			alert("导入成功！");
			//alert("11111");
			$(this).parents('#stuAdvInfoForm') // For each element, pick the ancestor that's a form tag.
				.find(':input') // Find all the input elements under those.
			    .each(function(i) {
				$("input").attr("readonly","readonly");
				$(this).removeClass("readonly");
			});	
			
		});
		$("#tableID").chromatable({
			width : "100%",

			scrolling : "yes"
		});

	});
</script>

<script language=JavaScript>
	
	function sousuo() {
		window
				.open(
						"gaojisousuo.htm",
						"",
						"depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
	}
	 
</script>

<body>
	 
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
											width="20" height="18" />
										</td>
										<td width="75%">
										<form id="collegeList" >
												<input type="button" value="查询" id="accurateSearch">
										</form>
										</td>
										<td width="9%" align="left">
											<div class="suckerdiv" style="padding-right:-20px">
												<ul id="suckertree1">
													<li><a href="#">信息管理</a>
														<ul>
															<li><a>编辑</a>
																<ul>
																	<li><a onclick="importFile()" id='manuallyId'>修改</a>
																	</li>
																	<li><a onclick=''>删除</a>
																	</li>
																</ul>
															</li>
															<li><a>录入</a>
																<ul>
																	<li><a onclick="manually()" id='manuallyId'>手动录入</a>
																	</li>
																	<li>
																		<input type="file" name="import" onchange="showImportInfo()" />
																	</li>
																</ul>
															</li>
														</ul>
													</li>
												</ul>
											</div>
										</td>
										<td width="7%" align="left"><input name="advanced_search"
											type="button" class="right-button07" value="高级搜索"
											onclick="popup('#advancedDiv', '#advancedSearchDiv', '#CloseadvancedSearch')" />
										</td>
										<td width="7%" align="left"><input name="export"
											type="button" class="right-button07" value="导出"
											onclick="exportFile()" />
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
									<div id="liulanbiao" style="margin-left: 10px">
										<table width="99%" border="0" cellpadding="0" cellspacing="0"
											class="CContent">
											<tr>
												<th class="tablestyle_title">当前位置：评优评先页面</th>
											</tr>
											<tr>
												<td class="CPanel">
													<table width="100%" border="0" align="center"
														cellpadding="0" cellspacing="0">

														<tr>
															<td height="40" class="font42">
																<table width="100%" border="0" cellpadding="4"
																	cellspacing="1" bgcolor="#464646" class="demo"
																	id="stuAdvInfoTab">
																	<thead>
																		<tr class="CTitle">
																			<td height="22" colspan="12" align="center"
																				style="font-size: 16px">评优评先信息表</td>
																		</tr>
																		<tr bgcolor="#EEEEEE" align="center">
																			<th width="2%"><center>
																					<input type="checkbox" id="choice" onClick="selectAllAndReverse('stuAdvInfoTab')"/>
																				</center></th>
																			<th width="3%">
																				<center>学号</center>
																			</th>
																			<th width="3%">
																				<center>姓名</center>
																			</th>
																			<th width="3%">
																				<center>性别</center>
																			</th>
																			<th width="5%">
																				<center>学院</center>
																			</th>
																			<th width="10%">
																				<center>专业方向</center>
																			</th>
																			<th width="5%">
																				<center>班级</center>
																			</th>
																			<th width="8%">
																				<center>先进项目</center>
																			</th>
																			<th width="5%">
																				<center>获奖时间</center>
																			</th>
																			<th width="7%">
																				<center>级别</center>
																			</th>
																			<th width="7%">
																				<center>审核状态</center>
																			</th>
																			<th width="3%">
																				<center>备注</center>
																			</th>
																		</tr>
																	</thead>
																	
																	<s:iterator value="#request['listStuAdvVo']" id="advInfo" status="status">
																		<tr bgcolor="#FFFFFF" align="center">
																			<td><input type="checkbox" /></td>
																			<td><a href="#"
																				onclick="popup('#pastAdvInfoDiv', '#setSchStuBasicInfoDiv', '#ClosePastAdvInfo')"><s:property value="#advInfo.studentNo"/></a>
																			</td>
																			<td><s:property value="#advInfo.studentName"/></td>
																			<td>
																			<s:if test="#advInfo.sex==1">
																			女
																			</s:if>
																			<s:else>
																			男	
																			</s:else>
																			</td>
																			<td><s:property value="#advInfo.college"/></td>
																			<td><s:property value="#advInfo.major"/></td>
																			<td><s:property value="#advInfo.className"/></td>
																			<td><s:property value="#advInfo.advanceActivity"/></td>
																			<td><s:property value="#advInfo.advTime"/></td>
																			<td><s:property value="#advInfo.advLevel"/></td>
																			<td><s:property value="#advInfo.examState"/></td>
																			<td><br></td>
																		</tr>
																</s:iterator>
															<form id="stuAdvInfoForm" action="" method="get">
																<s:iterator value="#request['inputStuAdvVos']" id="inputadvInfo" status="status">
																		<tr bgcolor="#FFFFFF" align="center">
																			<td><input type="checkbox" /></td>
																			<td><input style="width:100px" type="text" value=<s:property value="#inputadvInfo.studentNo" />></td>
																			<td><input style="width:100px" type="text" value=<s:property value="#inputadvInfo.studentName" />></td>
																			<td>
																			<select name="sex">
																				<s:if test="#advInfo.sex==1">
																					<option selected="selected">女</option>
																					<option>男</option>
																			</s:if>
																			<s:else>
																					<option>女</option>
																					<option selected="selected">男</option>
																			</s:else>
																			</select>
																			</td>
																			<td><input style="width:100px" type="text" value=<s:property value="#inputadvInfo.college" />></td>
																			<td><input style="width:100px" type="text" value=<s:property value="#inputadvInfo.major" />></td>
																			<td><input style="width:100px" type="text" value=<s:property value="#inputadvInfo.className" />></td>
																			<td><input style="width:100px" type="text"  value=<s:property value="#inputadvInfo.advanceActivity" />></td>
																			<td><input style="width:100px" type="text"  value=<s:property value="#inputadvInfo.advTime" />></td>
																			<td><input style="width:100px" type="text"  value=<s:property value="#inputadvInfo.advLevel" />></td>
																			<td><input style="width:100px" type="text"  value=<s:property value="#inputadvInfo.examState" />></td>
																			<td><br></td>
																		</tr>
											
																</s:iterator>
															</form>
																</table>
															</td>
														</tr>
													</table>
													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0">
														<tr>
															<td height="6"><img src="../../images/spacer.gif"
																width="1" height="1" />
															</td>
														</tr>
														<tr>
															<td height="33">
																<table width="100%" border="0" align="center"
																	cellpadding="0" cellspacing="0" class="right-font08">
																<s:if test="#request['inputStuAdvVos'] == null">
																	<tr>
																		<td width="50%">共 <span class="right-text09"><s:property value="#pageVo.pageNum"/></span>
																			页 | 第 <span class="right-text09"><s:property value="#pageVo.currentPage"/></span> 页</td>
																		<td width="49%" align="right">[ <a href="#"
																			class="right-font08">首页</a> | <a href="#"
																			class="right-font08">上一页</a> | <a href="#"
																			class="right-font08">下一页</a> <a href="stuAdvInfoAction?currentPage=<s:property value="#pageVo.pageNum"/>"
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
																			</table>
																		</td>
																	</tr>
																</s:if>
																<s:else>
																	<tr align="right">
																		<input type="button" id="ensureImportFile" value="确定" />
																		&nbsp;&nbsp;&nbsp;
																		<input type="button" id="cancel" value="取消" onclick="showStuAdvInfo()" />  
																	</tr>
																</s:else>
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
			<h2>
				高级查询选项<a href="#" id="CloseadvancedSearch">关闭</a>
			</h2>
			<div class="form">
				<table width="50%" border="0" cellpadding="4" cellspacing="1"
					bgcolor="#464646" class="demo" id="advancedSearchTab">
					<thead>

						<tr bgcolor="#FFFFFF" align="center">
							<td width='15%'>性别</td>
							<td width='35%' name='sex'><input name="sex" type="radio"
								value="sex" checked />男 <input name="sex" type="radio"
								value="sex" />女</td>
						</tr>
						<tr bgcolor="#FFFFFF" align="center">
							<td width='15%' name='projectName'>先进项目</td>
							<td width='35%'><select name="awardTitle">
									<option>优秀三好学生</option>
									<option>最佳三好学生</option>
									<option>优秀学生干部</option>
									<option>最佳学生干部</option>
									<option>优秀团员</option>
									<option>优秀团干部</option>
									<option>最佳学生干部</option>
							</select>
							</td>
						</tr>
						<tr bgcolor="#FFFFFF" align="center">
							<td width='15%'>级别</td>
							<td width='35%'><select name="awardLevel">
									<option>院级</option>
									<option>校级</option>
									<option>厅级</option>
									<option>省级</option>
									<option>国家级</option>
							</select>
							</td>
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
							</select>
							</td>
						</tr>
						<tr bgcolor="#FFFFFF" align="center">
							<!--使用juquery的时间插件-->
							<td width='15%'>获奖时间</td>
							<td width='35%'><select name="awardTerm">
									<option>2011-2012</option>
									<option>2012-2013</option>
							</select>
							</td>
						</tr>
				</table>
			</div>
		</div>
	</form>
	<!--曾获荣誉查询-->
	<div id="pastAdvInfoDiv" style="display: none"></div>
	<div id="setSchStuBasicInfoDiv" style="display: none">
		<h2>
			评优评先<a href="#" id="ClosePastAdvInfo">关闭</a>
		</h2>
		<div class="form">
			<table width="100%" border="0" cellpadding="4" cellspacing="1"
				bgcolor="#464646" class="demo" id="pastAdvInfoTab">
				<thead>
					<tr class="CTitle">
						<td height="22" colspan="10" align="center"
							style="font-size: 16px">学生曾获荣誉信息表</td>
					</tr>

					<tr bgcolor="#FFFFFF" align="center">
						<td width='15%' name='projectName'>先进项目类型</td>
						<td width='15%' name='projectName'>级别</td>
						<td width='15%' name='projectName'>时间</td>
						<td width='20%' name='projectName'>备注</td>
					</tr>
					<tr bgcolor="#FFFFFF" align="center">
						<td width='15%' name='projectName'>优秀三好学生</td>
						<td width='15%' name='projectName'>校级</td>
						<td width='15%' name='projectName'>2011-5-30</td>
						<td width='20%' name='projectName'>无</td>
					</tr>
					<tr bgcolor="#FFFFFF" align="center">
						<td width='15%' name='projectName'>优秀学生干部</td>
						<td width='15%' name='projectName'>校级</td>
						<td width='15%' name='projectName'>2012-4-23</td>
						<td width='20%' name='projectName'>无</td>
					</tr>
			</table>
		</div>
	</div>
	<s:debug></s:debug>
</body>
<script src="<%=basePath%>js/util/loadCollegeClass.js"></script>
</html>
