package baseball;

import camp.nextstep.edu.missionutils.Console;
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

    public String gameStart() {
        return "숫자 야구 게임을 시작합니다.";
    }

    public String inputNum() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return input;
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
}
