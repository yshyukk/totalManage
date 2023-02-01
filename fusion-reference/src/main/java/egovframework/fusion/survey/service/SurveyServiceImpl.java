package egovframework.fusion.survey.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.fusion.survey.dto.InsSurveyDTO;
import egovframework.fusion.survey.dto.RegistSurveyDTO;
import egovframework.fusion.survey.dto.SurveyContentDTO;
import egovframework.fusion.survey.dto.UpdDTO;
import egovframework.fusion.survey.vo.QueCategoryVO;
import egovframework.fusion.survey.vo.QuestionVO;
import egovframework.fusion.survey.vo.SurveyVO;

@Service
public class SurveyServiceImpl extends EgovAbstractServiceImpl implements  SurveyService{
	
	@Autowired
	SurveyMapper surveyMapper;
	
	@Override
	public List<SurveyVO> getSurveyList( ) {
		System.out.println(surveyMapper.getSurveyList());
		return surveyMapper.getSurveyList();
	}

	@Override
	public SurveyVO getIntroInfo(SurveyVO surveyVo) {
		return surveyMapper.getIntroInfo(surveyVo);
	}

	@Override
	public List<QuestionVO> getSurveyContent(SurveyContentDTO SurveyContentDto) throws IllegalAccessException {
		
		List<QuestionVO> resList= surveyMapper.getSurveyContent(SurveyContentDto);
		
		return resList;
	}

	@Override
	public void insSurveyRes(List<InsSurveyDTO> insList) {
		for(InsSurveyDTO items : insList) {
			System.out.println(items);
			
			if(items.getEtcVal()!= null){
				items.setValText(items.getEtcVal());
			}
			if (items.getTextAreaVal() != null) {
				items.setValText(items.getTextAreaVal());
			}
			List<Integer> tmpList = items.getCheckedVal();
			String str = "";
			System.out.println("tempList::" +tmpList);
			System.out.println(tmpList.size());
			if(tmpList.size() == 0) {
				str = "0";
			}
			for(int i=0; i<tmpList.size(); i++) {

				if(i == tmpList.size()-1) {
					str += Integer.toString(tmpList.get(i));	
				}else {
					str += Integer.toString(tmpList.get(i));
					str += ",";
				}		 
			}			
			items.setCheckValStr(str);
			System.out.println("string으로 전환 후 :::" +items);

		}
		surveyMapper.insSurveyRes(insList);
	}

	@Override
	public void delSurvey(int surveyLogId) {
		surveyMapper.delSurvey(surveyLogId);
		
	}

	@Override
	public List<UpdDTO> getSubmitInfo(SurveyContentDTO SurveyContentDto) {
		
		  List<UpdDTO> submitList = surveyMapper.getSubmitInfo(SurveyContentDto);
		  
		  for(int i=0; i<submitList.size(); i++) { 
			  String selectedNum = submitList.get(i).getSelNum();

			  if (selectedNum == null) {
				  continue;
			  } 
			  String tempArr [] = selectedNum.split(","); 
		      
			  submitList.get(i).setSelNumList(Arrays.asList(tempArr));   
			  
			  if(submitList.get(i).getValText() == null) {
				  submitList.get(i).setVarText("");
			  }
			  
		  } 
		return submitList;
	}

	@Override
	public void insSurveyLog(InsSurveyDTO insSurveyDto) {
		surveyMapper.insSurveyLog(insSurveyDto);
	}

	@Override
	public List<SurveyVO> getSurveyMyList(SurveyVO surveyVo) {
		return surveyMapper.getSurveyMyList(surveyVo);
	}

	@Override
	public int getLogId(InsSurveyDTO insSurveyDto) {
		return surveyMapper.getLogId(insSurveyDto);
	}

	@Override
	public int getSurveyResCnt(SurveyVO surveyVo) {
		return surveyMapper.getSurveyResCnt(surveyVo);
	}
	
	
	@Override
	public List<QueCategoryVO> getCategory() {
		return surveyMapper.getCategory();
	}

	@Override
	public void insSurveyinfo(RegistSurveyDTO registSurveyDto) {

		String strWinDate = registSurveyDto.getWinDate();
		String strStartDate = registSurveyDto.getStartDate();
		String strEndDate = registSurveyDto.getEndDate();
		
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date1 = LocalDate.parse(strWinDate, dateTimeFormatter);
		LocalDate date2 = LocalDate.parse(strStartDate, dateTimeFormatter);
		LocalDate date3 = LocalDate.parse(strEndDate, dateTimeFormatter);

		java.sql.Date dateWinDate = java.sql.Date.valueOf(date1);
		java.sql.Date dateStartDate = java.sql.Date.valueOf(date2);
		java.sql.Date dateEndDate = java.sql.Date.valueOf(date3);
		
		registSurveyDto.setDateWinDate(dateWinDate);
		registSurveyDto.setDateStartDate(dateStartDate);
		registSurveyDto.setDateEndDate(dateEndDate);
		
		surveyMapper.insSurveyinfo(registSurveyDto);		
	}

	@Override
	public void insQueInfo(RegistSurveyDTO registSurveyDto) {		
		surveyMapper.insQueInfo(registSurveyDto);
	}
	@Override
	public int getMaxSurveyId() {
		return surveyMapper.getMaxSurveyId();
	}

	@Override
	public void insSelInfo(RegistSurveyDTO registSurveyDto) {
		surveyMapper.insSelInfo(registSurveyDto);
		
	}

	@Override
	public List<RegistSurveyDTO> getUpdQueInfo(int surveyId) {
		return surveyMapper.getUpdQueInfo(surveyId);
	}

	@Override
	public RegistSurveyDTO getUpdSurveyInfo(SurveyContentDTO surveyContentDto) {
		return surveyMapper.getUpdSurveyInfo(surveyContentDto);
	}

	@Override
	public void delSurveyInfo(int surveyId) {
		surveyMapper.delSurveyInfo(surveyId);
		
	}

	@Override
	public void delSurveyQueInfo(int surveyId) {
		surveyMapper.delSurveyQueInfo(surveyId);
		
	}

	@Override
	public void delSurveySelInfo(int queId) {
		surveyMapper.delSurveySelInfo(queId);
		
	}
}