package baseball.service;

import java.util.stream.Stream;

import baseball.domain.player.ComputerPlayer;
import baseball.domain.player.Player;
import baseball.domain.player.UserPlayer;
import camp.nextstep.edu.missionutils.Console;

public class GameService {
    public static final int LENGTH_OF_NUM = 3;
    public static GAME_RESULT finishNumber = GAME_RESULT.START_GAME;
    private final Player computer = new ComputerPlayer();
    private final Player user = new UserPlayer();

    public void startGame() {
        computer.getNumber();
        while (true) {
            boolean isFinished = playGame();
            if (isFinished) return;
        }

    }

    private boolean playGame() {
        user.getNumber();
        boolean isFinished = checkFinish();
        if (isFinished) return true;
        computeScore();
        return false;
    }

    private boolean checkFinish() throws IllegalArgumentException {
        if (user.number == computer.number) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            finishNumber = inputFinish();
            return true;
        }
        return false;
    }

    private static GAME_RESULT inputFinish() throws IllegalArgumentException {
        int intInput = Integer.parseInt(Console.readLine());
        switch (intInput) {
            case 1: 
                return GAME_RESULT.START_GAME;
            case 2:
                return GAME_RESULT.END_GAME;
            default:
                throw new IllegalArgumentException();
        }
    }

    private void computeScore() {
        int strike = getStrikeNumber(user.number, computer.number);
        int ball = getBallNumber(user.number, computer.number);
        printGameScore(strike, ball);   
    }

    private static int getStrikeNumber(int input, int computer) {
        int strike = 0;
        int[] arrInput = Stream.of(String.valueOf(input).split("")).mapToInt(Integer::parseInt).toArray();
        int[] arrComputer = Stream.of(String.valueOf(computer).split("")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < arrInput.length; i++) {
            if (arrInput[i] == arrComputer[i]) {
                strike++;
            }
        }
        return strike;
    }

    private static int getBallNumber(int input, int computer) {
        int ball = 0;
        int[] arrInput = Stream.of(String.valueOf(input).split("")).mapToInt(Integer::parseInt).toArray();
        int[] arrComputer = Stream.of(String.valueOf(computer).split("")).mapToInt(Integer::parseInt).toArray();
        int[] checkComputer = new int[10];
        for (int j : arrComputer) {
            checkComputer[j] = 1;
        }
        for (int i = 0; i < arrInput.length; i++) {
            if (checkComputer[arrInput[i]] == 1 && arrComputer[i] != arrInput[i]) {
                ball++;
            }
        }
        return ball;
    }

    private static void printGameScore(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
        else if (strike == 0) {
            System.out.println(ball + "볼");
        }
        else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        }
        else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }
}
