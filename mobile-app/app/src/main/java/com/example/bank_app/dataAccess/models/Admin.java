package com.example.bank_app.dataAccess.models;

public class Admin {

    private int id;
    private String password;

    public Admin(){
        this.id = 0;
        this.password = "def";
    }
    public Admin(int id, String password){
        this.id = id;
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
