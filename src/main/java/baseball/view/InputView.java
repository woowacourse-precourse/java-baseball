package baseball.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String EVERY_CHARACTER = "";
    private static final int NEW_GAME_NUMBER = 1;
    private static final int FINISH_NUMBER = 2;

    public List<Integer> promptNumbers() {
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return Arrays.stream(input.split(EVERY_CHARACTER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public boolean promptNewGame() {
        System.out.println("게임을 새로 시작하려면 " + NEW_GAME_NUMBER + ", 종료하려면 " + FINISH_NUMBER + "를 입력하세요.");
        int number = Integer.parseInt(Console.readLine());
        if (number == NEW_GAME_NUMBER) {
            return true;
        }
        if (number == FINISH_NUMBER) {
            return false;
        }
        return promptNewGame();
    }
}
