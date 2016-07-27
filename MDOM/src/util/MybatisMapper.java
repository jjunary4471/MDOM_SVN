package util;

import java.util.List;

import bean.HD_InfoVO;
import bean.TR_InfoVO;
import bean.TS_InfoVO;

public class MybatisMapper {
	
	public String MDOM0301_getUSInfo = "mdom03.getUSInfo";
	public String MDOM0301_getTSInfo = "mdom03.getTSInfo";
	public String MDOM0301_getTRInfoList = "mdom03.getTRInfoList";
	public String MDOM0301_getHDInfoList = "mdom03.getHDInfoList";	
	
	public String MDOM0302_updateUSInfo = "mdom03.updateUSInfo";

	public String MDOM0303_getTRInfo_mesai_no = "mdom03.getTRInfo_mesai_no";
	public String MDOM0303_insertTRInfo = "mdom03.insertTRInfo";
	public String MDOM0303_updateTRInfo = "mdom03.updateTRInfo";
	public String MDOM0303_deleteTRInfo = "mdom03.deleteTRInfo";

	public String MDOM0304_deleteHDInfo = "mdom03.deleteHDInfo";

	public String MDOMCOMMON_getCDInfoList = "common.getCDInfoList";
}
