package com.news.biz;

import java.util.List;

import com.news.entity.Topic;

public interface TopicBiz {
	/*//��ȡ����һ������
	public List getFirstTitle();
	//һ�����ⷢ��
	public void addFirstleveltitle(Firstleveltitle firstleveltitle);
	//ɾ��ָ����ŵ�һ������
	public void delFirstleveltitle(int id);*/
	
	//��ȡ��������
	public List getAllTopics();
	
	//ͨ�����ƻ�ȡ����
	public List getTopicByName(String name);
	
	//ͨ�����ɾ������
	public void deleteTopic(int id);	
	
	//����������Ŀ
	public int countTopics();
	
	//��������
	public void updateTopic(Topic topic);
	
	//�������
	public void addTopic(Topic topic);
	
	//ͨ����Ż�ȡ����
	public Topic getTopicById(int id);	
}
