package check;

import entities.Person;

public class FioPersonChecker implements PersonChecker {

    @Override
    public boolean check(Person p, Object value) {
        if (p.equals(value)) {
            return true;
        }
        return false;
    }

}
