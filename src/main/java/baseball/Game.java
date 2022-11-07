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

    public Result guess() {
        String guessedNumber = player.getNumber();
        player.isValidNumber(guessedNumber);
        return computer.judgeNumber(guessedNumber);
    }

    public void start() {
        computer = new Computer();
        boolean finish = false;
        while (!finish) {
            Result resultOfGuess = guess();
            System.out.println(resultOfGuess.toString());
            finish = resultOfGuess.checkFinish();
        }
        finishMessage();
    }
}
