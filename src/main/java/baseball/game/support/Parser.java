package baseball.game.support;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static List<Integer> stringToNumbers(String input){
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<input.length();i++){
            result.add(Integer.parseInt(input.substring(i,i+1)));
        }
        return result;
    }
}
