package egovframework.fusion.survey.service;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.fusion.survey.dto.InsSurveyDTO;
import egovframework.fusion.survey.dto.RegistSurveyDTO;
import egovframework.fusion.survey.dto.SurveyContentDTO;
import egovframework.fusion.survey.dto.UpdDTO;
import egovframework.fusion.survey.vo.QueCategoryVO;
import egovframework.fusion.survey.vo.QuestionVO;
import egovframework.fusion.survey.vo.SurveyVO;

@Mapper
public interface SurveyMapper {
	public List<SurveyVO> getSurveyList();
	
	public SurveyVO getIntroInfo(SurveyVO surveyVo);
	
	public List<QuestionVO> getSurveyContent(SurveyContentDTO SurveyContentDto);
	
	public void insSurveyLog(InsSurveyDTO insSurveyDto);
	
	public int getLogId(InsSurveyDTO insSurveyDto);
	
	public void insSurveyRes(List<InsSurveyDTO> insList);
	
	public void delSurvey(int surveyLogId);
	
	public List<UpdDTO> getSubmitInfo(SurveyContentDTO SurveyContentDto);
	
	public List<SurveyVO>getSurveyMyList(SurveyVO surveyVo);
	
	public int getSurveyResCnt(SurveyVO surveyVo);
	
	public List<QueCategoryVO> getCategory();
	
	public void insSurveyinfo(RegistSurveyDTO registSurveyDto);
	
	public int getMaxSurveyId();
	
	public void insQueInfo(RegistSurveyDTO registSurveyDto);
	
	public void insSelInfo(RegistSurveyDTO registSurveyDto);
	
	public List<RegistSurveyDTO> getUpdQueInfo(int surveyId);

	public RegistSurveyDTO getUpdSurveyInfo(SurveyContentDTO surveyContentDto);
	
	public void delSurveyInfo(int surveyId);
	
	public void delSurveyQueInfo(int surveyId);
	
	public void delSurveySelInfo(int queId);


	
}