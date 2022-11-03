package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {

  int value;
  static String inputNumInString;

  User () {

  }
  public static String inputValue() {
    inputNumInString = readLine();
    return (validateInput());
  }

  static String validateInput() {
    checkInputIsNum();

//    if (str == "123") {
//      System.out.println(str);
//      return str;
//    }
//    System.out.println("EEE");
    return inputNumInString;
  }

  static void checkInputIsNum() {
    try {
      int number = Integer.parseInt(inputNumInString);
    } catch (NumberFormatException ex) {
      ex.printStackTrace();
    }
  }
}
