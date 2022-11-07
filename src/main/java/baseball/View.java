package baseball;

public class View {
  public static void start() {
    System.out.println("숫자 야구 게임을 시작합니다.");
  }
  public static void waitInput() {
    System.out.println("숫자를 입력해주세요 : ");
  }
  public static void result(String userResult) {
    System.out.println(userResult);
  }
  public static void finish() {
    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력해주세요.");
  }
}
