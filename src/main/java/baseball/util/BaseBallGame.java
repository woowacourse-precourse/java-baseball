package baseball.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseBallGame {
    private final List<Integer> computerRandomThreeValue;

    private static final int BALL = 0;
    private static final int STRIKE = 1;

    public BaseBallGame(List<Integer> computerRandomThreeValue) {
        this.computerRandomThreeValue = List.copyOf(computerRandomThreeValue);
    }


    public void gameStart () {
        String userData;
        List<Integer> ballStrikeCount;
        do {
            System.out.print("숫자를 입력해주세요 : ");

            userData = Console.readLine();

            userInputValidCheck(userData);

            ballStrikeCount = computerRandomCompareToUserInput(computerRandomThreeValue, userData);
            printByBallAndStrikeCount(ballStrikeCount);

        } while (ballStrikeCount.get(STRIKE) != 3);
    }

    private static void userInputValidCheck(String userInput) {
        if (!userInput.matches("^[0-9]{3}$")) {
            throw new IllegalArgumentException();
        }
    }


    private static List<Integer> computerRandomCompareToUserInput (List<Integer> computerRandom, String userInput) {
        int ballCount = 0,
                strikeCount = 0;

        for (int i = 0; i < computerRandom.size(); i++) {
            if (userInput.charAt(i) - '0' == computerRandom.get(i)) {
                strikeCount++;
                continue;
            }

            if (computerRandom.contains(userInput.charAt(i) - '0')) {
                ballCount++;
            }
        }

        return List.of(ballCount, strikeCount);
    }


    private static void printByBallAndStrikeCount (List<Integer> ballStrikeCount) {
        if (ballStrikeCount.get(BALL) == 0 && ballStrikeCount.get(STRIKE) == 0) {
            System.out.println("낫싱");
            return;
        }

        if (ballStrikeCount.get(STRIKE) == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }

        System.out.println(ballStrikeCount.get(BALL) + "볼 " + ballStrikeCount.get(STRIKE) + "스트라이크");
    }
}
