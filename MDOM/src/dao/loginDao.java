package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import bean.userInfoBean;
import mybatis.SqlMapClient;

public class loginDao {
	private SqlSession sql;
	
	public List<userInfoBean> getUserInfo(String userid, String userpw) {

		sql = SqlMapClient.getSqlSession();

		Map<String, Object> source = new HashMap<String, Object>();
		source.put("id", userid);
		source.put("pw", userpw);


		List<userInfoBean> user = sql.selectList("mapper_common", source);
		
		sql.close();
		return user;
	}
}
