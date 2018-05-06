package com.example.rbc.web.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Nico on 22/03/2018.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RobotNotFoundException  extends RuntimeException  {

  public RobotNotFoundException(Long robotId) {
    super("could not find user '" + robotId + "'.");
  }

}
