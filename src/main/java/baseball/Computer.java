package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

  public List<Character> makeRandomNum() {
    char randNumChar;
    List<Character> characterList = new ArrayList<>();
    char tmp1 = oneRandomNumChar();
    characterList.add(tmp1);
    char tmp2 = 0;
    for (int i = 1; i < 3; i++) {
      randNumChar = oneRandomNumChar();
      while (i == 1 && randNumChar == tmp1) {
        randNumChar = oneRandomNumChar();
      }
      if (i == 1) {
        tmp2 = randNumChar;
      }
      while (i == 2 && (randNumChar == tmp1 || randNumChar == tmp2)) {
        randNumChar = oneRandomNumChar();
      }
      characterList.add(randNumChar);
    }
    return characterList;
  }

  private Character oneRandomNumChar() {
    return Character.forDigit(Randoms.pickNumberInRange(1, 9), 10);
  }
}
