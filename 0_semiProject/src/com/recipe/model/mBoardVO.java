

package com.recipe.mBoard.model;

public class mBoardVO {
	private int boardNUM;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	private String boardDate;
	private String boardHit;
	
	
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
	public String getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	public String getBoardHit() {
		return boardHit;
	}
	public void setBoardHit(String boardHit) {
		this.boardHit = boardHit;
	}
	@Override
	public String toString() {
		return "mBoardVO [boardNUM=" + boardNUM + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardWriter=" + boardWriter + ", boardDate=" + boardDate + ", boardHit=" + boardHit + "]";
	}
	
	
	
}


