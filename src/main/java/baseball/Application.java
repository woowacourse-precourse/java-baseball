package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public Computer computer;
    public User user;
    public boolean isGameFinished;

    public Application(Computer computer, User user) {
        this.computer = computer;
        this.user = user;
        this.isGameFinished = false;
    }

    public static void main(String[] args) {
        Computer computer = new Computer();
        User user = new User();
        Application application = new Application(computer, user);
        application.printStartGame();
        application.computer.pickRandomNumber();
        while (!application.isGameFinished) {
            application.user.getUserGuessInput();
            application.computer.calculateStrikeBall(application.user.getUserInputList());
            application.computer.giveHintToUser();
            application.printEndGame();
        }
    }

    private void printStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void printEndGame() {
        if (computer.isThreeStrike()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하시려면 1, 종료하시려면 2를 입력하세요.");
            checkGameFinished();
        }
    }

    private void checkGameFinished() {
        if (!user.getUserReplayInput()) {
            isGameFinished = true;
            return;
        }
        computer.pickRandomNumber();
        printStartGame();
    }
}
