package com.company;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import people.Library;
import people.Person;
import xml.JAXBProcessor;
import xml.StaxStreamProcessor;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    static void request(int t, Library lib) {
        System.out.println("Enter name");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        if (t == 2) {
            lib.delete(0);
        } else {
            String name2 = name;
            if (t == 1) {
                System.out.println("Enter name");
                name2 = sc.next();
            }
            System.out.println("Enter sex");
            String ch = sc.next();
            System.out.println("Enter Date of birthday");
            org.joda.time.format.DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.mm.yyyy");
            DateTime datetime = formatter.parseDateTime(sc.next());
            if (t == 0) {
                Person p = new Person(name2, ch, datetime, 1);
                lib.add(p);
            } else {
                lib.change(0, name2, ch, datetime);
            }
        }
    }

    private static final String xml = "resources/person.xml";

    public static void main(String[] args) {
        // write your code here
        /*System.out.println("Hello");
        Scanner sc = new Scanner(System.in);
        Library lib =new Library(new MergeSort());
        while(true) {
            System.out.println("Enter 0-Add person, 1 - Change person, 2- Remove person,3 - Exit");
            int t = Integer.parseInt(sc.next());
            switch (t)
            {
                case 0:
                case 1:
                case 2:
                {
                    request(t,lib);
                    break;
                }
                case 3:
                {
                    return;
                }
                default:
                    continue;
            }
        }*/
        Library l = new Library();
        try (StaxStreamProcessor processor = new StaxStreamProcessor(Files.newInputStream(Paths.get(xml)))) {
            XMLStreamReader reader = processor.getReader();
            org.joda.time.format.DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy.dd.mm");
            while (processor.doUntil(XMLEvent.START_ELEMENT, "person")) {
                String name = reader.getAttributeValue(null, "name");
                Integer id = Integer.parseInt(reader.getAttributeValue(null, "id"));
                DateTime date = formatter.parseDateTime(reader.getAttributeValue(null, "date"));
                String sex = reader.getAttributeValue(null, "sex");
                l.add(new Person(name, sex, date, id));
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(l.toString());


        JAXBProcessor pr = new JAXBProcessor();
        Library ll=pr.parseXml(new File(xml));
        System.out.println(ll.toString());
    }
}
