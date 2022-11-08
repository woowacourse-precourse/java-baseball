package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Application {

    static List<Integer> target;
    static List<Integer> num;
    private static String regex = "^[1-9]{3}$";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    static void setTarget() {
        Set<Integer> randNumSet = new LinkedHashSet<>();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (randNumSet.size() < 3) {
            int pickNum = Randoms.pickNumberInRange(1, 9);
            if (!randNumSet.contains(pickNum)) {
                randNumSet.add(pickNum);
            }
        }
        ArrayList<Integer> target = new ArrayList<>(randNumSet);
    }

    static void checkInput() {
        String inputNum = Console.readLine();
        //1. 3자리 아님
        if (inputNum.length() != 3) {
            throw new IllegalArgumentException("숫자의 어느 자리에도 0이 포함되지 않는 3자리의 숫자를 입력하십시오.");
        }
        //2. 1-9 이외 값이 포함(1: 49, 9: 57)
        if (!inputNum.matches(regex)) {
            throw new IllegalArgumentException("1-9사이 값을 입력하시오.");
        }
//        for(int i=0;i<inputNum.length();i++){
//            char ch=inputNum.charAt(i);
//            //3. 3자리 수 중 중복이 있을 때
//            if(appear.get(String.valueOf(ch))==1){
//                throw new IllegalArgumentException("3자리의 숫자 중 중복되는 값이 존재해서는 안됩니다.");
//            }else {
//                appear.put(String.valueOf(ch),1);
//            }
//        }
        num = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            num.add(inputNum.charAt(i) - '0');
        }
    }
}
