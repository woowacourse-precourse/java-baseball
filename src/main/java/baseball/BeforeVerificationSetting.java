package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BeforeVerificationSetting {

    public static char[] makeNumberSplitArrangement(int receivedNumber){
        String number = Integer.toString(receivedNumber);
        char[] numberSplitArrangement = number.toCharArray();
        return numberSplitArrangement;
    }

    public static List<Integer> makeNumberSplitList(int receivedNumber){
        List<Integer> numberSplitList = new ArrayList<>();

        for(char oneNumber : makeNumberSplitArrangement(receivedNumber)){
            numberSplitList.add((int) oneNumber);
        }
        return numberSplitList;
    }

    public static Set<Integer> makeNumberSplitSet(int receivedNumber){
        Set<Integer> numberSplitSet = new HashSet<>(makeNumberSplitList(receivedNumber));

        return numberSplitSet;
    }
}
