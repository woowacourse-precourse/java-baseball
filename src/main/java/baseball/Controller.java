package baseball;

public class Controller {
    public Controller() {
    }

    public void start() {
        Computer computer = new Computer();
        Game game = new Game(computer);
        int state = 1;
        while(state != 2) {
            game.init();
            game.start();
            printRestartMessage();
        }
    }

    public void printRestartMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
