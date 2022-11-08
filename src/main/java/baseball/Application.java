package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Game rightAnswer = new Game();
        Game.init(rightAnswer);
    }
}

class Game {

    int[] number = new int[3];

    Game() {
        int nowRandomNum;
        int nowNumberIndex = 0;

        while (nowNumberIndex < 3) {
            nowRandomNum = this.randNum();

            if (!Another.checkArray(number, nowRandomNum)) {
                number[nowNumberIndex++] = nowRandomNum;
            }
        }
    }

    Game(String str) {
        for (int i = 0; i < 3; i++) {
            number[i] = Integer.parseInt(str.charAt(i) + "");
        }
    }

    private int randNum() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public static void init(Game rightAnswer) {
        Game answer = Game.getAnswer();

        gameHint hint = new gameHint();
        hint.compareAnswer(answer, rightAnswer);
        hint.showResult();

        if (hint.strike != 3) {
            Game.init(rightAnswer);
            return;
        }

        int newGameAnswer = Game.checkNewGameStart();
        if (newGameAnswer == 1) {
            rightAnswer = new Game();
            Game.init(rightAnswer);
        }
    }

    private static Game getAnswer() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        Game.checkInputValue(userInput);

        return new Game(userInput);
    }

    private static int checkNewGameStart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String newGameAnswer = Console.readLine();

        return Game.getNewGameAnswerNumber(newGameAnswer);
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

    static void checkInputValue(final String str) {
        if (!Game.checkInputLength(str)) {
            throw new IllegalArgumentException();
        }
        if (!Game.checkInputNumber(str)) {
            throw new IllegalArgumentException();
        }
        if (!Game.checkEqualNumber(str)) {
            throw new IllegalArgumentException();
        }
    }

    static boolean checkInputLength(final String str) {
        return str.length() == 3;
    }

    static boolean checkInputNumber(String str) {
        try {
            int numberValue = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        char[] numberArray = Another.Char2String(str);
        return !Another.checkArrayContains(numberArray, '0');
    }

    static boolean checkEqualNumber(String str) {
        char[] checkEqual = new char[str.length()];
        char[] word = Another.Char2String(str);

        for (int i = 0; i < str.length(); i++) {
            if (Another.checkArrayContains(checkEqual, word[i])) {
                return false;
            }
            checkEqual[i] = word[i];
        }

        return true;
    }
}

class gameHint {
    int ball, strike;

    private void addBallCount() {
        ball++;
    }

    private void addStrikeCount() {
        strike++;
    }

    void compareAnswer(Game answer, Game rightAnswer) {
        int nowNumber;

        for (int i = 0; i < 3; i++) {
            nowNumber = answer.number[i];

            if (!Another.checkArray(rightAnswer.number, nowNumber)) {
                continue;
            }
            if (i == Another.getIndexFromValue(rightAnswer.number, nowNumber)) {
                addStrikeCount();
                continue;
            }

            addBallCount();
        }
    }

    void showResult() {
        String result = "";
        if (ball != 0) {
            result += ball + "볼";
        }

        if (strike != 0) {
            if (ball != 0) {
                result += " ";
            }
            result += strike + "스트라이크";
        }

        if (result.equals("")) {
            result = "낫싱";
        }

        System.out.println(result);
    }
}
class Another {
    static boolean checkArray(int[] arr, int number) {
        for (int value : arr) {
            if (value == number) {
                return true;
            }
        }
        return false;
    }

    static boolean checkArrayContains(char[] arr, char number) {
        for (int value : arr) {
            if (value == number) {
                return true;
            }
        }
        return false;
    }

    static char[] Char2String(String str) {
        char[] charArray = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            charArray[i] = str.charAt(i);
        }

        return charArray;
    }

    static int getIndexFromValue(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}