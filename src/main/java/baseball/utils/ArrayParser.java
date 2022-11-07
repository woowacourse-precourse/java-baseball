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

    public static ArrayList<Integer> stringToIntegerList(String word){
        ArrayList<Integer> result = new ArrayList<>(word.length());

        for(int index=0; index<word.length(); index++){
            result.add(Integer.parseInt(word.substring(index, index+1)));
        }

        return result;
    }


}
