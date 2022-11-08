package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class ListGenerator {
    public static List<Integer> stringToIntegerList(String input){
        List<Integer> list = new ArrayList<>();
        for ( int i = 0 ; i < input.length() ; i ++){
            list.add(input.charAt(i) - '0');
        }
        return list;
    }
}
