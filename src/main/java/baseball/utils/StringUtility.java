package baseball.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringUtility {
    public static boolean hasDuplicatedChar(String source) {
        String[] target = source.split("");
        Set<String> targetSet = new HashSet<>(Arrays.asList(target));
        return targetSet.size() != source.length();
    }
}
