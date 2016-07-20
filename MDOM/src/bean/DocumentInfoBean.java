package bean;

public class DocumentInfoBean {
	private String USER_ID = null;			// 社員番号
	private String DOC_YM = null;			// 月次対象年月
	private String AUTH_USER = null;		// 確認者
	private String TRNS_STATUS = null;		// 書類状態
	private String TRP_REJECT_REASON = null;// 差し戻す理由
	private String REQ_DAY = null;			// 依頼実施日
	private String CPL_DAY = null;			// 確認完了日
	private String UPD_DT = null;			// 更新日付
	private String UPD_ID = null;			// 更新者
	private String TRK_DT = null;			// 登録日付
	private String TRK_ID = null;			// 登録者
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getDOC_YM() {
		return DOC_YM;
	}
	public void setDOC_YM(String dOC_YM) {
		DOC_YM = dOC_YM;
	}
	public String getAUTH_USER() {
		return AUTH_USER;
	}
	public void setAUTH_USER(String aUTH_USER) {
		AUTH_USER = aUTH_USER;
	}
	public String getTRNS_STATUS() {
		return TRNS_STATUS;
	}
	public void setTRNS_STATUS(String tRNS_STATUS) {
		TRNS_STATUS = tRNS_STATUS;
	}
	public String getTRP_REJECT_REASON() {
		return TRP_REJECT_REASON;
	}
	public void setTRP_REJECT_REASON(String tRP_REJECT_REASON) {
		TRP_REJECT_REASON = tRP_REJECT_REASON;
	}
	public String getREQ_DAY() {
		return REQ_DAY;
	}
	public void setREQ_DAY(String rEQ_DAY) {
		REQ_DAY = rEQ_DAY;
	}
	public String getCPL_DAY() {
		return CPL_DAY;
	}
	public void setCPL_DAY(String cPL_DAY) {
		CPL_DAY = cPL_DAY;
	}
	public String getUPD_DT() {
		return UPD_DT;
	}
	public void setUPD_DT(String uPD_DT) {
		UPD_DT = uPD_DT;
	}
	public String getUPD_ID() {
		return UPD_ID;
	}
	public void setUPD_ID(String uPD_ID) {
		UPD_ID = uPD_ID;
	}
	public String getTRK_DT() {
		return TRK_DT;
	}
	public void setTRK_DT(String tRK_DT) {
		TRK_DT = tRK_DT;
	}
	public String getTRK_ID() {
		return TRK_ID;
	}
	public void setTRK_ID(String tRK_ID) {
		TRK_ID = tRK_ID;
	}
	@Override
	public String toString() {
		return "DocumentInfoBean [USER_ID=" + USER_ID + ", DOC_YM=" + DOC_YM + ", AUTH_USER=" + AUTH_USER
				+ ", TRNS_STATUS=" + TRNS_STATUS + ", TRP_REJECT_REASON=" + TRP_REJECT_REASON + ", REQ_DAY=" + REQ_DAY
				+ ", CPL_DAY=" + CPL_DAY + ", UPD_DT=" + UPD_DT + ", UPD_ID=" + UPD_ID + ", TRK_DT=" + TRK_DT
				+ ", TRK_ID=" + TRK_ID + "]";
	}
	
	
}
