package utils;

import baseball.digit.Digit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertUtil {

    private ConvertUtil(){
    }
    public static List<Digit> convertDigit(String input){
        List<String> characterList = Arrays.asList(input.split(""));
        List<Digit> newDigitList = new ArrayList<>(3);
        for(int i = 0; i < characterList.size(); i++) {
            newDigitList.add(new Digit(i, Integer.valueOf(characterList.get(i))));
        }
        return newDigitList;
    }
    public static List<Digit> convertDigit(List<Integer> inputIntegerList){
        List<Digit> newDigitList = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            newDigitList.add(new Digit(i, inputIntegerList.get(i)));
        }
        return newDigitList;
    }
}
