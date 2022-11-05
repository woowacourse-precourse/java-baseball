package baseball.view.input;


import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputImpl implements Input {

    private final String REGEX = "^[1-9]{3}$";
    private final int NEW_GAGE = 1;
    private final int QUIT = 2;

    @Override
    public String baseballInput() {
        String baseballInput = Console.readLine();
        if (isAllowedBaseballInput(baseballInput) && isEachNumberDifferent(baseballInput)) {
            return baseballInput;
        }
        return null;
    }

    @Override
    public String endInput() {
        String endInput = Console.readLine();
        if (isAllowedEndInput(endInput)) {
            return endInput;
        }
        return null;
    }

    private boolean isAllowedEndInput(String endInput) {
        int endInputNumber = Integer.parseInt(endInput);
        if (endInputNumber == NEW_GAGE || endInputNumber == QUIT) {
            return true;
        }
        throw new IllegalArgumentException("새로운 게임을 시작혀려면1, 종료하려면 2를 입력하세요.");
    }

    private boolean isAllowedBaseballInput(String baseballInput) throws IllegalArgumentException {
        if (baseballInput.matches(REGEX)) {
            return true;
        }
        throw new IllegalArgumentException("서로다른 3자리 숫자만 입력 가능합니다.");
    }

    private boolean isEachNumberDifferent(String baseballInput) throws IllegalArgumentException{
        String[] baseballNumber = baseballInput.split("");
        List<String> distinctNumber = Arrays.stream(baseballNumber)
                .distinct()
                .collect(Collectors.toList());
        if (distinctNumber.size() == 3) {
            return true;
        }
        throw new IllegalArgumentException("서로다른 3자리 숫자만 입력 가능합니다.");
    }

}
