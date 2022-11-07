package baseball;

import java.util.Scanner;

public class BaseBallGame {
    private String userNumber;
    private Computer computer;
    private int ballCount;
    private int strikeCount;
    private String restartToken;
    private Scanner scanner;

    public BaseBallGame() {
        computer = new Computer();
        ballCount = 0;
        strikeCount= 0;
        restartToken = "";
        scanner = new Scanner(System.in);
    }

    public void inputUserNumber() {
        userNumber = scanner.nextLine();
    }
}
