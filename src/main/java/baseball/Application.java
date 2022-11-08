package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

class Array {
    static boolean checkArrayContains(final int[] arr, final int number) {
        for (int value : arr) {
            if (value == number) {
                return true;
            }
        }
        return false;
    }
    static boolean checkArrayContains(final char[] arr, final char number) {
        for (int value : arr) {
            if (value == number) {
                return true;
            }
        }
        return false;
    }
    static char[] getCharArrayFromString(String str) {
        char[] charArray = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            charArray[i] = str.charAt(i);
        }

        return charArray;
    }
    static int getIndexFromValue(final int[] arr, final int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

}

class Score {
    int ball, strike;

    private static final String BALL= "볼";
    private static final String STRIKE= "스트라이크";
    private static final String NOTHING= "낫싱";

    public String toString() {
        return "ball: " + this.ball + ", strike: " + this.strike;
    }

    private void addBallCount() {
        this.ball++;
    }

    private void addStrikeCount() {
        this.strike++;
    }

    //3.같은 수가 같은 자리에 있는가? 다른 자리에 있는가? (같은 자리에 -> 스트라이크,다른 자리에 -> 볼)

    void compareAnswer(Game answer, Game rightAnswer) {
        int nowNumber;

        for (int i = 0; i < Game.NUMBER_COUNT; i++) {
            nowNumber = answer.number[i];

            if (!Array.checkArrayContains(rightAnswer.number, nowNumber)) {
                continue;
            }
            if (i == Array.getIndexFromValue(rightAnswer.number, nowNumber)) {
                addStrikeCount();
                continue;
            }

            addBallCount();
        }
    }

    //4. 결과 출력 (스트라이크=0 볼=0 이면 낫싱)
    void showResult() {
        String result = "";
        if (this.ball != 0) {
            result += this.ball + BALL;
        }

        if (this.strike != 0) {
            if (this.ball != 0) {
                result += " ";
            }
            result += this.strike + STRIKE;
        }

        if (result.equals("")) {
            result = NOTHING;
        }

        System.out.println(result);
    }
}


class Game {
    private static final int START = 1;
    private static final int END = 9;
    static final int NUMBER_COUNT = 3;
    private static final int NEW = 1;
    private static final int QUIT= 2;

    int[] number = new int[NUMBER_COUNT];

    Game() {//컴퓨터가 1~9까지 서로 다른 임의의 수 3개 선택
        int nowRandomNum;
        int nowNumberIndex = 0;

        while (nowNumberIndex < NUMBER_COUNT) {
            nowRandomNum = this.getRandomNumber();

            if (!Array.checkArrayContains(number, nowRandomNum)) {
                number[nowNumberIndex++] = nowRandomNum;
            }
        }
    }

    Game(String str) {
        for (int i = 0; i < Game.NUMBER_COUNT; i++) {
            number[i] = Integer.parseInt(str.charAt(i) + "");
        }
    }

    private int getRandomNumber() {//1~9까지 임의의 수
        return pickNumberInRange(Game.START, Game.END);
    }

    public static void init(Game rightAnswer) {
        Game answer = Game.getAnswer();

        Score sc = new Score();
        sc.compareAnswer(answer, rightAnswer);
        sc.showResult();

        if (sc.strike != Game.NUMBER_COUNT) {//모두 맞히지 못한 경우
            Game.init(rightAnswer);
            return;
        }


    }

    private static Game getAnswer() {//2.게임 플레이어의 숫자 입력
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = readLine();
        Game.checkInputValue(userInput);
        return new Game(userInput);
    }

    //사용자가 잘못된 값을 입력할 경우 : 길이, 숫자인지, 같은 숫자가 있는지 확인
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
        return str.length() == Game.NUMBER_COUNT;
    }

    static boolean checkInputNumber(String str) {
        try {
            int numberValue = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        char[] numberArray = Array.getCharArrayFromString(str);
        return !Array.checkArrayContains(numberArray, '0');
    }

    static boolean checkEqualNumber(String str) {
        char[] checkEqual = new char[str.length()];
        char[] word = Array.getCharArrayFromString(str);

        for (int i = 0; i < str.length(); i++) {
            if (Array.checkArrayContains(checkEqual, word[i])) {
                return false;
            }
            checkEqual[i] = word[i];
        }

        return true;
    }


}
public class Application {
    public static void main(String[] args) {
        Game game = new Game();

    }
}
