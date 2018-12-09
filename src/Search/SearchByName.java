package Search;

import People.Person;

public class SearchByName implements ISearch {
    public Boolean checkin(Person p, Object obj)
    {
        return p.getName().equals(obj);
    }

}
