package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    public static final Pattern NUMBER_REGEX = Pattern.compile("^[1-9]+$");

    public List<Integer> readPlayerNumber() {
        String input = getValidatedPlayerNumber(Console.readLine());
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private String getValidatedPlayerNumber(String playerNumber) {
        if (!NUMBER_REGEX.matcher(playerNumber).matches()) {
            throw new IllegalArgumentException("1부터 9까지의 숫자만 입력 가능합니다.");
        }
        if (!isNumeric(playerNumber)) {
            throw new IllegalArgumentException("입력 범위를 초과했습니다.");
        }
        if (playerNumber.length() != 3) {
            throw new IllegalArgumentException("세 자리 자연수를 입력해 주세요.");
        }
        return playerNumber;
    }

    private boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }
}
