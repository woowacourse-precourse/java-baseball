package baseball.input;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputReader implements InputReader {

  @Override
  public String readLine() {
    printInputMessage();
    return Console.readLine();
  }

  private void printInputMessage() {
    System.out.print("숫자를 입력해주세요 : ");
  }
}
