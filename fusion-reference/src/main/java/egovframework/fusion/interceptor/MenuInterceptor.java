package egovframework.fusion.interceptor;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

import egovframework.fusion.totalManagement.service.MenuService;
import egovframework.fusion.totalManagement.vo.MenuVO;
import egovframework.fusion.user.service.UserService;


public class MenuInterceptor extends WebContentInterceptor{

	@Autowired
	MenuService menuService;
	
	@Autowired
	UserService userService;
	
	
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
        ModelAndView modelAndView) throws Exception {
    	HttpSession session = request.getSession();
		
		int userRole = 0;
		
		if(session.getAttribute("userId") == null) {
			userRole =4;
		} else {
			int userId = (int) session.getAttribute("userId");
			userRole = userService.getUserRole(userId);
		}
    	List<MenuVO> menuList = menuService.getMenuList(userRole);
		
    	for(MenuVO item : menuList) {
    		
    		int accessRole = item.getAccessRole();
    		
    		String role = "";
    		
    		if(accessRole == 0) {
    			role = "슈퍼 관리자";
    		}else if(accessRole == 1) {
    			role = "일반 관리자";
    		}else if(accessRole == 2) {
    			role = "회원";
    		}else if(accessRole == 3) {
    			role = "비회원";
    		}
    		item.setRole(role);
    	}
    			
    	
		modelAndView.addObject("menuList",menuList);
		modelAndView.addObject("userRole",userRole);
		
		//response.sendRedirect("/mainPage.do");
		// 만약에 GetOutputStram() 어저구 오류가 나면 Interceptor 건드릴것
    }
	
    
    
	

}
