package baseball;
import java.util.*;
import camp.nextstep.edu.missionutils.*;
public class Application {
    public static List<Integer> getRandomNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
