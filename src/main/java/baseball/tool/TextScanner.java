package baseball.tool;

import baseball.dataStorage.DataStorage;
import camp.nextstep.edu.missionutils.Console;
import java.util.Scanner;

public class TextScanner {

  //사용자로부터 3자리 숫자를 입력받는 메서드
  public static void scanAnswer() throws IllegalArgumentException {
    String inputString;
    inputString = Console.readLine();
    System.out.println(inputString);
    int num;
    if (inputString != null && inputString.matches("[1-9]{3}")
        && !checkDuplication(inputString)) {
      num = Integer.parseInt(inputString);
      DataStorage.storeAnswer(num);  //input된 number를 배열로 저장
    } else {
      throw new IllegalArgumentException();
    }
  }

  public static boolean checkDuplication(String input) {
    if (input.charAt(0) != input.charAt(1) && input.charAt(1) != input.charAt(2)
        && input.charAt(0) != input.charAt(2)) {
      return false;
    }
    return true;
  }

  //게임이 끝난 후 사용자로부터 재시작 또는 종료 코드를 입력받는 메서드
  public static Signal scanSignal() throws IllegalArgumentException {
    String signalCode = Console.readLine();

    if (signalCode != null && signalCode.matches("[1-2]")) {
      if (Integer.parseInt(signalCode) == 1) {
        return Signal.NEWGAME;
      } else {
        return Signal.QUIT;
      }
    } else {
      throw new IllegalArgumentException();
    }
  }
}
