package com.intelygenz.backendninja.model;

public class UserCredential {

    private String username;
    private String password;
    private String telefono;

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public UserCredential(String username, String password,String telefono) {
        this.username = username;
        this.password = password;
        this.telefono = telefono;
    }

    public UserCredential() {
    }

    @Override
    public String toString() {
        return "UserCredential{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
