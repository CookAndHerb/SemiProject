

package com.recipe.mboard.model;

import java.sql.Date;

public class mBoardVO {
	private int boardNUM;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	private Date boardDate;
	private int boardHit;
	
	
	public int getBoardNUM() {
		return boardNUM;
	}
	public void setBoardNUM(int boardNUM) {
		this.boardNUM = boardNUM;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	public int getBoardHit() {
		return boardHit;
	}
	public void setBoardHit(int boardHit) {
		this.boardHit = boardHit;
	}
	@Override
	public String toString() {
		return "mBoardVO [boardNUM=" + boardNUM + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardWriter=" + boardWriter + ", boardDate=" + boardDate + ", boardHit=" + boardHit + "]";
	}
	
	
	
}


