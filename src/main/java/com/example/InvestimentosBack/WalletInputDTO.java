package com.example.InvestimentosBack;

import com.example.InvestimentosBack.domain.Investment;

import java.util.ArrayList;

public class WalletInputDTO {
    
    Integer id;
    Double goal;
    ArrayList<Investment> firstYearInvestments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getGoal() {
        return goal;
    }

    public void setGoal(Double goal) {
        this.goal = goal;
    }

    public ArrayList<Investment> getFirstYearInvestments() {
        return firstYearInvestments;
    }

    public void setFirstYearInvestments(ArrayList<Investment> firstYearInvestments) {
        this.firstYearInvestments = firstYearInvestments;
    }
}
