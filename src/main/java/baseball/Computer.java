package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Computer {

  private static String RandomValue;

  private static void printGameStart() {
    System.out.println("숫자 야구 게임을 시작합니다.");
  }

  private static void printInputNumber() {
    System.out.print("숫자를 입력해주세요 : ");
  }

  private static void printCalculateResult(String calculatedResult) {
    System.out.println(calculatedResult);
  }
  private static String generateRandom() {
    StringBuilder sb = new StringBuilder();
    ArrayList<Integer> generateRandNum = new ArrayList<>();

    while (generateRandNum.size() < 3) {
      int randomNumber = Randoms.pickNumberInRange(1, 9);
      if (!generateRandNum.contains(randomNumber)) {
        generateRandNum.add(randomNumber);
        sb.append(Integer.toString(randomNumber));
      }
    }

    RandomValue = sb.toString();
    return RandomValue;
  }

  public static String testComputerPrint(int mode, String input) {
    if (mode == 1) {
      printGameStart();
    }
    if (mode == 2) {
      printInputNumber();
    }
    if (mode == 3) {
      return generateRandom();
    }
    if (mode == 4) {
      printCalculateResult(input);
    }
    return "";
  }
}
