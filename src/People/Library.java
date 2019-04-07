package People;
import Search.ISearch;
import Search.SearchByName;
import Sorting.ISorted;
import Sorting.QuickSort;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.io.FileWriter;
import java.lang.reflect.Field;
import java.util.logging.*;

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
    private final int step=5;
    @Autoinjectble
    private ISorted sort;
    private org.joda.time.format.DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.mm.yyyy");
    private final static Logger log = Logger.getLogger(Library.class.getName());
    public Library(ISorted sort)
    {
        count=0;
        list=new Person[step];
        this.sort=sort;
        /*list[0]=new Person("ab","w",formatter.parseDateTime("12.04.1990"),0);
        list[1]=new Person("ac","m",formatter.parseDateTime("12.04.1994"),0);
        list[2]=new Person("aad","w",formatter.parseDateTime("12.04.1992"),0);
        list[3]=new Person("aaf","m",formatter.parseDateTime("12.04.1989"),0);
        list[4]=new Person("sd","w",formatter.parseDateTime("12.04.1998"),0);
        list[5]=new Person("sdf","m",formatter.parseDateTime("12.04.1991"),0);
        list[6]=new Person("ert","w",formatter.parseDateTime("12.04.1999"),0);
        count=7;
        sort();*/

    }
    public Library()
    {
        count=0;
        list=new Person[step];
        this.sort=new QuickSort();
        //PrintConf();
    }

    private void PrintConf()
    {
        try {
            FileWriter writer = new FileWriter("properties.txt");
            Class c = this.getClass();
            Field f=c.getDeclaredField("sort");
            String sortname=f.get(this).getClass().getTypeName();
            writer.write("sort=");
            writer.write(sortname);
            writer.flush();
            writer.close();
        }
        catch(Exception ex)
        {
            log.log( Level.SEVERE, ex.toString(), ex );
        }
    }


    /**
     *
     * @param p type class Person
     */
    public void add(Person p)
    {
        if(list.length==count)
        {
            resize();
            log.info("Resize");
        }
        id++;
        list[count]=p;
        log.info("Add " + p.toString());
        count++;
    }

    private void resize()
    {
        try {
            Person[] list2 = new Person[list.length + step];
            for (int i = 0; i < list.length; i++) {
                list2[i] = list[i];
            }
            list = list2;
        }
        catch (Exception ex) {
            log.log( Level.SEVERE, ex.toString(), ex );
        }
    }

    /**
     * sort
     */
    public void sort()
    {
        log.info("sort");
        sort.sort(list, count,(p1, p2)->p1.getName().compareTo(p2.getName()));
    }

    /**
     *
     * @param id - id of object that changes ,type string
     * @param Name2 -
     * @param sex
     * @param date
     */
    public void change(Integer id, String Name2, String sex, DateTime date)
    {
        log.info("change");
        for (int i=0;i<count;i++)
        {
            if(list[i].getId().equals(id)==true)
            {
                list[i]= new Person(Name2,sex,date,list[i].getId());
                break;
            }
        }
    }

    /**
     *
     * @param obj type class Person
     * @return array of Person
     */
    public Person[] findByName(String obj)
    {
        return find(obj,new SearchByName());
    }

    private Person[] find(Object obj,ISearch search)
    {
        Integer k=0;
        log.info("find");
        for(int i=0;i<count;i++)
        {
            if(search.checkin(list[i],obj))
            {
                k++;
            }
        }
        Person [] pf=new Person[k];
        k=0;
        for(int i=0;i<count;i++)
        {
            if(search.checkin(list[i],obj))
            {
                pf[k]=list[i];
                k++;
            }
        }
        log.info("find number "+k.toString());
        return pf;
    }

    /**
     *
     * @param id id of object, type Integer
     */
    public void delete(Integer id)
    {
        log.log(Level.INFO,"delete "+id.toString());
        try {
            Boolean ok = false;
            for (int i = 0; i < count - 1; i++) {
                if (ok) {
                    list[i - 1] = list[i];
                }
                if (list[i].getId().equals(id) == true) {
                    ok = true;
                    count--;
                }
            }
        }
        catch (Exception ex)
        {
            log.log( Level.SEVERE, ex.toString(), ex );
        }
    }
}
