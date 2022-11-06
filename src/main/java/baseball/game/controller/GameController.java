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
        gameService.computeComputerNumbers();
    }
}
