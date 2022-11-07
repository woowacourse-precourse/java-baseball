package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;

public class Game {
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
        List<Integer> result = new ArrayList<>(3);
        Integer strikes = countStrikes(computerRandomNumbers, gamePlayerInput);
        Integer balls = countBalls(computerRandomNumbers, gamePlayerInput ) - strikes;

        if (balls > 0) {
            result.append(balls + "볼 ");
        }

        if (strikes > 0) {
            result.append(strikes + "스트라이크");
        }

        if (strikes == balls && balls == 0) {
            result.append("낫싱");
        }

        return result.toString();
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