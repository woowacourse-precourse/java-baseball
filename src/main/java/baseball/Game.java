package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {

  private static final boolean CORRECT = true;
  private static final int RANDOM_NUMBERS_LENGTH = 3;

  public Answer createAnswer() {
    List<Character> randomNumbers = new ArrayList<>();
    while (randomNumbers.size() < RANDOM_NUMBERS_LENGTH) {
      Character randomNumber =
          Character.forDigit(Randoms.pickNumberInRange(1, 9), 10);
      if (!randomNumbers.contains(randomNumber)) {
        randomNumbers.add(randomNumber);
      }
    }
    return new Answer(randomNumbers);
  }

  public boolean end() {
    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    return CORRECT;
  }
}
