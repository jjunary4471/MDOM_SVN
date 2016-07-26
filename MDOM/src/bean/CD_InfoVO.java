package bean;

import java.sql.Timestamp;

public class CD_InfoVO {
	private String CODE_KANRI_NO = null;		//コード管理番号
	private String CODE_BUNRUI_NO = null;		//コード分類
	private String CODE_BUNRUI_NAME = null;		//コード分類名
	private String CODE_NO = null;				//コード
	private String CODE_NAME = null;			//コード名
	private String SSK_NM = null;				//正式名称
	private Timestamp UPD_DT = null;			//更新日付
	private String UPD_ID = null;				//更新者
	private Timestamp TRK_DT = null;			//登録日付
	private String TRK_ID = null;				//登録者
	
	
	public String getCODE_KANRI_NO() {
		return CODE_KANRI_NO;
	}
	public void setCODE_KANRI_NO(String cODE_KANRI_NO) {
		CODE_KANRI_NO = cODE_KANRI_NO;
	}
	public String getCODE_BUNRUI_NO() {
		return CODE_BUNRUI_NO;
	}
	public void setCODE_BUNRUI_NO(String cODE_BUNRUI_NO) {
		CODE_BUNRUI_NO = cODE_BUNRUI_NO;
	}
	public String getCODE_BUNRUI_NAME() {
		return CODE_BUNRUI_NAME;
	}
	public void setCODE_BUNRUI_NAME(String cODE_BUNRUI_NAME) {
		CODE_BUNRUI_NAME = cODE_BUNRUI_NAME;
	}
	public String getCODE_NO() {
		return CODE_NO;
	}
	public void setCODE_NO(String cODE_NO) {
		CODE_NO = cODE_NO;
	}
	public String getCODE_NAME() {
		return CODE_NAME;
	}
	public void setCODE_NAME(String cODE_NAME) {
		CODE_NAME = cODE_NAME;
	}
	public String getSSK_NM() {
		return SSK_NM;
	}
	public void setSSK_NM(String sSK_NM) {
		SSK_NM = sSK_NM;
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
	public String getTRK_ID() {
		return TRK_ID;
	}
	public void setTRK_ID(String tRK_ID) {
		TRK_ID = tRK_ID;
	}
	
	@Override
	public String toString() {
		return "CD_InfoVO [CODE_KANRI_NO=" + CODE_KANRI_NO + ", CODE_BUNRUI_NO=" + CODE_BUNRUI_NO
				+ ", CODE_BUNRUI_NAME=" + CODE_BUNRUI_NAME + ", CODE_NO=" + CODE_NO + ", CODE_NAME=" + CODE_NAME
				+ ", SSK_NM=" + SSK_NM + ", UPD_DT=" + UPD_DT + ", UPD_ID=" + UPD_ID + ", TRK_DT=" + TRK_DT
				+ ", TRK_ID=" + TRK_ID + "]";
	}
	
}
