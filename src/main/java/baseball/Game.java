package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Game {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RIGHT_ANSWER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String AFTER_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    public static final String RESTART_RESPONSE = "1";
    public static final String QUIT_RESPONSE = "2";
    public static final int LENGTH = 3;

    public Computer computer = new Computer();
    public Player player = new Player();

    public void start() {
        System.out.println(START_MESSAGE);
        String answer = computer.generateRandomNumbersString();
        run(answer);
    }

    public void run(String answer) {
        int strike = 0;
        int ball = 0;
        while (!checkAnswer(strike)) {
            String playerInput = getPlayerInput();
            List<Integer> result = compareAnswer(answer, playerInput);
            strike = result.get(0);
            ball = result.get(1);
            printResult(strike, ball);
        }

        String response = getPlayerResponse();
        checkResponse(response);
    }

    private String getPlayerInput() {
        System.out.print(INPUT_MESSAGE);
        return player.getPlayerInputNumbersString();
    }

    private List<Integer> compareAnswer(String answer, String playerInput) {
        int strike = 0, ball = 0;
        for (int i = 0; i < LENGTH; i++) {
            if (answer.charAt(i) == playerInput.charAt(i)) {
                strike++;
            } else if (answer.indexOf(playerInput.charAt(i)) != -1) {
                ball++;
            }
        }
        return Arrays.asList(strike, ball);
    }

    private boolean checkAnswer(int strike) {
        return strike == LENGTH;
    }

    private void printResult(int strike, int ball) {
        if (ball != 0) {
            System.out.print(ball + BALL + " ");
        }
        if (strike != 0) {
            System.out.print(strike + STRIKE);
        }
        if (ball == 0 && strike == 0) {
            System.out.print(NOTHING);
        }
        System.out.println();

        if (strike == LENGTH) {
            System.out.println(RIGHT_ANSWER_MESSAGE);
        }
    }

    private String getPlayerResponse() {
        System.out.println(AFTER_GAME_MESSAGE);
        return player.getPlayerResponseAfterGame();
    }

    private void checkResponse(String response) {
        if (response.equals(RESTART_RESPONSE)) {
            start();
        }
    }
}
