package baseball;

import java.util.List;

public class UserNumberValidator {

    /**
     * 유저의 3가지 숫자가 모두 다른지 확인
     */
    public boolean isDifferent(List<Integer> userNumberList){
        Integer userNumberLen = Math.toIntExact(userNumberList.stream().distinct().count());
        return userNumberLen==3;
    }

    /**
     * 유저가 3개의 숫자를 입력했는지 확인하는 함수
     */
    public boolean isThreeNumber(List<Integer> userNumberList){
        Integer userNumberLen = userNumberList.size();
        return userNumberLen==3;
    }
}
