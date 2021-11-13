package com.nicola.web.graphqlspring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class SpringBootExampleIT {
  @Autowired
  private TestRestTemplate template;

  @Test
  void getHello() {
    ResponseEntity<String> responseEntity = template.getForEntity("/", String.class);
    assertThat(responseEntity.getBody()).isEqualTo(SpringBootExample.EXAMPLE_MESSAGE);
  }
}
