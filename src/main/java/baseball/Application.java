package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean restart = true;

        while (restart) {
            playGame();
            restart = Input.restart();
        }
    }

    /**
     * function to play a number baseball game.
     */
    public static void playGame() {
        List<Integer> computer = generateAnswer();
        boolean find = false;

        while(!find) {
            List<Integer> user = Input.answer();
            find = computer.equals(user);
            Result result = new Result(computer, user);
            result.print();
        }
    }

    /**
     * Generate the correct answer for a number baseball game.
     * @return answer
     */
    public static List<Integer> generateAnswer() {
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
