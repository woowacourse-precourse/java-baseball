package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computer = RandomNum(3);

    }

    public static List<Integer> RandomNum(int count){
        List<Integer> list = new ArrayList<>();
        while(list.size() <count){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!list.contains(randomNumber)){
                list.add(randomNumber);
            }
        }
        return list;
    }
}
