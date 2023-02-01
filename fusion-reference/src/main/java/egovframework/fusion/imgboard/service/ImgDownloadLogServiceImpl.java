package egovframework.fusion.imgboard.service;

import java.util.List;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.fusion.imgboard.vo.ImgDownloadLogVO;

@Service
public class ImgDownloadLogServiceImpl  extends EgovAbstractServiceImpl implements ImgDownloadLogService{
@Autowired
ImgDownloadLogMapper imgDownloadLogMapper;
	@Override
		public void insDownLog(ImgDownloadLogVO imgDownloadLogVo) {
			imgDownloadLogMapper.insDownLog(imgDownloadLogVo);	
		}
	@Override
	public List<ImgDownloadLogVO> cntDownFile(ImgDownloadLogVO imgDownloadLogVo) {
		return 	imgDownloadLogMapper.cntDownFile(imgDownloadLogVo);	
	
	}
	@Override
	public List<ImgDownloadLogVO> getDownRank(ImgDownloadLogVO imgDownloadLogVo) {
		return imgDownloadLogMapper.getDownRank(imgDownloadLogVo);
	}

}
