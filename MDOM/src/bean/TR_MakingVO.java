package bean;

public class TR_MakingVO {
	
	private String kinmu_day = null; 	// 勤務日
	private String mesai_no = null; 	// 交通費明細番号
	private String kukan_start = null; 	// 区間開始
	private String kukan_stop = null; 	// 区間到着
	private String round_trip = null; 	// 往復有無
	private String dest_area = null; 	// 行先
	private String trp_shurui = null; 	// 乗物
	private String trp_cost = null; 	// 金額
	private String mae_money = null; 	// 前渡金
	
	
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
}
