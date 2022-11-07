package baseball.view;

import baseball.service.ValidateService;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameStartView {

    private static final String INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_NUMBERS_DELIMITER = "";

    private final ValidateService validateService;

    public GameStartView() {
        validateService = new ValidateService();
    }

    public List<Integer> getInputNumbers() {
        System.out.print(INPUT_NUMBERS_MESSAGE);
        String inputBaseBallNumbers = Console.readLine();

        validateInputNumber(inputBaseBallNumbers);

        return Arrays.stream(inputBaseBallNumbers.split(INPUT_NUMBERS_DELIMITER))
                .map(Integer::new)
                .collect(Collectors.toList());
    }

    private void validateInputNumber(String inputBaseBallNumbers) {
        validateService.validateInputValue(inputBaseBallNumbers);
    }
}