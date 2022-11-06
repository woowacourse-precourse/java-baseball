package baseball;

import java.util.*;

public class CompareNumber {

    public static Map<String, Integer> countResult(String computerNumber, String playerNumber){
        List<String> resultList = findNumber(computerNumber,playerNumber);
        Map<String, Integer> resultMap = new HashMap<>();
        for(String result : resultList){
            int resultFrequency = Collections.frequency(resultList, result);
            resultMap.put(result, resultFrequency);
        }
        return resultMap;
    }

    public static List<String> findNumber(String computerStringNumber, String playerStringNumber){
        List<String> answerList = new ArrayList<>();
        char[] playerNumberArray = playerStringNumber.toCharArray();
        String answer;
        int computerNumberIndex;
        int playerNumberIndex = 0;
        for(char number : playerNumberArray){
            computerNumberIndex = computerStringNumber.indexOf(number);
            //플레이어 숫자와 컴퓨터 숫자 인덱스 비교 후 해당하는 문구 저장
            answer = compareIndex(computerNumberIndex, playerNumberIndex);
            answerList.add(answer);
            playerNumberIndex++;
        }
        answerList = removeNothing(answerList);
        return answerList;
    }

    public static List<String> removeNothing(List<String> answerList){
        if(answerList.size() != 1 && answerList.contains("낫싱")){
            answerList.remove("낫싱");
        }
        return answerList;
    }

    public static String compareIndex(int computerIndex, int playerIndex){
        String answer;
        if(computerIndex == -1){
            answer = "낫싱";
        }
        else if(computerIndex == playerIndex){
            answer = "스트라이크";
        }
        else{
            answer = "볼";
        }
        return answer;
    }
}
