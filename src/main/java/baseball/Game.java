package baseball;

public class Game {
    Computer computer;
    User user;

    public void runGame() {
        boolean stop = false;
        while (!stop) {
            startGame();
            playGame();
            stop = playAgain();
        }
    }

    public void startGame() {
        computer = new Computer();
        user = new User();
        computer.startMsg();
    }

    public void playGame() {
        boolean win = false;
        while (true) {
            computer.inputMsg();
            user.inputNum();
            win = computer.gameLogic(computer.getRandomNumList(), user.getUserNumList());
            if (win) {
                break;
            }
        }
    }

    public boolean playAgain() {
        int again;
        computer.printReplay();
        again = user.inputPlayAgain();
        if (again == 1) {
            return false;
        } else {
            return true;
        }
    }
}
