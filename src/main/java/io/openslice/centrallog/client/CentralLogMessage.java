package io.openslice.centrallog.client;

import java.time.Instant;

/**
 * @author ctranoris
 *
 */
public class CentralLogMessage {

	private CLevel clevel;
	
	private String message;
	
	private String time;
	
	private String component;
	
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
		this.time = Instant.now().toString();
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}		
	
	
}
