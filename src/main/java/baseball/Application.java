package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.ArrayList;

public class Application {

    private static List<Integer> computer = new ArrayList<>();
    private static void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static void pickRandomNumber() {
        while (computer.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        start();
        pickRandomNumber();
    }
}
