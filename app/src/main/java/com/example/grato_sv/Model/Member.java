package com.example.grato_sv.Model;

public class Member {
    public String name;
    public String ID;

    public Member(String name,String ID){
        this.name = name;
        this.ID = ID;
    }

    public void setName(String _name){
        this.name = _name;
    }
    public String getName(){
        return this.name;
    }

    public void setID(String _ID){
        this.ID = _ID;
    }
    public String getID(){
        return this.ID;
    }
}
