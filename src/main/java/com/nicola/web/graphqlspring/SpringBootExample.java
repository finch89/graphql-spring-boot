package com.nicola.web.graphqlspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootExample {

  static final String EXAMPLE_MESSAGE = "Hello Spring Boot!";

  @GetMapping("/")
  public String index() {
    return EXAMPLE_MESSAGE;
  }
}
