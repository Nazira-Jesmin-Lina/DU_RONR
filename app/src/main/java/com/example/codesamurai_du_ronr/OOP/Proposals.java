package com.example.codesamurai_du_ronr.OOP;

public class Proposals {
    public String name,location,exec,project_id,goal,proposal_date;
    public Double Latitude,Longitude,cost,timespan;

    public Proposals() {

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
}
