package baseball;

import java.util.*;
import java.util.stream.Collectors;

public class ExecuteBaseBallGame {
    String INDEX_VALUE_ARE_CORRECT = "스트라이크";
    String VALUE_IS_CORRECT = "볼";
    String INDEX_VALUE_ARE_WRONG = "낫싱";

    // 컴퓨터가 제시한 배열
    ArrayList<Integer> computer;

    // 스트라이크, 볼, 낫싱 점수를 map으로 저장하는 함수
    public Map<String, Integer> calculateScores(int input) {
        List<Integer> userNumbers = getUserDigits(input);

        Map<String, Integer> result = new HashMap<String, Integer>();


        for (int i = 0; i < userNumbers.size(); i++) {
            int userDigit =  userNumbers.get(i);
            int findIndex = computer.indexOf(userDigit);

            if (i == findIndex) {
                saveScore(result, INDEX_VALUE_ARE_CORRECT);
            } else if (i != findIndex && findIndex != -1) {
                saveScore(result, VALUE_IS_CORRECT);
            } else if (findIndex == -1) {
                saveScore(result, INDEX_VALUE_ARE_WRONG);
            }
        }
        return result;
    }

    public static List<Integer> getUserDigits(int input) {
        int[] digits = Integer.toString(input).chars().map(c -> c-'0').toArray();
        return Arrays.stream(digits).boxed().collect(Collectors.toList());
    }

    public static void saveScore(Map<String, Integer> map, String key) {
        int score = 1;
        if (map.isEmpty()) {
            map.put(key, 0);
        } else {
            map.put(key, map.get(key) + score);
        }
    }



}
