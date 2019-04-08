package search;

import people.Person;

public class SearchById {
    public Boolean checkin(Person p, Object obj)
    {
        return p.getId().equals(obj);
    }
}
