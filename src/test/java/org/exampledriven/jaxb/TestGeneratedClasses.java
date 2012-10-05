/**
 * 
 */
package org.exampledriven.jaxb;

import java.io.InputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.exampledriven.jaxb.generated.contact.Contact;
import org.exampledriven.jaxb.generated.request.Request;
import org.exampledriven.jaxb.generated.response.Response;

/**
 * @author Peter Szanto
 */
public class TestGeneratedClasses {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private JAXBUtil jaxbUtil;
	@Before
	public void init() throws JAXBException {
		jaxbUtil = new JAXBUtil(JAXBContext.newInstance(Request.class, Response.class));
	}
	
	@Test
	public void testResponse() throws JAXBException {

		InputStream fis = this.getClass().getClassLoader().getResourceAsStream("response.xml");

		Object o = jaxbUtil.readXML(fis);

		Response response = (Response) o;

		for (Contact contact : response.getContacts().getContact()) {
			logger.debug("=== contact ===");
			logger.debug(contact.getFirstname());
			logger.debug(contact.getLastname());
			logger.debug(contact.getEmail());
		}
		
		Contact c = new Contact();
		c.setFirstname("This comes from the Java code");
		c.setEmail("exampledriven@example.org");

		response.getContacts().getContact().add(c);
		
		jaxbUtil.writeXML(response, System.out);

	}	

	@Test
	public void testRequest() throws JAXBException {

		InputStream fis = this.getClass().getClassLoader().getResourceAsStream("request.xml");

		Object o = jaxbUtil.readXML(fis);

		Request request= (Request) o;

		for (Contact contact : request.getContacts().getContact()) {
			logger.debug("=== contact ===");
			logger.debug(contact.getFirstname());
			logger.debug(contact.getLastname());
			logger.debug(contact.getEmail());
			
			contact.setEmail(contact.getEmail() + " UPDATED ");
		}
		
		jaxbUtil.writeXML(request, System.out);

	}	

}
