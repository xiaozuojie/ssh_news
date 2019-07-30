package com.news.action;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import com.news.entity.Admin;
import com.news.entity.Newsinfo;
import com.news.entity.Pager;
import com.news.entity.Topic;
import com.news.biz.TopicBiz;
import com.news.biz.NewsinfoBiz;
import com.opensymphony.xwork2.ActionSupport;

public class NewsinfoAction extends ActionSupport implements RequestAware,SessionAware {
	
	/*Integer tid;	  //��װ�����ݵ�������
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}*/
	
	int id;   //��װ�����ݵ����ű��
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	/*public String title;  //��װ��ҳ�����Ӵ����������ű������
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}*/

	Newsinfo newsinfo; //��װ������
	public Newsinfo getNewsinfo() {
		return newsinfo;
	}
	public void setNewsinfo(Newsinfo newsinfo) {
		this.newsinfo = newsinfo;
	}

	//����ҵ���߼��ӿ�
	TopicBiz topicBiz;
	public void setTopicBiz(TopicBiz topicBiz) {
		this.topicBiz = topicBiz;
	}	
	//����ҵ���߼��ӿ�
	NewsinfoBiz newsinfoBiz;
	public void setNewsinfoBiz(NewsinfoBiz newsinfoBiz) {
		this.newsinfoBiz = newsinfoBiz;
	}

	//��ҳʵ����
	private Pager pager;
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}

	Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;		
	}
	Map<String, Object> session;
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;				
	}	
	
	//����������ҳ���ȡ�����б���ת�����������ҳindex.jsp
	public String index() throws Exception {
		int curPage=1;
		if(pager!=null)
			curPage=pager.getCurPage();
		List newsinfoList=null;
		if(newsinfo==null){
	        //���û��ָ����ѯ��������ȡָ��ҳ��������б�
			newsinfoList=newsinfoBiz.getAllNewsinfoByPage(curPage,10);
			//�ٻ����������������������ʼ����ҳ��Pager����
			pager=newsinfoBiz.getPagerOfAllNewsinfo(10);			
		}else{
			//���ָ���˲�ѯ����������������ȡָ��ҳ��������б�
			newsinfoList=newsinfoBiz.getNewsinfoByConditionAndPage(newsinfo, curPage, 10);
			//�ٸ������������������������������ʼ����ҳ��Pager����
			pager=newsinfoBiz.getPagerOfNewsinfo(newsinfo,10);			
		}
		//����Pager�����еĴ���ʾҳҳ��
		pager.setCurPage(curPage);
		//������ʾ�ĵ�ǰҳ�����б����request��Χ
		request.put("newsinfoList", newsinfoList);
		//��ȡ��������
		List topicList=topicBiz.getAllTopics();
		//�������б����request��Χ
		request.put("topicList", topicList);
		return "index";
	}
	
	//�ӹ������ź͹��������и���ȡ5����¼����ת��index_sidebar.jspҳ��
	public String indexsidebar() throws Exception {	
		//��ȡ5����������
		Newsinfo conditon =new Newsinfo();
		Topic topic =new Topic();
		topic.setId(1);
		conditon.setTopic(topic);		
		List domesticNewsList=newsinfoBiz.getNewsinfoByConditionAndPage(conditon, 1,5);
		//��ȡ5����������
		topic.setId(2);
		conditon.setTopic(topic);
		List internationalNewsList=newsinfoBiz.getNewsinfoByConditionAndPage(conditon, 1,5);
		request.put("domesticNewsList", domesticNewsList);
		request.put("internationalNewsList", internationalNewsList);
		return "index_sidebar";
	}	
	
	//�����������
	public String newsread() throws Exception {	
		//�������ű�Ż�ȡ����
		Newsinfo newsinfo=newsinfoBiz.getNewsinfoById(id);
		//�����Ŵ���request��Χ
		request.put("newsinfo", newsinfo);
		//��ȡ5����������
		Newsinfo conditon =new Newsinfo();
		Topic topic =new Topic();
		topic.setId(1);
		conditon.setTopic(topic);
		List domesticNewsList=newsinfoBiz.getNewsinfoByConditionAndPage(conditon, 1,5);
		//��ȡ5����������
		topic.setId(2);
		conditon.setTopic(topic);
		List internationalNewsList=newsinfoBiz.getNewsinfoByConditionAndPage(conditon, 1,5);
		request.put("domesticNewsList", domesticNewsList);
		request.put("internationalNewsList", internationalNewsList);
		//��ȡ�������⣬������request��Χ
		List topicList=topicBiz.getAllTopics();
		request.put("topicList", topicList);
		//ת�������������ҳ
		return "news_read";
	}	
	
	//��ȡ�����б���ת���������ҳ
	public String toNewsAdd() throws Exception {			
		List topicList=topicBiz.getAllTopics();
		request.put("topicList", topicList);
		return "news_add";
	}	
	
	//ִ���������
	public String doNewsAdd() throws Exception {
		//��session�л�ȡ����Ա����
		Admin admin=(Admin)session.get("admin");
		newsinfo.setAuthor(admin.getLoginName());
		newsinfo.setCreateDate(new Date());
		newsinfoBiz.addNews(newsinfo);
		return "admin";
	}
	
	//��ȡָ��ҳ�������б���ת�����Ź���ҳ
	public String admin() throws Exception {
		List newsinfoList=null;
		int curPage=1;
		if(pager!=null)
			curPage=pager.getCurPage();
		if(newsinfo==null){
			//���û��ָ����ѯ��������ȡָ��ҳ��������б�
			newsinfoList=newsinfoBiz.getAllNewsinfoByPage(curPage,10);
			//�ٻ����������������������ʼ����ҳ��Pager����
			pager=newsinfoBiz.getPagerOfAllNewsinfo(10);
		}else{
			//���ָ���˲�ѯ����������������ȡָ��ҳ��������б�
			newsinfoList=newsinfoBiz.getNewsinfoByConditionAndPage(newsinfo, curPage, 10);
			//�ٸ������������������������������ʼ����ҳ��Pager����
			pager=newsinfoBiz.getPagerOfNewsinfo(newsinfo,10);			
		}
		//����Pager�����еĴ���ʾҳҳ��
		pager.setCurPage(curPage);
		//������ʾ�ĵ�ǰҳ�����б����request��Χ
		request.put("newsinfoList", newsinfoList);
		//��ȡ��������
		List topicList=topicBiz.getAllTopics();
		//�������б����request��Χ
		request.put("topicList", topicList);
		return "admin";
	}
	
	//ִ������ɾ��
	public String deleteNews() throws Exception {
		newsinfoBiz.deleteNews(id);
		return "admin";
	}
	
	//�������ű�Ż�ȡ���ţ�����ȡ�����б���ת�������޸�ҳ
	public String toNewsModify() throws Exception {
		//�������ű�Ż�ȡ����
		Newsinfo newsinfo=newsinfoBiz.getNewsinfoById(id);
		//��Ҫ�޸ĵ����Ŵ���request
		request.put("newsinfo", newsinfo);
		//��ȡ�����б�
		List topicList=topicBiz.getAllTopics();
		//�������б����request
		request.put("topicList", topicList);
		//ת�������޸�ҳ
		return "news_modify";
	}
	
	//ִ�������޸�
	public String doNewsModify() throws Exception {
		//��session�л�ȡ����Ա����
		Admin admin=(Admin)session.get("admin");
		newsinfo.setAuthor(admin.getLoginName());
		newsinfo.setCreateDate(new Date());
		newsinfoBiz.updateNews(newsinfo);
		return "admin";
	}

}
