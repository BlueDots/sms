<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>医保申请</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 
   <link rel="stylesheet" rev="stylesheet" href="<%=basePath%>/css/style.css"
			type="text/css" media="all" />
	<style type="text/css">
	.STYLE1 {
		font-size: 16px;
		font-weight: bold;
	}
	div {
		font-size: 16px
	}
	</style>

  </head>
  
  
<body>
      <div id="lurubiao" style="margin-left:10px">
					<table width="99%" border="0" cellpadding="4" cellspacing="1" class="CContent">
						<th class="tablestyle_title">
								医保申请
						</th>
						</tr>
						<tr>
						<td>
	<form name="MedApplication" id="MedApplication" action="" method="post">
	<table width="100%" border="0" cellpadding="8" cellspacing="0" class="newfont03">
  <tr>
    <td width="50%"><div align="right"><strong>联系电话</strong></div></td>
    <td width="50%"><label>
      <input type="text" name="textfield3" />
    </label></td>
  </tr>
   <tr>
    <td width="50%"><div align="right"><strong>银行卡号</strong></div></td>
    <td width="50%"><label>
      <input type="text" name="textfield3" />
    </label></td>
  </tr>
  <tr>
    <td width="50%"><div align="right"><strong>住院地址</strong></div></td>
    <td width="50%"><label>
      <input type="text" name="textfield4" />
    </label></td>
  </tr>
  <tr>
    <td width="50%"><div align="right"><strong>住院日期</strong></div></td>
    <td width="50%"><label>
     <input name="enterDate" type="text" class="input-xlarge datepicker" id="enterDate" value="02/16/12"/> 
    </label></td>
  </tr>
  <tr>
    <td width="50%"><div align="right"><strong>出院日期</strong></div></td>
    <td width="50%"><label>
     <input name="leaveDate" type="text" class="input-xlarge datepicker" id="leaveDate" value="02/16/12"/>  
    </label></td>
  </tr>
    <tr>
    <td width="50%"><div align="right"><strong>住院天数</strong></div></td>
    <td width="50%"><label>
      <input type="text" name="textfield5" />
    </label></td>
  </tr>
  <tr>
    <td width="50%"><div align="right"><strong>本市或转外</strong></div></td>
    <td width="50%"> 
                  <div align="left">
                      <select name="select2" class="span2">
                        <option>本市</option>
                        <option>转外</option>
                      </select>
            </div></td>
  </tr>
  <tr>
    <td width="50%" height="85"><div align="right"><strong>诊断病情</br>
            </br>
    </strong></div></td>
    <td width="50%"><label>
	  <textarea name="diagnoise" cols="20" rows="5"></textarea>
    </label></td>
  </tr>
  <tr>
    <td width="50%"><div align="right"><strong>总费用</strong></div></td>
    <td width="50%"><label>
      <input type="text" name="textfield10" />
    </label></td>
  </tr>
   <tr>
    <td width="50%"><div align="right"><strong>申请时间</strong></div></td>
    <td width="50%"><label>
      <input type="text" name="textfield6" />
    </label></td>
  </tr>
  <tr>
    <td colspan="2" ><div align="center"> 
       <input type="button" value="保存" onclick="alert('保存成功！');"/>
        <input type="button" value="提交" onclick="alert('提交成功！');"/>
    </div></td>
  </tr>
      </table>
	  </form>
	  </td>
	</tr>
   </table>   
   </div>
</body>
</html>
