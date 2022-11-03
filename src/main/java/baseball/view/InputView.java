package baseball.view;

import baseball.BallParameters;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static BallParameters printStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("슷자를 입력해주세요 : ");
        String hits = scanner.next();
        return new BallParameters(hits);
    }
}
