package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ValidationNumber {

    int gameNumberSize;

    ValidationNumber(int size) {
        gameNumberSize = size;
    }

    public void check(String number) {
        checkIsNumberAndNotHaveZero(number);
        // 위의 check를 통과했다면 주어진 number에는 숫자만 존재한다. parseInt() 에러 발생 X
        List<Integer> numberList = stringToIntegerList(number);
        checkOverlap(numberList, gameNumberSize);
        checkNumberSize(numberList, gameNumberSize);
    }

    public List<Integer> stringToIntegerList(String number) {
        List<Integer> returnList = new ArrayList<>();
        String[] split = number.split("");
        for(String target : split) {
            returnList.add(Integer.parseInt(target));
        }
        return returnList;
    }

    public void checkIsNumberAndNotHaveZero(String number) {
        String numberRegex = "^[1-9]*$";
        if(!number.matches(numberRegex)) {
            throw new IllegalArgumentException();
        }
    }

    public void checkOverlap(List<Integer> number, int size) {
        HashSet<Integer> numberSet = new HashSet<>(number);

        if (numberSet.size() != size) {
            throw new IllegalArgumentException();
        }
    }

    public void checkNumberSize(List<Integer> number, int size) {
        if(number.size() != size) {
            throw new IllegalArgumentException();
        }
    }
}
