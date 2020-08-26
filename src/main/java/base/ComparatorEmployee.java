package base;


import model.Employee;

import java.util.Comparator;

public class ComparatorEmployee implements Comparator<Employee> {

    @Override
    public int compare(Employee firstEmployee, Employee secondEmployee) {
        if (firstEmployee.wage() == secondEmployee.wage()) {
            return firstEmployee.getName().compareTo(secondEmployee.getName());
        }
        if (firstEmployee.wage() < secondEmployee.wage()) {
            return 1;
        }
        return -1;
    }
}
