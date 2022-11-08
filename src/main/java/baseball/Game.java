package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String SUCCESS_MESSAGE = ReferenceValue.SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String AGAIN_QUESTION_MESSAGE = "게임을 새로 시작하려면 " + ReferenceValue.AGAIN + ", 종료하려면 " + ReferenceValue.EXIT + "를 입력하세요.";

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

        boolean result = checkSuccess(record);

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

    private static List<Integer> getUserNumbers(String input) {
        List<Integer> user = new ArrayList<>();

        for (int i = 0; i < ReferenceValue.SIZE; i++) {
            char currentValue = input.charAt(i);
            int number = Character.getNumericValue(currentValue);
            user.add(number);
        }

        return user;
    }

    private static List<Integer> getComputerNumbers() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < ReferenceValue.SIZE) {
            int randomNumber = getPickNumber();
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static int getPickNumber() {
        int number = Randoms.pickNumberInRange(ReferenceValue.START_RANGE, ReferenceValue.END_RANGE);
        return number;
    }

    private static void printAgainQuestion() {
        System.out.println(AGAIN_QUESTION_MESSAGE);
    }

    private static boolean checkSuccess(Record record) {

        boolean success = false;

        int strikeCount = record.strikeCount;

        if (strikeCount == ReferenceValue.SIZE) {
            System.out.println(SUCCESS_MESSAGE);
            success = true;
        }

        return success;
    }

    private static boolean checkAgainGame() {

        String input = Console.readLine();

        boolean isNumber = ValidCheck.checkIsNumberError(input);
        if (isNumber) {
            throw new IllegalArgumentException();
        }

        int toBeContinue = Integer.valueOf(input);
        System.out.println(toBeContinue);

        boolean isContinue = ValidCheck.checkIsContinueError(toBeContinue);
        if (isContinue) {
            throw new IllegalArgumentException();
        }

        boolean again = false;

        if (toBeContinue == ReferenceValue.AGAIN) {
            again = true;
        }

        return again;
    }


    private static void runException(String input) {

        boolean isNumber = ValidCheck.checkIsNumberError(input);
        boolean isSize = ValidCheck.checkSizeError(input);
        boolean isRange = ValidCheck.checkRangeError(input);
        boolean isVisited = ValidCheck.checkVisitedError(input);

        if (isNumber || isSize || isRange || isVisited) {
            throw new IllegalArgumentException();
        }
    }

}
