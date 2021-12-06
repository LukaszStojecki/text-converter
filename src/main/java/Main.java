import model.Sentence;
import model.Text;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Sentence> sentenceList = new ArrayList<>();
        sentenceList.add(new Sentence(Arrays.asList("Mary", "had", "a", "little", "lamb")));
        sentenceList.add(new Sentence(Arrays.asList("Peter", "called", "for", "the", "wolf", "and", "Aesop", "came")));
        sentenceList.add(new Sentence(Arrays.asList("Cinderella", "likes", "shoes")));

        Text text = new Text(sentenceList);
        jaxbObjectToXML(text);
    }

    private static void jaxbObjectToXML(Text text) {
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
