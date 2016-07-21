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

public class MDOM0301 implements Action, Preparable, ModelDriven<MDOM0301_DAO> {
	ActionContext context = ActionContext.getContext();
	Map<String, Object> session = null;
	
	MDOM0301_DAO mdom0301_dao = null;
	TS_InfoVO ts_InfoVO = null;
	US_InfoVO us_InfoVO = null;
	List<TR_InfoVO> tr_InfoVOList = null;
	List<HD_InfoVO> hd_InfoVOList = null;
	String documentYear = null;
	String documentMonth = null;
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
			
			us_InfoVO = mdom0301_dao.getUSInfo(us_InfoVO, param);
			ts_InfoVO = mdom0301_dao.getTSInfo(ts_InfoVO, param);
			tr_InfoVOList = mdom0301_dao.getTRInfoList(tr_InfoVOList, param);
			String documentDate = ts_InfoVO.getDoc_ym();
			documentYear = documentDate.substring(0,4);
			documentMonth = documentDate.substring(4,6);
			
			
			transport_date();

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

	public List<String> getTransDate_in() {
		return transDate_in;
	}

	public US_InfoVO getUs_InfoVO() {
		return us_InfoVO;
	}
	
	public List<TR_InfoVO> getTr_InfoVOList() {
		return tr_InfoVOList;
	}
	
	public void transport_date() {
		String docuYear = documentYear;
		String docuMonth = null;
		if (documentMonth.length() == 1) {
			docuMonth = "0" + documentMonth;
		} else {
			docuMonth = documentMonth;
		}

		try {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyymm");
			String strDate = docuYear + docuMonth;
			Date documentDate = dateFormat.parse(strDate);
			int lastDay = calendar.getMaximum(Calendar.DAY_OF_MONTH);

			for (int i = 1; i <= lastDay; i++) {
				String strTemp = null;
				if (i < 10) {
					strTemp = "0" + String.valueOf(i);
				} else {
					strTemp = String.valueOf(i);
				}
				transDate_in.add(strDate + strTemp);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
