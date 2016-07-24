package bean;

public class TR_InfoVO {
	
	private String user_id = null; 		// 社員番号
	private String doc_ym = null; 		// 月次対象年月
	private String kinmu_day = null; 	// 勤務日
	private String mesai_no = null; 	// 交通費明細番号
	private String kukan_start = null; 	// 区間開始
	private String kukan_stop = null; 	// 区間到着
	private String round_trip = null; 	// 往復有無
	private String dest_area = null; 	// 行先
	private String trp_shurui = null; 	// 乗物
	private String trp_cost = null; 	// 金額
	private String mae_money = null; 	// 前渡金
	private String upd_dt = null; 		// 更新日付
	private String upd_id = null; 		// 更新者
	private String trk_dt = null; 		// 登録日付
	private String trk_id = null; 		// 登録者
	private String tr_add_form_flag = null;
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
	public String getKinmu_day() {
		return kinmu_day;
	}
	public void setKinmu_day(String kinmu_day) {
		this.kinmu_day = kinmu_day;
	}
	public String getMesai_no() {
		return mesai_no;
	}
	public void setMesai_no(String mesai_no) {
		this.mesai_no = mesai_no;
	}
	public String getKukan_start() {
		return kukan_start;
	}
	public void setKukan_start(String kukan_start) {
		this.kukan_start = kukan_start;
	}
	public String getKukan_stop() {
		return kukan_stop;
	}
	public void setKukan_stop(String kukan_stop) {
		this.kukan_stop = kukan_stop;
	}
	public String getRound_trip() {
		return round_trip;
	}
	public void setRound_trip(String round_trip) {
		this.round_trip = round_trip;
	}
	public String getDest_area() {
		return dest_area;
	}
	public void setDest_area(String dest_area) {
		this.dest_area = dest_area;
	}
	public String getTrp_shurui() {
		return trp_shurui;
	}
	public void setTrp_shurui(String trp_shurui) {
		this.trp_shurui = trp_shurui;
	}
	public String getTrp_cost() {
		return trp_cost;
	}
	public void setTrp_cost(String trp_cost) {
		this.trp_cost = trp_cost;
	}
	public String getMae_money() {
		return mae_money;
	}
	public void setMae_money(String mae_money) {
		this.mae_money = mae_money;
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
	public String getTr_add_form_flag() {
		return tr_add_form_flag;
	}
	public void setTr_add_form_flag(String tr_add_form_flag) {
		this.tr_add_form_flag = tr_add_form_flag;
	}
	@Override
	public String toString() {
		return "TR_InfoVO [user_id=" + user_id + ", doc_ym=" + doc_ym + ", kinmu_day=" + kinmu_day + ", mesai_no="
				+ mesai_no + ", kukan_start=" + kukan_start + ", kukan_stop=" + kukan_stop + ", round_trip="
				+ round_trip + ", dest_area=" + dest_area + ", trp_shurui=" + trp_shurui + ", trp_cost=" + trp_cost
				+ ", mae_money=" + mae_money + ", upd_dt=" + upd_dt + ", upd_id=" + upd_id + ", trk_dt=" + trk_dt
				+ ", trk_id=" + trk_id + ", tr_add_form_flag=" + tr_add_form_flag + "]";
	}

	

}
