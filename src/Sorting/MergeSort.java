package Sorting;
import java.util.Comparator;
import People.Person;

public class MergeSort implements ISorted {
    Person[] list;
    Comparator<Person> Comp;
    public void Sort( Person[] list,int count, Comparator<Person> Comp)
    {
        this.list=list;
        this.Comp=Comp;
        Person[] list2=Sort(0,count);
        for(int i=0;i<count;i++)
        {
            this.list[i]=list2[i];
        }
    }

    private Person[] Sort(int l,int r)
    {
        if(r-l<=1)
        {
            Person[] mergelist= new Person[1];
            mergelist[0]=list[l];
            return mergelist;
        }
        Person[] left =Sort(l,(l+r)/2);
        Person[] right =Sort((l+r)/2,r);
        Person[] ans=new Person[r-l];
        int lim=(l+r)/2-l;
        int lim2=r-(l+r)/2;
        int inl=0;
        int inr=0;
        for(int i=l;i<r;i++)
        {
            if(inl==lim)
            {
                ans[i-l]=right[inr];
                inr++;
            }
            else
            {
                if(inr==lim2)
                {
                    ans[i-l]=left[inl];
                    inl++;
                }
                else
                {
                    if( Comp.compare(left[inl],right[inr])<=0)
                    {
                        ans[i-l]=left[inl];
                        inl++;
                    }
                    else
                    {
                        ans[i-l]=right[inr];
                        inr++;
                    }
                }
            }
        }
        return ans;
    }
}
