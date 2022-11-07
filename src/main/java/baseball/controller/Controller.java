package baseball.controller;

import java.util.List;

import baseball.model.Computer;
import baseball.model.User;
import baseball.view.InputView;
import baseball.view.OutputView;

import baseball.exception.Exceptions;

public class Controller {
    private boolean GAME_END = true;
    private boolean GAME_NOT_END = false;
    private static final String END_MESSAGE = "2";
    private static final String RESTART_MESSAGE = "1";
    private static final int END_STRIKE_COUNT = 3;
    private static final String END_EXCEPTION_MESSAGE = "입력이 잘못되었어요";
    private List<Integer> userNumber;
    private List<Integer> computerNumber;
    private boolean isGameEnd = false;
    private int strike;
    private int ball;

    Computer computer;
    User user;

    public Controller() {
        computer = new Computer();
        user = new User();

    }

    public void playGame() {
        computerNumber = computer.addRandomNumbers();
        InputView.startMessage();
        while (!isGameEnd) {
            String numbers = InputView.gameMessage();
            try {
                validateRequestNumber(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                throw new IllegalArgumentException(END_EXCEPTION_MESSAGE);
            }
            userNumber = user.parseNumbers(numbers);
            running();
        }
        askAgainRestart();
    }

    private void running() {
        resetScore();
        modifyStrikeBallCount();
        OutputView.printResult(ball, strike);
        if (strike == END_STRIKE_COUNT) {
            isGameEnd = GAME_END;
            OutputView.printSuccess();
        }
    }

    public boolean getGameEnd() {
        return isGameEnd;
    }

    private void askAgainRestart() {
        String message = InputView.endMessage();
        try {
            validateRequestEndNumbers(message);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(END_EXCEPTION_MESSAGE);
        }
        if (RESTART_MESSAGE.equals(message)) {
            isGameEnd = GAME_NOT_END;
        }
    }

    private void modifyStrikeBallCount() {
        ball = countBall(computerNumber, userNumber);
        for (int i = 0; i < userNumber.size(); i++) {
            if (isStrikeNumber(computerNumber, userNumber.get(i), userNumber.indexOf(userNumber.get(i)))) {
                ball -= 1;
                strike += 1;
            }
        }
    }

    private boolean isStrikeNumber(List<Integer> computerNumber, int userNumber, int userNumberIndex) {
        for (int i = 0; i < computerNumber.size(); i++) {
            if (computerNumber.get(i) == userNumber && i == userNumberIndex) {
                return true;
            }
        }
        return false;
    }

    private int countBall(List<Integer> computerNumber, List<Integer> userNumber) {
        int ball = 0;
        for (int i = 0; i < computerNumber.size(); i++) {
            if (computerNumber.contains(userNumber.get(i))) {
                ball += 1;
            }
        }
        return ball;
    }

    private void resetScore() {
        ball = 0;
        strike = 0;
    }

    private void validateRequestEndNumbers(String request) {
        if (!request.equals(END_MESSAGE) && !request.equals(RESTART_MESSAGE)) {
            throw new IllegalArgumentException(END_EXCEPTION_MESSAGE);
        }
    }

    private void validateRequestNumber(String request) {
        if (!Exceptions.respondException(request)) {
            throw new IllegalArgumentException(END_EXCEPTION_MESSAGE);
        }
    }


}