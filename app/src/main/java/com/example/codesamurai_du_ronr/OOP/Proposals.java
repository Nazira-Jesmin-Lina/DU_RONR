package com.example.codesamurai_du_ronr.OOP;

import java.util.ArrayList;

public class Proposals {
    public String name,location,exec,project_id,goal,proposal_date;
    public Double latitude,longitude,cost,timespan;

    public Proposals() {

    }
    public Proposals(ArrayList<String> data)
    {
        this.name=data.get(0);
        this.location=data.get(1);
        this.latitude=Double.parseDouble(data.get(2));
        this.longitude=Double.parseDouble(data.get(3));
        this.exec=data.get(4);
        this.cost=Double.parseDouble(data.get(5));
        this.timespan=Double.parseDouble(data.get(6));
        this.project_id=data.get(7);
        this.goal=data.get(8);
        this.proposal_date=data.get(9);
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

    public String getProposal_date() {
        return proposal_date;
    }

    public void setProposal_date(String proposal_date) {
        this.proposal_date = proposal_date;
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

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
