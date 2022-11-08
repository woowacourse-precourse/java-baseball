package baseball;

public class Game {
    public static final int OVER_CONDITION = 3;
    private final Computer computer = new Computer();
    private final Player player = new Player();
    private final Referee referee = new Referee();

    public void play() {
        computer.setIntegerList(computer.generateIntegerList());
        referee.setComputerList(computer.getIntegerList());

        do {
            player.setIntegerList(player.getIntegerListAsInput());
            referee.setPlayerList(player.getIntegerList());
            referee.updateHint();
            referee.printHint();
        } while (!isOver());

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private boolean isOver() {
        if (referee.getStrikes() == OVER_CONDITION) {
            return true;
        }
        return false;
    }
}
