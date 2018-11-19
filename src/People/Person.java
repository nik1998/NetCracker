package People;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;
public class Person {
    String Name;
    char sex;
    DateTime date;
    public Person(String Name, char sex, DateTime date)
    {
        this.Name=Name;
        this.sex=sex;
        this.date=date;
    }

}
