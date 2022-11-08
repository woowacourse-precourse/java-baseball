package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Utill {
    public static List<Integer> stringToList(String target) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < target.length(); i++) {
            result.add(Character.getNumericValue(target.charAt(i)));
        }
        return result;
    }

    public static List<Integer> SetToList(Set<Integer> target) {
        return new ArrayList<>(target);
    }
}
