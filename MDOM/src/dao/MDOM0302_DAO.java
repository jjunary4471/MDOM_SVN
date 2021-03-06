package dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mybatis.SqlMapClient;
import util.MybatisMapper;

public class MDOM0302_DAO {
	SqlMapClient sqlMapClient = null;
	SqlSession sqlSession = null;
	MybatisMapper mm = new MybatisMapper();
	
	public MDOM0302_DAO() {
		this.sqlMapClient = new SqlMapClient();
		this.sqlSession = this.sqlMapClient.getSqlSession();
	}

	public int updateUSInfo(Map<String,String> param) {
		int resultInt = sqlSession.update(mm.MDOM0302_updateUSInfo, param);
		sqlSession.commit();
		return resultInt;
	}
	
	public void close() {
		sqlSession.close();
	}
}
