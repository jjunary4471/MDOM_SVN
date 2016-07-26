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
	
	private MDOMCD_DAO mdomcom_dao		= null;
	// bean
	private List<CD_InfoVO> cd_InfoVOList	= null;
	
	private HashMap<String, LinkedHashMap<String, CD_InfoVO>> allCdMap    = null;

	public MDOM_CD(HashMap<String, LinkedHashMap<String, CD_InfoVO>> allCdMap){
		if(allCdMap == null){
			this.allCdMap = getCodeMap();
		}else{
			this.allCdMap = allCdMap;
		}
	}
	
	public HashMap<String, LinkedHashMap<String, CD_InfoVO>> getCodeMap(){
		allCdMap = new HashMap<>();
		
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
			}
			cdMap.put(cd_InfoVOTemp.getCODE_NO(), cd_InfoVOTemp);
		}
		allCdMap.put(cd_bunrui_no, cdMap);
				
		return allCdMap;
	}
	
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
	
	public String getCodeName(String cd_bunrui_no, String cd_no){
		return allCdMap.get(cd_bunrui_no).get(cd_no).getCODE_NAME();
	}
	
	public String getCodeSSKName(String cd_bunrui_no, String cd_no){		
		return allCdMap.get(cd_bunrui_no).get(cd_no).getSSK_NM();
	}
	
	
	
}
