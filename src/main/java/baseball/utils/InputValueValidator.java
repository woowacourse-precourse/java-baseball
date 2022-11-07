package baseball.utils;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class InputValueValidator {

    public static boolean isNumberOnly(String inputValue){
        return Pattern.matches(Constants.NUMBER_REGEX, inputValue);
    }

    public static boolean isLengthCorrect(String inputValue, int length){
        return inputValue.length() == length;
    }

    public static boolean isNoDuplicatedValue(String inputValue){
        char checkChar = inputValue.charAt(0);
        ArrayList<Character> compareList;

        for(int index = 1; index<inputValue.length(); index++){
            compareList = ArrayParser.stringToCharList(inputValue.substring(index));

            if(compareList.contains(checkChar)){
                return false;
            }
            checkChar = inputValue.charAt(index);
        }

        return true;
    }

    public static boolean isContainValues(String inputValue, int[] values){
        for(int index=0; index<inputValue.length(); index++){
            if(isValueIn(inputValue.charAt(index), values)){
                return true;
            }
        }
        return false;
    }

    private static boolean isValueIn(char c, int[] values){
        for (int value : values) {
            if (value == Character.getNumericValue(c)) {
                return true;
            }
        }
        return false;
    }

}
