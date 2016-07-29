package action.reviewTrans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import bean.CD_InfoVO;
import bean.HD_InfoVO;
import bean.TR_InfoVO;
import bean.TR_ReviewVO;
import bean.TS_InfoVO;
import common.StringUtility;
import dao.MDOM0301_DAO;
import dao.MDOM0601_DAO;
import util.DateCalulator;

public class MDOM0601 implements Action, Preparable {
	
	private static final String AROUND = "00"; 
	
	private Logger log = Logger.getLogger(this.getClass());
	private ActionContext context = ActionContext.getContext();
	private Map<String, Object> session = null;
	private Map<String, Object> parameter = null;
	private List<TR_InfoVO> tr_InfoVOList = null;
	private List<HD_InfoVO> hd_InfoVOList = null;
	private String doc_year = null;
	private String doc_month = null;
	private String doc_ym = null;
	private TS_InfoVO ts_InfoVO = null;
	private String selected_user_id = null;
	private ArrayList<TR_ReviewVO> tr_ReviewVOList = null;
//	private List<TR_ReviewVO> tr_ReviewVO = null;
	
	private MDOM0601_DAO mdom0601_dao		= null;

	@Override
	public void prepare() throws Exception {
		session = context.getSession();
		parameter = context.getParameters();
		tr_InfoVOList = new ArrayList<TR_InfoVO>();
		hd_InfoVOList = new ArrayList<HD_InfoVO>();
		tr_ReviewVOList = new ArrayList<TR_ReviewVO>();
		ts_InfoVO = new TS_InfoVO();
		mdom0601_dao = new MDOM0601_DAO();
	}

	@Override
	public String execute() throws Exception {
		log.info("==============================================================");
		log.info("==========MDOM0601 execute start==============================");
		try {
			// セッション取得
			context.setSession(session);
			// データベース取得
			Map<String, String> param = new HashMap<String, String>();
			param.put("user_id", selected_user_id);
			param.put("doc_ym", doc_ym);
			tr_InfoVOList = mdom0601_dao.getTRInfoList(tr_InfoVOList, param);
			tr_ReviewVOList = getTR_ReviewListFromTRInfo(tr_InfoVOList);

			
			return "SUCCESS";
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";
		} finally{
			mdom0601_dao.close();
			log.info("============================================================");
			log.info("==========MDOM0601 execute end==============================");
		}
	}

	public List<TR_InfoVO> getTr_InfoVOList() {
		return tr_InfoVOList;
	}

	public List<HD_InfoVO> getHd_InfoVOList() {
		return hd_InfoVOList;
	}

	public String getDoc_year() {
		return doc_year;
	}

	public String getDoc_month() {
		return doc_month;
	}

	public String getSelected_user_id() {
		return selected_user_id;
	}
	private ArrayList<TR_ReviewVO> getTR_ReviewListFromTRInfo(List<TR_InfoVO> tr_InfoList){
		
		Iterator<TR_InfoVO> iteratorTr = tr_InfoList.iterator();
		ArrayList<TR_ReviewVO> tr_ReviewList = new ArrayList<>();
		
		TR_InfoVO tr_InfoVO = null;
	
		String zandaka = "0";
		
		while(iteratorTr.hasNext()) {
			tr_InfoVO = iteratorTr.next();
			zandaka = getZandakaFromTR_Info(tr_InfoVO.getTrp_cost(), zandaka);
			tr_ReviewList.add(getTR_ReviewVO(tr_InfoVO, zandaka));
			}
		
		return tr_ReviewList;
	}
	
	private TR_ReviewVO getTR_ReviewVO(TR_InfoVO tr_InfoVO, String zandaka){
		
		TR_ReviewVO tr_ReviewVO = new TR_ReviewVO();
		tr_ReviewVO.setKinmubi(getKinmubiFromTR_Info(tr_InfoVO.getMesai_no(), tr_InfoVO.getKinmu_day()));
		tr_ReviewVO.setYobi(getYobiFromTR_Info(new DateCalulator(),
												tr_InfoVO.getMesai_no(),
												tr_InfoVO.getKinmu_day()));
		tr_ReviewVO.setKukan(getKukanFromTR_Info(tr_InfoVO.getKukan_start(), 
												tr_InfoVO.getKukan_stop(), 
												tr_InfoVO.getRound_trip()));
		tr_ReviewVO.setIkisaki(tr_InfoVO.getDest_area());
		tr_ReviewVO.setNorimono(tr_InfoVO.getTrp_shurui());
		tr_ReviewVO.setKingaku(getYenMoney(tr_InfoVO.getTrp_cost()));
		tr_ReviewVO.setMaekin("");
		tr_ReviewVO.setZandaka(getYenMoney(getZandakaFromTR_Info(zandaka, tr_InfoVO.getTrp_cost())));
		return tr_ReviewVO;
	}
	
	private String getKinmubiFromTR_Info(String meisai_No, String kinmuDay){
		return meisai_No == "01" ? kinmuDay : ""; 
	}
	
	private String getYobiFromTR_Info(DateCalulator dateCalulator,String meisai_No, String kinmuDay){
		return meisai_No == "01" ? dateCalulator.getWeekDay(doc_year, doc_month, kinmuDay):""; 
	}
	
	private String getKukanFromTR_Info(String depature, String arrival, String around){
		return around.equals(AROUND) ? depature + "⇔" + arrival : depature + "⇒" + arrival; 
	}
	
	private String getYenMoney(String money){
		return StringUtility.getYenMoney(money);
	}
	
	private String getZandakaFromTR_Info(String zandaka, String kingaku){
		return String.valueOf(Integer.parseInt(zandaka) - Integer.parseInt(kingaku));
	}

	/**
	 * @param hd_InfoVOList the hd_InfoVOList to set
	 */
	public void setHd_InfoVOList(List<HD_InfoVO> hd_InfoVOList) {
		this.hd_InfoVOList = hd_InfoVOList;
	}

	/**
	 * @param doc_year the doc_year to set
	 */
	public void setDoc_year(String doc_year) {
		this.doc_year = doc_year;
	}

	/**
	 * @param doc_month the doc_month to set
	 */
	public void setDoc_month(String doc_month) {
		this.doc_month = doc_month;
	}

	/**
	 * @param selected_user_id the selected_user_id to set
	 */
	public void setSelected_user_id(String selected_user_id) {
		this.selected_user_id = selected_user_id;
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
	 * @return the ts_InfoVO
	 */
	public TS_InfoVO getTs_InfoVO() {
		return ts_InfoVO;
	}

	/**
	 * @param ts_InfoVO the ts_InfoVO to set
	 */
	public void setTs_InfoVO(TS_InfoVO ts_InfoVO) {
		this.ts_InfoVO = ts_InfoVO;
	}

	/**
	 * @return the tr_ReviewVOList
	 */
	public ArrayList<TR_ReviewVO> getTr_ReviewVOList() {
		return tr_ReviewVOList;
	}

	/**
	 * @param tr_ReviewVOList the tr_ReviewVOList to set
	 */
	public void setTr_ReviewVOList(ArrayList<TR_ReviewVO> tr_ReviewVOList) {
		this.tr_ReviewVOList = tr_ReviewVOList;
	}

	/**
	 * @param tr_InfoVOList the tr_InfoVOList to set
	 */
	public void setTr_InfoVOList(List<TR_InfoVO> tr_InfoVOList) {
		this.tr_InfoVOList = tr_InfoVOList;
	}
	
	
}
