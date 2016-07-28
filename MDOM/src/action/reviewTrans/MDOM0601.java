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
import com.opensymphony.xwork2.Preparable;

import bean.CD_InfoVO;
import bean.HD_InfoVO;
import bean.TR_InfoVO;
import bean.TR_ReviewVO;
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
	private String selected_user_id = null;
	private List<TR_ReviewVO> tr_ReviewVOList = null;
//	private List<TR_ReviewVO> tr_ReviewVO = null;
	
	private MDOM0601_DAO mdom0601_dao		= null;

	@Override
	public void prepare() throws Exception {
		session = context.getSession();
		parameter = context.getParameters();
		tr_InfoVOList = new ArrayList<TR_InfoVO>();
		hd_InfoVOList = new ArrayList<HD_InfoVO>();
		tr_ReviewVOList = new ArrayList<TR_ReviewVO>();
	}

	@Override
	public String execute() throws Exception {
		try {
			doc_year = String.valueOf(parameter.get("doc_year"));
			doc_month = String.valueOf(parameter.get("doc_month"));
			selected_user_id = String.valueOf(parameter.get("selected_user_id"));
			// セッション取得
			context.setSession(session);
			// データベース取得
			Map<String, String> param = new HashMap<String, String>();
			param.put("user_id", selected_user_id);
			param.put("doc_ym", doc_month);
			tr_InfoVOList = mdom0601_dao.getTRInfoList(tr_InfoVOList, param);
			hd_InfoVOList = mdom0601_dao.getHDInfoList(hd_InfoVOList, param);

			
			return "SUCCESS";
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";
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
	private ArrayList<TR_ReviewVO> getTR_ReviewList(ArrayList<TR_InfoVO> tr_InfoList){
		
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
		tr_ReviewVO.setYobi(getYobiFromTR_Info(new DateCalulator(), tr_InfoVO.getKinmu_day()));
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
	
	private String getYobiFromTR_Info(DateCalulator dateCalulator, String kinmuDay){
		return dateCalulator.getWeekDay(doc_year, doc_month, kinmuDay); 
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
	
}
