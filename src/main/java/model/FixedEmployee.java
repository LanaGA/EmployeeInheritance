package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FixedEmployee extends Employee {

    @JsonCreator
    public FixedEmployee(@JsonProperty("id") int id,
                         @JsonProperty("name") String name,
                         @JsonProperty("rate") double rate) {
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
