package com.example.bank_app.dataAccess.models;

public class User {

    private int id;
    private String name;
    private int password;

    public User(){
        this.id = 0;
        this.name = "def";
        this.password = 0;
    }
    public User (int id, String nombre, int password){
        this.id = id;
        this.name = nombre;
        this.password = password;
    }


    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
