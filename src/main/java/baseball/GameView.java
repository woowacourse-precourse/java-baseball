package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameView {
    private final int NUMBER_LENGTH = 3;
    private final String RESTART_NUMBER = "1";
    private final String GAME_START_TEXT = "숫자 야구 게임을 시작합니다.";
    private final String INPUT_NUMBER_TEXT = "숫자를 입력해주세요 : ";
    private final String EXIT_GAME_TEXT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void startGame() {
        System.out.println(GAME_START_TEXT);
        String status;
        do {
            status = this.proceedGame();
        } while (status.equals(RESTART_NUMBER));
    }

    private String proceedGame() {
        BaseballGame game = new BaseballGame();
        InputValidation inputValidation = new InputValidation();
        String inputValue;

        while (game.getStrike() != NUMBER_LENGTH) {
            System.out.print(INPUT_NUMBER_TEXT);
            inputValue = Console.readLine();

            try {
                inputValidation.validateInputValue(inputValue);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
            System.out.println(game.startMatch(inputValue));
        }
        System.out.print(EXIT_GAME_TEXT);

        return "";
    }
}