package baseball;

import java.util.List;

public class Game {

    static final int GAME_OVER_STRIKE_COUNT = 3;
    private List<Integer> computerNumbers;
    private List<Integer> userNumbers;
    boolean isGameOver = false;

    public static void startGame() {
        Game game = new Game();
        game.setComputerNumbers();
        while (!game.isGameOver) {
            game.setUserNumbers();
            game.getGameScore();
        }
    }

    private void setComputerNumbers() {
        Computer computer = new Computer();
        List<Integer> computerNumbers = computer.getNumberList();
        this.computerNumbers = computerNumbers;
    }

    private void setUserNumbers() {
        User user = new User();
        user.setUserInput();
        List<Integer> userNumbers = user.getValidatedInput();
        this.userNumbers = userNumbers;
    }

    private void getGameScore() {
        Judge.getGameScore(userNumbers, computerNumbers);
        if (Judge.countStrike(userNumbers, computerNumbers) == GAME_OVER_STRIKE_COUNT) {
            isGameOver = true;
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    public static int ResetGameOrQuit() {
        User user = new User();
        user.setQuitOrNotInput();
        int quitOrNot = user.getValidatedQuitOrNotInput();
        return quitOrNot;
    }
}
