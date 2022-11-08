package baseball;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberBaseballGame {
    private final ArrayList<String> answer;
    private int ballCount;
    private int strikeCount;

    public BaseballGame() {
        answer = new ArrayList<>(3);
        inputs = new ArrayList<>(3);
        ballCount = 0;
        strikeCount = 0;
        initAnswer();

        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void play() {
        while (true) {
            System.out.print("숫자를 입력해 주세요: ");
            String input = Console.readLine();      
        }
    }
}
