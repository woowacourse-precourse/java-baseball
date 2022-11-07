package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Balls {
    List<Integer> numbers;

    public Balls(String inputBallNumber){
        numbers = stringToList(inputBallNumber);
    }


    public static List<Integer> stringToList(String inputBallNumber){
        List<Integer> inputBallList = new ArrayList<>();
        int convertInt = Integer.parseInt(inputBallNumber);
        while (convertInt >0){
            int remainingNumber = convertInt%10;
            inputBallList.add(remainingNumber);
            convertInt/=10;
        }

        Collections.reverse(inputBallList);
        return inputBallList;
    }
}
