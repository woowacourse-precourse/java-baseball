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
    do {
      startGame();
    } while (doRetry());
  }

  private void beforeGameStart() {
    printGameStartMessage();
  }

  private void startGame() {
    boolean isPlayerWin = false;
    while (!isPlayerWin) {
      List<Integer> guessedNumber = player.guessNumber();
      isPlayerWin = computer.getPlayerWinOrNotAndPrintResult(guessedNumber);
    }
    printGameOverMessage();
  }

  private boolean doRetry() {
    printRetryOrExitMessage();
    if (player.selectRetryOrExit()) {
      computer.resetAnswer();
      return true;
    }
    return false;
  }

  private void printGameStartMessage() {
    System.out.println("숫자 야구 게임을 시작합니다.");
  }

  private void printGameOverMessage() {
    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
  }

  private void printRetryOrExitMessage() {
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
  }
}
