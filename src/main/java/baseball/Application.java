package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
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
    public static String getPlayerNumber() throws IllegalArgumentException {
        String input = Console.readLine().trim();
        if(isValidNumber(input)){
            return input;
        }
        throw new IllegalArgumentException();
    }

    //3. 입력한 값이 유효한 값인지 확인하기
    public static boolean isValidNumber(String input){
        if(!isNumber(input)) {
            return false;
        }
        if (input.contains("0")) {
            return false;
        }
        Set<Integer> numberSet = new HashSet<>();
        int playerNumber =  Integer.parseInt(input);
        while(playerNumber!=0){
            numberSet.add(playerNumber%10);
            playerNumber /=10;
        }
        return numberSet.size() == DIGITS ;
    }
    //숫자인지 확인
    public static boolean isNumber(String input) {
        return input.chars()
                .allMatch(Character::isDigit) ;
    }
    // N자리 수인지 확인
    public static boolean isCorrectSize(List<Integer> playerNumber){
        return playerNumber.size() == DIGITS;
    }
    // 범위 안의 수인지 확인
    public static boolean isInRange(List<Integer> playerNumber){
        return playerNumber.stream()
                .allMatch(v->
                        RANDOM_MIN<=v && v<= RANDOM_MAX);
    }
    // 중복되는 수 있는지 확인
    public static boolean isNotDuplicated(List<Integer> playerNumber){
        return Set.copyOf(playerNumber).size() == DIGITS;
    }



}
