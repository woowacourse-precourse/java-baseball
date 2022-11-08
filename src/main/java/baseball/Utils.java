package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Utils {
    public static List<Character> StringToCharList(String input) {
        List<Character> list = new ArrayList<>();
        for (char c : input.toCharArray()) {
            list.add(c);
        }
        return list;
    }

    public static HashSet<Character> StringToCharSet(String input) {
        HashSet<Character> set = new HashSet<>();
        for (char c : input.toCharArray()) {
            set.add(c);
        }
        return set;
    }

    public static void addOneToMap(HashMap<String, Integer> map, String key) {
        map.put(key, map.get(key) + 1);
    }
}
