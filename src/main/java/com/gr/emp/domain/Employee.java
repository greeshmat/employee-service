package com.gr.emp.domain;

public  class Employee  {
    private int id;
    private String name;
       
    public void setId(int id){
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
   
    public int getId() { return id; }
    public String getName() { return name;}
    
    public String toString() {
        return " Id is " + id + " and name is " + name;
    }
    
}
