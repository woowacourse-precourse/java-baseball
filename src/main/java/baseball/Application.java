package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    private static final int SIZE = 3;

    private static final int STRIKE = 0;
    private static final int BALL = 1;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        playGame();
    }

    private static void playGame() {

        printStart();
        List<Integer> computer = getTargetNumbers();

        while (true) {
            String input = setInput();
            boolean error = checkUserError(input);

            if (error) {
                break;
            }

            List<Integer> user = getToEnterNumbers(input);
            List<Integer> counts = getEachCounts(computer, user);
            printBallStrike(counts);

            int strikeCount = counts.get(STRIKE);
            boolean success = checkSuccess(strikeCount);

            if (!success) {
                continue;
            }

            printAgainQuestion();
            boolean again = checkAgainGame();

            if (again) {
                computer = getTargetNumbers();
                continue;
            }

            break;
        }
    }

    private static String setInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        return input;
    }

    private static List<Integer> getEachCounts(List<Integer> computer, List<Integer> user) {

        List<Integer> counts = new ArrayList<>();

        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < SIZE; i++) {
            int computerNumber = computer.get(i);
            int userNumber = user.get(i);

            if (userNumber == computerNumber) {
                strikeCount++;
                continue;
            }
            if (computer.contains(userNumber)) {
                ballCount++;
            }
        }

        counts.add(strikeCount);
        counts.add(ballCount);

        return counts;
    }

    private static List<Integer> getToEnterNumbers(String input) {
        List<Integer> user = new ArrayList<>();

        for (int i = 0; i < SIZE; i++) {
            char currentValue = input.charAt(i);
            int number = Character.getNumericValue(currentValue);
            user.add(number);
        }

        return user;
    }

    private static List<Integer> getTargetNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static void printBallStrike(List<Integer> counts) {

        int nothing = 0;

        int strikeCount = counts.get(STRIKE);
        int ballCount = counts.get(BALL);

        if (ballCount > nothing && strikeCount > nothing) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        } else if (ballCount > nothing) {
            System.out.println(ballCount + "볼");
        } else if (strikeCount > nothing) {
            System.out.println(strikeCount + "스트라이크");
        } else if (ballCount == nothing && strikeCount == nothing) {
            System.out.println("낫싱");
        }

        return;
    }

    private static void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    private static void printAgainQuestion() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private static boolean checkUserError(String input) {

        System.out.println(input);

        if(checkSizeError(input) || checkRangeError(input) || checkVisitedError(input)) {
            return true;
        }

        return false;
    }
    private static boolean checkRangeError(String input) {

        int min = 1;
        int max = 9;

        for (int i = 0; i < SIZE; i++) {
            char value = input.charAt(i);
            int number = Character.getNumericValue(value);

            boolean rangeCheck = (number >= min) && (number <= max);

            if (!rangeCheck) {
                return true;
            }
        }
        return false;
    }
    private static boolean checkSizeError(String input) {
        int size = input.length();

        if (size != SIZE) {
            return true;
        }

        return false;
    }
    private static boolean checkVisitedError(String input) {
        List<Integer> visitedList = new ArrayList<>();

        for (int i = 0; i < SIZE; i++) {
            char value = input.charAt(i);
            int number = Character.getNumericValue(value);

            if (visitedList.contains(number)) {
                return true;
            }

            visitedList.add(number);
        }

        return false;
    }

    private static boolean checkSuccess(int strikeCount) {

        boolean success = false;

        if (strikeCount == SIZE) {
            System.out.println(SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            success = true;
        }

        return success;
    }

    private static boolean checkAgainGame() {
        int againGame = 1;
        int toBeContinue = Integer.valueOf(Console.readLine());

        System.out.println(toBeContinue);

        boolean again = false;

        if (toBeContinue == againGame) {
            again = true;
        }

        return again;
    }
}
