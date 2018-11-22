package Comparators;

import People.Person;
import java.util.Comparator;


public class AgeComp implements IComparator<Person> {
    public int compare(Person p1, Person p2)
    {
        if(p1.getAge()==null)
        {
            return -1;
        }
        else
        {
            if(p2.getAge()==null)
            {
                return 1;
            }
            return p1.getAge()-p2.getAge();
        }
    }

}