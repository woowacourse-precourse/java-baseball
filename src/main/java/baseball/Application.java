package baseball;

import baseball.controller.GameController;
import baseball.service.InputService;

public class Application {

  private static final InputService inputService = new InputService();

  public static void main(String[] args) {
    // TODO: 프로그램 구현
    do {
      GameController gameController = new GameController();
      System.out.println("숫자 야구 게임을 시작합니다.");
      gameController.play();
    } while (inputService.doesPlayerWantToRestart());
  }
}
