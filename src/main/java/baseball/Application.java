package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application application = new Application();
        application.run();



    }

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            System.out.println("숫자를 입력해주세요 : ");
            String input = Console.readLine();
        }
    }

    public List<Integer> createNewAnswer() {
        int startInclusive = 1;
        int lastInclusive = 9;
        int count = 3;
        return Randoms.pickUniqueNumbersInRange(startInclusive, lastInclusive, count);
    }
}
