<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'dept_scholarshipAssess_verify.jsp' starting page</title>
    <link href="<%=basePath %>css/css.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/college/tanchu.css">
		<link href="<%=basePath %>css/style.css" rel="stylesheet" type="text/css" />
		<link href="<%=basePath %>css/arrow.css" rel="stylesheet" type="text/css" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
*{margin:0;padding:0;list-style-type:none;}
.demo{border:solid 1px #D5D5D5;border-collapse:collapse;width:100%;}
.demo td{border:1px solid #D5D5D5;font-size:12px;padding:7px 5px;}
.demo th{background-color:#EEE;border-right:1px solid #D5D5D5;font-size:13.5px;line-height:120%;font-weight:bold;padding:8px 5px;text-align:right;}
 
</style>
  </head>
  
  <body>
   <body> 
		<form name="fom" id="fom" method="post" action="">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">

				<tr>
					<td height="30">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="62" background="../../../images/nav04.gif">

									<table width="98%" border="0" align="center" cellpadding="0"
										cellspacing="0">
										<tr>
											<td width="21">
												<img src="../../../images/ico07.gif" width="20" height="18" />
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
														请选择专业方向
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
														请选择班级
													</option>
													<option>
														1102
													</option>
													<option>
														1101
													</option>
												</select>
												<input name="textfield" type="text" size="16" value="请输入学号或姓名"/>
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
											<td width="77" align="center" style="position:relative;left:-40px">
												<div class="suckerdiv">
													<ul id="suckertree1">
														<li>
															<a href="#">审核</a>
															<ul>
																<li>
																	<a href="#">通过</a>
																</li>
																<li>
																	<a href="#">不通过</a>
																</li>
															</ul>
														</li>
													</ul>
												</div>
											</td>
											<td width="77" align="center">

												<a href="#" onclick="sousuo()"> <input name="Submit3"
														type="button" class="right-button07" value="高级搜索" /> </a>

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
							<table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td class="CPanel">
										<div id="liulanbiao" style="margin-left: 10px">
											<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
												<tr>
													<th class="tablestyle_title">
														当前位置：<a href="../dept_scholarshipAssess.html">奖学金页面</a>--->审核
													</th>
												</tr>
												<tr>
													<td class="CPanel" align="center">
														<font size="4">当前共有<font color="red">2</font>个班级提交待审核信息</font>
													</td>
												</tr>
												<tr bgcolor="#DDDDDD">
													<td class="CPanel" align="left" >
														软件1101班<font color = "red" onclick="verifyDetail('ruanjian1101')">（点击查看详细信息）</font>
														<span style="margin-left: 1080px"><input type="button" value="汇总"
															onclick="popup('#stuScholarshipCollectInfoDiv', '#StuScholarshipCollectInfoDiv', '#CloseStuScholarshipCollectInfo')"></span>
													</td>
												</tr>												
												<tr id="ruanjian1101" style="display:none" align="center" >
													<td class="CPanel" align="center" style="position:relative;left:-0px">
															  	<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
                                                                <tr class="CTitle">
                                                                  <td height="22" colspan="24" align="center"
																				style="font-size: 16px"> 奖学金信息表 
																	</td>
                                                                </tr>
																<tr bgcolor="#EEEEEE" align = "center">
                                                                  <td width="2%" rowspan="3"> <input type="checkbox" /> </td>
                                                                  <td width="4%" rowspan="3"> 学号 </td>
                                                                  <td width="3%" rowspan="3"> 姓名 </td>
                                                                  <td colspan="4"> 德育素质测评（20%）</td>
                                                                  <td colspan="5"> 智育素质测评（60%）</td>
                                                                  <td colspan="4">体育素质测评（5%）</td>
                                                                  <td colspan="4">美育素质测评（15%）</td>
                                                                  <td colspan="2" rowspan="2">综合测评</td>
                                                                  <td width="2%" rowspan="3"> 奖学金等级</td>
                                                                  <td width="2%" rowspan="3">审核</td>
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
                                                                <tr bgcolor="#FFFFFF" align = "center">
                                                                  <td><input type="checkbox" /></td>
                                                                  <td><a href="#" onclick="">20101428</a> </td>
                                                                  <td> 陈鹏 </td>
                                                                  <td >16 </td>
                                                                  <td>0</td>
                                                                  <td>0</td>
                                                                  <td>16</td>
                                                                  <td>51</td>
                                                                  <td>2</td>
                                                                  <td>1.2</td>
                                                                  <td></td>
                                                                  <td>52.20</td>
                                                                  <td>2</td>
                                                                  <td>2</td>
                                                                  <td>2</td>
                                                                  <td>6</td>
                                                                  <td>10</td>
                                                                  <td>6</td>
                                                                  <td>6</td>
                                                                  <td>22</td>
                                                                  <td>80.20</td>
                                                                  <td>1</td>
                                                                  <td>一等</td>
                                                                  <td>院级审核通过</td>
                                                                </tr>
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
												<tr bgcolor="#DDDDDD">
													<td class="CPanel" align="left" >
														软件1102班<font color = "red" onclick="verifyDetail('ruanjian1102')">（点击查看详细信息）</font>

													</td>
												</tr>
												<tr id="ruanjian1102" style="display:none" align="center" >
													<td class="CPanel" align="center" style="position:relative;left:-0px">
															  	<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
                                                                <tr class="CTitle">
                                                                  <td height="22" colspan="24" align="center"
																				style="font-size: 16px"> 奖学金信息表 
																	</td>
                                                                </tr>
                                                               <tr bgcolor="#EEEEEE" align = "center">
                                                                  <td width="2%" rowspan="3"> <input type="checkbox" /> </td>
                                                                  <td width="4%" rowspan="3"> 学号 </td>
                                                                  <td width="3%" rowspan="3"> 姓名 </td>
                                                                  <td colspan="4"> 德育素质测评（20%）</td>
                                                                  <td colspan="5"> 智育素质测评（60%）</td>
                                                                  <td colspan="4">体育素质测评（5%）</td>
                                                                  <td colspan="4">美育素质测评（15%）</td>
                                                                  <td colspan="2" rowspan="2">综合测评</td>
                                                                  <td width="2%" rowspan="3"> 奖学金等级</td>
                                                                  <td width="2%" rowspan="3">审核</td>
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
                                                                <tr bgcolor="#FFFFFF" align = "center">
                                                                  <td><input type="checkbox" /></td>
                                                                  <td><a href="#" onclick="">20101428</a> </td>
                                                                  <td> 陈鹏 </td>
                                                                  <td >16 </td>
                                                                  <td>0</td>
                                                                  <td>0</td>
                                                                  <td>16</td>
                                                                  <td>51</td>
                                                                  <td>2</td>
                                                                  <td>1.2</td>
                                                                  <td></td>
                                                                  <td>52.20</td>
                                                                  <td>2</td>
                                                                  <td>2</td>
                                                                  <td>2</td>
                                                                  <td>6</td>
                                                                  <td>10</td>
                                                                  <td>6</td>
                                                                  <td>6</td>
                                                                  <td>22</td>
                                                                  <td>80.20</td>
                                                                  <td>1</td>
                                                                  <td>一等</td>
                                                                  <td>院级审核通过</td>
                                                                </tr>
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
    	<div id="StuScholarshipCollectInfoDiv" style="display: none">
        	<h2>班级奖学金汇总<a href="#" id="CloseStuScholarshipCollectInfo">关闭</a></h2>
        	<div class="form">
            	<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="demo" id="pastAdvInfoTab" ><thead>
            		<tr class="CTitle">
            			<td height="22" colspan="10" align="center" style="font-size: 16px">
            				软件1101班奖学金汇总信息<font color="red" size="2">(括号是分配人数)</font>
						</td>
					</tr>
            
					<tr bgcolor="#FFFFFF" align="center">
					    <th width='15%' name='projectName'> 
					    	<center>一等<font color="red">(2)</font></center>
					    </th>
					    <th width='15%' name='projectName'> 
					    	<center>二等<font color="red">(6)</font></center>
					    </th>
					    <th width='15%' name='projectName'> 
					    	<center>三等<font color="red">(7)</font></center>
					    </th>
					    <th width='20%' name='projectName'> 
					    	<center>超标</center>
					    </th>
					    <th width='20%' name='projectName'> 
					    	<center>审核状态</center>
					    </th>
					</tr>
					<tr bgcolor="#FFFFFF" align="center">
					    <td width='15%' name='projectName'> 
					    	2
					    </td>
					    <td width='15%' name='projectName'> 
					    	6
					    </td>
					    <td width='15%' name='projectName'> 
					    	7
					    </td>
					    <td width='20%' name='projectName'> 
					    	否
					    </td>
					    <td width='20%' name='projectName'> 
					    	院级待审核
					    </td>
					</tr>
            	</table>
        	</div>
    	</div>		
	</body>
  </body>
  <script type="text/javascript" src="../../../js/college.js"></script>
<script src="../../../js/jquery-1.10.2.min.js"></script>
<script src="../../../js/testSearch.js"></script>
<script src="../../../js/jquery-ui-1.8.21.custom.min.js"></script>
<script src="../../../js/jquery.chromatable.js"></script>
<script src="../../../js/college/college.js"></script>
</html>