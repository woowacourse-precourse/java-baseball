package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class NumberGenerator {
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;
    static final int NUMBER_LENGTH = 3;
    private static final int NEW_GAME = 1;
    private static final int QUIT_GAME = 2;

    private static final String GET_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String SUCCESS_MESSAGE = NumberGenerator.NUMBER_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NEW_GAME_CHECK_MESSAGE = "게임을 새로 시작하려면 " + NumberGenerator.NEW_GAME + ", 종료하려면 " + NumberGenerator.QUIT_GAME + "를 입력하세요.";

    int[] number = new int[NUMBER_LENGTH];

    NumberGenerator() {
        int nowRandomNum;
        int nowNumberIndex = 0;
        while (nowNumberIndex < NEW_GAME) {
            nowRandomNum = this.getRandomNumber();
            if (!RelationArray.checkArrayContains(number, nowRandomNum)) {
                number[nowNumberIndex++] = nowRandomNum;
            }
        }
    }

    NumberGenerator(String str) {
        for (int i = 0; i < NumberGenerator.NUMBER_LENGTH; i++) {
            number[i] = Integer.parseInt(str.charAt(i) + "");
        }
    }
    private int getRandomNumber() {
        return pickNumberInRange(NumberGenerator.START_RANGE, NumberGenerator.END_RANGE);
    }
    public static void init(NumberGenerator rightAnswer) {
        NumberGenerator answer = NumberGenerator.getAnswer();
        GameInfo hint = new GameInfo();
        hint.compareAnswer(answer, rightAnswer);
        hint.showResult();
        if (hint.strike != NumberGenerator.NUMBER_LENGTH) {
            NumberGenerator.init(rightAnswer);
            return;
        }

        int newGameAnswer = NumberGenerator.checkNewGameStart();

        if (newGameAnswer == NumberGenerator.NEW_GAME) {
            rightAnswer = new NumberGenerator();
            NumberGenerator.init(rightAnswer);
        }
    }

    private static NumberGenerator getAnswer() {
        System.out.print(GET_NUMBER_MESSAGE);
        String userInput = readLine();
        NumberGenerator.checkInputValue(userInput);

        return new NumberGenerator(userInput);
    }

    private static int checkNewGameStart() {
        System.out.println(SUCCESS_MESSAGE);
        System.out.println(NEW_GAME_CHECK_MESSAGE);

        String newGameAnswer = readLine();
        return NumberGenerator.getNewGameAnswerNumber(newGameAnswer);
    }

    private static int getNewGameAnswerNumber(String str) {
        int intValue;
        try {
            intValue = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (intValue != 1 && intValue != 2) {
            throw new IllegalArgumentException();
        }

        return intValue;
    }

    public String toString() {
        return "number: " + this.number[0] + this.number[1] + this.number[2];
    }
    static void checkInputValue(final String str) {
        if (!NumberGenerator.checkInputLength(str)) {
            throw new IllegalArgumentException();
        }
        if (!NumberGenerator.checkInputNumber(str)) {
            throw new IllegalArgumentException();
        }
        if (!NumberGenerator.checkEqualNumber(str)) {
            throw new IllegalArgumentException();
        }
    }
    static boolean checkInputLength(final String str) {
        return str.length() == NumberGenerator.NUMBER_LENGTH;
    }
    static boolean checkInputNumber(String str) {
        try {
            int numberValue = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        char[] numberArray = RelationArray.getCharArrayFromString(str);
        return !RelationArray.checkArrayContains(numberArray, '0');
    }
    static boolean checkEqualNumber(String str) {
        char[] checkEqual = new char[str.length()];
        char[] word = RelationArray.getCharArrayFromString(str);
        for (int i = 0; i < str.length(); i++) {
            if (RelationArray.checkArrayContains(checkEqual, word[i])) {
                return false;
            }
            checkEqual[i] = word[i];
        }
        return true;
    }
}
