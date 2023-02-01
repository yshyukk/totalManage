package egovframework.fusion.imgboard.vo;

import java.sql.Date;

public class ImgBoardLikeVO {
	private Integer likeId;
	private String likeYn;
	private String pushLikeUser;
	private Integer imgBoardId;
	private Date likeRegistDt;
	
	private int likeCnt;
	private int ranking;
	private String title;
	
	private int boardNum;
	

	public int getLikeCnt() {
		return likeCnt;
	}
	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getLikeRegistDt() {
		return likeRegistDt;
	}
	public void setLikeRegistDt(Date likeRegistDt) {
		this.likeRegistDt = likeRegistDt;
	}
	public Integer getLikeId() {
		return likeId;
	}
	public void setLikeId(Integer likeId) {
		this.likeId = likeId;
	}
	public String getLikeYn() {
		return likeYn;
	}
	public void setLikeYn(String likeYn) {
		this.likeYn = likeYn;
	}
	public String getPushLikeUser() {
		return pushLikeUser;
	}
	public void setPushLikeUser(String pushLikeUser) {
		this.pushLikeUser = pushLikeUser;
	}
	public Integer getImgBoardId() {
		return imgBoardId;
	}
	public void setImgBoardId(Integer imgBoardId) {
		this.imgBoardId = imgBoardId;
	}
	@Override
	public String toString() {
		return "ImgBoardLikeVO [likeId=" + likeId + ", likeYn=" + likeYn + ", pushLikeUser=" + pushLikeUser
				+ ", imgBoardId=" + imgBoardId + ", likeRegistDt=" + likeRegistDt + ", likeCnt=" + likeCnt
				+ ", ranking=" + ranking + ", title=" + title + "]";
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	
	
}