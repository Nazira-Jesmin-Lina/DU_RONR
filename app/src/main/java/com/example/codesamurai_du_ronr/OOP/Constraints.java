package com.example.codesamurai_du_ronr.OOP;

import java.util.ArrayList;

public class Constraints
{
    private String code,constraint_type;
    private int max_limit;

    public Constraints() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getConstraint_type() {
        return constraint_type;
    }

    public void setConstraint_type(String constraint_type) {
        this.constraint_type = constraint_type;
    }

    public int getMax_limit() {
        return max_limit;
    }

    public void setMax_limit(int max_limit) {
        this.max_limit = max_limit;
    }

    public Constraints(ArrayList<String> data)
    {
        this.code=data.get(0);
        this.max_limit=Integer.parseInt(data.get(1));
        this.constraint_type=data.get(2);

    }



}
