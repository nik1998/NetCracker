package Sorting;
import java.util.Comparator;
import People.Person;

public interface ISorted {
    void Sort(Person[] list,int count, Comparator<Person> Comp);

}
