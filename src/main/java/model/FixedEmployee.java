package model;

public class FixedEmployee extends Employee {
    public static final String TYPE = "fixed";

    public FixedEmployee(int id,
                         String name,
                         double rate) {
        super(id, name, rate);
    }

    @Override
    public String getType() {
        return "fixed";
    }

    @Override
    public double wage() {
        return getRate();
    }

}
