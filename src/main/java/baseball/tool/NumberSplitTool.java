package baseball.tool;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberSplitTool {

    public static char[] makeNumberSplitArrangement(int receivedNumber) {

        String number = Integer.toString(receivedNumber);

        return number.toCharArray();
    }

    public static List<Integer> makeNumberSplitList(int receivedNumber) {
        List<Integer> numberSplitList = new ArrayList<>();

        for (char oneNumber : makeNumberSplitArrangement(receivedNumber)) {
            int n = oneNumber - '0';
            numberSplitList.add(n);
        }
        return numberSplitList;
    }

    public static Set<Integer> makeNumberSplitSet(int receivedNumber) {

        return new HashSet<>(makeNumberSplitList(receivedNumber));
    }
}