package egovframework.fusion.survey.vo;

import java.sql.Date;

public class SurveyVO {

	private int surveyId;
	private String userId;
	private String surveyTitle;
	private String participant;
	private int participantCnt;
	private String winDt;
	private Date registDt;
	private Date startDt;
	private Date endDt;
	private String delYn;
	private int queOrder; //문제순서
	
	private int boardNum;
	private int surveyPeriod;
	private String startPeriod;
	private String endPeriod;
	private int myListCount;
	private int updLimit;
	//
	private int surveyLogId;
	
	
	public String getStartPeriod() {
		return startPeriod;
	}
	public void setStartPeriod(String startPeriod) {
		this.startPeriod = startPeriod;
	}
	public String getEndPeriod() {
		return endPeriod;
	}
	public void setEndPeriod(String endPeriod) {
		this.endPeriod = endPeriod;
	}
	public int getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSurveyTitle() {
		return surveyTitle;
	}
	public void setSurveyTitle(String surveyTitle) {
		this.surveyTitle = surveyTitle;
	}
	public String getParticipant() {
		return participant;
	}
	public void setParticipant(String participant) {
		this.participant = participant;
	}
	public int getParticipantCnt() {
		return participantCnt;
	}
	public void setParticipantCnt(int participantCnt) {
		this.participantCnt = participantCnt;
	}
	public String getWinDt() {
		return winDt;
	}
	public void setWinDt(String winDt) {
		this.winDt = winDt;
	}
	public Date getRegistDt() {
		return registDt;
	}
	public void setRegistDt(Date registDt) {
		this.registDt = registDt;
	}
	public Date getStartDt() {
		return startDt;
	}
	public void setStartDt(Date startDt) {
		this.startDt = startDt;
	}
	public Date getEndDt() {
		return endDt;
	}
	public void setEndDt(Date endDt) {
		this.endDt = endDt;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public int getSurveyPeriod() {
		return surveyPeriod;
	}
	public void setSurveyPeriod(int surveyPeriod) {
		this.surveyPeriod = surveyPeriod;
	}
	public int getQueOrder() {
		return queOrder;
	}
	public void setQueOrder(int queOrder) {
		this.queOrder = queOrder;
	}
	public int getSurveyLogId() {
		return surveyLogId;
	}
	public void setSurveyLogId(int surveyLogId) {
		this.surveyLogId = surveyLogId;
	}
	@Override
	public String toString() {
		return "SurveyVO [surveyId=" + surveyId + ", userId=" + userId + ", surveyTitle=" + surveyTitle
				+ ", participant=" + participant + ", participantCnt=" + participantCnt + ", winDt=" + winDt
				+ ", registDt=" + registDt + ", startDt=" + startDt + ", endDt=" + endDt + ", delYn=" + delYn
				+ ", queOrder=" + queOrder + ", boardNum=" + boardNum + ", surveyPeriod=" + surveyPeriod
				+ ", startPeriod=" + startPeriod + ", endPeriod=" + endPeriod + ", surveyLogId=" + surveyLogId + "]";
	}
	public int getMyListCount() {
		return myListCount;
	}
	public void setMyListCount(int myListCount) {
		this.myListCount = myListCount;
	}
	public int getUpdLimit() {
		return updLimit;
	}
	public void setUpdLimit(int updLimit) {
		this.updLimit = updLimit;
	}
	
	
}