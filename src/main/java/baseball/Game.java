package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;

public class Game {
  private static String toBeContinued = "1";
  public Game() {
    this(toBeContinued);
  }
  public Game(String toBeContinued) {
    Game.toBeContinued = toBeContinued;
  }

  public String generateNumber() {
    String inputNumber = Console.readLine();
    if (validityChecker(inputNumber)) {
      throw new IllegalArgumentException("1, 또는 2를 입력해야 합니다.");
    }
    return inputNumber;
  }
  // 최종적으로 게임을 돌리는 기능. 마지막에 완성
  public void run() {
     do {

     } while (Objects.equals(toBeContinued, "1"));
  }

//  forTest
  public void generateNumberTest(String input) {
    if (validityChecker(input)) {
      throw new IllegalArgumentException();
    }
    System.out.print(input);
  }

  public boolean validityChecker(String input) {
    return !Objects.equals(input, "1") && !Objects.equals(input, "2");
  }

  public void setRestart() {
//    3개의 숫자를 모두 맞히셨습니다! 게임 종료
//    게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
    toBeContinued = generateNumber();
  }
}
