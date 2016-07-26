package action.making;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import bean.HD_InfoVO;
import bean.TR_InfoVO;
import bean.TS_InfoVO;
import bean.US_InfoVO;
import dao.MDOM0301_DAO;
import util.DateCalulator;

public class MDOM0301 implements Action, Preparable{
	private Logger log = Logger.getLogger(this.getClass());
	private ActionContext context = ActionContext.getContext();
	private Map<String, Object> session = null;
	// dao
	private MDOM0301_DAO mdom0301_dao		= null;
	// bean
	private TS_InfoVO ts_InfoVO				= null;
	private US_InfoVO us_InfoVO				= null;
	private List<TR_InfoVO> tr_InfoVOList	= null;
	private List<HD_InfoVO> hd_InfoVOList	= null;
	// request
	private String documentDate		= null;
	private String documentYear		= null;
	private String documentMonth	= null;
	private String documentLastDay	= null;
	private String currentMonth		= null;
	//
	@Override
	public String execute() throws Exception {
		log.info("==============================================================");
		log.info("==========MDOM0301 execute start==============================");
		try {
			// セッション取得
			session.put("s_user_id", "10000001");
			context.setSession(session);
			String user_id = String.valueOf(session.get("s_user_id"));
			// データベース取得
			Map<String, String> param = new HashMap<String, String>();
			param.put("user_id", user_id);
			us_InfoVO = mdom0301_dao.getUSInfo(us_InfoVO, param);
			ts_InfoVO = mdom0301_dao.getTSInfo(ts_InfoVO, param);
			param.put("doc_ym", ts_InfoVO.getDoc_ym());
			tr_InfoVOList = mdom0301_dao.getTRInfoList(tr_InfoVOList, param);
			hd_InfoVOList = mdom0301_dao.getHDInfoList(hd_InfoVOList, param);
			// ドキュメント日付の設定
			documentDate = ts_InfoVO.getDoc_ym();
			documentYear = documentDate.substring(0,4);
			documentMonth = documentDate.substring(4,6);
			if(documentMonth.substring(0,1).equals("0")) {
				documentMonth = documentMonth.substring(1, 2);
			}
			// システム日付 の設定
			DateCalulator dateCalulator = new DateCalulator();
			currentMonth = String.valueOf(dateCalulator.getCurrentMonth());
			documentLastDay = String.valueOf(dateCalulator.getLastDay(documentYear,documentMonth));
			
			return "SUCCESS";
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";
		} finally {
			mdom0301_dao.close();
			log.info("============================================================");
			log.info("==========MDOM0301 execute end==============================");
		}
	}
	
	@Override
	public void prepare() throws Exception {
		session = context.getSession();
		mdom0301_dao = new MDOM0301_DAO();
		this.ts_InfoVO = new TS_InfoVO();
		this.us_InfoVO = new US_InfoVO();
		this.hd_InfoVOList = new ArrayList<HD_InfoVO>();
		this.tr_InfoVOList = new ArrayList<TR_InfoVO>();
	}

	
	
	public TS_InfoVO getTs_InfoVO() {
		return ts_InfoVO;
	}

	public String getDocumentYear() {
		return documentYear;
	}

	public String getDocumentMonth() {
		return documentMonth;
	}

	public String getDocumentDate() {
		return documentDate;
	}
	
	public String getDocumentLastDay() {
		return documentLastDay;
	}
	
	public String getCurrentMonth() {
		return currentMonth;
	}

	public void setDocumentMonth(String documentMonth) {
		this.documentMonth = documentMonth;
	}

	public US_InfoVO getUs_InfoVO() {
		return us_InfoVO;
	}
	
	public List<TR_InfoVO> getTr_InfoVOList() {
		return tr_InfoVOList;
	}

	public List<HD_InfoVO> getHd_InfoVOList() {
		return hd_InfoVOList;
	}
}
