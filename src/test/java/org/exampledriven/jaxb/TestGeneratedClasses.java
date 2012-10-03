/**
 * 
 */
package org.exampledriven.jaxb;

import java.io.InputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.exampledriven.jaxb.contact.Contact;
import org.exampledriven.jaxb.request.Request;
import org.exampledriven.jaxb.response.Response;

/**
 * @author Peter Szanto
 */
public class TestGeneratedClasses  extends JAXBTestBase {

	private Logger logger = LoggerFactory.getLogger(getClass());

	public TestGeneratedClasses() throws JAXBException {
			super(JAXBContext.newInstance("org.exampledriven.jaxb.response:org.exampledriven.jaxb.contact:org.exampledriven.jaxb.request"));
	}

	@Test
	public void testResponse() throws JAXBException {

		InputStream fis = this.getClass().getClassLoader().getResourceAsStream("response.xml");

		Object o = readXML(fis);

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
		
		writeXML(response, System.out);

	}	

	@Test
	public void testRequest() throws JAXBException {

		InputStream fis = this.getClass().getClassLoader().getResourceAsStream("request.xml");

		Object o = readXML(fis);

		Request request= (Request) o;

		for (Contact contact : request.getContacts().getContact()) {
			logger.debug("=== contact ===");
			logger.debug(contact.getFirstname());
			logger.debug(contact.getLastname());
			logger.debug(contact.getEmail());
			
			contact.setEmail(contact.getEmail() + " UPDATED ");
		}
		
		writeXML(request, System.out);

	}	

}
