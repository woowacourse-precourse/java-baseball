package baseball;

public class Game {
    private Player player;
    private Computer computer;

    public Game(Player player) {
        this.player = player;
    }

    public void finishMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public boolean tryCycle() {
        String playerNumber = player.getNumber();
        player.isValidNumber(playerNumber);
        Result result = computer.judgeNumber(playerNumber);
        System.out.println(result.toString());
        return result.checkFinish();
    }

    public void start() {
        computer = new Computer();
        boolean finish = false;
        while (!finish) {
            finish = tryCycle();
        }
        finishMessage();
    }
}
