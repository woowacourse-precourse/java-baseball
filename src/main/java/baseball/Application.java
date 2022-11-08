package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class Application {
  static final int digit = 3;
  static final int startInclusive = 1;
  static final int endInclusive = 9;

  public static void main(String[] args) {
    Application numberBaseBallGame = new Application();
    numberBaseBallGame.startGame();
  }

  public void startGame() {
    System.out.println("숫자 야구 게임을 시작합니다.");
    List<Integer> computer = initComputer();

    while (true) {
      String userInput = enterNumber();
      checkCorrectInput(userInput);

    }
  }

  public List<Integer> initComputer() {
    List<Integer> computer = new ArrayList<>();

    while (computer.size() < digit) {
      int randomNumber = Randoms.pickNumberInRange(startInclusive, endInclusive);
      if (!computer.contains(randomNumber)) {
        computer.add(randomNumber);
      }
    }

    return computer;
  }

  public String enterNumber() {
    System.out.print("숫자를 입력해주세요 : ");
    String userInput = Console.readLine();
    return userInput;
  }

  public void checkCorrectInput(String userInput) {
    if (userInput.length() != digit) {
      throw new IllegalArgumentException("입력 길이가 초과되어 종료합니다.");
    }

    List<Integer> userInputList = new ArrayList<>();
    String[] numbers = userInput.split("");

    for (int i = 0; i < digit; i++) {
      try {
        int number = Integer.parseInt(numbers[i]);
        if (!((number < 49) || (number > 57))) {
          throw new IllegalArgumentException("숫자가 아닌 입력이므로 종료합니다.");
        } else if (userInputList.contains(number)) {
          throw new IllegalArgumentException("중복된 숫자가 존재하므로 종료합니다.");
        }
        userInputList.add(number);
      } catch (NumberFormatException e) {
        throw new IllegalArgumentException("숫자가 아닌 입력이므로 종료합니다.");
      }
    }
  }
}
