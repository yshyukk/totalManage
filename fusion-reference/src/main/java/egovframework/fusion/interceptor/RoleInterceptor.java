package egovframework.fusion.interceptor;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

import egovframework.fusion.totalManagement.service.MenuService;
import egovframework.fusion.totalManagement.vo.MenuVO;
import egovframework.fusion.user.service.UserService;

public class RoleInterceptor extends WebContentInterceptor{
	@Autowired
	UserService userService;
	
	@Autowired
	MenuService menuService;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws ServletException {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int params = Integer.parseInt(request.getParameter("menuId"));
		String aParam = request.getParameter("accessRole");
    	System.out.println("preRun");

		HttpSession session = request.getSession(false);
		
		Integer userId =  (Integer) session.getAttribute("userId");

		int userRole = 0;
		if(userId == null) {
			userRole =4;
		} else {
			userRole = userService.getUserRole(userId);
		}	
		
		MenuVO menuVo = new MenuVO();
		menuVo.setMenuId(params);		
		
		int menuAccess = menuService.getUserAuth(menuVo);
		
		if(menuAccess >= userRole) {
			return true;
		} else {
			try {
				response.sendRedirect("/mainPage.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
		}		
	}
	
}
