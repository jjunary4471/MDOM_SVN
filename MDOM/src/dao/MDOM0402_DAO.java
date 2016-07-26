package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import bean.HD_InfoVO;
import mybatis.SqlMapClient;

public class MDOM0402_DAO {
	private SqlSession sql;
	private int maxDocNum;
	
	
	public String getHLDInfo(String user_id, String hld_mng_no, String mk_day, String bigKubun, String smallKubun,
			String holidayReason, String holidayStart, String holidayField, String holidayEnd, String holidayPjname,
			String holidayJpnum, String holidayEtcnum, String holidayVisa, String holidayDocStatus, String trk_dt,
			String trk_id) {
		
		sql = SqlMapClient.getSqlSession();

		Map<String, Object> source = new HashMap<String, Object>();
		source.put("USER_ID", user_id);
		source.put("HLD_MNG_NO", hld_mng_no);
		source.put("MK_DAY", mk_day);
		source.put("HLD_KBN_CATEGORY", bigKubun);
		source.put("HLD_KBN_ITEM", smallKubun);
		source.put("HLD_RSN", holidayReason);
		source.put("HLD_START", holidayStart);
		source.put("HLD_END", holidayEnd);
		source.put("HLD_PHONE_JPN", holidayJpnum);
		source.put("HLD_WORK_AREA", holidayField);
		source.put("HLD_PROJECT_NAME", holidayPjname);
		source.put("HLD_PHONE_ETC", holidayEtcnum);
		source.put("VISA_DAY", holidayVisa);
		source.put("HLD_STATUS", holidayDocStatus);
		source.put("TRK_DT", trk_dt);
		source.put("TRK_ID", trk_id);
				
		List<HD_InfoVO> hld = sql.selectList("holiday.setHLDInfo", source);

		sql.close();
		return "OK";
			
	}
	
	public int getDocNum(String user_id) {
		sql = SqlMapClient.getSqlSession();
		
		maxDocNum = sql.selectOne("holiday.getDocNum", user_id);
		
		return maxDocNum;
	}
}
