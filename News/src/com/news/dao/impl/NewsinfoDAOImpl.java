package com.news.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import com.news.dao.NewsinfoDAO;
import com.news.entity.Newsinfo;

public class NewsinfoDAOImpl implements NewsinfoDAO {

	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	//��ȡ���������б�
	@Override
	public List getAllNewsinfo() {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Newsinfo.class);
		return c.list();
	}
	
	//��ȡ������������
	@Override
	public Integer getCountOfAllNewsinfo() {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Newsinfo.class);
		return c.list().size();
	}
	
	//����ָ��ҳ���ȡ�����б�
	@Override
	public List getAllNewsinfoByPage(int page,int pageSize) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Newsinfo.class);
		c.setFirstResult(pageSize*(page-1));
		c.setMaxResults(pageSize);
		c.addOrder(Order.desc("createDate"));
		return c.list();
	}
	
	//�������ű�Ż�ȡ����
	@Override
	public Newsinfo getNewsinfoById(int id) {
		Session session=sessionFactory.getCurrentSession();
		Newsinfo newsinfo=(Newsinfo)session.get(Newsinfo.class, id);
		return newsinfo;
	}

	
	//�������⡢���ű����������ȡ������������
	@Override
	public Integer getCountOfNewsinfo(Newsinfo condition){
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Newsinfo.class);
		if(condition!=null){
			if((condition.getTopic()!=null) && (condition.getTopic().getId()!=null))
				c.add(Restrictions.eq("topic.id", condition.getTopic().getId()));
			if((condition.getTitle()!=null) && !("".equals(condition.getTitle())))
				c.add(Restrictions.like("title", condition.getTitle(),MatchMode.ANYWHERE));
		}
		return c.list().size();
	}
	
	//���������š����ű����������ָ��ҳ���ȡ�����б�
	@Override
	public List getNewsinfoByConditionAndPage(Newsinfo condition,int page,int pageSize) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Newsinfo.class);
		if(condition!=null){
			if((condition.getTopic()!=null) && (condition.getTopic().getId()!=null))
				c.add(Restrictions.eq("topic.id", condition.getTopic().getId()));
			if((condition.getTitle()!=null) && !("".equals(condition.getTitle())))
				c.add(Restrictions.like("title", condition.getTitle(),MatchMode.ANYWHERE));
		}
		c.setFirstResult(pageSize*(page-1));
		c.setMaxResults(pageSize);
		c.addOrder(Order.desc("createDate"));
		return c.list();
	}
	
	//ɾ������
	@Override
	public void deleteNewsinfo(Newsinfo newsinfo) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(newsinfo);
	}
	
	//�������
	@Override
	public void addNews(Newsinfo newsinfo) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(newsinfo);		
	}
	
	//�޸�����
	@Override
	public void updateNews(Newsinfo newsinfo) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(newsinfo);			
	}
}
