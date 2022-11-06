package baseball.controller;

import baseball.SystemMessage;
import baseball.service.GameService;
import camp.nextstep.edu.missionutils.Console;

public class GameController {
    private GameService gameService = new GameService();

    public void run() {
        start();
        end();
    }

    private void start() {
        SystemMessage.printStartMessage();
        gameService.start();
    }

    private void end(){
        SystemMessage.printEndMessage();
    }
}
