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


}
public class Application {
    public static void main(String[] args) {
        Game game = new Game();

    }
}
