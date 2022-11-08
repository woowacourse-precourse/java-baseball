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
            inputPlayerNumber();
            showBallCount();
            gameCount += 1;
            if ( checkStrikeNumber() == 3) {
                gameOn = confirmGameRestart();
                gameCount = 0;
            }
        }

    }
    public static boolean confirmGameRestart(){
        messageService.endGameMessage();
        messageService.restartGameMessage();
        return playerService.inputRestartAnswer();
    }

    public static int checkStrikeNumber() {
        return playerService.checkBallCount(computerService.getComputerNumber()).get(1);
    }

    public static void inputPlayerNumber(){
        playerService.setPlayerNumber(playerService.inputPlayerNumber());
    }
    public static void showBallCount(){
        messageService.ballCountMessage(playerService.checkBallCount(computerService.getComputerNumber()));
    }


    public static void initGame(){
        computerService.setComputerNumber();
    }


}
