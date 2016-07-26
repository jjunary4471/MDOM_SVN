package dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import bean.TR_InfoVO;
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

	public String getTRInfo_mesai_no(Map<String, String> param) {
		String returnStr = null;
		try {
			returnStr = sqlSession.selectOne(mm.MDOM0303_getTRInfo_mesai_no, param);
			if(returnStr == null) {
				returnStr = "-1";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return returnStr;
		}
	}

	public int insertTRInfo(TR_InfoVO tr_InfoVO) {
		int returnInt = 0;
		try {
			returnInt = sqlSession.insert(mm.MDOM0303_insertTRInfo, tr_InfoVO);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return returnInt;
		}
	}

	public int updateTRInfo(TR_InfoVO tr_InfoVO) {
		int returnInt = 0;
		try {
			returnInt = sqlSession.update(mm.MDOM0303_updateTRInfo, tr_InfoVO);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return returnInt;
		}
	}

	public int deleteTRInfo(TR_InfoVO tr_InfoVO) {
		int returnInt = 0;
		try {
			returnInt = sqlSession.delete(mm.MDOM0303_deleteTRInfo, tr_InfoVO);
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
