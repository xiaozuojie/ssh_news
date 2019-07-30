package com.news.dao;

import java.util.List;
import java.util.Map;

import com.news.entity.Topic;


public interface TopicDAO {
	//获取所有主题
	public List getAllTopics();
	
	//通过名称获取主题
	public List getTopicByName(String name);
	
	//通过编号获取主题
	public Topic getTopicById(int id);	
	
	//删除主题
	public void deleteTopic(Topic topic);	
	
	//返回主题数目
	public int countTopics();
	
	//更新主题
	public void updateTopic(Topic topic);
	
	//添加主题
	public void addTopic(Topic topic);

}
