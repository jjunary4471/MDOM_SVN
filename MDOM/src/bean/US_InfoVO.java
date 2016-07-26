package bean;

public class US_InfoVO {
	
	private String user_id = null; 			// 社員番号
	private String user_password = null;	// パスワード
	private String user_ccfname = null;		// 漢字姓
	private String user_cclname = null;		// 漢字名
	private String user_katafname = null;	// カタカナ姓
	private String user_katalname = null;	// カタカナ名
	private String user_phone_jpn = null;	// 電話番号
	private String user_department = null;	// 部署
	private String user_rank = null;		// 職級
	private String auth_flg = null;			// 権限有無フラグ
	private String auth_lvl = null;			// 権限レベル
	private String user_email = null;		// メール
	private String work_area = null;		// 現場名
	private String project_name = null;		// プロジェクト名
	private String user_phone_etc = null;	// 緊急連絡先日本外
	private String visa_day = null;			// ビザ有効期間
	private String upd_dt = null;			// 更新日付
	private String upd_id = null;			// 更新者
	private String trk_dt = null;			// 登録日付
	private String trk_id = null;			// 登録者
	
	private String user_department_name = null;	// 部署
	private String user_rank_name = null;		// 職級
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_ccfname() {
		return user_ccfname;
	}
	public void setUser_ccfname(String user_ccfname) {
		this.user_ccfname = user_ccfname;
	}
	public String getUser_cclname() {
		return user_cclname;
	}
	public void setUser_cclname(String user_cclname) {
		this.user_cclname = user_cclname;
	}
	public String getUser_katafname() {
		return user_katafname;
	}
	public void setUser_katafname(String user_katafname) {
		this.user_katafname = user_katafname;
	}
	public String getUser_katalname() {
		return user_katalname;
	}
	public void setUser_katalname(String user_katalname) {
		this.user_katalname = user_katalname;
	}
	public String getUser_phone_jpn() {
		return user_phone_jpn;
	}
	public void setUser_phone_jpn(String user_phone_jpn) {
		this.user_phone_jpn = user_phone_jpn;
	}
	public String getUser_department() {
		return user_department;
	}
	public void setUser_department(String user_department) {
		this.user_department = user_department;
	}
	public String getUser_rank() {
		return user_rank;
	}
	public void setUser_rank(String user_rank) {
		this.user_rank = user_rank;
	}
	public String getAuth_flg() {
		return auth_flg;
	}
	public void setAuth_flg(String auth_flg) {
		this.auth_flg = auth_flg;
	}
	public String getAuth_lvl() {
		return auth_lvl;
	}
	public void setAuth_lvl(String auth_lvl) {
		this.auth_lvl = auth_lvl;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getWork_area() {
		return work_area;
	}
	public void setWork_area(String work_area) {
		this.work_area = work_area;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getUser_phone_etc() {
		return user_phone_etc;
	}
	public void setUser_phone_etc(String user_phone_etc) {
		this.user_phone_etc = user_phone_etc;
	}
	public String getVisa_day() {
		return visa_day;
	}
	public void setVisa_day(String visa_day) {
		this.visa_day = visa_day;
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
	public String getUser_department_name() {
		return user_department_name;
	}
	public void setUser_department_name(String user_department_name) {
		this.user_department_name = user_department_name;
	}
	public String getUser_rank_name() {
		return user_rank_name;
	}
	public void setUser_rank_name(String user_rank_name) {
		this.user_rank_name = user_rank_name;
	}
	
	@Override
	public String toString() {
		return "US_InfoVO [user_id=" + user_id + ", user_password=" + user_password + ", user_ccfname=" + user_ccfname
				+ ", user_cclname=" + user_cclname + ", user_katafname=" + user_katafname + ", user_katalname="
				+ user_katalname + ", user_phone_jpn=" + user_phone_jpn + ", user_department=" + user_department
				+ ", user_rank=" + user_rank + ", auth_flg=" + auth_flg + ", auth_lvl=" + auth_lvl + ", user_email="
				+ user_email + ", work_area=" + work_area + ", project_name=" + project_name + ", user_phone_etc="
				+ user_phone_etc + ", visa_day=" + visa_day + ", upd_dt=" + upd_dt + ", upd_id=" + upd_id + ", trk_dt="
				+ trk_dt + ", trk_id=" + trk_id + ", user_department_name=" + user_department_name + ", user_rank_name="
				+ user_rank_name + "]";
	}
	
	
}
