package com.example.codesamurai_du_ronr.OOP;

import java.util.ArrayList;

public class Agencies {
    public Agencies() {
    }
    public Agencies(ArrayList<String> data) {
        this.code=data.get(0);
        this.name=data.get(1);
        this.type=data.get(2);
        this.desc=data.get(3);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    //    Code - Shortcode for the agency
//    Name - Name of the agency
//    Type - Type of the agency
//    Description - Description of the objective of the agency
    public String code,name,type,desc;

}
