<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri='/struts-tags' prefix='s' %>
<div class="sidebar">
    <h1> <img src="Images/title_1.gif" alt="��������" /> </h1>
    <div class="side_list">
      <ul>    
        <!-- ѭ����ʾ5����������  -->  	  
      	<s:iterator id="domesticNews" value="#request.domesticNewsList">
      		<li> <a href='newsread?id=${domesticNews.id }'><b> ${domesticNews.title }</b></a> </li>
      		<br>
      	</s:iterator>
      </ul>
    </div>
    <h1> <img src="Images/title_2.gif" alt="��������" /> </h1>
    <div class="side_list">
      <ul>    
      <!-- ѭ����ʾ5����������  -->  	
    	<s:iterator id="internationalNews" value="#request.internationalNewsList">
    		<li> <a href='newsread?id=${internationalNews.id }'><b> ${internationalNews.title }</b></a> </li>
    		<br>
    	</s:iterator>
      </ul>
    </div>    
  </div>

