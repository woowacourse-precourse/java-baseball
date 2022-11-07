package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    public static final int NUMBER_OF_DIGIT = 3;

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> numComputer = NumComputerPicker.pickNumComputer();

        List<Integer> numInput = new ArrayList<>();
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String str = Console.readLine();
            getNumInput(numInput, str);

            List<Integer> score = ScoreCalculator.calScore(numComputer, numInput);

            printScore(score);

            int strikeCount = score.get(1);
            if (strikeCount == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
        }
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

    private void printScore(List<Integer> score) {
        int ballCount = score.get(0);
        int strikeCount = score.get(1);

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
        return;
    }

}
