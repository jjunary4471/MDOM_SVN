
package action.review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.Preparable;

import bean.CD_InfoVO;
import bean.HD_ConfirmVO;
import bean.TS_ConfirmVO;
import bean.TS_InfoVO;
import common.MDOM_CD;
import dao.MDOM0501_DAO;
import util.DateCalulator;

public class MDOM0501 implements Action, Preparable {
	private Logger log = Logger.getLogger(this.getClass());
	private ActionContext context = ActionContext.getContext();
	private Map<String, Object> session = null;
	// dao
	private MDOM0501_DAO mdom0501_dao = null;
	// bean
	private HashMap<String, LinkedHashMap<String, CD_InfoVO>> cd_hashMap = null;
	private ArrayList<HashMap<String, String>> code_sts_list = null;
	private ArrayList<HashMap<String, String>> code_dept_list = null;
	private ArrayList<HashMap<String, String>> code_rank_list = null;
	private ArrayList<HashMap<String, String>> code_category_list = null;
	private ArrayList<HashMap<String, String>> code_item_list = null;
	private List<TS_ConfirmVO> ts_ConfirmVOList = null;
	private List<HD_ConfirmVO> hd_ConfirmVOList = null;
	//
	private String user_id = null;
	private String auth_lvl = null;

	@Override
	public String execute() throws Exception {
		log.info("==============================================================");
		log.info("==========MDOM0301 execute start==============================");
		try {
			// ===========================================================================
			// セッション取得
			user_id = (String) session.get("s_user_id");
			auth_lvl = (String) session.get("s_user_auth_lvl");

			// ===========================================================================
			// コード取得及び処理
			cd_hashMap = (HashMap<String, LinkedHashMap<String, CD_InfoVO>>) session.get("s_allCdMap");
			MDOM_CD mdcd = new MDOM_CD(cd_hashMap);
			code_sts_list = mdcd.getCodeNameList(MDOM_CD.doc_sts);
			code_dept_list = mdcd.getCodeNameList(MDOM_CD.dept);
			code_rank_list = mdcd.getCodeNameList(MDOM_CD.rank);
			code_category_list = mdcd.getCodeNameList(MDOM_CD.holi_cate);
			code_item_list = mdcd.getCodeNameList(MDOM_CD.holi_item);

			// ===========================================================================
			// システム日付取得
			DateCalulator dateCalulator = new DateCalulator();
			String year = String.valueOf(dateCalulator.getCurrentYear());
			String month = String.valueOf(dateCalulator.getCurrentMonth());
			if (month.length() == 1)
				month = "0" + month;
			String lastDay = String.valueOf(dateCalulator.getLastDay(year, month));
			String doc_ym = year + month;
			String first_day = year + month + "01";
			String last_day = year + month + lastDay;

			// ===========================================================================
			// パラメーター設定
			Map<String, String> tsParam = new HashMap<String, String>();
			tsParam.put("user_id", user_id);
			tsParam.put("doc_ym", doc_ym);
			Map<String, String> hdParam = new HashMap<String, String>();
			hdParam.put("user_id", user_id);
			hdParam.put("first_day", first_day);
			hdParam.put("last_day", last_day);
			hdParam.put("auth_lvl", auth_lvl);

			// ===========================================================================
			// データベース取得
			// 交通費情報リスト
			ts_ConfirmVOList = mdom0501_dao.getTSConfirmList(ts_ConfirmVOList, tsParam);
			// 休暇情報リスト
			hd_ConfirmVOList = mdom0501_dao.getHDConfirmList(hd_ConfirmVOList, hdParam);

			// ===========================================================================
			// 情報リストのコード名設定
			// 交通費情報の処理
			if (!ts_ConfirmVOList.isEmpty()) {	// 内容がある場合
				Iterator<TS_ConfirmVO> iteratorTs = ts_ConfirmVOList.iterator();
				while (iteratorTs.hasNext()) {
					TS_ConfirmVO ts_ConfirmVOTemp = new TS_ConfirmVO();
					ts_ConfirmVOTemp	= iteratorTs.next();
					String status		= ts_ConfirmVOTemp.getTrns_status();
					String department	= ts_ConfirmVOTemp.getUser_department();
					String rank			= ts_ConfirmVOTemp.getUser_rank();

					Iterator<HashMap<String, String>> iteratorSts = code_sts_list.iterator();
					while (iteratorSts.hasNext()) {
						Map<String, String> mapTemp = iteratorSts.next();
						if (mapTemp.get("code_no").equals(status)) {
							ts_ConfirmVOTemp.setTrns_status_name(mapTemp.get("code_name"));
							break;
						}
					}
					Iterator<HashMap<String, String>> iteratorDept = code_dept_list.iterator();
					while (iteratorDept.hasNext()) {
						Map<String, String> mapTemp = iteratorDept.next();
						if (mapTemp.get("code_no").equals(department)) {
							ts_ConfirmVOTemp.setUser_department_name(mapTemp.get("code_name"));
							break;
						}
					}
					Iterator<HashMap<String, String>> iteratorRank = code_rank_list.iterator();
					while (iteratorRank.hasNext()) {
						Map<String, String> mapTemp = iteratorRank.next();
						if (mapTemp.get("code_no").equals(rank)) {
							ts_ConfirmVOTemp.setUser_rank_name(mapTemp.get("code_name"));
							break;
						}
					}
				}
			}
			// 休暇情報の処理
			if(!hd_ConfirmVOList.isEmpty()) {	// 内容がある場合
				Iterator<HD_ConfirmVO> iteratorHd = hd_ConfirmVOList.iterator();
				while(iteratorHd.hasNext()) {
					HD_ConfirmVO hd_ConfirmVOTemp = new HD_ConfirmVO();
					hd_ConfirmVOTemp	= iteratorHd.next();
					String department	= hd_ConfirmVOTemp.getUser_department();
					String status		= hd_ConfirmVOTemp.getHld_status();
					String category		= hd_ConfirmVOTemp.getHld_kbn_category();
					String item			= hd_ConfirmVOTemp.getHld_kbn_item();

					Iterator<HashMap<String, String>> iteratorDept = code_dept_list.iterator();
					while (iteratorDept.hasNext()) {
						Map<String, String> mapTemp = iteratorDept.next();
						if (mapTemp.get("code_no").equals(department)) {
							hd_ConfirmVOTemp.setUser_department_name(mapTemp.get("code_name"));
							break;
						}
					}
					Iterator<HashMap<String, String>> iteratorSts = code_sts_list.iterator();
					while (iteratorSts.hasNext()) {
						Map<String, String> mapTemp = iteratorSts.next();
						if (mapTemp.get("code_no").equals(status)) {
							hd_ConfirmVOTemp.setHld_status_name(mapTemp.get("code_name"));
							break;
						}
					}
					Iterator<HashMap<String, String>> iteratorCtg = code_category_list.iterator();
					while (iteratorCtg.hasNext()) {
						Map<String, String> mapTemp = iteratorCtg.next();
						if (mapTemp.get("code_no").equals(category)) {
							hd_ConfirmVOTemp.setHld_kbn_category_name(mapTemp.get("code_name"));
							break;
						}
					}
					Iterator<HashMap<String, String>> iteratorItem = code_item_list.iterator();
					while (iteratorItem.hasNext()) {
						Map<String, String> mapTemp = iteratorItem.next();
						if (mapTemp.get("code_no").equals(item)) {
							hd_ConfirmVOTemp.setHld_kbn_item_name(mapTemp.get("code_name"));
							break;
						}
					}
				}
			}

			return "SUCCESS";
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";
		} finally {
			mdom0501_dao.close();
			log.info("============================================================");
			log.info("==========MDOM0301 execute end==============================");
		}
	}

	@Override
	public void prepare() throws Exception {
		session = context.getSession();
		mdom0501_dao = new MDOM0501_DAO();
		ts_ConfirmVOList = new ArrayList<TS_ConfirmVO>();
	}

	/**
	 * @return the ts_ConfirmVOList
	 */
	public List<TS_ConfirmVO> getTs_ConfirmVOList() {
		return ts_ConfirmVOList;
	}

	/**
	 * @return the hd_ConfirmVOList
	 */
	public List<HD_ConfirmVO> getHd_ConfirmVOList() {
		return hd_ConfirmVOList;
	}

}
