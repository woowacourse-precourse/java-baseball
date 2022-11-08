package baseball;

import java.io.*;
import java.util.Scanner;

public class ExecuteGame {

    // 입력한 값을 String 형태로 반환
//    private String saveInput () {
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.next();
//        return input;
//    }
    private Scanner scanner;
    private PrintStream ps;

    public ExecuteGame(InputStream inputStream, PrintStream ps) {
        this.scanner = new Scanner(inputStream);
        this.ps = ps;
    }

    // 게임을 재시작할지 말지 묻는 메서드
    public boolean canRepeatGame() {
        ps.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = scanner.nextLine();
        if (input.equals("1")) {
            return true;
        } else if (input.equals("2")) {
            return false;
        }
        ps.println("1 또는 2를 입력해주세요");
        return canRepeatGame();
    }
}
