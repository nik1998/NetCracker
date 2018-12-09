package Search;

import People.Person;

public interface ISearch {
    /**
     *
     * @param p type class person
     * @param obl type of object that is searched
     * @return Boolean
     */
    public Boolean checkin(Person p,Object obl);
}
