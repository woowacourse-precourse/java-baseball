package baseball;

import baseball.ScoreCalculator.BallOrStrike;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    public static final int NUMBER_OF_DIGIT = 3;

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            List<Integer> numComputer = NumComputerPicker.pickNumComputer();
            int strikeCount;
            do {
                System.out.print("숫자를 입력해주세요 : ");
                String str = Console.readLine();
                List<Integer> numInput = new ArrayList<>();
                getNumInput(numInput, str);

                EnumMap<BallOrStrike, Integer> score = ScoreCalculator.calScore(numComputer, numInput);

                printScore(score);

                strikeCount = score.get(BallOrStrike.STRIKE);
            } while (!gameEnd(strikeCount));
        } while (restart());
    }

    public void getNumInput(List<Integer> result, String str) {
        for (int i = 0; i < str.length(); i++) {
            int num = Character.getNumericValue(str.charAt(i));
            result.add(num);
        }

        if (!validateInput(result)) {
            throw new IllegalArgumentException();
        }

        return;
    }

    private boolean validateInput(List<Integer> input) {
        if (input.size() != NUMBER_OF_DIGIT) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < NUMBER_OF_DIGIT; i++) {
            int digit = input.get(i);
            if (digit == 0) {
                return false;
            }

            set.add(digit);
        }

        if (set.size() != NUMBER_OF_DIGIT) {
            return false;
        }

        return true;
    }

    private void printScore(EnumMap<BallOrStrike, Integer> score) {
        int ballCount = score.get(BallOrStrike.BALL);
        int strikeCount = score.get(BallOrStrike.STRIKE);

        if ((ballCount == 0) && (strikeCount == 0)) {
            System.out.println("낫싱");
            return;
        }

        if (ballCount != 0) {
            System.out.print(ballCount + "볼 ");
        }

        if (strikeCount != 0) {
            System.out.print(strikeCount + "스트라이크");
        }

        System.out.println();
    }

    private boolean gameEnd(int strikeCount) {
        if (strikeCount < 3) {
            return false;
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        return true;
    }

    private boolean restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int operation;
        try {
            operation = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException();
        }

        if (operation == 1) {
            return true;
        }
        if (operation == 2) {
            return false;
        }

        throw new IllegalArgumentException();
    }

}
