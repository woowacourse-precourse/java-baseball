package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void makeRandomValue(List<Integer> computer){
        computer.clear();
        while (computer.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = new ArrayList<>();
        makeRandomValue(computer);
    }
}
