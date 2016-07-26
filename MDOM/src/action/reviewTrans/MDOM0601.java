package action.reviewTrans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.Preparable;

import bean.HD_InfoVO;
import bean.TR_InfoVO;

public class MDOM0601 implements Action, Preparable {
	private Logger log = Logger.getLogger(this.getClass());
	private ActionContext context = ActionContext.getContext();
	private Map<String, Object> session = null;
	private Map<String, Object> parameter = null;
	private List<TR_InfoVO> tr_InfoVOList = null;
	private List<HD_InfoVO> hd_InfoVOList = null;
	private String doc_year = null;
	private String doc_month = null;

	@Override
	public void prepare() throws Exception {
		session = context.getSession();
		parameter = context.getParameters();
		tr_InfoVOList = new ArrayList<TR_InfoVO>();
		hd_InfoVOList = new ArrayList<HD_InfoVO>();
	}

	@Override
	public String execute() throws Exception {
		try {
			// セッション取得
			context.setSession(session);
			String user_id = String.valueOf(session.get("s_user_id"));
			// パラメーター取得
			tr_InfoVOList = (List<TR_InfoVO>) parameter.get("tr_InfoVOList");
			hd_InfoVOList = (List<HD_InfoVO>) parameter.get("hd_InfoVOList");
			doc_year = String.valueOf(parameter.get("doc_year"));
			doc_month = String.valueOf(parameter.get("doc_month"));
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";
		} finally {
			return "SUCCESS";
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
	
	
}
