package model;

public class OutsourceEmployee extends Employee {
    public OutsourceEmployee(int id, String name, double rate){
        this.id = id;
        this.rate = rate;
        this.name = name;

        type = "outsource";
    }
    @Override
    public double wage() {
        return 20.8*8*rate;
    }
}
