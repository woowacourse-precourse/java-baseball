package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        Game Rans = new Game();
        Game.init(Rans);
    }
}
class Array {
    static boolean check_arr(final int[] arr, final int number) {
        for (int value : arr) {
            if (value == number) {
                return true;
            }
        }
        return false;
    }
    static boolean check_arr(final char[] arr, final char number) {
        for (int value : arr) {
            if (value == number) {
                return true;
            }
        }
        return false;
    }



    static char[] get_char(String str) {
        char[] charArray = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            charArray[i] = str.charAt(i);
        }

        return charArray;
    }

    static int get_index(final int[] arr, final int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
class Game {
    private static final int start = 1;
    private static final int end = 9;
    static final int count = 3;
    private static final String message = "숫자를 입력해주세요 : ";
    private static final String smessage = Game.count + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String newgame = "게임을 새로 시작하려면 " + 1+ ", 종료하려면 " + 2+ "를 입력하세요.";

    int[] number = new int[count];

    Game() {
        int rand_num;
        int rand_num_index = 0;

        while (rand_num_index < count) {
            rand_num = this.get_rand_num();

            if (!Array.check_arr(number, rand_num)) {
                number[rand_num_index++] = rand_num;
            }
        }
    }

    Game(String str) {
        for (int i = 0; i < Game.count; i++) {
            number[i] = Integer.parseInt(str.charAt(i) + "");
        }
    }

    private int get_rand_num() {
        return pickNumberInRange(Game.start, Game.end);
    }

    public static void init(Game right_ans) {
        Game answer = Game.get_ans();

        Hint hint = new Hint();
        hint.comp_ans(answer, right_ans);
        hint.result_show();

        if (hint.strike != Game.count) {
            Game.init(right_ans);
            return;
        }

        int new_game_start = Game.check_new_game();
        if (new_game_start == 1) {
            right_ans = new Game();
            Game.init(right_ans);
        }
    }

    private static Game get_ans() {
        System.out.print(message);
        String userInput = readLine();
        Game.check_input(userInput);

        return new Game(userInput);
    }

    private static int check_new_game() {
        System.out.println(smessage);
        System.out.println(newgame);

        String newGameAnswer = readLine();
        return Game.get_new_game_ans_num(newGameAnswer);
    }

    private static int get_new_game_ans_num(String str) {
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

    static void check_input(final String str) {
        if (!Game.check_length(str)) {
            throw new IllegalArgumentException();
        }
        if (!Game.check_input_num(str)) {
            throw new IllegalArgumentException();
        }
        if (!Game.check_eq(str)) {
            throw new IllegalArgumentException();
        }
    }
    static boolean check_input_num(String str) {
        try {
            int numberValue = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        char[] numberArray = Array.get_char(str);
        return !Array.check_arr(numberArray, '0');
    }
    static boolean check_length(final String str) {
        return str.length() == Game.count;
    }

    static boolean check_eq(String str) {
        char[] checkEqual = new char[str.length()];
        char[] word = Array.get_char(str);

        for (int i = 0; i < str.length(); i++) {
            if (Array.check_arr(checkEqual, word[i])) {
                return false;
            }
            checkEqual[i] = word[i];
        }

        return true;
    }
}

class Hint {
    int ball, strike;
    private static final String Ball = "볼";
    private static final String Str = "스트라이크";
    private static final String Out = "낫싱";

    public String toString() {
        return "ball: " + this.ball + ", strike: " + this.strike;
    }

    private void Ball_count() {
        this.ball++;
    }

    private void Str_count() {
        this.strike++;
    }

    void comp_ans(Game answer, Game rightAnswer) {
        int nowNumber;

        for (int i = 0; i < Game.count; i++) {
            nowNumber = answer.number[i];

            if (!Array.check_arr(rightAnswer.number, nowNumber)) {
                continue;
            }
            if (i == Array.get_index(rightAnswer.number, nowNumber)) {
                Str_count();
                continue;
            }

            Ball_count();
        }
    }

    void result_show() {
        String result = "";
        if (this.ball != 0) {
            result += this.ball + Ball;
        }

        if (this.strike != 0) {
            if (this.ball != 0) {
                result += " ";
            }
            result += this.strike + Str;
        }

        if (result.equals("")) {
            result = Out;
        }

        System.out.println(result);
    }
}