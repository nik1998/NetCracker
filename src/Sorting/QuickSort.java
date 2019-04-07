package Sorting;
import java.util.Comparator;
import People.Person;

public class QuickSort implements ISorted {
    Person[] list;
    Comparator<Person> Comp;

    /**
     *
     * @param list -array of Person
     * @param count -count of Person that you
     * @param Comp - Comparator or lambda expressions
     */
    public void sort(Person[] list, int count, Comparator<Person> Comp)
    {
        this.list=list;
        this.Comp=Comp;
        sort(0,0,count);
    }
    private void swap(int i,int j)
    {
        Person p=list[i];
        list[i]=list[j];
        list[j]=p;
    }

    private void sort(int in, int l, int r) {
        int rr=r;
        int ll=l;
        if(r-l<=1)
        {
            return;
        }
        for(int i=in+1;i<rr;i++)
        {
            int c=Comp.compare(list[in],list[i]);
            if(c<0)
            {
                while(rr>ll)
                {
                    if(Comp.compare(list[in],list[rr-1])>0)
                    {
                        swap(rr-1,i);
                        ll++;
                        rr--;
                        break;
                    }
                    else
                    {
                        rr--;
                    }
                }
            }
            else
            {
                ll++;
            }
        }
        swap(in,ll);
        sort(l,l,ll);
        sort(ll+1,ll+1,r);
    }

}
