package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        //  게임 재시작 여부를 판단하는 flag 선언
        int flag = 1;
        while(flag == 1){
            System.out.println(MessageCode.GAME_START);
            //  목표 숫자 생성
            List<Integer> targetNumbers = createTargetNumber();
            playGame(targetNumbers);
            System.out.println(MessageCode.GAME_END);
            System.out.println(MessageCode.GAME_RESTART);
            flag = verifyFlag(Console.readLine());
        }
    }

    //  입력값이 유효한 flag 값인지 판별
    public static int verifyFlag(String str){
        int flag = Integer.parseInt(str);
        if(flag < 1 || flag > 2){
            throw new IllegalArgumentException("INVALID_INPUT_RANGE");
        }
        return flag;
    }

    //  목표 숫자 생성 메소드
    public static List<Integer> createTargetNumber(){
        List<Integer> targetNumbers = new ArrayList<>();

        while (targetNumbers.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!targetNumbers.contains(randomNumber)){
                targetNumbers.add(randomNumber);
            }
        }
        return targetNumbers;
    }

    public static void playGame(List<Integer> targetNumbers) {
        boolean flag = true;
        while(flag){
            System.out.printf(MessageCode.INSERT_NUMBER.toString());
            int[] inputNumbers = verifyInput(Console.readLine());
            Map<String,Integer> countMatchResult = compareInputToTarget(inputNumbers,targetNumbers);
            String result = convertMapToString(countMatchResult);
            System.out.println(result);
            if(result.equals(MatchCode.END.toString())){
                flag = false;
            }
        }
    }

    public static int[] verifyInput(String input){
        if(input.length() != 3) throw new IllegalArgumentException("INVALID_INPUT_LENGTH");
        return Stream.of(input.split("")).mapToInt(Integer::parseInt).toArray();
    }

    public static Map<String, Integer> compareInputToTarget(int[] inputNumbers, List<Integer> targetNumbers) {
        Map<String, Integer> countMatchResult = initializeMap();
        int index = 0;

        for (int inputNumber : inputNumbers) {
            if (!targetNumbers.contains(inputNumber)) {
                index++;
                continue;
            }

            int targetNumber = targetNumbers.get(index);
            String matchResult = null;

            if (inputNumber == targetNumber) {
                matchResult = MatchCode.STRIKE.toString();
            }
            if (inputNumber != targetNumber) {
                matchResult = MatchCode.BALL.toString();
            }

            countMatchResult.put(matchResult, countMatchResult.get(matchResult) + 1);
            index++;
        }
        return countMatchResult;
    }

    public static Map<String,Integer> initializeMap(){
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put(MatchCode.BALL.toString(), 0);
        map.put(MatchCode.STRIKE.toString(), 0);
        return map;
    }

    public static String convertMapToString(Map<String,Integer> map){
        removeZeroValueInMap(map);

        if(map.isEmpty()){
            return MatchCode.NOTHING.toString();
        }

        return mapToStringInOrder(map);
    }

    public static void removeZeroValueInMap(Map<String,Integer> map){
        map.entrySet().stream().filter(e -> e.getValue() == 0).collect(Collectors.toList()).
            forEach(e -> map.remove(e.getKey()));
    }

    public static String mapToStringInOrder(Map<String,Integer> map){
        StringBuilder stringBuilder = new StringBuilder();
        map.forEach((key, value) -> stringBuilder.append(value).append(key).append(" "));
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        return stringBuilder.toString();
    }
}