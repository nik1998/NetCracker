package xml;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import people.Library;
import people.Person;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
public class DomProcessor implements XmlProcessor{
    private static DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy.dd.mm");
    @Override
    public Library parseXml(String filename) {
        Library l = new Library();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(filename));
            NodeList elements = document.getDocumentElement().getElementsByTagName("person");
            for (int i = 0; i < elements.getLength(); i++) {
                Node person = elements.item(i);
                NamedNodeMap attributes = person.getAttributes();
                String name = attributes.getNamedItem("name").getNodeValue();
                Integer id = Integer.parseInt(attributes.getNamedItem("id").getNodeValue());
                DateTime date = formatter.parseDateTime(attributes.getNamedItem("date").getNodeValue());
                String sex = attributes.getNamedItem("sex").getNodeValue();
                l.add(new Person(name, sex, date, id));
            }
            return l;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
