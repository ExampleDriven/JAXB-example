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

/**
 * @author Peter Szanto
 */
public class TestNormalClasses extends JAXBTestBase {

	private Logger logger = LoggerFactory.getLogger(getClass());

	public TestNormalClasses() throws JAXBException {
		super(JAXBContext.newInstance(Book.class));
	}

	@Test
	public void writeBook() throws JAXBException {

		Book book = new Book();
		book.setAuthor("me");
		book.setTitle("example");
		book.setSecret("super secret");
		
		writeXML(book, System.out);

	}	
	
	@Test
	public void readBook() throws JAXBException {
		InputStream fis = this.getClass().getClassLoader().getResourceAsStream("book.xml");

		Book b = (Book)readXML(fis);
		
		logger.debug("author : " + b.getAuthor());	
		logger.debug("title : " + b.getTitle());	
		
	}



}
