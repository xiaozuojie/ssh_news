<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri='/struts-tags' prefix='s' %>
<jsp:include page="console_element/top.jsp" />
<script language="javascript">
	function clickdel(){
		return confirm("ɾ������ȷ��");
	}	
</script>

<div id="main">
  <jsp:include page="console_element/left.html" />
  <div id="opt_area">    
   <s:form ation="admin" method="post" theme="simple">
                      ���⣺<s:select name="newsinfo.topic.id" list="#request.topicList" listKey="id" listValue="name" cssClass="opt_input" />
         &nbsp;&nbsp; &nbsp;���ű��⣺<s:textfield name="newsinfo.title" />
          <s:submit value="��ѯ" />
        </s:form>
    <ul class="classlist"> 
    	<s:iterator id="news" value="#request.newsinfoList">
    	 	<li>${news.title}<span> ���ߣ�${news.author}&#160;&#160;&#160;&#160; <a href='toNewsModify?id=${news.id}'>�޸�</a> &#160;&#160;&#160;&#160; <a href='deleteNews?id=${news.id}' onclick='return clickdel()'>ɾ��</a> </span> </li>
    	</s:iterator>        
        <s:if test="pager.curPage>1">
            <p align="center">
			    <a href='admin?pager.curPage=1&newsinfo.topic.id=${requestScope.newsinfo.topic.id}&newsinfo.title=${requestScope.newsinfo.title}'>��ҳ</a>
			    <a href='admin?pager.curPage=${pager.curPage-1 }&newsinfo.topic.id=${requestScope.newsinfo.topic.id}&newsinfo.title=${requestScope.newsinfo.title}'>��һҳ</a>
		    </p>
		</s:if>		
		
		<s:if test="pager.curPage < pager.pageCount">
		  <p align="center">
			<a href='admin?pager.curPage=${pager.curPage+1}&newsinfo.topic.id=${requestScope.newsinfo.topic.id}&newsinfo.title=${requestScope.newsinfo.title}'>��һҳ</a>
			<a href='admin?pager.curPage=${pager.pageCount }&newsinfo.topic.id=${requestScope.newsinfo.topic.id}&newsinfo.title=${requestScope.newsinfo.title}'>βҳ</a>
		  </p>
		</s:if>
    </ul>
  </div>
</div>

