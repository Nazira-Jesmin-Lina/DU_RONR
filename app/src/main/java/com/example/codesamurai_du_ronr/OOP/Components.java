package com.example.codesamurai_du_ronr.OOP;

public class Components {
    public Components() {
    }

    //    Project_id - Reference to project in projects.csv or proposals.csv
//    Executing_agency - Executing Agency
//    component_id    - Unique id of the component
//    Component_type - Type of the component
    private String Project_id,Executing_agency,component_id,Component_type;

    public String getProject_id() {
        return Project_id;
    }

    public void setProject_id(String project_id) {
        Project_id = project_id;
    }

    public String getExecuting_agency() {
        return Executing_agency;
    }

    public void setExecuting_agency(String executing_agency) {
        Executing_agency = executing_agency;
    }

    public String getComponent_id() {
        return component_id;
    }

    public void setComponent_id(String component_id) {
        this.component_id = component_id;
    }

    public String getComponent_type() {
        return Component_type;
    }

    public void setComponent_type(String component_type) {
        Component_type = component_type;
    }
}
