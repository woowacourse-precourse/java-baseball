package baseball.valid;

import java.util.Stack;

import static baseball.constant.constants.*;

public class Valid {
    //region UserClass Valid
    /**
     * User 입력이 3자리 수가 아니면 IllegalArgumentException를 Throw한다.
     * @param str User 입력
     */
    public static void validUserInputSize(String str){
        if(str.length() != NUMBER_LIMIT_LENGTH) {
            throw new IllegalArgumentException(FALSE_RANGE);
        }
    }

    /**
     * User가 숫자가 아닌 문자를 입력하면 IllegalArgumentException Throw
     * @param str User 입력
     */
    public static void validUserInputNotNumber(String str){
        for(int i=0;i<str.length();i++){
            if(!Character.isDigit(str.charAt(i))) {
                throw new IllegalArgumentException(NOT_NUMBER);
            }
        }
    }

    /**
     * User가 입력한 문자열 중 중복되는 숫자가 있으면 IllegalArgumentException Throw
     * @param str User 입력
     */
    public static void validDuplicateNumber(String str){
        Stack<Character> stack = new Stack<>();

        for(char c : str.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == c) {
                throw new IllegalArgumentException(DUPLICATE_NUMBER);
            }
            stack.push(c);
        }
    }

    /**
     * 게임 재시작 입력 시 1과 2를 입력하지 않으면 오류를 내는 메소드
     * @param str User 입력
     */
    public static void validRestartNumber(String str){
        if(str.equals(RESTART) || str.equals(EXIT)) {
            return;
        }
        throw new IllegalArgumentException(NOT_FOR_RESTART);
    }
    //endregion
}
