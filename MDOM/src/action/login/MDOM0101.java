package action.login;

import bean.CD_InfoVO;
import bean.US_InfoVO;
import com.opensymphony.xwork2.ActionContext;
import common.MDOM_CD;
import common.StringUtility;
import dao.MDOM0101_DAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	List<US_InfoVO> userInfoList = new ArrayList();
	List<CD_InfoVO> userCodeInfo = new ArrayList();
	ActionContext context = ActionContext.getContext();
	MDOM_CD mdomCd = null;
	Map<String, Object> session = this.context.getSession();

	public String execute() throws Exception {
		try {
			this.mdomCd = new MDOM_CD(null);

			this.userInfoList = this.logindao.getUserInfo(this.userId);

			this.user_pw = ((US_InfoVO) this.userInfoList.get(0)).getUser_password();
			if (StringUtility.checkEqual(this.user_pw, StringUtility.getSHA256(this.userPassword))) {
				this.us_InfoVO = ((US_InfoVO) this.userInfoList.get(0));

				this.user_id = this.us_InfoVO.getUser_id();
				this.user_name = (this.us_InfoVO.getUser_ccfname() + this.us_InfoVO.getUser_cclname());
				this.user_rank = this.us_InfoVO.getUser_rank();
				this.user_rank_name = this.mdomCd.getCodeName("003", this.user_rank);
				this.user_department = this.us_InfoVO.getUser_department();
				this.user_department_name = this.mdomCd.getCodeName("002", this.user_department);
				this.auth_flg = this.us_InfoVO.getAuth_flg();
				this.auth_lvl = this.us_InfoVO.getAuth_lvl();

				this.session.put("s_user_id", this.user_id);
				this.session.put("s_user_name", this.user_name);
				this.session.put("s_user_rank_cd", this.user_rank);
				this.session.put("s_user_rank_name", this.user_rank_name);
				this.session.put("s_user_dept_cd", this.user_department);
				this.session.put("s_user_dept_name", this.user_department_name);
				this.session.put("s_user_auth_flg", this.auth_flg);
				this.session.put("s_user_auth_lvl", this.auth_lvl);
				this.session.put("s_allCdMap", this.mdomCd.getAllCdMap());
				this.context.setSession(this.session);
			} else {
				this.checkFlag = "0";
				return "FAIL";
			}
		} catch (Exception e) {
			this.checkFlag = "0";
			return "FAIL";
		}
		return "SUCCESS";
	}

	public String logoutAction() {
		this.session.clear();
		this.context.setSession(this.session);

		return "success";
	}

	public String getCheckFlag() {
		return this.checkFlag;
	}

	public void setCheckFlag(String checkFlag) {
		this.checkFlag = checkFlag;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}
