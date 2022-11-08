package baseball.input;

import java.util.ArrayList;
import java.util.List;

public class inputToint {


    public static List<Integer> toInt(String inputString){
        int intNumber = Integer.parseInt(inputString);
        List<Integer> number = new ArrayList<>();
        for(int i = 0 ; i<inputString.length(); i++){
            number.add(0,intNumber%10);
            intNumber = intNumber/10;
        }
        return number;
    }

}
