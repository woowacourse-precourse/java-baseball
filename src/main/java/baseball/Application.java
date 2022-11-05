package baseball;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public int checkBall (List<Integer> answer, List<Integer> userInput) {
        int howManyBall = 0;
        for (int i=0; i<3; i++) {
            if (answer.contains(userInput.get(i))) {
                howManyBall++;
            }
        }
        return howManyBall;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
