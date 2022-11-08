package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;

// 역할 관리자 : 의존성 연결을 책임지기, DIP
public class AppConfig{


    public Map<Integer, Integer> createComputerNumber() {

        return new Player().createComputerNumber();
    }

    public Map<Integer, Integer> inputUserNumber() {
        return new Input().inputUserNumber(Console.readLine());
    }

    public Hint loopHint() {
        return new Hint();
    }


    public Print printResult() {
        return new Print();
    }

    public static Game game() {
        return new Game();
    }

    public Application end() {
        return new Application();
    }
}
