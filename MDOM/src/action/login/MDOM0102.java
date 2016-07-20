package action.login;

import java.util.ArrayList;
import java.util.List;

import bean.userInfoBean;
import dao.loginDao;

public class MDOM0102 {
	private String userId;
	private String userPassword;
	userInfoBean userBean = new userInfoBean();
	loginDao logindao = new loginDao();
	List<userInfoBean> userInfoList = new ArrayList<userInfoBean>();
	
	
	public String loginAction() {
		try{
			System.out.println(userId);
			System.out.println(userPassword);
			
			userInfoList = logindao.getUserInfo(this.userId, this.userPassword);
			
			System.out.println(userInfoList);
			
		}catch(Exception e){
			return "FAIL";
		}
		
		return "SUCCESS";

	}
	
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}
