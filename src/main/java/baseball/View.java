package baseball;

import camp.nextstep.edu.missionutils.Console;

public class View {
    private static final String START ="숫자 야구 게임을 시작합니다.";
    private static final String ASK_INPUT ="숫자를 입력해주세요 : ";
    private static final String RESULT_CORRECT ="3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String ASK_KEEP_PLAYING ="게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final Validator validator = new Validator();
    public void printStart(){
        System.out.println(START);
    }

    public String getUserInput() throws IllegalArgumentException {
        System.out.println(ASK_INPUT);
        String input = Console.readLine().trim();
        if (!validator.isNumber(input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    public void printHint(String hint) {
        System.out.println(hint);
    }

    public String getExitInput() throws IllegalArgumentException {
        System.out.println(RESULT_CORRECT);
        System.out.println(ASK_KEEP_PLAYING);

        String input = Console.readLine().trim();
        if (!validator.isValidCommandNumber(input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }
}


