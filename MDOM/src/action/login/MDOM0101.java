package action.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import bean.CD_InfoVO;
import bean.US_InfoVO;
import common.StringUtility;
import dao.MDOM0101_DAO;

public class MDOM0101 {
	private String userId;
	private String userPassword;

	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_rank;
	private String user_rank_name;
	private String user_department;
	private String user_department_name;
	private String auth_flg;
	private String auth_lvl;
	
	private String checkFlag;
	
	US_InfoVO us_InfoVO = new US_InfoVO();
	MDOM0101_DAO logindao = new MDOM0101_DAO();
	List<US_InfoVO> userInfoList = new ArrayList<US_InfoVO>();
	List<CD_InfoVO> userCodeInfo = new ArrayList<CD_InfoVO>();
	ActionContext context = ActionContext.getContext();
	Map<String, Object> session = (Map<String, Object>) context.getSession();
		
	public String execute() throws Exception{
		
		try{

			userInfoList = logindao.getUserInfo(this.userId);
						
			user_pw = userInfoList.get(0).getUser_password();
			
			
			if(StringUtility.checkEqual(user_pw,
					StringUtility.getSHA256(this.userPassword))) {
				
				us_InfoVO = userInfoList.get(0);
				
				user_id = us_InfoVO.getUser_id();
				user_name = us_InfoVO.getUser_ccfname() + us_InfoVO.getUser_cclname();
				user_rank = us_InfoVO.getUser_rank();
				user_rank_name = us_InfoVO.getUser_rank_name();
				user_department = us_InfoVO.getUser_department();
				user_department_name = us_InfoVO.getUser_department_name();
				auth_flg = us_InfoVO.getAuth_flg();
				auth_lvl = us_InfoVO.getAuth_lvl();
				
				
				session.put("s_user_id", user_id);
				session.put("s_user_name", user_name);
				session.put("s_user_rank_cd", user_rank);
				session.put("s_user_rank_name", user_rank_name);
				session.put("s_user_dept_cd", user_department);
				session.put("s_user_dept_name", user_department_name);
				session.put("s_user_auth_flg", auth_flg);
				session.put("s_user_auth_lvl", auth_lvl);
				context.setSession(session);

			}else {
				checkFlag = "0";
				return "FAIL";
			}
			
		}catch(Exception e) {
			checkFlag = "0";
			return "FAIL";
		}
		return "SUCCESS";
		
	}
	
	public String logoutAction(){

		session.clear();
		context.setSession(session);
		
		return "success";
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
