package com.news.biz.impl;

import java.util.List;

import com.news.biz.AdminBiz;
import com.news.dao.AdminDAO;
import com.news.entity.Admin;

public class AdminBizImpl implements AdminBiz {

	//使用AdminDAO接口声明属性adminDAO，并添加set方法用于依赖注入
	AdminDAO adminDAO;		
	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	@Override
	public List login(Admin condition) {		
		return adminDAO.search(condition);
	}

}
