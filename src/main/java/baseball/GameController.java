package baseball;

import baseball.service.GameSettingService;
import baseball.service.ProgressGameService;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameController {

    private GameSettingService gameSettingService;
    private ProgressGameService progressGameService;

    public GameController() {
        gameSettingService = new GameSettingService();
        progressGameService = new ProgressGameService();
    }

    public void startGame() {
        boolean replayGame = true;
        while(replayGame){
            List<Integer> computerAnswer = gameSettingService.generateRandomThreeNumbers();
            progressGameService.playGame(computerAnswer);
            replayGame = progressGameService.endGame();
        }
    }
}