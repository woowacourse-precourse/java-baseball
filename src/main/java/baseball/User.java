package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {

  int value;
  User () {
  }

  public static String inputValue() {

    return (validateInput("123"));
  }

  static String validateInput(String str) {
    if (str == "123") {
      System.out.println(str);
      return str;
    }
    System.out.println("EEE");
    return "EEE";
  }

}
