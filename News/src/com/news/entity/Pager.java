package com.news.entity;

public class Pager {
	private int curPage;//����ʾҳ
	private int perPageRows ;//ÿҳ��ʾ�ļ�¼��  
	private int rowCount; //��¼����  
	private int pageCount; //��ҳ�� 	
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int currentPage) {
		this.curPage = currentPage;
	}
	public int getPerPageRows() {
		return perPageRows;
	}
	public void setPerPageRows(int perPageRows) {
		this.perPageRows = perPageRows;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public int getPageCount() {
		return (rowCount+perPageRows-1)/perPageRows;
	}

}
