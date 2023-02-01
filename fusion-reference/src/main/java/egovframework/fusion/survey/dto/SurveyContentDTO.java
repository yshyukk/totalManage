package egovframework.fusion.survey.dto;

import java.util.List;

public class SurveyContentDTO {
	
	private int queId;
	private int surveyId;
	private String queContent;
	private String queLimit;
	private String queCategory; //문항분류
	private int queRef;
	private int queType; // 0: 만족도조사, 1: 작성자가 직접 입력, 3: 기타, 4: 없음
	private int queOrder; //문제순서
	private int childOrder;
	private int queLimitCnt;
	private int categoryId;
	private int surveyLogId;
	private int surveyTitle;
	
	private int selId;
	private String selContent;
	private int selValType;
	private int selType;
	private String userId;
	private int selNum;
	
	private List<String> selContentList;
	
	public int getQueId() {
		return queId;
	}
	public void setQueId(int queId) {
		this.queId = queId;
	}
	public int getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(int serveyid) {
		this.surveyId = serveyid;
	}
	public String getQueContent() {
		return queContent;
	}
	public void setQueContent(String queContent) {
		this.queContent = queContent;
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
	public int getQueRef() {
		return queRef;
	}
	public void setQueRef(int queRef) {
		this.queRef = queRef;
	}
	public int getQueType() {
		return queType;
	}
	public void setQueType(int queType) {
		this.queType = queType;
	}
	public int getSelId() {
		return selId;
	}
	public void setSelId(int selId) {
		this.selId = selId;
	}
	public String getSelContent() {
		return selContent;
	}
	public void setSelContent(String selContent) {
		this.selContent = selContent;
	}
	public int getSelValType() {
		return selValType;
	}
	public void setSelValType(int selValType) {
		this.selValType = selValType;
	}
	public int getSelType() {
		return selType;
	}
	public void setSelType(int selType) {
		this.selType = selType;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<String> getSelContentList() {
		return selContentList;
	}
	public void setSelContentList(List<String> selContentList) {
		this.selContentList = selContentList;
	}
	public int getQueOrder() {
		return queOrder;
	}
	public void setQueOrder(int queOrder) {
		this.queOrder = queOrder;
	}

	public int getChildOrder() {
		return childOrder;
	}
	public void setChildOrder(int childOrder) {
		this.childOrder = childOrder;
	}
	public int getSelNum() {
		return selNum;
	}
	public void setSelNum(int selNum) {
		this.selNum = selNum;
	}
	@Override
	public String toString() {
		return "SurveyContentDTO [queId=" + queId + ", surveyId=" + surveyId + ", queContent=" + queContent
				+ ", queLimit=" + queLimit + ", queCategory=" + queCategory + ", queRef=" + queRef + ", queType="
				+ queType + ", queOrder=" + queOrder + ", childOrder=" + childOrder + ", selId=" + selId
				+ ", selContent=" + selContent + ", selValType=" + selValType
				+ ", selType=" + selType + ", userId=" + userId + ", selNum=" + selNum + ", selContentList="
				+ selContentList + "]";
	}
	public int getQueLimitCnt() {
		return queLimitCnt;
	}
	public void setQueLimitCnt(int queLimitCnt) {
		this.queLimitCnt = queLimitCnt;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getSurveyLogId() {
		return surveyLogId;
	}
	public void setSurveyLogId(int surveyLogId) {
		this.surveyLogId = surveyLogId;
	}
	public int getSurveyTitle() {
		return surveyTitle;
	}
	public void setSurveyTitle(int surveyTitle) {
		this.surveyTitle = surveyTitle;
	}
}