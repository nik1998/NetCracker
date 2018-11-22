package Comparators;

import People.Person;
import java.util.Comparator;


public class MyCompName implements IComparator<Person> {
    public int compare(Person p1, Person p2)
    {
        return p1.getName().compareTo(p2.getName());
    }

}
