package egovframework.fusion.totalManagement.vo;

public class MenuVO {
	private int menuId;
	private int userId;
	private String menuName;
	private String menuType;
	private String menuPath;
	private int menuOrder;
	private String delYn;
	private int accessRole;
	
	private String role;
	
	private String link;
	
	private Integer boardNum;
	
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuType() {
		return menuType;
	}
	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}
	public String getMenuPath() {
		return menuPath;
	}
	public void setMenuPath(String menuPath) {
		this.menuPath = menuPath;
	}
	public int getMenuOrder() {
		return menuOrder;
	}
	public void setMenuOrder(int menuOrder) {
		this.menuOrder = menuOrder;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public int getAccessRole() {
		return accessRole;
	}
	public void setAccessRole(int accessRole) {
		this.accessRole = accessRole;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Integer getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(Integer boardNum) {
		this.boardNum = boardNum;
	}
	
	@Override
	public String toString() {
		return "MenuVO [menuId=" + menuId + ", userId=" + userId + ", menuName=" + menuName + ", menuType=" + menuType
				+ ", menuPath=" + menuPath + ", menuOrder=" + menuOrder + ", delYn=" + delYn + ", accessRole="
				+ accessRole + ", role=" + role + ", link=" + link + ", boardNum=" + boardNum + "]";
	}

}
