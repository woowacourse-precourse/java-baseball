package baseball.exception;

import java.util.List;

public class UserNumberValidator {

    /**
     * 사용자가 입력한 수에 대해 검증하는 함수
     */
    public static boolean checkValidationUserNumber(List<Integer> userNumberList){
        return isDifferent(userNumberList) && isThreeNumber(userNumberList) && isNotZero(userNumberList);
    }

    /**
     * 유저의 3가지 숫자가 모두 다른지 확인
     */
    public static boolean isDifferent(List<Integer> userNumberList){
        Integer userNumberLen = Math.toIntExact(userNumberList.stream().distinct().count());
        return userNumberLen==3;
    }

    /**
     * 유저가 3개의 숫자를 입력했는지 확인하는 함수
     */
    public static boolean isThreeNumber(List<Integer> userNumberList){
        Integer userNumberLen = userNumberList.size();
        return userNumberLen==3;
    }

    /**
     * 유저가 입력한 3개의 숫자에 0이 없는지 확인
     */
    public static boolean isNotZero(List<Integer> userNumberList){
        return !userNumberList.contains(0);
    }
}
