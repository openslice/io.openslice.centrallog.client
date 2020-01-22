



public class CentralLogMessage {

	CLevel clevel;
	
	String message;
	
	/**
	 * 
	 */
	public CentralLogMessage() {
		this.clevel=CLevel.WARN;
		this.message="This is the default CentralLogger message";
	}
		
	/**
	 * @param cLevel
	 * @param message
	 */
	public CentralLogMessage(CLevel cLevel, String message) {
		super();
		this.clevel = cLevel;
		this.message = message;
	}


	/**
	 * @return the cLevel
	 */
	public CLevel getclevel() {
		return clevel;
	}

	/**
	 * @param cLevel the cLevel to set
	 */
	public void setclevel(CLevel cLevel) {
		this.clevel = cLevel;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}		
}
