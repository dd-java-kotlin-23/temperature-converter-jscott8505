package edu.cnm.deepdive;

import java.util.Scanner;

public class Main {

  void main(String[] args) {
    // DONE: 6/2/26 Set initial conversion mode to Celsius-to-Fahrenheit.
    Mode mode = Mode.CELSIUS_TO_FAHRENHEIT;
    Converter converter = new Converter();
    // DONE: 6/2/26 Start reading from standard input.
    Scanner scanner = new Scanner(System.in);
    // TODO: 6/2/26 While there is any input remaining to process;
    while (scanner.hasNext()) {
      if (scanner.hasNextDouble()) {
        double input = scanner.nextDouble();
        double output = mode == Mode.CELSIUS_TO_FAHRENHEIT
            ? converter.convertC2F(input)
            : converter.convertF2C(input);
        // TODO: 6/2/26 Print conversion mode, inout, output.
        System.out.println("input = " + input + "; output = " + output);
      } else {
        String input = scanner.next();
        char modeFlag = Character.toUpperCase(input.strip().charAt(0));
        mode = switch (modeFlag) {
          case 'C'-> Mode.CELSIUS_TO_FAHRENHEIT;
          case 'F' -> Mode.FAHRENHEIT_TO_CELSIUS;
            default -> {
              System.err.println("Invalid input:" + input);
              // TODO: Print error message to standard error
              yield mode;
            }
        };

      }
    }
    // DONE: 6/2/26 1. Get next input token.
    //                 a. if token is a number, convert according to the current mode, and output mode to standard output
    //                 b. if token is 'F', switch mode to Fahrenheit-to-Celsius for subsequent conversions.
    //                 c. if token is 'C', switch mode to Celsius-to-Fahrenheit for subsequent conversions.
    //                 d. if token is anything else, write error message to standard error.
  }

  private enum Mode {
    CELSIUS_TO_FAHRENHEIT, FAHRENHEIT_TO_CELSIUS
  }

}
