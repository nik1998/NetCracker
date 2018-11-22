package Sorting;
import java.util.Comparator;
import People.Person;

public class QuickSort implements ISorted {
    Person[] list;
    Comparator<Person> Comp;
    public void Sort( Person[] list,int count, Comparator<Person> Comp)
    {
        this.list=list;
        this.Comp=Comp;
        Sort(0,0,count);
    }
    private void swap(int i,int j)
    {
        Person p=list[i];
        list[i]=list[j];
        list[j]=p;
    }

    private void Sort(int in,int l,int r) {
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
        Sort(l,l,ll);
        Sort(ll+1,ll+1,r);
    }
}