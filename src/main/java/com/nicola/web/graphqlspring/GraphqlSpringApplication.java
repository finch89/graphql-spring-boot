package com.nicola.web.graphqlspring;

import graphql.Scalars;
import graphql.schema.DataFetcher;
import graphql.schema.FieldCoordinates;
import graphql.schema.GraphQLCodeRegistry;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import java.util.concurrent.CompletableFuture;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ConfigurationPropertiesScan
public class GraphqlSpringApplication {

  public static void main(String[] args) {
    SpringApplication.run(GraphqlSpringApplication.class, args);
  }

  @Bean
  GraphQLSchema schema() {
    DataFetcher<CompletableFuture<String>> test =
      env ->
        CompletableFuture.supplyAsync(
          () -> {
            try {
              Thread.sleep(2000);
            } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
            }
            return "response";
          });
    return GraphQLSchema.newSchema()
      .query(
        GraphQLObjectType.newObject()
          .name("query")
          .field(field -> field.name("test").type(Scalars.GraphQLString))
          .build())
      .codeRegistry(
        GraphQLCodeRegistry.newCodeRegistry()
          .dataFetcher(FieldCoordinates.coordinates("query", "test"), test)
          .build())
      .build();
  }
}
