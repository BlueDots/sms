<%@ page language="java" import="java.util.*,java.net.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib prefix="s" uri="/struts-tags" %>
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
	 
	 <form action="<%=basePath%>hosInsuranceInfo/hosInsuranceInfo!checkHosByTeacher" method="post">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">

				<tr>
					<td height="30">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="62" background="<%=basePath %>images/nav04.gif">

									<table width="100%" border="0" align="center" cellpadding="0"
										cellspacing="0">
										<tr>
										 
											<td width="300">

													 
											</td>
											<td width="47" align="center">
												<div class="suckerdiv" style="padding-right:-90px">
													<ul id="suckertree1">
														<li>
															<a href="#">审核管理</a>
															<ul>
																<li>
																
																<a onclick="$('#isYesOrNot').val(1);$(this).closest('form').submit();">通过</a>
																<a onclick="$('#isYesOrNot').val(0);$(this).closest('form').submit();">不通过</a>
																</li>
																　
															</ul>
														</li>

													</ul>
												</div>
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
												     <input type="hidden" id="isYesOrNot" name="isYesOrNot">
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
																			<td width="7%"><input type="checkbox"/></td>
																			<td width="8%">
																				学号			
																		    </td>
																		    <td width="8%">
																				姓名			
																		    </td>
																		   
																		    <td width="8%">
																				学院与班级			
																		    </td>
																		    <td width="8%">
																				联系电话			
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
																				备注			
																		    </td>
																		    
			                                                            </tr>        
						                                               
						                                               	            
						                                               <s:iterator value="#request.hoss">   
						                                                 
					                                                    <tr bgcolor="#FFFFFF">
					                                                    
					                                                       <td width="7%"><input  value="<s:property value="#request.hosNo"/>" name="hosNo<s:property value="#request.hosNo"/>" type="checkbox"/></td>
																			<td width="8%">
																				<s:property value="student.studentNo"/>			
																		    </td>
																		    <td width="8%">
																				<s:property value="student.studentName"/>			
																		    </td>
																		    <td width="8%">
																				<s:property value="student.college"/><s:property value="student.className"/>			
																		    </td>
																		    <td width="8%">
																			<s:property value="student.telephone"/>			
																		  			
																		    </td>
																		    <td width="8%">
																				<s:property value="hospitalAddress"/>		
																		    </td>
																		    <td width="8%">
																			 	<s:property value="hospitalDate"/>			
																		    </td>
																		    <td width="8%">
																				<s:property value="leaveDate"/>			
																		    </td>
																		    <td width="8%">
																				<s:property value="hosDate"/>			
																		    </td>
																		    <td width="8%">
																				<s:if test="localCity==0">本市</s:if>
																				<s:else>转外</s:else>		
																		    </td>
																		    <td width="8%">
																				<s:property value="conditon"/>				
																		    </td>
																		    <td width="8%">
																				<s:property value="cost"/>			
																		    </td>
																		    <td width="8%">
																				<s:property value="applyTime"/>		
																		    </td>
																		   　
																		    <td width="8%">
																				　<textarea rows="" cols="" name="stateRemark<s:property value="#request.hosNo"/>" ></textarea>			
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
																				<span class="right-text09"><s:property value="#request.pageVo.pageNum"/></span> 页 | 第
																				<span class="right-text09"><s:property  value="#request.pageVo.currentPage"/></span> 页
																			</td>
																			
																			 
																			
																			<td width="49%" align="right">
																				[
																				<a href="<%=basePath%>hosInsuranceInfo/hosInsuranceInfo!getAllHosByTeacher?currentPage=1&hosState=<%=URLEncoder.encode(URLEncoder.encode("校级审核中","utf-8"),"utf-8")%>" class="right-font08">首页</a> |
																				
																				<a href="<%=basePath%>hosInsuranceInfo/hosInsuranceInfo!getAllHosByTeacher?currentPage=<s:property  value="#request.pageVo.currentPage-1"/>&hosState=<%=URLEncoder.encode(URLEncoder.encode("校级审核中","utf-8"),"utf-8")%>" class="right-font08">上一页</a> |
																				<a href="<%=basePath%>hosInsuranceInfo/hosInsuranceInfo!getAllHosByTeacher?currentPage=<s:property  value="(#request.pageVo.currentPage+1)<#request.pageVo.pageNum?(#request.pageVo.currentPage+1):#request.pageVo.pageNum"/>&hosState=<%=URLEncoder.encode(URLEncoder.encode("校级审核中","utf-8"),"utf-8")%>" class="right-font08">下一页</a> |
																				<a href="<%=basePath%>hosInsuranceInfo/hosInsuranceInfo!getAllHosByTeacher?currentPage=<s:property  value="#request.pageVo.pageNum"/>&hosState=<%=URLEncoder.encode(URLEncoder.encode("校级审核中","utf-8"),"utf-8")%>" class="right-font08">末页</a>] 
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
	</body>
		<script src="<%=basePath %>js/jquery-1.10.2.js"></script>
 
	 <script type="text/javascript" src="<%=basePath%>js/school/school.js"></script>
		<script src="<%=basePath %>js/jquery.chromatable.js"></script>
	 
 
  </body>
</html>
