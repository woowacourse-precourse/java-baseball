package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;

public class Game {
    final static int BALL = 1;
    final static int STRIKE = 0;
    final static String WIN_CONDITION = "3스트라이크";
    final static int NUMBER_LENGTH = 3;
    private Computer computer;

    Game() {
        this.computer = new Computer();
    }

    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String gamePlayerInput = getGamePlayerInput();
            checkGamePlayerNumberInput(gamePlayerInput);
            String result = getResult(computer.getRandomNumbers(), gamePlayerInput);
            System.out.println(result);
            if (result.contains(WIN_CONDITION)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    public String getGamePlayerInput() {
        return Console.readLine();
    }

    public void checkGamePlayerNumberInput(String gamePlayerNumberInput) {
        ExceptionFor2.checkGamePlayerNumberInput(gamePlayerNumberInput);
    }

    public String getResult(String computerRandomNumbers, String gamePlayerInput) {
        List<Integer> result = new ArrayList<>(2);
        result.add(countStrikes(computerRandomNumbers, gamePlayerInput));
        result.add(countBalls(computerRandomNumbers, gamePlayerInput ) - result.get(STRIKE));

        return getResultMessage(result);
    }

    private String getResultMessage(List<Integer> result) {
        String resultMessage = "";
        if (result.get(BALL) > 0) {
            resultMessage = resultMessage.concat(Integer.toString(result.get(BALL)) + "볼 ");
        }

        if (result.get(STRIKE) > 0) {
            resultMessage = resultMessage.concat(Integer.toString(result.get(STRIKE)) + "스트라이크");
        }

        if (resultMessage.length() ==  0) {
            resultMessage = "낫싱";
        }

        return resultMessage;
    }

    private Integer countStrikes(String computerRandomNumbers, String gamePlayerInput) {
        int strikes = 0;
        for (int stringIndex = 0; stringIndex < NUMBER_LENGTH; stringIndex++) {
            if (computerRandomNumbers.charAt(stringIndex) == gamePlayerInput.charAt(stringIndex)) {
                strikes++;
            }
        }
        return strikes;
    }

    private Integer countBalls(String computerRandomNumbers, String gamePlayerInput) {
        int balls = 0;
        for (int stringIndex = 0; stringIndex < NUMBER_LENGTH; stringIndex++) {
            if (computerRandomNumbers.contains(Character.toString(gamePlayerInput.charAt(stringIndex)))) {
                balls++;
            }
        }
        return balls;
    }

}