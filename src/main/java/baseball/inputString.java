package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static baseball.exceptions.exception;

public class inputString {

    public static void input(){
        String inputNumber_s = Console.readLine();
    }

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
