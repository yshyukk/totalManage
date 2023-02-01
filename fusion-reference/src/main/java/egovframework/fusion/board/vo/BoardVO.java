/*********************************************************
 * 업 무 명 : 게시판 컨트롤러
 * 설 명 : 게시판을 조회하는 화면에서 사용 
 * 작 성 자 : 김민규
 * 작 성 일 : 2022.10.06
 * 관련테이블 : 
 * Copyright ⓒ fusionsoft.co.kr
 *
 *********************************************************/
package egovframework.fusion.board.vo;

import java.io.Serializable;

public class BoardVO implements Serializable{

	private static final long serialVersionUID = -8402510944659037798L;

	/* 게시판 */
	private Integer board_num;
	private Integer row_num;
	
	private Integer board_id;
	private String title;
	private String content;
	private String writer;
	private String board_content;
	private String del_yn;
	private String regist_dt;
	private String update_dt;
	private String select_board;
	private int board_type;

	/*카운트*/
	private String cnt_user;
	private Integer board_cnt=0;
	private String limit_dt;
	private Integer cnt_id;
	
	/*댓글*/
	private Integer comm_id;
	private Integer comm_parent;
	private String comm_content;
	private String comm_writer;
	private String comm_regist_dt;
	private Integer level;

	/*답글*/
	private int rep_parent;
	
	
	/**/
	private int boardNum;
	private int accessRole;
	private int menuId;
	
	public Integer getRow_num() {
		return row_num;
	}
	public void setRow_num(Integer row_num) {
		this.row_num = row_num;
	}
	
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public int getRep_parent() {
		return rep_parent;
	}
	public void setRep_parent(int rep_parent) {
		this.rep_parent = rep_parent;
	}
	public Integer getComm_parent() {
		return comm_parent;
	}
	public void setComm_parent(Integer comm_parent) {
		this.comm_parent = comm_parent;
	}
	public String getComm_content() {
		return comm_content;
	}
	public void setComm_content(String comm_content) {
		this.comm_content = comm_content;
	}
	public String getComm_writer() {
		return comm_writer;
	}
	public void setComm_writer(String comm_writer) {
		this.comm_writer = comm_writer;
	}
	public String getComm_regist_dt() {
		return comm_regist_dt;
	}
	public void setComm_regist_dt(String comm_regist_dt) {
		this.comm_regist_dt = comm_regist_dt;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getComm_id() {
		return comm_id;
	}
	public void setComm_id(Integer cOMM_ID) {
		comm_id = cOMM_ID;
	}
	public Integer getCnt_id() {
		return cnt_id;
	}
	public void setCnt_id(Integer cnt_id) {
		this.cnt_id = cnt_id;
	}
	public String getLimit_dt() {
		return limit_dt;
	}
	public void setLimit_dt(String limit_dt) {
		this.limit_dt = limit_dt;
	}
	public String getCnt_user() {
		return cnt_user;
	}
	public void setCnt_user(String cnt_user) {
		this.cnt_user = cnt_user;
	}
	public String getSelect_board() {
		return select_board;
	}
	public void setSelect_board(String select_board) {
		this.select_board = select_board;
	}
	public int getBoard_type() {
		return board_type;
	}
	public void setBoard_type(int board_type) {
		this.board_type = board_type;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/* 사용자 */
	private String id;
	
	public Integer getBoard_id() {
		return board_id;
	}
	public void setBoard_id(Integer board_id) {
		this.board_id = board_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Integer getBoard_cnt() {
		return board_cnt;
	}
	public void setBoard_cnt(Integer board_cnt) {
		this.board_cnt = board_cnt;
	}
	public String getRegist_dt() {
		return regist_dt;
	}
	public void setRegist_dt(String regist_dt) {
		this.regist_dt = regist_dt;
	}
	public String getUpdate_dt() {
		return update_dt;
	}
	public void setUpdate_dt(String update_dt) {
		this.update_dt = update_dt;
	}
	public String getDel_yn() {
		return del_yn;
	}
	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getBoard_num() {
		return board_num;
	}
	public void setBoard_num(Integer board_num) {
		this.board_num = board_num;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public int getAccessRole() {
		return accessRole;
	}
	public void setAccessRole(int accessRole) {
		this.accessRole = accessRole;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	@Override
	public String toString() {
		return "BoardVO [board_num=" + board_num + ", row_num=" + row_num + ", board_id=" + board_id + ", title="
				+ title + ", content=" + content + ", writer=" + writer + ", board_content=" + board_content
				+ ", del_yn=" + del_yn + ", regist_dt=" + regist_dt + ", update_dt=" + update_dt + ", select_board="
				+ select_board + ", board_type=" + board_type + ", cnt_user=" + cnt_user + ", board_cnt=" + board_cnt
				+ ", limit_dt=" + limit_dt + ", cnt_id=" + cnt_id + ", comm_id=" + comm_id + ", comm_parent="
				+ comm_parent + ", comm_content=" + comm_content + ", comm_writer=" + comm_writer + ", comm_regist_dt="
				+ comm_regist_dt + ", level=" + level + ", rep_parent=" + rep_parent + ", boardNum=" + boardNum
				+ ", accessRole=" + accessRole + ", menuId=" + menuId + ", id=" + id + "]";
	}
	

}