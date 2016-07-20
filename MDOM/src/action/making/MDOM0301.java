package action.making;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import bean.DocumentInfoBean;
import form.MakingForm;

public class MDOM0301 implements Action, Preparable, ModelDriven<MakingForm> {

	DocumentInfoBean documentInfo = null;
	MakingForm formData = null;
	String documentYear = "16";
	String documentMonth = "7";
	
	@Override
	public String execute() throws Exception {
		System.out.println("execute start");
		
		documentInfo = new DocumentInfoBean();
		documentInfo.setUSER_ID("10000001");
		documentInfo.setDOC_YM("20160701");
		documentInfo.setTRNS_STATUS("2:承認要請");
		documentInfo.setAUTH_USER("20000001");
		formData.setDocumentInfo(documentInfo);
		
		System.out.println("execute end");
		return "SUCCESS";
	}

	@Override
	public MakingForm getModel() {
		
		return formData;
	}

	@Override
	public void prepare() throws Exception {
		this.formData = new MakingForm();
	}
	
	public String getDocumentYear() {
		return documentYear;
	}
	public String getDocumentMonth() {
		return documentMonth;
	}
}
