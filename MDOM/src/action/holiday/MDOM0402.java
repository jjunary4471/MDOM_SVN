package action.holiday;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang3.SystemUtils;

import com.opensymphony.xwork2.ActionContext;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import dao.MDOM0402_DAO;

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
	private String trk_dt;	// 시스템 날짜 데이터 타입이 날짜 형식
	private String trk_id;
	
	private String year;
	private String month;
	private String day;
	
	private int maxDocNum;
	private String maxDocNumStr;
	
	ActionContext context = ActionContext.getContext();
	Map<String, Object> session = (Map<String, Object>) context.getSession();
	MDOM0402_DAO mdom0402_dao = new MDOM0402_DAO();
	String getHLDInfoChk;


	public String execute() throws Exception {
		try{
			
			user_id = (String)session.get("s_user_id");
			user_name = (String)session.get("s_user_name");
			
			maxDocNum = mdom0402_dao.getDocNum(this.user_id);
					
			maxDocNum = maxDocNum + 1;
			
			maxDocNumStr = Integer.toString(maxDocNum);
			
			if(maxDocNumStr.length() == 1) {
				hld_mng_no = "0000000" + Integer.toString(maxDocNum); 
			}else if(maxDocNumStr.length() == 2) {
				hld_mng_no = "000000" + Integer.toString(maxDocNum); 
			}else if(maxDocNumStr.length() == 3) {
				hld_mng_no = "00000" + Integer.toString(maxDocNum); 
			}else if(maxDocNumStr.length() == 4) {
				hld_mng_no = "0000" + Integer.toString(maxDocNum); 
			}else if(maxDocNumStr.length() == 5) {
				hld_mng_no = "000" + Integer.toString(maxDocNum); 
			}else if(maxDocNumStr.length() == 6) {
				hld_mng_no = "00" + Integer.toString(maxDocNum); 
			}else if(maxDocNumStr.length() == 7) {
				hld_mng_no = "0" + Integer.toString(maxDocNum); 
			}if(maxDocNumStr.length() == 8) {
				hld_mng_no = Integer.toString(maxDocNum); 
			}
			
			System.out.println(hld_mng_no);
			
			holidayDocStatus = "1";
			
			Calendar calendar = new GregorianCalendar(Locale.JAPAN);
			year = String.valueOf(calendar.get(Calendar.YEAR));
			month = "0" + String.valueOf(calendar.get(Calendar.MONTH)+1);
			day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
			
			if(day.length() == 1) {
				day = "0" + day;
			}
			
			trk_dt = year + month + day;
			mk_day = trk_dt;
			trk_id = user_id;
			
			getHLDInfoChk = mdom0402_dao.getHLDInfo(this.user_id, this.hld_mng_no, this.mk_day, 
						this.bigKubun, this.smallKubun, this.holidayReason, this.holidayStart,
					this.holidayField, this.holidayEnd, this.holidayPjname, this.holidayJpnum, 
					this.holidayEtcnum, this.holidayVisa, this.holidayDocStatus, this.trk_dt, this.trk_id);
			
		
			return "SUCCESS";
		}catch(Exception e) {
			return "FAIL";
		}
		
	}
	
	public String getHolidayField() {
		return holidayField;
	}

	public void setHolidayField(String holidayField) {
		this.holidayField = holidayField;
	}
	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public String getBigKubun() {
		return bigKubun;
	}

	public void setBigKubun(String bigKubun) {
		this.bigKubun = bigKubun;
	}

	public String getSmallKubun() {
		return smallKubun;
	}

	public void setSmallKubun(String smallKubun) {
		this.smallKubun = smallKubun;
	}
	
	public String getHolidayReason() {
		return holidayReason;
	}

	public void setHolidayReason(String holidayReason) {
		this.holidayReason = holidayReason;
	}

	public String getHolidayStart() {
		return holidayStart;
	}

	public void setHolidayStart(String holidayStart) {
		this.holidayStart = holidayStart;
	}

	public String getHolidayEnd() {
		return holidayEnd;
	}

	public void setHolidayEnd(String holidayEnd) {
		this.holidayEnd = holidayEnd;
	}

	public String getHolidayPjname() {
		return holidayPjname;
	}

	public void setHolidayPjname(String holidayPjname) {
		this.holidayPjname = holidayPjname;
	}

	public String getHolidayJpnum() {
		return holidayJpnum;
	}

	public void setHolidayJpnum(String holidayJpnum) {
		this.holidayJpnum = holidayJpnum;
	}

	public String getHolidayEtcnum() {
		return holidayEtcnum;
	}

	public void setHolidayEtcnum(String holidayEtcnum) {
		this.holidayEtcnum = holidayEtcnum;
	}

	public String getHolidayVisa() {
		return holidayVisa;
	}

	public void setHolidayVisa(String holidayVisa) {
		this.holidayVisa = holidayVisa;
	}

}
