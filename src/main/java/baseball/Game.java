package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private static final int TOTAL_SIZE = 3;
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;
    private static final int AGAIN = 1;
    private static final int EXIT = 2;
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String SUCCESS_MESSAGE = TOTAL_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String AGAIN_QUESTION_MESSAGE = "게임을 새로 시작하려면 " + AGAIN + ", 종료하려면 " + EXIT + "를 입력하세요.";

    List<Integer> numbers;

    public Game() {
        numbers = getComputerNumbers();
    }

    public Game(String input) {
        numbers = getUserNumbers(input);
    }

    public static void play(Game computer) {
        Game user = Game.getUserGame();

        Record record = new Record();
        record.setEachCounts(computer, user);
        record.displayRecord();

        int strikeCount = record.strikeCount;
        boolean result = checkSuccess(strikeCount);

        if (!result) {
            Game.play(computer);
            return;
        }

        printAgainQuestion();
        boolean again = checkAgainGame();

        if (again) {
            computer = new Game();
            Game.play(computer);
        }
    }

    private static Game getUserGame() {
        String input = Console.readLine();
        System.out.println(INPUT_MESSAGE + input);

        runException(input);

        Game game = new Game(input);
        return game;
    }

    private static List<Integer> getComputerNumbers() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < TOTAL_SIZE) {
            int randomNumber = getPickNumber();
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    private static void printAgainQuestion() {
        System.out.println(AGAIN_QUESTION_MESSAGE);
    }
    private static boolean checkSuccess(int strikeCount) {

        boolean success = false;

        if (strikeCount == TOTAL_SIZE) {
            System.out.println(SUCCESS_MESSAGE);
            success = true;
        }

        return success;
    }
    private static boolean checkAgainGame() {
        int toBeContinue;

        try {
            toBeContinue = Integer.valueOf(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        System.out.println(toBeContinue);

        if (toBeContinue != AGAIN && toBeContinue != EXIT) {
            throw new IllegalArgumentException();
        }

        boolean again = false;

        if (toBeContinue == AGAIN) {
            again = true;
        }

        return again;
    }
    private static int getPickNumber() {
        int number = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
        return number;
    }

    private static List<Integer> getUserNumbers(String input) {
        List<Integer> user = new ArrayList<>();

        for (int i = 0; i < TOTAL_SIZE; i++) {
            char currentValue = input.charAt(i);
            int number = Character.getNumericValue(currentValue);
            user.add(number);
        }

        return user;
    }

    private static void runException(String input) {

        if (checkSizeError(input) || checkRangeError(input) || checkVisitedError(input)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean checkRangeError(String input) {

        for (int i = 0; i < TOTAL_SIZE; i++) {
            char value = input.charAt(i);
            int number = Character.getNumericValue(value);

            boolean rangeCheck = (number >= START_RANGE) && (number <= END_RANGE);

            if (!rangeCheck) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkSizeError(String input) {
        int size = input.length();

        if (size != TOTAL_SIZE) {
            return true;
        }

        return false;
    }

    private static boolean checkVisitedError(String input) {
        List<Integer> visitedList = new ArrayList<>();

        for (int i = 0; i < TOTAL_SIZE; i++) {
            char value = input.charAt(i);
            int number = Character.getNumericValue(value);

            if (visitedList.contains(number)) {
                return true;
            }

            visitedList.add(number);
        }

        return false;
    }

}
