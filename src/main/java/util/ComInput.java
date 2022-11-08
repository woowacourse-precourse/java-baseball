package util;

import java.util.List;

public class ComInput {
    public static boolean isValidComInput(List<Integer> numbers) {

        return isNotDuplicate(numbers);
    }

    private static boolean isNotDuplicate(List<Integer> numbers) {

        for (int i= 0; i<numbers.size(); i++){
            if (isSame(i, numbers)){
                return false;
            }
        }

        return true;
    }

    private static boolean isSame(int curIndex, List<Integer> numbers) {

        for (int i=0; i<numbers.size(); i++){
            int curValue = numbers.get(curIndex);
            int nextValue = numbers.get(i);
            if (i != curIndex && curValue == nextValue){
                return true;
            }
        }

        return false;
    }

}
