package egovframework.fusion.totalManagement.controller;



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

import egovframework.fusion.board.service.BoardService;
import egovframework.fusion.board.vo.BoardVO;
import egovframework.fusion.imgboard.service.HashTagService;
import egovframework.fusion.imgboard.service.ImgBoardService;
import egovframework.fusion.imgboard.vo.HashTagVO;
import egovframework.fusion.imgboard.vo.ImgBoardVO;
import egovframework.fusion.survey.service.SurveyService;
import egovframework.fusion.totalManagement.dto.TotalSearchDTO;
import egovframework.fusion.totalManagement.service.MenuService;
import egovframework.fusion.totalManagement.vo.MenuVO;

@Controller
public class TotalManagementController {
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	ImgBoardService imgService;
	
	@Autowired
	SurveyService surveyService;
	
	@Autowired
	HashTagService hashTagService;

	@RequestMapping("/mainPage.do")
	public String mainPage() {
		return "common/mainPage.tiles";
	}
	
	@RequestMapping("/failToAuth.do")
	public String failToAuth() {
		return "user/loginForm.tiles";
	}
	//관리자 메뉴관리 페이지
	@RequestMapping(value = "/admin/menuPage.do", method = RequestMethod.GET)
	public String menuPage() throws Exception {
		
		return "admin/menuPage.tiles";
	}
	//메뉴 등록
	@RequestMapping(value="/admin/insMenu.do", method = RequestMethod.POST)
	@ResponseBody
	public String insMenu(@RequestBody String data, HttpServletRequest request)  throws Exception{
		
		HttpSession session = request.getSession(false);
		String userId = "";

		if(session.getAttribute("userId") == null) {
			userId = request.getSession().getId();
		}else {
			userId = session.getAttribute("userId").toString();
		}
		Gson gson = new GsonBuilder().serializeNulls().create();
	
		String jsonString = data;
        
		MenuVO menuVo = gson.fromJson(jsonString, new TypeToken<MenuVO>(){}.getType());
				
		menuService.insMenuInfo(menuVo);
		return "success";
	}
	
	@RequestMapping(value = "/admin/menuList.do", method = RequestMethod.GET)
	public String boardList(Model model) throws Exception {
			
			int userRole = 0;
			/* boardList 출력 */
			List<MenuVO> menuInfoList = menuService.getMenuList(userRole);
			
			
			model.addAttribute("menuInfoList", menuInfoList);
			
		return "admin/menuPage.tiles";
	}
	
	@RequestMapping(value = "/admin/updMenuPage.do", method = RequestMethod.GET)
	public String updMenuPage(MenuVO menuVo, Model model) throws Exception {
			
			/* boardList 출력 */
			MenuVO menuInfo = menuService.getOneMenuInfo(menuVo);
			
			//링크 뿌려줄때 ?뒤에꺼 다 지우고 뿌려주기
			model.addAttribute("menuInfo", menuInfo);
			
		return "views/admin/menuUpdPage";
	}
	
	
	@RequestMapping(value="/admin/updMenu.do", method = RequestMethod.POST)
	@ResponseBody
	public String updMenu(@RequestBody String data, HttpServletRequest request)  throws Exception{
		
		HttpSession session = request.getSession(false);
		String userId = "";

		if(session.getAttribute("userId") == null) {
			userId = request.getSession().getId();
		}else {
			userId = session.getAttribute("userId").toString();
		}
		Gson gson = new GsonBuilder().serializeNulls().create();
	
		String jsonString = data;
        
		MenuVO menuVo = gson.fromJson(jsonString, new TypeToken<MenuVO>(){}.getType());
		
		menuService.updMenuInfo(menuVo);
		return "success";
	}
	
	@RequestMapping(value="/admin/delMenu.do", method = RequestMethod.POST)
	@ResponseBody
	public String delMenu(@RequestBody String data, HttpServletRequest request)  throws Exception{
		
		HttpSession session = request.getSession(false);
		String userId = "";

		if(session.getAttribute("userId") == null) {
			userId = request.getSession().getId();
		}else {
			userId = session.getAttribute("userId").toString();
		}
		Gson gson = new GsonBuilder().serializeNulls().create();
	
		String jsonString = data;
        
		MenuVO menuVo = gson.fromJson(jsonString, new TypeToken<MenuVO>(){}.getType());
		
		menuService.delMenuInfo(menuVo);
		return "success";
	}
	
	@RequestMapping(value = "/admin/totalSerach.do", method = RequestMethod.GET)
	public String totalSerach(TotalSearchDTO totalSearchDto, Model model, HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession(false);
		String userId = "";

		if(session.getAttribute("userId") == null) {
			userId = request.getSession().getId();
		}else {
			userId = (String) session.getAttribute("id");
;
		}
		totalSearchDto.setUserId(userId);
		
		List<Integer> boardNumList = menuService.getBoardNum();
		totalSearchDto.setBoardNum(boardNumList);
		List<Integer> galBoardNumList = menuService.getGalBoardNum();
		totalSearchDto.setGalBoardNum(galBoardNumList);
		
		List<BoardVO> boardList = boardService.getBoardTotalSearch(totalSearchDto);
		List<ImgBoardVO> imgList = imgService.getImgTotalSearch(totalSearchDto);
		List<HashTagVO> hashTagList = hashTagService.getHashTagInfo();

//		List<SurveyVO> surveyList = surveyService.getSurveyTotalSearch(totalSearchDto);dddddddddddddddddddd
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("imgList", imgList);
		model.addAttribute("hashTagList",hashTagList);

//		model.addAttribute("surveyList", surveyList);
		
		System.out.println("===============================");
		System.out.println("===============================");
		for(BoardVO vo : boardList) {
			System.out.println(vo);
		}
		System.out.println("===============================");
		System.out.println("===============================");
		
		return "admin/searchResultPage.tiles";
		

//		
		
//		
//		List<BoardVO> boardSearchResList = menuService.getBoardSearchRes(totalSearchDto);
//		
//		model.addAttribute("boardSearchResList",boardSearchResList);
		
		
		
		
	}

}