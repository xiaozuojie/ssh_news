<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<jsp:include page="console_element/top.jsp" />
<%@ taglib uri='/struts-tags' prefix='s' %>
<script type="text/javascript">
	function check(){
		var name = document.getElementById("name");

		if(name.value == ""){
			alert("�������������ƣ���");
			name.focus();
			return false;
		}		
		return true;
	}
</script>
<div id="main">
  <jsp:include page="console_element/left.html" />
  <div id="opt_area">
    <h1 id="opt_type">�޸����⣺ </h1>
    <s:form action="/doTopicModify" method="post" onsubmit="return check()">
      <s:hidden name="topic.id" value="%{#request.modifyTopic.id}" />
      <p>
        <s:textfield label="��������" id="name" name="topic.name" value="%{#request.modifyTopic.name }" cssClass="opt_input" />
      </p> 
       
      <p>
        <s:submit value="�ύ" cssClass="opt_sub" />
      </p>     
    </s:form>
  </div>
</div>
