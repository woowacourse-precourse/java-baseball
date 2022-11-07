package baseball;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Key {

    public static Integer getKey(Map<Integer, Integer> playerNumber, int playerValue) {
        Set<Entry<Integer, Integer>> entrySet = playerNumber.entrySet();
        int getKey = 0;
        for (Entry<Integer, Integer> entry : entrySet) {
            if (entry.getValue().equals(playerValue)) {
                getKey = entry.getKey();
            }
        }
        return getKey;
    }
}
