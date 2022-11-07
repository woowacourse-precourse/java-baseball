package baseball;

import java.util.HashMap;

public class GameManager {
    private static HashMap<Integer,Integer> RandomNumberHash = new HashMap<>();

    void init() {
        RandomNumberHash = Computer.generateRandomNumber();
    }

}
