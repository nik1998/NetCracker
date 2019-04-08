package sorting;
import java.util.Comparator;
import people.Person;

public class BubbleSort implements ISorted  {
    Person[] list;
    Comparator<Person> comp;
    /**
     *
     * @param list -array of Person
     * @param count -count of Person that you
     * @param Comp - Comparator or lambda expressions
     */
    public void sort(Person[] list, int count, Comparator<Person> Comp)
    {
        this.list=list;
        this.comp=Comp;
        sort(count);
    }
    private void swap(int i,int j)
    {
        Person p=list[i];
        list[i]=list[j];
        list[j]=p;
    }

    private void sort(int count) {

        for(int i=0;i<count;i++)
        {
            for(int j=0;j<count-i-1;j++)
            {
                if(comp.compare(list[j],list[j+1])>0)
                {
                    swap(j,j+1);
                }
            }
        }

    }

}
