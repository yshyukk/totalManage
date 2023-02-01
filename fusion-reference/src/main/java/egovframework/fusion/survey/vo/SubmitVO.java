package egovframework.fusion.survey.vo;

import java.sql.Date;

public class SubmitVO {
	
	private int submitId;
	private int userId;
	private int serveyId;
	private int queId;
	private int selId;
	private Date registDt;
	private Date updateDt;
	private String valOne;
	private String valMulti;
	private String valText;
	public int getSubmitId() {
		return submitId;
	}
	public void setSubmitId(int submitId) {
		this.submitId = submitId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getServeyId() {
		return serveyId;
	}
	public void setServeyId(int serveyId) {
		this.serveyId = serveyId;
	}
	public int getQueId() {
		return queId;
	}
	public void setQueId(int queId) {
		this.queId = queId;
	}
	public int getSelId() {
		return selId;
	}
	public void setSelId(int selId) {
		this.selId = selId;
	}
	public Date getRegistDt() {
		return registDt;
	}
	public void setRegistDt(Date registDt) {
		this.registDt = registDt;
	}
	public Date getUpdateDt() {
		return updateDt;
	}
	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}
	public String getValOne() {
		return valOne;
	}
	public void setValOne(String valOne) {
		this.valOne = valOne;
	}
	public String getValMulti() {
		return valMulti;
	}
	public void setValMulti(String valMulti) {
		this.valMulti = valMulti;
	}
	public String getValText() {
		return valText;
	}
	public void setValText(String valText) {
		this.valText = valText;
	}
	
	@Override
	public String toString() {
		return "SubmitVO [submitId=" + submitId + ", userId=" + userId + ", serveyId=" + serveyId + ", queId=" + queId
				+ ", selId=" + selId + ", registDt=" + registDt + ", updateDt=" + updateDt + ", valOne=" + valOne
				+ ", valMulti=" + valMulti + ", valText=" + valText + "]";
	}
	
	
	
}