package action.making;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import bean.TR_InfoVO;
import dao.MDOM0303_DAO;

public class MDOM0303 implements Action, Preparable, ModelDriven<TR_InfoVO> {
	ActionContext context = ActionContext.getContext();
	Map<String, Object> session = null;
	
	MDOM0303_DAO mdom0303_dao = null;
	TR_InfoVO tr_InfoVO = null;

	@Override
	public String execute() throws Exception {
		try {
			
			tr_InfoVO.setUser_id(String.valueOf(session.get("user_id")));
			tr_InfoVO.setMesai_no("0");
			tr_InfoVO.setDoc_ym("201607");
			
			int resultInt = mdom0303_dao.setTRInfo(tr_InfoVO);
			
			System.out.println(resultInt);
			if(resultInt != 1) {
				throw new Exception();
			}
			return "SUCCESS";
		} catch (Exception e) {
			return "ERROR";
		} finally {
			mdom0303_dao.close();
		}
	}

	@Override
	public TR_InfoVO getModel() {
		return tr_InfoVO;
	}

	@Override
	public void prepare() throws Exception {
		session = context.getSession();
		mdom0303_dao = new MDOM0303_DAO();
		tr_InfoVO = new TR_InfoVO();
	}

}
