<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>个人简历</title>
<link rel="stylesheet" rev="stylesheet" href="../../css/style.css"
			type="text/css" media="all" />
<link href="../../css/css.css" rel="stylesheet" type="text/css" />
<link href="../../css/style.css" rel="stylesheet" type="text/css" />
<link href="../../css/arrow.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">

var menuids = [ "suckertree1" ]

function buildsubmenus() {
	for ( var i = 0; i < menuids.length; i++) {
		var ultags = document.getElementById(menuids[i]).getElementsByTagName(
				"ul")
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
	window.addEventListener("load", buildsubmenus, false)
else if (window.attachEvent)
	window.attachEvent("onload", buildsubmenus)</script>
<script language=JavaScript>
//window.setTimeout(output,2000);
function output(){
	alert("导出成功!");
}

function viewmypic(mypic,imgfile) {
if (imgfile.value){
mypic.src=imgfile.value;
mypic.style.display="";
mypic.border=1;
}
}
function sousuo() {
	window
			.open(
					"gaojisousuo.htm",
					"",
					"depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
}
function selectAll() {
	var obj = document.fom.elements;
	for ( var i = 0; i < obj.length; i++) {
		if (obj[i].name == "delid") {
			obj[i].checked = true;
		}
	}
}

function unselectAll() {
	var obj = document.fom.elements;
	for ( var i = 0; i < obj.length; i++) {
		if (obj[i].name == "delid") {
			if (obj[i].checked == true)
				obj[i].checked = false;
			else
				obj[i].checked = true;
		}
	}
}

function link() {
	document.getElementById("fom").action = "../addrenwu.htm";
	document.getElementById("fom").submit();
}
</script>
<script src="../../js/jquery-1.7.2.min.js">
</script>
<script src="../../js/testSearch.js">
</script>
<script src="../../js/provincesdata.js">
</script>
<script src="../../js/jquery.provincesCity.js">
</script>
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
					<table width="99%" border="1"  class="CContent">
						<tr>
     <td class="tablestyle_title" width="15%">
	     <div align="left">
	          <span class="STYLE1">基本信息</span>
           <input type="button" name="Otput" value="导出"
									onclick="output()" />
		  </div>
	 </td>
	
    </tr>
	<tr>
	<td colspan="2">
	<table width="100%" border="1" cellpadding="4" cellspacing="1 " class="newfont03" style="border-collapse:collapse">
       <tr>
                    <td width="125" bgcolor="#FFFFFF" colspan = "5"><div align="center"><span  class="STYLE9"><b>个人情况</b> </span></div></td>
                  </tr>
                  <tr>
                    <td width="125" bgcolor="#FFFFFF"><div align="center"><span  class="STYLE9"><b>姓名</b><br /></span></div><br /></td>
                    <td width="162" bgcolor="#FFFFFF"><div align="center"><span align="center" class="STYLE9"></span><s:property value="#request.vita.studentInfo.studentName"/></div></td>
                    <td width="153" bgcolor="#FFFFFF"><div align="center"><span align="center" class="STYLE9"><b>性别</b><br /> </span></div><br /></td>
                    <td width="153" bgcolor="#FFFFFF"><div align="center"><span align="center" class="STYLE9"></span><s:if test="%{#request.vita.studentInfo.sex='1'}">女</s:if>
                    　<s:else>男</s:else></div></td>
                    <td width="90" height="120" rowspan="4" bgcolor="#FFFFFF" align="center" style="padding-left:50px"><img src="img/luoweifu.jpg" alt="protrait" width="90" height="120" /></td>
                  </tr>
                  <tr>
                    <td width="125" bgcolor="#FFFFFF"><div align="center"><span  class="STYLE9"><b>名族</b><br /></span></div><br /></td>
                    <td width="162" bgcolor="#FFFFFF"><div align="center"><span align="center" class="STYLE9"><s:property value="#request.vita.studentInfo.nation"/></span></div></td>
                    <td width="153" bgcolor="#FFFFFF"><div align="center"><span align="center" class="STYLE9"><b>籍贯</b><br /> </span></div><br /></td>
                    <td width="153" bgcolor="#FFFFFF"><div align="center"><span align="center" class="STYLE9"></span><s:property value="#request.vita.studentInfo.hometown"/></div></td>
                  </tr>
                  <tr>
                    <td width="125" bgcolor="#FFFFFF"><div align="center"><span  class="STYLE9"><b>政治面貌</b><br /></span></div><br /></td>
                    <td width="162" bgcolor="#FFFFFF"><div align="center"><span align="center" class="STYLE9"></span><s:property value="#request.vita.studentInfo.studentName"/></div></td>
                    <td width="153" bgcolor="#FFFFFF"><div align="center"><span align="center" class="STYLE9"><b>出生年月</b><br /> </span></div><br /></td>
                    <td width="153" bgcolor="#FFFFFF"><div align="center"><span align="center" class="STYLE9"></span><s:property value="#request.vita.studentInfo.birthday"/></div></td>
                  </tr>
                  <tr>
                    <td width="125" bgcolor="#FFFFFF"><div align="center"><span  class="STYLE9"><b>专业</b><br /></span></div><br /></td>
                    <td width="162" bgcolor="#FFFFFF"><div align="center"><span align="center" class="STYLE9"></span><s:property value="#request.vita.studentInfo.major"/></div></td>
                    <td width="153" bgcolor="#FFFFFF"><div align="center"><span align="center" class="STYLE9"><b>学制</b><br /> </span></div><br /></td>
                    <td width="153" bgcolor="#FFFFFF"><div align="center"><span align="center" class="STYLE9"></span>四年</div></td>
                  </tr>
                 
                  <tr>
                    <td width="125" bgcolor="#FFFFFF"><div align="center"><span  class="STYLE9">手机号<br /></span></div><br /></td>
                    <td width="162" bgcolor="#FFFFFF"><div align="center"><span align="center" class="STYLE9"></span><s:property value="#request.vita.studentInfo.telephone"/></div></td>
                    <td width="153" bgcolor="#FFFFFF"><div align="center"><span align="center" class="STYLE9"><b>个人邮箱</b><br /> </span></div><br /></td>
                    <td width="153" bgcolor="#FFFFFF" colspan = "3"><div align="center"><span align="center" class="STYLE9"></span><s:property value="#request.vita.studentInfo.email"/></div></td>
                  </tr>
                          
               </div></td>                   
                   <tr>
                    <td width="125" bgcolor="#FFFFFF" colspan = "5"><div align="center"><span  class="STYLE9"><b>学生活动</b><br /> </span></div><br /></td>
                  </tr>
                  <tr> 
                    <td width="125" bgcolor="#FFFFFF" colspan = "5" rolspan="5" style="line-height: 150%"><span style="color: rgb(0, 0, 0); font-family: Verdana,Arial,Helvetica,sans-serif; font-size: 16px; font-style: normal;
                     font-variant: normal; font-weight: normal; letter-spacing: normal; line-height: 24px; text-align: start; text-indent: 0px; text-transform: none; white-space: normal; word-spacing: 0px; background-color: rgb(255, 255, 255); 
                     display: inline ! important; float: none;">
                    学生干部职位和任职时间：<s:property value="#request.vita.participate.studentPost"/>
                    <s:property value="#request.vita.participate.workingTime"/>
                    <br>活动名称和等级： <s:property value="#request.vita.participate.activityName"/>
                   <s:property value="#request.vita.participate.activityRating"/>
                    </span></td>
                  </tr>
                   <tr>
                    <td width="125" bgcolor="#FFFFFF" colspan = "5"><div align="center"><span  class="STYLE9"><b>评优评先</b><br /> </span></div><br /></td>
                  </tr>
                  <tr> 
                    <td width="125" bgcolor="#FFFFFF" colspan = "5" rolspan="5" style="line-height: 150%"><div><span  class="STYLE9"> </span>
                先进项目和时间:     <s:property value="#request.vita.advance[0].advanceActivity"/>&nbsp;&nbsp;&nbsp;
                  
                  
                  </tr>
                   <tr>
                    <td width="125" bgcolor="#FFFFFF" colspan = "5"><div align="center"><span  class="STYLE9"><b>奖助学金<br /> 
                      </b> </span></div><br /></td>
                  </tr>
                  <tr> 
                    <td width="125" bgcolor="#FFFFFF" colspan = "5" rolspan="5" style="line-height: 150%"><div><span  class="STYLE9"><b></b> </span>
                   名称和金额： <s:property value="#request.vita.advance[0].activityName"/>
                     <s:property value="#request.vita.advance[0].grantMoney"/>元
                    <br></div></td>
                  </tr>
            
</body>
</html>