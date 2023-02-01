package egovframework.fusion.imgboard.service;

import java.util.List;

import egovframework.fusion.imgboard.vo.ImgDownloadLogVO;

public interface ImgDownloadLogService {
	
	public void insDownLog(ImgDownloadLogVO imgDownloadLogVo);
	
	public List<ImgDownloadLogVO> cntDownFile(ImgDownloadLogVO imgDownloadLogVo);
	
	public List<ImgDownloadLogVO> getDownRank(ImgDownloadLogVO imgDownloadLogVo);
}
