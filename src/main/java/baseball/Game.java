package baseball;

public class Game {
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

    public boolean tryCycle(Player player, Computer computer) {
        String playerNumber = player.getNumber();
        if (!player.isValidNumber(playerNumber)) {
            Player.isNotValid();
        }
        Result result = computer.judgeNumber(playerNumber);
        System.out.println(result.toString());
        return result.checkFinish();
    }

    public void start(Player player) {
        Computer computer = new Computer();
        boolean finish = false;
        while (!finish) {
            finish = tryCycle(player, computer);
        }
        finishMessage();
    }

    public void restartLoop() {
        Player player = new Player();
        startMessage();
        boolean restart = true;
        while (restart) {
            start(player);
            String playerRestart = player.getRestart();
            if (!player.isValidRestart(playerRestart)) {
                Player.isNotValid();
            }
            restart = checkRestart(playerRestart);
        }
    }
}
