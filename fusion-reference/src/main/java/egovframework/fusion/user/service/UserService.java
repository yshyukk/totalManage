package egovframework.fusion.user.service;

import egovframework.fusion.user.vo.UserVO;

public interface UserService {

	public void insUser(UserVO userVO);
	
	public int getUserId(String inputId);
	
	public UserVO getLoginInfo(UserVO userVO);
	
	public int checkId(String checkId);
	
	public int checkPwd(UserVO userVO);
	
	public int getUserRole(int userId);
	
}