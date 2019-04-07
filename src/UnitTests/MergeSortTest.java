package UnitTests;

import People.Person;
import Sorting.BubbleSort;
import org.joda.time.format.DateTimeFormat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MergeSortTest {
    private Person[] p;
    private Person[] p2;
    private org.joda.time.format.DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.mm.yyyy");
    BubbleSort q;

    @Before
    public void setUp() throws Exception {
        p = new Person[7];
        p[0] = new Person("ab", "w", formatter.parseDateTime("12.04.1990"), 0);
        p[1] = new Person("ac", "m", formatter.parseDateTime("12.04.1994"), 0);
        p[2] = new Person("aad", "w", formatter.parseDateTime("12.04.1992"), 0);
        p[3] = new Person("aaf", "m", formatter.parseDateTime("12.04.1989"), 0);
        p[4] = new Person("sd", "w", formatter.parseDateTime("12.04.1998"), 0);
        p[5] = new Person("sdf", "m", formatter.parseDateTime("12.04.1991"), 0);
        p[6] = new Person("ert", "w", formatter.parseDateTime("12.04.1999"), 0);
        p2 = new Person[7];
        for (int i = 0; i < 7; i++) {
            p2[i] = p[i];
        }
        q = new BubbleSort();
    }


    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void sort() throws Exception {
        q.sort(p,7,(p1, p2)->p1.getName().compareTo(p2.getName()));
        int k=0;
        Arrays.sort(p2,(p1, p2)->p1.getName().compareTo(p2.getName()));
        assertEquals(p2,p);
    }

}