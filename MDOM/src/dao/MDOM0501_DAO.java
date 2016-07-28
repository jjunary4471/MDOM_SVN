package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import bean.HD_ConfirmVO;
import bean.TS_ConfirmVO;
import mybatis.SqlMapClient;
import util.MybatisMapper;

public class MDOM0501_DAO {
	
	SqlMapClient sqlMapClient = null;
	SqlSession sqlSession = null;
	MybatisMapper mm = new MybatisMapper();
	
	public MDOM0501_DAO() {
		this.sqlMapClient = new SqlMapClient();
		this.sqlSession = this.sqlMapClient.getSqlSession();
	}
	
	public List<TS_ConfirmVO> getTSConfirmList(List<TS_ConfirmVO> ts_ConfirmVOList, Map<String, String> param) {
		ts_ConfirmVOList = sqlSession.selectList(mm.MDOM0501_getTSConfirmList, param);
		return ts_ConfirmVOList;
	}
	
	public List<HD_ConfirmVO> getHDConfirmList(List<HD_ConfirmVO> hd_InfoVOList, Map<String,String> param) {
		hd_InfoVOList = sqlSession.selectList(mm.MDOM0501_getHDInfoList, param);
		return hd_InfoVOList;
	}
	
	public void close() {
		sqlSession.close();
	}
}
