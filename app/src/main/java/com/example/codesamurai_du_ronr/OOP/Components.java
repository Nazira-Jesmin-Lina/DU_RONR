package com.example.codesamurai_du_ronr.OOP;

import java.util.ArrayList;

public class Components {
    public Components() {
    }
    public Components(ArrayList<String> data)
    {
        this.project_id=data.get(0);
        this.executing_agency=data.get(1);
        this.component_id=data.get(2);
        this.component_type=data.get(3);
        this.depends_on=data.get(4);
        this.budget_ratio=Double.parseDouble(data.get(5));


    }

    //    Project_id - Reference to project in projects.csv or proposals.csv
//    Executing_agency - Executing Agency
//    component_id    - Unique id of the component
//    Component_type - Type of the component
    private String project_id,executing_agency,component_id,component_type,depends_on;
    private Double budget_ratio;

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getExecuting_agency() {
        return executing_agency;
    }

    public void setExecuting_agency(String executing_agency) {
        this.executing_agency = executing_agency;
    }

    public String getDepends_on() {
        return depends_on;
    }

    public void setDepends_on(String depends_on) {
        this.depends_on = depends_on;
    }

    public Double getBudget_ratio() {
        return budget_ratio;
    }

    public void setBudget_ratio(Double budget_ratio) {
        this.budget_ratio = budget_ratio;
    }

    public String getComponent_id() {
        return component_id;
    }

    public void setComponent_id(String component_id) {
        this.component_id = component_id;
    }

    public String getComponent_type() {
        return component_type;
    }

    public void setComponent_type(String component_type) {
        this.component_type = component_type;
    }
}
