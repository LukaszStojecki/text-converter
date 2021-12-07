package service.xml;


import model.Text;
import service.TextConverter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class ConvertToXML implements TextConverter {

    @Override
    public void convert(Text text) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Text.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            File file = new File("result.xml");
            jaxbMarshaller.marshal(text, file);
            jaxbMarshaller.marshal(text, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
