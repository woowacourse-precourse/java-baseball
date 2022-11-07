package baseball.service;

import baseball.domain.player.ComputerPlayer;
import baseball.domain.player.Player;
import baseball.domain.player.UserPlayer;
import camp.nextstep.edu.missionutils.Console;
import java.util.stream.Stream;

public class GameService {
    public static final int LENGTH_OF_NUM = 3;
    public static final Player computer = new ComputerPlayer();
    public static final Player user = new UserPlayer();
    public static GAME_RESULT finishNumber = GAME_RESULT.START_GAME;

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

    public static int getStrikeNumber(int input, int computer) {
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

    public static int getBallNumber(int input, int computer) {
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

    public static String printGameScore(int strike, int ball) {
        String printMessage = "";
        if (strike == 0 && ball == 0) {
            printMessage += "낫싱";
        } else if (strike == 0) {
            printMessage += ball + "볼";
        } else if (ball == 0) {
            printMessage += strike + "스트라이크";
        } else {
            printMessage += ball + "볼 " + strike + "스트라이크";
        }
        return printMessage;
    }

    public static boolean checkFinish() {
        if (user.number == computer.number) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return true;
        }
        return false;
    }

    public void startGame() {
        computer.getNumber();
        printStartMessage();
        while (true) {
            boolean isFinished = playGame();
            if (isFinished) {
                return;
            }
        }

    }

    private void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private boolean playGame() {
        user.getNumber();
        boolean isFinished = checkFinish();
        if (isFinished) {
            finishNumber = inputFinish();
            return true;
        }
        computeScore();
        return false;
    }

    private void computeScore() {
        int strike = getStrikeNumber(user.number, computer.number);
        int ball = getBallNumber(user.number, computer.number);
        System.out.println(printGameScore(strike, ball));
    }
}
