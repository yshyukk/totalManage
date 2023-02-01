package egovframework.fusion.imgboard.service;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.fusion.imgboard.vo.ImgDownloadLogVO;

@Mapper
public interface ImgDownloadLogMapper {
	
	public void insDownLog(ImgDownloadLogVO imgDownloadLogVo);
	
	public List<ImgDownloadLogVO> cntDownFile(ImgDownloadLogVO imgDownloadLogVo);
	
	public List<ImgDownloadLogVO> getDownRank(ImgDownloadLogVO imgDownloadLogVo);



}
