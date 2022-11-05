package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BaseballGame {

    private Scanner scanner = new Scanner(System.in);
    private List<Integer> answer;
    private boolean gameContinueFlag;

    public void start() {
        gameContinueFlag = true;

        System.out.println("숫자 야구 게임을 시작합니다.");
        answer = makeAnswer();

        while (gameContinueFlag) {
            List<Integer> userInput = getUserInput();
        }
    }

    private List<Integer> getUserInput() {
            String userInput = Console.readLine();

            if (Utils.isValidUserInput(userInput)) {
                List<Integer> userInputList = Utils.intToList(Integer.valueOf(userInput));
                return userInputList;
            } else {
                throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
            }
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

    public boolean isRestart() {
        return gameContinueFlag;
    }

}
