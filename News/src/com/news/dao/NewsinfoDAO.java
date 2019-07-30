package com.news.dao;

import java.util.List;
import com.news.entity.Newsinfo;

public interface NewsinfoDAO {		
	
	//添加新闻
	public void addNews(Newsinfo newsinfo);
	
	//更新新闻
	public void updateNews(Newsinfo newsinfo);
	
	//获取所有新闻列表
	public List getAllNewsinfo();
	
	//获取所有新闻数量
	public Integer getCountOfAllNewsinfo();	
	
	//根据指定页码获取新闻列表
	public List getAllNewsinfoByPage(int page,int pageSize);
	
	//根据新闻编号获取新闻
	public Newsinfo getNewsinfoById(int id);
	
	//根据主题、新闻标题等条件获取所属新闻数量
	public Integer getCountOfNewsinfo(Newsinfo condition);	
	
	//根据主题编号、新闻标题等条件和指定页码获取新闻列表
    public List getNewsinfoByConditionAndPage(Newsinfo conditon,int page,int pageSize);    
	
	//删除新闻对象
	public void deleteNewsinfo(Newsinfo newsinfo);	
	
}
