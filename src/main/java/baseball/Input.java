package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {

  private static final int STRINGLEN = 3;

  public List<Character> readAndMakeInputList() {
    String inputString = Console.readLine();
    validStringLength(inputString);
    return stringToList(inputString);
  }

  // 테스트용 메소드
  public void printInputString(String inputString) {
    validStringLength(inputString);
    System.out.println(stringToList(inputString)); // [1, 2, 3]
  }

  private List<Character> stringToList(String inputString) {
    List<Character> list = new ArrayList<>();
    for (int i = 0; i < inputString.length(); i++) {
      list.add(inputString.charAt(i));
    }
    validOnlyOneNumInList(list);
    validNumElementAndNoZero(list);
    return list;
  }

  private void validStringLength(String inputString) {
    if (inputString.length() != STRINGLEN) {
      throw new IllegalArgumentException(inputString + "은 3자리가 아닙니다.");
    }
  }

  private void validOnlyOneNumInList(List<Character> list) {
    if (list.get(0) == list.get(1) || list.get(1) == list.get(2) || list.get(0) == list.get(2)) {
      throw new IllegalArgumentException("중복이 있습니다.");
    }
  }

  private void validNumElementAndNoZero(List<Character> list) {
    for (Character character : list) {
      if (character < '1' || '9' < character) {
        throw new IllegalArgumentException("1에서 9까지만 가능합니다.");
      }
    }
  }
}
