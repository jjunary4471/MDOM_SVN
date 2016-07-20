package dao;

import java.util.ArrayList;
import java.util.List;

import bean.TR_InfoVO;
import bean.TS_InfoVO;

public class MDOM0301_DAO {
	
	TS_InfoVO ts_InfoVO = new TS_InfoVO();
	List<TR_InfoVO> tr_InfoVOList = new ArrayList<TR_InfoVO>();

	public TS_InfoVO getTs_InfoVO() {
		return ts_InfoVO;
	}

	public void setTs_InfoVO(TS_InfoVO ts_InfoVO) {
		this.ts_InfoVO = ts_InfoVO;
	}

	public List<TR_InfoVO> getTr_InfoVOList() {
		return tr_InfoVOList;
	}

	public void setTr_InfoVOList(List<TR_InfoVO> tr_InfoVOList) {
		this.tr_InfoVOList = tr_InfoVOList;
	}

	
	
	
}
