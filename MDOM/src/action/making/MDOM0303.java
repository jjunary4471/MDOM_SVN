package action.making;

import java.util.HashMap;
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
			
			
			Map<String, String> param = new HashMap<String, String>();
			param.put("user_id", "10000002");
			param.put("kinmu_day", tr_InfoVO.getKinmu_day());
			
			String mesai_noStr = mdom0303_dao.getTRInfo_mesai_no(param);
			int mesai_no = 0;
			if(mesai_noStr != null) {
				mesai_no = Integer.parseInt(mesai_noStr);
				mesai_no++;
				mesai_noStr = String.valueOf(mesai_no);
			}

			tr_InfoVO.setUser_id(String.valueOf(session.get("user_id")));
			tr_InfoVO.setMesai_no(mesai_noStr);
			
			int resultInt = mdom0303_dao.setTRInfo(tr_InfoVO);
			
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
