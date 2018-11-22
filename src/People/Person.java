package People;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;
public class Person implements Check {
    public String getName() {
        return name;
    }
    public String getSex() {
        return sex;
    }
    public DateTime getDate() {
        return date;
    }
    public Integer getAge() {
        return age;
    }
    public Integer getId() { return id; }
    public void setName(String name) {
        this.name = name;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public void setDate(DateTime date) {
        this.date = date;
        if(date==null)
            age=null;
        else
            age=2018-date.getYear();
    }
    private String name;
    private String sex;
    private DateTime date;
    private Integer age;
    private Integer id;
    public Person(String name, String sex, DateTime date,Integer id)
    {
        this.name=name;
        this.sex=sex;
        this.id=id;
        setDate(date);
    }
    public Boolean Checkin(Person obj)
    {
        Boolean ok=true;
        if(obj.name!=null && name.equals(obj.name)==false) {
            ok = false;
        }
        if(obj.sex!=null && sex.equals(obj.sex)==false)
        {
            ok=false;
        }
        if(obj.date!=null && date.equals(obj.date)==false)
        {
            ok=false;
        }
        if(obj.age!=null && age.equals(obj.age)==false)
        {
            ok=false;
        }
        if(obj.id!=null && id.equals(obj.id)==false)
        {
            ok=false;
        }
        return ok;
    }

}

