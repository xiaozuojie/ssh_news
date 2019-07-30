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
	
	/*Integer tid;	  //封装表单传递的主题编号
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}*/
	
	int id;   //封装表单传递的新闻编号
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	/*public String title;  //封装分页超链接传递来的新闻标题参数
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}*/

	Newsinfo newsinfo; //封装表单参数
	public Newsinfo getNewsinfo() {
		return newsinfo;
	}
	public void setNewsinfo(Newsinfo newsinfo) {
		this.newsinfo = newsinfo;
	}

	//主题业务逻辑接口
	TopicBiz topicBiz;
	public void setTopicBiz(TopicBiz topicBiz) {
		this.topicBiz = topicBiz;
	}	
	//新闻业务逻辑接口
	NewsinfoBiz newsinfoBiz;
	public void setNewsinfoBiz(NewsinfoBiz newsinfoBiz) {
		this.newsinfoBiz = newsinfoBiz;
	}

	//分页实体类
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
	
	//根据条件和页码获取新闻列表，再转到新闻浏览首页index.jsp
	public String index() throws Exception {
		int curPage=1;
		if(pager!=null)
			curPage=pager.getCurPage();
		List newsinfoList=null;
		if(newsinfo==null){
	        //如何没有指定查询条件，获取指定页码的新闻列表
			newsinfoList=newsinfoBiz.getAllNewsinfoByPage(curPage,10);
			//再获得所有新闻总数，用来初始化分页类Pager对象
			pager=newsinfoBiz.getPagerOfAllNewsinfo(10);			
		}else{
			//如果指定了查询条件，根据条件获取指定页码的新闻列表
			newsinfoList=newsinfoBiz.getNewsinfoByConditionAndPage(newsinfo, curPage, 10);
			//再根据条件获得所属新闻总数，用来初始化分页类Pager对象
			pager=newsinfoBiz.getPagerOfNewsinfo(newsinfo,10);			
		}
		//设置Pager对象中的待显示页页码
		pager.setCurPage(curPage);
		//将待显示的当前页新闻列表存入request范围
		request.put("newsinfoList", newsinfoList);
		//获取所有主题
		List topicList=topicBiz.getAllTopics();
		//将主题列表存入request范围
		request.put("topicList", topicList);
		return "index";
	}
	
	//从国内新闻和国际新闻中各获取5条记录，再转到index_sidebar.jsp页面
	public String indexsidebar() throws Exception {	
		//获取5条国内新闻
		Newsinfo conditon =new Newsinfo();
		Topic topic =new Topic();
		topic.setId(1);
		conditon.setTopic(topic);		
		List domesticNewsList=newsinfoBiz.getNewsinfoByConditionAndPage(conditon, 1,5);
		//获取5条国际新闻
		topic.setId(2);
		conditon.setTopic(topic);
		List internationalNewsList=newsinfoBiz.getNewsinfoByConditionAndPage(conditon, 1,5);
		request.put("domesticNewsList", domesticNewsList);
		request.put("internationalNewsList", internationalNewsList);
		return "index_sidebar";
	}	
	
	//浏览新闻内容
	public String newsread() throws Exception {	
		//根据新闻编号获取新闻
		Newsinfo newsinfo=newsinfoBiz.getNewsinfoById(id);
		//将新闻存入request范围
		request.put("newsinfo", newsinfo);
		//获取5条国内新闻
		Newsinfo conditon =new Newsinfo();
		Topic topic =new Topic();
		topic.setId(1);
		conditon.setTopic(topic);
		List domesticNewsList=newsinfoBiz.getNewsinfoByConditionAndPage(conditon, 1,5);
		//获取5条国际新闻
		topic.setId(2);
		conditon.setTopic(topic);
		List internationalNewsList=newsinfoBiz.getNewsinfoByConditionAndPage(conditon, 1,5);
		request.put("domesticNewsList", domesticNewsList);
		request.put("internationalNewsList", internationalNewsList);
		//获取所有主题，并存入request范围
		List topicList=topicBiz.getAllTopics();
		request.put("topicList", topicList);
		//转到新闻内容浏览页
		return "news_read";
	}	
	
	//获取主题列表，再转到新闻添加页
	public String toNewsAdd() throws Exception {			
		List topicList=topicBiz.getAllTopics();
		request.put("topicList", topicList);
		return "news_add";
	}	
	
	//执行新闻添加
	public String doNewsAdd() throws Exception {
		//从session中获取管理员对象
		Admin admin=(Admin)session.get("admin");
		newsinfo.setAuthor(admin.getLoginName());
		newsinfo.setCreateDate(new Date());
		newsinfoBiz.addNews(newsinfo);
		return "admin";
	}
	
	//获取指定页的新闻列表，再转到新闻管理页
	public String admin() throws Exception {
		List newsinfoList=null;
		int curPage=1;
		if(pager!=null)
			curPage=pager.getCurPage();
		if(newsinfo==null){
			//如何没有指定查询条件，获取指定页码的新闻列表
			newsinfoList=newsinfoBiz.getAllNewsinfoByPage(curPage,10);
			//再获得所有新闻总数，用来初始化分页类Pager对象
			pager=newsinfoBiz.getPagerOfAllNewsinfo(10);
		}else{
			//如果指定了查询条件，根据条件获取指定页码的新闻列表
			newsinfoList=newsinfoBiz.getNewsinfoByConditionAndPage(newsinfo, curPage, 10);
			//再根据条件获得所属新闻总数，用来初始化分页类Pager对象
			pager=newsinfoBiz.getPagerOfNewsinfo(newsinfo,10);			
		}
		//设置Pager对象中的待显示页页码
		pager.setCurPage(curPage);
		//将待显示的当前页新闻列表存入request范围
		request.put("newsinfoList", newsinfoList);
		//获取所有主题
		List topicList=topicBiz.getAllTopics();
		//将主题列表存入request范围
		request.put("topicList", topicList);
		return "admin";
	}
	
	//执行新闻删除
	public String deleteNews() throws Exception {
		newsinfoBiz.deleteNews(id);
		return "admin";
	}
	
	//根据新闻编号获取新闻，并获取主题列表，再转到新闻修改页
	public String toNewsModify() throws Exception {
		//根据新闻编号获取新闻
		Newsinfo newsinfo=newsinfoBiz.getNewsinfoById(id);
		//将要修改的新闻存入request
		request.put("newsinfo", newsinfo);
		//获取主题列表
		List topicList=topicBiz.getAllTopics();
		//将主题列表存入request
		request.put("topicList", topicList);
		//转到新闻修改页
		return "news_modify";
	}
	
	//执行新闻修改
	public String doNewsModify() throws Exception {
		//从session中获取管理员对象
		Admin admin=(Admin)session.get("admin");
		newsinfo.setAuthor(admin.getLoginName());
		newsinfo.setCreateDate(new Date());
		newsinfoBiz.updateNews(newsinfo);
		return "admin";
	}

}
