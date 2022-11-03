package baseball.view;

import baseball.service.ValidateService;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameStartView {

    private static final String INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_NUMBERS_DELIMITER = "";

    private static final String GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String INPUT_GAME_STATE_COMMAND_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private final ValidateService validateService;

    public GameStartView() {
        validateService = new ValidateService();
    }

    public List<Integer> inputNumbers() {
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