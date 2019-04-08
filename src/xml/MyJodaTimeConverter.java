package xml;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class MyJodaTimeConverter extends XmlAdapter<String, DateTime> {

    static DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy.dd.mm");
    @Override
    public DateTime unmarshal(String v) throws Exception {
        return formatter.parseDateTime(v);
    }
    @Override
    public String marshal(DateTime v) throws Exception {
        return v.toString();
    }
}