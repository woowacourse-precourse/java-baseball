package baseball;

import java.util.List;
import java.util.Objects;

public class NumberCheckList {

    public static boolean isIntegerList(String word, int index){
        if(Character.isDigit(word.charAt(index))){
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
        return true;
    }

    public static boolean isListSize(List<Integer> List) throws IllegalArgumentException{
        if(List.size() != NumberNaming.MAX_NUMBER_SIZE) {
            throw new IllegalArgumentException("3자리 숫자가 아닙니다.");
        }
        return true;
    }

    public static boolean isOverLap(List<Integer> List){
        for(int i = 1; i < List.size() - 1; i++){
            if (Objects.equals(List.get(i), List.get(i - 1))){
                throw new IllegalArgumentException("숫자가 중복됩니다.");
            }
        }
        return true;
    }





}
