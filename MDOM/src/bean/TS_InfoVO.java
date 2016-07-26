package bean;

public class TS_InfoVO {
	private String user_id = null;			// 社員番号
	private String doc_ym = null;			// 月次対象年月
	private String auth_user = null;		// 確認者
	private String trns_status = null;		// 書類状態
	private String trp_reject_reason = null;// 差し戻す理由
	private String req_day = null;			// 依頼実施日
	private String cpl_day = null;			// 確認完了日
	private String upd_dt = null;			// 更新日付
	private String upd_id = null;			// 更新者
	private String trk_dt = null;			// 登録日付
	private String trk_id = null;			// 登録者

	private String trns_status_name = null;		// 書類状態

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getDoc_ym() {
		return doc_ym;
	}

	public void setDoc_ym(String doc_ym) {
		this.doc_ym = doc_ym;
	}

	public String getAuth_user() {
		return auth_user;
	}

	public void setAuth_user(String auth_user) {
		this.auth_user = auth_user;
	}

	public String getTrns_status() {
		return trns_status;
	}

	public void setTrns_status(String trns_status) {
		this.trns_status = trns_status;
	}

	public String getTrp_reject_reason() {
		return trp_reject_reason;
	}

	public void setTrp_reject_reason(String trp_reject_reason) {
		this.trp_reject_reason = trp_reject_reason;
	}

	public String getReq_day() {
		return req_day;
	}

	public void setReq_day(String req_day) {
		this.req_day = req_day;
	}

	public String getCpl_day() {
		return cpl_day;
	}

	public void setCpl_day(String cpl_day) {
		this.cpl_day = cpl_day;
	}

	public String getUpd_dt() {
		return upd_dt;
	}

	public void setUpd_dt(String upd_dt) {
		this.upd_dt = upd_dt;
	}

	public String getUpd_id() {
		return upd_id;
	}

	public void setUpd_id(String upd_id) {
		this.upd_id = upd_id;
	}

	public String getTrk_dt() {
		return trk_dt;
	}

	public void setTrk_dt(String trk_dt) {
		this.trk_dt = trk_dt;
	}

	public String getTrk_id() {
		return trk_id;
	}

	public void setTrk_id(String trk_id) {
		this.trk_id = trk_id;
	}

	public String getTrns_status_name() {
		return trns_status_name;
	}

	public void setTrns_status_name(String trns_status_name) {
		this.trns_status_name = trns_status_name;
	}
	
	
}
