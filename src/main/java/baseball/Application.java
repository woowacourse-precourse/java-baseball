package baseball;

import baseball.inputparser.RestartType;
import java.util.Scanner;

import static baseball.inputparser.InputParser.parseRestartInput;
import static baseball.inputparser.RestartType.QUIT;
import static baseball.mainbaseballgame.BaseballGameApplication.executeBaseballGame;

/**
 * 메인 게임을 실행하는 클래스입니다.
 * @version 1.0.0
 * @author CHO MinHo
 */
public class Application {

    public static Scanner scanner;

    /**
     * 야구 게임을 실행하고, 게임 종료가 된 경우 재시작 여부를 입력 받습니다.
     * 재시작 여부에 따라 프로그램이 재실행되거나, 종료됩니다.
     * @throws IllegalArgumentException 잘못된 입력을 받을 경우 예외를 던집니다.
     */
    public static void main(String[] args) throws IllegalArgumentException {

        scanner = new Scanner(System.in);

        while(true) {
            executeBaseballGame();

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String restartInput = scanner.nextLine();
            RestartType restartType = parseRestartInput(restartInput);

            if (restartType.equals(QUIT)) {
                break;
            }
        }

        scanner.close();
    }
}
