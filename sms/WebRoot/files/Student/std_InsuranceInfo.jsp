<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib prefix="s" uri="/struts-tags" %>

<s:debug></s:debug>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'std_InsuranceInfo.jsp' starting page</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" rev="stylesheet" href="<%=basePath%>css/style.css"
      type="text/css" media="all" />
<link href="<%=basePath%>css/css.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/arrow.css" rel="stylesheet" type="text/css" />

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
<script language=JavaScript>
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
<script src="<%=basePath%>js/jquery-1.10.2.min.js">
</script>
<script src="<%=basePath%>js/testSearch.js">
</script>
<script src="<%=basePath%>js/provincesdata.js">
</script>
<script src="<%=basePath%>js/jquery.provincesCity.js">
</script>
<style type="text/css">
.STYLE1 {
  font-size: 16px;
  font-weight: bold;
}

div {
  font-size: 16px
}
.STYLE3 {color: #FFFFFF}
</style>
</head>
<SCRIPT language=JavaScript>
function tupian(idt){
    var nametu="xiaotu"+idt;
    var tp = document.getElementById(nametu);
    tp.src="../images/ico05.gif";//ͼƬico04Ϊ��ɫ������
  
  for(var i=1;i<30;i++)
  {
    
    var nametu2="xiaotu"+i;
    if(i!=idt*1)
    {
      var tp2=document.getElementById('xiaotu'+i);
    if(tp2!=undefined)
      {tp2.src="../images/ico06.gif";}//ͼƬico06Ϊ��ɫ������
    }
  }
}

function list(idstr){
  var name1="subtree"+idstr;
  var name2="img"+idstr;
  var objectobj=document.all(name1);
  var imgobj=document.all(name2);
  
  
  //alert(imgobj);
  
  if(objectobj.style.display=="none"){
    for(i=1;i<10;i++){
      var name3="img"+i;
      var name="subtree"+i;
      var o=document.all(name);
      if(o!=undefined){
        o.style.display="none";
        var image=document.all(name3);
        //alert(image);
        image.src="../../images/ico04.gif";
      }
    }
    objectobj.style.display="";
    imgobj.src="../../images/ico03.gif";
  }
  else{
    objectobj.style.display="none";
    imgobj.src="../../images/ico04.gif";
  }
}

</SCRIPT>

  </head>
  <body>
  
  
  
<div id="lurubiao" style="margin-left:10px">
  <table width="99%" border="0" cellpadding="0" cellspacing="0"
            class="newfont03" style="border-collapse:collapse">
    <tr>
     <td class="tablestyle_title" width="15%">
       <div align="left">
          <span class="STYLE1">医保信息>><a href="<%=basePath%>files/Student/std_InsuranceApply.jsp"><font color="red">申请医保</font></a></span></div>
   </td>
   
    </tr>
  </table>
  </div>
  <br />
  <br />
  
<div id="lurubiao" style="margin-left:10px height:400px;overflow-x:scroll">
  <table width="99%" border="0" cellpadding="0" cellspacing="0"
            class="newfont03">
    <tr>
     <td class="tablestyle_title" colspan="2">
       <div align="left">
            <span class="STYLE1">居民医保</span>
           <input type="button" name="Otput" value="导出"
                  onclick="alert('导出成功！');" />
      </div>
   </td>
    </tr>
  
    <tr>
      <td colspan="2">
    <table width="100%" border="1" cellpadding="4" cellspacing="1" class="newfont03">
          <tr>
  <td colspan="2"><table width="100%" border="1" cellpadding="4" cellspacing="1" class="newfont03" style="border-collapse:collapse">
      <tr height="32">
        <td width="100"><div align="center"><b>选择</b></div></td>
        <td height="100" width="86"><div align="center"><strong>序号</strong></div></td>
  
    <td width="300"><div align="center"><strong>联系电话</strong></div></td>
        <td width="300"><div align="center"><strong>住院地址</strong></div></td>
        <td width="300"><div align="center"><strong>住院日期</strong></div></td>
        <td width="300"><div align="center"><strong>出院日期</strong></div></td>
    <td width="200"><div align="center"><strong>住院天数</strong></div></td>
        <td width="200"><div align="center"><strong>本市或转外</strong></div></td>
        <td width="300"><div align="center"><strong>诊断病情</strong></div></td>
        <td width="200"><div align="center"><strong>总费用</strong></div></td>
        <td width="300"><div align="center"><strong>申请时间</strong></div></td>
    <td width="200"><div align="center"><strong>是否受理</strong></div></td>
        <td width="200"><div align="center"><strong>是否领卡</strong></div></td>
    <td width="500"><div align="center"><strong>详情</strong></div></td>
      </tr>
      <tr height="18">
        <td><input type="checkbox" name="checkbox" value="checkbox" align="left"/></td>
        <td height="18">2013001</td>
         
        <td>　</td>
        <td>　</td>
        <td>　</td>
        <td>　</td>
        <td>　</td>
        <td>　</td>
    <td>　</td>
        <td>　</td>
        <td>　</td>
        <td>　</td>
        <td>　</td>
        <td>　</td>
      </tr>
      <tr height="18">
        <td><input type="checkbox" name="checkbox" value="checkbox" align="left"/></td>
        <td height="18">2013002</td>
    
        <td>　</td>
        <td>　</td>
        <td>　</td>
        <td>　</td>
        <td>　</td>
        <td>　</td>
    <td>　</td>
        <td>　</td>
        <td>　</td>
        <td>　</td>
        <td>　</td>
        <td>　</td>
      </tr>
      <tr height="18">
        <td><input type="checkbox" name="checkbox" value="checkbox" align="left"/></td>
        <td height="18">2013003</td>
         
        <td>　</td>
        <td>　</td>
        <td>　</td>
        <td>　</td>
        <td>　</td>
        <td>　</td>
    <td>　</td>
        <td>　</td>
        <td>　</td>
        <td>　</td>
        <td>　</td>
        <td>　</td>
      </tr>
      </table>
   </td>
  </tr>
   </table>   
    </td>
   </tr>  
   </table>
   </div>
   <br />
   <br />
   <div id="lurubiao" style="margin-left:10px  height:400px;overflow-x:scroll">
  <table width="99%" border="0" cellpadding="0" cellspacing="0"
            class="newfont03">
    <tr>
     <td class="tablestyle_title" colspan="2">
       <div align="left">
            <span class="STYLE1">商业保险</span>
           <input type="button" name="Otput" value="导出"
                  onclick="alert('导出成功！');" />
      </div>
   </td>
    </tr>
  
   <tr>
      <td colspan="2">
    <table width="100%" border="1" cellpadding="4" cellspacing="1" class="newfont03">
          <tr>
  <td colspan="2"><table width="100%" border="1" cellpadding="4" cellspacing="1" class="newfont03" style="border-collapse:collapse">
      <tr height="32">
        <td width="100"><div align="center"><b>选择</b></div></td>
        <td height="100" width="86"><div align="center"><strong>序号</strong></div></td>
      
        <td width="300"><div align="center"><strong>联系电话</strong></div></td>
        <td width="300"><div align="center"><strong>银行卡号</strong></div></td>
        <td width="200"><div align="center"><strong>除结算单材料是否齐全</strong></div></td>
        <td width="300"><div align="center"><strong>接案子日期</strong></div></td>
        <td width="300"><div align="center"><strong>未报销原因</strong></div></td>
        <td width="300"><div align="center"><strong>类型</strong></div></td>
    <td width="500"><div align="center"><strong>详细</strong></div></td>
      </tr>
      <tr height="18">
        <td><input type="checkbox" name="checkbox" value="checkbox" align="left"/></td>
        <td height="18">2013001</td>
        
        <td>　</td>
        <td>　</td>
        <td>　</td>
        <td>　</td>
        <td>　</td>
        <td>　</td>
    <td>　</td>
      </tr>
      <tr height="18">
        <td><input type="checkbox" name="checkbox" value="checkbox" align="left"/></td>
        <td height="18">2013002</td>
        
        <td>　</td>
        <td>　</td>
        <td>　</td>
        <td>　</td>
        <td>　</td>
        <td>　</td>
    <td>　</td>
      </tr>
      <tr height="18">
        <td><input type="checkbox" name="checkbox" value="checkbox" align="left"/></td>
        <td height="18">2013003</td>
        
        <td>　</td>
        <td>　</td>
        <td>　</td>
        <td>　</td>
        <td>　</td>
        <td>　</td>
    <td>　</td>
      </tr>
      </table>
   </td>
  </tr>
   </table>   
    </td>
   </tr>  
   </table>
   </div>
</body>
  
</html>
