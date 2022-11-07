package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        startGame();
    }

    private static void startGame() {
        boolean isQuitting = false;

        while (!isQuitting) {
            startRound();
            isQuitting = isQuittingGame();
        }
    }

    private static boolean isQuittingGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String quitStatus = Console.readLine();

        if (quitStatus.length() != 1) {
            throw new IllegalArgumentException();
        }

        if ("1".equals(quitStatus)) {
            return false;
        } else if ("2".equals(quitStatus)) {
            return true;
        }

        throw new IllegalArgumentException();
    }

    private static void startRound() {
        List<Integer> randomNumbers = getRandomBaseballNumbers();
        boolean isDone;

        do {
            String userInput = getUserInput();
            List<Integer> comparedResult = compareBaseballNumbers(userInput, randomNumbers);
            isDone = printResultAndCheckIsDone(comparedResult);
        } while (!isDone);
    }

    private static boolean printResultAndCheckIsDone(List<Integer> comparedResult) {
        int ballCnt = comparedResult.get(0);
        int strikeCnt = comparedResult.get(1);

        if (strikeCnt == 3) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else if (ballCnt != 0 || strikeCnt != 0) {
            System.out.printf("%d볼 %d스트라이크\n", ballCnt, strikeCnt);
            return false;
        }

        System.out.println("낫싱");
        return false;
    }

    private static List<Integer> compareBaseballNumbers(String userInput, List<Integer> randomNumbers) {
        int ballCnt = 0;
        int strikeCnt = 0;

        for (int i = 0; i < 3; i++) {
            int currNum = userInput.charAt(i) - '0';

            if (randomNumbers.get(i) == currNum) {
                strikeCnt++;
            } else if (randomNumbers.contains(currNum)) {
                ballCnt++;
            }
        }

        return List.of(ballCnt, strikeCnt);
    }

    private static String getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        isValidInput(userInput);
        return userInput;
    }

    private static void isValidInput(String userInput) {
        Set<Character> notDuplicatedNumbers = new HashSet<>();

        if (userInput.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < userInput.length(); i++) {
            char currChar = userInput.charAt(i);

            if (currChar < '1' || currChar > '9') {
                throw new IllegalArgumentException();
            }

            int setSize = notDuplicatedNumbers.size();
            notDuplicatedNumbers.add(currChar);

            if (setSize == notDuplicatedNumbers.size()) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static List<Integer> getRandomBaseballNumbers() {
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


