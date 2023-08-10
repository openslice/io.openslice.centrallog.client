package io.openslice.centrallog.client;
/*-
 * ========================LICENSE_START=================================
 * io.openslice.portal.api
 * %%
 * Copyright (C) 2019 openslice.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =========================LICENSE_END==================================
 */

import java.util.concurrent.Future;

import org.apache.camel.Exchange;
import org.apache.camel.FluentProducerTemplate;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ctranoris
 *
 *
 */
@Configuration
@Component
public class CentralLogger {
	
	/** the Camel Context configure via Spring. See bean.xml*/	
//	private static CamelContext actx;
	

	@Autowired
	private ProducerTemplate template;

//	private static String centralloggerurl = null;
//	
//	public static String getCentralLoggerUrl()
//	{
//		return centralloggerurl;
//	}
//
//	public CentralLogger(String centralloggerurl_tmp) {
//		super();
//		centralloggerurl = centralloggerurl_tmp;
//	}
//
//	public static void setCentralLoggerUrl(String centralLoggerUrl)
//	{
//		centralloggerurl=centralLoggerUrl;
//	}
	
//	public void setActx(CamelContext actx) {
//		CentralLogger.actx = actx;
//	}
	
	
	/**
	 * @param cl
	 * @param amessage
	 * @param componentName
	 */
//	public void log(CLevel cl, String amessage) {	
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("endpoint", this.centralloggerurl );
//		map.put("clevel", cl.toString() );
//		map.put("message", amessage );
//		log(map);
//	}
	
//	public static void log(Map<String, Object> map)
//	{
//		String json;
//		try {
//			json = new ObjectMapper().writeValueAsString(map);
//			//System.out.println(json);
//			FluentProducerTemplate template = actx.createFluentProducerTemplate().to("seda:centralLog?multipleConsumers=true");
//			Future<Exchange> result = template.withBody( json ).asyncSend();
//			waitAndStopForTemplate( result, template);
//
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}					
//	}

	public void log(CLevel cl, String amessage, String component) {
		
//		CentralLogPackage clp = new CentralLogPackage();
//		clp.setEndpoint(centralloggerurl);
		CentralLogMessage clm = new CentralLogMessage();
		clm.setclevel(cl);
		clm.setMessage(amessage);
		clm.setComponent(component);
//		clp.setCentralLogMessage(clm);
		try {
			log(clm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void log(CentralLogMessage clm) throws Exception
	{
//		if ( actx==null) {
//			throw new Exception("actx is null");
//		}
		if ( template==null) {
			throw new Exception("template is null");
		}
		String json;
			json = new ObjectMapper().writeValueAsString(clm);
//			FluentProducerTemplate template = actx.createFluentProducerTemplate()
//					.to("activemq:queue:centrallogger.log");
			//Future<Exchange> result = template.withBody( json ).asyncSend();
			//waitAndStopForTemplate( result, template);
			template.sendBody("activemq:queue:centrallogger.log", json);
					
	}
	
	/**
	 * 
	 * utility function to stop ProducerTemplate
	 * @param result
	 * @param template
	 */
	private void waitAndStopForTemplate(Future<Exchange> result, FluentProducerTemplate template) {
		while (true) {			
			if (result.isDone()) {
				//logger.info( "waitAndStopForTemplate: " + template.toString() + " [STOPPED]");
				try {
					template.stop();
					//template.clearAll();
					template.cleanUp();
					break;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			try {
				//logger.info( "waitAndStopForTemplate: " + template.toString() + " [WAITING...]");
				Thread.sleep( 5000 );
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
}
