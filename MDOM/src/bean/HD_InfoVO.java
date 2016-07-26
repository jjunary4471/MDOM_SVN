package bean;

import java.sql.Timestamp;

public class HD_InfoVO {
	
	private String user_id = null;			// 社員番号
	private String hld_mng_no = null;		// 休暇申請管理番号
	private String mk_day = null;			// 作成日
	private String hld_kbn_category = null;	// 休暇区分（大分類）
	private String hld_kbn_item = null;		// 休暇区分（小分類）
	private String hld_rsn = null;			// 休暇理由
	private String hld_start = null;		// 休暇期間(開始日)
	private String hld_end = null;			// 休暇期間(終了日)	
	private String hld_phone_jpn = null;	// 電話番号
	private String hld_work_area = null;	// 現場名
	private String hld_project_name = null;	// プロジェクト名
	private String hld_phone_etc = null;	// 緊急連絡先日本外
	private String visa_day = null;			// ビザ有効期間
	private String req_day = null;			// 依頼実施日
	private String cpl_ay = null;			// 確認完了日
	private String auth_user = null;		// 確認者
	private String hld_status = null;		// 書類状態
	private String hld_reject_reason = null;// 差し戻す理由
	private Timestamp upd_dt = null;		// 更新日付
	private String upd_id = null;			// 更新者
	private Timestamp trk_dt = null;		// 登録日付
	private String trk_id = null;			// 登録者
	
	private String kyuka_day = null;
	private String week_day = null;
	private String hld_kbn_category_name = null;// 休暇区分（大分類）
	private String hld_kbn_item_name = null;	// 休暇区分（小分類）
	private String hld_status_name = null;		// 書類状態
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getHld_mng_no() {
		return hld_mng_no;
	}
	public void setHld_mng_no(String hld_mng_no) {
		this.hld_mng_no = hld_mng_no;
	}
	public String getMk_day() {
		return mk_day;
	}
	public void setMk_day(String mk_day) {
		this.mk_day = mk_day;
	}
	public String getHld_kbn_category() {
		return hld_kbn_category;
	}
	public void setHld_kbn_category(String hld_kbn_category) {
		this.hld_kbn_category = hld_kbn_category;
	}
	public String getHld_kbn_item() {
		return hld_kbn_item;
	}
	public void setHld_kbn_item(String hld_kbn_item) {
		this.hld_kbn_item = hld_kbn_item;
	}
	public String getHld_rsn() {
		return hld_rsn;
	}
	public void setHld_rsn(String hld_rsn) {
		this.hld_rsn = hld_rsn;
	}
	public String getHld_start() {
		return hld_start;
	}
	public void setHld_start(String hld_start) {
		this.hld_start = hld_start;
	}
	public String getHld_end() {
		return hld_end;
	}
	public void setHld_end(String hld_end) {
		this.hld_end = hld_end;
	}
	public String getHld_phone_jpn() {
		return hld_phone_jpn;
	}
	public void setHld_phone_jpn(String hld_phone_jpn) {
		this.hld_phone_jpn = hld_phone_jpn;
	}
	public String getHld_work_area() {
		return hld_work_area;
	}
	public void setHld_work_area(String hld_work_area) {
		this.hld_work_area = hld_work_area;
	}
	public String getHld_project_name() {
		return hld_project_name;
	}
	public void setHld_project_name(String hld_project_name) {
		this.hld_project_name = hld_project_name;
	}
	public String getHld_phone_etc() {
		return hld_phone_etc;
	}
	public void setHld_phone_etc(String hld_phone_etc) {
		this.hld_phone_etc = hld_phone_etc;
	}
	public String getVisa_day() {
		return visa_day;
	}
	public void setVisa_day(String visa_day) {
		this.visa_day = visa_day;
	}
	public String getReq_day() {
		return req_day;
	}
	public void setReq_day(String req_day) {
		this.req_day = req_day;
	}
	public String getCpl_ay() {
		return cpl_ay;
	}
	public void setCpl_ay(String cpl_ay) {
		this.cpl_ay = cpl_ay;
	}
	public String getAuth_user() {
		return auth_user;
	}
	public void setAuth_user(String auth_user) {
		this.auth_user = auth_user;
	}
	public String getHld_status() {
		return hld_status;
	}
	public void setHld_status(String hld_status) {
		this.hld_status = hld_status;
	}
	public String getHld_reject_reason() {
		return hld_reject_reason;
	}
	public void setHld_reject_reason(String hld_reject_reason) {
		this.hld_reject_reason = hld_reject_reason;
	}
	public Timestamp getUpd_dt() {
		return upd_dt;
	}
	public void setUpd_dt(Timestamp upd_dt) {
		this.upd_dt = upd_dt;
	}
	public String getUpd_id() {
		return upd_id;
	}
	public void setUpd_id(String upd_id) {
		this.upd_id = upd_id;
	}
	public Timestamp getTrk_dt() {
		return trk_dt;
	}
	public void setTrk_dt(Timestamp trk_dt) {
		this.trk_dt = trk_dt;
	}
	public String getTrk_id() {
		return trk_id;
	}
	public void setTrk_id(String trk_id) {
		this.trk_id = trk_id;
	}
	public String getWeek_day() {
		return week_day;
	}
	public void setWeek_day(String week_day) {
		this.week_day = week_day;
	}
	public String getHld_kbn_category_name() {
		return hld_kbn_category_name;
	}
	public void setHld_kbn_category_name(String hld_kbn_category_name) {
		this.hld_kbn_category_name = hld_kbn_category_name;
	}
	public String getHld_kbn_item_name() {
		return hld_kbn_item_name;
	}
	public void setHld_kbn_item_name(String hld_kbn_item_name) {
		this.hld_kbn_item_name = hld_kbn_item_name;
	}
	public String getHld_status_name() {
		return hld_status_name;
	}
	public void setHld_status_name(String hld_status_name) {
		this.hld_status_name = hld_status_name;
	}
	public String getKyuka_day() {
		return kyuka_day;
	}
	public void setKyuka_day(String kyuka_day) {
		this.kyuka_day = kyuka_day;
	}
	
	
}
