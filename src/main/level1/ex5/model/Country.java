package main.level1.ex5.model;

import java.io.Serializable;

public class Country implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private int poblation;

    public Country(String name, int poblation) {
        this.name  = name;
        this.poblation = poblation;
    }

    public int getPoblation() {
        return poblation;
    }

    public void setPoblation(int poblation) {
        this.poblation = poblation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", poblation=" + poblation +
                '}';
    }
}



