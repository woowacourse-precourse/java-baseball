package baseball;

import java.util.List;

public class BaseBallGameManager {

  private Computer computer;
  private Player player;

  public BaseBallGameManager(Computer computer, Player player) {
    this.computer = computer;
    this.player = player;
  }

  public void runGame() {
    beforeGameStart();
    startGame();
  }

  private void startGame() {
    List<Integer> guessedNumber = player.guessNumber();
  }

  private void beforeGameStart() {
    printGameStartMessage();
  }

  private void printGameStartMessage() {
    System.out.println("숫자 야구 게임을 시작합니다.");
  }
}
