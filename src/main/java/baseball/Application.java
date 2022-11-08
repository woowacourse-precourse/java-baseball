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
}
