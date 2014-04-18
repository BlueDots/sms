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

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>学生工作管理系统</title>
	
		<link href="<%=basePath%>css/css.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css/college/tanchu.css">
		<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
		<link href="<%=basePath%>css/arrow.css" rel="stylesheet" type="text/css" />

<style type="text/css">
*{margin:0;padding:0;list-style-type:none;}
.demo{border:solid 1px #D5D5D5;border-collapse:collapse;width:100%;}
.demo td{border:1px solid #D5D5D5;font-size:12px;padding:7px 5px;}
.demo th{background-color:#EEE;border-right:1px solid #D5D5D5;font-size:13.5px;line-height:120%;font-weight:bold;padding:8px 5px;text-align:left;
}
 
</style>
<script src="<%=basePath%>js/jquery-1.10.2.js"></script>
<script src="<%=basePath%>js/jquery.chromatable.js"></script></script>
<script src="<%=basePath%>js/college/college.js"></script>
<script src="<%=basePath%>js/college/entry.js"></script>
<script type="text/javascript">
   $(document).ready(function(){ 
 	getStuBasicInfoList(1);
	$("#tableOfShowStuBasicInfoLists").chromatable({
		width: "100%",
        scrolling: "yes"
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
								<td height="62" background="<%=basePath%>images/nav04.gif">

									<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
										<tr>
											<td width="2%">
												<img src="<%=basePath%>images/ico07.gif" width="20" height="18" />
											</td>
											<td width="70%">
												学院：
												<select name="学院">
													<option>
														软件学院
													</option>
													<option>
														马克思主义学院（政治学院）
													</option>
												</select>
												专业：
												<select name="专业">
													<option>
														请选择
													</option>
													<option>
														软件工程
													</option>
													<option>
														数字媒体
													</option>
													<option>
														软件英语
													</option>
												</select>
												班级：
												<select name="班级">
													<option>
														请选择
													</option>
													<option>
														1101
													</option>
													<option>
														1102
													</option>
													<option>
														1103
													</option>
													<option>
														1104
													</option>													
												</select>
												<input name="textfield" type="text" size="16" value="请输入学号或者姓名" />
												<input name="Submit4" type="button" class="right-button02"
													value="查 询" />
													排序
												<select name="排序">
													<option>
														学号升序
													</option>
													<option>
														学号降序
													</option>
												</select>
											</td>
											<td width="15%" align="center" style="position:relative;left:-80px">
												<div class="suckerdiv">
													<ul id="suckertree1">
														<li>
															<a >信息管理</a>
															<ul>
																<li>
																	<a >编辑</a>
																	<ul>
																		<li>
																			<a onclick="edit()" >修改</a>
																		</li>																		
																		<li>
																			<a onclick="edit()" >删除</a>
																		</li>																		
																	</ul>	
																</li>
																<li>
																	<a  href="">录入</a>
																	<ul>
																		<li>
																			<a href="#" onclick="manually('entryStuBasicInfo')">手动录入</a>
																		</li>
																		<li>
																			<a href="#">导入</a>
																		</li>																		
																	</ul>
																</li>																		
															</ul>
														</li>
													</ul>
												</div>
											</td>
											<td width="6%" align="center">

												<a onclick="sousuo()"> <input name="Submit3"
														type="button" class="right-button07" value="高级搜索"  onclick="popup('#advancedDiv', '#advancedSearchDiv', '#CloseadvancedSearch')" id='advancedBtn'/> </a>
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
					<td id = "main">
						<div  style="display: block">
							<table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
								
								<tr>
									<td class="CPanel">
										<div id="liulanbiao" style="margin-left: 10px">
											<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
												<tr>
													<th class="tablestyle_title">
														当前位置：学生基本信息<span style="position:relative;left:950px"><a href="<%=basePath%>files/college/dept_basicInfo/dept_basicInfo_verify.jsp"><font color = "red" >待审核信息</font></a>(3)</span>
													</th>
												</tr>
												<tr id="editMsg"  style="display:none">
													<td  class="CPanel" align="center">
														<div style="overflow-x: auto; overflow-y: auto;width:100%;">
														<table width="150%" border="0" align="center" cellpadding="0" cellspacing="0">
															<tr>
																<td height="40" class="font42">
																	<form action="" method = "post">
																	
																	<table border="0" cellpadding="4"
																		cellspacing="1" bgcolor="#464646" class="demo" id = "entryStuBasicInfo">
																		<tr class="CTitle" align = "center">
																			<td height="22" colspan="17" align="center"
																				style="font-size: 16px">
																				学生基本信息录入表
																			</td>
																		</tr>
																		<tr bgcolor="#EEEEEE" align = "center">
																			<th width="3%" >
																				<center>照片</center>
																			</th>																				
																			<th width="4%">
																				<center>学号</center>
																			</th>
                                                                            <th width="3%">
																				<center>姓名</center>
																			</th>
																			<th width="5%">
																				<center>专业</center>
																			</th>
																			<th width="5%">
																				<center>班级</center>
																			</th>
																			<th width="3%">
																				<center>性别</center>
																			</th>
																			<th width="3%">
																				<center>民族</center>
																			</th>
																			<th width="3%">
																				<center>籍贯</center>
																			</th>
																			<th width="5%">
																				<center>政治面貌</center>
																			</th>
																			<th width="7%">
																				<center>身份证号码</center>
																			</th>
																			<th width="4%">
																				<center>学历</center>
																			</th>
																			<th width="5%">
																				<center>英语等级</center>
																			</th>																			
																			<th width="7%">
																				<center>银行卡号</center>
																			</th>		
																		</tr>
																		<tr bgcolor="#EEEEEE" align = "center" >
																			<td colspan="13" style="padding:1px">
																				<button type="button">提交</button>
																				<button type="button" onclick="exchange('allbasicMsg','editMsg')">取消</button>
																			</td>
																		</tr>
																	</table>
																</form>
																</td>
																
															</tr>	
														</table>
														</div>
													</td>
												</tr>
												<tr id="allbasicMsg" >

													<td class="CPanel" align="center" width="1300">
														<table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
														
														
														
															<!--显示学生基本信息列表  -->
															<tr id="mainShow" style="display:block">
																<td height="40" class="font42">
																	<table width="1300" border="0" cellpadding="4"
																		cellspacing="1" bgcolor="#464646" class="demo" id="tableOfShowStuBasicInfoLists" >
																			
																		<tr class="CTitle" align = "center">
																			<td height="22" colspan="17" align="center"
																				style="font-size: 16px">
																				班级信息 共50人，男生30人，女人20人。
																			</td>
																		</tr>
																		<tr bgcolor="#EEEEEE" align = "center">
																			<td width="2%">
																		<input id = "check1" name="checkbox11" type="checkbox" value="checkbox" onclick = "selectAllAndReverse()"/>
																			</td>
																			<th width="3%" >
																				<center>照片</center>
																			</th>																				
																			<th width="4%">
																				<center>学号</center>
																			</th>
                                                                            <th width="3%">
																				<center>姓名</center>
																			</th>
																			<th width="5%">
																				<center>专业</center>
																			</th>
																			<th width="5%">
																				<center>班级</center>
																			</th>
																			<th width="3%">
																				<center>性别</center>
																			</th>
																			<th width="3%">
																				<center>民族</center>
																			</th>
																			<th width="3%">
																				<center>籍贯</center>
																			</th>
																			<th width="5%">
																				<center>政治面貌</center>
																			</th>
																			<th width="7%">
																				<center>身份证号码</center>
																			</th>
																			<th width="4%">
																				<center>学历</center>
																			</th>
																			<th width="5%">
																				<center>英语等级</center>
																			</th>																			
																			<th width="7%">
																				<center>银行卡号</center>
																			<th width="5%">
																				<center>审核状态</center>
																			</th>
																			<th width="4%">
																				<center>备注</center>
																			</th>		
																		</tr>														
																	</table>
																</td>
															</tr>
														</table>
														
														
														<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
															<tr>
																<td height="6">
																	<img src="<%=basePath %>images/spacer.gif" width="1" height="1" />
																</td>
															</tr>
															<tr>
																<td height="33">
																	<table width="100%" border="0" align="center"
																		cellpadding="0" cellspacing="0" class="right-font08">
																		<tr>
																			<td width="50%">
																				共<s:debug></s:debug>
																				<span class="right-text09" id="pageNums">5</span> 页 | 第
																				<span class="right-text09" id="currentPage">1</span> 页
																			</td>
																			<td width="49%" align="right">
																				[
																				<a id="firstPage" class="right-font08" >首页</a> |
																				<a id="previousPage" class="right-font08">上一页</a> |
																				<a id="nextPage" class="right-font08">下一页</a> |
																				<a id="lastPage" class="right-font08">末页</a>] 转至：
																			</td>
																			<td width="1%">
																				<table width="20" border="0" cellspacing="0"
																					cellpadding="0">
																					<tr>
																						<td width="1%">
																							<input name="textfield3" type="text"
																								 size="1" height="20" id="gotoPage" />
																						</td>
																						<td width="87%">
																							<input name="Submit23222" type="button"
																								class="right-button06"  id="go"/>
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
		<div id="StuBasicInfoDiv" style="display: none">
		        	<h2>学生基本信息<a id="btnCloseStuBasicInfoDiv">关闭</a></h2>
		        	<div class="form">
		            	<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="demo" id="stuBasicInfo" ><thead>
		            		<tr class="CTitle">
		            			<td height="22" colspan="12" align="center" style="font-size: 16px">
		            				学生基本信息表
								</td>
							</tr>
							<tr bgcolor="#FFFFFF">
								<td width="6%"><b>学号</b></td>
								<td width="6%" id="studentNo">20112222</td>
								<td width="6%"><b>姓名</b></td>
								<td width="6%" id="studentName">张三</td>
								<td width="6%" ><b>性别</b></td>
								<td width="6%" id="sex">男</td>
								<td width="8%" rowspan="4"><img src="" id="photo"></td>
							</tr>
							<tr bgcolor="#EEEEEE">
								<td width="6%"><b>学院</b></td>
								<td width="6%" id="college">软件学院</td>
								<td width="6%"><b>专业</b></td>
								<td width="6%" id="major">软件开发</td>
								<td width="6%"><b>班级</b></td>
								<td width="6%" id="className">1001</td>
							</tr>
							<tr bgcolor="#FFFFFF">
								<td width="6%"><b>出生日期</b></td>
								<td width="6%" id="birthday">1991/3/4</td>
								<td width="6%"><b>民族</b></td>
								<td width="6%" id="nation">汉族</td>
								<td width="6%"><b>籍贯</b></td>
								<td width="6%" id="hometown">山区</td>
							</tr>
							<tr bgcolor="#EEEEEE">
								<td width="6%" colspan="3"><b>政治面貌</b></td>
								<td width="6%" colspan="3" id="political">党员</td>
							</tr>
							<tr bgcolor="#FFFFFF">
								<td width="6%"><b>手机号码</b></td>
								<td width="6%" id="telephone">1234567</td>
								<td width="6%"><b>银行卡号</b></td>
								<td colspan="2" width="6%" id="bankCard">2132032039023902</td>
								<td width="6%"><b>身份证号</b></td>
								<td width="6%" id="idCard">32435358989</td>
							</tr>
							<tr bgcolor="#EEEEEE">
								<td width="6%"><b>家庭联系人</b></td>
								<td width="6%" id="family">父亲</td>
								<td width="6%"><b>家庭现住址</b></td>
								<td colspan="2" width="6%" id="address">江西南昌</td>
								<td width="6%"><b>家庭联系电话</b></td>
								<td width="6%" id="fphone">23242434</td>
							</tr>
							<tr bgcolor="#FFFFFF">
								<td width="6%"><b>英语等级</b></td>
								<td width="6%" id="englishlevel">4</td>
								<td width="6%"><b>个人邮箱</b></td>
								<td colspan="2" width="6%" id="email">12323234@qq.com</td>
								<td width="6%"><b>学历</b></td>
								<td width="6%" id="eduBackground">本科在读</td>
							</tr>
		            	</table>
		        	</div>
		    	</div>



	    		<div id="advancedSearchDiv" style="display: none">
             	<h2>高级查询选项<a id="CloseadvancedSearch">关闭</a></h2>
        	<div class="form">
            	<table width="50%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="demo" id="advancedSearchTab" ><thead>
            
					<tr bgcolor="#FFFFFF" align="center">
					    <td width='15%' name='projectName'> 
					    	性别
					    </td>
					    <td width='35%' name='sex'> 
					    	<input name="sex" type="radio" value="sex" checked />男 
							<input name="sex" type="radio" value="sex" />女
					    </td>
					</tr>
					<tr bgcolor="#FFFFFF" align="center">
					    <td width='15%' name='projectName'> 
					    	名族
					    </td>
					    <td width='35%' name='nation'> 
					    	<select>
					    		<option>汉族</option>
					    		<option>满族</option>
					    		<option>傣族</option>
					    		<option>高山族</option>
					    	</select>	
					    </td>
					</tr>
					<tr bgcolor="#FFFFFF" align="center">
					    <td width='15%'> 
					    	学历
					    </td >
					    <td width='35%' name='nation'> 
					  		 <select>
					    		<option>专科</option>
					    		<option>本科</option>
					    	</select>	
					    </td>
					</tr>
					<tr bgcolor="#FFFFFF" align="center">
					    <td width='15%'> 
					    	英语等级
					    </td>
					    <td width='35%' name='nation'> 
					   		<select>
					    		<option>四级</option>
					    		<option>六级</option>
					    	</select>	
					    </td>
					</tr>
					<tr bgcolor="#FFFFFF" align="center">
					    <td width='15%' name='projectName'> 
					    	政治面貌
					    </td>
					    <td width='35%' name='politics'> 
					    	<select>
					    		<option>共青团员</option>
					    		<option>中共预备党员</option>
					    		<option>中共党员</option>
					    		<option>群众</option>
					    	</select>	
					    </td>
					</tr>
					<tr bgcolor="#FFFFFF" align="center">
					    <td width='15%' name='projectName'> 
					    	籍贯
					    </td>
					    <td width='35%' name='birthplace'> 
					    	<select>
					    		<option>南昌市</option>
					    		<option>赣州市</option>
					    		<option>宜春市</option>
					    		<option>高安市</option>
					    	</select>	
					    </td>
					</tr>
					<tr bgcolor="#FFFFFF" align="center">
						<td colspan="2"><input type="button" value="查询"/></td>
					</tr>
            	</table>
        	</div>
    	</div>    			
	</body>

<script type="text/javascript" src="<%=basePath%>/js/college/collegeSkip.js">
</script>

</html>


