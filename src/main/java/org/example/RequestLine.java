package org.example;

import java.util.Objects;

public class RequestLine {
  private final String httpMethod;
  private final String urlPath;
  private QueryStrings queryStrings;

  public RequestLine(String httpMethod, String urlPath, String queryStrings) {
    this.httpMethod = httpMethod;
    this.urlPath = urlPath;
    this.queryStrings = new QueryStrings(queryStrings);
  }

  public RequestLine(String requestLine) {
    String[] tokens = requestLine.split(" ");
    this.httpMethod = tokens[0];

    String[] urlPathTokens = tokens[1].split("\\?");
    this.urlPath = urlPathTokens[0];

    if (urlPathTokens.length == 2) {
      this.queryStrings = new QueryStrings(urlPathTokens[1]);
    }
  }

  public boolean isGetRequest() {
    return "GET".equals(this.httpMethod);
  }

  public boolean matchPath(String requestPath) {
    return urlPath.equals(requestPath);
  }

  public QueryStrings getQueryStrings() {
    return this.queryStrings;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    RequestLine that = (RequestLine) o;
    return Objects.equals(httpMethod, that.httpMethod) && Objects.equals(urlPath, that.urlPath) && Objects.equals(queryStrings, that.queryStrings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(httpMethod, urlPath, queryStrings);
  }
}
