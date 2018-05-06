package com.example.rbc.web.controller;

import com.example.rbc.web.model.Robot;
import com.example.rbc.web.service.RobotServiceImpl;
import com.google.gson.Gson;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import java.nio.charset.Charset;
import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Nico on 22/03/2018.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(RobotController.class)
@Ignore
public class RobotControllerTest {

  private final static String SERVICE_URL = "/api/v1/robot";

  private final Robot robotStub1 = new Robot("Robot1", 1.5);

  private final Robot robotStub2 = new Robot("Robot2", 2.5);

  private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private RobotServiceImpl robotService;

  @Test
  public void findAllRobotsTest() throws Exception {

    when(robotService.findAll()).thenReturn(Arrays.asList(robotStub1, robotStub2));
    this.mockMvc.perform(get(SERVICE_URL))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(contentType))
        .andExpect(jsonPath("$[0].name", is("Robot1")))
        .andExpect(jsonPath("$[0].price", is(1.5)))
        .andExpect(jsonPath("$[1].name", is("Robot2")))
        .andExpect(jsonPath("$[1].price", is(2.5)));

  }

  @Test
  public void addRobotsTest() throws Exception {

    when(robotService.create(any(Robot.class))).thenReturn(robotStub1);

    Gson gson = new Gson();

    this.mockMvc.perform(
        post(SERVICE_URL).
        contentType(MediaType.APPLICATION_JSON)
        .content(gson.toJson(robotStub1))
       )
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(contentType))
        .andExpect(jsonPath("name", is("Robot1")))
        .andExpect(jsonPath("price", is(1.5)));

  }






}







