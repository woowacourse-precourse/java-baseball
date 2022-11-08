package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    public final ComputerNumber computerNumber;
    public final UserNumber userNumber;

    private List<Integer> userGuessNumbers;
    private List<Integer> computerAnswerNumber;

    private int strike;
    private int ball;

    public Game() {
        computerNumber = new ComputerNumber();
        userNumber = new UserNumber();

        userGuessNumbers = new ArrayList<>();
        computerAnswerNumber = new ArrayList<>();
        strike = 0;
        ball = 0;
    }

    public void startPlaying() {
        System.out.println(SystemMessage.printStartMessage);
        computerNumber.makeRandomNumber();
        computerAnswerNumber = computerNumber.getComputerNumber();
        do {
            UserNumber userNumber = new UserNumber();
            userGuessNumbers = userNumber.userInputNumber();
            strike = 0;
            ball = 0;
            countScore();
            printScoreInfo();
        } while (!endGame());
        System.out.println(SystemMessage.printEndMessage);
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

    public void countScore() {
        String inputString = userGuessNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        String computerString = computerAnswerNumber.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        for (int i = 0; i < Constants.NUMBER_LENGTH; i++) {
            int index = inputString.indexOf(computerString.charAt(i));
            if (index == i) {
                strike++;
            } else if (index != -1) {
                ball++;
            }
        }
    }

    public boolean endGame() {
        return strike == Constants.NUMBER_LENGTH;
    }

    public boolean retryOrQuit() {
        System.out.println(SystemMessage.printRetryOrQuit);
        String restart = Console.readLine();
        if (!Validator.checkRestartException(restart)) {
            throw new IllegalArgumentException();
        }
        return restart.equals(Constants.RESTART);
    }
}