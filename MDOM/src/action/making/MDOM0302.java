package action.making;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import dao.MDOM0301_DAO;
import dao.MDOM0302_DAO;
import util.DateCalulator;

public class MDOM0302 implements Action, Preparable{
	private Logger log = Logger.getLogger(this.getClass());
	private ActionContext context = ActionContext.getContext();
	private Map<String, Object> session = null;
	// dao
	private MDOM0302_DAO mdom0302_dao = null;
	//
	private String current_doc_ym = null; 
	
	@Override
	public String execute() throws Exception {
		log.info("==============================================================");
		log.info("==========MDOM0302 execute start==============================");
		try{
		// セッション取得
		String user_id = String.valueOf(session.get("s_user_id"));
		//  システム日付の設定
		DateCalulator dateCalulator = new DateCalulator();
		String month = String.valueOf(dateCalulator.getCurrentMonth());
		String year  = String.valueOf(dateCalulator.getCurrentYear());
		if(month.length() == 1) {
			month = "0" + month;
		}
		// ドキュメント日付の設定
		String currentDoc_ym = year + month;
		// データベース取得
		Map<String, String> param = new HashMap<String, String>();
		param.put("user_id",user_id);
		param.put("doc_ym", current_doc_ym);		//前月
		param.put("currentDoc_ym", currentDoc_ym);	//更新する月
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
			log.info("============================================================");
			log.info("==========MDOM0302 execute end==============================");
		}
	}

	@Override
	public void prepare() throws Exception {
		session = context.getSession();
		mdom0302_dao = new MDOM0302_DAO();
	}

	public void setCurrent_doc_ym(String current_doc_ym) {
		this.current_doc_ym = current_doc_ym;
	}

	
}
