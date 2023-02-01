package egovframework.fusion.survey.dto;

import java.sql.Date;
import java.util.List;

public class UpdDTO {
	private int submitId;
	private String userId;
	private int surveyId;
	private int queId;
	private int selId;
	private Date registDt;
	private Date updateDt;
	private String valText;
	private String selNum;
	private int surveyLogId;

	private List<String> selNumList;

	public int getSubmitId() {
		return submitId;
	}
	public void setSubmitId(int submitId) {
		this.submitId = submitId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
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

	public String getValText() {
		return valText;
	}

	public void setVarText(String valText) {
		this.valText = valText;
	}

	public String getSelNum() {
		return selNum;
	}

	public void setSelNum(String selNum) {
		this.selNum = selNum;
	}

	public List<String> getSelNumList() {
		return selNumList;
	}

	public void setSelNumList(List<String> selNumList) {
		this.selNumList = selNumList;
	}

	@Override
	public String toString() {
		return "UpdDTO [submitId=" + submitId + ", userId=" + userId + ", surveyId=" + surveyId + ", queId=" + queId
				+ ", selId=" + selId + ", registDt=" + registDt + ", updateDt=" + updateDt + ", valText=" + valText
				+ ", selNum=" + selNum + ", selNumList=" + selNumList + "]";
	}
	public int getSurveyLogId() {
		return surveyLogId;
	}
	public void setSurveyLogId(int surveyLogId) {
		this.surveyLogId = surveyLogId;
	}
}	