package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseballGame {
    private final User user;
    private final Computer computer;
    private final NumberComparator numberComparator;
    private final ErrorChecker errorChecker;
    private final int START_INCLUSIVE = 1;
    private final int END_INCLUSIVE = 9;
    private final int RESTART_GAME = 1;
    private final int EXIT_GAME = 2;
    private final String START_GAME = "숫자 야구 게임을 시작합니다.";
    private final String WIN_GAME;
    private final String WIN_GAME_TEXT = "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String GAME_CONTINUE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final String FINISH_GAME = "게임을 종료합니다.";
    private final String INPUT_NUMBER = "숫자를 입력해주세요 : ";

    public BaseballGame(int numberSize) {
        computer = new Computer(numberSize, START_INCLUSIVE, END_INCLUSIVE);
        user = new User();
        numberComparator = new NumberComparator(numberSize);

        List<Integer> continueGameInputList = List.of(RESTART_GAME, EXIT_GAME);
        errorChecker = new ErrorChecker(numberSize, START_INCLUSIVE, END_INCLUSIVE, continueGameInputList);

        WIN_GAME = numberSize + WIN_GAME_TEXT;
    }

    private void startGame() {
        System.out.println(START_GAME);
        computer.makeNewNumbers();
    }

    public void playGame() {
        boolean isPlaying = true;
        boolean isUserWin = false;

        while (isPlaying) {
            startGame();
            do {
                inputUserNumber();
                isUserWin = numberComparator.isUserWin(user, computer);
            } while (!isUserWin);
            System.out.println(WIN_GAME);
            isPlaying = continueGame();
        }
    }

    private void inputUserNumber() throws IllegalArgumentException {
        System.out.print(INPUT_NUMBER);
        String input = Console.readLine();

        errorChecker.checkUserNumberError(input);
        user.makeNewNumbers(input);
    }

    private boolean continueGame() throws IllegalArgumentException {
        System.out.println(GAME_CONTINUE);

        String input = Console.readLine();
        errorChecker.checkContinueGameError(input);

        int inputCode = Integer.parseInt(input);
        if (inputCode == RESTART_GAME) {
            return true;
        }
        if (inputCode == EXIT_GAME) {
            System.out.println(FINISH_GAME);
            return false;
        }
        return false;
    }
}
