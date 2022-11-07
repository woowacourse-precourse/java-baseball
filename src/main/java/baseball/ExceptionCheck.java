package baseball;

import java.util.List;

public class ExceptionCheck {

    public static boolean noException(String input, List<Integer> Input){
        checkExceptionforLength(Input);
        for(int i = 0; i < input.length() ;i++){
            checkExceptionforSameValue((int)(input.charAt(i) -'0'), i,Input);
            checkExceptionforFormat(input.charAt(i), Input);
        }
        return true;
    }

    public static void checkExceptionforFormat(char c, List<Integer> Input){
        if(c == '0'){
            throw new IllegalArgumentException("0이 포함된 수가 입력되었습니다.");
        }
    }
    public static void checkExceptionforLength(List<Integer> Input){
        if(Input.size() != 3){
            throw new IllegalArgumentException("세 자리수가 아닌 숫자가 입력되었습니다.");
        }
    }

    public static void checkExceptionforSameValue(int c, int index, List<Integer> Input){
        if(Input.contains(c) && index != Input.indexOf(c)){
            throw new IllegalArgumentException("같은 숫자가 있는 수가 입력되었습니다.");
        }
    }
}
