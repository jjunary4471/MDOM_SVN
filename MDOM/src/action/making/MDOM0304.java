package action.making;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.Preparable;

import dao.MDOM0304_DAO;
import util.DateCalulator;

public class MDOM0304 implements Action, Preparable {
	private Logger log = Logger.getLogger(this.getClass());
	private ActionContext context = ActionContext.getContext();
	private Map<String, Object> session = null;
	// bean
	private MDOM0304_DAO mdom0304_dao = null;
	
	private String hld_mng_no = null;

	@Override
	public String execute() throws Exception {
		log.info("==============================================================");
		log.info("==========MDOM0304 execute start==============================");
		try{
		// セッション取得
		String user_id = String.valueOf(session.get("s_user_id"));
		// データベース取得
		Map<String, String> param = new HashMap<String, String>();
		param.put("user_id",user_id);
		param.put("hld_mng_no", hld_mng_no);
		int returnInt = mdom0304_dao.deleteHDInfo(param);
		if(returnInt != 1) {
			throw new Exception();
		}
		return "SUCCESS";
		}catch(Exception e) {
			e.printStackTrace();
			return "ERROR";
		}finally {
			mdom0304_dao.close();
			log.info("============================================================");
			log.info("==========MDOM0304 execute end==============================");
		}
	}

	@Override
	public void prepare() throws Exception {
		session = context.getSession();
		mdom0304_dao = new MDOM0304_DAO();
	}
	
	public void setHld_mng_no(String hld_mng_no) {
		this.hld_mng_no = hld_mng_no;
	}
	
	
}
