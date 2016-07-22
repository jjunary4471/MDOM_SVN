package action.holiday;

import org.apache.commons.lang3.SystemUtils;

public class MDOM0402 {
	private String bigKubun;
	private String smallKubun;
	private String holidayReason;
	private String holidayStart;
	private String holidayEnd;
	private String holidayPjname;
	private String holidayJpnum;
	private String holidayEtcnum;
	private String holidayVisa;
	


	public String execute() throws Exception {
		try{
			
			return "SUCCESS";
		}catch(Exception e) {
			return "FAIL";
		}
		
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
