package com.example.rbc.web.controller;

import com.example.rbc.web.controller.exceptions.RobotNotFoundException;
import com.example.rbc.web.model.Robot;
import com.example.rbc.web.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by Nico on 22/03/2018.
 */

@RestController
@RequestMapping({"/api/v1/robot"})
public class RobotController {

  private final RobotService robotService;

  @Autowired
  public RobotController(RobotService robotService) {
    this.robotService = robotService;
  }

  @PostMapping
  public Robot create(@RequestBody Robot robot){
    return robotService.create(robot);
  }

  @GetMapping(path = {"/{id}"})
  public Robot findOne(@PathVariable("id") long id){
    Optional<Robot> robot = robotService.findById(id);

    if(robot.isPresent()){
      return robot.get();
    } else {
      throw  new RobotNotFoundException(id);
    }

  }

  @DeleteMapping(path ={"/{id}"})
  public Robot delete(@PathVariable("id") long id) {
    Optional<Robot> robot = robotService.delete(id);

    if(robot.isPresent()){
      return robot.get();
    } else {
      throw  new RobotNotFoundException(id);
    }
  }

  @PutMapping
  public Robot update(@RequestBody Robot robot){
    return robotService.update(robot);
  }

  @GetMapping
  public List findAll(){
    return robotService.findAll();
  }


}
