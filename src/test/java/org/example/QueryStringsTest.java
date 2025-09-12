package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QueryStringsTest {

  @Test
  void createTest() {
    QueryStrings queryStrings = new QueryStrings("operand1=3&operator=*&operand2=10");

    assertThat(queryStrings).isNotNull();
  }
}
