package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Console;

public class Game {
  public static String toBeContinued = "1";
  public Game() {
    this(toBeContinued);
  }
  public Game(String toBeContinued) {
    this.toBeContinued = toBeContinued;
  }

  public String generateNumber() {
    String inputNumber = Console.readLine();
    if (!validityChecker(inputNumber)) {
      throw new IllegalArgumentException("1, 또는 2를 입력해야 합니다.");
    }
    return inputNumber;
  }

//  forTest
  public void generateNumberTest(String input) {
    if (!validityChecker(input)) {
      throw new IllegalArgumentException();
    }
    System.out.print(input);
  }

  public boolean validityChecker(String input) {
    return input == "1" || input == "2";
  }

  public void setRestart() {
//    3개의 숫자를 모두 맞히셨습니다! 게임 종료
//    게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
    this.toBeContinued = generateNumber();
  }
}
