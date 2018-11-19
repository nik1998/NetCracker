package People;

import org.joda.time.DateTime;
public class Library {
    Person[] list;
    int  count;
    final int step=10;
    public Library()
    {
        count=0;
        list=new Person[step];
    }
    public void add(String Name, char sex, DateTime date)
    {
        if(list.length==count)
        {
            resize();
        }
        list[count]=new Person(Name, sex,date);
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
    public void change(String Name, Person person)
    {
        for (int i=0;i<count;i++)
        {
            if(list[i].Name.equals(Name)==true)
            {
                list[i]= person;
                break;
            }
        }
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
            if(list[i].Name.equals(Name)==true)
            {
                ok =true;
                count--;
            }

        }

    }



}
