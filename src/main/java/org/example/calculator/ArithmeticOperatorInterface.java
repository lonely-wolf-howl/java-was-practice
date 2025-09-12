package org.example.calculator;

public interface ArithmeticOperatorInterface {
  boolean supports(String operator);

  int calculate(PositiveNumber a, PositiveNumber b);
}
