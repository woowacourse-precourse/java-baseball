package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BaseballGame {

    private Scanner scanner = new Scanner(System.in);
    private List<Integer> answer;

    public void start() {
        boolean gameContinue = true;

        System.out.println("숫자 야구 게임을 시작합니다.");
        answer = makeAnswer();
        
        while (gameContinue) {
            List<Integer> userInput = getUserInput();
        }
    }

    private List<Integer> getUserInput() {
        int userInput = scanner.nextInt();
        return Utils.intToList(userInput);
    }

    public boolean isRestart() {
        return false;
    }

    public List<Integer> makeAnswer() {
        List<Integer> answer = new ArrayList<>();

        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }

        return answer;
    }
}
