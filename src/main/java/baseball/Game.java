package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    public void play_game() {
        boolean gameEnd = false;
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (!gameEnd) {
            baseball();
            gameEnd = new_game();
        }

    }

    public void baseball() {
        Computer computer = new Computer();
        boolean gameWin = false;
        gameResult gameResult = new gameResult();

        while (!gameWin) {
            User user = new User();
            gameWin = gameResult.get_result(computer, user);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public boolean new_game() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restart = Console.readLine();
        validate_restart(restart);

        if (restart.equals("1")) return false;
        return true;
    }

    public void validate_restart(String input) {
        if (input.equals("1")) return;
        if (input.equals("2")) return;
        throw new IllegalArgumentException("1 아니면 2 입력 바람");
    }

    
}
