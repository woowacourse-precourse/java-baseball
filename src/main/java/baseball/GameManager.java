package baseball;
import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;

public class GameManager {
    private static HashMap<Integer,Integer> RandomNumberHash = new HashMap<>();
    private static HashMap<Integer,Integer> InputNumberHash = new HashMap<>();

    void init() {
        RandomNumberHash = Computer.generateRandomNumber();
    }

    static HashMap<Integer, Integer> scanNumber() {
        InputNumberHash.clear();
        String numberString = Console.readLine();
        int index=0;
        for (char character: numberString.toCharArray()) {
            index++;
            int digit = character-'0';
            InputNumberHash.put(digit, index);
        }
        return InputNumberHash;
    }

}
