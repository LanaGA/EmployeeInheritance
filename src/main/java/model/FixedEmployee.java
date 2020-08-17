package model;

public class FixedEmployee extends Employee {

    public FixedEmployee(int id, String name, double rate) {
        this.id = id;
        this.rate = rate;
        this.name = name;

        type = "fixed";
    }

    @Override
    public double wage() {
        return rate;
    }



}
