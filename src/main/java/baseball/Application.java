package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static final int USER_LENGTH_NOT_3 = 1;
    public static final int ALPHA_IN_USER = 2;

    public static void showPrompt(List<Integer> answer) {
        String user = null;
        System.out.println("숫자 야구 게임을 시작합니다.");
        Console console = null;
        while (true) {
            System.out.println("숫자를 입력해주세요 : ");
            user = Console.readLine();
            System.out.println(user);
        }
    }
    public static List<Integer> getAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> answer = getAnswer();
        System.out.println(answer);
        showPrompt(answer);
    }
}
