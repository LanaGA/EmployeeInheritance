package model;

public abstract class Employee {

    private String name;
    private double rate;
    private int id;

    public Employee(
            int id,
            String name,
            double rate
    ) {
        setId(id);
        setRate(rate);
        setName(name);
    }

    abstract public String getType();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public abstract double wage();


    @Override
    public String toString() {
        return "Name: " + name + ", id: " + id + ", Wage: " + wage() + ", Type: " + getType();
    }

}

