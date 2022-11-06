package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {
    static final int NEW_GAME = 1;
    static final int END_GAME = 2;

    public List<Integer> askNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        return parseUserNumbersToList(userInput);
    }

    public List<Integer> parseUserNumbersToList(String userAnswer) {
        List<Integer> parsedAnswer = new ArrayList<>();

        if (userAnswer.length() != 3) {
            throw new IllegalArgumentException("숫자 3개만 입력해주세요");
        }

        try {
            Arrays.stream(userAnswer.split(""))
                    .forEach((num) -> parsedAnswer.add(Integer.parseInt(num)));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }

        return parsedAnswer;
    }

    public void announce(String announcement) {
        System.out.println(announcement);
    }

    public boolean askRegame() {
        announce("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();
        int answer;
        try {
            answer = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }

        if (answer == NEW_GAME) {
            return true;
        }

        else if (answer == END_GAME) {
            return false;
        }

        else {
            throw new IllegalArgumentException("1 혹은 2로만 대답해주세요");
        }
    }
}
