package baseball.exception;

import static baseball.exception.ErrorMessage.INPUT_TYPE;

public class TypeException {


    /**
     * 플레이어가 입력한 문자중에 숫자가 아닌 문자가 포함되면 예외 처리한다.
     *
     * @param input 플레이어가 입력한 문자
     * @throws IllegalArgumentException 입력받은 문자중에 숫자가 아닌문자가 포함되면 던진다.
     */
    public void typeException(String input) throws IllegalArgumentException {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException(INPUT_TYPE.getErrorMessage());
            }
        }
    }
}
