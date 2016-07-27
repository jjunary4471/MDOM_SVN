package dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import bean.TR_InfoVO;
import mybatis.SqlMapClient;
import util.MybatisMapper;

public class MDOM0304_DAO {

	SqlMapClient sqlMapClient = null;
	SqlSession sqlSession = null;
	MybatisMapper mm = new MybatisMapper();

	public MDOM0304_DAO() {
		this.sqlMapClient = new SqlMapClient();
		this.sqlSession = this.sqlMapClient.getSqlSession();
	}

	public int deleteHDInfo(Map<String, String> param) {
		int returnInt = 0;
		try {
			returnInt = sqlSession.delete(mm.MDOM0304_deleteHDInfo, param);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return returnInt;
		}
	}
	
	public void close() {
		sqlSession.close();
	}
}
