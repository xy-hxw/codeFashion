package com.common.until;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

public class Page {
	/**
	 * 分页数据
	 */
	private Collection<Object> data = null;
	/**
	 * 当前页
	 */
	private int curPage;
	/**
	 * 每页显示的记录数
	 */
	private int pageSize;
	/**
	 * 记录行数
	 */
	private int rowsCount;
	/**
	 * 页数
	 */
	private int pageCount;
	
	public Page(Collection<Object> data) {
		this.data = data;
		this.curPage = 1;
		this.pageSize = Constants.PAGE_SIZE;
		this.rowsCount = data.size();
		this.pageCount = (int) Math.ceil((double) rowsCount / pageSize);
	}

	public Page(Collection<Object> data, int curPage) {
		this.data = data;
		this.curPage = curPage;
		this.pageSize =  Constants.PAGE_SIZE;
		this.rowsCount = data.size();
		this.pageCount = (int) Math.ceil((double) rowsCount / pageSize);
	}

	public Page(Collection<Object> data, int curPage, int rowCount) {
		this.data = data;
		this.curPage = curPage;
		this.pageSize = Constants.PAGE_SIZE;
		this.rowsCount = rowCount;
		this.pageCount = (int) Math.ceil((double) rowsCount / pageSize);
	}
	
	public Page(int curPage, int rowCount) {
		this.curPage = curPage;
		this.pageSize = Constants.PAGE_SIZE;
		this.rowsCount = rowCount;
		this.pageCount = (int) Math.ceil((double) rowsCount / pageSize);
	}
	
	public Page(int curPage, int rowCount, int pageSize) {
		this.curPage = curPage;
		this.pageSize = pageSize;
		this.rowsCount = rowCount;
		this.pageCount = (int) Math.ceil((double) rowsCount / pageSize);
	}

	
	/**    
	 * 每页显示的起始记录数
	 * 
	 * @return int 
	 */
	
	public int getOffset() {
		return (curPage - 1) * pageSize;
	}

	/**
	 * getCurPage:返回当前的页数
	 * 
	 * @return int
	 */
	public int getCurPage() {
		return curPage;
	}

	/**
	 * getPageSize：返回分页大小
	 * 
	 * @return int
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * getRowsCount：返回总记录行数
	 * 
	 * @return int
	 */
	public int getRowsCount() {
		return rowsCount;
	}

	/**
	 * getPageCount：返回总页数
	 * 
	 * @return int
	 */
	public int getPageCount() {
		return pageCount;
	}

	/**
	 * 第一页
	 * 
	 * @return int
	 */
	public int first() {
		return 1;
	}

	/**
	 * 最后一页
	 * 
	 * @return int
	 */
	public int last() {
		return pageCount;
	}

	/**
	 * 上一页
	 * 
	 * @return int
	 */
	public int previous() {
		return (curPage - 1 < 1) ? 1 : curPage - 1;
	}

	/**
	 * 下一页
	 * 
	 * @return int
	 */
	public int next() {
		return (curPage + 1 > pageCount) ? pageCount : curPage + 1;
	}

	/**
	 * 第一页
	 * 
	 * @return boolean
	 */
	public boolean isFirst() {
		return (curPage == 1) ? true : false;
	}

	/**
	 * 最后一页
	 * 
	 * @return boolean
	 */
	public boolean isLast() {
		if(rowsCount == 0)
			return true;
		return (curPage == pageCount) ? true : false;
	}

	/**
	 * * 获取当前页数据
	 * 
	 * @return Collection<Object>
	 */
	public Collection<Object> getData() {
		Collection<Object> curData = null;
		if (data != null) {
			int start = (curPage - 1) * pageSize;
			int end = 0;
			if (start + pageSize > rowsCount)
				end = rowsCount;
			else
				end = start + pageSize;
			ArrayList<Object> arrayCurData = new ArrayList<Object>();
			ArrayList<Object> arrayData = null;
			Vector<Object> VectorCurData = new Vector<Object>();
			Vector<Object> VectorData = null;
			boolean isArray = true;
			if (data instanceof ArrayList) {
				arrayData = (ArrayList<Object>) data;
				isArray = true;
			} else if (data instanceof Vector) {
				VectorData = (Vector<Object>) data;
				isArray = false;
			}
			for (int i = start; i < end; i++) {
				if (isArray) {
					arrayCurData.add(arrayData.get(i));
				} else {
					VectorData.add(VectorData.elementAt(i));
				}
			}
			if (isArray) {
				curData = (Collection<Object>) arrayCurData;
			} else {
				curData = (Collection<Object>) VectorCurData;
			}
		}
		return curData;
	}

	/**
	 * 获取工具条
	 * 
	 * @return String
	 */
	public String getToolBar(String fileName) {
		String temp = "";
		if (fileName.indexOf("?") == -1) {
			temp = "?";
		} else {
			temp = "&";
		}
		String str = "<form method='post' name='frmPage' action='" + fileName
				+ "'>";
		str += "<div class='page'><p align='center'>";
		if (isFirst())
			str += "首页 上一页 ";
		else {
			str += "<a href='" + fileName + temp + "curPage=1'>首页</a> ";
			str += "<a href='" + fileName + temp + "curPage=" + (curPage - 1)
					+ "'>上一页</a> ";
		}
		if (isLast()){
			str += "下一页 尾页 ";
		}else {
			str += "<a href='" + fileName + temp + "curPage=" + (curPage + 1)
					+ "'>下一页</a> ";
			str += "<a href='" + fileName + temp + "curPage=" + pageCount
					+ "'>尾页</a> ";
		}
		str += " 共<b>" + rowsCount + "</b>条记录 ";
		str += " 转到<select name='page' class='input-small' onChange=\"location='" + fileName 
			+ temp + "curPage='+this.options[this.selectedIndex].value\">"; 

		for (int i = 1; i <= pageCount; i++) {
			if (i == curPage)
				str += "<option value='" + i + "' selected>第" + i
						+ "页</option>";
			else
				str += "<option value='" + i + "'>第" + i + "页</option>";
		}
		str += "</select></p></div></form>";
		return str;
	}
}
