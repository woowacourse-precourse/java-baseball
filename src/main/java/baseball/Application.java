import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
//package baseball;

public class Application {
    public static ArrayList<Integer> generateAnswer() {
        ArrayList<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber))
                answer.add(randomNumber);
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        int executionCode = 1;
        ArrayList<Integer> answer;
        while (executionCode == 1) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            answer = generateAnswer();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            executionCode = Integer.parseInt(Console.readLine());
        }
    }
}