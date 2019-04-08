package search;

import people.Person;

public class SearchByName implements ISearch {
    public Boolean checkin(Person p, Object obj)
    {
        return p.getName().equals(obj);
    }

}
