package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private final static String  REQUEST_PLAYER_GUESS = "숫자를 입력해주세요 : ";

    public static void getPlayerGuess() {
        System.out.print(REQUEST_PLAYER_GUESS);
        String playerGuess = Console.readLine();
    }
}
