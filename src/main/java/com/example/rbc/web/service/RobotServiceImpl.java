package com.example.rbc.web.service;

import com.example.rbc.web.model.Robot;
import com.example.rbc.web.model.RobotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Nico on 22/03/2018.
 */
@Service
public class RobotServiceImpl implements RobotService {

  private final RobotRepository robotRepository;

  @Autowired
  public RobotServiceImpl(RobotRepository robotRepository) {
    this.robotRepository = robotRepository;
  }

  @Override
  public Robot create(Robot robot) {
    return robotRepository.save(robot);
  }

  @Override
  public Robot update(Robot robot) {
    return robotRepository.save(robot);
  }

  @Override
  public Optional<Robot> delete(Long id) {
    Optional<Robot> robot = findById(id);

    if(robot.isPresent()){
        robotRepository.delete(robot.get());
    }

    return robot;
  }

  @Override
  public List<Robot> findAll() {
    return robotRepository.findAll();
  }

  @Override
  public Optional<Robot> findById(Long id) {
    return robotRepository.findById(id);
  }

}
