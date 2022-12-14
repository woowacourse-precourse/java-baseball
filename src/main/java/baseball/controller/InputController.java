package baseball.controller;

import baseball.model.Player;
import baseball.view.InputView;

public class InputController {
    private final InputView inputView;

    public InputController(){
        inputView = new InputView();
    }
    // model ->  controller
    public  Player readyPlayer() {
        try {
            inputView.getInputMessage();
            Player player = new Player();
            String userInput = inputView.inputNumbers();
            player.setNumbers(userInput);
            return player;
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return new Player();
        }
    }

}
