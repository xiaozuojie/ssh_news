<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri='/struts-tags' prefix='s' %>
<jsp:include page="index-elements/index_top.jsp" />
<div id="container">
<s:action name="indexsidebar" namespace="/" executeResult="true" />
  <div class="main">
    <div class="class_type"> <img src="Images/class_type.gif" alt="��������" /> </div>
    <div class="content">
      <ul class="class_date">
      	<li id='class_month'>    
      	 <!-- ѭ����ʾ�����б� -->  	
      	 <s:iterator id="topic" value="#request.topicList">
      	 	<a href="index?newsinfo.topic.id=${topic.id}"><b>${topic.name}</b></a>
      	 </s:iterator>
      </ul>
      <ul class="classlist"> 
        <!-- ѭ����ʾ��ǰҳ�����б� -->     
        <s:iterator id="news" value="#request.newsinfoList">
            <li><a href="newsread?id=${news.id}"> ${news.title} </a>
      	    <span> ${newsinfo.createDate}</span></li>
        </s:iterator>     
        <br> <br>
        
        <!-- ��ҳ�����Ӳ��� -->
        <s:if test="pager.curPage>1">
            <p align="center">
			    <a href='index?pager.curPage=1&newsinfo.topic.id=${requestScope.newsinfo.topic.id}'>��ҳ</a>
			    <a href='index?pager.curPage=${pager.curPage-1 }&newsinfo.topic.id=${requestScope.newsinfo.topic.id}'>��һҳ</a>
		    </p>
		</s:if>		
		
		<s:if test="pager.curPage < pager.pageCount">
		  <p align="center">
			<a href='index?pager.curPage=${pager.curPage+1}&newsinfo.topic.id=${requestScope.newsinfo.topic.id}'>��һҳ</a>
			<a href='index?pager.curPage=${pager.pageCount }&newsinfo.topic.id=${requestScope.newsinfo.topic.id}'>βҳ</a>
		  </p>
		</s:if>
       </ul>
    </div>   
  </div>
</div>

