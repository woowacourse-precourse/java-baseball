package extract;

import java.util.Map;

public class Key {

    public static Integer getKey(Map<Integer, Character> playerNumber, Character value) {
        return playerNumber.entrySet().stream()
                .filter(integerCharacterEntry -> value.equals(integerCharacterEntry.getValue()))
                .findFirst().map(Map.Entry::getKey)
                .orElse(null);
    }
}
