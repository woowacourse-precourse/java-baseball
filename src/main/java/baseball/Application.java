package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            List<Integer> computerNumber = makeComputerRandomNumber();
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String input = Console.readLine();
                List<Integer> inputNumber = checkTheNumber(input);
                int[] result = compareNumber(inputNumber, computerNumber);
                boolean gameOver = printResult(result);

                if(gameOver){
                    break;
                }
            }
        }


    }

    public static List<Integer> makeComputerRandomNumber() {
        List<Integer> numArr = new ArrayList<Integer>();

        while (numArr.size() < 3) {
            pickRandomNumber(numArr);
        }

        return numArr;
    }

    public static List<Integer> pickRandomNumber(List<Integer> numArr) {
        int number = Randoms.pickNumberInRange(1, 9);

        if (!numArr.contains(number)) {
            numArr.add(number);
        }

        return numArr;
    }

    public static List<Integer> checkTheNumber(String input) {
        boolean isWrongInput = false;
        int number = changeStrToInt(input);
        List<Integer> numArr = changeIntToList(number);

        if (isOverlap(numArr) || isNotSizeThree(numArr) || hasZero(numArr)) {
            isWrongInput = true;
        }

        if (isWrongInput == true) {
            throw new IllegalArgumentException();
        }

        return numArr;
    }

    public static int changeStrToInt(String input) {
        int number;

        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return number;
    }

    public static List<Integer> changeIntToList(int number) {
        List<Integer> numArr = new ArrayList<Integer>();

        while (number > 0) {
            numArr.add(0, number % 10);
            number /= 10;
        }

        return numArr;
    }

    public static boolean isOverlap(List<Integer> numArr) {
        boolean overlap = true;

        if (numArr.size() == numArr.stream().distinct().count()) {
            overlap = false;
        }

        return overlap;
    }

    public static boolean isNotSizeThree(List<Integer> numArr) {
        boolean notSizeThree = false;

        if (numArr.size() != 3) {
            notSizeThree = true;
        }

        return notSizeThree;
    }

    public static boolean hasZero(List<Integer> numArr) {
        boolean isZero = false;

        for (int i : numArr) {
            if (i == 0) {
                isZero = true;
            }
        }

        return isZero;
    }

    public static int[] compareNumber(List<Integer> inputNumber, List<Integer> computerNumber) {
        int[] result = new int[3];
        int strike;
        int ball;
        int out;

        for (int number : inputNumber) {
            int number_index = inputNumber.indexOf(number);

            checkStrikeBallOut(number, number_index, computerNumber, result);
        }

        return result;
    }

    public static void checkStrikeBallOut(int number, int number_index, List<Integer> computerNumber, int[] result) {
        if (computerNumber.get(number_index) == number) {
            result[0]++;
        } else if (computerNumber.contains(number)) {
            result[1]++;
        } else {
            result[2]++;
        }
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
            System.out.println("낫싱");
        }
        System.out.println();

        return gameOver;
    }
}
