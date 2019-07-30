package com.news.biz.impl;

import java.util.List;
import com.news.entity.Newsinfo;
import com.news.entity.Pager;
import com.news.biz.NewsinfoBiz;
import com.news.dao.NewsinfoDAO;

public class NewsinfoBizImpl implements NewsinfoBiz {

	NewsinfoDAO newsinfoDAO;		
	public void setNewsinfoDAO(NewsinfoDAO newsinfoDAO) {
		this.newsinfoDAO = newsinfoDAO;
	}
	
	//��ȡָ��ҳ��������б�
	@Override
	public List getAllNewsinfoByPage(int page,int pageSize){
		return newsinfoDAO.getAllNewsinfoByPage(page,pageSize);
	}
	
	//��ȡ������������,������ʼ����ҳ��Pager���󣬲�������perPageRows��rowCount����
	@Override
	public Pager getPagerOfAllNewsinfo(int pageSize) {
		int count= newsinfoDAO.getCountOfAllNewsinfo();
		//ʹ�÷�ҳ��Pager�������
		Pager pager=new Pager();
		//����pager�����е�perPageRows���ԣ���ʾÿҳ��ʾ�ļ�¼��
		pager.setPerPageRows(pageSize);
		//����pager�����е�rowCount���ԣ���ʾ��¼����
		pager.setRowCount(count);
	    //����pager����
		return pager;
	}	
	
	//���������š����ű����������ָ��ҳ���ȡ�����б�
	@Override
	public List getNewsinfoByConditionAndPage(Newsinfo condition,int page,int pageSize) {
		return newsinfoDAO.getNewsinfoByConditionAndPage(condition, page, pageSize);
	}
	
	//�������⡢���ű����������ȡ��������,������ʼ����ҳ��Pager���󣬲�������perPageRows��rowCount����
	@Override
	public Pager getPagerOfNewsinfo(Newsinfo condition,int pageSize) {
		int count= newsinfoDAO.getCountOfNewsinfo(condition);
		//ʹ�÷�ҳ��Pager�������
		Pager pager=new Pager();
		//����pager�����е�perPageRows���ԣ���ʾÿҳ��ʾ�ļ�¼��
		pager.setPerPageRows(pageSize);
		//����pager�����е�rowCount���ԣ���ʾ��¼����
		pager.setRowCount(count);
	    //����pager����
		return pager;
	}

	//�������ű�Ż�ȡ����
	@Override
	public Newsinfo getNewsinfoById(int id) {
		return newsinfoDAO.getNewsinfoById(id);
	}

	//�������
	@Override
	public void addNews(Newsinfo newsinfo) {
		newsinfoDAO.addNews(newsinfo);
	}

	//ɾ������
	@Override
	public void deleteNews(int id) {
		Newsinfo newsinfo=newsinfoDAO.getNewsinfoById(id);
		newsinfoDAO.deleteNewsinfo(newsinfo);		
	}

	//�޸�����
	@Override
	public void updateNews(Newsinfo newsinfo) {
		newsinfoDAO.updateNews(newsinfo);
	}

}
