package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import bean.HD_InfoVO;
import bean.TR_InfoVO;
import bean.TS_InfoVO;
import bean.US_InfoVO;
import mybatis.SqlMapClient;
import util.MybatisMapper;

public class MDOM0303_DAO {

	SqlMapClient sqlMapClient = null;
	SqlSession sqlSession = null;
	MybatisMapper mm = new MybatisMapper();

	public MDOM0303_DAO() {
		this.sqlMapClient = new SqlMapClient();
		this.sqlSession = this.sqlMapClient.getSqlSession();
	}

	public int setTRInfo(TR_InfoVO tr_InfoVO) {
		int resultInt = sqlSession.insert(mm.MDOM0303_setTRInfo,tr_InfoVO);
		sqlSession.commit();
		return resultInt;
	}

	public void close() {
		sqlSession.close();
	}
}
