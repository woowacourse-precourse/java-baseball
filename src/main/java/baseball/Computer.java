package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

  public List<Character> makeRandomNum() {
    List<Character> characterList = new ArrayList<>();

    char index0Value = oneRandomNumChar();
    characterList.add(index0Value);
    return compareAndAddList(characterList, index0Value);
  }

  private List<Character> compareAndAddList(List<Character> characterList, char index0Value) {
    char randNumChar;
    char index1Value = 0;

    for (int i = 1; i < 3; i++) {
      randNumChar = oneRandomNumChar();
      while (i == 1 && randNumChar == index0Value) {
        randNumChar = oneRandomNumChar();
      }
      if (i == 1) {
        index1Value = randNumChar;
      }
      while (i == 2 && (randNumChar == index0Value || randNumChar == index1Value)) {
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
