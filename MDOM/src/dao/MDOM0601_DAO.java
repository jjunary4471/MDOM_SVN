package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import bean.HD_InfoVO;
import bean.TR_InfoVO;
import mybatis.SqlMapClient;
import util.MybatisMapper;

public class MDOM0601_DAO {

	SqlMapClient sqlMapClient = null;
	SqlSession sqlSession = null;
	MybatisMapper mm = new MybatisMapper();
	
	public MDOM0601_DAO() {
		this.sqlMapClient = new SqlMapClient();
		this.sqlSession = this.sqlMapClient.getSqlSession();
	}
	
	public List<TR_InfoVO> getTRInfoList(List<TR_InfoVO> tr_InfoVOList, Map<String,String> param) {
		tr_InfoVOList = sqlSession.selectList(mm.MDOM0601_getTRInfoList, param);
		return tr_InfoVOList;
	}

	public List<HD_InfoVO> getHDInfoList(List<HD_InfoVO> hd_InfoVOList, Map<String,String> param) {
		hd_InfoVOList = sqlSession.selectList(mm.MDOM0601_getHDInfoList, param);
		return hd_InfoVOList;
	}
	
	public void close() {
		sqlSession.close();
	}
}
