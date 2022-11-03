package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class User {
    public static List<Integer> getUserNumber(int inputNumber){
        List<Integer> userNumbers = new ArrayList<>();
        int[] userNumberArr = Stream.of(String.valueOf(inputNumber).split("")).mapToInt(Integer::parseInt).toArray();
        for(int i=0; i<userNumberArr.length; i++){
            userNumbers.add(userNumberArr[i]);
        }
        return userNumbers;
    }

}
