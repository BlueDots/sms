<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>医保信息审核页面</title>
		<link href="<%=basePath %>css/css.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/school/tanchu.css">
		<link href="<%=basePath %>css/style.css" rel="stylesheet" type="text/css" />
		<link href="<%=basePath %>css/arrow.css" rel="stylesheet" type="text/css" />
	
<style type="text/css">
*{margin:0;padding:0;list-style-type:none;}
.demo{border:solid 1px #D5D5D5;border-collapse:collapse;width:100%;}
.demo td{border:1px solid #D5D5D5;font-size:12px;padding:7px 15px;}
.demo th{background-color:#EEE;border-right:1px solid #D5D5D5;font-size:13.5px;line-height:120%;font-weight:bold;padding:8px 5px;text-align:left;}
</style>

  </head>
  
  <body>
    	<body> 
	 
			<table width="100%" border="0" cellspacing="0" cellpadding="0">

				<tr>
					<td height="30">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="62" background="<%=basePath %>images/nav04.gif">

									<table width="100%" border="0" align="center" cellpadding="0"
										cellspacing="0">
										<tr>
											<td width="21">
												 
											</td>
											<td width="538">

													 
											</td>
											<td width="47" align="center">
												<div class="suckerdiv" style="padding-right:-20px">
													<ul id="suckertree1">
														<li>
															<a href="#">审核管理</a>
															<ul>
																<li>
																	<a>审核</a>
																		<ul>
																			<li>
																				<a onclick=''>审核通过</a>
																			</li>
																			<li>
																				<a onclick=''>审核不通过</a>
																			</li>
																		</ul>
																</li>
																　
															</ul>
														</li>

													</ul>
												</div>
											</td>
											<td width="77" align="center" style="padding-right:-30px">
												<input name="advanced_search" type="button" class="right-button07" value="高级搜索" onclick="popup('#advancedDiv', '#advancedSearchDiv', '#CloseadvancedSearch')" />
											</td>
											<td width="77" align="center" style="padding-right:-100px">
											<input name="export" type="button" class="right-button07" value="导出" onclick="exportData()"/>
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
													<th class="tablestyle_title">
														当前位置:<a href="../mainfra.html">首页</a>---><a href="../sch_yibao.html">学生医保信息查询</a>---><font color="red">学生医保信息审核</font>
													</th>
												</tr>
												<tr>
													<td class="CPanel">
														<table width="96%" border="0" align="center"
															cellpadding="0" cellspacing="0">
															<tr>
																<td height="40" class="font42">
																	<table width="100%" border="0" cellpadding="4"
																		cellspacing="1" bgcolor="#464646" class="demo" id="tableID" ><thead>
																		<tr class="CTitle">
																			<td height="22" colspan="18" align="center"
																				style="font-size: 16px">
																				学生医保信息表
																			</td>
																		</tr>
																		
																		<tr bgcolor="#EEEEEE">
																			<td width="7%">全选<input type="checkbox"/></td>
																			<td width="8%">
																				学号			
																		    </td>
																		    <td width="8%">
																				姓名			
																		    </td>
																		    <td width="8%">
																				性别			
																		    </td>
																		    <td width="8%">
																				身份证号			
																		    </td>
																		    <td width="8%">
																				学院与班级			
																		    </td>
																		    <td width="8%">
																				联系电话			
																		    </td>
																		    <td width="8%">
																				银行卡号			
																		    </td>
																		    <td width="8%">
																				住院地址			
																		    </td>
																		    <td width="8%">
																				住院日期			
																		    </td>
																		    <td width="8%">
																				出院日期			
																		    </td>
																		    <td width="8%">
																				住院天数			
																		    </td>
																		    <td width="8%">
																				本市或转外			
																		    </td>
																		    <td width="8%">
																				病情			
																		    </td>
																		    <td width="8%">
																				总费用			
																		    </td>
																		    <td width="8%">
																				申请时间			
																		    </td>
																		    <td width="8%">
																				审核状态			
																		    </td>
																		    <td width="8%">
																				备注			
																		    </td>
			                                                            </tr>        
						                                                            
					                                                    <tr bgcolor="#FFFFFF">
					                                                       <td width="7%"><input type="checkbox"/></td>
																			<td width="8%">
																				20112222			
																		    </td>
																		    <td width="8%">
																				张三			
																		    </td>
																		    <td width="8%">
																				男			
																		    </td>
																		    <td width="8%">
																				1312423432			
																		    </td>
																		    <td width="8%">
																				软件1102			
																		    </td>
																		    <td width="8%">
																				110			
																		    </td>
																		    <td width="8%">
																				9*****11			
																		    </td>
																		    <td width="8%">
																				校医院			
																		    </td>
																		    <td width="8%">
																				2013/2/2			
																		    </td>
																		    <td width="8%">
																				2013/2/3			
																		    </td>
																		    <td width="8%">
																				1			
																		    </td>
																		    <td width="8%">
																				本市			
																		    </td>
																		    <td width="8%">
																				被狗咬			
																		    </td>
																		    <td width="8%">
																				250			
																		    </td>
																		    <td width="8%">
																				2013/2/4			
																		    </td>
																		    <td width="8%">
																				审核通过			
																		    </td>
																		    <td width="8%">
																				无			
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
																				<a href="#" class="right-font08">末页</a>] 转至
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
		
	</body>
		<script src="<%=basePath %>js/jquery-1.10.2.js"></script>
 
	 
		<script src="<%=basePath %>js/jquery.chromatable.js"></script>
	 
 
  </body>
</html>
