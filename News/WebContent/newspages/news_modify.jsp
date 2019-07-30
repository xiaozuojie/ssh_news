<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri='/struts-tags' prefix='s' %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<jsp:include page="console_element/top.jsp" />
<script type="text/javascript">
	function check(){
		var title = document.getElementById("title");
		var author = document.getElementById("author");
		var summary = document.getElementById("summary");
		var content = document.getElementById("content");
		
		if(title.value == ""){
			alert("���ⲻ��Ϊ�գ���");
			title.focus();
			return false;
		}else if(author.value == ""){
			alert("���߲���Ϊ�գ���");
			author.focus();
			return false;
		}else if(summary.value == ""){
			alert("ժҪ����Ϊ�գ���");
			summary.focus();
			return false;
		}else if(content.value == ""){
			alert("���ݲ���Ϊ�գ���");
			content.focus();
			return false;
		}		
		return true;
	}
</script>

<div id="main">
  <jsp:include page="console_element/left.html" />
  <div id="opt_area">
    <h1 id="opt_type"> �޸����ţ� </h1>
    <form action="/News/doNewsModify" method="post" onsubmit="return check()">
      <s:hidden name="newsinfo.id" value="%{#request.newsinfo.id}" />
      <p>        
        <s:select name="newsinfo.topic.id" label="����" list="#request.topicList" listKey="id" listValue="name" value="%{#request.newsinfo.topic.id }" cssClass="opt_input" />
      </p>
      <p>
        <s:textfield label="����" name="newsinfo.title" cssClass="opt_input" value="%{#request.newsinfo.title }"  />
      </p>      
      <p>
        <s:textarea label="ժҪ" name="newsinfo.summary" value="%{#request.newsinfo.summary }" cols="40" rows="3"  />
      </p>
      <p>
         <s:textarea label="����" name="newsinfo.content" value="%{#request.newsinfo.content }" cols="70" rows="10" />        
      </p>   
      <br>
     <p>
         <s:submit value="�ύ" cssClass="opt_sub" align="center" />  
      </p> 
    </form>    
  </div>
</div>

