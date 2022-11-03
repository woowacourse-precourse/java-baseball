package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    public final static String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public final static int NUMBER_COUNT_TO_CREATED = 3;

    private List<Integer> computerNumbers = new ArrayList<>();
    private int strikeCount;
    private int ballCount;
    private String message;

    public void start() {
        System.out.println(GAME_START_MESSAGE);
        createComputerNumbers();
        String input = Console.readLine();
        isWrongInputValue(input);
        for (int i = 0; i < computerNumbers.size(); i++) {
            String val = String.valueOf(computerNumbers.get(i));
            if (input.contains(val)) {
                if (val.equals(String.valueOf(input.charAt(i)))) {
                    strikeCount++;
                }
                if (!val.equals(String.valueOf(input.charAt(i)))) {
                    ballCount++;
                }
            }
        }
    }

    private void isWrongInputValue(String input) {
        if (input.length() != NUMBER_COUNT_TO_CREATED) {
            throw new IllegalArgumentException();
        }

        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }

        if (input.contains("0")) {
            throw new IllegalArgumentException();
        }

        if (input.length() != input.chars().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    private void createComputerNumbers() {
        computerNumbers = Randoms
                .pickUniqueNumbersInRange(1, 9, NUMBER_COUNT_TO_CREATED);
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }
}
