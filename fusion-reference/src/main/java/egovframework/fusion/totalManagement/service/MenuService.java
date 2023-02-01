package egovframework.fusion.totalManagement.service;

import java.util.List;

import egovframework.fusion.board.vo.BoardVO;
import egovframework.fusion.totalManagement.dto.TotalSearchDTO;
import egovframework.fusion.totalManagement.vo.MenuVO;

public interface MenuService {
	
	public List<MenuVO> getMenuList(int userRole);
	
	public int getUserAuth(MenuVO menuVo);
	
	public void insMenuInfo(MenuVO menuVo);
	
	public MenuVO getOneMenuInfo(MenuVO menuVo);
	
	public void updMenuInfo(MenuVO menuVo);
	
	public void delMenuInfo(MenuVO menuVo);
	
	public List<Integer> getBoardNum();
	
	public List<Integer> getGalBoardNum();
		
	public List<BoardVO> getBoardSearchRes(TotalSearchDTO totalSearchDto);
	
}