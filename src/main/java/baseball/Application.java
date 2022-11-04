package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final int NUMBER_SIZE = 3;

    private static List<Integer> generateRandomNumberBySize() {
        List<Integer> randomNumber = new ArrayList<>();
        while (randomNumber.size() < Application.NUMBER_SIZE) {
            int tempRandomNumber = generateRandomNumber();
            if (!randomNumber.contains(tempRandomNumber)) {
                randomNumber.add(tempRandomNumber);
            }
        }
        return randomNumber;
    }

    private static int generateRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    private static List<Integer> inputPlayerNumber() {
        List<Integer> playerNumber = new ArrayList<>();
        String playerInputs = Console.readLine();
        for (String playerInput : playerInputs.split(""))
            playerNumber.add(Integer.parseInt(playerInput));
        return playerNumber;
    }

    private static boolean isBall(int number, List<Integer> playerNumber) {
        return playerNumber.contains(number);
    }

    private static boolean isStrike(int randomNumberIndex, int playerNumberIndex) {
        return randomNumberIndex == playerNumberIndex;
    }

    private static boolean isNothing(int ball, int strike) {
        return ball == 0 && strike == 0;
    }

    private static Boolean isThreeStrike(int strike) {
        return strike == Application.NUMBER_SIZE;
    }

    private static void printNumberHint(int ball, int strike) {
        if (isNothing(ball, strike)) {
            System.out.println("낫싱");
        } else if (isThreeStrike(strike)) {
            System.out.println(strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.printf("%d볼 %d스트라이크", ball, strike);
        }
    }

    private static void getNumberHint(List<Integer> randomNumber, List<Integer> playerNumber) {
        int ball = 0, strike = 0;
        for (Integer number: randomNumber) {
            if (isBall(number, playerNumber)) {
                int randomNumberIndex = randomNumber.indexOf(number);
                int playerNumberIndex = playerNumber.indexOf(number);
                if (isStrike(randomNumberIndex, playerNumberIndex)) strike ++;
                else    ball ++;
            }
        }
        printNumberHint(ball, strike);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> randomNumber = generateRandomNumberBySize();
        System.out.println(randomNumber);
        List<Integer> playerNumber = inputPlayerNumber();
        System.out.println(playerNumber);
        getNumberHint(randomNumber, playerNumber);
    }
}
