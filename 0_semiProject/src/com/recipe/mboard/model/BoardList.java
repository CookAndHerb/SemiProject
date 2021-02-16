package com.recipe.mboard.model;

public class BoardList {
//	private int currentPage;
//	private int pageSize;
//	private int totalCount;
//	private int totalPage;
//	private int startPage;
//	private int endPage;
//
//	public BoardList(int currentPage, int pageSize, int totalCount) {
//		this.currentPage = currentPage;
//		this.pageSize = pageSize;
//		this.totalCount = totalCount;
//
//		totalPage = (this.totalCount-1) / pageSize;
//		this.currentPage = currentPage > totalPage ? totalPage : currentPage;
//		this.currentPage = currentPage < 1? 1 : currentPage;
//
//		startPage = (this.currentPage-1) /10 * 10 +1;
//
//		endPage = startPage+9;
//
//		endPage = endPage > totalPage ? totalPage : endPage;
//	}
//
//	public int getCurrentPage() {
//		return currentPage;
//	}
//
//	public void setCurrentPage(int currentPage) {
//		this.currentPage = currentPage;
//	}
//
//	public int getPageSize() {
//		return pageSize;
//	}
//
//	public void setPageSize(int pageSize) {
//		this.pageSize = pageSize;
//	}
//
//	public int getTotalCount() {
//		return totalCount;
//	}
//
//	public void setTotalCount(int totalCount) {
//		this.totalCount = totalCount;
//	}
//
//	public int getTotalPage() {
//		return totalPage;
//	}
//
//	public void setTotalPage(int totalPage) {
//		this.totalPage = totalPage;
//	}
//
//	public int getStartPage() {
//		return startPage;
//	}
//
//	public void setStartPage(int startPage) {
//		this.startPage = startPage;
//	}
//
//	public int getEndPage() {
//		return endPage;
//	}
//
//	public void setEndPage(int endPage) {
//		this.endPage = endPage;
//	}

	private int currentPage;
	private int pageTotalCount;
	private int startNavi;
	private int endNavi;
	private int recordCountPerPage;
	
	public BoardList(int currentPage, int pageTotalCount, int startNavi, int endNavi, int recordCountPerPage) {
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
