package egovframework.fusion.survey.vo;

public class SelectVO {
	private int selId;
	private int queId;
	private String selContent;
	private int selLimitCnt;
	private int selValType;
	private int selType;
	private int selNum;
	
	public int getSelType() {
		return selType;
	}
	public void setSelType(int selType) {
		this.selType = selType;
	}
	public int getSelId() {
		return selId;
	}
	public void setSelId(int selId) {
		this.selId = selId;
	}
	public int getQueId() {
		return queId;
	}
	public void setQueId(int queId) {
		this.queId = queId;
	}
	public String getSelContent() {
		return selContent;
	}
	public void setSelContent(String selContent) {
		this.selContent = selContent;
	}

	public int getSelLimitCnt() {
		return selLimitCnt;
	}
	public void setSelLimitCnt(int selLimitCnt) {
		this.selLimitCnt = selLimitCnt;
	}
	public int getSelValType() {
		return selValType;
	}
	public void setSelValType(int selValType) {
		this.selValType = selValType;
	}
	@Override
	public String toString() {
		return "SelectAnswerVO [selId=" + selId + ", queId=" + queId + ", selContent=" + selContent + ", selLimitCnt="
				+ selLimitCnt + ", selValType=" + selValType + ", selType=" + selType + "]";
	}
	public int getSelNum() {
		return selNum;
	}
	public void setSelNum(int selNum) {
		this.selNum = selNum;
	}
	
}