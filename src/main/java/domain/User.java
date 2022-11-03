package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class User {
    public static List<Integer> getUserNumber(String inputNumber){
        List<Integer> userNumbers = new ArrayList<>();
        String[] userNumberArr = inputNumber.split("");

        for(int i=0; i<userNumberArr.length; i++){
            userNumbers.add(Integer.valueOf(userNumberArr[i]));
        }
        return userNumbers;
    }

}
