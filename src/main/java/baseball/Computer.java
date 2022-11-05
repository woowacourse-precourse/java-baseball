package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Computer {

  public static String RandomValue;

  Computer () {
    RandomValue = generateRandom();
    //printGameStart();
    //printInputNumber();
  }

  public static void printGameStart() {
    System.out.println("숫자 야구 게임을 시작합니다.");
  }

  public static void printInputNumber() {
    System.out.print("숫자를 입력해주세요 : ");
  }

  public static void printEndingMessage() {
    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
  }
  public static String printCalculateResult(String calculatedResult) {
    System.out.println(calculatedResult);
    return calculatedResult;
  }
  public static String generateRandom() {
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
