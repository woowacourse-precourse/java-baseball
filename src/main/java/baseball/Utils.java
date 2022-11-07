package baseball;

import java.util.List;

public class Utils {
    public static String listToString(List<Integer> listIn) {
        StringBuilder output = new StringBuilder();
        for (Integer integer : listIn) {
            output.append(integer);
        }
        return output.toString();
    }
}
