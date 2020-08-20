package base;


import model.Employee;

import java.util.Comparator;

public class ComparatorEmployee implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.wage() == o2.wage()) {
            return o1.getName().compareTo(o2.getName());
        }
        if (o1.wage() < o2.wage()) {
            return 1;
        }
        return -1;
    }
}
