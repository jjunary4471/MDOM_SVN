package action.making;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import bean.TR_InfoVO;
import bean.TS_InfoVO;
import dao.MDOM0301_DAO;

public class MDOM0301 implements Action, Preparable, ModelDriven<MDOM0301_DAO> {

	TS_InfoVO ts_InfoVO = null;
	TR_InfoVO tr_InfoVO = null;
	MDOM0301_DAO formData = null;
	String documentYear = "16";
	String documentMonth = "7";
	
	@Override
	public String execute() throws Exception {
		System.out.println("execute start");
		
		ts_InfoVO = new TS_InfoVO();
		ts_InfoVO.setUser_id("10000001");
		ts_InfoVO.setDoc_ym("20160701");
		ts_InfoVO.setTrns_status("2:承認要請");
		ts_InfoVO.setAuth_user("20000001");
		formData.setTs_InfoVO(ts_InfoVO);
		
//		tr_InfoVO.set
		
		System.out.println("execute end");
		return "SUCCESS";
	}

	@Override
	public MDOM0301_DAO getModel() {
		
		return formData;
	}

	@Override
	public void prepare() throws Exception {
		this.formData = new MDOM0301_DAO();
	}
	
	public String getDocumentYear() {
		return documentYear;
	}
	public String getDocumentMonth() {
		return documentMonth;
	}
}
