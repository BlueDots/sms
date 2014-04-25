<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@  taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<title>江西农业大学学生工作管理系统</title>

<link rel="stylesheet" href="<%=basePath%>/css/zTreeStyle/demo.css" type="text/css">
<!--左侧选项栏的css格式文件-->
<link rel="stylesheet" href="<%=basePath%>/css/zTreeStyle/zTreeStyle.css"
	type="text/css">
<!--树节点样式文件-->
<link href="<%=basePath%>css/css.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
<!--表格样式文件-->
<link href="<%=basePath%>css/jquery-ui.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/arrow.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.ztree.core-3.5.js"></script>

<style type="text/css">
* {
	margin: 0;
	padding: 0;
	list-style-type: none;
}

.demo {
	border: solid 1px #D5D5D5;
	border-collapse: collapse;
	width: 100%;
}

.demo td {
	border: 1px solid #D5D5D5;
	font-size: 12px;
	padding: 7px 5px;
}

.demo th {
	background-color: #EEE;
	border-right: 1px solid #D5D5D5;
	font-size: 13.5px;
	line-height: 120%;
	font-weight: bold;
	padding: 8px 5px;
	text-align: right;
}
</style>

<SCRIPT type="text/javascript">
<!--
	var setting = {
		data : {
			simpleData : {
				enable : true
			}
		}
	};

	var zNodes =[
      { id:1, pId:0, name:"功能模块", open:true},
      { id:11, pId:1, name:"学生基本信息",url:"<%=basePath%>files/college/dept_basicInfo.jsp", target:"mainFrame"},
      { id:12, pId:1, name:"教师基本信息",url:"dept_teacherInfoManagement.html", target:"mainFrame"},
      { id:13, pId:1, name:"学生参与活动",url:"<%=basePath%>files/college/dept_activityInfo.html", target:"mainFrame"},
      { id:14, pId:1, name:"活动管理",url:"<%=basePath%>files/college/dept_activityManage.html", target:"mainFrame"},
      { id:15, pId:1, name:"评优评先",url:"<%=basePath%>/files/college/dept_advanceInfo.jsp", target:"mainFrame"},
      { id:16, pId:1, name:"奖助学金信息",url:"<%=basePath%>/files/college/dept_scholarshipInfo.jsp", target:"mainFrame"},
      { id:17, pId:1, name:"奖学金评定",url:"dept_scholarshipAssess.html", target:"mainFrame"},
      { id:18, pId:1, name:"处分信息",url:"dept_punishInfo.html", target:"mainFrame"},
      { id:19, pId:1, name:"学籍变动",url:"dept_statusInfo.html", target:"mainFrame"},
      { id:20, pId:1, name:"就业信息",url:"dept_jobInfo.html", target:"mainFrame"},
      { id:21, pId:1, name:"贫困建档",url:"<%=basePath%>/files/college/dept_poverty.jsp",target:"mainFrame"}, 
      {
		id : 2,
		pId : 0,
		name : "软件学院"
	}, {
		id : 21,
		pId : 2,
		name : "物联网",
		open : true
	}, {
		id : 211,
		pId : 21,
		name : "叶子节点211"
	}, {
		id : 212,
		pId : 21,
		name : "叶子节点212"
	}, {
		id : 213,
		pId : 21,
		name : "叶子节点213"
	}, {
		id : 214,
		pId : 21,
		name : "叶子节点214"
	}, {
		id : 22,
		pId : 2,
		name : "软件英语"
	}, {
		id : 221,
		pId : 22,
		name : "叶子节点221"
	}, {
		id : 222,
		pId : 22,
		name : "叶子节点222"
	}, {
		id : 223,
		pId : 22,
		name : "叶子节点223"
	}, {
		id : 224,
		pId : 22,
		name : "叶子节点224"
	}, {
		id : 23,
		pId : 2,
		name : "软件开发"
	}, {
		id : 231,
		pId : 23,
		name : "叶子节点231"
	}, {
		id : 232,
		pId : 23,
		name : "叶子节点232"
	}, {
		id : 233,
		pId : 23,
		name : "叶子节点233"
	}, {
		id : 234,
		pId : 23,
		name : "叶子节点234"
	}, {
		id : 3,
		pId : 0,
		name : "外语学院",
		isParent : true
	} ];

	$(document).ready(function() {
		$.fn.zTree.init($("#treeDemo"), setting, zNodes);
	});
//-->
</SCRIPT>
</head>
<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
				<div class="content_wrap">
					<div class="zTreeDemoBackground left">
						<ul id="treeDemo" class="ztree"></ul>
					</div>
				</div>
			</td>
			<td><img src="<%=basePath%>/images/welcome.gif">
			</td>
			<!--登陆成功显示的欢迎页面-->
			<!--
    <td> 点击班级时显示班级所有学生粗略的基本信息
       <div id="allbasicMsg" style="float:left;display:block;margin-top:0px;margin-left:10px;height:565px">使div向左浮动
              <table id="subtree1" style="margin-top:0px;" width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td class="CPanel">
                    <div id="liulanbiao" style="margin-left: 10px">
                      <table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
                        <tr>
                          <th class="tablestyle_title">
                            当前位置：学生基本信息
                          </th>
                        </tr>
                        <tr>
                          <td class="CPanel" align="center">
                            <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
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
                                        6级
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
                                        6级
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
                                        6级
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
                      </table>
                    </div>
                  </td>
                </tr>
              </table>
            </div>  
     -->
			</td>
		</tr>
	</table>
</body>


<script type="text/javascript" src="<%=basePath %>js/college/collegeJSON.js" >

	
</script>

</html>
