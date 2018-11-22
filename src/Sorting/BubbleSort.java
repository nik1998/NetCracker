package Sorting;
import java.util.Comparator;
import People.Person;

public class BubbleSort implements ISorted  {
    Person[] list;
    Comparator<Person> Comp;
    public void Sort( Person[] list,int count, Comparator<Person> Comp)
    {
        this.list=list;
        this.Comp=Comp;
        Sort(count);
    }
    private void swap(int i,int j)
    {
        Person p=list[i];
        list[i]=list[j];
        list[j]=p;
    }

    private void Sort(int count) {

        for(int i=0;i<count;i++)
        {
            for(int j=0;j<count-i-1;j++)
            {
                if(Comp.compare(list[j],list[j+1])>0)
                {
                    swap(j,j+1);
                }
            }
        }

    }
}
