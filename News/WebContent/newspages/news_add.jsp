<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="gbk"%>
<%@ taglib uri='/struts-tags' prefix='s' %>
<jsp:include page="console_element/top.jsp" />

<script type="text/javascript">
	function check(){
		var title = document.getElementById("title");
		var author = document.getElementById("author");
		var summary = document.getElementById("summary");
		var content = document.getElementById("content");		
		if(title.value == ""){
			alert("标题不能为空！！");
			title.focus();
			return false;
		}else if(author.value == ""){
			alert("作者不能为空！！");
			author.focus();
			return false;
		}else if(summary.value == ""){
			alert("摘要不能为空！！");
			summary.focus();
			return false;
		}else if(content.value == ""){
			alert("内容不能为空！！");
			content.focus();
			return false;
		}		
		return true;
	}
</script>
<div id="main">
  <jsp:include page="console_element/left.html" />
  <div id="opt_area">
    <h1 id="opt_type"> 添加新闻： </h1>
    <s:form action="doNewsAdd" method="post" onsubmit="return check()">
      <p>        
        <s:select name="newsinfo.topic.id" label="主题" list="#request.topicList" listKey="id" listValue="name" cssClass="opt_input" />
      </p>
      <p>
        <s:textfield label="标题" name="newsinfo.title" cssClass="opt_input"  />
      </p>      
      <p>
        <s:textarea label="摘要" name="newsinfo.summary" cols="40" rows="3" />
      </p>
      <p>
         <s:textarea label="内容" name="newsinfo.content" cols="70" rows="10" />        
      </p>   
      <br>
     <p>
         <s:submit value="提交" cssClass="opt_sub" align="center" />  
      </p> 
    </s:form>
  </div>
</div>

