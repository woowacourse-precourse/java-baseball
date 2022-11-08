package baseball;

import java.util.ArrayList;
import java.util.List;

public class Revert {

    public static char[] revertStringToCharArray(String inputString) {

        return inputString.toCharArray();
    }

    public static int[] revertCharArrayToAsciiArray(char[] charArray) {
        int[] asciiArray = new int[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            asciiArray[i] = charArray[i];
        }
        return asciiArray;
    }

    public static List<Integer> revertStringToList(String inputString){
        List<Integer> inputList = new ArrayList<Integer>();
        for(String number: inputString.split("")){
            inputList.add(Integer.parseInt(number));
        }

        return inputList;
    }
}
