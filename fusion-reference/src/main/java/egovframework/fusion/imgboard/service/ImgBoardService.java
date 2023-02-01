package egovframework.fusion.imgboard.service;

import java.util.List;

import egovframework.fusion.comm.vo.PagingVO;
import egovframework.fusion.imgboard.dto.ImgBoardListDTO;
import egovframework.fusion.imgboard.vo.ImgBoardVO;
import egovframework.fusion.totalManagement.dto.TotalSearchDTO;


public interface ImgBoardService {
	
	public List<ImgBoardListDTO> getImgBoard(PagingVO pagingVo);

	public int searchTotal(ImgBoardVO imgBoardVo);
	
	public int insImgBoard(ImgBoardVO imgBoardVo) ;
	
	public int getMaxBoardId(String userId);
	
	public void insThumbNail(int imgBoardId);
	
	public int searchTotalCount(PagingVO pagingVo);
	
	public ImgBoardVO getImgBoardDetailInfo(int imgBoardId);
	
	public void updateContents(ImgBoardVO imgBoardVo);
	
	public void delImgBoard(int imgBoardId);
	
	
	/* SELECT */
	// TOTAL-SEARCH (통합검색)
	public List<ImgBoardVO> getImgTotalSearch(TotalSearchDTO condition);
	
}