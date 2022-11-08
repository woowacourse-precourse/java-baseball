package baseball.service;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.utils.CheckException;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameService {
    private static Computer computer;
    private static User user;

    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer = new Computer();
        playGame();
    }

    private static void playGame() {
        user.setUserNumbers(getUserNumbers());
    }

    private static List<Integer> getUserNumbers() throws IllegalArgumentException {
        System.out.print("숫자를 입력해 주세요 : ");
        String input = Console.readLine();
        return CheckException.checkUserInput(input);
    }
}
