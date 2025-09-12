package org.example;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class QueryStrings {
  private final List<QueryString> queryStrings = new ArrayList<>();

  public QueryStrings(String queryStringLine) {
    String[] queryStringTokens = queryStringLine.split("&");

    Arrays.stream(queryStringTokens)
            .forEach(queryString -> {
              String[] values = queryString.split("=");
              if (values.length != 2) {
                throw new IllegalArgumentException("Invalid query string");
              }

              String decodedKey = URLDecoder.decode(values[0], StandardCharsets.UTF_8);
              String decodedValue = URLDecoder.decode(values[1], StandardCharsets.UTF_8);

              queryStrings.add(new QueryString(decodedKey, decodedValue));
            });
  }

  public String getValue(String key) {
    return this.queryStrings.stream()
            .filter(queryString -> queryString.exists(key))
            .map(QueryString::getValue)
            .findFirst()
            .orElse(null);
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    QueryStrings that = (QueryStrings) o;
    return Objects.equals(queryStrings, that.queryStrings);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(queryStrings);
  }
}
