package baseball;

import camp.nextstep.edu.missionutils.Console;

public class EndOrRe {

  public Integer readAndMakeInputList() {
    String inputString = Console.readLine();
    validOneOrTwo(inputString);
    return stringToInt(inputString);
  }

  // 테스트용 메소드
  public void printInputString(String inputString) {
    validOneOrTwo(inputString);
    System.out.println(stringToInt(inputString));
  }

  private Integer stringToInt(String inputString) {
    return Integer.valueOf(inputString);
  }

  private void validOneOrTwo(String inputString) {
    if (!inputString.equals("1") && !inputString.equals("2")) {
      throw new IllegalArgumentException();
    }
  }
}
