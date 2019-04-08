package unitTests;

import people.Library;
import people.Inject;
import org.junit.Before;
import org.junit.Test;

public class LibraryReflection {
    Library l;
    @Before
    public void setUp() throws Exception {
        l = new Library();

    }

    @Test
    public void initSort() {
        Inject.initSort(l);
        l.sort();
    }
}