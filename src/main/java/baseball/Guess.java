package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.Constant.WRITE_ANSWER;

public class Guess {
    public static String takeGuess() {
        System.out.print(WRITE_ANSWER);
        return Console.readLine();
    }
}
