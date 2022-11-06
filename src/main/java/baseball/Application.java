package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

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


    // 2-1. 유효성 체크 : 숫자인지
    public static boolean isNumber(String input) {
        return input.chars()
                .allMatch(Character::isDigit) ;
    }

    public static boolean isCorrectSize(List<Integer> playerNumber){
        return playerNumber.size() == DIGITS;
    }

    public static boolean isInRange(List<Integer> playerNumber){
        return playerNumber.stream()
                .allMatch(v->
                        RANDOM_MIN<=v && v<= RANDOM_MAX);
    }

    public static boolean isNotDuplicated(List<Integer> playerNumber){
        return Set.copyOf(playerNumber).size() == DIGITS;
    }

    // 2-2. 유효성 체크 : 세 자리인지 / 1-9 사이 / 서로 다른 수인지
    public static boolean isValidNumber(List<Integer> playerNumber) {
        return isCorrectSize(playerNumber) &&
                isInRange(playerNumber) &&
                isNotDuplicated(playerNumber);
    }


}
