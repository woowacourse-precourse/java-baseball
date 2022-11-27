package baseball.domain;

public class Referee {

    private final Computer computer;

    public Referee(Computer computer) {
        this.computer = computer;
    }

    public boolean gameStart(Player player) {
        return computer.compareTo(player);
    }
}
