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

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>学生工作管理系统</title>
	
		<link href="<%=basePath%>css/css.css" rel="stylesheet" type="text/css" />
		<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
		<link href="<%=basePath%>css/jquery-ui.css" rel="stylesheet" type="text/css" />
		<link href="<%=basePath%>css/arrow.css" rel="stylesheet" type="text/css" />

<style type="text/css">
*{margin:0;padding:0;list-style-type:none;}
.demo{border:solid 1px #D5D5D5;border-collapse:collapse;width:100%;}
.demo td{border:1px solid #D5D5D5;font-size:12px;padding:7px 5px;}
.demo th{background-color:#EEE;border-right:1px solid #D5D5D5;font-size:13.5px;line-height:120%;font-weight:bold;padding:8px 5px;text-align:left;}
 
</style>
		
	</head>

<script src="<%=basePath%>js/jquery-1.10.2.js"></script>

<script src="<%=basePath%>js/jquery.chromatable.js"></script>
<script type="text/javascript">
   



</script>
<script src="<%=basePath%>js/college/college.js"></script>
	<body> 
		<form name="fom" id="fom" method="post" action="">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">

				<tr>
					<td height="30">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="62" background="<%=basePath%>images/nav04.gif">

									<table width="98%" border="0" align="center" cellpadding="0"
										cellspacing="0">
										<tr>
											<td width="21">
												<img src="<%=basePath%>images/ico07.gif" width="20" height="18" />
											</td>
											<td width="538">
												学院：
												<select name="学院">
													<option>
														软件学院
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
												<input name="textfield" type="text" size="16" />
												<input name="Submit4" type="button" class="right-button02"
													value="查 询" />
												<select name="排序">
													<option>
														学号
													</option>
													<option>
														姓名
													</option>
												</select>
													 <img src="<%=basePath%>images/up[1].png"></img>
											</td>
											<td width="77" align="center" style="position:relative;left:-100px">
												<div class="suckerdiv">
													<ul id="suckertree1">
														<li>
															<a href="#">审核</a>
															<ul>
																<li>
																	<a onclick="edit()" href="#">通过</a>
																</li>
																<li>
																	<a onclick="edit()" href="#">不通过</a>
																</li>
															</ul>
														</li>
													</ul>
												</div>
											</td>
											<td width="77" align="center">

												<a href="#" onclick="sousuo()"> <input name="Submit3"
														type="button" class="right-button07" value="高级搜索" /> </a>


												<!--<div class="suckerdiv">
														<ul id="suckertree1">
															
																	<li>
																	<a href="#">高级搜索</a>
																	</li>
																	
																</ul>
																</a>
															</li>
														</ul>
													</div>-->
											</td>
											<td width="77" align="center">
												<a href="#" onclick="sousuo()"> <input name="Submit4"
														type="button" class="right-button07" value="导出" /> </a>
												<!--<div class="suckerdiv">
															<ul id="suckertree1">
															
																	<li>
																	<a href="#">导出</a>
																	</li>
																	
																</ul>
															</div>	-->

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
							<table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td class="CPanel">
										<div id="liulanbiao" style="margin-left: 10px">
											<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
												<tr>
													<th class="tablestyle_title">
														当前位置：<a href="<%=basePath%>files/college/dept_basicInfo.jsp">学生基本信息</a>--->审核
													</th>
												</tr>
												<tr>
													<td class="CPanel" align="center">
														<font size="4">当前共有<font color="red">3</font>个班级提交待审核信息</font>
													</td>
												</tr>
												<tr bgcolor="#DDDDDD">
													<td class="CPanel" align="left" >
														软件1101班<font color = "red" onclick="verifyDetail('ruanjian1101')">（点击查看详细信息）</font>
													</td>
												</tr>												
												<tr id="ruanjian1101" style="display:none" align="center" >

													<td class="" align="center" style="position:relative;left:-0px">
														<table width="1300" border="0" align="center" cellpadding="0" cellspacing="0">
															<tr>
																<td height="40" class="font42">
																	<table width="100%" border="0"  cellpadding="4" class="demo" id="tableID" cellspacing="1"     bgcolor="#464646" class="newfont03" align = "center">
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
																			<th width="8%">
																				<center>担任职务及时间</center>
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
																		<tr bgcolor="#FFFFFF" align = "center">
																			<td>
																			<input name="checkbox11" type="checkbox" value="checkbox" />
																			</td> 																			
																			<td>
																				照片
																			</td>
																			<td>
																				<a href="listmokuaimingxi.htm" onclick=""></a>20111635
																			</td>

																			<td>
																				陈江
																			</td>
																			<td>
																				数字媒体
																			</td>
																			<td>
																				软件1107
																			</td>
																			<td>
																				男
																			</td>
																			<td>
																				汉
																			</td>
																			<td>
																				安徽
																			</td>
																			<td>
																				团员
																			</td>
																			<td>
																				42108719930326131X
																			</td>
																			<td>
																				本科
																			</td>
																			<td>
																				4级
																			</td>
																			<td>
																				2012/9 学习委员
																			</td>
																			<td>
																				111111111111111111
																			</td>
																			<td>
																				院级待审核
																			</td>
																			<td>
																				无
																			</td>
																		</tr>
																		<tr bgcolor="#FFFFFF" align = "center">
																			<td>
																			<input name="checkbox11" type="checkbox" value="checkbox" />
																			</td> 																			
																			<td>
																				照片
																			</td>
																			<td>
																				<a href="listmokuaimingxi.htm" onclick=""></a>20111635
																			</td>

																			<td>
																				陈江
																			</td>
																			<td>
																				数字媒体
																			</td>
																			<td>
																				软件1107
																			</td>
																			<td>
																				男
																			</td>
																			<td>
																				汉
																			</td>
																			<td>
																				安徽
																			</td>
																			<td>
																				团员
																			</td>
																			<td>
																				42108719930326131X
																			</td>
																			<td>
																				本科
																			</td>
																			<td>
																				4级
																			</td>
																			<td>
																				2012/9 学习委员
																			</td>
																			<td>
																				111111111111111111
																			</td>
																			<td>
																				院级待审核
																			</td>
																			<td>
																				无
																			</td>
																		</tr>
																		<tr bgcolor="#FFFFFF" align = "center">
																			<td>
																			<input name="checkbox11" type="checkbox" value="checkbox" />
																			</td> 																			
																			<td>
																				照片
																			</td>
																			<td>
																				<a href="listmokuaimingxi.htm" onclick=""></a>20111635
																			</td>

																			<td>
																				陈江
																			</td>
																			<td>
																				数字媒体
																			</td>
																			<td>
																				软件1107
																			</td>
																			<td>
																				男
																			</td>
																			<td>
																				汉
																			</td>
																			<td>
																				安徽
																			</td>
																			<td>
																				团员
																			</td>
																			<td>
																				42108719930326131X
																			</td>
																			<td>
																				本科
																			</td>
																			<td>
																				4级
																			</td>
																			<td>
																				2012/9 学习委员
																			</td>
																			<td>
																				111111111111111111
																			</td>
																			<td>
																				院级待审核
																			</td>
																			<td>
																				无
																			</td>
																		</tr>
																		<tr bgcolor="#FFFFFF" align = "center">
																			<td>
																			<input name="checkbox11" type="checkbox" value="checkbox" />
																			</td> 																			
																			<td>
																				照片
																			</td>
																			<td>
																				<a href="listmokuaimingxi.htm" onclick=""></a>20111635
																			</td>

																			<td>
																				陈江
																			</td>
																			<td>
																				数字媒体
																			</td>
																			<td>
																				软件1107
																			</td>
																			<td>
																				男
																			</td>
																			<td>
																				汉
																			</td>
																			<td>
																				安徽
																			</td>
																			<td>
																				团员
																			</td>
																			<td>
																				42108719930326131X
																			</td>
																			<td>
																				本科
																			</td>
																			<td>
																				4级
																			</td>
																			<td>
																				2012/9 学习委员
																			</td>
																			<td>
																				111111111111111111
																			</td>
																			<td>
																				院级待审核
																			</td>
																			<td>
																				无
																			</td>
																		</tr>																		
																		<tr bgcolor="#FFFFFF" align = "center">
																			<td>
																			<input name="checkbox11" type="checkbox" value="checkbox" />
																			</td> 																			
																			<td>
																				照片
																			</td>
																			<td>
																				<a href="listmokuaimingxi.htm" onclick=""></a>20111635
																			</td>

																			<td>
																				陈江
																			</td>
																			<td>
																				数字媒体
																			</td>
																			<td>
																				软件1107
																			</td>
																			<td>
																				男
																			</td>
																			<td>
																				汉
																			</td>
																			<td>
																				安徽
																			</td>
																			<td>
																				团员
																			</td>
																			<td>
																				42108719930326131X
																			</td>
																			<td>
																				本科
																			</td>
																			<td>
																				4级
																			</td>
																			<td>
																				2012/9 学习委员
																			</td>
																			<td>
																				111111111111111111
																			</td>
																			<td>
																				院级待审核
																			</td>
																			<td>
																				无
																			</td>
																		</tr>																		

																	</table>
																</td>
															</tr>
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
												<tr bgcolor="#EEEEEE">
													<td class="CPanel" align="left" >
														软件1102班<font color = "red" onclick="verifyDetail('ruanjian1102')">（点击查看详细信息）</font>
													</td>
												</tr>
												<tr id="ruanjian1102" style="display:none" align="center" >

													<td class="CPanel" align="center" style="position:relative;left:0px">
														<table width="1300" border="0" align="center" cellpadding="0" cellspacing="0">
															<tr>
																<td height="40" class="font42">
																	<table width="100%" border="0"  cellpadding="4" class="demo" id="tableID" cellspacing="1"     bgcolor="#464646" class="newfont03" align = "center">
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
																			<th width="8%">
																				<center>担任职务及时间</center>
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
																		<tr bgcolor="#FFFFFF" align = "center">
																			<td>
																			<input name="checkbox11" type="checkbox" value="checkbox" />
																			</td> 																			
																			<td>
																				照片
																			</td>
																			<td>
																				<a href="listmokuaimingxi.htm" onclick=""></a>20111635
																			</td>

																			<td>
																				陈江
																			</td>
																			<td>
																				数字媒体
																			</td>
																			<td>
																				软件1107
																			</td>
																			<td>
																				男
																			</td>
																			<td>
																				汉
																			</td>
																			<td>
																				安徽
																			</td>
																			<td>
																				团员
																			</td>
																			<td>
																				42108719930326131X
																			</td>
																			<td>
																				本科
																			</td>
																			<td>
																				4级
																			</td>
																			<td>
																				2012/9 学习委员
																			</td>
																			<td>
																				111111111111111111
																			</td>
																			<td>
																				院级待审核
																			</td>
																			<td>
																				无
																			</td>
																		</tr>
																		<tr bgcolor="#FFFFFF" align = "center">
																			<td>
																			<input name="checkbox11" type="checkbox" value="checkbox" />
																			</td> 																			
																			<td>
																				照片
																			</td>
																			<td>
																				<a href="listmokuaimingxi.htm" onclick=""></a>20111635
																			</td>

																			<td>
																				陈江
																			</td>
																			<td>
																				数字媒体
																			</td>
																			<td>
																				软件1107
																			</td>
																			<td>
																				男
																			</td>
																			<td>
																				汉
																			</td>
																			<td>
																				安徽
																			</td>
																			<td>
																				团员
																			</td>
																			<td>
																				42108719930326131X
																			</td>
																			<td>
																				本科
																			</td>
																			<td>
																				4级
																			</td>
																			<td>
																				2012/9 学习委员
																			</td>
																			<td>
																				111111111111111111
																			</td>
																			<td>
																				院级待审核
																			</td>
																			<td>
																				无
																			</td>
																		</tr>
																		<tr bgcolor="#FFFFFF" align = "center">
																			<td>
																			<input name="checkbox11" type="checkbox" value="checkbox" />
																			</td> 																			
																			<td>
																				照片
																			</td>
																			<td>
																				<a href="listmokuaimingxi.htm" onclick=""></a>20111635
																			</td>

																			<td>
																				陈江
																			</td>
																			<td>
																				数字媒体
																			</td>
																			<td>
																				软件1107
																			</td>
																			<td>
																				男
																			</td>
																			<td>
																				汉
																			</td>
																			<td>
																				安徽
																			</td>
																			<td>
																				团员
																			</td>
																			<td>
																				42108719930326131X
																			</td>
																			<td>
																				本科
																			</td>
																			<td>
																				4级
																			</td>
																			<td>
																				2012/9 学习委员
																			</td>
																			<td>
																				111111111111111111
																			</td>
																			<td>
																				院级待审核
																			</td>
																			<td>
																				无
																			</td>
																		</tr>
																		<tr bgcolor="#FFFFFF" align = "center">
																			<td>
																			<input name="checkbox11" type="checkbox" value="checkbox" />
																			</td> 																			
																			<td>
																				照片
																			</td>
																			<td>
																				<a href="listmokuaimingxi.htm" onclick=""></a>20111635
																			</td>

																			<td>
																				陈江
																			</td>
																			<td>
																				数字媒体
																			</td>
																			<td>
																				软件1107
																			</td>
																			<td>
																				男
																			</td>
																			<td>
																				汉
																			</td>
																			<td>
																				安徽
																			</td>
																			<td>
																				团员
																			</td>
																			<td>
																				42108719930326131X
																			</td>
																			<td>
																				本科
																			</td>
																			<td>
																				4级
																			</td>
																			<td>
																				2012/9 学习委员
																			</td>
																			<td>
																				111111111111111111
																			</td>
																			<td>
																				院级待审核
																			</td>
																			<td>
																				无
																			</td>
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
												<tr bgcolor="#DDDDDD">
													<td class="CPanel" align="left" >
														软件1107班<font color = "red" onclick="verifyDetail('ruanjian1107')">（点击查看详细信息）</font>
													</td>
												</tr>
												<tr id="ruanjian1107" style="display:none" align="center" >

													<td class="CPanel" align="center" style="position:relative;left:0px">
														<table width="1300" border="0" align="center" cellpadding="0" cellspacing="0">
															<tr>
																<td height="40" class="font42">
																	<table width="100%" border="0"  cellpadding="4" class="demo" id="tableID"cellspacing="1"     bgcolor="#464646" class="newfont03" align = "center">
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
																			<th width="8%">
																				<center>担任职务及时间</center>
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
																		<tr bgcolor="#FFFFFF" align = "center">
																			<td>
																			<input name="checkbox11" type="checkbox" value="checkbox" />
																			</td> 																			
																			<td>
																				照片
																			</td>
																			<td>
																				<a href="listmokuaimingxi.htm" onclick=""></a>20111635
																			</td>

																			<td>
																				陈江
																			</td>
																			<td>
																				数字媒体
																			</td>
																			<td>
																				软件1107
																			</td>
																			<td>
																				男
																			</td>
																			<td>
																				汉
																			</td>
																			<td>
																				安徽
																			</td>
																			<td>
																				团员
																			</td>
																			<td>
																				42108719930326131X
																			</td>
																			<td>
																				本科
																			</td>
																			<td>
																				4级
																			</td>
																			<td>
																				2012/9 学习委员
																			</td>
																			<td>
																				111111111111111111
																			</td>
																			<td>
																				院级待审核
																			</td>
																			<td>
																				无
																			</td>
																		</tr>
																		<tr bgcolor="#FFFFFF" align = "center">
																			<td>
																			<input name="checkbox11" type="checkbox" value="checkbox" />
																			</td> 																			
																			<td>
																				照片
																			</td>
																			<td>
																				<a href="listmokuaimingxi.htm" onclick=""></a>20111635
																			</td>

																			<td>
																				陈江
																			</td>
																			<td>
																				数字媒体
																			</td>
																			<td>
																				软件1107
																			</td>
																			<td>
																				男
																			</td>
																			<td>
																				汉
																			</td>
																			<td>
																				安徽
																			</td>
																			<td>
																				团员
																			</td>
																			<td>
																				42108719930326131X
																			</td>
																			<td>
																				本科
																			</td>
																			<td>
																				4级
																			</td>
																			<td>
																				2012/9 学习委员
																			</td>
																			<td>
																				111111111111111111
																			</td>
																			<td>
																				院级待审核
																			</td>
																			<td>
																				无
																			</td>
																		</tr>
																		<tr bgcolor="#FFFFFF" align = "center">
																			<td>
																			<input name="checkbox11" type="checkbox" value="checkbox" />
																			</td> 																			
																			<td>
																				照片
																			</td>
																			<td>
																				<a href="listmokuaimingxi.htm" onclick=""></a>20111635
																			</td>

																			<td>
																				陈江
																			</td>
																			<td>
																				数字媒体
																			</td>
																			<td>
																				软件1107
																			</td>
																			<td>
																				男
																			</td>
																			<td>
																				汉
																			</td>
																			<td>
																				安徽
																			</td>
																			<td>
																				团员
																			</td>
																			<td>
																				42108719930326131X
																			</td>
																			<td>
																				本科
																			</td>
																			<td>
																				4级
																			</td>
																			<td>
																				2012/9 学习委员
																			</td>
																			<td>
																				111111111111111111
																			</td>
																			<td>
																				院级待审核
																			</td>
																			<td>
																				无
																			</td>
																		</tr>
																		<tr bgcolor="#FFFFFF" align = "center">
																			<td>
																			<input name="checkbox11" type="checkbox" value="checkbox" />
																			</td> 																			
																			<td>
																				照片
																			</td>
																			<td>
																				<a href="listmokuaimingxi.htm" onclick=""></a>20111635
																			</td>

																			<td>
																				陈江
																			</td>
																			<td>
																				数字媒体
																			</td>
																			<td>
																				软件1107
																			</td>
																			<td>
																				男
																			</td>
																			<td>
																				汉
																			</td>
																			<td>
																				安徽
																			</td>
																			<td>
																				团员
																			</td>
																			<td>
																				42108719930326131X
																			</td>
																			<td>
																				本科
																			</td>
																			<td>
																				4级
																			</td>
																			<td>
																				2012/9 学习委员
																			</td>
																			<td>
																				111111111111111111
																			</td>
																			<td>
																				院级待审核
																			</td>
																			<td>
																				无
																			</td>
																		</tr>																		
																		
																	</table>
																</td>
															</tr>
														</table>
														
														
														<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
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
												<tr align="center">
														<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
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
	</body>
</html>

