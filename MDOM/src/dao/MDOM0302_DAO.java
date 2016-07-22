package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import bean.HD_InfoVO;
import bean.TR_InfoVO;
import bean.TS_InfoVO;
import bean.US_InfoVO;
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
