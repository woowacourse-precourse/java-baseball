package baseball;

import java.io.*;
import java.util.Map;
import java.util.Scanner;

public class ExecuteGame extends IllegalArgumentException {
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

    // 게임 중 값을 입력 받아 출력하는 함수
    // 잘못된 값을 입력했을 경우 에러 메시지 출력 후 `IllegalArgumentException`을 발생
    public String getUserValidInput() {
        try {
            ps.println("숫자를 입력해주세요: ");
            String userValidInput = scanner.nextLine();
            if (!InputValidator.isValidInput(userValidInput)) {
                ps.println("잘못된 값을 입력했습니다!\n0을 제외한 서로 다른 3개의 숫자를 연속하여 입력해주세요.\n프로그램을 재시작해주세요.");
                throw new IllegalArgumentException();
            }
            return userValidInput;
        } catch (IllegalArgumentException e) {
            System.exit(0);
            throw e;
        }
    }

    public void play() {
        String computer = RandomNumberMaker.computer();
        BaseBallGame baseBallGame = new BaseBallGame(computer);
        do {
            String userInput = getUserValidInput();
            baseBallGame.playBaseBall(userInput);
            Map<String, Integer> result = baseBallGame.calculateScores(userInput);
            boolean isCorrect = baseBallGame.isRightAnswer(result);
            if (isCorrect) {
                break;
            }
        } while (true);
    }

}
