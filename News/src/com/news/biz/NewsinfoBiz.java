package com.news.biz;

import java.util.List;

import com.news.entity.Newsinfo;
import com.news.entity.Pager;
import com.news.entity.Topic;


public interface NewsinfoBiz {
	
	//��ȡָ��ҳ��������б�
    public List getAllNewsinfoByPage(int page,int pageSize);
	
	//��ȡ������������,������ʼ����ҳ��Pager���󣬲�������perPageRows��rowCount����
    public Pager getPagerOfAllNewsinfo(int pageSize);	    
	
	//���������š����ű����������ָ��ҳ���ȡ�����б�
    public List getNewsinfoByConditionAndPage(Newsinfo condition,int page,int pageSize);   
    
    //�������⡢���ű����������ȡ��������,������ʼ����ҳ��Pager���󣬲�������perPageRows��rowCount����
    public Pager getPagerOfNewsinfo(Newsinfo condition,int pageSize);	    
    
    //�������ű�Ż�ȡ����
  	public Newsinfo getNewsinfoById(int id);
  	
    //�������
  	public void addNews(Newsinfo newsinfo);
  	
    //�޸�����
  	public void updateNews(Newsinfo newsinfo);
  	
    //ɾ������
  	public void deleteNews(int id);    
	
}
