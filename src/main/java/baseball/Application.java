package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Application {
    public static class IllegalArgumentException extends RuntimeException {
    }

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
        return null;
    }

    private static ArrayList<Integer> calculateResults(
            ArrayList<Integer> targetNumbers, ArrayList<Integer> playerNumbers) {
        return null;
    }

    private static void printResults(Integer numberOfBalls, Integer numberOfStrikes) {
    }
}
