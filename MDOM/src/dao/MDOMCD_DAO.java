package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import bean.CD_InfoVO;
import mybatis.SqlMapClient;
import util.MybatisMapper;

public class MDOMCD_DAO {
	
	SqlMapClient sqlMapClient = null;
	SqlSession sqlSession = null;
	MybatisMapper mm = new MybatisMapper();
	
	public MDOMCD_DAO() {
		this.sqlMapClient = new SqlMapClient();
		this.sqlSession = this.sqlMapClient.getSqlSession();
	}	
	
	public CD_InfoVO getCdInfo(CD_InfoVO cd_InfoVO, Map<String,String> param) {
		cd_InfoVO = sqlSession.selectOne(mm.MDOM0301_getUSInfo, param);
		return cd_InfoVO;
	}

	public List<CD_InfoVO> getCDInfoList(List<CD_InfoVO> cd_InfoVOList, Map<String,String> param) {
		cd_InfoVOList = sqlSession.selectList(mm.MDOMCOMMON_getCDInfoList, param);
		return cd_InfoVOList;
	}
	
	public void close() {
		sqlSession.close();
	}

}
