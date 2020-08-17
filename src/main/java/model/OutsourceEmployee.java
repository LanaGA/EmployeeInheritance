package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OutsourceEmployee extends Employee {

    @JsonCreator
    public OutsourceEmployee(@JsonProperty("id") int id,
                             @JsonProperty("name") String name,
                             @JsonProperty("rate") double rate) {
        super(id, name, rate);
    }

    @Override
    public String getType() {
        return "outsource";
    }

    @Override
    public double wage() {
        return 20.8*8*getRate();
    }
}
