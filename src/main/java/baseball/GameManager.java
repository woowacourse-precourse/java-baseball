package baseball;
import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.List;

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

    static String printResult() {
        String resultString = "";
        List<Character> resultKeys = List.of('B', 'S', 'O');
        if (resultHash.get('S')==3) {
            resultString = "3스트라이크";
            System.out.println(resultString);
            return resultString;
        }
        if (resultHash.get('O')==3) {
            resultString="낫싱";
            System.out.println(resultString);
            return resultString;
        }
        for (char SBO: resultKeys) {
            if (resultHash.get(SBO)==0) continue;
            if (SBO=='B') resultString=resultString+resultHash.get(SBO)+"볼 ";
            if (SBO=='S') resultString=resultString+resultHash.get(SBO)+"스트라이크 ";
        }
        resultString = resultString.substring(0,resultString.length()-1);
        System.out.println(resultString);
        return resultString;
    }

}
