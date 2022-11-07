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
        if(ball == 0 && strike == 0) {
            System.out.println("낫싱");
            return false;
        }
        else if(strike == 0) {
            System.out.println(ball + "볼");
            return false;
        }
        else if(ball == 0) {
            System.out.println(strike + "스트라이크");
            if(strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return true;
            }
            else return false;
        }
        else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
            return false;
        }
    }

    public boolean retryGame(String input) {
        if(input.equals("1")) return true;
        else if(input.equals("2")) return false;
        else throw new IllegalArgumentException();
    }
}
