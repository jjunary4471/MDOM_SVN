package common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import bean.CD_InfoVO;
import dao.MDOMCD_DAO;

public class MDOM_CD {
	
	/**
	 * {@value #com}コード分類名：社名
	 * **/
	public static final String com = "001";
	/**
	 * {@value #dept}　コード分類名：部署
	 * **/
	public static final String dept = "002";
	/**
	 * {@value #rank}　コード分類名：職位
	 * **/
	public static final String rank = "003";
	/**
	 * {@value #auth_flg}　コード分類名：確認権限有無
	 * **/
	public static final String auth_flg = "004";
	/**
	 * {@value #auth_lvl}　コード分類名：確認レベル
	 * **/
	public static final String auth_lvl = "005";
	/**
	 * {@value #doc_sts}　コード分類名：書類状態
	 * **/
	public static final String doc_sts = "006";
	/**
	 * {@value #rnd_trip}　コード分類名：往復区分
	 * **/
	public static final String rnd_trip = "007";
	/**
	 * {@value #holi_cate}　コード分類名：休暇理由（大）
	 * **/
	public static final String holi_cate = "008";
	/**
	 * {@value #holi_item}　コード分類名：休暇理由（小）
	 * **/
	public static final String holi_item = "009";
	
	
	private MDOMCD_DAO mdomcom_dao		= null;
	// bean
	private List<CD_InfoVO> cd_InfoVOList	= null;
	
	private HashMap<String, LinkedHashMap<String, CD_InfoVO>> allCdMap    = null;

	public HashMap<String, LinkedHashMap<String, CD_InfoVO>> getAllCdMap() {
		return allCdMap;
	}

	public void setAllCdMap(HashMap<String, LinkedHashMap<String, CD_InfoVO>> allCdMap) {
		this.allCdMap = allCdMap;
	}

	/**
	 * コードマップクラスを作成
	 * @param allCdMap   コードマップ
	 */
	public MDOM_CD(HashMap<String, LinkedHashMap<String, CD_InfoVO>> allCdMap){
		if(allCdMap == null){
			setAllCdMap(getCodeMap());
		}else{
			setAllCdMap(allCdMap);		
		}
	}
	
	/**
	 * コードテーブルかた全てのコードを取得しコードマップを作成
	 */
	public HashMap<String, LinkedHashMap<String, CD_InfoVO>> getCodeMap(){
		allCdMap = new HashMap<>();
		
		mdomcom_dao = new MDOMCD_DAO();
		
		Map<String, String> param = new HashMap<String, String>();
		
		cd_InfoVOList = mdomcom_dao.getCDInfoList(cd_InfoVOList, param);
				
		String cd_bunrui_no = cd_InfoVOList.get(0).getCODE_BUNRUI_NO();
		
		LinkedHashMap<String, CD_InfoVO> cdMap = new  LinkedHashMap<>();
		
		Iterator<CD_InfoVO> iteratorCd = cd_InfoVOList.iterator();
		
		while(iteratorCd.hasNext()) {
			CD_InfoVO cd_InfoVOTemp = iteratorCd.next();
			if(!cd_bunrui_no.equals(cd_InfoVOTemp.getCODE_BUNRUI_NO())){
				allCdMap.put(cd_bunrui_no, cdMap);
				cdMap = new LinkedHashMap<>();
				cd_bunrui_no = cd_InfoVOTemp.getCODE_BUNRUI_NO();
			}
			cdMap.put(cd_InfoVOTemp.getCODE_NO(), cd_InfoVOTemp);
		}
		allCdMap.put(cd_bunrui_no, cdMap);
				
		return allCdMap;
	}
	
	/**
	 * コード分類が一致するコード名リストを取得
	 * @param cd_bunrui_no コード分類
	 * @return　コード名リスト
	 */
	public ArrayList<String> getCodeNameList( String cd_bunrui_no){
		
		LinkedHashMap<String, CD_InfoVO> cdMap = new  LinkedHashMap<>();
		ArrayList<String> cdList = new ArrayList<>();
		cdMap = allCdMap.get(cd_bunrui_no);
		
		Iterator<CD_InfoVO> iteratorCd = cdMap.values().iterator();
		
		while(iteratorCd.hasNext()) {
			cdList.add(iteratorCd.next().getCODE_NAME());
		}
		
		return cdList;
	}
	
	/**
	 * コード分類、コードが一致するコード名を取得
	 * @param cd_bunrui_no コード分類
	 * @param　cd_no コード
	 * @return　コード名
	 */
	public String getCodeName(String cd_bunrui_no, String cd_no){	
		return allCdMap.get(cd_bunrui_no).get(cd_no).getCODE_NAME();
	}
	
	/**
	 * コード分類、コードが一致するコード正式名称を取得
	 * @param cd_bunrui_no コード分類
	 * @param cd_no コード
	 * @return コード正式名称
	 */
	public String getCodeSSKName(String cd_bunrui_no, String cd_no){		
		return allCdMap.get(cd_bunrui_no).get(cd_no).getSSK_NM();
	}
	
}
