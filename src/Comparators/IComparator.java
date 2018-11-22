package Comparators;

@FunctionalInterface
public interface IComparator<Person> {
    int compare(Person p1,Person p2);
}
