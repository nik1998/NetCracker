package UnitTests;

import People.Library;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryReflection {
    Library l;
    @Before
    public void setUp() throws Exception {
        l = new Library();
    }

    @Test
    public void initSort() {
        l.Sort();
    }
}