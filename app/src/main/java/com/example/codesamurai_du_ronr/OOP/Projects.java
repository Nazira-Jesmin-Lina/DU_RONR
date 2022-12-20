package com.example.codesamurai_du_ronr.OOP;

import java.util.ArrayList;

public class Projects {
    public String name,location,exec,project_id,goal,start_date;
    public Double Latitude,Longitude,cost,timespan,completion,actual_cost;

    public Projects(){

    }
    public Projects(ArrayList<String> data){
        this.name=data.get(0);
        this.location=data.get(1);
        this.Latitude=Double.parseDouble(data.get(2));
        this.Longitude=Double.parseDouble(data.get(3));
        this.exec=data.get(4);
        this.cost=Double.parseDouble(data.get(5));
        this.timespan=Double.parseDouble(data.get(6));
        this.project_id=data.get(7);
        this.goal=data.get(8);
        this.start_date=data.get(9);
        this.completion=Double.parseDouble(data.get(10));
        this.actual_cost=Double.parseDouble(data.get(11));

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getExec() {
        return exec;
    }

    public void setExec(String exec) {
        this.exec = exec;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public Double getLatitude() {
        return Latitude;
    }

    public void setLatitude(Double latitude) {
        Latitude = latitude;
    }

    public Double getLongitude() {
        return Longitude;
    }

    public void setLongitude(Double longitude) {
        Longitude = longitude;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getTimespan() {
        return timespan;
    }

    public void setTimespan(Double timespan) {
        this.timespan = timespan;
    }

    public Double getCompletion() {
        return completion;
    }

    public void setCompletion(Double completion) {
        this.completion = completion;
    }

    public Double getActual_cost() {
        return actual_cost;
    }

    public void setActual_cost(Double actual_cost) {
        this.actual_cost = actual_cost;
    }
}
