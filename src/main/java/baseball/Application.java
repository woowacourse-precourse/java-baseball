package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import org.mockito.stubbing.Answer;

public class Application {

    //  중복되지 않는 랜덤한 3자리 수 선택
    public static List<Integer> Answer() {
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
        List<Integer> answer = new ArrayList<>();
        game :while(true) {
            answer = Answer();

        }


    }
}