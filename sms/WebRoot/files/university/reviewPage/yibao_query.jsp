<%@page import="java.net.URLEncoder"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		<title>医保信息</title>
		<link href="<%=basePath%>css/css.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css/school/tanchu.css">
		<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
		<link href="<%=basePath%>css/arrow.css" rel="stylesheet" type="text/css" />
	
<style type="text/css">
*{margin:0;padding:0;list-style-type:none;}
.demo{border:solid 1px #D5D5D5;border-collapse:collapse;width:100%;}
.demo td{border:1px solid #D5D5D5;font-size:12px;padding:7px 15px;}
.demo th{background-color:#EEE;border-right:1px solid #D5D5D5;font-size:13.5px;line-height:120%;font-weight:bold;padding:8px 5px;text-align:left;}
</style>
  </head>
  
 
    <body> 
		
			<table width="100%" border="0" cellspacing="0" cellpadding="0">

				<tr>
					<td height="30">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="62" background="<%=basePath%>images/nav04.gif">

									<table width="100%" border="0" align="center" cellpadding="0"
										cellspacing="0">
										<tr>
											<td width="21">
												<img src="<%=basePath%>images/ico07.gif" width="20" height="18" />
											</td>
											<td width="538">
										　
												
												
											</td>
											
											<td width="47" align="center">
											
											
												<div class="suckerdiv" style="padding-right:-20px">
													 
													
													<ul id="suckertree1">
														<li>
															<a href="#">信息管理</a>
															<ul>
																
																<li>
																	<a>录入</a>
																		<ul>
																			<li>
																			<!-- popup('#medicareDiv', '#acceptResultDiv', '#btnCloseacceptResult') -->
																				<a onclick="updateDataAboutAcceptResult()">录入受理结果</a>
																			</li>
																			<li>
																			<!-- popup('#medicareDiv', '#acceptResultList', '#btnCloseList') -->
																				<a onclick="updateDataAboutReimburse()">录入已报销名单</a>
																			</li>
																			<li>
																			<!--popup('#medicareDiv', '#acceptMoney', '#btnCloseMoney')  -->
																				<a onclick="updateDataAboutCompany()">录入商业理赔结果</a>
																				
																			</li>
																		</ul>
																</li>
																<li>
																	<a href="">导入</a>
																</li>
																<li>
																	<a onclick="$('#Company').hide();$('#reimburseStudent').hide();$('#juming').show();"  style="cursor: pointer;">居民医保</a>
																</li>
																<li>
																	<a onclick="$('#reimburseStudent').hide();$('#juming').hide();$('#Company').show();" style="cursor: pointer;">商业医保</a>
																</li>
																	<li>
																	<a onclick="$('#juming').hide();$('#Company').hide();$('#reimburseStudent').show();" style="cursor: pointer;">已报销名单</a>
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
														当前位置:<a href="<%=basePath%>hosInsuranceInfo/hosInsuranceInfo!getAllHosByTeacher">首页</a>---><font color="red">高级查询</font><span style="position:relative;left:600px"><a href="<%=basePath%>hosInsuranceInfo/hosInsuranceInfo!getAllHosByTeacher?hosState=<%=URLEncoder.encode(URLEncoder.encode("校级审核中","utf-8"),"utf-8")%>"><font color = "red" >待审核信息</font></a>(3)</span>
													</th>
												</tr>
												<tr>
													<td class="CPanel">
														<table width="96%" border="0" align="center"
															cellpadding="0" cellspacing="0">
															<tr>
																<td height="40" class="font42">
																	<table width="100%" border="0" cellpadding="4"
																		cellspacing="1" bgcolor="#464646" class="demo" id="juming"  ><thead>
																		<tr class="CTitle">
																			<td height="22" colspan="20" align="center"
																				style="font-size: 16px">
																				学生医保登记表
																			</td>
																		</tr>
																		
																		<tr bgcolor="#EEEEEE">
																			<td width="7%"><input type="checkbox" name="jumingAll"/></td>
																			<td width="8%">
																				序号			
																		    </td>
																		    <td width="8%">
																				姓名			
																		    </td>
																		    <td width="8%">
																				性别			
																		    </td>
																		    <td width="8%">
																				身份证	
																		    </td>
																		    <td width="8%">
																				学院班级			
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
																				递交案子时间			
																		    </td>
																		    <td width="8%">
																				申请时间			
																		    </td>
																		     <td width="8%">
																				未受理原因			
																		    </td>
																		    <td width="8%">
																			处理结果			
																		    </td>
																		    
																		    <td width="8%">
																				审核状态			
																		    </td>
																		   
																		
			                                                            </tr>        
						                                             <s:iterator  value="#request.hoss">
					                                                    <tr bgcolor="#FFFFFF">
					                                                       <td width="7%"><input type="checkbox" name="juming"  value="<s:property value="hosNo"/>"/></td>
																			<td width="8%">
																				<s:property value="student.studentNo"/>		
																		    </td>
																		    <td width="8%">
																				<s:property value="student.studentName"/>			
																		    </td>
																		    <td width="8%">
																		    <s:if test="student.sex==0">
																		    男
																		    </s:if>
																			<s:else>女</s:else>			
																		    </td>
																		    
																		    <td width="8%">
																				<s:property value="student.idCard"/>		
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
																				<s:else >转外</s:else>		
																		    </td>
																		    <td width="8%">
																				<s:property value="conditon"/>		
																		    </td>
																		    <td width="8%">
																				<s:property value="cost"/>		
																		    </td>
																		      <td width="8%">
																				<s:property value="submitTime"/>		
																		    </td>
																		    <td width="8%">
																				<s:property value="applyTime"/>			
																		    </td>
																		     <td width="8%">
																				<s:property value="refuseReason"/>				
																		    </td>
																		    <td width="8%">
																					<s:property value="resultDeal"/>		
																		    </td>
																		    <td width="8%">
																					<s:property value="hosState"/>		
																		    </td>
																		         
					                                                    </tr>		 	
						                                                   </s:iterator>
																	</table>



																<!--商业医保开始  -->
																<table width="100%" border="0" cellpadding="4"
																		cellspacing="1" bgcolor="#464646" class="demo" id="Company"  style="display: none;"><thead>
																		<tr class="CTitle">
																			<td height="22" colspan="19" align="center"
																				style="font-size: 16px">
																				商业理赔登记表
																			</td>
																		</tr>
																		
																		<tr bgcolor="#EEEEEE">
																			<td width="7%"><input name="companyAll" type="checkbox"/></td>
																			<td width="8%">
																				序号			
																		    </td>
																		    <td width="8%">
																				姓名			
																		    </td>
																		    <td width="8%">
																				性别			
																		    </td>
																		    <td width="8%">
																				身份证	
																		    </td>
																		    <td width="8%">
																				学院班级			
																		    </td>
																		    <td width="8%">
																				联系电话			
																		    </td>
																		     
																		    <td width="8%">
																				银行卡号		
																		    </td>
																		    <td width="8%">
																				材料齐全			
																		    </td>
																		    <td width="8%">
																				接案时间			
																		    </td>
																		    <td width="8%">
																				未报销原因		
																		    </td>
																		    <td width="8%">
																				备注			
																		    </td>
																		</tr>        
						                                             <s:iterator  value="#request.hoss">
					                                                    <tr bgcolor="#FFFFFF">
					                                                       <td width="7%"><input type="checkbox" name="company" value="<s:property value="hosNo"/>"/></td>
																			<td width="8%">
																				<s:property value="student.studentNo"/>		
																		    </td>
																		    <td width="8%">
																				<s:property value="student.studentName"/>			
																		    </td>
																		    <td width="8%">
																		    <s:if test="student.sex==0">
																		    男
																		    </s:if>
																			<s:else>女</s:else>			
																		    </td>
																		    
																		    <td width="8%">
																				<s:property value="student.idCard"/>		
																		    </td>
																		    <td width="8%">
																				<s:property value="student.college"/><s:property value="student.className"/>
																							
																		    </td>
																		    <td width="8%">
																				<s:property value="student.telephone"/>			
																		    </td>
																		  　
																		 
																		   <td width="8%">
																				<s:property value="bankcardID"/>			
																		    </td>
																		     <td width="8%">
																			　	<s:if test="complete==1">
																				是
																				</s:if>
																				<s:else>
																				否
																				</s:else>			
																		    </td>
																		     <td width="8%">
																				<s:property value="insurerTime"/>			
																		    </td>
																		    
																		      <td width="8%">
																				<s:property value="notinsurerReason"/>			
																		    </td>
																		      <td width="8%">
																				<s:property value="companyRemark"/>			
																		    </td>
					                                                    </tr>		 	
						                                                   </s:iterator>
																	</table>
																
																<!-- end -->


																<!--报销名单开始  -->
																<table width="100%" border="0" cellpadding="4"
																		cellspacing="1" bgcolor="#464646" class="demo" id="reimburseStudent" style="display: none;" ><thead>
																		<tr class="CTitle">
																			<td height="22" colspan="11" align="center"
																				style="font-size: 16px">
																				已报销登记表
																			</td>
																		</tr>
																		
																		<tr bgcolor="#EEEEEE">
																			<td width="7%"><input type="checkbox" name="reimburseAll"/></td>
																			<td width="8%">
																				序号			
																		    </td>
																		    <td width="8%">
																				姓名			
																		    </td>
																		    <td width="8%">
																				性别			
																		    </td>
																		    <td width="8%">
																				身份证	
																		    </td>
																		    <td width="16%">
																				学院班级			
																		    </td>
																		    <td width="10%">
																				联系电话			
																		    </td>
																		    <td width="8%">
																				已报销金额			
																		    </td> 
																		      <td width="12%">
																				是否有结算单			
																		    </td>   
																		 <td width="8%">
																				是否领卡
																					
																		    </td> 
																		     <td width="8%">
																				领卡时间			
																		    </td> 
																		   
																		
			                                                            </tr>        
						                                             <s:iterator  value="#request.hoss">
					                                                    <tr bgcolor="#FFFFFF">
					                                                       <td width="7%"><input type="checkbox" name="reimburse" value="<s:property value="hosNo"/>"/></td>
																			<td width="8%">
																				<s:property value="student.studentNo"/>		
																		    </td>
																		    <td width="8%">
																				<s:property value="student.studentName"/>			
																		    </td>
																		    <td width="8%">
																		    <s:if test="student.sex==0">
																		    男
																		    </s:if>
																			<s:else>女</s:else>			
																		    </td>
																		    
																		    <td width="8%">
																				<s:property value="student.idCard"/>		
																		    </td>
																		    <td width="16%">
																				<s:property value="student.college"/><s:property value="student.className"/>
																							
																		    </td>
																		    <td width="10%">
																				<s:property value="student.telephone"/>			
																		    </td>
																	　 <td width="8%">
																				<s:property value="reimbursementAmount"/>			
																		    </td>
																		    <td width="12%">
																				 	
																				<s:if test="bill==1">
																					有
																				</s:if>
																				<s:else>
																				否
																				</s:else>		
																		    </td>
																		   
																		    <td width="8%">
																				  <s:if test="collarCard==1">
																				已领卡
																				</s:if>	
																				<s:if test="collarCard==1">
																				未领卡
																				</s:if>			
																		    </td>
																		    <td width="8%">
																				<s:property value="getcardTime"/>			
																		    </td>
					                                                    </tr>		 	
						                                                   </s:iterator>
																	</table>
																
																<!-- end -->

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
																				<span class="right-text09"><s:property value="#request.pageVo.currentPage"/></span> 页
																			</td>
																			<td width="49%" align="right">
																		 
																			<form action="<%=basePath%>hosInsuranceInfo/hosInsuranceQuery!queryHosByCondition" method="post">
																				<input type="hidden"	id="currentPage" name="currentPage">
																				<input type="hidden"	 name="collarCard" value="<s:property value="#request.collarCard"/>">
																				<input type="hidden"	 name="hosState" value="<s:property value="#request.hosState"/>">
																				<input type="hidden"	 name="hosState" value="<s:property value="#request.hosType"/>">
																				
																				[
																				<a onclick="$('#currentPage').val(1);$(this).closest('form').submit();" class="right-font08">首页</a> |
																				<a onclick="$('#currentPage').val(<s:property value="#request.pageVo.currentPage-1"/>);$(this).closest('form').submit();"  class="right-font08">上一页</a> |
																				<a  onclick="$('#currentPage').val(<s:property value="(#request.pageVo.currentPage+1)<#request.pageVo.pageNum?(#request.pageVo.currentPage+1):#request.pageVo.pageNum"/>);$(this).closest('form').submit();" class="right-font08">下一页</a> |
																				<a onclick="$('#currentPage').val(<s:property value="#request.pageVo.pageNum"/>);$(this).closest('form').submit();" class="right-font08">末页</a>] 
																			</form>
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
		 
		
    	<div id="medicareDiv" style="display: none"></div>
    		<div id="acceptResultDiv" style="display: none">
        		<h2>录入受理结果<a  id="btnCloseacceptResult">关闭</a></h2>
        		<div class="form">
        		 <form action="" method="post">
            		<input type="hidden" name="hosNo" id="jumingHosNo"> 
            		<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="demo" id="tableID" ><thead>
            			<tr class="CTitle">
            				<td height="22" colspan="4" align="center" style="font-size: 16px">
            				受理结果信息表
							</td>
						</tr>
						<tr bgcolor="#FFFFFF">
						    <td width="15%">
								学号			
							</td>
							<td width="15%">
								 <p id="jumingStudentNo"></p>
							</td>
							<td width="15%">
							    姓名			
							</td>
							<td width="15%">
								<p id="jumingStudentName"></p>			
							</td>
						</tr>
						<tr bgcolor="#EEEEEE">
						   <td width="15%">
								学院			
							</td>
							<td width="15%">
								<p id="jumingCollege"></p>	
							</td>
							<td width="15%">
							    班级			
							</td>
							<td width="15%">
								<p id="jumingClass"></p> 			
							</td>
						</tr>
						<tr bgcolor="#FFFFFF">
						   <td colspan="2">
								住院日期			
							</td>
							<td colspan="2">
								<p id="jumingHospitalDate"></p>
							</td>
							
						</tr>
						<tr bgcolor="#EEEEEE">
						   <td colspan="2">
								出院日期			
							</td>
							<td colspan="2">
								<p id="jumingLeaveDate"></p>
							</td>
						</tr>
						<tr bgcolor="#FFFFFF">
						    <td width="15%">
								住院天数			
							</td>
							<td width="15%">
								<p id="jumingHosDate"></p>
							</td>
							<td width="6%">
							    病情			
							</td>
							<td width="15%">
								<p id="jumingConditon"></p>		
							</td>
						</tr>
						<tr bgcolor="#EEEEEE">
						   <td colspan="2">
								本地或转外			
							</td>
							<td colspan="2">
							 <p id="jumingLocalCity"></p>	
							</td>
						</tr>
						<tr bgcolor="#FFFFFF">
						   <td colspan="2">
								申请时间			
							</td>
							<td colspan="2">
								 <p id="jumingApplyTime"></p>
							</td>
						</tr>
						
						<tr bgcolor="#EEEEEE">
						   <td width="15%" >
								住院地址			
							</td>
							<td width="15%" >
								 <p id="jumingHospitalAddress"></p>
							</td>
						   
						   <td width="15%" >
								总费用			
							</td>
							<td width="15%" >
								 <p id="jumingCost"></p>
							</td>
							
							
						</tr>
						<tr bgcolor="#EEEEEE">
						   <td colspan="2">
								递交案子时间			
							</td>
							<td colspan="2">
								<input type="text" name="submitTime"/>
							</td>
						</tr>
						<tr bgcolor="#FFFFFF">
						    <td width="15%">
								未受理原因			
							</td>
							<td width="15%">
								<input type="text" name="refuseReason"/>
							</td>
							<td width="15%">
							    受理结果			
							</td>
							<td width="15%">
								<input type="text" name="resultDeal"/>			
							</td>
						</tr>
						
            		</table>
            	
            		<div style="margin-left: 250px">
            				<input type='submit' value='提交'  />
            				&nbsp;&nbsp;&nbsp;&nbsp;
            				<input type="reset" value='取消'   />
            		</div>
            		</form>
            		
        		</div>
    		</div>


    		<div id="acceptResultList" style="display: none">
        		<h2>录入已报销名单<a   id="btnCloseList">关闭</a></h2>
        		<div class="form">
       
		
		
		
		 <form action="" method="post">
		 	<input type="hidden" name="bxHosNo">
            		<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="demo" id="tableID" ><thead>
            			<tr class="CTitle">
            				<td height="22" colspan="4" align="center" style="font-size: 16px">
            				已报销名单信息表
							</td>
						</tr>
						<tr bgcolor="#FFFFFF">
						    <td width="15%">
								学号			
							</td>
							<td width="15%">
								 <p id="bxStudentNo"></p>
							</td>
							<td width="15%">
							    姓名			
							</td>
							<td width="15%">
							 <p id="bxStudentName"></p>			
							</td>
						</tr>
						<tr bgcolor="#EEEEEE">
						   <td width="15%">
								学院			
							</td>
							<td width="15%">
								 <p id="bxCollege"></p>
							</td>
							<td width="15%">
							    班级			
							</td>
							<td width="15%">
								 <p id="bxClass"></p>			
							</td>
						</tr>
						
						 
		
						<tr bgcolor="#FFFFFF">
						   <td colspan="2">
								住院日期			
							</td>
							<td colspan="2">
								<p id="bxHospitalDate"></p>
							</td>
							
						</tr>
						<tr bgcolor="#EEEEEE">
						   <td colspan="2">
								出院日期			
							</td>
							<td colspan="2">
									<p id="bxLeaveDate"></p>
							</td>
						</tr>
						<tr bgcolor="#FFFFFF">
						    <td width="15%">
								住院天数			
							</td>
							<td width="15%">
								<p id="bxHosDate"></p>
							</td>
							<td width="6%">
							    病情			
							</td>
							<td width="15%">
								<p id="bxConditon"></p>		
							</td>
						</tr>
						<tr bgcolor="#EEEEEE">
						   <td colspan="2">
								本地或转外			
							</td>
							<td colspan="2">
								<p id="bxLocalCity"></p>
								
							</td>
						</tr>
						<tr bgcolor="#FFFFFF">
						   <td colspan="2">
								申请时间			
							</td>
							<td colspan="2">
							<p id="bxApplyTime"></p>
								 
							</td>
						</tr>
						<tr bgcolor="#EEEEEE">
						   <td colspan="2">
								医保处已报销金额			
							</td>
							<td colspan="2">
								<input type="text" name="reimbursementAmount"/>
							</td>
						</tr>
						<tr bgcolor="#FFFFFF">
						    <td width="15%">
								是否有结算清单			
							</td>
							<td width="15%">
								<select name="bill">
									<option value="1">是</option>
									<option value="0">否</option>
								</select>
							</td>
							<td width="15%">
							    领卡时间			
							</td>
							<td width="15%">
								<input type="text" name="getcardTime"/>			
							</td>
						</tr>
						<tr bgcolor="#EEEEEE">
						   <td width="15%">
								总费用			
							</td>
							<td width="15%">
								￥500
							</td>
							<td width="15%">
							    备注			
							</td>
							<td width="15%">
								<input type="text" name="jumingRemark"/>			
							</td>
						</tr>
            		</table>
            	
            		<div style="margin-left: 250px">
            				<input type='submit' value='提交'  />
            				&nbsp;&nbsp;&nbsp;&nbsp;
            				<input type="reset" value='取消'   />
            		</div>
            		</form>
        		</div>
    		</div>

    		<div id="acceptMoney" style="display: none">
        		<h2>录入商业理赔结果<a   id="btnCloseMoney">关闭</a></h2>
        		<div class="form">
        		<form action="">
        		<input type="hidden" name="companyHosNo">
            		<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="demo" id="tableID" ><thead>
            			<tr class="CTitle">
            				<td height="22" colspan="4" align="center" style="font-size: 16px">
            				商业理赔结果信息表
							</td>
						</tr>
						<tr bgcolor="#FFFFFF">
						    <td width="15%">
								学号			
							</td>
							<td width="15%">
								 <p id="companyStudentNo"></p>
							</td>
							<td width="15%">
							    姓名			
							</td>
							<td width="15%">
								<p id="companyStudentName"></p>			
							</td>
						</tr>
						<tr bgcolor="#EEEEEE">
						   <td width="15%">
								学院			
							</td>
							<td width="15%">
								 <p id="companyCollege"></p>
							</td>
							<td width="15%">
							    班级			
							</td>
							<td width="15%">
								 <p id="companyClass"></p>				
							</td>
						</tr>
						<tr bgcolor="#FFFFFF">
						   <td colspan="2">
								住院日期			
							</td>
							<td colspan="2">
								<p id="companyHospitalDate"></p>
							</td>
							
						</tr>
						<tr bgcolor="#EEEEEE">
						   <td colspan="2">
								出院日期			
							</td>
							<td colspan="2">
								<p id="companyLeaveDate"></p>
							</td>
						</tr>
						<tr bgcolor="#FFFFFF">
						    <td width="15%">
								住院天数			
							</td>
							<td width="15%">
									<p id="companyHosDate"></p>
							</td>
							<td width="6%">
							    病情			
							</td>
							<td width="15%">
								<p id="bxConditon"></p>				
							</td>
						</tr>
						<tr bgcolor="#EEEEEE">
						   <td colspan="2">
								本地或转外			
							</td>
							<td colspan="2">
									<p id="companyLocalCity"></p>
							</td>
						</tr>
						<tr bgcolor="#FFFFFF">
						   <td colspan="2">
								申请时间			
							</td>
							<td colspan="2">
								<p id="companyApplyTime"></p>
							</td>
						</tr>
						<tr bgcolor="#EEEEEE">
						   <td colspan="2">
								保险公司接案子的时间			
							</td>
							<td colspan="2">
								<input type="text" name="insurerTime"/>
							</td>
						</tr>
						<tr bgcolor="#FFFFFF">
						    <td colspan="2">
								除结算单材料是否齐全			
							</td>
							<td colspan="2">
								<select name="complete">
									<option value="1">是</option>
									<option value="0">否</option>
								</select>
							</td>
						</tr>
						<tr bgcolor="#EEEEEE">
						    <td colspan="2">
								银行卡号			
							</td>
							<td colspan="2">
								 <p id="companyBankcardID"></p>
							</td>
						</tr>
						<tr bgcolor="#FFFFFF">
						    <td colspan="2">
								没有结算的原因			
							</td>
							<td colspan="2">
								<input type="text" name="notinsurerReason"/>
							</td>
						</tr>
						<tr bgcolor="#EEEEEE">
						   <td width="15%">
								总费用			
							</td>
							<td width="15%">
								￥500
							</td>
							<td width="15%">
							    备注			
							</td>
							<td width="15%">
								<input type="text" name="companyRemark"/>			
							</td>
						</tr>
            		</table>
            	
            		<div style="margin-left: 250px">
            				<input type='submit' value='提交'   />
            				&nbsp;&nbsp;&nbsp;&nbsp;
            				<input type="reset" value='取消'   />
            		</div>
            		</form>
        		</div>
    		</div>
		 
		<form name="fom" id="fom" method="post" action="<%=basePath%>hosInsuranceInfo/hosInsuranceQuery!queryHosByCondition">
    	<div id="advancedDiv" style="display: none"></div>
    		<div id="advancedSearchDiv" style="display: none">
             	<h2>高级查询选项<a href="#" id="CloseadvancedSearch">关闭</a></h2>
        	<div class="form">
            	<table width="50%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="demo" id="advancedSearchTab" ><thead>
                      
                      <tr bgcolor="#FFFFFF" align="center">
					    <td width='15%' > 
					    	是否领卡
					    </td>
					    <td width='35%' > 
					    	<select name="collarCard">
					    		<option value="1">以领卡</option>
					    		<option value="-1">未领卡</option>
					    		
					    	</select>	
					    </td>
					</tr>
            
				　
					<tr bgcolor="#FFFFFF" align="center">
					    <td width='15%'  > 
					    	类别
					    </td>
					    <td width='35%'  > 
					    	 <select name="hosType" class="span2">
                        <optgroup label="居民医保">
                        	<option  value="居民医保住院未刷卡">已住院未刷卡</option>
                        	<option  value="居民医保住院已刷卡">已住院已刷卡</option>
                        	<option  value="居民医保未刷卡">未刷卡</option>
                        </optgroup>
                         <optgroup label="大病医保">
                        	<option value="大病医保住院未刷卡">已住院未刷卡</option>
                        	<option value="大病医保住院已刷卡">已住院已刷卡</option>
                        	<option value="大病医保未刷卡">未刷卡</option>
                        </optgroup>
                        
                        
                         <optgroup label="商业医保" >
                        	<option value="商业医保住院未刷卡">已住院未刷卡</option>
                        	<option value="商业医保住院已刷卡">已住院已刷卡</option>
                        	<option value="商业医保未刷卡">未刷卡</option>
                        </optgroup>
                      </select>
					    </td>
					</tr>
					　
					 
					<tr bgcolor="#FFFFFF" align="center">
					    <td width='15%'> 
					    	审核状态
					    </td >
					    <td width='35%' > 
					  		 <select name='hosState'>
					   
					    		<option value="通过"> 通过</option>
					    	    <option value="校级审核中">校级审核中</option>
					    	    <option value="校级未通过">校级未通过</option>
					    	</select>	
					    </td>
					</tr>
					
					<tr bgcolor="#FFFFFF" align="center">
						<td colspan="2"><input type="submit" value="查询"/></td>
					</tr>
            	</table>
            	
        	</div>
    	</div>
    	</form>
    
	</body>
    
 	    <script src="<%=basePath%>js/jquery-1.10.2.js"></script>
		<script src="<%=basePath%>js/testSearch.js"></script>
	    <script src="<%=basePath%>js/jquery.chromatable.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/school/school.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/util/loadCollegeClass.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/school/xionganping_yibao.js"></script>
</html>
