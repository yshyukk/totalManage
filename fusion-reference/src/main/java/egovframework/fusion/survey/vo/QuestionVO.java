package egovframework.fusion.survey.vo;

import java.util.List;

public class QuestionVO {

	private int queId;
	private int surveyId;
	private String queContent;
	private String queLimit;
	private int queRef;
	private int queType; // 0: 만족도조사, 1: 작성자가 직접 입력, 3: 기타, 4: 없음
	private int queOrder;
	private int childOrder;
	private int queLimitCnt;
	private int categoryId;
	private String queCategory;
	
	private String strQueCategory;
	//보기목록
	private List<SelectVO> selectList;
	
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
	public int getQueId() {
		return queId;
	}
	public void setQueId(int queId) {
		this.queId = queId;
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
	public List<SelectVO> getSelectList() {
		return selectList;
	}
	public void setSelectList(List<SelectVO> selectList) {
		this.selectList = selectList;
	}
	@Override
	public String toString() {
		return "QuestionVO [queId=" + queId + ", surveyId=" + surveyId + ", queContent=" + queContent + ", queLimit="
				+ queLimit + ", categoryId=" + categoryId + ", queRef=" + queRef + ", queType=" + queType
				+ ", queOrder=" + queOrder + ", childOrder=" + childOrder + ", selectList=" + selectList + "]";
	}
	public int getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
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
	public String getQueCategory() {
		return queCategory;
	}
	public void setQueCategory(String queCategory) {
		this.queCategory = queCategory;
	}
	public String getStrQueCategory() {
		return strQueCategory;
	}
	public void setStrQueCategory(String strQueCategory) {
		this.strQueCategory = strQueCategory;
	}
	
	
	
}