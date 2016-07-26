package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import bean.CD_InfoVO;
import bean.US_InfoVO;
import mybatis.SqlMapClient;

public class MDOM0101_DAO {
	private SqlSession sql;
	
	public List<US_InfoVO> getUserInfo(String userid) {
		
		sql = SqlMapClient.getSqlSession();
		
		Map<String, Object> source = new HashMap<String, Object>();
		source.put("id", userid);
		
		List<US_InfoVO> user = sql.selectList("common.getUserInfo", source);
		
		sql.close();
		return user;
	}

}
