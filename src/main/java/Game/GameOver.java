package Game;

import java.util.Scanner;
import Exception.CheckException;

public class GameOver {

    private final Scanner scanner;

    public GameOver(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean work() throws IllegalArgumentException{

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restartValue = CheckException.restartStatusValid(scanner.nextLine());
        return setRestartStatus(restartValue);
    }

    private static boolean setRestartStatus(String defineRestartValue) {
        return defineRestartValue.equals("1");
    }
}
