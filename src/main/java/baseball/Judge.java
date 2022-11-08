package baseball;

import java.util.List;

public class Judge {
    public static void checkTheResult(List<Integer> inputNumber, List<Integer> computerNumber) {
        int[] result = compareNumber(inputNumber, computerNumber);
        boolean gameOver = printResult(result);

        if (!gameOver) {
            checkTheResult(User.getUserInput(), computerNumber);
        }
    }

    public static int[] compareNumber(List<Integer> inputNumber, List<Integer> computerNumber) {
        int[] result = new int[3];

        for (int number : inputNumber) {
            int number_index = inputNumber.indexOf(number);

            checkStrikeBallOut(number, number_index, computerNumber, result);
        }

        return result;
    }

    public static void checkStrikeBallOut(int number, int number_index, List<Integer> computerNumber, int[] result) {
        if (computerNumber.get(number_index) == number) {
            result[0]++;
            return;
        }
        if (computerNumber.contains(number)) {
            result[1]++;
            return;
        }
        result[2]++;
    }

    public static boolean printResult(int[] result) {
        boolean gameOver = false;
        int strike = result[0];
        int ball = result[1];
        int out = result[2];

        if (ball != 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike != 0) {
            System.out.print(strike + "스트라이크");
        }
        if (strike == 3) {
            System.out.print("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            gameOver = true;
        }
        if (out == 3) {
            System.out.print("낫싱");
        }
        System.out.println();

        return gameOver;
    }
}
