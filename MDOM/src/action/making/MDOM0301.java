package action.making;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

public class MDOM0301 implements Action, Preparable, ModelDriven<MDOM0301_DAO> {
	ActionContext context = ActionContext.getContext();
	Map<String, Object> session = null;
	
	MDOM0301_DAO mdom0301_dao = null;
	TS_InfoVO ts_InfoVO = null;
	US_InfoVO us_InfoVO = null;
	List<TR_InfoVO> tr_InfoVOList = null;
	List<HD_InfoVO> hd_InfoVOList = null;
	String documentDate = null;
	String documentYear = null;
	String documentMonth = null;
	String documentLastDay = null;
	String currentMonth = null;
	List<String> transDate_in = new ArrayList<String>();

	@Override
	public String execute() throws Exception {
		System.out.println("MDOM0301 execute start");
		try {
			//
			session.put("user_id", "10000001");
			context.setSession(session);
			//
			Map<String, String> param = new HashMap<String, String>();
			param.put("user_id", "10000001");
			//
			us_InfoVO = mdom0301_dao.getUSInfo(us_InfoVO, param);
			ts_InfoVO = mdom0301_dao.getTSInfo(ts_InfoVO, param);
			tr_InfoVOList = mdom0301_dao.getTRInfoList(tr_InfoVOList, param);
			//
			documentDate = ts_InfoVO.getDoc_ym();
			documentYear = documentDate.substring(0,4);
			documentMonth = documentDate.substring(4,6);
			if(documentMonth.substring(0,1).equals("0")) {
				documentMonth = documentMonth.substring(1, 2);
			}
			//
			DateCalulator dateCalulator = new DateCalulator();
			currentMonth = String.valueOf(dateCalulator.getCurrentMonth());
			documentLastDay = String.valueOf(dateCalulator.getLastDay(documentYear,documentMonth));
			//
			
			
			System.out.println("MDOM0301 execute end");
			return "SUCCESS";
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";
		} finally {
			mdom0301_dao.close();
		}
	}

	@Override
	public MDOM0301_DAO getModel() {

		return null;
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

	public List<String> getTransDate_in() {
		return transDate_in;
	}

	public US_InfoVO getUs_InfoVO() {
		return us_InfoVO;
	}
	
	public List<TR_InfoVO> getTr_InfoVOList() {
		return tr_InfoVOList;
	}
}
