package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;

public class Application {
    public static List<Integer> generateNumber(){
        List<Integer> num = new ArrayList<>();
        while (num.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!num.contains(randomNumber)) {
                num.add(randomNumber);
            }
        }
        return num;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> test = generateNumber();
        System.out.print(test);
    }
}
