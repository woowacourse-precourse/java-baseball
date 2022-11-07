package baseball;

import java.util.Scanner;

public class ExecuteGame {

    // 입력한 값을 String 형태로 반환
    private String saveInput () {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        return input;
    }

    // 게임을 재시작할지 말지 묻는 메서드
    private boolean canRepeatGame () {
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = saveInput();

            if (input.equals("1")) {
                return true;
            } else if (input.equals("2")) {
                return false;
            } else {
                System.out.println("1 또는 2를 입력하세요.");
            }
        }
    }


}
