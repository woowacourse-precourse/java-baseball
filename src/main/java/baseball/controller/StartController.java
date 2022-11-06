package baseball.controller;

import baseball.domain.Again;
import baseball.domain.Computer;
import baseball.service.AgainValidator;
import baseball.service.Implement;
import baseball.view.StartEndGame;

import java.io.IOException;

public class StartController {
    final StartEndGame startEndGame;
    final Implement implement;
    final Computer computer;

    public StartController() {
        this.startEndGame = new StartEndGame();
        this.implement = new Implement();
        this.computer = new Computer();
    }

    public Computer startController() throws IOException {
        startEndGame.startGame();
        return computer;
    }

    public int askOneMore() throws IOException {
        startEndGame.endGame();
        Again again = new Again(startEndGame.inputToQuestion());
        AgainValidator againValidator = new AgainValidator();
        againValidator.validate(again);
        return again.getDoTry();
    }
}
