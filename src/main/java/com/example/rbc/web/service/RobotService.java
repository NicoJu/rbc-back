package com.example.rbc.web.service;

import com.example.rbc.web.model.Robot;

import java.util.List;
import java.util.Optional;

/**
 * Created by Nico on 22/03/2018.
 */
public interface RobotService {

  public Robot create(Robot robot);
  public Robot  update(Robot robot);
  public Optional<Robot>  delete(Long id);
  public List<Robot> findAll();
  public Optional<Robot> findById(Long id);

}
