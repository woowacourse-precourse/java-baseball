package baseball.controller;

import baseball.model.Player;
import baseball.view.InputView;
import baseball.utils.Exception;

public class InputController {
    private final InputView inputView;
    private final Exception exception;
    public InputController(){
        this.inputView = new InputView();
        this.exception = new Exception();
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
    public int getOneInputNumber() {
        try {
            int oneDigitNumber = Integer.parseInt(inputView.inputNumbers());
            exception.checkOneDigitNumber(oneDigitNumber);
            return oneDigitNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Wrong input Number Format");
        }
    }
}
