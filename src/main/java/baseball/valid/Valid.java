package baseball.valid;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Valid {
    //region UserClass Valid
    /**
     * User 입력이 3자리 수가 아니면 IllegalArgumentException를 Throw한다.
     * @param str User 입력
     */
    public static void validUserInputSize(String str){
        if(str.length() != 3)
            throw new IllegalArgumentException("3자리 수를 입력해야 합니다");
    }

    /**
     * User가 숫자가 아닌 문자를 입력하면 IllegalArgumentException Throw
     * @param str User 입력
     */
    public static void validUserInputNotNumber(String str){
        for(int i=0;i<str.length();i++){
            if(!Character.isDigit(str.charAt(i)))
                throw new IllegalArgumentException("숫자가 아닌 문자가 입력되었습니다.");
        }
    }

    /**
     * User가 입력한 문자열 중 중복되는 숫자가 있으면 IllegalArgumentException Throw
     * @param str User 입력
     */
    public static void validDuplicateNumber(String str){
        Stack<Character> stack = new Stack<>();

        for(char c : str.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == c)
                throw new IllegalArgumentException("중복된 숫자가 입력되었습니다");
            else
                stack.push(c);
        }
    }
    //endregion
}
