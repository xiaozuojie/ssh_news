package com.news.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.news.dao.TopicDAO;
import com.news.entity.Topic;

public class TopicDAOImpl implements TopicDAO {

	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	//��ȡ��������
	@Override
	public List getAllTopics() {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Topic.class);
		return c.list();
	}
	
	//ͨ�����ƻ�ȡ����
	@Override
	public List getTopicByName(String name) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Topic.class);
		c.add(Restrictions.eq("name", name));
		return c.list();
	}
	
	//ͨ����Ż�ȡ����
	@Override
	public Topic getTopicById(int id) {
		Session session=sessionFactory.getCurrentSession();
		Topic topic=(Topic)session.get(Topic.class, id);
		return topic;
	}

	//ɾ������
	@Override
	public void deleteTopic(Topic topic) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(topic);
	}
	
	@Override
	public int countTopics() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	//�޸�����
	@Override
	public void updateTopic(Topic topic) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(topic);
	}
	
	//�������
	@Override
	public void addTopic(Topic topic) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(topic);
	}	
	
	
	
	
}
