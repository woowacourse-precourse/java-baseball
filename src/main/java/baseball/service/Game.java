package baseball.service;

import baseball.console.Input;
import baseball.console.Output;
import baseball.entity.Computer;
import baseball.entity.User;

public class Game {
    private final String startMessage = "숫자 야구 게임을 시작합니다.";
    private User user;
    private Computer computer;

    public Game() {
        System.out.println(startMessage);
        user = new User();
        computer = new Computer();
    }

    public void start() {
        computer.setAnswer();
        user.setNumber(Input.get());
        while (!isCorrect()) {
            user.setNumber(Input.get());
        }
        Output.printAnswerMessage();
        if (Input.restart().equals("1")) {
            start();
        }
    }

    private boolean isCorrect() {
        if (user.getNumber().equals(computer.getAnswer())) {
            return true;
        }
        return false;
    }
}
