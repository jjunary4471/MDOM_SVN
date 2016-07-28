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

	@Override
	public void prepare() throws Exception {
		session = context.getSession();
		parameter = context.getParameters();
	}

	@Override
	public String execute() throws Exception {
		return null;
	}

}
