<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>学生工作管理系统</title>
<link href="<%=basePath%>css/css.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/college/tanchu.css">
<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/arrow.css" rel="stylesheet" type="text/css" />

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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

</head>



<body>
	 
			<table width="100%" border="0" cellspacing="0" cellpadding="0">

				<tr>
					<td height="30">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="62" background="<%=basePath %>images/nav04.gif">

									<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
										<tr>
											<td width="2%">
												<img src="<%=basePath%>images/ico07.gif" width="20" height="18" />
											</td>
											<td width="538">
										 <form action="<%=basePath%>scholarShip/scholarShip!showSchloarShipForTeacher" id="collegeList" method="post" onsubmit="if(($('#className').val()=='-1'||$('#className').val()==undefined)){alert('需要选择班级和学期');return false;}">
													 
													 <input type="submit" value="查询" id="accurateSearch">
												</form>
												 
											</td>
											<s:if test="%{#session.roles[0].roleName!='班主任'}">
																		 <s:set name="flag" value="1"/>
												 </s:if>
												 <s:else><s:set name="flag" value="0"/></s:else>
											<td width="15%" align="center" style="position:relative;left:-80px">
												<div class="suckerdiv">
													<ul id="suckertree1">
														<li>
															<a href="#">信息管理</a>
															<ul>
																<li>
																	<a href="#">编辑</a>
																	<ul>
																		<li>
																			<a onclick="updateData('<s:property value="#flag"/>')"  >修改</a>
																		</li>																		
																		<li>
																			<a onclick="edit()" href="#">删除</a>
																		</li>																		
																	</ul>	
																</li>
																<li>
																	<a  href="#">录入</a>
																	<ul>
																 
																		<li>
																		
														
																			<a   onclick="addMoreColumn('<s:property value="#flag"/>')">手动录入</a>
																		</li>
																		<li>
																			<a href="#">导入</a>
																		</li>																		
																	</ul>
																</li>
																<li>
																	<a href="dept_scholarshipAssess/dept_scholarshipAssess_proportion.html">分配比例</a>
																</li>																	
															</ul>
														</li>
													</ul>
												</div>
											</td>
											<td width="6%" align="center">

												<a > <input name="Submit3"
														type="button" class="right-button07" value="高级搜索" onclick="$('#advancedSearchDiv').show()"/> </a>
											</td>

											</td>											
											<td width="6%" align="center">
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
				
					
						<div style="display: block">
							<table id="subtree1" style="DISPLAY: <s:if test="%{#request.pageVo=null}">none</s:if>;" width="100%" border="0"
								cellspacing="0" cellpadding="0">
								<tr>
									<td class="CPanel">
										<div id="liulanbiao" style="margin-left: 10px">
											<table width="99%" border="0" cellpadding="0" cellspacing="0"
												class="CContent">
												<tr>
													<th class="tablestyle_title">
														当前位置：<a href="<%=basePath%>/files/college/dept_scholarshipAssess.jsp">首页</a><span style="position:relative;left:950px"><a href="dept_scholarshipAssess/dept_scholarshipAssess_verify.html"><font color = "red" >待审核信息</font></a>(3)</span>
													</th>
													 
												</tr>
												<tr id="editMsg"  style="display:none">
													<td  class="CPanel" align="center">
														<form action="scholarShip/scholarShip!addSchloarShip" method = "post" onsubmit="return checkFormDate();">
														
														<input type="hidden" name="college" id="CollegeForAdd">
														<input type="hidden" name="className" id="CollegeForclassName" >
														
														<div style="overflow-x: auto; overflow-y: auto;width:98%;">
														<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" id="entryScholarshipAssessInfo">
															<tr>
																<td height="40" class="font42">
																
															 <table border="0" cellpadding="4"
																		cellspacing="1" bgcolor="#464646" class="demo" id = "">
																		<tr class="CTitle" align = "center">
																			<td height="22" colspan="15" align="center"
																				style="font-size: 16px">
																				学生奖学金信息录入表
																			</td>
																		</tr>
                                                                 <tr bgcolor="#EEEEEE" align = "center">
                                                                  <td rowspan="3" style="width:60px "> 学号 </td>
                                                                  <td   rowspan="3"> 学期 </td>
                                                                  <td colspan="3"  > 德育素质测评（20%）</td>
                                                                  <td colspan="3"  > 智育素质测评（60%）</td>
                                                                  <td colspan="3"  >体育素质测评（5%）</td>
                                                                  <td colspan="4" >美育素质测评（15%）</td>
                                                           
                                                                   
                                                                </tr>
                                                                <tr bgcolor="#EEEEEE" align = "center">
                                                                  <td rowspan="2">基准分</td>
                                                                  <td   rowspan="2">奖励分</td>
                                                                  <td  rowspan="2">惩罚分</td>
                                                               
                                                                  <td  rowspan="2" >学业课程分</td>
                                                                  <td   rowspan="2">科技活动与创新分</td>
                                                                  <td   rowspan="2">职业技能分</td>
                                                                  
                                                                  <td   rowspan="2">体育课程分</td>
                                                                  <td  rowspan="2">体育健康分</td>
                                                                  <td  rowspan="2">体育竞赛分</td>
                                                                  
                                                                  <td  rowspan="2">美育管理艺术分</td>
                                                                  <td  rowspan="2">美育文化艺术分</td>
                                                                  <td   rowspan="2">美育媒体艺术分</td>
                                                                  <td  rowspan="2">美育实践服务分</td>
                                                                </tr> 
                                                                  
															                                                                                   
																</table>
																
																</td>
															 
															</tr>	
															
															
														</table>
														</div>
														</form>
													</td>
												</tr>												
												<tr id="">
													<td class="CPanel">
														
														
														<table width="100%" border="0" align="center"
															cellpadding="0" cellspacing="0" id="allbasicMsg">
															
															<tr>
															  <td height="40" class="font42"><table width="100%" border="0" cellpadding="4"
																		cellspacing="1" bgcolor="#464646" class="newfont03">
                                                            <tr class="CTitle">
                                                                 <td height="22" colspan="26" align="center"
																				style="font-size: 16px">  班级:<s:property value="#request.scholars[0].student.className"/>学期:<s:property value="#request.scholars[0].term"/>奖学金信息表 </td>
                                                                </tr>
                                                                <tr bgcolor="#EEEEEE" align = "center">
                                                                  <td width="2%" rowspan="3"> <input type="checkbox"  /> </td>
                                                                  <td width="4%" rowspan="3"> 学号 </td>
                                                                  <td width="3%" rowspan="3"> 姓名 </td>
                                                                  <td colspan="4"> 德育素质测评（20%）</td>
                                                                  <td colspan="5"> 智育素质测评（60%）</td>
                                                                  <td colspan="4">体育素质测评（5%）</td>
                                                                  <td colspan="4">美育素质测评（15%）</td>
                                                                  <td colspan="2" rowspan="2">综合测评</td>
                                                                  <td width="2%" rowspan="3"> 奖学金等级</td>
                                                                  <td width="2%" rowspan="3">状态</td>
                                                                   <td width="2%" rowspan="3">备注</td>
                                                                </tr>
                                                                <tr bgcolor="#EEEEEE" align = "center">
                                                                  <td width="4%" rowspan="2">基准分</td>
                                                                  <td width="4%" rowspan="2">奖励分</td>
                                                                  <td width="4%" rowspan="2">惩罚分</td>
                                                                  <td width="3%" rowspan="2">得分</td>
                                                                  <td colspan="2">学业课程分</td>
                                                                  <td width="3%" rowspan="2">科技活动与创新分</td>
                                                                  <td width="3%" rowspan="2">职业技能分</td>
                                                                  <td width="2%" rowspan="2">得分</td>
                                                                  <td width="3%" rowspan="2">体育课程分</td>
                                                                  <td width="3%" rowspan="2">体育健康分</td>
                                                                  <td width="2%" rowspan="2">体育竞赛分</td>
                                                                  <td width="2%" rowspan="2">得分</td>
                                                                  <td width="2%" rowspan="2">美育管理艺术分</td>
                                                                  <td width="2%" rowspan="2">美育文化艺术分</td>
                                                                  <td width="2%" rowspan="2">美育媒体艺术分</td>
                                                                  <td width="3%" rowspan="2">美育实践服务分</td>
                                                                </tr>
                                                                <tr bgcolor="#EEEEEE" align = "center">
                                                                  <td width="6%">必修课成绩</td>
                                                                  <td width="7%">公选课惩罚分</td>
                                                                  <td width="2%">总得分</td>
                                                                  <td width="4%">排名</td>
                                                                  
                                                                </tr>
                                                             <s:iterator value="#request.scholars">
                                                                <tr bgcolor="#FFFFFF" align = "center">
                                                                  <td><input type="checkbox" name="oprechebox" value="state=<s:property value="exameState"/>,studentNo=<s:property value="student.studentNo"/>&term=<s:property value="term"/>" /></td>
                                                                  <td><a onclick="getOneStudentSchloar('<s:property value="student.studentNo"/>')"><s:property value="student.studentNo"/></a> </td>
                                                                  <td> <s:property value="student.studentName"/></td>
                                                                  <td ><s:property value="baseScore"/></td>
                                                                  <td><s:property value="awardScore"/></td>
                                                                  <td><s:property value="punishScore"/></td>
                                                                  <td><s:property value="moralQualityAssessmentScore"/></td>
                                                                  <td><s:property value="lessonScore"/></td>
                                                                  <td>0</td>
                                                                  <td><s:property value="innovateScore"/></td>
                                                                  <td><s:property value="skillsScore"/></td>
                                                                  <td><s:property value="qualityScore"/></td>
                                                                  <td><s:property value="sportScore"/></td>
                                                                  <td><s:property value="physiqueScore"/></td>
                                                                  <td><s:property value="sportMatchScore"/></td>
                                                                  <td><s:property value="sportQualityTotalScore"/></td>
                                                                  <td><s:property value="manageScore"/></td>
                                                                  <td><s:property value="cultureScore"/></td>
                                                                  <td><s:property value="mediaScore"/></td>
                                                                  <td><s:property value="serviceScore"/></td>
                                                                  <td><s:property value="totalScore"/></td>
                                                                  <td><s:property value="totalScoreRank"/></td>
                                                                
                                                                  <td><s:property value="rank"/></td>
                                                                    <td><s:property value="exameState"/></td>
  																	<td><s:property value="remarks"/></td>
                                                                </tr>
                                                                </s:iterator>
															
														</table>
														<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
															<tr>
																<td height="6">
																	<img src="<%=basePath%>images/spacer.gif" width="1" height="1" />
																</td>
															</tr>
															<tr>
																<td height="33">
																	<table width="100%" border="0" align="center"
																		cellpadding="0" cellspacing="0" class="right-font08">
																		<tr>
																			<td width="50%">
																				共
																				 
																				<span class="right-text09"><s:property value="#request.pagevo.pageNum"/></span> 页 | 第
																				<span class="right-text09"><s:property value="#request.pagevo.currentPage"/></span> 页
																			</td>
																			<td width="49%" align="right">
																		<form action="<%=basePath%>scholarShip/scholarShip!showSchloarShipForTeacher" method="post">
																				<input type="hidden"	id="currentPage" name="currentPage">
																				<input type="hidden"	 name="department" value="<s:property value="#request.params['college']"/>">
																				<input type="hidden"	 name="major" value="<s:property value="#request.params['major']"/>">
																				<input type="hidden"	 name="className" value="<s:property value="#request.params['className']"/>">
																				<input type="hidden"	 name="term" value="<s:property value="#request.params['term']"/>">
																				 
																			 	[
																				<a onclick="$('#currentPage').val(1);$(this).closest('form').submit();" class="right-font08">首页</a> |
																				<a onclick="$('#currentPage').val(<s:property value="#request.pagevo.currentPage-1"/>);$(this).closest('form').submit();"  class="right-font08">上一页</a> |
																				<a  onclick="$('#currentPage').val(<s:property value="(#request.pagevo.currentPage+1)<#request.pagevo.pageNum?(#request.pagevo.currentPage+1):#request.pagevo.pageNum"/>);$(this).closest('form').submit();" class="right-font08">下一页</a> |
																				<a onclick="$('#currentPage').val(<s:property value="#request.pagevo.pageNum"/>);$(this).closest('form').submit();" class="right-font08">末页</a>] 
																			</form>
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
	 

  <form action="<%=basePath%>scholarShip/scholarShip!querySchloarShipForTeacher" method="post">
    	<div id="advancedSearchDiv" style="display: none">
             	<h2>高级查询选项<a   id="CloseadvancedSearch" onclick="$('#advancedSearchDiv').hide();">关闭</a></h2>
        	<input type="hidden" id="qdepartment" name="department"/>
            		<input type="hidden" id="qmajor" name="major"/>
            		<input type="hidden" id="qclass" name="className"/>
            		<input type="hidden" id="qterm" name="term"/>
        	<div class="form">
            	<table width="50%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="demo" id="advancedSearchTab" ><thead>
            		
					<tr bgcolor="#FFFFFF" align="center">
					    <td width='15%'> 
					    	性别
					    </td>
					    <td width='35%' name='sex'> 
					    	<input name="sex" type="radio" value="0" checked />男 
							<input name="sex" type="radio" value="1" />女
							<input name="sex" type="radio"   />全部
					    </td>
					</tr>
					<tr bgcolor="#FFFFFF" align="center">
					    <td width='15%'> 
					    	奖学金等级
					    </td>
					    <td width='35%'> 
					    	<select name="advLevel">
					    		<option>全部</option>
					    		<option value="一等奖">一等</option>
					    		<option value="二等奖">二等</option>
					    		<option value="三等奖">三等</option>
					    		
					    	</select>	
					    </td>
					</tr>
					<tr bgcolor="#FFFFFF" align="center">
					    <td width='15%'> 
					    	排名
					    </td >
					    <td width='35%'> 
					  		前<input name="advRank" type="text"   />
					    </td>
					</tr>
					<tr bgcolor="#FFFFFF" align="center">
					    <td width='15%'> 
					    	总得分
					    </td >
					    <td width='35%'> 
					  		 <select name="advScore">
					  		 	<option  >全部</option>
					    		<option value="90">优秀(90以上)</option>
					    		<option value="80">良好(80以上)</option>
					    		<option value="60">及格(60以上)</option>
					    		<option value="40">不及格(60以下)</option>
					    	</select>	
					    </td>
					</tr>
					<tr bgcolor="#FFFFFF" align="center">
						<td colspan="2"><input type="button" value="查询" onclick="if(($('#className').val()=='-1'||$('#className').val()==undefined)){alert('需要选择班级和学期');return;};$('#qdepartment').val($('#department').val());$('#qmajor').val($('#major').val());$('#qclass').val($('#className').val());$('#qterm').val($('#term').val());$(this).closest('form').submit();"/></td>
					</tr>
            	</table>
        	</div>
    	</div>
</form>


<form action="scholarShipUpdate/scholarShipUpdate!updateStudentScholarShip" method="post">
<input type="hidden" name="classGrantState" id="studentNoForModify" >
<input type="hidden" name="examState" id="examStateForModify" >
<input type="hidden" name="term" id="termForModify">
<!--修改班级奖学金-->
    	<div id="modifyDiv" style="display: none;" align="center"></div>
    		<div id="modifyInfoDiv" style="display: none;" align="center">
        	<h2>奖学金信息<a  onclick="$('#modifyDiv').hide();$('#modifyInfoDiv').hide();" id="CloseModidyInfo">关闭</a></h2>
        	<div class="form">
            	<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="demo" id="modifyAdvInfoTab" ><thead>
            		<tr class="CTitle">
            			<td height="22" colspan="13" align="center" style="font-size: 16px">
            				修改<font id="modiftName"></font>奖学金
						</td>
					</tr>
            
				 <tr bgcolor="#EEEEEE" align = "center">
                      <td >基准分</td>
                      <td   >奖励分</td>
                      <td  >惩罚分</td>
            
                      <td  >学业课程分</td>
                      <td   >科技活动与创新分</td>
                             <td  >职业技能分</td>
             
                        <td >体育课程分</td>
                     <td  >体育健康分</td>
                     <td  >体育竞赛分</td>
               
                       <td  >美育管理艺术分</td>
                       <td   >美育文化艺术分</td>
                    <td   >美育媒体艺术分</td>
                    <td >美育实践服务分</td>
                  </tr>
					<tr bgcolor="#FFFFFF" align="center">
					      <td><input name="baseScore" value="0"  id="mbaseScore" style="width: 100%"></td>
                        <td   ><input name="awardScore" value="0"  id="mawardScore" style="width: 100%"></td>
                      <td  ><input name="punishScore" value="0"  id="mpunishScore" style="width: 100%"></td>
            
                      <td ><input name="lessonScore" value="0"  id="mlessonScore" style="width: 100%" ></td>
                      <td   ><input name="innovateScore" value="0"  id="minnovateScore" style="width: 100%"></td>
                       <td ><input name="skillsScore" value="0"  id="mskillsScore" style="width: 100%"></td>
             
                        <td ><input name="sportScore" value="0"  id="msportScore" style="width: 100%"></td>
                     <td ><input name="physiqueScore" value="0"  id="mphysiqueScore" style="width: 100%"></td>
                     <td ><input name="sportMatchScore" value="0"  id="msportMatchScore" style="width: 100%"></td>
               
                       <td ><input name="manageScore" value="0"  id="mmanageScore"style="width: 100%" ></td>
                       <td   ><input name="cultureScore" value="0"  id="mcultureScore" style="width: 100%"></td>
                    <td    ><input name="mediaScore" value="0"  id="mmediaScore" style="width: 100%"></td>
                    <td  id="mserviceScore"><input name="serviceScore" value="0"  id="serviceScore"style="width: 100%" ></td>
					</tr>
					 <tr bgcolor="#FFFFFF" align="center">
					      <td colspan="6"><input type="submit" value="提交"></td>
                          <td colspan="7"><input type="reset" value="重置"></td>
                    
					</tr>
            	</table>
        	</div>
    	</div>
</form>
    
    
    	<!--曾获班级奖学金-->
    	<div id="assessInfoDiv" style="display: none" align="center"></div>
    		<div id="setSchStuBasicInfoDiv" style="display: none" align="center">
        	<h2>奖学金信息<a  onclick="$('#assessInfoDiv').hide();$('#setSchStuBasicInfoDiv').hide();" id="ClosePastAssInfo">关闭</a></h2>
        	<div class="form">
            	<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="demo" id="pastAdvInfoTab" ><thead>
            		<tr class="CTitle">
            			<td height="22" colspan="10" align="center" style="font-size: 16px">
            				学生奖学金信息表
						</td>
					</tr>
            
					<tr bgcolor="#FFFFFF" align="center">
					    <td width='10%' name="assTerm"> 
					    	学期
					    </td>
					    <td width='15%' name="totalScore"> 
					    	德育素质得分
					    </td>
					     <td width='15%' name="totalScore"> 
					    	智育素质得分
					    </td>
					     <td width='15%' name="totalScore"> 
					    	体育素质得分
					    </td>
					     <td width='15%' name="totalScore"> 
					    	美育素质得分
					    </td>
					    <td width='15%' name="totalScore"> 
					    	总得分
					    </td>
					    <td width='10%' name="assLevel"> 
					    	奖学金等级
					    </td>
					    <td width='5%' name="assRank"> 
					    	排名
					    </td>
					</tr>
					 
					 
            	</table>
        	</div>
    	</div>
	</body>
	
</body>
<script src="<%=basePath%>js/jquery-1.10.2.js"></script>
<script src="<%=basePath%>js/college/college.js"></script>
<script src="<%=basePath%>js/college/entry.js"></script>
<script type="text/javascript" src="<%=basePath%>js/util/loadCollegeClass.js"></script>
<script type="text/javascript" src="<%=basePath%>js/college/xionganping_schloarship.js"></script>
<script type="text/javascript">
   
   $(document).ready(function(){ 
 	
	$("#tableID").chromatable({
		width: "100%",
	 
          scrolling: "yes"
	});

	});



</script>
</html>
