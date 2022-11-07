package baseball.utils;

import java.util.ArrayList;

public class ArrayParser {

    public static ArrayList<Character> stringToCharList(String word){
        ArrayList<Character> result = new ArrayList<>(word.length());

        for(int index=0; index<word.length(); index++){
            result.add(word.charAt(index));
        }

        return result;
    }


}
