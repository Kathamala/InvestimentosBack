package com.example.InvestimentosBack.domain;

public class Investment {
    Integer id;
    String name;
    String type;
    Double value;
    Double yieldRate;

    public Investment(Integer id, String name, String type, Double value, Double yieldRate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.value = value;
        this.yieldRate = yieldRate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getYieldRate() {
        return yieldRate;
    }

    public void setYieldRate(Double yieldRate) {
        this.yieldRate = yieldRate;
    }
}
