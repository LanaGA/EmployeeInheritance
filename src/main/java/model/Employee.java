package model;

public abstract class Employee implements Comparable<Employee> {
    String type;
    String name;
    double rate;
    int id;

    public abstract double wage();

    @Override
    public int compareTo(Employee b) {
        if (this.wage() == b.wage()) {
            return this.name.compareTo(b.name);
        }
        if (this.wage() < b.wage()) {
            return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", id: " + id + ", Wage: " + wage() + ", Type: " + type;
    }

    public String printAllInfo() {
        return "Name: " + name + ", id: " + id + ", Wage: " + wage() + ", Type: " + type + "\n";
    }

    public String save() {
        return type + " " + id + " " + rate + " " + name + "\n";
    }

    public String printName() {
        return ("Name: " + name + "\n");
    }

    public String printId() {
        return ("id: " + id + "\n");
    }

}

