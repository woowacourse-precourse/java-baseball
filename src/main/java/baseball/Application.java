package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
    }

    //1. 컴퓨터 수 생성하기
    private static final int DIGITS = 3;
    private static final int RANDOM_MIN = 1;
    private static final int RANDOM_MAX = 9;

    public static List<Integer> createComputerNumber () {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < DIGITS) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }

        return computerNumber;
    }


    //2. 플레이어 수 입력받기
    public static List<Integer> getPlayerNumber () throws IllegalArgumentException {
        String input = Console.readLine().trim();
        if(!isNumber(input)){
            return input.chars()
                    .boxed()
                    .collect(Collectors.toList());
        }
        throw new IllegalArgumentException();
    }


    // 3-1. 플레이어 수 유효성 체크 : 숫자인지
    public static boolean isNumber(String input) {
        return input.chars()
                .allMatch(Character::isDigit) ;
    }
    // 3-2. 플레이어 수 유효성 체크 : 세 자리 수인지
    public static boolean isCorrectSize(List<Integer> playerNumber){
        return playerNumber.size() == DIGITS;
    }
    // 3-3. 플레이어 수 유효성 체크 : 범위 안의 수인지
    public static boolean isInRange(List<Integer> playerNumber){
        return playerNumber.stream()
                .allMatch(v->
                        RANDOM_MIN<=v && v<= RANDOM_MAX);
    }
    // 3-4. 플레이어 수 유효성 체크 : 서로 다른 수인지
    public static boolean isNotDuplicated(List<Integer> playerNumber){
        return Set.copyOf(playerNumber).size() == DIGITS;
    }

    // 3. 유효성 체크 : 세 자리인지 / 1-9 사이 / 서로 다른 수인지
    public static boolean isValidNumber(List<Integer> playerNumber) {
        return isCorrectSize(playerNumber) &&
                isInRange(playerNumber) &&
                isNotDuplicated(playerNumber);
    }


    //4. 플레이어 수와 컴퓨터 수 비교하기
    public static Map<String, Integer> checkAnswer(List<Integer> computerNumber, List<Integer>  playerNumber){
        Map<String, Integer> resultMap = new HashMap<>();

        for(int i=0; i<DIGITS ;i++){ //세자리 수 비교
            if(computerNumber.contains(playerNumber.get(i))) { //포함하는지
                checkBallOrStrike(computerNumber.get(i), playerNumber.get(i), resultMap);
                continue;
            }
            int oldValue = resultMap.getOrDefault("nothing", 0);
            resultMap.put("nothing", oldValue+1);

        }
        return resultMap;
    }
    //4-1. 볼인지 스트라이크인지 확인하기
    public static void checkBallOrStrike (Integer computerNum, Integer playerNum, Map<String, Integer> resultMap){
        if(computerNum == playerNum){ //일치하는지
            int oldValue = resultMap.getOrDefault("strike", 0);
            resultMap.put("strike", oldValue+1);
            return;
        }
        int oldValue = resultMap.getOrDefault("ball", 0);
        resultMap.put("ball", oldValue+1);
    }

    //5. 비교한 결과 문자열로 만들기
    public static String giveHint(Map<String, Integer> resultMap){
        List<String> answer = new ArrayList<>();
        if(resultMap.containsKey("ball")) {
            answer.add(String.format("%d볼",resultMap.get("ball") ));
        }
        if(resultMap.containsKey("strike")) {
            answer.add(String.format("%d스트라이크", resultMap.get("strike") ));
        }
        if(resultMap.containsKey("nothing")
                && resultMap.get("nothing").equals(3)) {
            answer.add("낫싱");
        }

        return String.join(" ",answer).trim();
    }

    //6. 정답인지 확인하기
    public static boolean isAnswer(Map<String, Integer> resultMap) {
        if (resultMap.containsKey("strike") && resultMap.get("strike") == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

}
