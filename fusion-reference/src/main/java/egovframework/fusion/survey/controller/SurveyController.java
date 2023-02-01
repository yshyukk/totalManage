package egovframework.fusion.survey.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import egovframework.fusion.survey.dto.InsSurveyDTO;
import egovframework.fusion.survey.dto.RegistSurveyDTO;
import egovframework.fusion.survey.dto.SurveyContentDTO;
import egovframework.fusion.survey.dto.UpdDTO;
import egovframework.fusion.survey.service.SurveyService;
import egovframework.fusion.survey.vo.QueCategoryVO;
import egovframework.fusion.survey.vo.QuestionVO;
import egovframework.fusion.survey.vo.SurveyVO;

@Controller
public class SurveyController {

	@Autowired
	SurveyService surveyService;
	
	//설문지 리스트
	@RequestMapping(value="/survey/surveyList.do", method = RequestMethod.GET)
	public String surveyList(SurveyVO surveyVo, HttpServletRequest request, Model model) throws Exception {
		
		List<SurveyVO> listInfo = surveyService.getSurveyList();
		model.addAttribute("SuveyListInfo", listInfo);

		return "survey/surveyList.tiles";
	}

	//설문지 첫페이지
	@RequestMapping(value="/survey/introSurvey.do", method = RequestMethod.GET)
	public String introSurvey(SurveyVO surveyVo, HttpServletRequest request, Model model)  throws Exception{
		HttpSession session = request.getSession(false);
		
		String userId = "";
		
		if(session.getAttribute("userId") == null) {
			userId = request.getSession().getId();
		}else {
			surveyVo.setUserId(session.getAttribute("userId").toString());
		}
		
		SurveyVO surveyIntroInfo = surveyService.getIntroInfo(surveyVo);
		List<SurveyVO>getSurveyMyList = surveyService.getSurveyMyList(surveyVo);
		
		surveyVo.setUserId(userId);
		int surveyResCnt = surveyService.getSurveyResCnt(surveyVo);
		
		model.addAttribute("introInfo",surveyIntroInfo);
		model.addAttribute("myList",getSurveyMyList);
		model.addAttribute("surveyResCnt",surveyResCnt);
		return "views/survey/introSurvey";
	}
	
	//설문시작
	@RequestMapping(value="/survey/doSurvey.do", method = RequestMethod.GET)
	public String startSurvey(SurveyContentDTO surveyContentDto, Model model, HttpServletRequest request)  throws Exception{
		
		HttpSession session = request.getSession(false);
		String userId = "";
		
		if(session.getAttribute("userId") == null) {
			userId = request.getSession().getId();
		}else {
			userId = session.getAttribute("userId").toString();
		}
		
		surveyContentDto.setUserId(userId);
		surveyContentDto.setSurveyId(surveyContentDto.getSurveyId());
		
		List<QuestionVO> resList = surveyService.getSurveyContent(surveyContentDto);
	
		model.addAttribute("surveyContent",resList);
		return "views/survey/doSurvey";
	}
	//설문조사 결과 등록
	@RequestMapping(value="/survey/insSurvey.do", method = RequestMethod.POST)
	@ResponseBody
	public String insSurvey(InsSurveyDTO insSurveyDto, @RequestBody String list, HttpServletRequest request)  throws Exception{
		
		HttpSession session = request.getSession(false);
		String userId = "";
				
		if(session.getAttribute("userId") == null) {
			userId = request.getSession().getId();
		}else {
			userId = session.getAttribute("userId").toString();
		}
		Gson gson = new GsonBuilder().serializeNulls().create();
	
		String jsonString = list;
        
		List<InsSurveyDTO> insList = gson.fromJson(jsonString, new TypeToken<List<InsSurveyDTO>>(){}.getType());
		
		insSurveyDto.setSurveyId(insList.get(0).getSurveyId());
		insSurveyDto.setUserId(userId);
		
		
		
		surveyService.insSurveyLog(insSurveyDto);
		int surveyLogId = surveyService.getLogId(insSurveyDto);
		
		for(InsSurveyDTO items : insList) {
			items.setSurveyLogId(surveyLogId);
			items.setUserId(userId);
		}
		surveyService.insSurveyRes(insList);
		
		return "success";
	}
	//수정 페이지로 이동
	//
	@RequestMapping(value="/survey/updPage.do", method = RequestMethod.GET)
	public String updPage(SurveyContentDTO surveyContentDto, Model model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession(false);
		String userId = "";
		
		userId = session.getAttribute("userId").toString();
		
		surveyContentDto.setUserId(userId);
		
		surveyContentDto.setSurveyId(surveyContentDto.getSurveyId());
		
		List<QuestionVO> resList = surveyService.getSurveyContent(surveyContentDto);
		List<UpdDTO> submitList = surveyService.getSubmitInfo(surveyContentDto);
		
		model.addAttribute("surveyContent",resList);
		model.addAttribute("submitList",submitList);
		
		return "views/survey/updateSurvey";
	}

	//수정버튼 클릭시
	@RequestMapping(value="/survey/updSurvey.do", method = RequestMethod.POST)
	@ResponseBody
	public String updSurvey(@RequestBody String list, HttpServletRequest request)  throws Exception{
		
		HttpSession session = request.getSession(false);
		String userId = "";
	
		userId = session.getAttribute("userId").toString();
		
		Gson gson = new GsonBuilder().serializeNulls().create();
	
		String jsonString = list;
        
		List<InsSurveyDTO> insList = gson.fromJson(jsonString, new TypeToken<List<InsSurveyDTO>>(){}.getType());
		
		for(InsSurveyDTO item : insList) {
			item.setUserId(userId);
		}
		
		int surveyLogId = insList.get(0).getSurveyLogId();
		
		surveyService.delSurvey(surveyLogId);
		surveyService.insSurveyRes(insList);
		
		return "success";
	}
	//설문조사 작성페이지
	@RequestMapping(value="/survey/makeSurvey.do", method = RequestMethod.GET)
	public String makeSurvey(Model model) throws Exception {
		
		List<QueCategoryVO> categoryList = surveyService.getCategory();
		
		model.addAttribute("categoryList",categoryList);
		
		return "views/survey/makeSurvey";
	}
	//설문조사 등록
	@RequestMapping(value="/survey/registSurvey.do", method = RequestMethod.POST)
	@ResponseBody
	public String registSurvey(@RequestBody String list, HttpServletRequest request)  throws Exception{
		
		HttpSession session = request.getSession(false);
		String userId = "";
				
		if(session.getAttribute("userId") == null) {
			userId = request.getSession().getId();
		}else {
			userId = session.getAttribute("userId").toString();
		}
		
		Gson gson = new GsonBuilder().serializeNulls().create();

		List<RegistSurveyDTO> surveyInfoList = gson.fromJson(list, new TypeToken<List<RegistSurveyDTO>>(){}.getType());
		
		RegistSurveyDTO registSurveyDto = surveyInfoList.get(0);
		
		surveyService.insSurveyinfo(registSurveyDto);
		int surveyId = surveyService.getMaxSurveyId();
		
		for(int i=1; i<surveyInfoList.size(); i++) {
			RegistSurveyDTO item = surveyInfoList.get(i);
			
			item.setQueOrder(i);
			item.setSurveyId(surveyId);
			
			surveyService.insQueInfo(item);
			
			List<String> selContentArr = item.getSelContentArr();
			for(int j = 0 ; j < selContentArr.size(); j ++ ) {
				RegistSurveyDTO selDto = new RegistSurveyDTO();
				selDto.setSelContent(selContentArr.get(j));
				selDto.setSelType(item.getSelType());
				selDto.setSelNum(j + 1);
				surveyService.insSelInfo(selDto);
			}
		}
		return "success";
	}
	// 조사결과 수정 페이지로 이동
	@RequestMapping(value="/survey/surveyUpdPage.do", method = RequestMethod.GET)
	public String surveyUpdPage(SurveyContentDTO SurveyContentDto, Model model, HttpServletRequest request) throws Exception {
		
		List<QueCategoryVO> categoryList = surveyService.getCategory();
		List<QuestionVO> updSurveyQueInfo = surveyService.getSurveyContent(SurveyContentDto);
		for(QuestionVO item : updSurveyQueInfo) {
		
			String strQueCategory = Integer.toString(item.getCategoryId());
			item.setStrQueCategory(strQueCategory);
		}
		
		RegistSurveyDTO updSurveyInfo = surveyService.getUpdSurveyInfo(SurveyContentDto);
		
		model.addAttribute("updSurveyQueInfo",updSurveyQueInfo);
		model.addAttribute("updSurveyInfo",updSurveyInfo);
		model.addAttribute("categoryList",categoryList);

		
		return "views/survey/surveyUpdPage";
	}
	
	//설문조사 수정버튼 눌렀을 때 (미완)
		@RequestMapping(value="/survey/surveyUpd.do", method = RequestMethod.POST)
		@ResponseBody
		public String surveyUpd(@RequestBody String list, HttpServletRequest request)  throws Exception{
			
			HttpSession session = request.getSession(false);
			String userId = "";
					
			if(session.getAttribute("userId") == null) {
				userId = request.getSession().getId();
			}else {
				userId = session.getAttribute("userId").toString();
			}
			
			Gson gson = new GsonBuilder().serializeNulls().create();

			List<RegistSurveyDTO> surveyInfoList = gson.fromJson(list, new TypeToken<List<RegistSurveyDTO>>(){}.getType());
			
			RegistSurveyDTO registSurveyDto = surveyInfoList.get(0);
			
			int surveyId = registSurveyDto.getSurveyId();
			
			/*surveyService.delSurveyInfo(surveyId);
			surveyService.delSurveyQueInfo(surveyId);
			surveyService.delSurveySelInfo(queId);
			surveyService.insSurveyinfo(registSurveyDto);
			surveyService.insQueInfo(item);
			surveyService.insSelInfo(selDto);*/

			
			
			//이부분 foreach로 수정
			/*for(int i=1; i<surveyInfoList.size(); i++) {
				int queId = Integer.parseInt(surveyInfoList.get(i).getQueId());
				System.out.println("queId:::"+queId);
				surveyService.delSurveySelInfo(queId);
				
				RegistSurveyDTO item = surveyInfoList.get(i);
				
				item.setQueOrder(i);
				item.setSurveyId(surveyId);
				
				surveyService.insQueInfo(item);
				
				List<String> selContentArr = item.getSelContentArr();
				for(int j = 0 ; j < selContentArr.size(); j ++ ) {
					RegistSurveyDTO selDto = new RegistSurveyDTO();
					selDto.setSelContent(selContentArr.get(j));
					selDto.setSelType(item.getSelType());
					selDto.setSelNum(j + 1);
					surveyService.insSelInfo(selDto);
				}
			}*/
			return "success";
		}
}