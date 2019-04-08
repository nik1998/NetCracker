package xml;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import people.Library;
import people.Person;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StaxStreamProcessor implements AutoCloseable, XmlProcessor {

    private static final XMLInputFactory factory = XMLInputFactory.newInstance();

    private XMLStreamReader reader;
    private static DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy.dd.mm");

    public XMLStreamReader getReader() {
        return reader;
    }

    @Override
    public Library parseXml(String filename) {
        try {
            reader = factory.createXMLStreamReader(Files.newInputStream(Paths.get(filename)));
            Library l = new Library();

            while (doUntil(XMLEvent.START_ELEMENT, "person")) {
                String name = reader.getAttributeValue(null, "name");
                Integer id = Integer.parseInt(reader.getAttributeValue(null, "id"));
                DateTime date = formatter.parseDateTime(reader.getAttributeValue(null, "date"));
                String sex = reader.getAttributeValue(null, "sex");
                l.add(new Person(name, sex, date, id));
            }
            return l;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void close() {
        if (reader != null) {
            try {
                reader.close();
            } catch (XMLStreamException e) { // empty
            }
        }
    }

    public boolean doUntil(int stopEvent, String value) throws XMLStreamException {
        while (reader.hasNext()) {
            int event = reader.next();

            if (event == stopEvent) {
                String st = reader.getLocalName();
                if (value.equals(reader.getLocalName())) {
                    return true;
                }
            }
        }
        return false;
    }
}
