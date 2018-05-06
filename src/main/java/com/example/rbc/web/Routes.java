package com.example.rbc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Routes {

  @RequestMapping(value = "/app/**")
  public String redirect() {
    return "forward:/";
  }

}
