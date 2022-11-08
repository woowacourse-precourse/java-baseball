package baseball.view;

import baseball.Button;
import baseball.dto.InputParameters;
import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String START_GUIDE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_GUIDE = "슷자를 입력해주세요 : ";

    private static final String RESTART_GUIDE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";

    public static void printGuide() {
        System.out.println(START_GUIDE);
    }

    public static InputParameters printStartGame() {
        System.out.print(INPUT_GUIDE);
        String hits = Console.readLine();

        return new InputParameters(hits);
    }

    public static Button printRestartButton(){
        System.out.println(RESTART_GUIDE);

        return new Button(Console.readLine());
    }
}
