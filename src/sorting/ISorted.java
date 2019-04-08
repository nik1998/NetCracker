package sorting;
import java.util.Comparator;
import people.Person;

public interface ISorted {
    void sort(Person[] list, int count, Comparator<Person> Comp);

}
