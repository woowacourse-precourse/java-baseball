package baseball.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseBallGame {
    private final List<Integer> threeRandomValue;

    private String userInput;
    private List<Integer> ballStrikeCount;

    private static final int BALL = 0;
    private static final int STRIKE = 1;


    public BaseBallGame(List<Integer> threeRandomValue) {
        this.threeRandomValue = List.copyOf(threeRandomValue);
    }


    public void gameStart () {
        do {
            getUserInput();

            ballStrikeCount = threeRandomValueCompareToUserInput(threeRandomValue, userInput);
            printByBallAndStrikeStatus(ballStrikeCount);

        } while (ballStrikeCount.get(STRIKE) != 3);
    }


    private void getUserInput () {
        System.out.print("숫자를 입력해주세요 : ");
        userInput = Console.readLine();

        if (!userInput.matches("^[0-9]{3}$")) {
            throw new IllegalArgumentException();
        }
    }


    public static List<Integer> threeRandomValueCompareToUserInput (List<Integer> threeRandomValue, String userInput) {
        int ballCount = 0,
                strikeCount = 0;

        for (int i = 0; i < threeRandomValue.size(); i++) {
            if (userInput.charAt(i) - '0' == threeRandomValue.get(i)) {
                strikeCount++;
                continue;
            }

            if (threeRandomValue.contains(userInput.charAt(i) - '0')) {
                ballCount++;
            }
        }

        return List.of(ballCount, strikeCount);
    }


    public static void printByBallAndStrikeStatus (List<Integer> ballStrikeStatus) {
        if (ballStrikeStatus.get(BALL) == 0 && ballStrikeStatus.get(STRIKE) == 0) {
            System.out.println("낫싱");
            return;
        }

        if (ballStrikeStatus.get(STRIKE) == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }
        String status = "";
        if (ballStrikeStatus.get(BALL) > 0) {
            status += ballStrikeStatus.get(BALL) + "볼";
        }

        if (ballStrikeStatus.get(STRIKE) > 0) {
            if (!status.isEmpty()) {
                status += " ";
            }
            status += ballStrikeStatus.get(STRIKE) + "스트라이크";
        }
        System.out.println(status);
    }
}
