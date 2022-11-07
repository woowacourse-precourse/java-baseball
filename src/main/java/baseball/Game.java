package baseball;

public class Game {
    private Player player;
    private Computer computer;
    public void startMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void finishMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public boolean checkRestart(String playerRestart) {
        char letter = playerRestart.charAt(0);
        return letter == '1';
    }

    public boolean tryCycle() {
        String playerNumber = player.getNumber();
        if (!player.isValidNumber(playerNumber)) {
            Player.isNotValid();
        }
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

    public void restartLoop() {
        player = new Player();
        startMessage();
        boolean restart = true;
        while (restart) {
            start();
            String playerRestart = player.getRestart();
            if (!player.isValidRestart(playerRestart)) {
                Player.isNotValid();
            }
            restart = checkRestart(playerRestart);
        }
    }
}
