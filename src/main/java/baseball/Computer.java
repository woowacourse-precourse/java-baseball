package baseball;

public class Computer {
  private static String RandonValue;

  private static void printGameStart() {
    System.out.println("숫자 야구 게임을 시작합니다.");
  }

  private static void printInputNumber() {
    System.out.print("숫자를 입력해주세요 : ");
  }

  public static void testComputerPrint(int mode) {
    if (mode == 1) printGameStart();
    if (mode == 2) printInputNumber();
  }


}
