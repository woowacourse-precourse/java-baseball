package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            playGame();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String userInput = Console.readLine();
            if (userInput.equals("1")) {
                continue;
            }
            if (userInput.equals("2")) {
                break;
            }
            throw new IllegalArgumentException();
        }
    }

    private static void playGame() {
        ArrayList<Integer> targetNumbers = pickRandomNumbers();
        while (true) {
            ArrayList<Integer> playerNumbers = getPlayerNumbers();
            ArrayList<Integer> results = calculateResults(targetNumbers, playerNumbers);
            printResults(results.get(0), results.get(1));
            if (results.get(1) == 3) {
                break;
            }
        }
    }

    private static ArrayList<Integer> pickRandomNumbers() {
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    private static ArrayList<Integer> getPlayerNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String playerInput = Console.readLine();

        if (!isValid(playerInput)) {
            throw new IllegalArgumentException();
        }

        ArrayList<Integer> playerNumbers = new ArrayList<>();
        for (int i = 0; i < playerInput.length(); i++) {
            playerNumbers.add(playerInput.charAt(i) - '0');
        }
        return playerNumbers;
    }

    private static boolean isValid(String playerInput) {
        if (!playerInput.matches("^[1-9]{3}$")) {
            return false;
        }
        int number1 = playerInput.charAt(0) - '0';
        int number2 = playerInput.charAt(1) - '0';
        int number3 = playerInput.charAt(2) - '0';
        return number1 != number2 && number1 != number3 && number2 != number3;
    }

    private static ArrayList<Integer> calculateResults(
            ArrayList<Integer> targetNumbers, ArrayList<Integer> playerNumbers) {
        int numberOfBalls = 0;
        int numberOfStrikes = 0;

        for (int i = 0; i < playerNumbers.size(); i++) {
            if (Objects.equals(playerNumbers.get(i), targetNumbers.get(i))) {
                numberOfStrikes++;
            } else if (targetNumbers.contains(playerNumbers.get(i))) {
                numberOfBalls++;
            }
        }
        return new ArrayList<>(Arrays.asList(numberOfBalls, numberOfStrikes));
    }

    private static void printResults(Integer numberOfBalls, Integer numberOfStrikes) {
        if (numberOfBalls == 0 && numberOfStrikes == 0) {
            System.out.println("낫싱");
            return;
        }
        if (numberOfBalls != 0) {
            System.out.print(numberOfBalls + "볼 ");
        }
        if (numberOfStrikes != 0) {
            System.out.print(numberOfStrikes + "스트라이크");
        }
        System.out.println();
        if (numberOfStrikes == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}
