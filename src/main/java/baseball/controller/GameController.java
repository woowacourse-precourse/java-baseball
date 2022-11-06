package baseball.controller;

import baseball.system.SystemValue;
import baseball.system.SystemMessage;
import baseball.service.GameService;
import camp.nextstep.edu.missionutils.Console;

public class GameController {
    private GameService gameService = new GameService();

    public void run() {
        start();
        end();
        retry();
    }

    private void start() {
        SystemMessage.printStartMessage();
        gameService.start();
    }

    private void end(){
        SystemMessage.printEndMessage();
    }

    private void retry(){
        SystemMessage.printRetryMessage();
        int inputRetry = getCorrectRetryNumber();

        if (inputRetry == SystemValue.GAME_RESTART_KEY){
            run();
        }
    }

    private int getCorrectRetryNumber(){
        int number = Integer.parseInt(Console.readLine());

        if (number < SystemValue.GAME_RESTART_KEY || number > SystemValue.GAME_END_KEY){
            throw new IllegalArgumentException();
        }
        return number;
    }
}
