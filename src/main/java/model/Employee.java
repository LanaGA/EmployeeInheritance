package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Value;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;


@JsonTypeInfo(use = NAME, include = PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = FixedEmployee.class, name = "fixed"),
        @JsonSubTypes.Type(value = OutsourceEmployee.class, name = "outsorce")
})
public abstract class Employee implements Comparable<Employee> {

    public Employee(
            @JsonProperty("id") int id,
            @JsonProperty("name") String name,
            @JsonProperty("rate") double rate
    ) {
        setId(id);
        setRate(rate);
        setName(name);
    }
    @JsonIgnore
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

    private String name;
    private double rate;
    private int id;

    public abstract double wage();

    @Override
    public int compareTo(Employee b) {
        if (this.wage() == b.wage()) {
            return getName().compareTo(b.getName());
        }
        if (this.wage() < b.wage()) {
            return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", id: " + id + ", Wage: " + wage() + ", Type: " + getType();
    }

    public String save() {
        return getType() + " " + id + " " + rate + " " + name + "\n";
    }

    public String printName() {
        return ("Name: " + name + "\n");
    }

    public String printId() {
        return ("id: " + id + "\n");
    }

}

