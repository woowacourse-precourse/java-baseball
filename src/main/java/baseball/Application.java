package baseball;

import baseball.service.UserInput;
import baseball.utils.ConsoleLog;
import baseball.utils.MakeRandom;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        ConsoleLog console = ConsoleLog.getInstance();
        MakeRandom makeRandom = MakeRandom.getInstance();

        console.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computerNumbers = makeRandom.numbers();
        List<Integer> userNumbers = UserInput.number("숫자를 입력해주세요 : ");
    }
}
