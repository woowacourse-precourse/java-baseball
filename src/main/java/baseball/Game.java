package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.ArrayList;

public class Game {
    final static int BALL = 1;
    final static int STRIKE = 0;
    final static String WIN_CONDITION = "3스트라이크";
    final static int NUMBER_LENGTH = 3;
    private Computer computer;
    private String computerNumbers;

    Game() {
        this.computer = new Computer();
        this.computerNumbers = computer.getRandomNumbers();
    }

    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String playerNumbers = getGamePlayerInput();
            String result = getResult(playerNumbers);
            System.out.println(result);
            if (result.contains(WIN_CONDITION)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    public String getGamePlayerInput() {
        String playerNumbers = Console.readLine();
        verifyPlayerNumbers(playerNumbers);

        return playerNumbers;
    }

    public void verifyPlayerNumbers(String playerNumbers) {
        PlayerNumbersException.verify(playerNumbers);
    }

    public String getResult(String playerNumbers) {
        List<Integer> result = new ArrayList<>(2);
        result.add(countStrikes(playerNumbers));
        result.add(countBalls(playerNumbers ) - result.get(STRIKE));

        return getResultMessage(result);
    }

    private String getResultMessage(List<Integer> result) {
        String resultMessage = "";
        if (result.get(BALL) > 0) {
//            resultMessage = resultMessage.concat(String.join(Integer.toString(result.get(BALL)), "볼", " "));
            resultMessage = String.join(Integer.toString(result.get(BALL)), "볼 ");
        }

        if (result.get(STRIKE) > 0) {
//            resultMessage = resultMessage.concat(String.join(Integer.toString(result.get(STRIKE)), "스트라이크"));
            resultMessage = String.join(resultMessage, Integer.toString(result.get(STRIKE)), "스트라이크");
        }

        if (resultMessage.length() ==  0) {
            resultMessage = "낫싱";
        }

        return resultMessage;
    }

    private Integer countStrikes(String playerNumbers) {
        int strikes = 0;
        for (int stringIndex = 0; stringIndex < NUMBER_LENGTH; stringIndex++) {
            if (this.computerNumbers.charAt(stringIndex) == playerNumbers.charAt(stringIndex)) {
                strikes++;
            }
        }
        return strikes;
    }

    private Integer countBalls(String playerNumbers) {
        int balls = 0;
        for (int stringIndex = 0; stringIndex < NUMBER_LENGTH; stringIndex++) {
            if (this.computerNumbers.contains(Character.toString(playerNumbers.charAt(stringIndex)))) {
                balls++;
            }
        }
        return balls;
    }

}