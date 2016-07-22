package action.holiday;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import bean.US_InfoVO;
import dao.MDOM0101_DAO;
import dao.MDOM0402_DAO;

public class MDOM0401 {

	private String user_id;
	
	private String user_field;
	private String user_pj;
	private String user_jpnum;
	private String user_etcnum;
	private String user_visa;
	
	private String year;
	private String month;
	private String day;
	private String nowDate;
	
	List<US_InfoVO> userInfoList = new ArrayList<US_InfoVO>();
	US_InfoVO us_InfoVO = new US_InfoVO();
	MDOM0101_DAO logindao = new MDOM0101_DAO();
	
	ActionContext context = ActionContext.getContext();
	Map<String, Object> session = (Map<String, Object>) context.getSession();

	
	public String execute() throws Exception {
		
		try {
			user_id = (String)session.get("s_user_id");
			
			userInfoList = logindao.getUserInfo(this.user_id);
			
			us_InfoVO = userInfoList.get(0);
			
			user_field = us_InfoVO.getWork_area();
			user_pj = us_InfoVO.getProject_name();
			user_jpnum = us_InfoVO.getUser_phone_jpn();
			user_etcnum = us_InfoVO.getUser_phone_etc();
			user_visa = us_InfoVO.getVisa_day();
			
			Calendar calendar = new GregorianCalendar(Locale.JAPAN);
			year = String.valueOf(calendar.get(Calendar.YEAR));
			month = "0" + String.valueOf(calendar.get(Calendar.MONTH)+1);
			day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
			
			if(day.length() == 1) {
				day = "0" + day;
			}

			nowDate = year + month + day;
			
		} catch (Exception e) {
			return "FAIL";

		}
		return "SUCCESS";
	}


	public String getNowDate() {
		return nowDate;
	}


	public void setNowDate(String nowDate) {
		this.nowDate = nowDate;
	}


	public String getUser_field() {
		return user_field;
	}


	public void setUser_field(String user_field) {
		this.user_field = user_field;
	}


	public String getUser_pj() {
		return user_pj;
	}


	public void setUser_pj(String user_pj) {
		this.user_pj = user_pj;
	}


	public String getUser_jpnum() {
		return user_jpnum;
	}


	public void setUser_jpnum(String user_jpnum) {
		this.user_jpnum = user_jpnum;
	}


	public String getUser_etcnum() {
		return user_etcnum;
	}


	public void setUser_etcnum(String user_etcnum) {
		this.user_etcnum = user_etcnum;
	}


	public String getUser_visa() {
		return user_visa;
	}


	public void setUser_visa(String user_visa) {
		this.user_visa = user_visa;
	}
}
