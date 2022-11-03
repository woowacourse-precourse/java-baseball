package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Utils {

    public static List<Integer> intToList(int input) {
        List<Integer> returnList = new ArrayList<>();

        while (input > 0) {
            returnList.add(input % 10);
            input /= 10;
        }

        Collections.reverse(returnList);
        return returnList;
    }
}
