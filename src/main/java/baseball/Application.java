package baseball;

import baseball.controller.GameController;
import baseball.service.InputService;
import baseball.service.hint.HintService;

public class Application {

  public static void main(String[] args) {
    // TODO: 프로그램 구현
    InputService inputService = new InputService();
    HintService hintService = new HintService();
    do {
      GameController gameController = new GameController(inputService, hintService);
      System.out.println("숫자 야구 게임을 시작합니다.");
      gameController.play();
    } while (inputService.doesPlayerWantToRestart());
  }
}
