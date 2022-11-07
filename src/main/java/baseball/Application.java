package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static int makeTargetNum() {

        List<Integer> target = new ArrayList<>();

        while (target.size() < 3) {
            int n = Randoms.pickNumberInRange(1, 9);
            if (!target.contains(n)) {
                target.add(n);
            }
        }

        System.out.println("target " + target);
        String stringOfTargetNum = "";
        for (int n : target) {
            stringOfTargetNum += n;
        }

        return Integer.parseInt(stringOfTargetNum);
    }

    public static void isValidate(String input){

        char[] inputToArr = input.toCharArray();

        for (char c : inputToArr) {
            if(!Character.isDigit(c)){
                throw new IllegalArgumentException("오직 숫자만 입력 가능합니다.");
            }
        }

        if(input.length() != 3){
            throw new IllegalArgumentException("세 자리수만 입력 가능합니다.");
        }


        if(Integer.parseInt(input) < 123 || 987 < Integer.parseInt(input)){
            throw new IllegalArgumentException("중복 없는 세 자리수만 입력 가능합니다.");
        }

        if(input.contains("0")){
            throw new IllegalArgumentException("0을 제외한 세 자리 수를 입력하세요.");
        }

        if(inputToArr[0] == inputToArr[1] || inputToArr[1] == inputToArr[2] || inputToArr[0] == inputToArr[2]){
            throw new IllegalArgumentException("중복이 없는 세 자리 수를 입력하세요.");
        }

    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 1
        int target = makeTargetNum();

        // 2
        System.out.println("숫자 야구 게임을 시작합니다.");
        String input = Console.readLine();
        isValidate(input);


    }


}
