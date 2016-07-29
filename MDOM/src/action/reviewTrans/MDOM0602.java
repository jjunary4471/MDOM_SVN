package action.reviewTrans;

import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.Preparable;

public class MDOM0602 implements Action, Preparable {
	
	private Logger log = Logger.getLogger(this.getClass());
	private ActionContext context = ActionContext.getContext();
	private Map<String, Object> session = null;
	private Map<String, Object> parameter = null;
	private String doc_year = null;
	private String doc_month = null;
	private String selected_user_id = null;
	private String docStatus = null;

	@Override
	public void prepare() throws Exception {
		session = context.getSession();
		parameter = context.getParameters();
	}

	@Override
	public String execute() throws Exception {
		doc_year = String.valueOf(parameter.get("doc_year"));
		doc_month = String.valueOf(parameter.get("doc_month"));
		selected_user_id = String.valueOf(parameter.get("selected_user_id"));
		
		return null;
	}

	/**
	 * @return the docStatus
	 */
	public String getDocStatus() {
		return docStatus;
	}

	/**
	 * @param docStatus the docStatus to set
	 */
	public void setDocStatus(String docStatus) {
		this.docStatus = docStatus;
	}
	
	

}
