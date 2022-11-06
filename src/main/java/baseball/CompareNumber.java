package baseball;

import java.util.*;

public class CompareNumber {

    public static void printResult(String computerNumber, String playerNumber){
        String result = attachResult(computerNumber,playerNumber);
        System.out.println(result);
    }
    
    public static String attachResult(String computerNumber, String playerNumber){
        Map<String, Integer> resultMap = countResult(computerNumber,playerNumber);
        List<String> sortedResultList = sortMap(resultMap);
        String totalResult = "";

        for(String result : sortedResultList){
            int count = resultMap.get(result);
            if(result != "낫싱") {
                totalResult += Integer.toString(count);
            }
            totalResult += result;
            totalResult += " ";
        }
        totalResult = removeLastBlank(totalResult);
        return totalResult;
    }

    public static String removeLastBlank(String number){
        char lastIndex = number.charAt(number.length() - 1);
        if(lastIndex == ' '){
            number = number.substring(0, number.length() - 1);
        }
        return number;
    }

    public static List<String> sortMap(Map<String, Integer> resultMap){
        List<String> sortedResultList = new ArrayList<>(resultMap.keySet());
        Collections.sort(sortedResultList);
        return sortedResultList;
    }

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
