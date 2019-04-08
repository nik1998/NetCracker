package unitTests;

import people.Library;
import people.Person;
import org.joda.time.format.DateTimeFormat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {

    private Person[] p;
    private Library l;
    private org.joda.time.format.DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.mm.yyyy");
    @Before
    public void setUp() throws Exception {
        p=new Person[7];
        p[0]=new Person("ab","w",formatter.parseDateTime("12.04.1990"),0);
        p[1]=new Person("ac","m",formatter.parseDateTime("12.04.1994"),0);
        p[2]=new Person("aad","w",formatter.parseDateTime("12.04.1992"),0);
        p[3]=new Person("aaf","m",formatter.parseDateTime("12.04.1989"),0);
        p[4]=new Person("sd","w",formatter.parseDateTime("12.04.1998"),0);
        p[5]=new Person("sdf","m",formatter.parseDateTime("12.04.1991"),0);
        p[6]=new Person("ert","w",formatter.parseDateTime("12.04.1999"),0);
        l=new Library();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void add() throws Exception {
        for(int i=0;i<7;i++)
        {
            l.add(p[i]);
        }
        Person[] p2=l.getList();
        for(int i=0;i<7;i++) {
            assertEquals(p[i], p2[i]);
        }
        assertEquals(7,l.getCount());
    }

    @Test
    public void resize() throws Exception {
    }

    @Test
    public void sort() throws Exception {
    }

    @Test
    public void change() throws Exception {
    }

    @Test
    public void find() throws Exception {
        add();
        Person [] p1=l.findByName("ab");
        Person [] p2=new Person[1];
        p2[0]=p[0];
        assertEquals(p2,p1);
    }

    @Test
    public void delete() throws Exception {
        for(int i=0;i<8;i++)
        {
            l.delete(i+1);
        }
    }

}