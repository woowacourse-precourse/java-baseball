package baseball;

import java.util.*;

public class BaseBallGame {
    String INDEX_VALUE_ARE_CORRECT = "스트라이크";
    String VALUE_IS_CORRECT = "볼";
    String INDEX_VALUE_ARE_WRONG = "낫싱";

    String computer;
    Map<String, Integer> result = new HashMap<String, Integer>();

    public BaseBallGame(String computer) {
        this.computer = computer;
    }

    public void playBaseBall(String input) {
            BaseBallGame baseBallGame = new BaseBallGame(computer);
            Map<String, Integer> scores = baseBallGame.calculateScores(input);
            System.out.println(getResultAsString(scores));
    }

    // 스트라이크, 볼, 낫싱 점수를 map으로 저장하는 함수
    public Map<String, Integer> calculateScores(String input) {

        for (int i = 0; i < input.length(); i++) {
            int userDigit = input.charAt(i);
            int findIndex = computer.indexOf(userDigit);

            if (i == findIndex) {
                saveScore(result, INDEX_VALUE_ARE_CORRECT);
            } else if (findIndex != -1) {
                saveScore(result, VALUE_IS_CORRECT);
            } else if (findIndex == -1) {
                saveScore(result, INDEX_VALUE_ARE_WRONG);
            }
        }
        return result;
    }


    public void saveScore(Map<String, Integer> map, String key) {
        int score = 1;
        if (!map.containsKey(key)) {
            map.put(key, 1);
        } else {
            map.put(key, map.get(key) + score);
        }
    }

    // 게임결과 출력
    public String getResultAsString(Map<String, Integer> scores) {
        StringBuilder res = new StringBuilder();

        if (scores.containsKey(INDEX_VALUE_ARE_WRONG) && scores.get(INDEX_VALUE_ARE_WRONG) == 3) {
            return INDEX_VALUE_ARE_WRONG;
        }

        if (scores.containsKey(VALUE_IS_CORRECT)) {
            res.append(scores.get(VALUE_IS_CORRECT)).append(VALUE_IS_CORRECT).append(" ");
        }

        if (scores.containsKey(INDEX_VALUE_ARE_CORRECT)) {
            res.append(scores.get(INDEX_VALUE_ARE_CORRECT)).append(INDEX_VALUE_ARE_CORRECT);
        }

        return res.toString();
    }


    public boolean isRightAnswer(Map<String, Integer> scores) {
        if(scores.containsKey(INDEX_VALUE_ARE_CORRECT) && scores.get(INDEX_VALUE_ARE_CORRECT) == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료!");
            return true;
        } else {
            this.result.clear();
            return false;
        }
    }

}
