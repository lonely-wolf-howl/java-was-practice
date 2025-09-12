package org.example.calculator;

import org.example.calculator.operator.AdditionOperator;
import org.example.calculator.operator.DivisionOperator;
import org.example.calculator.operator.MultiplicationOperator;
import org.example.calculator.operator.SubtractionOperator;

import java.util.List;

public class Calculator {
  private static final List<ArithmeticOperatorInterface> arithmeticOperators = List.of(
          new AdditionOperator(),
          new SubtractionOperator(),
          new MultiplicationOperator(),
          new DivisionOperator());

  public static int calculate(PositiveNumber a, String operator, PositiveNumber b) {
    return arithmeticOperators.stream()
            .filter(arithmeticOperator -> arithmeticOperator.supports(operator))
            .map(arithmeticOperator -> arithmeticOperator.calculate(a, b))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Invalid arithmetic operation."));
  }
}
