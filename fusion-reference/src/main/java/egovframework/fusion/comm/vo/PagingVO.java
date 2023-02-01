package egovframework.fusion.comm.vo;

public class PagingVO {
	
	private String userId;

	/* 사용전 설정해야 하는 값*/
	private int total; // 총 게시글 수
	private int viewPage = 1; //현재페이지 번호
	private String search; //검색
	private String searchText;
	private int pageFilter=3; // 페이지에 몇개씩 보여줄껀지
	
	/* 자동으로 계산되서 사용되는 값 */
	private int totalPage; //총 페이지 수
	private int startIndex = 1; // 
	private int endIndex=10; // 끝
	private int startPage;
	private int endPage;
	private int pageBtnNum=10; //페이지 버튼 ㄳㅅ
	private boolean prev;
	private boolean next;
	
	
	
	//새로 생성된 게시판을 구분하기 위한 변수
	private int boardNum;
	

	public int getPageFilter() {
		return pageFilter;
	}
	public void setPageFilter(int pageFilter) {
		this.pageFilter = pageFilter;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	public int getViewPage() {
		return viewPage;
	}
	public void setViewPage(int viewPage) {
		this.viewPage = viewPage;
	}
	
	
	 //총 페이지 수
	public int getTotalPage() {
		int temp = (int) Math.ceil((double)this.total/this.pageFilter);
		return temp;
	}
	public int getStartIndex() {
		return ((this.viewPage-1)*this.pageFilter)+1;
	}
	public int getEndIndex() {
		return getStartIndex()+this.pageFilter;
	}
	public int getStartPage() {
		return ((this.viewPage-1)/(this.pageBtnNum))*this.pageBtnNum+1;
	}
	public int getEndPage() {
		if(getStartPage()+this.pageBtnNum > getTotalPage()) {
			return getTotalPage();
		}else {
			return getStartPage()+this.pageBtnNum -1;
		}
	}
	
	public int getPageBtnNum() {
		return pageBtnNum;
	}
	
	public boolean isPrev() {
		if(this.viewPage <= 1) {
			return false;
		}else {
			return true;
		}
		
	}
	public boolean isNext() {
		if(this.viewPage >= this.getEndPage()) {
			return false;
		}else {
			return true;
		}
	}
	@Override
	public String toString() {
		return "PagingVO [total=" + total + ", viewPage=" + viewPage + ", search=" + search + ", searchText="
				+ searchText + ", pageFilter=" + pageFilter + ", totalPage=" + totalPage + ", startIndex=" + startIndex
				+ ", endIndex=" + endIndex + ", startPage=" + startPage + ", endPage=" + endPage + ", pageBtnNum="
				+ pageBtnNum + ", prev=" + prev + ", next=" + next + "]";
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
}