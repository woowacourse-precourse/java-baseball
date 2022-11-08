package baseball.view;

import baseball.dto.SelectedNumberForRestartDTO;
import baseball.dto.UserNumbersDTO;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String RESTART_SELECT_INPUT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String UTILITY_CLASS_CREATE_EXCEPTION_MESSAGE = "생성할 수 없는 View 클래스입니다.";
    private static final String NUMBER_INPUT_PROMPT_MESSAGE = "숫자를 입력해주세요 : ";
    
    private InputView() {
        throw new IllegalStateException(UTILITY_CLASS_CREATE_EXCEPTION_MESSAGE);
    }
    
    public static UserNumbersDTO inputUserBalls() {
        printNumberInputPromptMessage();
        return new UserNumbersDTO(Console.readLine());
    }
    
    private static void printNumberInputPromptMessage() {
        System.out.print(NUMBER_INPUT_PROMPT_MESSAGE);
    }
    
    public static SelectedNumberForRestartDTO inputNumberForRestart() {
        printRestartSelectInputMessage();
        return new SelectedNumberForRestartDTO(Console.readLine());
    }
    
    private static void printRestartSelectInputMessage() {
        System.out.println(RESTART_SELECT_INPUT_MESSAGE);
    }
}
