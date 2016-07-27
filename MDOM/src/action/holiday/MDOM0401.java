package action.holiday;

import bean.HD_InfoVO;
import bean.US_InfoVO;
import com.opensymphony.xwork2.ActionContext;
import dao.MDOM0101_DAO;
import dao.MDOM0402_DAO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
	private String hld_flag;
	private String hldCategory;
	private String hldItem;
	private String hld_mng_no;
	private String hldReason;
	private String hldStart;
	private String hldEnd;
	List<US_InfoVO> userInfoList = new ArrayList();
	US_InfoVO us_InfoVO = new US_InfoVO();
	MDOM0101_DAO logindao = new MDOM0101_DAO();
	List<HD_InfoVO> hldEditList = new ArrayList();
	HD_InfoVO hd_infovo = new HD_InfoVO();
	MDOM0402_DAO mdom0402_dao = new MDOM0402_DAO();
	ActionContext context = ActionContext.getContext();
	Map<String, Object> session = this.context.getSession();

	public String execute() throws Exception {
		try {
			this.user_id = ((String) this.session.get("s_user_id"));

			this.userInfoList = this.logindao.getUserInfo(this.user_id);

			this.us_InfoVO = ((US_InfoVO) this.userInfoList.get(0));

			this.user_field = this.us_InfoVO.getWork_area();
			this.user_pj = this.us_InfoVO.getProject_name();
			this.user_jpnum = this.us_InfoVO.getUser_phone_jpn();
			this.user_etcnum = this.us_InfoVO.getUser_phone_etc();
			this.user_visa = this.us_InfoVO.getVisa_day();

			Calendar calendar = new GregorianCalendar(Locale.JAPAN);
			this.year = String.valueOf(calendar.get(1));
			this.month = ("0" + String.valueOf(calendar.get(2) + 1));
			this.day = String.valueOf(calendar.get(5));
			if (this.day.length() == 1) {
				this.day = ("0" + this.day);
			}
			this.nowDate = (this.year + this.month + this.day);
		} catch (Exception e) {
			return "FAIL";
		}
		return "SUCCESS";
	}

	public String intoHLDEdit() {
		try {
			this.user_id = ((String) this.session.get("s_user_id"));

			this.hldEditList = this.mdom0402_dao.getHldEditList(this.user_id, this.hld_mng_no);

			this.hd_infovo = ((HD_InfoVO) this.hldEditList.get(0));

			this.hldCategory = this.hd_infovo.getHld_kbn_category();
			this.hldItem = this.hd_infovo.getHld_kbn_item();

			this.hldReason = this.hd_infovo.getHld_rsn();
			this.hldStart = this.hd_infovo.getHld_start();
			this.hldEnd = this.hd_infovo.getHld_end();
			this.user_field = this.hd_infovo.getHld_work_area();
			this.user_pj = this.hd_infovo.getHld_project_name();
			this.user_jpnum = this.hd_infovo.getHld_phone_jpn();
			this.user_etcnum = this.hd_infovo.getHld_phone_etc();
			this.user_visa = this.hd_infovo.getVisa_day();

			Calendar calendar = new GregorianCalendar(Locale.JAPAN);
			this.year = String.valueOf(calendar.get(1));
			this.month = ("0" + String.valueOf(calendar.get(2) + 1));
			this.day = String.valueOf(calendar.get(5));
			if (this.day.length() == 1) {
				this.day = ("0" + this.day);
			}
			this.nowDate = (this.year + this.month + this.day);
		} catch (Exception e) {
			return "FAIL";
		}
		return "SUCCESS";
	}

	public String getHldCategory() {
		return this.hldCategory;
	}

	public void setHldCategory(String hldCategory) {
		this.hldCategory = hldCategory;
	}

	public String getHldItem() {
		return this.hldItem;
	}

	public void setHldItem(String hldItem) {
		this.hldItem = hldItem;
	}

	public String getHldReason() {
		return this.hldReason;
	}

	public void setHldReason(String hldReason) {
		this.hldReason = hldReason;
	}

	public String getHldStart() {
		return this.hldStart;
	}

	public void setHldStart(String hldStart) {
		this.hldStart = hldStart;
	}

	public String getHldEnd() {
		return this.hldEnd;
	}

	public void setHldEnd(String hldEnd) {
		this.hldEnd = hldEnd;
	}

	public String getHld_flag() {
		return this.hld_flag;
	}

	public void setHld_flag(String hld_flag) {
		this.hld_flag = hld_flag;
	}

	public String getHld_mng_no() {
		return this.hld_mng_no;
	}

	public void setHld_mng_no(String hld_mng_no) {
		this.hld_mng_no = hld_mng_no;
	}

	public String getNowDate() {
		return this.nowDate;
	}

	public void setNowDate(String nowDate) {
		this.nowDate = nowDate;
	}

	public String getUser_field() {
		return this.user_field;
	}

	public void setUser_field(String user_field) {
		this.user_field = user_field;
	}

	public String getUser_pj() {
		return this.user_pj;
	}

	public void setUser_pj(String user_pj) {
		this.user_pj = user_pj;
	}

	public String getUser_jpnum() {
		return this.user_jpnum;
	}

	public void setUser_jpnum(String user_jpnum) {
		this.user_jpnum = user_jpnum;
	}

	public String getUser_etcnum() {
		return this.user_etcnum;
	}

	public void setUser_etcnum(String user_etcnum) {
		this.user_etcnum = user_etcnum;
	}

	public String getUser_visa() {
		return this.user_visa;
	}

	public void setUser_visa(String user_visa) {
		this.user_visa = user_visa;
	}
}
