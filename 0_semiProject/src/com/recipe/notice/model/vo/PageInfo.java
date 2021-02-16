package com.recipe.notice.model.vo;

public class PageInfo {
	private int currentPage;
	private int pageTotalCount;
	private int startNavi;
	private int endNavi;
	private int recordCountPerPage;
	
	public PageInfo(int currentPage, int pageTotalCount, int startNavi, int endNavi, int recordCountPerPage) {
		super();
		this.currentPage = currentPage;
		this.pageTotalCount = pageTotalCount;
		this.startNavi = startNavi;
		this.endNavi = endNavi;
		this.recordCountPerPage = recordCountPerPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public void setPageTotalCount(int pageTotalCount) {
		this.pageTotalCount = pageTotalCount;
	}

	public int getStartNavi() {
		return startNavi;
	}

	public void setStartNavi(int startNavi) {
		this.startNavi = startNavi;
	}

	public int getEndNavi() {
		return endNavi;
	}

	public void setEndNavi(int endNavi) {
		this.endNavi = endNavi;
	}

	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}

	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}

	
	
	
}
