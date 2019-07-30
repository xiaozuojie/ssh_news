package com.news.biz.impl;

import java.util.List;
import com.news.biz.TopicBiz;
import com.news.dao.TopicDAO;
import com.news.entity.Topic;

public class TopicBizImpl implements TopicBiz {

	TopicDAO topicDAO;	
	public void setTopicDAO(TopicDAO topicDAO) {
		this.topicDAO = topicDAO;
	}

	//获取所有主题
	@Override
	public List getAllTopics() {		
		return topicDAO.getAllTopics();
	}

	//通过名称获取主题
	@Override
	public List getTopicByName(String name) {
		return topicDAO.getTopicByName(name);
	}

	//通过编号删除主题
	@Override
	public void deleteTopic(int id) {	
		Topic topic=topicDAO.getTopicById(id);
		topicDAO.deleteTopic(topic);
	}

	@Override
	public int countTopics() {
		// TODO Auto-generated method stub
		return 0;
	}

	//更改主题
	@Override
	public void updateTopic(Topic topic) {
		topicDAO.updateTopic(topic);
	}

	//添加主题
	@Override
	public void addTopic(Topic topic) {
		topicDAO.addTopic(topic);
	}

	//根据编号获取主题
	@Override
	public Topic getTopicById(int id) {
		return topicDAO.getTopicById(id);
	}

}
