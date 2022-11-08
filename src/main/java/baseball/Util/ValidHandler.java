package baseball.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidHandler {

    public static boolean DuplicatedNumber(String string) {
        String[] answerStrings = string.split("");
        Arrays.sort(answerStrings);
        for(int index = 0; index < answerStrings.length; index++) {
            if(answerStrings[index].equals(answerStrings[index+1])) {
                return true;
            }
        }
        return false;
    }

    public static List<Integer> addList(String addString) {
        List<Integer> addNumberList = new ArrayList<>();
        for(int addIndex = 0; addIndex< addString.length(); addIndex++) {
            addNumberList.add((int)addString.charAt(addIndex) - '0');
        }
        return addNumberList;
    }
}
