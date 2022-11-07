package baseball.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringUtility {
    public static boolean hasDuplicatedChar(String target) {
        String[] targetArray = target.split("");
        Set<String> targetSet = new HashSet<>(Arrays.asList(targetArray));
        return targetSet.size() != target.length();
    }
}
