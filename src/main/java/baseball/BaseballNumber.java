package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BaseballNumber {

    public List<Integer> stringToIntegerList(String number) {
        List<Integer> returnList = new ArrayList<>();
        String[] split = number.split("");
        for(String target : split) {
            returnList.add(Integer.parseInt(target));
        }
        return returnList;
    }

    private void checkIsNumberAndNotHaveZero(String number) {
        String numberRegex = "^[1-9]*$";
        if(!number.matches(numberRegex)) {
            throw new IllegalArgumentException();
        }
    }

    private void checkOverlap(List<Integer> number, int size) {
        HashSet<Integer> numberSet = new HashSet<>(number);

        if (numberSet.size() != size) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNumberSize(List<Integer> number, int size) {
        if(number.size() != size) {
            throw new IllegalArgumentException();
        }
    }
}
