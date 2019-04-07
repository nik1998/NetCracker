package Sorting;
import java.util.Comparator;
import People.Person;

public interface ISorted {
    void sort(Person[] list, int count, Comparator<Person> Comp);

}
