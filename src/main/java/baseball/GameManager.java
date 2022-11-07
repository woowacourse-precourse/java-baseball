package baseball;
import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;

public class GameManager {
    private static HashMap<Integer,Integer> RandomNumberHash = new HashMap<>();
    private static HashMap<Integer,Integer> InputNumberHash = new HashMap<>();
    private static HashMap<Character,Integer> resultHash = new HashMap<>();
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

    static HashMap<Character,Integer> judgeResult() {
        resultHash.put('S', 0);
        resultHash.put('B', 0);
        resultHash.put('O', 0);
        InputNumberHash.forEach((intNumber, intIndex)->{
            if (!RandomNumberHash.containsKey(intNumber)){
                resultHash.put('O', resultHash.get('O')+1);
            } else if (RandomNumberHash.get(intNumber)==intIndex) {
                resultHash.put('S', resultHash.get('S')+1);
            } else if (RandomNumberHash.get(intNumber)!=intIndex) {
                resultHash.put('B', resultHash.get('B')+1);
            }
        });
        System.out.println(resultHash);
        return resultHash;
    }

}
