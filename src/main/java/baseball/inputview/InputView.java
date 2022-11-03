package baseball.inputview;


import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public InputView() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        inputNumber();
    }

    public int inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        int ballNumbers = scanner.nextInt();
        if (!InputViewValidator.validateSize(ballNumbers)) {
            throw new IllegalArgumentException("3자리 숫자를 입력하여야 합니다.");
        }
        return ballNumbers;
    }

    public boolean ask_restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int nextInt = scanner.nextInt();
        return nextInt == 1;
    }

}
