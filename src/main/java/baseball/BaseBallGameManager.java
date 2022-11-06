package baseball;

public class BaseBallGameManager {

  public void runGame() {
    beforeGameStart();
  }

  private void beforeGameStart() {
    printGameStartMessage();
  }

  private void printGameStartMessage() {
    System.out.println("숫자 야구 게임을 시작합니다.");
  }
}
