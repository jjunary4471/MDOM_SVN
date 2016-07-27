package dao;

import bean.HD_InfoVO;
import bean.US_InfoVO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mybatis.SqlMapClient;
import org.apache.ibatis.session.SqlSession;

public class MDOM0402_DAO {
	private SqlSession sql;
	private int maxDocNum;

	public String getHLDInfo(String user_id, String hld_mng_no, String mk_day, String bigKubun, String smallKubun,
			String holidayReason, String holidayStart, String holidayField, String holidayEnd, String holidayPjname,
			String holidayJpnum, String holidayEtcnum, String holidayVisa, String holidayDocStatus, String trk_dt,
			String trk_id) {
		this.sql = SqlMapClient.getSqlSession();

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

		List<HD_InfoVO> hld = this.sql.selectList("holiday.setHLDInfo", source);

		this.sql.close();
		return "OK";
	}

	public int getDocNum(String user_id) {
		this.sql = SqlMapClient.getSqlSession();

		try{
			
			this.maxDocNum = ((Integer) this.sql.selectOne("holiday.getDocNum", user_id)).intValue();
			
		}catch(Exception e) {
			return 0;
		}

		return this.maxDocNum;
	}

	public List<HD_InfoVO> getHldEditList(String user_id, String hld_mng_no) {
		this.sql = SqlMapClient.getSqlSession();

		Map<String, Object> source = new HashMap<String, Object>();
		source.put("USER_ID", user_id);
		source.put("HLD_MNG_NO", hld_mng_no);

		List<HD_InfoVO> edit = this.sql.selectList("holiday.setHLDEdit", source);

		this.sql.close();
		return edit;
	}

	public String setUserInfo(String USER_ID, String USER_PHONE_JPN, String WORK_AREA, String PROJECT_NAME,
			String USER_PHONE_ETC, String VISA_DAY) {
		this.sql = SqlMapClient.getSqlSession();

		Map<String, Object> source = new HashMap<String, Object>();
		source.put("USER_ID", USER_ID);
		source.put("USER_PHONE_JPN", USER_PHONE_JPN);
		source.put("WORK_AREA", WORK_AREA);
		source.put("PROJECT_NAME", PROJECT_NAME);
		source.put("USER_PHONE_ETC", USER_PHONE_ETC);
		source.put("VISA_DAY", VISA_DAY);

		List<US_InfoVO> user = this.sql.selectList("holiday.setUserInfo", source);

		this.sql.close();
		return "OK";
	}

	public String editHLDInfo(String USER_ID, String EDITDOCNUM, String BIGKUBUN, String SMALLKUBUN, 
			String HOLIDAYREASON, String HOLIDAYSTART, String HOLIDAYFIELD, String HOLIDAYEND,
			String HOLIDAYPJNAME, String HOLIDAYJPNUM, String HOLIDAYETCNUM, String HOLIDAYVISA,
			String UPD_DT, String UPD_ID) {
		
		this.sql = SqlMapClient.getSqlSession();
		
		try {

			Map<String, Object> source = new HashMap<String, Object>();
			source.put("USER_ID", USER_ID);
			source.put("HLD_MNG_NO", EDITDOCNUM);
			source.put("HLD_KBN_CATEGORY", BIGKUBUN);
			source.put("HLD_KBN_ITEM", SMALLKUBUN);
			source.put("HLD_RSN", HOLIDAYREASON);
			source.put("HLD_START", HOLIDAYSTART);
			source.put("HLD_END", HOLIDAYEND);
			source.put("HLD_PHONE_JPN", HOLIDAYJPNUM);
			source.put("HLD_WORK_AREA", HOLIDAYFIELD);
			source.put("HLD_PROJECT_NAME", HOLIDAYPJNAME);
			source.put("HLD_PHONE_ETC", HOLIDAYETCNUM);
			source.put("VISA_DAY", HOLIDAYVISA);
			source.put("UPD_DT", UPD_DT);
			source.put("UPD_ID", UPD_ID);
			
			List<HD_InfoVO> hld = this.sql.selectList("holiday.editHLDInfo", source);
			
			this.sql.close();
			return "OK";
		}catch(Exception e) {
			this.sql.close();
			return "NO";
		}
		
	}
	
}
