package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다. ");

        while (true) {
            List<Integer> computer = createRandomNumbers();

            boolean startOrEnd = checkContinue();

            if (startOrEnd == false) {
                break;
            }
        }

    }

    private static void startGame(List<Integer> computer) {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");

            int[] inputNumbers = getThreeInts();

            int ball = 0;
            int strike = 0;

            for (int i = 0; i < 3; i++) {
                String result = checkNumber(computer, inputNumbers, i);

                if (result.equals("strike")) {
                    strike++;
                } else if (result.equals("ball")) {
                    ball++;
                }
            }

            printMessage(ball, strike);

            if (strike == 3) {
                System.out.println(strike + "스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private static boolean checkContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputNumber = Console.readLine();

        int inputStartOrEnd = Integer.parseInt(inputNumber);

        if (inputStartOrEnd == 2) {
            return false;
        } else if (inputStartOrEnd == 1) {
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }


    private static void printMessage(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    private static String checkNumber(List<Integer> computer, int[] inputNumbers, int i) {
        for (int j = 0; j < 3; j++) {
            if (inputNumbers[i] == computer.get(j) && i == j) {
                return "strike";
            } else if (inputNumbers[i] == computer.get(j)) {
                return "ball";
            }
        }
        return "nothing";
    }

    private static int[] getThreeInts() {
        String input = Console.readLine();

        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        int inputNumber = Integer.parseInt(input);
        int[] inputNumbers = new int[3];

        inputNumbers[0] = inputNumber / 100;
        inputNumbers[1] = (inputNumber / 10) % 10;
        inputNumbers[2] = inputNumber % 10;

        for (int i = 0; i < 3; i++) {
            if (inputNumbers[i] == 0) {
                throw new IllegalArgumentException();
            }
        }
        return inputNumbers;
    }

    public static List<Integer> createRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }
}
