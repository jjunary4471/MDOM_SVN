package action.making;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import bean.HD_InfoVO;
import bean.TR_InfoVO;
import bean.TS_InfoVO;
import bean.US_InfoVO;
import mybatis.SqlMapClient;
import util.MybatisMapper;

public class MDOM0302 {
	
	SqlMapClient sqlMapClient = null;
	SqlSession sqlSession = null;
	MybatisMapper mm = new MybatisMapper();
	
	public MDOM0302() {
		this.sqlMapClient = new SqlMapClient();
		this.sqlSession = this.sqlMapClient.getSqlSession();
	}

	public US_InfoVO getUSInfo(US_InfoVO us_InfoVO, Map<String,String> param) {
		us_InfoVO = sqlSession.selectOne(mm.MDOM0301_getUSInfo, param);
		return us_InfoVO;
	}
	
	public TS_InfoVO getTSInfo(TS_InfoVO ts_InfoVO, Map<String,String> param) {
		ts_InfoVO = sqlSession.selectOne(mm.MDOM0301_getTSInfo, param);
		return ts_InfoVO;
	}
	
	public List<TR_InfoVO> getTRInfoList(List<TR_InfoVO> tr_InfoVOList, Map<String,String> param) {
		tr_InfoVOList = sqlSession.selectList(mm.MDOM0301_getTRInfoList, param);
		return tr_InfoVOList;
	}

	public List<HD_InfoVO> getHDInfoList(List<HD_InfoVO> hd_InfoVOList, Map<String,String> param) {
		hd_InfoVOList = sqlSession.selectList(mm.MDOM0301_getHDInfoList, param);
		return hd_InfoVOList;
	}
	
	public void close() {
		sqlSession.close();
	}
}
