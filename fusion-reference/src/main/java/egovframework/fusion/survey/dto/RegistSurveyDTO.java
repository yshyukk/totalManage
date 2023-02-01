package egovframework.fusion.survey.dto;

import java.sql.Date;
import java.util.List;

public class RegistSurveyDTO {
	private String title;
	private String participant;
	private String participantCnt;
	private String winDate;
	private String startDate;
	private String endDate;
	
	private Date dateWinDate;
	private Date dateStartDate;
	private Date dateEndDate;
	
	private String queId;
	private String queLimit;
	private String queCategory;
	private String addCategory;
	private String queContent;
	private String selType;
	private String queLimitCnt;
	private List<String> selContentArr;
	private int queOrder;
	private int surveyId;
	
	private String selContent;
	private int selNum;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getParticipant() {
		return participant;
	}
	public void setParticipant(String participant) {
		this.participant = participant;
	}
	public String getParticipantCnt() {
		return participantCnt;
	}
	public void setParticipantCnt(String participantCnt) {
		this.participantCnt = participantCnt;
	}
	public String getWinDate() {
		return winDate;
	}
	public void setWinDate(String winDate) {
		this.winDate = winDate;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getQueLimit() {
		return queLimit;
	}
	public void setQueLimit(String queLimit) {
		this.queLimit = queLimit;
	}
	public String getQueCategory() {
		return queCategory;
	}
	public void setQueCategory(String queCategory) {
		this.queCategory = queCategory;
	}
	public String getAddCategory() {
		return addCategory;
	}
	public void setAddCategory(String addCategory) {
		this.addCategory = addCategory;
	}
	public String getQueContent() {
		return queContent;
	}
	public void setQueContent(String queContent) {
		this.queContent = queContent;
	}
	public String getSelType() {
		return selType;
	}
	public void setSelType(String selType) {
		this.selType = selType;
	}
	public String getQueLimitCnt() {
		return queLimitCnt;
	}
	public void setQueLimitCnt(String queLimitCnt) {
		this.queLimitCnt = queLimitCnt;
	}
	public List<String> getSelContentArr() {
		return selContentArr;
	}
	public void setSelContentArr(List<String> selContentArr) {
		this.selContentArr = selContentArr;
	}
	public Date getDateWinDate() {
		return dateWinDate;
	}
	public void setDateWinDate(Date dateWinDate) {
		this.dateWinDate = dateWinDate;
	}
	public Date getDateStartDate() {
		return dateStartDate;
	}
	public void setDateStartDate(Date dateStartDate) {
		this.dateStartDate = dateStartDate;
	}
	public Date getDateEndDate() {
		return dateEndDate;
	}
	public void setDateEndDate(Date dateEndDate) {
		this.dateEndDate = dateEndDate;
	}
	
	public int getQueOrder() {
		return queOrder;
	}
	public void setQueOrder(int queOrder) {
		this.queOrder = queOrder;
	}

	public int getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}
	public String getQueId() {
		return queId;
	}
	public void setQueId(String queId) {
		this.queId = queId;
	}
	public String getSelContent() {
		return selContent;
	}
	public void setSelContent(String selContent) {
		this.selContent = selContent;
	}
	public int getSelNum() {
		return selNum;
	}
	public void setSelNum(int selNum) {
		this.selNum = selNum;
	}
	@Override
	public String toString() {
		return "RegistSurveyDTO [title=" + title + ", participant=" + participant + ", participantCnt=" + participantCnt
				+ ", winDate=" + winDate + ", startDate=" + startDate + ", endDate=" + endDate + ", dateWinDate="
				+ dateWinDate + ", dateStartDate=" + dateStartDate + ", dateEndDate=" + dateEndDate + ", queLimit="
				+ queLimit + ", queCategory=" + queCategory + ", addCategory=" + addCategory + ", queContent="
				+ queContent + ", selType=" + selType + ", queLimitCnt=" + queLimitCnt + ", selContentArr="
				+ selContentArr + ", queOrder=" + queOrder + "]";
	}
	
	
}