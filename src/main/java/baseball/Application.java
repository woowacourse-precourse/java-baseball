package baseball;

import baseball.gameController.GameController;

public class Application {

  static GameController controller = new GameController();

  public static void main(String[] args) {
      controller.BaseballGame();
  }
}
