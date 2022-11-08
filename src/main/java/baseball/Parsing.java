package baseball;

import java.util.ArrayList;
import java.util.List;

public class Parsing {
    static List<Integer> splitString(String a) {
        List<Integer> result = new ArrayList<>();
        String[] arr = a.split("");
        for(int i=0; i<3; i++) {
            result.add(Integer.valueOf(arr[i]));
        }
        return result;
    }
}
