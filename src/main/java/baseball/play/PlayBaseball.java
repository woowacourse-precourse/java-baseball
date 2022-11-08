package baseball.play;

import baseball.service.ComputerService;
import baseball.service.MessageService;
import baseball.service.PlayerService;

public class PlayBaseball {

    private static ComputerService computerService = new ComputerService();

    private static PlayerService playerService = new PlayerService();

    private static MessageService messageService = new MessageService();


    public static void main(String[] args) {
        boolean gameOn = true;
        messageService.startGameMessage();
        initGame();
        while (gameOn) {
            playerService.setPlayerNumber(playerService.inputPlayerNumber());
            messageService.ballCountMessage(playerService.checkBallCount(computerService.getComputerNumber()));
            if (playerService.checkBallCount(computerService.getComputerNumber()).get(1) == 3) {
                messageService.endGameMessage();
                messageService.restartGameMessage();
                gameOn = playerService.inputRestartAnswer();
                initGame();
            }
        }
    }

    public static void initGame(){
        computerService.setComputerNumber();
    }
}
