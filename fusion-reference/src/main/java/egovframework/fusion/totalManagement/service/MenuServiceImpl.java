package egovframework.fusion.totalManagement.service;

import java.util.List;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.fusion.board.vo.BoardVO;
import egovframework.fusion.imgboard.service.ImgBoardServiceImpl;
import egovframework.fusion.totalManagement.dto.TotalSearchDTO;
import egovframework.fusion.totalManagement.vo.MenuVO;

@Service
public class MenuServiceImpl extends EgovAbstractServiceImpl implements MenuService{
	private static final Logger LOGGER = LoggerFactory.getLogger(ImgBoardServiceImpl.class);
	
	@Autowired
	MenuMapper menuMapper;
	
	@Override
	public List<MenuVO> getMenuList(int userRole) {
		return menuMapper.getMenuList(userRole);
	}

	@Override
	public int getUserAuth(MenuVO menuVo) {
		return menuMapper.getUserAuth(menuVo);
	}

	@Override
	public void insMenuInfo(MenuVO menuVo) {
		menuMapper.insMenuInfo(menuVo);		
	}

	@Override
	public MenuVO getOneMenuInfo(MenuVO menuVo) {
		MenuVO menuInfo = menuMapper.getOneMenuInfo(menuVo);
		String menuPath = menuInfo.getMenuPath();
		int findString = menuPath.indexOf("http");
		System.out.println("asdasd:"+findString);
		
		if(findString > -1) {
			int lastIndex = menuPath.indexOf("?");
			String link = menuPath.substring(0,lastIndex);
			menuInfo.setLink(link);
		}

		return menuInfo;
	}

	@Override
	public void updMenuInfo(MenuVO menuVo) {
		 menuMapper.updMenuInfo(menuVo);
	}

	@Override
	public void delMenuInfo(MenuVO menuVo) {
		menuMapper.delMenuInfo(menuVo);
		
	}

	@Override
	public List<Integer> getBoardNum() {
		return menuMapper.getBoardNum();
	}

	@Override
	public List<Integer> getGalBoardNum() {
		// TODO Auto-generated method stub
		return menuMapper.getGalBoardNum();
	}

	@Override
	public List<BoardVO> getBoardSearchRes(TotalSearchDTO totalSearchDto) {
		return menuMapper.getBoardSearchRes(totalSearchDto);
	}
	
	
	


}