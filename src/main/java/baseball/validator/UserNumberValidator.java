package baseball.validator;

import java.util.List;

import static baseball.constant.GameConstant.BALL_LEN;
import static baseball.constant.GameConstant.ZERO;

public class UserNumberValidator {

    public static void checkValidationUserNumber(List<Integer> userNumberList){
        if(!(isDifferent(userNumberList) && isThreeNumber(userNumberList) && isNotZero(userNumberList)))
            throw new IllegalArgumentException();
    }

    public static boolean isDifferent(List<Integer> userNumberList){
        Integer userNumberLen = Math.toIntExact(userNumberList.stream().distinct().count());
        return userNumberLen==BALL_LEN;
    }

    public static boolean isThreeNumber(List<Integer> userNumberList){
        Integer userNumberLen = userNumberList.size();
        return userNumberLen==BALL_LEN;
    }

    public static boolean isNotZero(List<Integer> userNumberList){
        return !userNumberList.contains(ZERO);
    }

    private UserNumberValidator(){
    }

}
