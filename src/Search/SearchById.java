package Search;

import People.Person;

public class SearchById {
    public Boolean checkin(Person p, Object obj)
    {
        return p.getId().equals(obj);
    }
}
