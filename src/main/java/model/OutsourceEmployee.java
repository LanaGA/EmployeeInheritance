package model;

import static constant.WorkingDaysConstant.WORKING_HOURS_PER_MONTH;

public class OutsourceEmployee extends Employee {

    public static final String TYPE = "outsource";

    public OutsourceEmployee(int id,
                             String name,
                             double rate) {
        super(id, name, rate);
    }

    @Override
    public String getType() {
        return "outsource";
    }

    @Override
    public double wage() {
        return WORKING_HOURS_PER_MONTH * getRate();
    }
}
