package action.review;

import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.Preparable;

import dao.MDOM0301_DAO;

public class MDOM0501 {
	private Logger log = Logger.getLogger(this.getClass());
	private ActionContext context = ActionContext.getContext();
	private Map<String, Object> session = null;
	// dao
	private MDOM0301_DAO mdom0301_dao		= null;

	public String execute() throws Exception {
		return "SUCCESS";
	}

}
