package action.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import bean.US_InfoVO;
import dao.MDOM0102;

public class MDOM0101 {
	private String userId;
	private String userPassword;
	private String loginChk;
		
	private String user_id;
	private String user_name;
	private String user_rank;
	private String user_department;
	private String auth_flg;
	private String auth_lvl;
	
	private String checkFlag;
	
	US_InfoVO us_InfoVO = new US_InfoVO();
	MDOM0102 logindao = new MDOM0102();
	List<US_InfoVO> userInfoList = new ArrayList<US_InfoVO>();
	ActionContext context = ActionContext.getContext();
	Map<String, Object> session = (Map<String, Object>) context.getSession();
		
	public String execute() throws Exception{
		
		try{

			loginChk = logindao.loginPass(this.userId, this.userPassword);

			if(loginChk.equals("OK")) {
				
				userInfoList = logindao.getUserInfo(this.userId);
				
				us_InfoVO = userInfoList.get(0);
				
				user_id = us_InfoVO.getUser_id();
				user_name = us_InfoVO.getUser_ccfname() + us_InfoVO.getUser_cclname();
				user_rank = us_InfoVO.getUser_rank();
				user_department = us_InfoVO.getUser_department();
				auth_flg = us_InfoVO.getAuth_flg();
				auth_lvl = us_InfoVO.getAuth_lvl();

				session.put("s_user_id", user_id);
				session.put("s_user_name", user_name);
				session.put("s_user_rank_cd", user_rank);
				session.put("s_user_rank_name", "직급명");
				session.put("s_user_dept_cd", user_department);
				session.put("s_user_dept_name", "부서명");
				session.put("s_user_auth_flg", auth_flg);
				session.put("s_user_auth_lvl", auth_lvl);
				context.setSession(session);

			}
			
		}catch(Exception e) {
			checkFlag = "0";
			return "FAIL";
		}
		return "SUCCESS";
		
	}
	
	public String getCheckFlag() {
		return checkFlag;
	}

	public void setCheckFlag(String checkFlag) {
		this.checkFlag = checkFlag;
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
