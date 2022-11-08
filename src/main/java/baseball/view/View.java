package baseball.view;

public class View {

  public static void printGameStart() {
    System.out.println("숫자 야구 게임을 시작합니다.");
  }

  public static void printInputMyNumber() {
    System.out.print("숫자를 입력해주세요 : ");
  }

  public static void printBall(Integer ball) {
    System.out.println(ball + "볼");
  }

  public static void printStrike(Integer strike) {
    System.out.println(strike + "스트라이크");
  }

  public static void printNothing() {
    System.out.println("낫싱");
  }

  public static void printStrikeAndBall(Integer ball, Integer strike) {
    System.out.println(ball + "볼" + " " + strike + "스트라이크");
  }

  public static void printEndGame() {
    System.out.println("\"3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
  }
}
