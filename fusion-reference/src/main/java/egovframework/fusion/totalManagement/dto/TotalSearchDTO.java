package egovframework.fusion.totalManagement.dto;

import java.util.List;

public class TotalSearchDTO {
	private String userId;
	
	private String searchText;
	
	private List<Integer> boardNum;
	
	private List<Integer>  galBoardNum;
	
	
	

	public List<Integer> getGalBoardNum() {
		return galBoardNum;
	}
	public void setGalBoardNum(List<Integer> galBoardNum) {
		this.galBoardNum = galBoardNum;
	}
	public List<Integer> getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(List<Integer> boardNum) {
		this.boardNum = boardNum;
	}
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	@Override
	public String toString() {
		return "TotalSearchDTO [searchText=" + searchText + ", boardNum=" + boardNum + ", galBoardNum=" + galBoardNum
				+ "]";
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
