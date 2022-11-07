package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Computer {
    public List<Integer> randoms() {
        List<Integer> randoms = new ArrayList<>();
        while (randoms.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randoms.contains(randomNumber)) {
                randoms.add(randomNumber);
            }
        }
        return randoms;
    }

    public List<Integer> stringToInteger(String input) {
        if(!checkNum(input)) throw new IllegalArgumentException(); // 숫자 유효성 체크
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            nums.add(input.charAt(i) - '0');
        }
        return nums;
    }

    public boolean checkNum(String input) {
        // 1. 숫자인지 확인
        for (int i = 0; i < input.length(); i++) {
            if(!('0' <= input.charAt(i) && input.charAt(i) <= '9')) return false;
        }

        // 2. 세자리 수인지 확인
        if(input.length() != 3) return false;

        // 3. 중복되는 수가 있는지 확인
        List<String> duplicate = Arrays.asList(input.split(""));
        if(new HashSet<>(duplicate).size() != duplicate.size()) return false;

        return true;
    }

    public boolean baseballGame(List<Integer> randoms, List<Integer> nums) {
        Integer ball = 0;
        Integer strike = 0;
        for(int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < randoms.size(); j++) {
                if(nums.get(i).equals(randoms.get(j))) {
                    if(i == j) strike++;
                    else ball++;
                }
            }
        }
        Message.baseballGameMessage(ball, strike);
        if(strike == 3 && ball == 0) return true;
        else return false;
    }

    public boolean retryGame(String input) {
        if(input.equals("1")) return true;
        else if(input.equals("2")) return false;
        else throw new IllegalArgumentException();
    }
}
