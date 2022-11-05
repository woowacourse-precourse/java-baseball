package baseball;


import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Application {

    // 2번 랜덤으로 computer에서 제공하는 정답을 얻어내는 메소드
    public static String baseball_random() {

        String baseball = "";

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        for (int i : computer){
            baseball += Integer.toString(i);
        }

        return baseball;
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
