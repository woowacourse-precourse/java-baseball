package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Console;

public class UserBallsInput {
  private int maxLen;

  public UserBallsInput() {
    this(3);
  }
  public UserBallsInput(int maxLen) {
    this.maxLen = maxLen;
  }
  public String inputNumber() {
    String buffer = Console.readLine();
    System.out.println(buffer);
    return buffer;
  }
  public void inputNumberTest(String input) {
//    if (!validityChecker(input)) {
//      throw new IllegalArgumentException();
//    }
    System.out.print(input);
  }
}