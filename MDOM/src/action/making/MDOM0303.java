package action.making;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import bean.TR_InfoVO;
import dao.MDOM0303_DAO;

public class MDOM0303 implements Action, Preparable, ModelDriven<TR_InfoVO> {
	private Logger log = Logger.getLogger(this.getClass());
	private ActionContext context = ActionContext.getContext();
	private Map<String, Object> session = null;
	// dao
	private MDOM0303_DAO mdom0303_dao = null;
	// bean
	private TR_InfoVO tr_InfoVO = null;

	@Override
	public String execute() throws Exception {
		log.info("==============================================================");
		log.info("==========MDOM0303 execute start==============================");
		try {
			// セッション取得
			String user_id = String.valueOf(session.get("s_user_id"));
			
			// パラメーター設定
			String doc_ym = tr_InfoVO.getDoc_ym();
			String kinmu_day = tr_InfoVO.getKinmu_day();
			if (kinmu_day.length() == 1) { // kinmu_dayの桁が1の場合、0を付ける。
				kinmu_day = "0" + kinmu_day; // DD形式にする。
			}
			tr_InfoVO.setUser_id(user_id);
			tr_InfoVO.setKinmu_day(kinmu_day);
			
			// パラメーター取得
			String flag = tr_InfoVO.getTr_add_form_flag();// SQLパラメーター設定
			
			// 交通費データの登録 -----------------------------------------------
			if (flag.equals("0")) {
				// パラメーター設定
				Map<String, String> param = new HashMap<String, String>();
				param.put("user_id", user_id);
				param.put("doc_ym", doc_ym);
				param.put("kinmu_day", kinmu_day);
				// データベース取得
				String mesai_noStr = mdom0303_dao.getTRInfo_mesai_no(param); // mesai
				int mesai_no = 0;
				if (mesai_noStr != null) {
					mesai_no = Integer.parseInt(mesai_noStr);
					mesai_no++;
					mesai_noStr = String.valueOf(mesai_no);
				}
				// データベース更新
				tr_InfoVO.setMesai_no(mesai_noStr);
				int resultInt = mdom0303_dao.insertTRInfo(tr_InfoVO);
				if (resultInt != 1) {
					throw new Exception();
				}
			}
			// 交通費データの修正-----------------------------------------------
			else if (flag.equals("1")) {
				int resultInt = mdom0303_dao.updateTRInfo(tr_InfoVO);
				if (resultInt != 1) {
					throw new Exception();
				}
			}
			// 交通費データの削除-----------------------------------------------
			else {
				int resultInt = mdom0303_dao.deleteTRInfo(tr_InfoVO);
				if (resultInt != 1) {
					throw new Exception();
				}
			}
			return "SUCCESS";
		} catch (Exception e) {
			return "ERROR";
		} finally {
			mdom0303_dao.close();
			log.info("==============================================================");
			log.info("==========MDOM0303 execute end================================");
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
