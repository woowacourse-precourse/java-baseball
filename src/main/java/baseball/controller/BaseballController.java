package baseball.controller;

import baseball.service.ComputerService;
import baseball.service.MessageService;
import baseball.service.PlayerService;

public class BaseballController {
    private static ComputerService computerService = new ComputerService();

    private static PlayerService playerService = new PlayerService();

    private static MessageService messageService = new MessageService();


    public static void gameStart(){
        boolean gameOn = true;
        int gameCount = 0;
        messageService.startGameMessage();
        while (gameOn) {
            if (gameOn && gameCount == 0) {
                initGame();
            }
            playerService.setPlayerNumber(playerService.inputPlayerNumber());
            messageService.ballCountMessage(playerService.checkBallCount(computerService.getComputerNumber()));
            gameCount += 1;
            if (playerService.checkBallCount(computerService.getComputerNumber()).get(1) == 3) {
                messageService.endGameMessage();
                messageService.restartGameMessage();
                gameOn = playerService.inputRestartAnswer();
                gameCount = 0;
            }
        }

    }

    public static void initGame(){
        computerService.setComputerNumber();
    }


}
