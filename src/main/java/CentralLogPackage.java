

public class CentralLogPackage {
	String endpoint;
	CentralLogMessage centrallogmsg;

	/**
	 * 
	 */
	public CentralLogPackage() {
		this.endpoint = "";
		this.centrallogmsg = new CentralLogMessage();
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	
	public CentralLogMessage getCentralLogMessage()
	{
		return this.centrallogmsg;
	}
	public void setCentralLogMessage(CentralLogMessage clm)
	{
		this.centrallogmsg=clm;
	}
}
