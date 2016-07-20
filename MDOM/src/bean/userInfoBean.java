package bean;

import java.sql.Timestamp;

public class userInfoBean {
	private String USER_ID;
	private String USER_PASSWORD;
	private String USER_CCFNAME;
	private String USER_CCLNAME;
	private String USER_KATAFNAME;
	private String USER_KATALNAME;
	private String USER_PHONE_JPN;
	private String USER_DEPARTMENT;
	private String USER_RANK;
	private String AUTH_FLG;
	private String AUTH_LVL;
	private String USER_EMAIL;
	private String WORK_AREA;
	private String PROJECT_NAME;
	private String USER_PHONE_ETC;
	private String VISA_DAY;
	private Timestamp UPD_DT;
	private String UPD_ID;
	private Timestamp TRK_DT;
	private String ID;
	
	

	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getUSER_PASSWORD() {
		return USER_PASSWORD;
	}
	public void setUSER_PASSWORD(String uSER_PASSWORD) {
		USER_PASSWORD = uSER_PASSWORD;
	}
	public String getUSER_CCFNAME() {
		return USER_CCFNAME;
	}
	public void setUSER_CCFNAME(String uSER_CCFNAME) {
		USER_CCFNAME = uSER_CCFNAME;
	}
	public String getUSER_CCLNAME() {
		return USER_CCLNAME;
	}
	public void setUSER_CCLNAME(String uSER_CCLNAME) {
		USER_CCLNAME = uSER_CCLNAME;
	}
	public String getUSER_KATAFNAME() {
		return USER_KATAFNAME;
	}
	public void setUSER_KATAFNAME(String uSER_KATAFNAME) {
		USER_KATAFNAME = uSER_KATAFNAME;
	}
	public String getUSER_KATALNAME() {
		return USER_KATALNAME;
	}
	public void setUSER_KATALNAME(String uSER_KATALNAME) {
		USER_KATALNAME = uSER_KATALNAME;
	}
	public String getUSER_PHONE_JPN() {
		return USER_PHONE_JPN;
	}
	public void setUSER_PHONE_JPN(String uSER_PHONE_JPN) {
		USER_PHONE_JPN = uSER_PHONE_JPN;
	}
	public String getUSER_DEPARTMENT() {
		return USER_DEPARTMENT;
	}
	public void setUSER_DEPARTMENT(String uSER_DEPARTMENT) {
		USER_DEPARTMENT = uSER_DEPARTMENT;
	}
	public String getUSER_RANK() {
		return USER_RANK;
	}
	public void setUSER_RANK(String uSER_RANK) {
		USER_RANK = uSER_RANK;
	}
	public String getAUTH_FLG() {
		return AUTH_FLG;
	}
	public void setAUTH_FLG(String aUTH_FLG) {
		AUTH_FLG = aUTH_FLG;
	}
	public String getAUTH_LVL() {
		return AUTH_LVL;
	}
	public void setAUTH_LVL(String aUTH_LVL) {
		AUTH_LVL = aUTH_LVL;
	}
	public String getUSER_EMAIL() {
		return USER_EMAIL;
	}
	public void setUSER_EMAIL(String uSER_EMAIL) {
		USER_EMAIL = uSER_EMAIL;
	}
	public String getWORK_AREA() {
		return WORK_AREA;
	}
	public void setWORK_AREA(String wORK_AREA) {
		WORK_AREA = wORK_AREA;
	}
	public String getPROJECT_NAME() {
		return PROJECT_NAME;
	}
	public void setPROJECT_NAME(String pROJECT_NAME) {
		PROJECT_NAME = pROJECT_NAME;
	}
	public String getUSER_PHONE_ETC() {
		return USER_PHONE_ETC;
	}
	public void setUSER_PHONE_ETC(String uSER_PHONE_ETC) {
		USER_PHONE_ETC = uSER_PHONE_ETC;
	}
	public String getVISA_DAY() {
		return VISA_DAY;
	}
	public void setVISA_DAY(String vISA_DAY) {
		VISA_DAY = vISA_DAY;
	}
	public Timestamp getUPD_DT() {
		return UPD_DT;
	}
	public void setUPD_DT(Timestamp uPD_DT) {
		UPD_DT = uPD_DT;
	}
	public String getUPD_ID() {
		return UPD_ID;
	}
	public void setUPD_ID(String uPD_ID) {
		UPD_ID = uPD_ID;
	}
	public Timestamp getTRK_DT() {
		return TRK_DT;
	}
	public void setTRK_DT(Timestamp tRK_DT) {
		TRK_DT = tRK_DT;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	
	@Override
	public String toString() {
		return "userInfobean [USER_ID=" + USER_ID + ", USER_PASSWORD=" + USER_PASSWORD + ", USER_CCFNAME="
				+ USER_CCFNAME + ", USER_CCLNAME=" + USER_CCLNAME + ", USER_KATAFNAME=" + USER_KATAFNAME
				+ ", USER_KATALNAME=" + USER_KATALNAME + ", USER_PHONE_JPN=" + USER_PHONE_JPN + ", USER_DEPARTMENT="
				+ USER_DEPARTMENT + ", USER_RANK=" + USER_RANK + ", AUTH_FLG=" + AUTH_FLG + ", AUTH_LVL=" + AUTH_LVL
				+ ", USER_EMAIL=" + USER_EMAIL + ", WORK_AREA=" + WORK_AREA + ", PROJECT_NAME=" + PROJECT_NAME
				+ ", USER_PHONE_ETC=" + USER_PHONE_ETC + ", VISA_DAY=" + VISA_DAY + ", UPD_DT=" + UPD_DT + ", UPD_ID="
				+ UPD_ID + ", TRK_DT=" + TRK_DT + ", ID=" + ID + "]";
	}
}
