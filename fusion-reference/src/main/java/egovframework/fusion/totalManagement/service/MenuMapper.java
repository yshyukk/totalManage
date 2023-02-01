package egovframework.fusion.totalManagement.service;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.fusion.board.vo.BoardVO;
import egovframework.fusion.totalManagement.dto.TotalSearchDTO;
import egovframework.fusion.totalManagement.vo.MenuVO;

@Mapper
public interface MenuMapper {

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