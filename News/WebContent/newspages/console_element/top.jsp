<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri='/struts-tags' prefix='s' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<s:if test="#session.admin==null">
	<script type="text/javascript">
		alert("��ǰҳ��������ޣ������µ�¼�����˻���");
		open("/News/index","_self");	
	</script>
</s:if>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>���ŷ���ϵͳ�����̨</title>
<link href="/News/CSS/admin.css" rel="stylesheet" type="text/css" />
<div id="header">
  <div id="welcome">��ӭʹ�����Ź���ϵͳ��</div>
  <div id="nav">
    <div id="a_b01"><img src="/News/Images/adminBanner.jpg" alt="" /></div>
  </div>
</div>
<div id="admin_bar">
  <div id="status">����Ա�� ��¼  &#160;&#160;&#160;&#160; <a href="/News/loginout">ע��</a></div>
  <div id="channel"> </div>
</div>
</head>
<body>
