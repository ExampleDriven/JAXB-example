package org.exampledriven.jaxb;

import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBTestBase {

	protected Unmarshaller unmarshaller = null;
	protected Marshaller marshaller = null;

	public JAXBTestBase(JAXBContext jaxbContext) throws JAXBException {
		unmarshaller = jaxbContext.createUnmarshaller();
		marshaller = jaxbContext.createMarshaller();
	}

	public Object readXML(InputStream istrm) throws JAXBException {

		Object o = unmarshaller.unmarshal(istrm);
		return o;

	}

	public void writeXML(Object o, OutputStream os) throws JAXBException {

		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(o, os);

	}

}
