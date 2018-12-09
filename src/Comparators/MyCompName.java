package Comparators;

import People.Person;
import java.util.Comparator;


public class MyCompName implements IComparator<Person> {
    /**
     *
     * @param p1 Person1
     * @param p2 Person2
     * @return integer
     */
    public int compare(Person p1, Person p2)
    {
        return p1.getName().compareTo(p2.getName());
    }

}
