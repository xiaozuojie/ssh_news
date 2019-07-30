package com.news.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.news.dao.AdminDAO;
import com.news.entity.Admin;

public class AdminDAOImpl implements AdminDAO {
	
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List search(Admin condition) {
		List list=null;
		//ͨ��sessionFactory���Session
		Session session=sessionFactory.getCurrentSession();
		//����Criteria����
		Criteria c=session.createCriteria(Admin.class);
		//ʹ��Example�����ഴ��ʾ������
		Example example=Example.create(condition);
		//ΪCriteria����ָ��ʾ������example��Ϊ��ѯ����		
		c.add(example);			
		list= c.list();	  //ִ�в�ѯ����ý��		
		return list;
	}

}
