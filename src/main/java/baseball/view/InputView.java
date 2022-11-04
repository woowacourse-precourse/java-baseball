package baseball.view;

import baseball.dto.UserNumbersDTO;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String UTILITY_CLASS_CREATE_EXCEPTION_MESSAGE = "생성할 수 없는 View 클래스입니다.";
    private static final String NUMBER_INPUT_PROMPT_MESSAGE = "숫자를 입력해주세요 : ";
    
    private InputView() {
        throw new IllegalStateException(UTILITY_CLASS_CREATE_EXCEPTION_MESSAGE);
    }
    
    public static UserNumbersDTO inputUserBalls() {
        System.out.print(NUMBER_INPUT_PROMPT_MESSAGE);
        return new UserNumbersDTO(Console.readLine());
    }
}
