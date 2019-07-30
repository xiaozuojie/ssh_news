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

	//��ȡ��������
	@Override
	public List getAllTopics() {		
		return topicDAO.getAllTopics();
	}

	//ͨ�����ƻ�ȡ����
	@Override
	public List getTopicByName(String name) {
		return topicDAO.getTopicByName(name);
	}

	//ͨ�����ɾ������
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

	//��������
	@Override
	public void updateTopic(Topic topic) {
		topicDAO.updateTopic(topic);
	}

	//�������
	@Override
	public void addTopic(Topic topic) {
		topicDAO.addTopic(topic);
	}

	//���ݱ�Ż�ȡ����
	@Override
	public Topic getTopicById(int id) {
		return topicDAO.getTopicById(id);
	}

}
