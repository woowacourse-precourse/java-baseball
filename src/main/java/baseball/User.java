package baseball;
import camp.nextstep.edu.missionutils.Console;
import org.mockito.internal.matchers.Null;

public class User {

  int value;
  static String inputNumInString;

  User () {
  }

  public static String inputValue() {
    inputNumInString = Console.readLine();
    return (validateInput());
  }

  static String validateInput() {
    checkInputLength();
   // checkInputIsNum();


    System.out.println(inputNumInString);
    return inputNumInString;
  }

  private static void checkInputLength() {
    if (inputNumInString.length() != 3) {
      throw new IllegalArgumentException("input length is not three.");
    }
  }

  private static void checkInputIsNum() {
    for (int i = 0; i < 3; i++) {
      if (!(inputNumInString.charAt(i) >= '0' && inputNumInString.charAt(i) <= '9')) {
        throw new IllegalArgumentException("input contains things not number");
      }
    }


  }
  public static String inputValueTest(String testInput) {
    inputNumInString = testInput;
    return (validateInput());
    //return testInput;
  }
}
