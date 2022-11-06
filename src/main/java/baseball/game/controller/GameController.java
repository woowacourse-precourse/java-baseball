package baseball.game.controller;

import baseball.game.service.GameService;
import baseball.game.view.InputView;
import baseball.game.view.OutputView;

public class GameController {
    private final OutputView outputView;
    private final InputView inputView;
    private final GameService gameService;

    public GameController() {
        outputView=new OutputView();
        inputView=new InputView();
        gameService=new GameService();
    }

    public void play() {
        outputView.printGameStart();

        while(true) {//종료 조건 걸어야함
            gameService.computeComputerNumbers();

            String userNumbers=inputView.inputNumbers();
            gameService.verifyNumberOfInput(userNumbers);

            break;
        }
    }
}
