package baseball.exception;

import java.util.List;

public class UserNumberValidator {

    public static boolean checkValidationUserNumber(List<Integer> userNumberList){
        return isDifferent(userNumberList) && isThreeNumber(userNumberList) && isNotZero(userNumberList);
    }

    public static boolean isDifferent(List<Integer> userNumberList){
        Integer userNumberLen = Math.toIntExact(userNumberList.stream().distinct().count());
        return userNumberLen==3;
    }

    public static boolean isThreeNumber(List<Integer> userNumberList){
        Integer userNumberLen = userNumberList.size();
        return userNumberLen==3;
    }

    public static boolean isNotZero(List<Integer> userNumberList){
        return !userNumberList.contains(0);
    }
}
