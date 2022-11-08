package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Application {
    final static int NUMBER_MIN = 1;
    final static int NUMBER_MAX = 9;

    final static int GAME_PROGRESS = 0;
    final static int GAME_RESTART = 1;
    final static int GAME_END = 2;

    public static ArrayList<Integer> SelectNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();  // numbers chosen by computer

        while ( numbers.size() < 3 ) {
            Integer number = Randoms.pickNumberInRange(NUMBER_MIN, NUMBER_MAX);

            if ( !numbers.contains(number) ) {
                numbers.add(number);
            }
        }

        return numbers;
    }

    public static void CheckExceptionInputNumber(String numbers) {
        if (numbers.length() != 3) {
            throw new IllegalArgumentException("[Invalid] size of the number");
        }

        for(int i = 0; i < (numbers.length() -1); ++i) {
            if ( -1 != numbers.indexOf(numbers.charAt(i), i+1) ) {
                throw new IllegalArgumentException("[Invalid] the same value");
            }
            if ( Integer.valueOf(numbers.charAt(i)) == '0' ) {
                throw new IllegalArgumentException("[Invalid] the zero value");
            }
        }
    }

    public static void BaseballGame() {
        int gameStatus = GAME_PROGRESS;

        ArrayList<Integer> computerNumbers = SelectNumbers();

    }

    public static void main(String[] args) {
        System.out.println("숫자 아구 게임을 시작합니다.");

        BaseballGame();

        System.out.println("게임 종료");
    }
}
