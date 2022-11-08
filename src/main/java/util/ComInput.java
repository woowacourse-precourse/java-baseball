package util;

import java.util.List;

public class ComInput {
    public static boolean isValidComInput(List<Integer> numbers) {

        return isDiffer(numbers);
    }

    private static boolean isDiffer(List<Integer> numbers) {

        for (int i=0; i<numbers.size()-1; i++){
            int curValue = numbers.get(i);
            int nextValue = numbers.get(i+1);
            if (curValue == nextValue){
                return false;
            }
        }

        return true;
    }
}
