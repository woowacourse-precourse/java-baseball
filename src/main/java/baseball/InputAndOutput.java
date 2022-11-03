package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputAndOutput {

    private static final String ANSWER_REQUEST_PHRASE = "숫자를 입력해주세요 : ";
    private static final String RESTART_OR_END_PHRASE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String ENDANSWER_ERR_MESSAGE = "1 혹은 2가 아닙니다.";

    public static String getUserAnswer() {
        System.out.print(ANSWER_REQUEST_PHRASE);
        return Console.readLine();
    }

    public static String getRestartOrEnd() {
        System.out.println(RESTART_OR_END_PHRASE);
        return Console.readLine();
    }

    public boolean isValidEndAnswer(String endAnswer) {
        if (!checkLength(endAnswer) || !checkIsItOneOrTwo(endAnswer)) {
            throw new IllegalArgumentException(ENDANSWER_ERR_MESSAGE);
        }

        return true;
    }

    private boolean checkLength(String endAnswer) {
        return endAnswer.length() == 1;
    }

    private boolean checkIsItOneOrTwo(String endAnswer) {
        int ascii = endAnswer.charAt(0);

        return ascii >= 49 && ascii <= 50;
    }
}