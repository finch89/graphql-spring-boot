package com.nicola.web.graphqlspring.configuration;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@ConfigurationProperties(prefix = "persistence")
@Validated
public class PersistenceConfig {
  @NotNull
  private Sql sql;
  @NotNull
  private Mongo mongo;

  @Getter
  @Setter
  public static class Sql {
    @NotBlank
    private String host;
  }

  @Getter
  @Setter
  public static class Mongo {
    @NotBlank
    private String host;
  }
}
