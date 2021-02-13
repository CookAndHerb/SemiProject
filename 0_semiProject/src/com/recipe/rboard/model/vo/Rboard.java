package com.recipe.rboard.model.vo;

import java.sql.Date;

public class Rboard {
	
	private int boardCategory;
	private int boardNum;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	private int boardHit;
	private Date boardDate;
	private String originName;
	private String changeName;
	private String filePath;
	
	
	public Rboard() {};
	
	public Rboard(int boardCategory, int boardNum, String boardTitle, String boardContent, String boardWriter,
			int boardHit, Date boardDate, String originName, String changeName, String filePath) {
		super();
		this.boardCategory = boardCategory;
		this.boardNum = boardNum;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
		this.boardHit = boardHit;
		this.boardDate = boardDate;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
	}
	public int getBoardCategory() {
		return boardCategory;
	}
	public void setBoardCategory(int boardCategory) {
		this.boardCategory = boardCategory;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
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
	public int getBoardHit() {
		return boardHit;
	}
	public void setBoardHit(int boardHit) {
		this.boardHit = boardHit;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	public String getOriginName() {
		return originName;
	}
	public void setOriginName(String originName) {
		this.originName = originName;
	}
	public String getChangeName() {
		return changeName;
	}
	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	
	
	
}
