package People;
import Sorting.ISorted;
import Sorting.QuickSort;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.Comparator;

public class Library {
    public Person[] getList() {
        return list;
    }

    public int getCount() {
        return count;
    }

    private Person[] list;
    private int  count;
    private int id=0;
    private final int step=10;
    private ISorted Sort;
    private org.joda.time.format.DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.mm.yyyy");
    public Library(ISorted Sort)
    {
        count=0;
        list=new Person[step];
        list[0]=new Person("ab","w",formatter.parseDateTime("12.04.1990"),0);
        list[1]=new Person("ac","m",formatter.parseDateTime("12.04.1994"),0);
        list[2]=new Person("aad","w",formatter.parseDateTime("12.04.1992"),0);
        list[3]=new Person("aaf","m",formatter.parseDateTime("12.04.1989"),0);
        list[4]=new Person("sd","w",formatter.parseDateTime("12.04.1998"),0);
        list[5]=new Person("sdf","m",formatter.parseDateTime("12.04.1991"),0);
        list[6]=new Person("ert","w",formatter.parseDateTime("12.04.1999"),0);
        count=7;
        this.Sort=Sort;
        Sort();
    }
    public Library()
    {
        count=0;
        list=new Person[step];
        this.Sort=new QuickSort();
    }

    public void add(String Name, String sex, DateTime date)
    {
        if(list.length==count)
        {
            resize();
        }
        id++;
        list[count]=new Person(Name,sex,date,id);

        count++;
    }
    public void add(Person p)
    {
        if(list.length==count)
        {
            resize();
        }
        id++;
        list[count]=p;

        count++;
    }
    public void resize()
    {
        Person[] list2=new Person[list.length+step];
        for (int i=0;i<list.length;i++)
        {
            list2[i]=list[i];
        }
        list=list2;
    }
    public void Sort()
    {
        Sort.Sort(list, count,(p1,p2)->p1.getName().compareTo(p2.getName()));
    }

    public void change(String Name, String Name2, String sex, DateTime date)
    {
        for (int i=0;i<count;i++)
        {
            if(list[i].getName().equals(Name)==true)
            {
                list[i]= new Person(Name2,sex,date,list[i].getId());
                break;
            }
        }
    }
    public Person[] find(Person obj)
    {
        int k=0;
        for(int i=0;i<count;i++)
        {
            if(list[i].Checkin(obj))
            {
                k++;
            }
        }
        Person [] pf=new Person[k];
        k=0;
        for(int i=0;i<count;i++)
        {
            if(list[i].Checkin(obj))
            {
                pf[k]=list[i];
                k++;
            }
        }
        return pf;
    }
    public void delete(String Name)
    {
        Boolean ok=false;
        for (int i=0;i<count-1;i++)
        {
            if(ok)
            {
                list[i-1]=list[i];
            }
            if(list[i].getName().equals(Name)==true)
            {
                ok =true;
                count--;
            }
        }
    }
}
