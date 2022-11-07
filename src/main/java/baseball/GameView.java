package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameView {
    private final String GAME_START_TEXT = "숫자 야구 게임을 시작합니다.";
    private final String INPUT_NUMBER_TEXT = "숫자를 입력해주세요 : ";

    private String proceedGame() {
        BaseballGame game = new BaseballGame();
        InputValidation inputValidation = new InputValidation();
        String inputValue;

        System.out.print(GAME_START_TEXT);
        System.out.print(INPUT_NUMBER_TEXT);
        inputValue = Console.readLine();

        try {
            inputValidation.validateInputValue(inputValue);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

        return "";
    }
}