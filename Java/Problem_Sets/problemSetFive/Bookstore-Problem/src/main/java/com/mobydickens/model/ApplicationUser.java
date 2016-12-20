/**
 * Created by Taras on 11/20/2016.
 */

package com.mobydickens.model;


public class ApplicationUser
{

    public Integer id;
    public String username;
    public String password;
    public Boolean isAdmin;

    public ApplicationUser() {}

    public ApplicationUser(Integer id, String username, String password, Boolean isAdmin)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }
}