package baseball;

public class PrintOut {
  public static void startMessage() {
    System.out.println("숫자 야구 게임을 시작합니다.");
  }

  public static void inputMessage() {
    System.out.println("숫자를 입력해주세요 : ");
  }

  public static void scoreMessage(int[] ballAndStrike) {
    if (ballAndStrike[0] != 0 && ballAndStrike[1] == 0) {
      System.out.println(ballAndStrike[0] + "볼");
    }
    if (ballAndStrike[0] == 0 && ballAndStrike[1] != 0) {
      System.out.println(ballAndStrike[1] + "스트라이크");
    }
    if (ballAndStrike[0] != 0 && ballAndStrike[1] != 0) {
      System.out.println(ballAndStrike[0] + "볼 " + ballAndStrike[1] + "스트라이크");
    }
    if (ballAndStrike[0] == 0 && ballAndStrike[1] == 0) {
      System.out.println("낫싱");
    }
  }

  public static void endMessage() {
    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
  }

  public static void continueMessage() {
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
  }
}
