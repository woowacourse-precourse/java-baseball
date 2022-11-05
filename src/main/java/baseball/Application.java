package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Application {

    private static final int NUMBER_SIZE = 3;
    private static final String GAME_RESTART = "1";
    
    private static void Exception(String playerInputs) {
        String numberPattern = "[1-9]{3}";
        boolean result = Pattern.matches(numberPattern, playerInputs);
        if (!result) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다. 게임 종료됩니다.");
        }
    }

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
        System.out.print("숫자를 입력해주세요 : ");
        String playerInputs = Console.readLine();
        Exception(playerInputs);
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

    private static boolean printNumberHint(int ball, int strike) {
        if (isNothing(ball, strike)) {
            System.out.println("낫싱");
        } else if (isThreeStrike(strike)) {
            System.out.println(strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.printf("%d볼 %d스트라이크", ball, strike);
        }
        return false;
    }

    private static boolean getNumberHint(List<Integer> randomNumber, List<Integer> playerNumber) {
        int ball = 0, strike = 0;
        for (Integer number: randomNumber) {
            if (isBall(number, playerNumber)) {
                int randomNumberIndex = randomNumber.indexOf(number);
                int playerNumberIndex = playerNumber.indexOf(number);
                if (isStrike(randomNumberIndex, playerNumberIndex)) strike ++;
                else    ball ++;
            }
        }
        return printNumberHint(ball, strike);
    }

    private static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> randomNumber = generateRandomNumberBySize();
        System.out.println(randomNumber); // DEBUG
        boolean isFinish = false;
        while (!isFinish) {
            List<Integer> playerNumber = inputPlayerNumber();
            isFinish = getNumberHint(randomNumber, playerNumber);
        }
        restartGame();
    }

    private static void restartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String gameProgress = Console.readLine();
        if (gameProgress.equals(Application.GAME_RESTART))    startGame();
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        startGame();
        System.out.println("게임을 종료합니다.");
    }
}
