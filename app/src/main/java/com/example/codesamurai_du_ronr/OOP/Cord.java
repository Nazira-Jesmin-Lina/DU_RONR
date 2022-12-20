package com.example.codesamurai_du_ronr.OOP;

public class Cord {
    public String loc;
    public Double lat,lang;
    public Cord(String loc,String lat, String lang){
        this.loc=loc;
        this.lat=Double.parseDouble(lat);
        this.lang=Double.parseDouble(lang);
    }
}
