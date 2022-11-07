package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static baseball.GameConstants.NUMBER_LENGTH;

public class Game {
    public final ComputerNumber computerNumber;
    public final UserNumber userNumber;

    private List<Integer> userInputNumberList;
    private List<Integer> computerNumberList;

    private int strike;
    private int ball;

    public Game() {
        computerNumber = new ComputerNumber();
        userNumber = new UserNumber();

        userInputNumberList = new ArrayList<>();
        computerNumberList = new ArrayList<>();
        strike = 0;
        ball = 0;
    }

    public void startPlaying() {
        SystemMessage.printStartMessage();
        computerNumber.makeComputerNumber();
        computerNumberList = computerNumber.getComputerNumber();
        do {
            UserNumber userNumber = new UserNumber();
            userInputNumberList = userNumber.userInputNumber();
            strike = 0;
            ball = 0;
            scoreInfo();
            printScoreInfo();
        } while (!endGame());
        SystemMessage.printEndMessage();
    }

    public void printScoreInfo() {
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }
        if (ball + strike == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    public void scoreInfo() {
        String inputString = userInputNumberList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        String answerString = computerNumberList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            int index = inputString.indexOf(answerString.charAt(i));
            if (index == i) {
                strike++;
            } else if (index != -1) {
                ball++;
            }
        }
    }

    public boolean endGame() {
        return strike == NUMBER_LENGTH;
    }

    public boolean retryOrQuit() {
        SystemMessage.printRetryOrQuit();
        String restart = Console.readLine();
        if (!Validator.checkRestartException(restart)) {
            throw new IllegalArgumentException();
        }
        return restart.equals(GameConstants.RESTART);
    }
}