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
	
	//获取指定页码的新闻列表
	@Override
	public List getAllNewsinfoByPage(int page,int pageSize){
		return newsinfoDAO.getAllNewsinfoByPage(page,pageSize);
	}
	
	//获取所有新闻数量,用来初始化分页类Pager对象，并设置其perPageRows和rowCount属性
	@Override
	public Pager getPagerOfAllNewsinfo(int pageSize) {
		int count= newsinfoDAO.getCountOfAllNewsinfo();
		//使用分页类Pager定义对象
		Pager pager=new Pager();
		//设置pager对象中的perPageRows属性，表示每页显示的记录数
		pager.setPerPageRows(pageSize);
		//设置pager对象中的rowCount属性，表示记录总数
		pager.setRowCount(count);
	    //返回pager对象
		return pager;
	}	
	
	//根据主题编号、新闻标题等条件和指定页码获取新闻列表
	@Override
	public List getNewsinfoByConditionAndPage(Newsinfo condition,int page,int pageSize) {
		return newsinfoDAO.getNewsinfoByConditionAndPage(condition, page, pageSize);
	}
	
	//根据主题、新闻标题等条件获取新闻数量,用来初始化分页类Pager对象，并设置其perPageRows和rowCount属性
	@Override
	public Pager getPagerOfNewsinfo(Newsinfo condition,int pageSize) {
		int count= newsinfoDAO.getCountOfNewsinfo(condition);
		//使用分页类Pager定义对象
		Pager pager=new Pager();
		//设置pager对象中的perPageRows属性，表示每页显示的记录数
		pager.setPerPageRows(pageSize);
		//设置pager对象中的rowCount属性，表示记录总数
		pager.setRowCount(count);
	    //返回pager对象
		return pager;
	}

	//根据新闻编号获取新闻
	@Override
	public Newsinfo getNewsinfoById(int id) {
		return newsinfoDAO.getNewsinfoById(id);
	}

	//添加新闻
	@Override
	public void addNews(Newsinfo newsinfo) {
		newsinfoDAO.addNews(newsinfo);
	}

	//删除新闻
	@Override
	public void deleteNews(int id) {
		Newsinfo newsinfo=newsinfoDAO.getNewsinfoById(id);
		newsinfoDAO.deleteNewsinfo(newsinfo);		
	}

	//修改新闻
	@Override
	public void updateNews(Newsinfo newsinfo) {
		newsinfoDAO.updateNews(newsinfo);
	}

}
