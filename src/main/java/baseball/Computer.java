package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


public class Computer {
    public static final int LENGTH = 3;

    public List<Integer> randoms() {
        List<Integer> answers = new ArrayList<>();
        while (answers.size() < LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answers.contains(randomNumber)) {
                answers.add(randomNumber);
            }
        }
        return answers;
    }

    public List<Integer> stringToInteger(String input) {
        if(!checkNum(input)) throw new IllegalArgumentException(); // 숫자 유효성 체크
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < LENGTH; i++) {
            numbers.add(input.charAt(i) - '0');
        }
        return numbers;
    }

    private boolean checkNum(String input) {
        // 1. 세자리인지 확인
        if(input.length() != LENGTH) return false;

        // 2. 숫자인지 확인
        for (int i = 0; i < LENGTH; i++) {
            if(!('0' <= input.charAt(i) && input.charAt(i) <= '9')) return false;
        }

        // 3. 중복되는 수가 있는지 확인 -> 중복 값 허용하지 않는 Set 이용
        if(new HashSet<>(Arrays.asList(input.split(""))).size() != LENGTH) return false;

        return true;
    }

    public boolean baseballGame(List<Integer> randoms, List<Integer> nums) {
        Integer ball = 0;
        Integer strike = 0;
        for (int i = 0; i < LENGTH; i++) {
            if(isBall(randoms, nums.get(i), i)) ball++;
            if(isStrike(randoms, nums.get(i), i)) strike++;
        }
        Message.baseballGameMessage(ball, strike);
        if(strike == 3 && ball == 0) return true;
        else return false;
    }

    private boolean isBall(List<Integer> randoms, Integer num, int i) {
        for (int j = 0; j < LENGTH; j++) {
            if(num.equals(randoms.get(j)) && i != j) return true;
        }
        return false;
    }

    private boolean isStrike(List<Integer> randoms, Integer num, int i) {
        for (int j = 0; j < LENGTH; j++) {
            if(num.equals(randoms.get(j)) && i == j) return true;
        }
        return false;
    }

    public boolean retryGame(String input) {
        if(input.equals("1")) return true;
        else if(input.equals("2")) return false;
        else throw new IllegalArgumentException(); // 1,2외 값 체크
    }
}
