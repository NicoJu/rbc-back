package com.example.rbc.web.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Nico on 22/03/2018.
 */

@Entity
@ToString @EqualsAndHashCode
public class Robot {

  @Id
  @GeneratedValue
  private Long id;

  private @NonNull String name;
  private @NonNull Double price;
  private @NonNull String description;

  public Robot() {
  }

  public Robot(String name, Double price) {
    this.name = name;
    this.price = price;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }
}
