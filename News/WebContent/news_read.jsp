<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri='/struts-tags' prefix='s' %>
<jsp:include page="index-elements/index_top.jsp" />
<link href="CSS/read.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function checkComment(){
		var cauthor = document.getElementById("cauthor");
		var content = document.getElementById("ccontent");
		if(cauthor.value == ""){
			alert("用户名不能为空！！");
			return false;
		}else if(content.value == ""){
			alert("评论内容不能为空！！");
			return false;
		}
		return true;
	}
</script>
<div id="container">
  <jsp:include page="index-elements/index_sidebar.jsp"></jsp:include>
  <div class="main">
    <div class="class_type"> <img src="Images/class_type.gif" alt="新闻中心" /> </div>
    <div class="content">
      <ul class="class_date">
      	<li id='class_month'>      	
      	 <s:iterator id="topic" value="#request.topicList">
      	 	<a href="index?tid=${topic.id}"><b>${topic.name}</b></a>
      	 </s:iterator>
      </ul>
      <ul class="classlist">
        <table width="80%" align="center">
          <tr width="100%">
            <td colspan="2" align="center">${newsinfo.title}</td>
          </tr>
          <tr>
            <td colspan="2"><hr />
            </td>
          </tr>
          <tr>
            <td align="center">作者：${newsinfo.author}&nbsp;&nbsp;
                                类型：<a href="index?tid=${newsinfo.topic.id}">${newsinfo.topic.name}</a>
                               发布时间：${newsinfo.createDate}</td>
          </tr>
          <tr>
            <td align="left"><strong>摘要：${newsinfo.summary}</strong></td>
          </tr>
          <tr>
            <td colspan="2" align="center"></td>
          </tr>
          <tr>
            <td colspan="2">${newsinfo.content}</td>
          </tr>
          <tr>
            <td colspan="2"><hr />
            </td>
          </tr>
        </table>
      </ul>
    </div>
  </div>
</div>
