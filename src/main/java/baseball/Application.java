package baseball;

import baseball.controller.GameController;
import baseball.service.InputService;

public class Application {

  private static final InputService inputService = new InputService();

  public static void main(String[] args) {
    // TODO: 프로그램 구현
    do {
      GameController gameController = new GameController();
      gameController.play();
    } while (inputService.DoesPlayerWantToRestart());
  }
}
