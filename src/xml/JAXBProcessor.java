package xml;

import people.Library;
import people.Person;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JAXBProcessor implements XmlProcessor {
    @Override
    public Library parseXml(String filename) {
        try {
            JAXBContext context = JAXBContext.newInstance(Person.class, Library.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            Library repository = (Library) unmarshaller.unmarshal(new File(filename));
            return repository;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
