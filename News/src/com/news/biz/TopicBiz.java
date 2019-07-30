package com.news.biz;

import java.util.List;

import com.news.entity.Topic;

public interface TopicBiz {
	/*//获取所有一级标题
	public List getFirstTitle();
	//一级标题发布
	public void addFirstleveltitle(Firstleveltitle firstleveltitle);
	//删除指定编号的一级标题
	public void delFirstleveltitle(int id);*/
	
	//获取所有主题
	public List getAllTopics();
	
	//通过名称获取主题
	public List getTopicByName(String name);
	
	//通过编号删除主题
	public void deleteTopic(int id);	
	
	//返回主题数目
	public int countTopics();
	
	//更新主题
	public void updateTopic(Topic topic);
	
	//添加主题
	public void addTopic(Topic topic);
	
	//通过编号获取主题
	public Topic getTopicById(int id);	
}
