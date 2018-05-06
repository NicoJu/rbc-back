package com.example.rbc.web.auth.jwt;

/**
 * Created by Nico on 12/04/2018.
 */

public class AccountCredentials {

  private String username;
  private String password;
  // getters & setters

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
}