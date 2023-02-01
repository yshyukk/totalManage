package egovframework.fusion.survey.dto;

import java.sql.Date;
import java.util.List;

public class InsSurveyDTO {
	private int surveyId;
	private int queId;
	private int childOrder;
	private int queType;
	private List<Integer> checkedVal;
	private String textAreaVal;
	private String etcVal;
	private String valText;
	private int selNum;
	private String delYn;
	private int selId;
	
	private int submitId;

	private Date registDt;
	private Date updateDt;
	private int surveyLogId;

	private List<String> selNumList;
	

	private String checkValStr;
	
	private String userId;

	
	public int getSubmitId() {
		return submitId;
	}
	public void setSubmitId(int submitId) {
		this.submitId = submitId;
	}
	public Date getUpdateDt() {
		return updateDt;
	}
	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}
	public int getSurveyLogId() {
		return surveyLogId;
	}
	public void setSurveyLogId(int surveyLogId) {
		this.surveyLogId = surveyLogId;
	}
	public List<String> getSelNumList() {
		return selNumList;
	}
	public void setSelNumList(List<String> selNumList) {
		this.selNumList = selNumList;
	}
	public int getChildOrder() {
		return childOrder;
	}
	public void setChildOrder(int childOrder) {
		this.childOrder = childOrder;
	}
	public int getQueType() {
		return queType;
	}
	public void setQueType(int queType) {
		this.queType = queType;
	}
	public List<Integer> getCheckedVal() {
		return checkedVal;
	}
	public void setCheckedVal(List<Integer> checkedVal) {
		this.checkedVal = checkedVal;
	}
	public String getTextAreaVal() {
		return textAreaVal;
	}
	public void setTextAreaVal(String textAreaVal) {
		this.textAreaVal = textAreaVal;
	}
	public String getEtcVal() {
		return etcVal;
	}
	public void setEtcVal(String etcVal) {
		this.etcVal = etcVal;
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
	public String getValText() {
		return valText;
	}
	public void setValText(String valText) {
		this.valText = valText;
	}
	public int getSelNum() {
		return selNum;
	}
	public void setSelNum(int selNum) {
		this.selNum = selNum;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

	public int getSelId() {
		return selId;
	}
	public void setSelId(int selId) {
		this.selId = selId;
	}
	
	public String getCheckValStr() {
		return checkValStr;
	}
	public void setCheckValStr(String checkValStr) {
		this.checkValStr = checkValStr;
	}
	@Override
	public String toString() {
		return "InsSurveyDTO [surveyId=" + surveyId + ", queId=" + queId + ", childOrder=" + childOrder + ", queType="
				+ queType + ", checkedVal=" + checkedVal + ", textAreaVal=" + textAreaVal + ", etcVal=" + etcVal
				+ ", valText=" + valText + ", selNum=" + selNum + ", delYn=" + delYn + ", selId=" + selId
				+ ", checkValStr=" + checkValStr + ", userId=" + userId + "]";
	}
	public Date getRegistDt() {
		return registDt;
	}
	public void setRegistDt(Date registDt) {
		this.registDt = registDt;
	}

	
	
	
}