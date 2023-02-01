package egovframework.fusion.imgboard.vo;

import java.sql.Date;
import java.util.List;

public class ImgDownloadLogVO {

	private int downloadId;
	private String downUser;
	private String imgSaveName;
	private Date downDate;
	private int imgBoardId;
	
	private List<String> saveNameArr;
	private int downCnt;
	private int ranking;
	
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	public int getDownCnt() {
		return downCnt;
	}
	public void setDownCnt(int downCnt) {
		this.downCnt = downCnt;
	}
	public int getImgBoardId() {
		return imgBoardId;
	}
	public void setImgBoardId(int imgBoardId) {
		this.imgBoardId = imgBoardId;
	}
	public int getDownloadId() {
		return downloadId;
	}
	public List<String> getSaveNameArr() {
		return saveNameArr;
	}
	public void setSaveNameArr(List<String> saveNameArr) {
		this.saveNameArr = saveNameArr;
	}
	public void setDownloadId(int downloadId) {
		this.downloadId = downloadId;
	}
	public String getDownUser() {
		return downUser;
	}
	public void setDownUser(String downUser) {
		this.downUser = downUser;
	}
	public String getImgSaveName() {
		return imgSaveName;
	}
	public void setImgSaveName(String imgSaveName) {
		this.imgSaveName = imgSaveName;
	}
	public Date getDownDate() {
		return downDate;
	}
	public void setDownDate(Date downDate) {
		this.downDate = downDate;
	}
	@Override
	public String toString() {
		return "ImgDownloadLogVO [downloadId=" + downloadId + ", downUser=" + downUser + ", imgSaveName=" + imgSaveName
				+ ", downDate=" + downDate + ", imgBoardId=" + imgBoardId + ", saveNameArr=" + saveNameArr
				+ ", downCnt=" + downCnt + ", ranking=" + ranking + "]";
	}
	
	
}
