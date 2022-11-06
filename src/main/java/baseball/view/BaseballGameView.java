package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGameView {
    private static final String START_BASEBALL_GAME = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_USER_INPUT = "숫자를 입력해주세요 : ";
    private static final String GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_OR_END = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static final String END_INPUT_EMPTY_STRING = "빈 문자열을 입력하셨습니다";
    private static final String END_INPUT_NOT_NUMBER = "숫자를 입력해주세요";
    private static final String END_INPUT_INVALID_NUMBER_SIZE = "두 자리 이상 숫자를 입력하셨습니다";
    private static final String END_INPUT_INVALID_END_TYPE = "1, 2 이외의 숫자를 입력하셨습니다";
    private static final String END_INPUT_TYPE_RESTART = "1";
    private static final String END_INPUT_TYPE_END = "2";

    public void startBaseballGame() {
        System.out.println(START_BASEBALL_GAME);
    }

    public String getUserInput() {
        System.out.printf(GAME_USER_INPUT);
        String userBaseballInput = Console.readLine();
        return userBaseballInput;
    }

    public void printUserInputHint(String userInputResult) {
        System.out.println(userInputResult);
    }

    public int endBaseballGame() {
        System.out.println(GAME_END);
        System.out.println(RESTART_OR_END);
        String endGameInput = Console.readLine();
        validateEndGameInput(endGameInput);
        validateNumberString(endGameInput);
        int endGameType = Integer.parseInt(endGameInput);
        return endGameType;
    }

    public void validateEndGameInput(String endGameInput) {
        if (endGameInput.isBlank()) {
            throw new IllegalArgumentException(END_INPUT_EMPTY_STRING);
        }

    }

    public boolean isNumberString(String uncheckedString) {
        for (int i = 0; i < uncheckedString.length(); i++) {
            char uncheckedCharacter = uncheckedString.charAt(i);
            if(!Character.isDigit(uncheckedCharacter)) {
                return false;
            }
        }
        return true;
    }

    public void validateNumberString(String endGameInput) {
        if (!isNumberString(endGameInput)) {
            throw new IllegalArgumentException(END_INPUT_NOT_NUMBER);
        }
        if(endGameInput.length() > 1) {
            throw new IllegalArgumentException(END_INPUT_INVALID_NUMBER_SIZE);
        }
        if(!endGameInput.equals(END_INPUT_TYPE_RESTART) && !endGameInput.equals(END_INPUT_TYPE_END)) {
            throw new IllegalArgumentException(END_INPUT_INVALID_END_TYPE);
        }
    }
}
