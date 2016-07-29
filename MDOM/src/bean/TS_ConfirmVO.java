package bean;

import java.sql.Timestamp;

public class TS_ConfirmVO {
	/**
	 * 社員番号
	 */
	private String user_id = null;
	/**
	 * 月次対象年月
	 */
	private String doc_ym = null;
	/**
	 * 確認者
	 */
	private String auth_user = null;
	/**
	 * 書類状態
	 */
	private String trns_status = null;
	/**
	 * 差し戻す理由
	 */
	private String trp_reject_reason = null;
	/**
	 * 依頼実施日
	 */
	private String req_day = null;
	/**
	 * 確認完了日
	 */
	private String cpl_day = null;
	/**
	 * 更新日付
	 */
	private Timestamp upd_dt = null;
	/**
	 *  更新者
	 */
	private String upd_id = null;
	/**
	 * 登録日付
	 */
	private Timestamp trk_dt = null;
	/**
	 * 登録者
	 */
	private String trk_id = null;
	/**
	 * 書類状態
	 */
	private String trns_status_name = null;
	/**
	 * 部署
	 */
	private String user_department = null;
	/**
	 * 職級
	 */
	private String user_rank = null;
	/**
	 * 社員名
	 */
	private String user_name = null;
	/**
	 * 部署名
	 */
	private String user_department_name = null;
	/**
	 * 職級名
	 */
	private String user_rank_name = null;
	/**
	 * 社員名ーラスト・ネーム
	 */
	private String user_last_name = null;
	/**
	 * 社員名ーファースト・ネーム
	 */
	private String user_first_name = null;
	/**
	 * 確認者名ーファースト・ネーム
	 */
	private String auth_user_last_name = null;
	/**
	 * 確認社名ーファースト・ネーム
	 */
	private String auth_user_first_name = null;
	/**
	 * 確認社名
	 */
	private String auth_user_name = null;
	/**
	 * @return the user_id
	 */
	public String getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	/**
	 * @return the doc_ym
	 */
	public String getDoc_ym() {
		return doc_ym;
	}
	/**
	 * @param doc_ym the doc_ym to set
	 */
	public void setDoc_ym(String doc_ym) {
		this.doc_ym = doc_ym;
	}
	/**
	 * @return the auth_user
	 */
	public String getAuth_user() {
		return auth_user;
	}
	/**
	 * @param auth_user the auth_user to set
	 */
	public void setAuth_user(String auth_user) {
		this.auth_user = auth_user;
	}
	/**
	 * @return the trns_status
	 */
	public String getTrns_status() {
		return trns_status;
	}
	/**
	 * @param trns_status the trns_status to set
	 */
	public void setTrns_status(String trns_status) {
		this.trns_status = trns_status;
	}
	/**
	 * @return the trp_reject_reason
	 */
	public String getTrp_reject_reason() {
		return trp_reject_reason;
	}
	/**
	 * @param trp_reject_reason the trp_reject_reason to set
	 */
	public void setTrp_reject_reason(String trp_reject_reason) {
		this.trp_reject_reason = trp_reject_reason;
	}
	/**
	 * @return the req_day
	 */
	public String getReq_day() {
		return req_day;
	}
	/**
	 * @param req_day the req_day to set
	 */
	public void setReq_day(String req_day) {
		this.req_day = req_day;
	}
	/**
	 * @return the cpl_day
	 */
	public String getCpl_day() {
		return cpl_day;
	}
	/**
	 * @param cpl_day the cpl_day to set
	 */
	public void setCpl_day(String cpl_day) {
		this.cpl_day = cpl_day;
	}
	/**
	 * @return the upd_dt
	 */
	public Timestamp getUpd_dt() {
		return upd_dt;
	}
	/**
	 * @param upd_dt the upd_dt to set
	 */
	public void setUpd_dt(Timestamp upd_dt) {
		this.upd_dt = upd_dt;
	}
	/**
	 * @return the upd_id
	 */
	public String getUpd_id() {
		return upd_id;
	}
	/**
	 * @param upd_id the upd_id to set
	 */
	public void setUpd_id(String upd_id) {
		this.upd_id = upd_id;
	}
	/**
	 * @return the trk_dt
	 */
	public Timestamp getTrk_dt() {
		return trk_dt;
	}
	/**
	 * @param trk_dt the trk_dt to set
	 */
	public void setTrk_dt(Timestamp trk_dt) {
		this.trk_dt = trk_dt;
	}
	/**
	 * @return the trk_id
	 */
	public String getTrk_id() {
		return trk_id;
	}
	/**
	 * @param trk_id the trk_id to set
	 */
	public void setTrk_id(String trk_id) {
		this.trk_id = trk_id;
	}
	/**
	 * @return the trns_status_name
	 */
	public String getTrns_status_name() {
		return trns_status_name;
	}
	/**
	 * @param trns_status_name the trns_status_name to set
	 */
	public void setTrns_status_name(String trns_status_name) {
		this.trns_status_name = trns_status_name;
	}
	/**
	 * @return the user_department
	 */
	public String getUser_department() {
		return user_department;
	}
	/**
	 * @param user_department the user_department to set
	 */
	public void setUser_department(String user_department) {
		this.user_department = user_department;
	}
	/**
	 * @return the user_rank
	 */
	public String getUser_rank() {
		return user_rank;
	}
	/**
	 * @param user_rank the user_rank to set
	 */
	public void setUser_rank(String user_rank) {
		this.user_rank = user_rank;
	}
	/**
	 * @return the user_name
	 */
	public String getUser_name() {
		return user_name;
	}
	/**
	 * @param user_name the user_name to set
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	/**
	 * @return the user_department_name
	 */
	public String getUser_department_name() {
		return user_department_name;
	}
	/**
	 * @param user_department_name the user_department_name to set
	 */
	public void setUser_department_name(String user_department_name) {
		this.user_department_name = user_department_name;
	}
	/**
	 * @return the user_rank_name
	 */
	public String getUser_rank_name() {
		return user_rank_name;
	}
	/**
	 * @param user_rank_name the user_rank_name to set
	 */
	public void setUser_rank_name(String user_rank_name) {
		this.user_rank_name = user_rank_name;
	}
	/**
	 * @return the user_last_name
	 */
	public String getUser_last_name() {
		return user_last_name;
	}
	/**
	 * @param user_last_name the user_last_name to set
	 */
	public void setUser_last_name(String user_last_name) {
		this.user_last_name = user_last_name;
	}
	/**
	 * @return the user_first_name
	 */
	public String getUser_first_name() {
		return user_first_name;
	}
	/**
	 * @param user_first_name the user_first_name to set
	 */
	public void setUser_first_name(String user_first_name) {
		this.user_first_name = user_first_name;
	}
	/**
	 * @return the auth_user_last_name
	 */
	public String getAuth_user_last_name() {
		return auth_user_last_name;
	}
	/**
	 * @param auth_user_last_name the auth_user_last_name to set
	 */
	public void setAuth_user_last_name(String auth_user_last_name) {
		this.auth_user_last_name = auth_user_last_name;
	}
	/**
	 * @return the auth_user_first_name
	 */
	public String getAuth_user_first_name() {
		return auth_user_first_name;
	}
	/**
	 * @param auth_user_first_name the auth_user_first_name to set
	 */
	public void setAuth_user_first_name(String auth_user_first_name) {
		this.auth_user_first_name = auth_user_first_name;
	}
	/**
	 * @return the auth_user_name
	 */
	public String getAuth_user_name() {
		return auth_user_name;
	}
	/**
	 * @param auth_user_name the auth_user_name to set
	 */
	public void setAuth_user_name(String auth_user_name) {
		this.auth_user_name = auth_user_name;
	}
	
}
