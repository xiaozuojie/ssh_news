<%@ page language="java" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri='/struts-tags' prefix='s' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<title>新闻中国</title>
	
	<link href="CSS/main.css" rel="stylesheet" type="text/css" />
	<script language="javascript">
		function check(){
			var loginName = document.getElementById("loginName");
			var loginPwd = document.getElementById("loginPwd");
			if(loginName.value == ""){
				alert("用户名不能为空！请重新填入！");
				loginName.focus();	
				return false;
			}else if(loginPwd.value == ""){
				alert("密码不能为空！请重新填入！");
				loginPwd.focus();
				return false;
			}
			return true;
		}
		
		function focusOnLogin(){
			var loginPwd = document.getElementById("loginPwd");
			if( loginPwd != null )
				loginPwd.focus();	
		}
	</script>
</head>
<body onload="focusOnLogin()">
<div id="header">
	<div id="top_login">	
	<s:if test="#session.admin==null">
		<form action="validateLogin" method="post" onsubmit="return check()">
		    <label>用户名</label>
			<input type="text" id="loginName"  name="loginName" value="" class="login_input" />
			<label> 密&#160;&#160;码 </label>
			<input type="password" id="loginPwd" name="loginPwd" value="" class="login_input" />
			<input type="submit" class="login_sub" value="登录" />
			<label id="error"> </label>			
		</form>
	</s:if>
	<s:if test="#session.admin!=null">
		欢迎您 ：<s:property value="#session.admin.loginName" />  &nbsp; &nbsp; &nbsp;<a href="/News/admin">登录控制台</a> &nbsp; <a href="loginout">退出</a>
	</s:if>
  </div>
  <div id="nav">
	  <table>
	    <tr>
	    	<div id="a_b01"><img src="/News/Images/adminBanner.jpg" alt="" /></div>
	    </tr>
	  </table>
    <!--mainnav end-->
  </div>
</div>
<center>联系QQ：<font color=red>287307421或者254540457</font> &nbsp;更多程序设计请到：<a href="http://www.chengxusheji.cn" target="_blank">www.chengxusheji.cn</a>或者<a href="http://www.shuangyulin.com" target="_blank">www.shuangyulin.com</a></center>
</body>
</html>

