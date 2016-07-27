package action.holiday;

import com.opensymphony.xwork2.ActionContext;
import dao.MDOM0402_DAO;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;

public class MDOM0402 {
	private String user_id;
	private String user_name;
	private String hld_mng_no;
	private String mk_day;
	private String bigKubun;
	private String smallKubun;
	private String holidayReason;
	private String holidayStart;
	private String holidayEnd;
	private String holidayField;
	private String holidayPjname;
	private String holidayJpnum;
	private String holidayEtcnum;
	private String holidayVisa;
	private String holidayDocStatus;
	private String trk_dt;
	private String trk_id;
	private String upd_dt;
	private String upd_id;
	private String year;
	private String month;
	private String day;
	private int maxDocNum;
	private String maxDocNumStr;
	private String setUserInfoChk;
	private String typeCheck;
	private String editDocNum;
	ActionContext context = ActionContext.getContext();
	Map<String, Object> session = this.context.getSession();
	MDOM0402_DAO mdom0402_dao = new MDOM0402_DAO();
	String getHLDInfoChk;
	String editHLDInfoChk;

	public String execute() throws Exception {
		try {
			
			// 新規作成の場合
			if (this.typeCheck.equals("0")) {
				this.user_id = ((String) this.session.get("s_user_id"));
				this.user_name = ((String) this.session.get("s_user_name"));

				this.maxDocNum = this.mdom0402_dao.getDocNum(this.user_id);

				this.maxDocNum += 1;

				this.maxDocNumStr = Integer.toString(this.maxDocNum);
				if (this.maxDocNumStr.length() == 1) {
					this.hld_mng_no = ("0000000" + Integer.toString(this.maxDocNum));
				} else if (this.maxDocNumStr.length() == 2) {
					this.hld_mng_no = ("000000" + Integer.toString(this.maxDocNum));
				} else if (this.maxDocNumStr.length() == 3) {
					this.hld_mng_no = ("00000" + Integer.toString(this.maxDocNum));
				} else if (this.maxDocNumStr.length() == 4) {
					this.hld_mng_no = ("0000" + Integer.toString(this.maxDocNum));
				} else if (this.maxDocNumStr.length() == 5) {
					this.hld_mng_no = ("000" + Integer.toString(this.maxDocNum));
				} else if (this.maxDocNumStr.length() == 6) {
					this.hld_mng_no = ("00" + Integer.toString(this.maxDocNum));
				} else if (this.maxDocNumStr.length() == 7) {
					this.hld_mng_no = ("0" + Integer.toString(this.maxDocNum));
				}
				if (this.maxDocNumStr.length() == 8) {
					this.hld_mng_no = Integer.toString(this.maxDocNum);
				}

				this.holidayDocStatus = "1";

				Calendar calendar = new GregorianCalendar(Locale.JAPAN);
				this.year = String.valueOf(calendar.get(1));
				this.month = ("0" + String.valueOf(calendar.get(2) + 1));
				this.day = String.valueOf(calendar.get(5));
				if (this.day.length() == 1) {
					this.day = ("0" + this.day);
				}
				this.trk_dt = (this.year + this.month + this.day);
				this.mk_day = this.trk_dt;
				this.trk_id = this.user_id;

				this.getHLDInfoChk = this.mdom0402_dao.getHLDInfo(this.user_id, this.hld_mng_no, this.mk_day,
						this.bigKubun, this.smallKubun, this.holidayReason, this.holidayStart, this.holidayField,
						this.holidayEnd, this.holidayPjname, this.holidayJpnum, this.holidayEtcnum, this.holidayVisa,
						this.holidayDocStatus, this.trk_dt, this.trk_id);

				this.setUserInfoChk = this.mdom0402_dao.setUserInfo(this.user_id, this.holidayJpnum, this.holidayField,
						this.holidayPjname, this.holidayEtcnum, this.holidayVisa);
			} else {
				// 修正の場合
				System.out.println(editDocNum);
				
				this.user_id = ((String) this.session.get("s_user_id"));
				this.user_name = ((String) this.session.get("s_user_name"));
				
				if (this.editDocNum.length() == 1) {
					this.editDocNum = ("0000000" + this.editDocNum);
				} else if (this.editDocNum.length() == 2) {
					this.editDocNum = ("000000" + this.editDocNum);
				} else if (this.editDocNum.length() == 3) {
					this.editDocNum = ("00000" + this.editDocNum);
				} else if (this.editDocNum.length() == 4) {
					this.editDocNum = ("0000" + this.editDocNum);
				} else if (this.editDocNum.length() == 5) {
					this.editDocNum = ("000" + this.editDocNum);
				} else if (this.editDocNum.length() == 6) {
					this.editDocNum = ("00" + this.editDocNum);
				} else if (this.editDocNum.length() == 7) {
					this.editDocNum = ("0" + this.editDocNum);
				}
				
				Calendar calendar = new GregorianCalendar(Locale.JAPAN);
				this.year = String.valueOf(calendar.get(1));
				this.month = ("0" + String.valueOf(calendar.get(2) + 1));
				this.day = String.valueOf(calendar.get(5));
				if (this.day.length() == 1) {
					this.day = ("0" + this.day);
				}
				this.upd_dt = (this.year + this.month + this.day);
				this.upd_id = this.user_id;
				
				this.editHLDInfoChk = this.mdom0402_dao.editHLDInfo(this.user_id, this.editDocNum,
						this.bigKubun, this.smallKubun, this.holidayReason, this.holidayStart, this.holidayField,
						this.holidayEnd, this.holidayPjname, this.holidayJpnum, this.holidayEtcnum, this.holidayVisa,
						this.upd_dt, this.upd_id);
				
				if(this.editHLDInfoChk == "NO") {
					return "FAIL";
				}
				
				this.setUserInfoChk = this.mdom0402_dao.setUserInfo(this.user_id, this.holidayJpnum, this.holidayField,
						this.holidayPjname, this.holidayEtcnum, this.holidayVisa);
				
			}
		} catch (Exception e) {
			return "FAIL";
		}
		return "SUCCESS";
	}

	public String getHld_mng_no() {
		return hld_mng_no;
	}

	public void setHld_mng_no(String hld_mng_no) {
		this.hld_mng_no = hld_mng_no;
	}

	public String getEditDocNum() {
		return editDocNum;
	}

	public void setEditDocNum(String editDocNum) {
		this.editDocNum = editDocNum;
	}

	public String getTypeCheck() {
		return this.typeCheck;
	}

	public void setTypeCheck(String typeCheck) {
		this.typeCheck = typeCheck;
	}

	public String getHolidayField() {
		return this.holidayField;
	}

	public void setHolidayField(String holidayField) {
		this.holidayField = holidayField;
	}

	public String getUser_id() {
		return this.user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getBigKubun() {
		return this.bigKubun;
	}

	public void setBigKubun(String bigKubun) {
		this.bigKubun = bigKubun;
	}

	public String getSmallKubun() {
		return this.smallKubun;
	}

	public void setSmallKubun(String smallKubun) {
		this.smallKubun = smallKubun;
	}

	public String getHolidayReason() {
		return this.holidayReason;
	}

	public void setHolidayReason(String holidayReason) {
		this.holidayReason = holidayReason;
	}

	public String getHolidayStart() {
		return this.holidayStart;
	}

	public void setHolidayStart(String holidayStart) {
		this.holidayStart = holidayStart;
	}

	public String getHolidayEnd() {
		return this.holidayEnd;
	}

	public void setHolidayEnd(String holidayEnd) {
		this.holidayEnd = holidayEnd;
	}

	public String getHolidayPjname() {
		return this.holidayPjname;
	}

	public void setHolidayPjname(String holidayPjname) {
		this.holidayPjname = holidayPjname;
	}

	public String getHolidayJpnum() {
		return this.holidayJpnum;
	}

	public void setHolidayJpnum(String holidayJpnum) {
		this.holidayJpnum = holidayJpnum;
	}

	public String getHolidayEtcnum() {
		return this.holidayEtcnum;
	}

	public void setHolidayEtcnum(String holidayEtcnum) {
		this.holidayEtcnum = holidayEtcnum;
	}

	public String getHolidayVisa() {
		return this.holidayVisa;
	}

	public void setHolidayVisa(String holidayVisa) {
		this.holidayVisa = holidayVisa;
	}
}
