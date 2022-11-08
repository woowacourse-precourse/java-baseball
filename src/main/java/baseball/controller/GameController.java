package baseball.controller;

import baseball.service.GameService;
import baseball.view.Output;
import baseball.view.PlayerInput;

import java.util.List;

public class GameController {
    public void play(){
        Output.startMessage();
        List<Integer> playerNumber;
        List<Integer> computerNumber = GameService.makeComputerNumber();
        GameService.isContinue=true;

        while (GameService.isContinue) {

            try {
                playerNumber = PlayerInput.inputPlayerNumber();
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException();
            }

            if (GameService.compareAnswer(playerNumber, computerNumber)) {
                GameService.isContinue = PlayerInput.inputContinue();
                computerNumber = GameService.makeComputerNumber();
            }
        }
    }

}
