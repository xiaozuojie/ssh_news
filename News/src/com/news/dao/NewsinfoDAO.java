package com.news.dao;

import java.util.List;
import com.news.entity.Newsinfo;

public interface NewsinfoDAO {		
	
	//�������
	public void addNews(Newsinfo newsinfo);
	
	//��������
	public void updateNews(Newsinfo newsinfo);
	
	//��ȡ���������б�
	public List getAllNewsinfo();
	
	//��ȡ������������
	public Integer getCountOfAllNewsinfo();	
	
	//����ָ��ҳ���ȡ�����б�
	public List getAllNewsinfoByPage(int page,int pageSize);
	
	//�������ű�Ż�ȡ����
	public Newsinfo getNewsinfoById(int id);
	
	//�������⡢���ű����������ȡ������������
	public Integer getCountOfNewsinfo(Newsinfo condition);	
	
	//���������š����ű����������ָ��ҳ���ȡ�����б�
    public List getNewsinfoByConditionAndPage(Newsinfo conditon,int page,int pageSize);    
	
	//ɾ�����Ŷ���
	public void deleteNewsinfo(Newsinfo newsinfo);	
	
}
