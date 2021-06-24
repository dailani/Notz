/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.notez.modell;

/**
 *
 * @author Dailan´s PC
 */
public class User {
    
    private int idusers;
    private String username;
    private String password;
    
    public User(){};
    
    public User(String username){
        this.username = username;
    }
    
    public User(String username , String password){
        this.username=username;
        this.password=password;
    }
    
    public User(int idusers,String username , String password){
        this.idusers=idusers;
        this.username=username;
        this.password=password;
    }

    /**
     * @return the idusers
     */
    public int getIdusers() {
        return idusers;
    }

    /**
     * @param idusers the idusers to set
     */
    public void setIdusers(int idusers) {
        this.idusers = idusers;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
