package action.making;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import dao.MDOM0301_DAO;
import dao.MDOM0302_DAO;
import util.DateCalulator;

public class MDOM0302 implements Action, Preparable, ModelDriven<MDOM0301_DAO> {
	ActionContext context = ActionContext.getContext();
	Map<String, Object> session = null;
	Map<String, Object> parameter = null;
	
	MDOM0302_DAO mdom0302_dao = null;
	
	@Override
	public String execute() throws Exception {
		try{
		//
		String user_id = String.valueOf(session.get("s_user_id"));
		DateCalulator dateCalulator = new DateCalulator();
		String month = String.valueOf(dateCalulator.getCurrentMonth());
		String year  = String.valueOf(dateCalulator.getCurrentYear());
		if(month.length() == 1) {
			month = "0" + month;
		}
		
		String currentDoc_ym = year + month;
		String doc_ym = String.valueOf(parameter.get("doc_ym"));
		//
		Map<String, String> param = new HashMap<String, String>();
//		param.put("user_id",user_id);
//		param.put("doc_ym", doc_ym);				//前月
		param.put("currentDoc_ym", currentDoc_ym);	//更新する月
		param.put("user_id","10000001");
		param.put("doc_ym", "201608");				//前月
		
		int returnInt = mdom0302_dao.updateUSInfo(param);
		if(returnInt != 1) {
			throw new Exception();
		}
		return "SUCCESS";
		}catch(Exception e) {
			e.printStackTrace();
			return "ERROR";
		}finally {
			mdom0302_dao.close();
		}
	}

	@Override
	public MDOM0301_DAO getModel() {
		return null;
	}

	@Override
	public void prepare() throws Exception {
		session = context.getSession();
		parameter = context.getParameters();
		mdom0302_dao = new MDOM0302_DAO();
	}
	
}
