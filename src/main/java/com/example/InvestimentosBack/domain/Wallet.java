package com.example.InvestimentosBack.domain;

import java.util.ArrayList;

public class Wallet {
    Integer id;
    Double goal;
    Integer timeToReachGoal;

    ArrayList<ArrayList<Investment>> yearlyInvestments;

    public Wallet(Integer id, Double goal, ArrayList<Investment> firstYearInvestments) {
        this.id = id;
        this.goal = goal;
        this.timeToReachGoal = Integer.MAX_VALUE;
        this.yearlyInvestments = new ArrayList<ArrayList<Investment>>();
        this.yearlyInvestments.add(firstYearInvestments);
        Double firstYearAmount = 0.0;
        for (Investment fy: firstYearInvestments) {
            firstYearAmount += fy.getValue();
        }
        if(firstYearAmount >= goal){
            timeToReachGoal = 1;
        }
        else{
            calculateYields(1);
        }

    }

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
        Double currentAmount = 0.0;
        boolean calculateNewYears = false;
        Integer index = 0;
        while(goal >= currentAmount){
            currentAmount = 0.0;
            if(index >= yearlyInvestments.size()) {
                calculateNewYears = true;
                break;
            }
            for(Investment investment : yearlyInvestments.get(index)){
                currentAmount += investment.getValue();
            }
            index++;
        }
        if(calculateNewYears){
            calculateYields(index);
        }
        else{
            yearlyInvestments = new ArrayList<ArrayList<Investment>>(yearlyInvestments.subList(0, index));
        }
        timeToReachGoal = yearlyInvestments.size();
    }

    public Integer getTimeToReachGoal() {
        return timeToReachGoal;
    }

    public ArrayList<ArrayList<Investment>> getYearlyInvestments() {
        return yearlyInvestments;
    }

    public void clearInvestments(){
        yearlyInvestments.clear();
    }

    public void setNewInvestment(ArrayList<Investment> yearInvestment, Integer index){
        if(index < 0 || index > yearlyInvestments.size()) {
            return;
        }else{
            yearlyInvestments.set(index-1, yearInvestment);
        }
        calculateYields(index);
    }
    private void calculateYields(Integer startYear){
        if(startYear > timeToReachGoal) return;
        Double currentYearAmount = 0.0;
        Integer index = startYear-1;
        boolean hasReachedGoal = false;
        while(!hasReachedGoal){
            currentYearAmount = 0.0;
            ArrayList<Investment> nextYearInvestments = new ArrayList<Investment>();
            for(Investment investment : yearlyInvestments.get(index)){
                currentYearAmount += investment.getValue();
                nextYearInvestments.add(new Investment(investment.getId(), investment.getName(), investment.getType(), investment.getValue()*(1+(investment.getYieldRate()/100)), investment.getYieldRate()));
            }
            if(currentYearAmount >= goal){
                hasReachedGoal = true;
                break;
            }
            index++;
            if(index < yearlyInvestments.size()-1) {
                yearlyInvestments.set(index, nextYearInvestments);
            }
            else{
                yearlyInvestments.add(nextYearInvestments);
            }
        }
        timeToReachGoal = index+1;
        yearlyInvestments = new ArrayList<>(yearlyInvestments.subList(0, timeToReachGoal));

    }
}
