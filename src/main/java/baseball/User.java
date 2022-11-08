package baseball;


import camp.nextstep.edu.missionutils.Console;
import java.util.*;


public class User {


    public static List<Integer> inputGameNumber(){
        List<Integer> userNumbers = new ArrayList<>();

        String StringUserInput = Console.readLine();

        String[] arrayInput = StringUserInput.split("");

        for(int i=0; i<StringUserInput.length();i++){
            userNumbers.add(Integer.parseInt(arrayInput[i]));
        }

        return userNumbers;
    }
}