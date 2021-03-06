package dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mybatis.SqlMapClient;
import util.MybatisMapper;

public class MDOM0602_DAO {
	
	SqlMapClient sqlMapClient = null;
	SqlSession sqlSession = null;
	MybatisMapper mm = new MybatisMapper();
	
	public MDOM0602_DAO() {
		this.sqlMapClient = new SqlMapClient();
		this.sqlSession = this.sqlMapClient.getSqlSession();
	}

	public int updateTRInfoRequest(Map<String,String> param) {
		int resultInt = sqlSession.update(mm.MDOM0602_updateTRInfoForRequest, param);
		sqlSession.commit();
		return resultInt;
	}
	
	public int updateTRInfoConfirm(Map<String,String> param) {
		int resultInt = sqlSession.update(mm.MDOM0602_updateTRInfoForConfirm, param);
		sqlSession.commit();
		return resultInt;
	}
	
	public int updateTRInfoReject(Map<String,String> param) {
		int resultInt = sqlSession.update(mm.MDOM0602_updateTRInfoForReject, param);
		sqlSession.commit();
		return resultInt;
	}
	
	public void close() {
		sqlSession.close();
	}

}
