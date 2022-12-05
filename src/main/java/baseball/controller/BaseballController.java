package baseball.controller;

import baseball.Computer;
import baseball.Converter;
import baseball.RandomNumberGenerator;
import baseball.User;
import baseball.inputchecker.Checker;
import baseball.inputview.InputNumber;
import baseball.inputview.InputReplay;
import baseball.outputview.ResultMessage;
import baseball.outputview.StartMessage;

public class BaseballController {
    InputNumber inputNumber = new InputNumber();
    RandomNumberGenerator randomNumberGenerator;
    Computer computer;
    ResultMessage resultMessage = new ResultMessage();

    public void run() {
        int replay = 1;
        while(replay == 1) {
            startGame();
            playGame();
            replay = replay();
        }
    }

    public void startGame() {
        StartMessage.print();
        randomNumberGenerator = new RandomNumberGenerator();
        randomNumberGenerator.generate();
        computer = new Computer(randomNumberGenerator.getRandomNumberList());
    }

    public void playGame() {
        boolean retry = true;
        while (retry) {
            String input = inputNumber.run();
            Checker.isValid(input);
            User user = new User(Converter.stringToList(input));
            retry = computer.compareAndResult(user.getNumberList());
            resultMessage.print(computer.getResult().toString());
        }
    }

    public int replay() {
        InputReplay inputReplay = new InputReplay();
        return inputReplay.run();
    }
}
