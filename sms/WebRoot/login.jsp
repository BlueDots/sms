<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link href="<%=basePath%>/css/css.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath%>/js/admin/jquery-1.7.2.min.js"></script>

<script type="text/javascript">
function login(){
	
	var username = $("#username").attr("value");
	var password = $("#password").attr("value");
	var roleName = $("#roleName").attr("value");
	
	if(username==''){	
	
		alert("用户名不能为空");
		
	}else if(password==''){	
	
		alert("密码不能为空");
		
	}else {
	
		$.get("login!execute?username="+username+"&password="+password+"&roleName="+roleName,function(data){
	
    		alert(data);
	        
	        if(data=='登录成功'){
	        
	        	if(roleName == '学生') {
					window.location.href = "index_student.jsp";
				} else if(roleName == '班主任') {
					window.location.href = "index_tutor.jsp";
				} else if(roleName == '院级工作人员') {
					window.location.href = "index_college.jsp";
				} else if(roleName == '校级工作人员') {
					window.location.href = "index_school.jsp";
				} else if(roleName == '院级管理员') {
					window.location.href = "index_admin.jsp";
				} else if(roleName == '校级管理员'){
				    window.location.href="admin_index.jsp";
				}
	        	
	        	
	        	
	        }
	        
     	});
	
	}
	
	  
	
	
	
}


</script>



</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="147" background="<%=basePath%>/images/top02.gif"><img src="images/top03.gif" width="776" height="147" /></td>
  </tr>
</table>

<table width="562" border="0" align="center" cellpadding="0" cellspacing="0" class="right-table03">
  <tr>
    <td width="221">
    	<table width="95%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
      
	      <tr>
	        <td>
	        	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
		          	<tr>
		            	<td align="center"><img src="images/ico13.gif" width="107" height="97" /></td>
		          	</tr>
		          	<tr>
		            	<td height="40" align="center">&nbsp;</td>
		          	</tr>
				</table>
			</td>
	        <td><img src="images/line01.gif" width="5" height="292" /></td>
	      </tr>
    	</table>
    </td>
    
    <td>
   		
    	<table width="100%" border="0" cellspacing="0" cellpadding="0">
      		<tr>
      			<td valign="top"><br/></td>
      			<td width="31%" height="35" class="login-text02">登陆角色：<br/>
      			</td>
      			<td width="69%">
      				<select id="roleName">
		      			<option>学生</option>
		      			<option>班主任</option>
		      			<option>院级工作人员</option>
		      			<option>校级工作人员</option>
		      			<option>院级管理员</option>
		      			<option>校级管理员</option>
      				</select>
      			</td>
      		</tr> 
		    <tr>
		        <td valign="top"><br/></td>
		        <td width="31%" height="35" class="login-text02">用户名：<br/></td>
		        <td width="69%"><input name="username" type="text" size="30" id="username"/></td>
		    </tr>
		    <tr>
		       	<td valign="top"><br /></td>
		        <td height="35" class="login-text02">密　码：<br /></td>
		        <td><input name="password" type="password" size="30" id="password"/></td>
		    </tr>
      		<tr>
		        <td valign="top"><br /></td>
		        <td height="35">&nbsp;</td>
		        <td>
		          <input name="" type="button" class="right-button01" value="确认登陆" onclick="javascript:login();"/> 
		          <input name="Submit232" type="reset" class="right-button02" value="重 置" />
        		</td>
      		</tr>
    	</table>
    	
    </td>
  </tr>
</table>
</body>
</html>
