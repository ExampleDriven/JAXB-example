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

/**
 * @author Peter Szanto
 */
public class TestNormalClasses {

	private Logger logger = LoggerFactory.getLogger(getClass());


	private JAXBUtil jaxbUtil;
	
	@Before
	public void init() throws JAXBException {
		jaxbUtil = new JAXBUtil(JAXBContext.newInstance(Book.class));
	}

	@Test
	public void writeBook() throws JAXBException {

		Book book = new Book();
		book.setAuthor("me");
		book.setTitle("example");
		book.setSecret("super secret");
		
		jaxbUtil.writeXML(book, System.out);

	}	
	
	@Test
	public void readBook() throws JAXBException {
		InputStream fis = this.getClass().getClassLoader().getResourceAsStream("book.xml");

		Book b = (Book)jaxbUtil.readXML(fis);
		
		logger.debug("author : " + b.getAuthor());	
		logger.debug("title : " + b.getTitle());	
		
	}



}
