package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ValidationNumber {

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
